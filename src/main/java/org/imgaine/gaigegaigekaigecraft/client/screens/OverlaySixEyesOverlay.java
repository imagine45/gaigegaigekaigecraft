package org.imgaine.gaigegaigekaigecraft.client.screens;

import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes4Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes5Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes6Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes7Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes8Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyes9Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DataSixEyesDisplayOverlayIngameProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OSixEye1Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OSixEye2Procedure;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class OverlaySixEyesOverlay {
   public OverlaySixEyesOverlay() {
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

      if (DataSixEyesDisplayOverlayIngameProcedure.execute(entity)) {
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes4Procedure.execute(entity), 6, 71, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes5Procedure.execute(entity), 6, 80, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes6Procedure.execute(entity), 6, 98, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes7Procedure.execute(entity), 6, 107, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes8Procedure.execute(entity), 6, 116, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, DataSixEyes9Procedure.execute(entity), 6, 125, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OSixEye1Procedure.execute(entity), w / 2 + -45, h / 2 + -121, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OSixEye2Procedure.execute(entity), w / 2 + -45, h / 2 + -112, -205, false);
      }

   }
}
