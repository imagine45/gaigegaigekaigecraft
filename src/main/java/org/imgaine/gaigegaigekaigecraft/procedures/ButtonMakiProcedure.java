package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class ButtonMakiProcedure {
   public ButtonMakiProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return !entity.getPersistentData().getBoolean("CursedSpirit");
      }
   }
}
