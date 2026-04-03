package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LocateBloodBallProcedure {
   public LocateBloodBallProcedure() {
   }

   public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         boolean pitch = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double yaw2 = 0.0;
         double pitch2 = 0.0;
         double HP = 0.0;
         logic_a = false;
         if (entity.getPersistentData().getDouble("NameRanged") != 0.0) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(25.0), (e) -> true)) {
               if (entity != entityiterator && entityiterator instanceof BloodBallEntity && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                  logic_a = true;
                  break;
               }
            }
         }

         return logic_a;
      }
   }
}
