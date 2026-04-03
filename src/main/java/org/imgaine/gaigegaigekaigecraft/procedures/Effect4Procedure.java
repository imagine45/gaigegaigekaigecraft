package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.ArrayList;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class Effect4Procedure {
   public Effect4Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double size_width = 0.0;
         double size_height = 0.0;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         speed = 1.0 + entityiterator.getPersistentData().getDouble("cnt6") * 0.2;
         size_width = (double)entityiterator.getBbWidth() * 0.3;
         size_height = (double)entityiterator.getBbHeight() * 0.3;
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 1, false, false));
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.5F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.5F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.25F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.25F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.2F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
            }
         }

         if (entity.getPersistentData().getDouble("skill") == 106.0) {
            for(Entity _player : new ArrayList<Entity>(world.players())) {
               if (CanSeeSukunaSlashProcedure.execute(world, entity, _player) && !_player.level().isClientSide() && _player.getServer() != null) {
                  _player.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _player.position(), _player.getRotationVector(), _player.level() instanceof ServerLevel ? (ServerLevel)_player.level() : null, 4, _player.getName().getString(), _player.getDisplayName(), _player.level().getServer(), _player), "particle gaigegaigekaigecraft:particle_slash " + x_pos + " " + y_pos + " " + z_pos + " " + size_width + " " + size_height + " " + size_width + " 0 " + Math.round(4.0 * speed) + " normal");
               }
            }
         } else if (entity.getPersistentData().getDouble("skill") == 2108.0 && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_DISMANTLE_ITADORI.get(), x_pos, y_pos, z_pos, (int)(2.0 * speed), size_width, size_height, size_width, 0.0 * speed);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(2.0 * speed), size_width, size_height, size_width, 0.5);
         }

         Effect1Procedure.execute(world, entity, entityiterator);
      }
   }
}
