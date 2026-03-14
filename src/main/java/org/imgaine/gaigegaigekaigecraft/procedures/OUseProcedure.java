package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class OUseProcedure {
   public OUseProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String var10000 = OverlayKeyZProcedure.execute(entity);
         return var10000 + ": " + Component.m_237115_("jujutsu.overlay.use").getString();
      }
   }
}
