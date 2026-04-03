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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class EffectCursedSpeechCrumbleAwayProcedure {
   public EffectCursedSpeechCrumbleAwayProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos;
         double y_pos;
         double z_pos;
         int var10000;
         label92: {
            x_pos = 0.0;
            y_pos = 0.0;
            z_pos = 0.0;
            double theta = 0.0;
            double distance = 0.0;
            double range = 0.0;
            double strength = 0.0;
            EffectCursedSpeech1Procedure.execute(entity, entityiterator);
            x_pos = entityiterator.getX();
            y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
            z_pos = entityiterator.getZ();
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label92;
               }
            }

            var10000 = 0;
         }

         double var23 = (double)Math.min(var10000 + 1, 30) * 0.1;
         double var22 = (double)Math.round((double)(entityiterator.getBbHeight() + 1.0F) * Math.min(var23, 1.0));
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 10, false, false));
            }
         }

         int var10002;
         label86: {
            entityiterator.setDeltaMovement(new Vec3(0.0, -2.0, 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10002 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label86;
               }
            }

            var10002 = 0;
         }

         entityiterator.fallDistance = (float)(10 + var10002 * 2);

         for(int index0 = 0; index0 < (int)var22; ++index0) {
            y_pos -= (0.5 + (double)(entityiterator.getBbWidth() * 1.0F)) * var23;
            entity.getPersistentData().putDouble("BlockRange", Math.min((double)(1.0F + entityiterator.getBbWidth() * 2.0F) * var23, (double)(4.0F + entityiterator.getBbWidth())));
            entity.getPersistentData().putDouble("BlockDamage", 6.0);

            for(int index1 = 0; index1 < 4; ++index1) {
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var23, 0.5F);
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)var23, 0.5F, false);
               }
            }

            if (y_pos < entityiterator.getY() - var22) {
               break;
            }
         }

         for(int index2 = 0; index2 < (int)(36.0 * var22); ++index2) {
            ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, Mth.nextDouble(RandomSource.create(), 0.0, var22), 4.0, x_pos, x_pos, (double)(1.0F + entityiterator.getBbWidth() * 2.0F), y_pos - 1.0, Mth.nextDouble(RandomSource.create(), 0.0, 360.0), z_pos, z_pos, "minecraft:enchanted_hit");
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
