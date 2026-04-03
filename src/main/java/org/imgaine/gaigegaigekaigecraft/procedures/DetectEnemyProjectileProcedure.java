package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;

public class DetectEnemyProjectileProcedure {
   public DetectEnemyProjectileProcedure() {
   }

   public static boolean execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double dx = 0.0;
         double dy = 0.0;
         double dz = 0.0;
         double move_x = 0.0;
         double move_y = 0.0;
         double move_z = 0.0;
         if (!(entityiterator instanceof Projectile)) {
            return false;
         } else {
            Entity var10000;
            if (entityiterator instanceof TraceableEntity) {
               TraceableEntity _traceableEntity = (TraceableEntity)entityiterator;
               var10000 = _traceableEntity.getOwner();
            } else {
               var10000 = null;
            }

            if (var10000 == entity) {
               return false;
            } else {
               Vec3 vel = entityiterator.getDeltaMovement();
               dx = entity.getX() - entityiterator.getX();
               dy = entity.getY() + (double)entity.getBbHeight() * 0.5 - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
               dz = entity.getZ() - entityiterator.getZ();
               if (dx * vel.x + dy * vel.y + dz * vel.z <= 0.0) {
                  return false;
               } else {
                  move_x = entityiterator.getDeltaMovement().x();
                  move_y = entityiterator.getDeltaMovement().y();
                  move_z = entityiterator.getDeltaMovement().z();
                  return !(move_x * move_x + move_y * move_y + move_z * move_z < 0.02);
               }
            }
         }
      } else {
         return false;
      }
   }
}
