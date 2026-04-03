package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PhysicalGiftedEffectOnEffectActiveTickProcedure {
   public PhysicalGiftedEffectOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double x_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         double width = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.isAlive()) {
               MobEffectInstance giftedEffect = livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get());
               int giftedAmp = giftedEffect != null ? giftedEffect.getAmplifier() : 0;
               if (livingEntity.tickCount % 10 == 0) {
                  if (!livingEntity.hasEffect(MobEffects.DIG_SPEED) && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:haste infinite 0 true");
                  }

                  if (giftedAmp >= 3) {
                     if (livingEntity.hasEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get())) {
                        livingEntity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEATH_PAINTING_BLOOD.get());
                     }

                     if (livingEntity.hasEffect(MobEffects.CONFUSION)) {
                        livingEntity.removeEffect(MobEffects.CONFUSION);
                     }

                     if (livingEntity.hasEffect(MobEffects.POISON)) {
                        livingEntity.removeEffect(MobEffects.POISON);
                     }

                     if (livingEntity.hasEffect(MobEffects.WITHER)) {
                        livingEntity.removeEffect(MobEffects.WITHER);
                     }

                     if (!livingEntity.hasEffect(MobEffects.NIGHT_VISION) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:night_vision infinite 0 true");
                     }

                     if (entity.onGround()) {
                        MobEffectInstance doubleJump = livingEntity.getEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get());
                        int currentAmp = doubleJump != null ? doubleJump.getAmplifier() : -1;
                        if (currentAmp < 4) {
                           livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, currentAmp + 1, false, false));
                        } else if (doubleJump.getDuration() < 20) {
                           livingEntity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get(), 999999, 4, false, false));
                        }
                     }
                  }
               }

               if (entity.isSprinting() && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ())).getBlock() == Blocks.WATER && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() + 1.0, entity.getZ())).getBlock() != Blocks.WATER) {
                  x_power = entity.getDeltaMovement().x();
                  z_power = entity.getDeltaMovement().z();
                  speed = 1.0;
                  width = (double)entity.getBbWidth() * 0.25;
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, (float)(width * 8.0), 2.0F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, (float)(width * 8.0), 2.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), entity.getX(), entity.getY(), entity.getZ(), (int)Math.round(width * 35.0), width, 0.0, width, speed);
                  }

                  entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 2.0, Math.max(entity.getDeltaMovement().y(), 0.025), entity.getLookAngle().z * 2.0));
               }

               return;
            }
         }

      }
   }
}
