package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import net.minecraft.world.entity.Entity;

public class LogicAIProcedure {
   public LogicAIProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         if (entity instanceof CrowEntity) {
            logic_a = entity.getPersistentData().m_128459_("NameRanged_ranged") == 0.0;
         } else {
            logic_a = entity.getPersistentData().m_128459_("friend_num") == 0.0;
         }

         return logic_a;
      }
   }
}
