package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletBloodBulletHitsBlock2Procedure {
   public BulletBloodBulletHitsBlock2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         BulletBloodBulletHitsBlockProcedure.execute(world, x, y, z, entity, immediatesourceentity);
      }
   }
}
