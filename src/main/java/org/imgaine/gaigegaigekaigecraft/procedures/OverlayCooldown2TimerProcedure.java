package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class OverlayCooldown2TimerProcedure {
   public OverlayCooldown2TimerProcedure() {
   }

   public static boolean execute(Entity entity) {
      return entity == null ? false : OverlayCooldown2Procedure.execute(entity);
   }
}
