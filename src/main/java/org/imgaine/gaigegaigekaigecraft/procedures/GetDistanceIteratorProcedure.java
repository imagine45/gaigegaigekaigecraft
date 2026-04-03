package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class GetDistanceIteratorProcedure {
   public GetDistanceIteratorProcedure() {
   }

   public static double execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double distance = 0.0;
         double y_distance = 0.0;
         double widthTotal = 0.0;
         double z_distance = 0.0;
         double x_distance = 0.0;
         if (entityiterator.getY() > entity.getY()) {
            y_distance = Math.max(entityiterator.getY() - (entity.getY() + (double)entity.getBbHeight()), 0.0);
         } else {
            y_distance = Math.max(entity.getY() - (entityiterator.getY() + (double)entityiterator.getBbHeight()), 0.0);
         }

         widthTotal = (double)entity.getBbWidth() * 0.5 + (double)entityiterator.getBbWidth() * 0.5;
         x_distance = Math.max(Math.abs(entity.getX() - entityiterator.getX()) - widthTotal, 0.0);
         z_distance = Math.max(Math.abs(entity.getZ() - entityiterator.getZ()) - widthTotal, 0.0);
         return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
      } else {
         return 0.0;
      }
   }
}
