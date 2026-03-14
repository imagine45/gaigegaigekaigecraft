package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class GetDistanceProcedure {
   public GetDistanceProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         Entity target_entity = null;
         double y_distance = 0.0;
         double widthTotal = 0.0;
         double z_distance = 0.0;
         double x_distance = 0.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (!(target_entity instanceof LivingEntity)) {
            return 999.0;
         } else {
            if (target_entity.m_20186_() > entity.m_20186_()) {
               y_distance = Math.max(target_entity.m_20186_() - (entity.m_20186_() + (double)entity.m_20206_()), 0.0);
            } else {
               y_distance = Math.max(entity.m_20186_() - (target_entity.m_20186_() + (double)target_entity.m_20206_()), 0.0);
            }

            widthTotal = (double)entity.m_20205_() * 0.5 + (double)target_entity.m_20205_() * 0.5;
            x_distance = Math.max(Math.abs(entity.m_20185_() - target_entity.m_20185_()) - widthTotal, 0.0);
            z_distance = Math.max(Math.abs(entity.m_20189_() - target_entity.m_20189_()) - widthTotal, 0.0);
            return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
         }
      }
   }
}
