package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OCoolTimeProcedure {
   public OCoolTimeProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         int var10000;
         label38: {
            String STR1 = "";
            double NUM1 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getDuration();
                        break label38;
                     }
                  }

                  var10000 = 0;
                  break label38;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                  break label38;
               }
            }

            var10000 = 0;
         }

         double var8 = Math.ceil((double)var10000 * 0.1);
         String var7 = var8 > 0.0 ? "" + Math.round(var8) : "";
         return var7;
      }
   }
}
