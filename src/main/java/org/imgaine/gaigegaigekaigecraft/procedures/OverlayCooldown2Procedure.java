package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class OverlayCooldown2Procedure {
   public OverlayCooldown2Procedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return !LogicStartProcedure.execute(entity);
      }
   }
}
