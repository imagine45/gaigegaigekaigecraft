package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EmberInsectEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FoxFireEntity;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect7Procedure {
   public Effect7Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double amount = 0.0;
         double speed = 0.0;
         speed = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         amount = 0.1 * speed;
         if (entity instanceof FoxFireEntity) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y, z, 20, 0.1, 0.1, 0.1, 0.25 * speed);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.firecharge.use")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         } else {
            if (entity instanceof EmberInsectEntity) {
               amount = 1.0;
               entity.getPersistentData().putDouble("BlockDamage", 2.0);
               entity.getPersistentData().putDouble("BlockRange", 3.0);
               BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 25, 1.0, 1.0, 1.0, 0.25);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int)(20.0 * amount), 0.5, 0.5, 0.5, 0.25 * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y, z, (int)(20.0 * amount), 0.5, 0.5, 0.5, 0.25 * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.LAVA, x, y, z, (int)(30.0 * amount), 0.5, 0.5, 0.5, 0.25 * speed);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x, y, z, (int)(60.0 * amount), 0.5, 0.5, 0.5, 0.25 * speed);
            }
         }

      }
   }
}
