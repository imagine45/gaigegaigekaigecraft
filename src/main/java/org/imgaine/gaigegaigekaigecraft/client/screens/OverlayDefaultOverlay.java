package org.imgaine.gaigegaigekaigecraft.client.screens;

import com.mojang.blaze3d.platform.GlStateManager.DestFactor;
import com.mojang.blaze3d.platform.GlStateManager.SourceFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicCooldownCombatProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicCooldownMagicOnlyProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicCooldownProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.LogicDoubleCursedTechniqueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OChangeProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OCoolTimeCombatProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OCoolTimeProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OCoolTimeSelectingProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OCostProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OCursePowerProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OSwitchProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OTechniqueNameProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OUseProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayCooldown2Procedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayCooldown2TimerProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayCursedSkillProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayDefaultSkillProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayDomainSkillProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayHaveTechniqueProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayPassiveProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.OverlayPhysicalSkillProcedure;
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
public class OverlayDefaultOverlay {
   public OverlayDefaultOverlay() {
   }

   @SubscribeEvent(
      priority = EventPriority.HIGH
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
         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/tex_transblack.png"), -7, h - 43, 0.0F, 0.0F, 128, 48, 128, 48);
         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), 14, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         if (LogicCooldownProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 14, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), 2, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         if (LogicCooldownCombatProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 2, h - 22, 0.0F, 0.0F, 16, 16, 16, 16);
         }

         if (OverlayDomainSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_domain_expansion2.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayCursedSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_magic.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayDefaultSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_default.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayPhysicalSkillProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_punch.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayPassiveProcedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_passive.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         if (OverlayCooldown2Procedure.execute(entity)) {
            event.getGuiGraphics().m_280163_(new ResourceLocation("jujutsucraft:textures/screens/icon_cooldown.png"), 0, h - 45, 0.0F, 0.0F, 32, 32, 32, 32);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCursePowerProcedure.execute(entity), 33, h - 40, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OTechniqueNameProcedure.execute(entity), 33, h - 31, -205, false);
         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCostProcedure.execute(entity), 33, h - 22, -205, false);
         if (OverlayCooldown2TimerProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeSelectingProcedure.execute(entity), 13, h - 33, -205, false);
         }

         if (LogicCooldownCombatProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeCombatProcedure.execute(entity), 7, h - 19, -205, false);
         }

         if (LogicCooldownMagicOnlyProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OCoolTimeProcedure.execute(entity), 20, h - 19, -205, false);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OUseProcedure.execute(entity), 88, h - 10, -6710887, false);
         if (LogicDoubleCursedTechniqueProcedure.execute(entity)) {
            event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OSwitchProcedure.execute(entity), 34, h - 10, -6736897, false);
         }

         event.getGuiGraphics().m_280056_(Minecraft.m_91087_().f_91062_, OChangeProcedure.execute(entity), 88, h - 19, -6710887, false);
      }

      RenderSystem.depthMask(true);
      RenderSystem.defaultBlendFunc();
      RenderSystem.enableDepthTest();
      RenderSystem.disableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
   }
}
