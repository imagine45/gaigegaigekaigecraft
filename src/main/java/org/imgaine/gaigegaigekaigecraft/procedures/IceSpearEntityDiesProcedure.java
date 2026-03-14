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
         world.m_46796_(2001, BlockPos.m_274561_(x, y + (double)entity.m_20206_() * 0.5, z), Block.m_49956_(Blocks.f_50126_.m_49966_()));
         if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
