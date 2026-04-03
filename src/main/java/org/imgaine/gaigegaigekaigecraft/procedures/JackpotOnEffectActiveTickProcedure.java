package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class JackpotOnEffectActiveTickProcedure {
   public JackpotOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            double var10000;
            label73: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getAmplifier();
                     break label73;
                  }
               }

               var10000 = 0.0;
            }

            label68: {
               level = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()).getDuration();
                     break label68;
                  }
               }

               var10000 = 0.0;
            }

            entity.getPersistentData().putBoolean("PRESS_M", false);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2, (int)(5.0 + level), false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 2, false, false));
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ(), 2, (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.5);
            }

            if (Math.random() < 0.2 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.NOTE, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.75, entity.getZ(), 1, (double)(entity.getBbWidth() * 2.0F), (double)(entity.getBbHeight() * 1.0F), (double)(entity.getBbWidth() * 2.0F), 0.5);
            }

            if (entity.isSprinting() && entity.onGround() && !entity.isShiftKeyDown()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt25 = (LivingEntity)entity;
                  if (_livEnt25.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                     return;
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, entity.getX(), entity.getY(), entity.getZ(), 1, (double)entity.getBbWidth() * 0.1, (double)(entity.getBbHeight() * 0.0F), (double)entity.getBbWidth() * 0.1, 0.5);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), 1, (double)entity.getBbWidth() * 0.1, (double)(entity.getBbHeight() * 0.0F), (double)entity.getBbWidth() * 0.1, 0.25);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }
         }

      }
   }
}
