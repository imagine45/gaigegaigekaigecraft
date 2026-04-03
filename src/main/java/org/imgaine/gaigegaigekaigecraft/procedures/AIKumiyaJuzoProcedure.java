package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.AwasakaJiroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KumiyaJuzoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.NegiToshihisaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SudaManamiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIKumiyaJuzoProcedure {
   public AIKumiyaJuzoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double level_st = 0.0;
         double level_df = 0.0;
         if (entity.isAlive()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (!(entity instanceof KumiyaJuzoEntity) && !(entity instanceof AwasakaJiroEntity)) {
               if (entity instanceof SudaManamiEntity) {
                  level_st = 5.0;
                  level_df = 1.0;
               } else if (entity instanceof NegiToshihisaEntity) {
                  level_st = 4.0;
                  level_df = 1.0;
               } else {
                  level_st = 2.0;
                  level_df = 1.0;
               }
            } else {
               level_st = 8.0;
               level_df = 2.0;
            }

            label82: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label82;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)level_st, false, false));
                  }
               }
            }

            label77: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label77;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)level_df, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  CalculateAttackProcedure.execute(world, entity);
                  if (entity instanceof AwasakaJiroEntity) {
                     ItemStack var27;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var27 = _livEnt.getMainHandItem();
                     } else {
                        var27 = ItemStack.EMPTY;
                     }

                     if (var27.getItem() == ItemStack.EMPTY.getItem() && !entity.getPersistentData().getBoolean("flag1")) {
                        float var28;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var28 = _livEnt.getHealth();
                        } else {
                           var28 = -1.0F;
                        }

                        double var29 = (double)var28;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var29 < (double)var10001 * 0.75) {
                           entity.getPersistentData().putBoolean("flag1", true);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.KNIFE.get())).copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
