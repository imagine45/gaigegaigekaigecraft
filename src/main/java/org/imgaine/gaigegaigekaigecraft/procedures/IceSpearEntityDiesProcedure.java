package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class IceSpearEntityDiesProcedure {
   public IceSpearEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         world.levelEvent(2001, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), Block.getId(Blocks.ICE.defaultBlockState()));
         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
