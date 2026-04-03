package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class CursedTechniqueFushiguroProcedure {
   public CursedTechniqueFushiguroProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 604.0) {
            ReturnShadowProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player && entity.getPersistentData().getDouble("cnt10") == 0.0) {
               entity.getPersistentData().putDouble("cnt10", Math.max(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost, 1.0));
            }

            if (skill != 605.0 && skill != 606.0) {
               if (skill == 607.0) {
                  SummonDivineDogTotalityProcedure.execute(world, x, y, z, entity);
               } else if (skill == 608.0) {
                  SummonNueProcedure.execute(world, x, y, z, entity);
               } else if (skill == 609.0) {
                  SummonGreatSerpentProcedure.execute(world, x, y, z, entity);
               } else if (skill == 610.0) {
                  SummonToadProcedure.execute(world, x, y, z, entity);
               } else if (skill == 611.0) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.equals(Component.translatable("jujutsu.technique.choso3").getString())) {
                     entity.getPersistentData().putDouble("skill", 1007.0);
                  } else {
                     SummonMaxElephantProcedure.execute(world, x, y, z, entity);
                  }
               } else if (skill == 612.0) {
                  SummonRabbitEscapeProcedure.execute(world, x, y, z, entity);
               } else if (skill == 613.0) {
                  SummonRoundDeerProcedure.execute(world, x, y, z, entity);
               } else if (skill == 614.0) {
                  SummonPiercingOxProcedure.execute(world, x, y, z, entity);
               } else if (skill == 615.0) {
                  SummonTigerFuneralProcedure.execute(world, x, y, z, entity);
               } else if (skill == 617.0) {
                  SummonMergedBeastAgitoProcedure.execute(world, x, y, z, entity);
               } else if (skill == 618.0) {
                  if (entity.getPersistentData().getDouble("cnt9") == 0.0) {
                     if (entity instanceof Player) {
                        entity.getPersistentData().putDouble("cnt9", (double)(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName.equals(Component.translatable("item.gaigegaigekaigecraft.mahoraga_wheel_helmet").getString()) ? 2 : 1));
                     } else {
                        entity.getPersistentData().putDouble("cnt9", 1.0);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt9") == 1.0) {
                     SummonMahoragaProcedure.execute(world, x, y, z, entity);
                  } else {
                     ItemStack var10000;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     if (var10000.getItem() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                           } else {
                              var10000 = ItemStack.EMPTY;
                           }

                           ItemStack _setstack = var10000.copy();
                           _setstack.setCount(1);
                           ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                  }
               } else if (skill == 620.0) {
                  ChimeraShadowGardenProcedure.execute(world, x, y, z, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else {
               SummonDivineDogProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
