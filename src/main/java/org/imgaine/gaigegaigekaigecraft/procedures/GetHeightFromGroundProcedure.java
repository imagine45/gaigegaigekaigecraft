package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetHeightFromGroundProcedure {
   public GetHeightFromGroundProcedure() {
   }

   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         x_pos = entity.m_20185_();
         y_pos = entity.m_20186_();
         z_pos = entity.m_20189_();
         dis = 0.0;

         for(int index0 = 0; index0 < 255 && world.m_46859_(BlockPos.m_274561_(x_pos, y_pos - dis, z_pos)); ++index0) {
            ++dis;
         }

         return dis;
      }
   }
}
