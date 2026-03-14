package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class EffectKirinOnEffectActiveTickProcedure {
   public EffectKirinOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double NUM2 = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         if (entity.m_6084_()) {
            label29: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     break label29;
                  }
               }

               if (!(entity instanceof LivingEntity)) {
                  return;
               }

               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (!_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get());
            }
         }

      }
   }
}
