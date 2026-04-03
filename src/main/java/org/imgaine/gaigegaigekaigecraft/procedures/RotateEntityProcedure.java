package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class RotateEntityProcedure {
   public RotateEntityProcedure() {
   }

   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double yaw = 0.0;
         double pitch = 0.0;
         double distance = 0.0;
         double dx = 0.0;
         double dy = 0.0;
         double dz = 0.0;
         double atan2_result = 0.0;
         double distanceXZ = 0.0;
         double ratio = 0.0;
         entity.lookAt(Anchor.EYES, new Vec3(x, y, z));
      }
   }
}
