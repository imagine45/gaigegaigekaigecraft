package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueHigurumaProcedure {
   public CursedTechniqueHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         boolean have_gavel = false;
         ItemStack item_mainHand = ItemStack.EMPTY;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 2700.0);
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         item_mainHand = var10000.copy();
         have_gavel = item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get() || item_mainHand.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || item_mainHand.getItem() == JujutsucraftModItems.GAVEL_BIG.get();
         if (skill == 5.0) {
            GetGavelProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (skill != 6.0 && skill != 7.0) {
            if (skill != 8.0 && skill != 9.0) {
               if (skill != 10.0 && skill != 11.0) {
                  if (skill == 19.0) {
                     SkillJudgementProcedure.execute(world, x, y, z, entity);
                  } else if (skill == 20.0) {
                     DeadlySentencingProcedure.execute(world, x, y, z, entity);
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                  }
               } else {
                  if (!have_gavel) {
                     GetGavelProcedure.execute(world, x, y, z, entity);
                  }

                  for(int index2 = 0; index2 < 5; ++index2) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     item_mainHand = var10000.copy();
                     if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL_BIG.get()) {
                        break;
                     }

                     GavelRightClicked2Procedure.execute(world, x, y, z, entity);
                  }

                  if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL_BIG.get()) {
                     if (skill == 10.0) {
                        AttackStrongMahitoProcedure.execute(world, x, y, z, entity);
                     } else {
                        AttackOverheadHigurumaProcedure.execute(world, x, y, z, entity);
                     }
                  } else {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            } else {
               if (!have_gavel) {
                  GetGavelProcedure.execute(world, x, y, z, entity);
               }

               for(int index1 = 0; index1 < 5; ++index1) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  item_mainHand = var10000.copy();
                  if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }

               if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  var10000.getOrCreateTag().putDouble("Reach", 0.75 + entity.getPersistentData().getDouble("cnt1") * 0.2);
                  if (skill == 8.0) {
                     AttackContinueHigurumaProcedure.execute(world, entity);
                  } else {
                     AttackContinueHigurumaProcedure.execute(world, entity);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  SetAttributeMainhandProcedure.execute(var10000);
               } else {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         } else if (skill == 6.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
               if (!have_gavel) {
                  GetGavelProcedure.execute(world, x, y, z, entity);
               }

               for(int index0 = 0; index0 < 5; ++index0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  item_mainHand = var10000.copy();
                  if (item_mainHand.getItem() == JujutsucraftModItems.GAVEL.get()) {
                     break;
                  }

                  GavelRightClicked2Procedure.execute(world, x, y, z, entity);
               }
            }

            GavelThrowingProcedure.execute(world, entity);
         }

      }
   }
}
