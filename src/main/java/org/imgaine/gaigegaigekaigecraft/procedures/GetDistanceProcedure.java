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
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (!(target_entity instanceof LivingEntity)) {
            return 999.0;
         } else {
            if (target_entity.getY() > entity.getY()) {
               y_distance = Math.max(target_entity.getY() - (entity.getY() + (double)entity.getBbHeight()), 0.0);
            } else {
               y_distance = Math.max(entity.getY() - (target_entity.getY() + (double)target_entity.getBbHeight()), 0.0);
            }

            widthTotal = (double)entity.getBbWidth() * 0.5 + (double)target_entity.getBbWidth() * 0.5;
            x_distance = Math.max(Math.abs(entity.getX() - target_entity.getX()) - widthTotal, 0.0);
            z_distance = Math.max(Math.abs(entity.getZ() - target_entity.getZ()) - widthTotal, 0.0);
            return Math.sqrt(x_distance * x_distance + y_distance * y_distance + z_distance * z_distance);
         }
      }
   }
}
