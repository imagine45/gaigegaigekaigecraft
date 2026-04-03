package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class FallingBlossomEmotionOnEffectActiveTickProcedure {
   public FallingBlossomEmotionOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player && entity.tickCount % 10 == 0) {
            label63: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                     break label63;
                  }
               }

               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> capability.PlayerCursePowerChange -= 10.0);
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 3, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 3, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 3, 0, false, false));
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(4.0 * ReturnEntitySizeProcedure.execute(entity)), (double)entity.getBbWidth() * 0.35, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.35, 0.0);
         }

         label52: {
            if (ActiveTickConditionProcedure.execute(entity)) {
               if (!(entity instanceof LivingEntity)) {
                  break label52;
               }

               LivingEntity _livEnt13 = (LivingEntity)entity;
               if (!_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label52;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
         }

      }
   }
}
