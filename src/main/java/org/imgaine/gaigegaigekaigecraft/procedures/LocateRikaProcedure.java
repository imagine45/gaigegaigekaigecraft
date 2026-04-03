package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Rika2Entity;
import org.imgaine.gaigegaigekaigecraft.entity.RikaEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class LocateRikaProcedure {
   public LocateRikaProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         Entity entity_rika = null;
         logic_a = false;
         if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
            entity_rika = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("RIKA_UUID"));
            if ((entity_rika instanceof RikaEntity || entity_rika instanceof Rika2Entity) && entity.getPersistentData().getDouble("friend_num") == entity_rika.getPersistentData().getDouble("friend_num")) {
               logic_a = true;
            }
         }

         return logic_a;
      }
   }
}
