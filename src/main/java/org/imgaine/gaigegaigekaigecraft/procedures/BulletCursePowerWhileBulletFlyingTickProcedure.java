package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class BulletCursePowerWhileBulletFlyingTickProcedure {
   public BulletCursePowerWhileBulletFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         double y_power = 0.0;
         double z_power = 0.0;
         double old_skill = 0.0;
         double num = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double range = 0.0;
         double old_cooldown = 0.0;
         BulletDomainHitProcedure.execute(world, entity, immediatesourceentity);
         immediatesourceentity.getPersistentData().putDouble("cnt_life", immediatesourceentity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") == 1.0) {
            immediatesourceentity.setNoGravity(true);
            immediatesourceentity.getPersistentData().putDouble("skill", entity.getPersistentData().getDouble("skill"));
            immediatesourceentity.getPersistentData().putDouble("COOLDOWN_TICKS", entity.getPersistentData().getDouble("COOLDOWN_TICKS"));
            if (entity.getPersistentData().getDouble("cnt7") > 0.0) {
               immediatesourceentity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("cnt7"));
               immediatesourceentity.getPersistentData().putDouble("cnt6", 1.0 + entity.getPersistentData().getDouble("cnt7") * 0.03);
            } else {
               immediatesourceentity.getPersistentData().putDouble("Damage", 13.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
               immediatesourceentity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
            }

            immediatesourceentity.getPersistentData().putDouble("bullet_power", entity.getPersistentData().getDouble("Damage"));
            immediatesourceentity.getPersistentData().putDouble("old_x", immediatesourceentity.getX() - immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("old_y", immediatesourceentity.getY() - immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("old_z", immediatesourceentity.getZ() - immediatesourceentity.getDeltaMovement().z());
            immediatesourceentity.getPersistentData().putDouble("x_power", immediatesourceentity.getDeltaMovement().x());
            immediatesourceentity.getPersistentData().putDouble("y_power", immediatesourceentity.getDeltaMovement().y());
            immediatesourceentity.getPersistentData().putDouble("z_power", immediatesourceentity.getDeltaMovement().z());
         }

         if (!immediatesourceentity.getPersistentData().getBoolean("Stop")) {
            x_power = immediatesourceentity.getPersistentData().getDouble("x_power") - immediatesourceentity.getDeltaMovement().x();
            y_power = immediatesourceentity.getPersistentData().getDouble("y_power") - immediatesourceentity.getDeltaMovement().y();
            z_power = immediatesourceentity.getPersistentData().getDouble("z_power") - immediatesourceentity.getDeltaMovement().z();
            x_power = immediatesourceentity.getDeltaMovement().x() + Math.min(Math.abs(x_power), 0.1) * (double)(x_power > 0.0 ? 1 : -1);
            y_power = immediatesourceentity.getDeltaMovement().y() + Math.min(Math.abs(y_power), 0.1) * (double)(y_power > 0.0 ? 1 : -1);
            z_power = immediatesourceentity.getDeltaMovement().z() + Math.min(Math.abs(z_power), 0.1) * (double)(z_power > 0.0 ? 1 : -1);
            immediatesourceentity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
         } else {
            immediatesourceentity.getPersistentData().putBoolean("Stop", false);
         }

         old_skill = entity.getPersistentData().getDouble("skill");
         old_cooldown = entity.getPersistentData().getDouble("COOLDOWN_TICKS");
         entity.getPersistentData().putDouble("skill", immediatesourceentity.getPersistentData().getDouble("skill"));
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", immediatesourceentity.getPersistentData().getDouble("COOLDOWN_TICKS"));
         x_pos = immediatesourceentity.getPersistentData().getDouble("old_x");
         y_pos = immediatesourceentity.getPersistentData().getDouble("old_y");
         z_pos = immediatesourceentity.getPersistentData().getDouble("old_z");
         x_power = x - x_pos;
         y_power = y - y_pos;
         z_power = z - z_pos;
         dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
         if (dis > 1.0) {
            x_power /= dis;
            y_power /= dis;
            z_power /= dis;
         }

         for(int index0 = 0; index0 < (int)Math.round(Math.max(dis * 4.0, 1.0)); ++index0) {
            ++num;
            if (num > 0.0) {
               num = -4.0;
               entity.getPersistentData().putDouble("Damage", immediatesourceentity.getPersistentData().getDouble("Damage"));
               entity.getPersistentData().putDouble("Range", 3.0);
               entity.getPersistentData().putDouble("knockback", 0.25);
               if (immediatesourceentity.getPersistentData().getDouble("skill") == 154.0) {
                  entity.getPersistentData().putDouble("effect", 10.0);
               }

               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               AIBulletProcedure.execute();
            }

            if (immediatesourceentity.getPersistentData().getDouble("skill") == 154.0) {
               ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 5.0, Mth.nextDouble(RandomSource.create(), 0.0, Math.min(1.0, dis)) * 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, Math.random() < 0.5 ? "minecraft:soul_fire_flame" : "gaigegaigekaigecraft:particle_curse_power_blue");
            } else {
               ParticleGeneratorProcedure.execute(world, 1.0, 1.0, 5.0, Mth.nextDouble(RandomSource.create(), 0.0, Math.min(1.0, dis)) * 2.0, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_curse_power_orange");
            }

            x_pos += x_power * 0.25;
            y_pos += y_power * 0.25;
            z_pos += z_power * 0.25;
         }

         immediatesourceentity.getPersistentData().putDouble("old_x", x);
         immediatesourceentity.getPersistentData().putDouble("old_y", y);
         immediatesourceentity.getPersistentData().putDouble("old_z", z);
         entity.getPersistentData().putDouble("skill", old_skill);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cooldown);
         immediatesourceentity.getPersistentData().putDouble("Damage", Math.max(immediatesourceentity.getPersistentData().getDouble("Damage") * 0.99, 9.0));
         if (immediatesourceentity.getPersistentData().getDouble("cnt_life") > 40.0 && !immediatesourceentity.level().isClientSide()) {
            immediatesourceentity.discard();
         }

      }
   }
}
