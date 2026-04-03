package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class EffectCursedSpeechExplodeProcedure {
   public EffectCursedSpeechExplodeProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range = 0.0;
         EffectCursedSpeech1Procedure.execute(entity, entityiterator);
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         range = ReturnEntitySizeProcedure.execute(entityiterator);
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(20.0 * range), 1.0 * range, 1.0 * range, 1.0 * range, 0.25);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(20.0 * range), 0.25 * range, 0.25 * range, 0.25 * range, 0.5);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.LARGE_SMOKE, x_pos, y_pos, z_pos, (int)(20.0 * range), 0.25 * range, 0.25 * range, 0.25 * range, 0.5);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, (int)(4.0 * range), 0.25 * range, 0.25 * range, 0.25 * range, 0.5);
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.explode((Entity)null, x_pos, y_pos, z_pos, 2.0F, ExplosionInteraction.NONE);
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 5, false, false));
            }
         }

         entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
         if (!(entityiterator instanceof Player) && !entityiterator.isAlive() && !entityiterator.level().isClientSide()) {
            entityiterator.discard();
         }

      }
   }
}
