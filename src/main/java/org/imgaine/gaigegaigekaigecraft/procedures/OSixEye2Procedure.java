package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class OSixEye2Procedure {
   public OSixEye2Procedure() {
   }

   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().getString("DataSixEyes2");
   }
}
