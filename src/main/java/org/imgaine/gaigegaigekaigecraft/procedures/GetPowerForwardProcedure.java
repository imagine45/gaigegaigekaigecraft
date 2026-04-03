package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class GetPowerForwardProcedure {
   public GetPowerForwardProcedure() {
   }

   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         entity.getPersistentData().putDouble("x_power", x - entity.getX());
         entity.getPersistentData().putDouble("y_power", y - (entity.getY() + (double)entity.getBbHeight() * 0.9));
         entity.getPersistentData().putDouble("z_power", z - entity.getZ());
         dis = Math.sqrt(entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("x_power") + entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("y_power") + entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("z_power"));
         if (dis != 0.0) {
            entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") / dis * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") / dis * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") / dis * 3.0);
         } else {
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
         }

         if (entity.getPersistentData().getBoolean("free")) {
            entity.getPersistentData().putBoolean("free", false);
         } else {
            GetPowerFixProcedure.execute(entity);
         }

      }
   }
}
