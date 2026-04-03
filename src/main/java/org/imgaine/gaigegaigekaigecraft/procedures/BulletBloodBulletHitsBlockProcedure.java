package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletBloodBulletHitsBlockProcedure {
   public BulletBloodBulletHitsBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity immediatesourceentity, Entity sourceentity) {
      if (immediatesourceentity != null && sourceentity != null) {
         BulletBloodBulletHitsBlock2Procedure.execute(world, x, y, z, sourceentity, immediatesourceentity);
      }
   }
}
