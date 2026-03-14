package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class MeteorDisplayConditionProcedure {
   public MeteorDisplayConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.getPersistentData().m_128459_("cnt5") > 600.0;
      }
   }
}
