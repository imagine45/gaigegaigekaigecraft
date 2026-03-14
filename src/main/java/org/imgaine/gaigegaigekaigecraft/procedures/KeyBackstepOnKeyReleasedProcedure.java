package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class KeyBackstepOnKeyReleasedProcedure {
   public KeyBackstepOnKeyReleasedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("PRESS_S", false);
      }
   }
}
