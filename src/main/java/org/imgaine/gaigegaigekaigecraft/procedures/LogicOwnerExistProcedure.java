package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class LogicOwnerExistProcedure {
   public LogicOwnerExistProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         logic_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID")) instanceof LivingEntity;
         return logic_a;
      }
   }
}
