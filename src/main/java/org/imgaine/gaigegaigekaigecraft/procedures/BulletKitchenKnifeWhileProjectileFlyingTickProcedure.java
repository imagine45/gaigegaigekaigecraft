package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletKitchenKnifeWhileProjectileFlyingTickProcedure {
   public BulletKitchenKnifeWhileProjectileFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double repeat_num = 0.0;
         double damage = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double x_power = 0.0;
         double old_cooldown = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
            immediatesourceentity.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
            immediatesourceentity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            immediatesourceentity.getPersistentData().putDouble("old_x", x - immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("old_y", y - immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("old_z", z - immediatesourceentity.getDeltaMovement().z());
            immediatesourceentity.getPersistentData().putDouble("speed", Math.sqrt(immediatesourceentity.getDeltaMovement().x() * immediatesourceentity.getDeltaMovement().x() + immediatesourceentity.getDeltaMovement().y() * immediatesourceentity.getDeltaMovement().y() + immediatesourceentity.getDeltaMovement().z() * immediatesourceentity.getDeltaMovement().z()));
            immediatesourceentity.getPersistentData().putDouble("Damage", 13.0 * (1.0 + immediatesourceentity.getPersistentData().getDouble("cnt6") * 0.1));
         }

         x_pos = immediatesourceentity.getPersistentData().getDouble("old_x");
         y_pos = immediatesourceentity.getPersistentData().getDouble("old_y");
         z_pos = immediatesourceentity.getPersistentData().getDouble("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 0.1) {
            old_skill = entity.getPersistentData().getDouble("skill");
            old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
            entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
            repeat_num = (double)Math.round(Math.max(dis * 5.0, 1.0));
            damage = immediatesourceentity.getPersistentData().getDouble("Damage");

            for(int index0 = 0; index0 < (int)repeat_num; ++index0) {
               ++dis;
               if (dis > 0.0) {
                  dis = -5.0;
                  entity.getPersistentData().putDouble("Damage", damage);
                  entity.getPersistentData().putDouble("Range", 2.0);
                  entity.getPersistentData().putDouble("knockback", 0.25);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               x_pos += x_power * 0.2;
               y_pos += y_power * 0.2;
               z_pos += z_power * 0.2;
            }

            entity.getPersistentData().putDouble("skill", old_skill);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
         }

         immediatesourceentity.getPersistentData().putDouble("old_x", x);
         immediatesourceentity.getPersistentData().putDouble("old_y", y);
         immediatesourceentity.getPersistentData().putDouble("old_z", z);
         immediatesourceentity.getPersistentData().putDouble("Damage", Math.max(immediatesourceentity.getPersistentData().getDouble("Damage") * 0.99, 10.0));
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > (double)(immediatesourceentity.getPersistentData().getDouble("skill") == 4405.0 ? 30 : 200) && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
