package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.IshigoriRyuEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class LogicStartProcedure {
   public LogicStartProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         double CT1 = 0.0;
         double CT2 = 0.0;
         double selectCT = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
               return false;
            }
         }

         if (entity instanceof Player) {
            JujutsucraftModVariables.PlayerVariables pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
            CT1 = pVars.PlayerCurseTechnique;
            CT2 = pVars.PlayerCurseTechnique2;
            selectCT = pVars.PlayerSelectCurseTechnique;
            if (CT1 == 0.0) {
               return false;
            }

            if (selectCT == 20.0) {
               boolean var25;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     var25 = true;
                     return !var25;
                  }
               }

               var25 = false;
               return !var25;
            }

            if (selectCT == 21.0) {
               return true;
            }

            if (pVars.PhysicalAttack) {
               if (selectCT % 100.0 >= 0.0 && selectCT % 100.0 <= 2.0) {
                  int var24;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        label105: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 var24 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                                 break label105;
                              }
                           }

                           var24 = 0;
                        }

                        if (var24 != 0) {
                           var24 = 0;
                           return var24 != 0;
                        }
                     }
                  }

                  var24 = 1;
                  return var24 != 0;
               }

               if ((CT1 == 27.0 || CT2 == 27.0) && selectCT == 19.0) {
                  return true;
               }

               boolean var22;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     var22 = true;
                     return !var22;
                  }
               }

               var22 = false;
               return !var22;
            }

            if (pVars.PassiveTechnique && LogicStartPassiveProcedure.execute(entity)) {
               return true;
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt6 = (LivingEntity)entity;
               if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                  return false;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt7 = (LivingEntity)entity;
               if (_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return false;
               }
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt8 = (LivingEntity)entity;
            if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
               return false;
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt9 = (LivingEntity)entity;
            if (_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
               if (entity instanceof Player) {
                  if (CT1 != 12.0) {
                     return false;
                  }
               } else if (!(entity instanceof IshigoriRyuEntity)) {
                  return false;
               }
            }
         }

         int var10000;
         label127: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                  break label127;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0) {
            ItemStack var21;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var21 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var21 = ItemStack.EMPTY;
            }

            if (var21.getItem() != JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
               return false;
            }
         }

         return true;
      }
   }
}
