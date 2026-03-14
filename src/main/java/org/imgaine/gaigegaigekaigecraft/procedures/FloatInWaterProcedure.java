package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class FloatInWaterProcedure {
   public FloatInWaterProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.getPersistentData().m_128459_("skill") != 705.0;
      }
   }
}
