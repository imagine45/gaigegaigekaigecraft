package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class DomainHoleOnTickUpdateProcedure {
   public DomainHoleOnTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      if (!world.isClientSide()) {
         BlockPos currentPos = BlockPos.containing(x, y, z);
         BlockEntity be = world.getBlockEntity(currentPos);
         if (be != null) {
            double delayTime = be.getPersistentData().getDouble("delay_time") + 1.0;
            be.getPersistentData().putDouble("delay_time", delayTime);
            BlockState bs = world.getBlockState(currentPos);
            if (world instanceof Level) {
               Level _level = (Level)world;
               _level.sendBlockUpdated(currentPos, bs, bs, 3);
            }

            if (delayTime > 5.0) {
               boolean isSurrounded = false;
               if (world.getBlockState(currentPos.east()).canOcclude() && world.getBlockState(currentPos.east()).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  isSurrounded = true;
               } else if (world.getBlockState(currentPos.west()).canOcclude() && world.getBlockState(currentPos.west()).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  isSurrounded = true;
               } else if (world.getBlockState(currentPos.south()).canOcclude() && world.getBlockState(currentPos.south()).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  isSurrounded = true;
               } else if (world.getBlockState(currentPos.north()).canOcclude() && world.getBlockState(currentPos.north()).is(BlockTags.create(new ResourceLocation("gaigegaigekaigecraft:barrier")))) {
                  isSurrounded = true;
               }

               if (isSurrounded) {
                  String oldBlock = be.getPersistentData().getString("old_block");
                  String oldBarrier = be.getPersistentData().getString("old_barrier");
                  placeBlockSafe(world, currentPos, oldBarrier);
                  BlockEntity newBe = world.getBlockEntity(currentPos);
                  if (newBe != null) {
                     newBe.getPersistentData().putString("old_block", oldBlock);
                     BlockState newBs = world.getBlockState(currentPos);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        _level.sendBlockUpdated(currentPos, newBs, newBs, 3);
                     }
                  }
               }
            }

         }
      }
   }

   private static void placeBlockSafe(LevelAccessor world, BlockPos pos, String blockName) {
      if (!world.isClientSide() && blockName != null && !blockName.isEmpty()) {
         if (blockName.contains("[")) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               Commands var10000 = _level.getServer().getCommands();
               CommandSourceStack var10001 = (new CommandSourceStack(CommandSource.NULL, new Vec3((double)pos.getX(), (double)pos.getY(), (double)pos.getZ()), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput();
               int var10002 = pos.getX();
               var10000.performPrefixedCommand(var10001, "setblock " + var10002 + " " + pos.getY() + " " + pos.getZ() + " " + blockName + " replace");
            }
         } else {
            ResourceLocation res = new ResourceLocation(blockName.contains(":") ? blockName : "minecraft:" + blockName);
            world.setBlock(pos, ((Block)ForgeRegistries.BLOCKS.getValue(res)).defaultBlockState(), 3);
         }
      }

   }
}
