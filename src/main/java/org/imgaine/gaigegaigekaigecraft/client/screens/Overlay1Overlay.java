package org.imgaine.gaigegaigekaigecraft.client.screens;

import org.imgaine.gaigegaigekaigecraft.procedures.OOverlay1Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OOverlay2Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class Overlay1Overlay {
   public Overlay1Overlay() {
   }

   @SubscribeEvent(
      priority = EventPriority.NORMAL
   )
   public static void eventHandler(RenderGuiEvent.Pre event) {
      int w = event.getWindow().getGuiScaledWidth();
      int h = event.getWindow().getGuiScaledHeight();
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.getInstance().player;
      if (entity != null) {
         world = entity.level();
         x = entity.getX();
         y = entity.getY();
         z = entity.getZ();
      }

      event.getGuiGraphics().drawString(Minecraft.getInstance().font, OOverlay1Procedure.execute(entity), w / 2 + 108, h - 43, -1, false);
      event.getGuiGraphics().drawString(Minecraft.getInstance().font, OOverlay2Procedure.execute(entity), w / 2 + 108, h - 34, -1, false);
   }
}
