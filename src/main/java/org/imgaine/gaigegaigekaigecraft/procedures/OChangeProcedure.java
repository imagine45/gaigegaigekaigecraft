package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

public class OChangeProcedure {
   public OChangeProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String var10000 = OverlayKeyRProcedure.execute(entity);
         return var10000 + ": " + Component.m_237115_("jujutsu.overlay.change").getString();
      }
   }
}
