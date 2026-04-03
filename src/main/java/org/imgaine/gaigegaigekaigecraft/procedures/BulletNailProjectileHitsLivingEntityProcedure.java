package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class BulletNailProjectileHitsLivingEntityProcedure {
   public BulletNailProjectileHitsLivingEntityProcedure() {
   }

   public static void execute(Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         entity.getPersistentData().putDouble("Nail", entity.getPersistentData().getDouble("Nail") + 1.0);
         if (!immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
