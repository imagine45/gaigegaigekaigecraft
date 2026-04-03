package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyForwardOnKeyReleasedProcedure {
   public KeyForwardOnKeyReleasedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("PRESS_W", false);
      }
   }
}
