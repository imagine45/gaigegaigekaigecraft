package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class OSwitchProcedure {
   public OSwitchProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String var10000 = OverlayKeyCProcedure.execute(entity);
         return var10000 + ": " + Component.translatable("jujutsu.overlay.switch").getString();
      }
   }
}
