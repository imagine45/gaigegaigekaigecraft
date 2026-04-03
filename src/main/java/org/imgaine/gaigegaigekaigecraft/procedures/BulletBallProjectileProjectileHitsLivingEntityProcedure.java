package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletBallProjectileProjectileHitsLivingEntityProcedure {
   public BulletBallProjectileProjectileHitsLivingEntityProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
      if (sourceentity != null) {
         BulletBallProjectileProjectileHitsBlockProcedure.execute(world, x, y, z, sourceentity);
      }
   }
}
