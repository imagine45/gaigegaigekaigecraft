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
      int w = event.getWindow().m_85445_();
      int h = event.getWindow().m_85446_();
      Level world = null;
      double x = 0.0;
      double y = 0.0;
      double z = 0.0;
      Player entity = Minecraft.m_91087_().f_91074_;
      if (entity != null) {
         world = entity.m_9236_();
         x = entity.m_20185_();
         y = entity.m_20186_();
         z = entity.m_20189_();
      }

      event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OOverlay1Procedure.execute(entity), w / 2 + 108, h / 2 + 86, -1, false);
      event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OOverlay2Procedure.execute(entity), w / 2 + 108, h / 2 + 95, -1, false);
   }
}
