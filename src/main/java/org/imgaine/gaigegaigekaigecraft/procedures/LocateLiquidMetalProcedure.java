package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.LiquidMetalEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LocateLiquidMetalProcedure {
   public LocateLiquidMetalProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
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
         Entity entity_rika = null;
         logic_a = false;
         if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
            entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("LIQUID_METAL_UUID"));
            if (entity_rika instanceof LiquidMetalEntity && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
               logic_a = true;
            }
         }

         return logic_a;
      }
   }
}
