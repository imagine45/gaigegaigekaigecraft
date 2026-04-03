package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;

public class CursedBlockOnBlockRightClickedProcedure {
   public CursedBlockOnBlockRightClickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (InlineMethodHandler.checkGamemodeCreative(entity)) {
            if (!world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("run_type", InlineMethodHandler.getValue(world, BlockPos.containing(x, y, z), "run_type") + 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (InlineMethodHandler.getValue(world, BlockPos.containing(x, y, z), "run_type") > 30.0 && !world.isClientSide()) {
               BlockPos _bp = BlockPos.containing(x, y, z);
               BlockEntity _blockEntity = world.getBlockEntity(_bp);
               BlockState _bs = world.getBlockState(_bp);
               if (_blockEntity != null) {
                  _blockEntity.getPersistentData().putDouble("run_type", 0.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  _level.sendBlockUpdated(_bp, _bs, _bs, 3);
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  double var10001 = InlineMethodHandler.getValue(world, BlockPos.containing(x, y, z), "run_type");
                  _player.displayClientMessage(Component.literal("" + var10001), false);
               }
            }
         }

      }
   }
}
