package org.imgaine.gaigegaigekaigecraft.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicCantJustGuardProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicGuardProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicJustGuardProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OBackstepProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.ODoubleJumpDispProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.ODoubleJumpProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OFlyDispProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OFlyProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayHaveTechniqueProcedure;
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
public class OverlayBackstepOverlay {
   public OverlayBackstepOverlay() {
   }

   @SubscribeEvent(
      priority = EventPriority.LOW
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

      RenderSystem.disableDepthTest();
      RenderSystem.depthMask(false);
      RenderSystem.enableBlend();
      RenderSystem.setShader(GameRenderer::m_172817_);
      RenderSystem.blendFuncSeparate(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA, SourceFactor.ONE, DestFactor.ZERO);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      if (OverlayHaveTechniqueProcedure.execute(entity)) {
         if (LogicCantJustGuardProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_guard_cooldown.png"), w / 2 + -8, h - 53, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (LogicGuardProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/guard.png"), w / 2 + -8, h - 53, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (LogicJustGuardProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/guard_just.png"), w / 2 + -16, h - 61, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_backstep.png"), w / 2 + 6, h - 53, 0.0F, 0.0F, 16, 16, 16, 16);
         if (ODoubleJumpDispProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_double_jump.png"), w / 2 + 6, h - 62, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (OFlyDispProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_fly.png"), w / 2 + 6, h - 71, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OBackstepProcedure.execute(entity), w / 2 + 19, h - 48, -1, false);
         if (ODoubleJumpDispProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, ODoubleJumpProcedure.execute(entity), w / 2 + 19, h - 57, -1, false);
         }

         if (OFlyDispProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OFlyProcedure.execute(entity), w / 2 + 19, h - 66, -1, false);
         }
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
