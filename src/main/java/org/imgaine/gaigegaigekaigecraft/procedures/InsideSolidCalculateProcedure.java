package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;

public class InsideSolidCalculateProcedure {
   public InsideSolidCalculateProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, double height, double width) {
      AABB testAABB = new AABB(x - width * 0.5, y, z - width * 0.5, x + width * 0.5, y + height, z + width * 0.5);
      return !world.noCollision((Entity)null, testAABB);
   }
}
