package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIFootProcedure {
   public AIFootProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double move = 0.0;
         double amount = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         entity.fallDistance = 0.0F;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
            y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
            z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
            if (entity.getPersistentData().getDouble("cnt2") < 10.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }

               if (entity.getPersistentData().getBoolean("Stop") && !(entity.getPersistentData().getDouble("cnt2") > 0.0)) {
                  entity.getPersistentData().putBoolean("Stop", false);
               } else {
                  if (!InsideSolidCalculateProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ(), (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5)) {
                     entity.teleportTo(x, entity.getY() - 1.0, z);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(x, entity.getY() - 1.0, z, entity.getYRot(), entity.getXRot());
                     }
                  }

                  BulletDomainHit2Procedure.execute(world, entity);
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  if (!InsideSolidCalculateProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.25, entity.getZ(), (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5) && !(entity.getPersistentData().getDouble("cnt2") > 0.0)) {
                     entity.getPersistentData().putDouble("Damage", 17.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.25);
                     entity.getPersistentData().putDouble("y_knockback", entity.getDeltaMovement().y() * 1.25);
                     entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.25);
                     RangeAttackProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().putDouble("x_knockback", 0.0);
                     entity.getPersistentData().putDouble("y_knockback", 0.0);
                     entity.getPersistentData().putDouble("z_knockback", 0.0);
                     if (entity.getPersistentData().getDouble("cnt1") > 50.0 && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  } else {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x, entity.getY(), z, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.CLOUD, x, entity.getY(), z, (int)(10.0 * range), 2.0 * range, 1.0, 2.0 * range, 0.5);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x, entity.getY(), z, (int)(10.0 * range), 2.0 * range, 1.0, 2.0 * range, 0.5);
                     }

                     entity.getPersistentData().putDouble("Damage", 20.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     RangeAttackProcedure.execute(world, x, entity.getY(), z, entity);
                     entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6);
                     entity.getPersistentData().putDouble("BlockRange", 2.0 * range);
                     BlockDestroyAllDirectionProcedure.execute(world, x, y_pos, z, entity);
                     entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  }
               }
            } else {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt2") > 20.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
