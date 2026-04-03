package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class DataSixEyes5Procedure {
   public DataSixEyes5Procedure() {
   }

   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().getString("DataSixEyes5");
   }
}
