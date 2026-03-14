package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class OBackstepProcedure {
   public OBackstepProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         double PASSIVE_POWERFIX = 0.0;
         String STR1 = "";
         PASSIVE_POWERFIX = 5.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
               int var10001;
               label27: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                        var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).m_19564_();
                        break label27;
                     }
                  }

                  var10001 = 0;
               }

               PASSIVE_POWERFIX = (double)Math.round((float)(5 - (var10001 + 1)));
            }
         }

         STR1 = "§l§b";

         for(int index0 = 0; index0 < (int)PASSIVE_POWERFIX; ++index0) {
            STR1 = STR1 + "■";
         }

         return STR1;
      }
   }
}
