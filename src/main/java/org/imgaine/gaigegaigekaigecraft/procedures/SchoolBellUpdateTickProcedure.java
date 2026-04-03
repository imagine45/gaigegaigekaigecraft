package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;

public class SchoolBellUpdateTickProcedure {
   public SchoolBellUpdateTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (world instanceof Level _lvl0) {
         if (_lvl0.isDay()) {
            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putBoolean("flag_day", true);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
                  return;
               }
            }

            return;
         }
      }

      if (InlineMethodHandler.getValueFalse(world, BlockPos.containing(x, y, z), "flag_day")) {
         if (!world.isClientSide()) {
            BlockPos _bp = BlockPos.containing(x, y, z);
            BlockEntity _blockEntity = world.getBlockEntity(_bp);
            BlockState _bs = world.getBlockState(_bp);
            if (_blockEntity != null) {
               _blockEntity.getPersistentData().putBoolean("flag_day", false);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.sendBlockUpdated(_bp, _bs, _bs, 3);
            }
         }

         if (world instanceof Level) {
            Level _level = (Level)world;
            if (!_level.isClientSide()) {
               _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:school_bell")), SoundSource.NEUTRAL, 3.0F, 1.0F);
            } else {
               _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:school_bell")), SoundSource.NEUTRAL, 3.0F, 1.0F, false);
            }
         }
      }

   }
}
