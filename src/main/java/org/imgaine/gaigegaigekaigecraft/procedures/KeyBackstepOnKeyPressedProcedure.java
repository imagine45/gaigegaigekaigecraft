package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyBackstepOnKeyPressedProcedure {
   public KeyBackstepOnKeyPressedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("PRESS_S", true);
      }
   }
}
