package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ODoubleJumpProcedure {
   public ODoubleJumpProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         double PASSIVE_POWERFIX = 0.0;
         String STR1 = "";
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
               int var10000;
               label25: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get()).getAmplifier();
                        break label25;
                     }
                  }

                  var10000 = 0;
               }

               PASSIVE_POWERFIX = (double)Math.round((float)(var10000 + 1));
               STR1 = "§l§3";

               for(int index0 = 0; index0 < (int)PASSIVE_POWERFIX; ++index0) {
                  STR1 = STR1 + "■";
               }
            }
         }

         return STR1;
      }
   }
}
