package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class InsideSolidProcedure {
   public InsideSolidProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.isInWall() ? true : InsideSolidCalculateProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), (double)entity.getBbHeight(), (double)entity.getBbWidth());
      }
   }
}
