package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyForwardOnKeyReleasedProcedure {
   public KeyForwardOnKeyReleasedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("PRESS_W", false);
      }
   }
}
