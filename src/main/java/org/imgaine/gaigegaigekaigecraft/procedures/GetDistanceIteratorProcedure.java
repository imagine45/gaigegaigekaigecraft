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
         if (entityiterator.m_20186_() > entity.m_20186_()) {
            y_distance = Math.max(entityiterator.m_20186_() - (entity.m_20186_() + (double)entity.m_20206_()), 0.0);
         } else {
            y_distance = Math.max(entity.m_20186_() - (entityiterator.m_20186_() + (double)entityiterator.m_20206_()), 0.0);
         }

         widthTotal = (double)entity.m_20205_() * 0.5 + (double)entityiterator.m_20205_() * 0.5;
         x_distance = Math.max(Math.abs(entity.m_20185_() - entityiterator.m_20185_()) - widthTotal, 0.0);
         z_distance = Math.max(Math.abs(entity.m_20189_() - entityiterator.m_20189_()) - widthTotal, 0.0);
         return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
      } else {
         return 0.0;
      }
   }
}
