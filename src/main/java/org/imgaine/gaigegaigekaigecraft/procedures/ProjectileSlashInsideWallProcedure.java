package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ProjectileSlashInsideWallProcedure {
   public ProjectileSlashInsideWallProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, boolean vertical) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         double x_center = 0.0;
         double distance = 0.0;
         double z_center = 0.0;
         double x_pos = 0.0;
         double range_fix = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double pitch = 0.0;
         double y_center = 0.0;
         double yaw = 0.0;
         range_fix = Math.max(ReturnEntitySizeProcedure.execute(entity), 1.0);
         x_pos = x;
         y_pos = y;
         z_pos = z;
         if (!logic_a) {
            if (vertical) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)(entity.getXRot() + 90.0F));
            } else {
               yaw = Math.toRadians((double)(entity.getYRot() + 0.0F));
               pitch = Math.toRadians(0.0);
            }

            distance = 0.0;

            for(int index0 = 0; index0 < (int)Math.max(Math.round(6.0 * range_fix), 2L); ++index0) {
               distance += 0.5;
               x_center = x_pos + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_center = y_pos + Math.sin(pitch) * -1.0 * distance;
               z_center = z_pos + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!world.isEmptyBlock(BlockPos.containing(x_center, y_center, z_center))) {
                  logic_a = true;
                  break;
               }
            }
         }

         if (!logic_a) {
            if (vertical) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)(entity.getXRot() - 90.0F));
            } else {
               yaw = Math.toRadians((double)(entity.getYRot() + 180.0F));
               pitch = Math.toRadians(0.0);
            }

            distance = 0.0;

            for(int index1 = 0; index1 < (int)Math.max(Math.round(6.0 * range_fix), 2L); ++index1) {
               distance += 0.5;
               x_center = x_pos + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_center = y_pos + Math.sin(pitch) * -1.0 * distance;
               z_center = z_pos + Math.sin(yaw) * Math.cos(pitch) * distance;
               if (!world.isEmptyBlock(BlockPos.containing(x_center, y_center, z_center))) {
                  logic_a = true;
                  break;
               }
            }
         }

         return logic_a;
      }
   }
}
