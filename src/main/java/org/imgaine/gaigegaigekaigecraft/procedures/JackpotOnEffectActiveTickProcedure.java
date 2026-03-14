package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class JackpotOnEffectActiveTickProcedure {
   public JackpotOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean old_press_m = false;
         double level = 0.0;
         double tick = 0.0;
         double rnd = 0.0;
         double pitch = 0.0;
         if (entity.m_6084_()) {
            double var10000;
            label53: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19564_();
                     break label53;
                  }
               }

               var10000 = 0.0;
            }

            label48: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).m_19557_();
                     break label48;
                  }
               }

               var10000 = 0.0;
            }

            label43: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                     var20 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                     break label43;
                  }
               }

               var20 = 0;
            }

            if ((double)var20 < 4.0 + level) {
               JackpotEffectStartedappliedProcedure.execute(world, entity);
            }

            entity.getPersistentData().m_128379_("PRESS_M", false);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, (int)(5.0 + level), false, false));
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.25, entity.m_20189_(), 2, (double)entity.m_20205_() * 0.25, (double)entity.m_20206_() * 0.25, (double)entity.m_20205_() * 0.25, 0.5);
            }

            if (Math.random() < 0.2 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123758_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.75, entity.m_20189_(), 1, (double)(entity.m_20205_() * 2.0F), (double)(entity.m_20206_() * 1.0F), (double)(entity.m_20205_() * 2.0F), 0.5);
            }
         }

      }
   }
}
