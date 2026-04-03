package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class DataSixEyes9Procedure {
   public DataSixEyes9Procedure() {
   }

   public static String execute(Entity entity) {
      return entity == null ? "" : entity.getPersistentData().getString("DataSixEyes9");
   }
}
