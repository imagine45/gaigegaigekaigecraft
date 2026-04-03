package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class OverlayKeyGProcedure {
   public OverlayKeyGProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String keyName = "";
         if (entity instanceof Player) {
            for(KeyMapping key : Minecraft.getInstance().options.keyMappings) {
               if (key.getName().equals("key.gaigegaigekaigecraft.key_simple_domain")) {
                  keyName = key.getTranslatedKeyMessage().getString();
                  break;
               }
            }
         }

         return keyName;
      }
   }
}
