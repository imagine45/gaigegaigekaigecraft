package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class OSixEye1Procedure {
   public OSixEye1Procedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String var10000 = entity.getPersistentData().m_128461_("DataSixEyes1");
         return var10000 + " " + entity.getPersistentData().m_128461_("DataSixEyes10");
      }
   }
}
