package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletFlameBulletHitsBlockProcedure {
   public BulletFlameBulletHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double old_skill = 0.0;
         double CNT6 = 0.0;
         double range = 0.0;
         CNT6 = 1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1;
         range = 1.0 + ReturnEntitySizeProcedure.execute(immediatesourceentity);
         old_skill = entity.getPersistentData().getDouble("skill");
         entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
         entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
         entity.getPersistentData().putDouble("BlockRange", 2.0 * range);
         entity.getPersistentData().putDouble("effect", 3.0);
         entity.getPersistentData().putBoolean("noParticle", true);
         BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().putDouble("Damage", immediatesourceentity.getPersistentData().getDouble("Damage"));
         entity.getPersistentData().putDouble("knockback", 0.25 * CNT6);
         entity.getPersistentData().putDouble("Range", 4.0 * range);
         entity.getPersistentData().putDouble("effect", 10.0);
         entity.getPersistentData().putBoolean("attack", false);
         RangeAttackProcedure.execute(world, x, y, z, entity);
         entity.getPersistentData().putDouble("skill", old_skill);
         if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) && Math.random() < 0.1 && !world.getBlockState(BlockPos.containing(x, y, z)).canOcclude() && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            FallingBlockEntity.fall(_level, BlockPos.containing(x, y, z), Blocks.FIRE.defaultBlockState());
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.5 * CNT6), 1.0F, false);
            }
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:explosion ~ ~ ~ " + range * 2.0 + " " + range * 2.0 + " " + range * 2.0 + " " + 0.25 * CNT6 + " " + Math.round(2.0 * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:cloud ~ ~ ~ " + range * 1.0 + " " + range * 1.0 + " " + range * 1.0 + " " + 0.25 * CNT6 + " " + Math.round(4.0 * CNT6 * range) + " force");
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:flame ~ ~ ~ " + range * 1.0 + " " + range * 1.0 + " " + range * 1.0 + " " + 0.25 * CNT6 + " " + Math.round(8.0 * CNT6 * range) + " force");
         }

         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
