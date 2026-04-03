package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletKitchenKnifeProjectileHitsLivingEntityProcedure {
   public BulletKitchenKnifeProjectileHitsLivingEntityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         Effect1Procedure.execute(world, immediatesourceentity, entity);
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
