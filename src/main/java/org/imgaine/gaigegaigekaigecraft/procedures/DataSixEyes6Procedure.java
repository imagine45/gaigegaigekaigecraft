package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class DataSixEyes6Procedure {
   public DataSixEyes6Procedure() {
   }

   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().getString("DataSixEyes6");
   }
}
