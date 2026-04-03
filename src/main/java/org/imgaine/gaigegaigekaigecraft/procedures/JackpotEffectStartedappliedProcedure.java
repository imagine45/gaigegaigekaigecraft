package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class JackpotEffectStartedappliedProcedure {
   public JackpotEffectStartedappliedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         label28: {
            double level = 0.0;
            double tick = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  double var9 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier();
                  break label28;
               }
            }

            double var10000 = 0.0;
         }

         label23: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                  double var11 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getDuration();
                  break label23;
               }
            }

            double var10 = 0.0;
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 40, (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.5);
         }

      }
   }
}
