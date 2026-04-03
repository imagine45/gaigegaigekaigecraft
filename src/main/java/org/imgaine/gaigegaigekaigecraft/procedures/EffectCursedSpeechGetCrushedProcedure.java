package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCursedSpeechGetCrushedProcedure {
   public EffectCursedSpeechGetCrushedProcedure() {
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
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }

         for(int index0 = 0; index0 < (int)(36.0 * range); ++index0) {
            ParticleGeneratorCircleProcedure.execute(world, 1.0, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), 2.0 * range, 0.0, 2.0, x_pos, x_pos, y_pos, y_pos, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), z_pos, z_pos, "minecraft:enchanted_hit");
         }

         for(int index1 = 0; index1 < 3; ++index1) {
            Effect1Procedure.execute(world, entity, entityiterator);
            if (!entityiterator.isAlive()) {
               break;
            }
         }

         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 10, false, false));
            }
         }

         if (!entityiterator.isAlive()) {
            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
               entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale delay set pehkui:height 1 @s");
            }

            if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
               entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "scale set pehkui:height 0.01 @s");
            }
         }

      }
   }
}
