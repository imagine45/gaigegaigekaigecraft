package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class StepBlockProcedure {
   public StepBlockProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double vx, double vy, double vz) {
      if (entity != null) {
         double y_power = 0.0;
         double z_power = 0.0;
         double distance = 0.0;
         double bbHeight = 0.0;
         double maxAllowedStepHeight = 0.0;
         double x_power = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double bbWidth = 0.0;
         x_pos = x;
         y_pos = y;
         z_pos = z;
         x_power = vx;
         y_power = vy;
         z_power = vz;
         distance = Math.sqrt(vx * vx + vy * vy + vz * vz);
         if (distance != 0.0) {
            x_power = vx / distance;
            y_power = vy / distance;
            z_power = vz / distance;
         }

         bbWidth = (double)entity.m_20205_();
         bbHeight = (double)entity.m_20206_();
         if (InsideSolidCalculateProcedure.execute(world, x + x_power, y + Math.max(y_power, 0.0), z + z_power, bbHeight, bbWidth)) {
            maxAllowedStepHeight = Math.max(distance, 1.0);

            for(int index0 = 0; index0 < (int)Math.round(maxAllowedStepHeight) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + 1.0, z_pos, bbHeight, bbWidth); ++index0) {
               ++y_pos;
               if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos + y_power, z_pos + z_power, bbHeight, bbWidth)) {
                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
                  if (!(y_pos <= y)) {
                     for(int index1 = 0; index1 < 10 && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos - 0.1, z_pos, bbHeight, bbWidth); ++index1) {
                        y_pos -= 0.1;
                     }

                     if (!(y_pos <= y)) {
                        entity.m_6021_(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.f_8906_.m_9774_(x_pos, y_pos, z_pos, entity.m_146908_(), entity.m_146909_());
                        }

                        entity.m_20256_(new Vec3(vx, vy, vz));
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
