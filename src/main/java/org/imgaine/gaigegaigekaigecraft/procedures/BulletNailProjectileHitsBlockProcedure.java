package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class BulletNailProjectileHitsBlockProcedure {
   public BulletNailProjectileHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      double d = 0.0;
      if (world.getBlockState(BlockPos.containing(x, y, z)).is(BlockTags.create(new ResourceLocation("minecraft:ores/iron")))) {
         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
            }
         }
      } else if (world instanceof Level) {
         Level _level = (Level)world;
         if (!_level.isClientSide()) {
            _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 0.5F, 1.5F);
         } else {
            _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:gavel")), SoundSource.NEUTRAL, 0.5F, 1.5F, false);
         }
      }

   }
}
