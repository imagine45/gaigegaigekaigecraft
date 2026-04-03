package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class LogicCooldownMagicOnlyProcedure {
   public LogicCooldownMagicOnlyProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         int var7;
         label53: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                  break label53;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label53;
               }
            }

            label44: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var7 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                     break label44;
                  }
               }

               var7 = 0;
            }

            if (var7 <= 0) {
               label60: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                        break label60;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt4 = (LivingEntity)entity;
                     if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                        break label60;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt5 = (LivingEntity)entity;
                     if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        break label60;
                     }
                  }

                  var7 = 0;
                  return var7 != 0;
               }
            }
         }

         var7 = 1;
         return var7 != 0;
      }
   }
}
