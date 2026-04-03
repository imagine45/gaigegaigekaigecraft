package org.imgaine.gaigegaigekaigecraft.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayHaveCursedTechniqueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayKeyGProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayKeyMProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayKeyNProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayKeyVProcedure;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class OverlayKeyOverlay {
   public OverlayKeyOverlay() {
   }

   @SubscribeEvent(
      priority = EventPriority.LOW
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

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::getPositionTexShader);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (OverlayHaveCursedTechniqueProcedure.execute(entity)) {
         event.getGuiGraphics().blit(new ResourceLocation("gaigegaigekaigecraft:textures/screens/overlay_technique.png"), w / 2 + 91, h - 25, 0.0F, 0.0F, 26, 26, 26, 26);
         event.getGuiGraphics().blit(new ResourceLocation("gaigegaigekaigecraft:textures/screens/overlay_simple_domain.png"), w / 2 + 117, h - 25, 0.0F, 0.0F, 26, 26, 26, 26);
         event.getGuiGraphics().blit(new ResourceLocation("gaigegaigekaigecraft:textures/screens/overlay_reversed_cursed_technique.png"), w / 2 + 143, h - 25, 0.0F, 0.0F, 26, 26, 26, 26);
         event.getGuiGraphics().blit(new ResourceLocation("gaigegaigekaigecraft:textures/screens/overlay_domain_amplification.png"), w / 2 + 169, h - 25, 0.0F, 0.0F, 26, 26, 26, 26);
         event.getGuiGraphics().drawString(Minecraft.getInstance().font, OverlayKeyVProcedure.execute(entity), w / 2 + 102, h - 9, -1, false);
         event.getGuiGraphics().drawString(Minecraft.getInstance().font, OverlayKeyGProcedure.execute(entity), w / 2 + 128, h - 9, -1, false);
         event.getGuiGraphics().drawString(Minecraft.getInstance().font, OverlayKeyMProcedure.execute(entity), w / 2 + 154, h - 9, -1, false);
         event.getGuiGraphics().drawString(Minecraft.getInstance().font, OverlayKeyNProcedure.execute(entity), w / 2 + 180, h - 9, -1, false);
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
