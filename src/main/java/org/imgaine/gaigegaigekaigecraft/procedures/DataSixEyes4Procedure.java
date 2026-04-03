package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class DataSixEyes4Procedure {
   public DataSixEyes4Procedure() {
   }

   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().getString("DataSixEyes4");
   }
}
