package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.RedEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class AIRedProcedure {
   public AIRedProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         double power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         AIBlueRedProcedure.execute(world, entity);
         if (entity instanceof RedEntity) {
            RedEntity _datEntL0 = (RedEntity)entity;
            if ((Boolean)_datEntL0.getEntityData().get(RedEntity.DATA_flag_start)) {
               CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.75F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.5F, 0.5F, false);
                     }
                  }

                  entity.getPersistentData().putDouble("x_pos", entity.getX());
                  entity.getPersistentData().putDouble("y_pos", entity.getY());
                  entity.getPersistentData().putDouble("z_pos", entity.getZ());
               }

               for(int index0 = 0; index0 < 8; ++index0) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power") * 0.25);
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power") * 0.25);
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power") * 0.25);
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 40.0);
                  entity.getPersistentData().putDouble("Damage", Math.max(entity.getPersistentData().getDouble("Damage") * Math.pow(0.99, entity.getPersistentData().getDouble("cnt_life")), 28.0));
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * CNT6);
                  entity.getPersistentData().putDouble("Range", 10.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 2.0 * CNT6);
                  entity.getPersistentData().putDouble("effect", 0.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockRange", 6.0 * CNT6);
                  entity.getPersistentData().putDouble("BlockDamage", 10.0 * CNT6);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putBoolean("noEffect", true);
               }

               entity.getPersistentData().putBoolean("noEffect", false);
               entity.getPersistentData().putDouble("BlockRange", 12.0);
               entity.getPersistentData().putDouble("BlockDamage", 0.33);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
               if (entity.getPersistentData().getDouble("cnt1") == 3.0) {
                  entity.getPersistentData().putDouble("BlockRange", 24.0 * CNT6);
                  entity.getPersistentData().putDouble("BlockDamage", 0.33);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               range = ReturnEntitySizeProcedure.execute(entity);
               ParticleGeneratorProcedure.execute(world, range * 0.1, 40.0 * range, 30.0, 8.0, entity.getX(), entity.getX() + entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getY() + entity.getPersistentData().getDouble("y_power"), entity.getZ(), entity.getZ() + entity.getPersistentData().getDouble("z_power"), "minecraft:cloud");
               if (entity.getPersistentData().getDouble("cnt1") < 6.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLASH, entity.getX(), entity.getY(), entity.getZ(), (int)(30.0 * CNT6), 4.0, 4.0, 4.0, 1.0);
                  }

                  entity.getPersistentData().putDouble("Damage", 40.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 16.0 * CNT6);
                  entity.getPersistentData().putDouble("knockback", 4.0 * CNT6);
                  entity.getPersistentData().putDouble("effect", 0.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.65);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() - 1.5, entity.getZ(), entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") > 8.0 * CNT6 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         }

      }
   }
}
