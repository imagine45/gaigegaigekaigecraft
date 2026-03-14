package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class OverlayKeyCProcedure {
   public OverlayKeyCProcedure() {
   }

   public static String execute(Entity entity) {
      if (entity == null) {
         return "";
      } else {
         String keyName = "";
         if (entity instanceof Player) {
            for(KeyMapping key : Minecraft.m_91087_().f_91066_.f_92059_) {
               if (key.m_90860_().equals("key.jujutsucraft.key_switch_cursed_technique.")) {
                  keyName = key.m_90863_().getString();
                  break;
               }
            }
         }

         return keyName;
      }
   }
}
