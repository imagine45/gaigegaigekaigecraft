package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.level.LevelAccessor;

public class ParticleGeneratorCircleProcedure {
   public ParticleGeneratorCircleProcedure() {
   }

   public static void execute(LevelAccessor world, double count, double pitch, double radius1, double radius2, double speed, double x1, double x2, double y1, double y2, double yaw, double z1, double z2, String id) {
      if (id != null) {
         double up_z = 0.0;
         double up_x = 0.0;
         double cosTheta = 0.0;
         double pitch_rad = 0.0;
         double up_y = 0.0;
         double normal_z = 0.0;
         double normal_y = 0.0;
         double x_pos = 0.0;
         double normal_x = 0.0;
         double z_pos = 0.0;
         double yaw_rad = 0.0;
         double rad = 0.0;
         double y_pos = 0.0;
         double sinTheta = 0.0;
         yaw_rad = Math.toRadians(yaw + 90.0);
         pitch_rad = Math.toRadians(pitch + 90.0);
         normal_x = Math.cos(yaw_rad) * Math.cos(pitch_rad);
         normal_y = Math.sin(pitch_rad) * -1.0;
         normal_z = Math.sin(yaw_rad) * Math.cos(pitch_rad);
         up_x = Math.sin(yaw_rad) * -1.0;
         up_y = 0.0;
         up_z = Math.cos(yaw_rad);

         for(int index0 = 0; index0 < (int)Math.max(count, 1.0); ++index0) {
            rad = Math.toRadians(720.0 * Math.random());
            cosTheta = Math.cos(rad);
            sinTheta = Math.sin(rad);
            x_pos = cosTheta * up_x + sinTheta * normal_x;
            y_pos = cosTheta * up_y + sinTheta * normal_y;
            z_pos = cosTheta * up_z + sinTheta * normal_z;
            ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, speed, x1 + x_pos * radius1, x2 + x_pos * radius2, y1 + y_pos * radius1, y2 + y_pos * radius2, z1 + z_pos * radius1, z2 + z_pos * radius2, id);
         }

      }
   }
}
