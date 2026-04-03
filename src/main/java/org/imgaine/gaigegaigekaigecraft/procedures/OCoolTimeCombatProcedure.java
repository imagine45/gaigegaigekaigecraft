package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OCoolTimeCombatProcedure {
   public OCoolTimeCombatProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         int var10000;
         label20: {
            String STR1 = "";
            double NUM1 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                  break label20;
               }
            }

            var10000 = 0;
         }

         double var6 = Math.ceil((double)var10000 * 0.1);
         String var5 = var6 > 0.0 ? "" + Math.round(var6) : "";
         return var5;
      }
   }
}
