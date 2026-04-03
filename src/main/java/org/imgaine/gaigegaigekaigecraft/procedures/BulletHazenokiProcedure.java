package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BulletEyeEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletHazenokiProcedure {
   public BulletHazenokiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double power = 0.0;
         double repeat_num = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double old_cooldown = 0.0;
         double damage = 0.0;
         double num = 0.0;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + (double)(immediatesourceentity instanceof BulletEyeEntity ? 5 : 0));
            immediatesourceentity.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
            immediatesourceentity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().putDouble("old_x", x - immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("old_y", y - immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("old_z", z - immediatesourceentity.getDeltaMovement().z());
            immediatesourceentity.getPersistentData().putDouble("speed", Math.sqrt(immediatesourceentity.getDeltaMovement().x() * immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getDeltaMovement().y() * immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getDeltaMovement().z() * immediatesourceentity.getDeltaMovement().z()));
            immediatesourceentity.getPersistentData().putDouble("Damage", 15.0 * (1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1));
         }

         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 20.0) {
            BulletHazenokiHitProcedure.execute(world, x, y, z, entity, immediatesourceentity);
            if (!immediatesourceentity.level().isClientSide()) {
               immediatesourceentity.discard();
            }
         }

      }
   }
}
