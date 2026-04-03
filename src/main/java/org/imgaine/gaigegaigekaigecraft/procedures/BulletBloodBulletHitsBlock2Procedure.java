package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletBloodBulletHitsBlock2Procedure {
   public BulletBloodBulletHitsBlock2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double CNT6 = 0.0;
         double old_skill = 0.0;
         double range = 0.0;
         CNT6 = 1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1;
         range = 1.0 + ReturnEntitySizeProcedure.execute(immediatesourceentity);
         old_skill = entity.getPersistentData().getDouble("skill");
         entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
         if (immediatesourceentity.getPersistentData().getDouble("skill") != 2307.0) {
            entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6);
            entity.getPersistentData().putDouble("BlockRange", 1.0 * range);
            entity.getPersistentData().putBoolean("noParticle", true);
            BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         }

         entity.getPersistentData().putDouble("Damage", immediatesourceentity.getPersistentData().getDouble("Damage"));
         entity.getPersistentData().putDouble("knockback", 0.25 * CNT6);
         entity.getPersistentData().putDouble("Range", 4.0 * range);
         entity.getPersistentData().putBoolean("attack", false);
         if (immediatesourceentity.getPersistentData().getDouble("skill") == 1018.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_blood_red ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 0.25 * CNT6 + " " + Math.round(8.0 * CNT6 * range) + " force");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0), false);
               }
            }

            entity.getPersistentData().putDouble("effect", 11.0);
         } else if (immediatesourceentity.getPersistentData().getDouble("skill") == 2307.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:cockroach ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 0.25 * CNT6 + " " + Math.round(8.0 * CNT6 * range) + " force");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.spider.step")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0), false);
               }
            }

            entity.getPersistentData().putDouble("effect", 1.0);
         } else if (immediatesourceentity.getPersistentData().getDouble("skill") == 3912.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_liquid_metal ~ ~ ~ " + range * 0.1 + " " + range * 0.1 + " " + range * 0.1 + " " + 0.25 * CNT6 + " " + Math.round(8.0 * CNT6 * range) + " force");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0));
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), (float)Mth.nextDouble(RandomSource.create(), 0.8, 10.0), false);
               }
            }

            entity.getPersistentData().putDouble("effect", 0.0);
         } else {
            entity.getPersistentData().putDouble("effect", 0.0);
         }

         RangeAttackProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().putDouble("skill", old_skill);
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
