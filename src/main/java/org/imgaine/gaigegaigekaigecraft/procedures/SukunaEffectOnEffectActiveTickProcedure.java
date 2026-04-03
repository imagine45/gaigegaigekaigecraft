package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class SukunaEffectOnEffectActiveTickProcedure {
   public SukunaEffectOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.isAlive()) {
               if (livingEntity.tickCount % 10 == 0 && entity.onGround()) {
                  MobEffectInstance doubleJump = livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                  int currentAmp = doubleJump != null ? doubleJump.getAmplifier() : -1;
                  if (currentAmp < 4) {
                     livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, currentAmp + 1, false, false));
                  } else if (doubleJump.getDuration() < 20) {
                     livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, 4, false, false));
                  }
               }

               return;
            }
         }

      }
   }
}
