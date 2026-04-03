package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyDOnKeyReleasedProcedure {
   public KeyDOnKeyReleasedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("PRESS_D", false);
      }
   }
}
