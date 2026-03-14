package org.imgaine.gaigegaigekaigecraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModScreens;
import org.imgaine.gaigegaigekaigecraft.network.SelectTechniqueButtonMessage;
import org.imgaine.gaigegaigekaigecraft.procedures.ButtonMakiProcedure;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SelectTechniqueScreen extends AbstractContainerScreen<SelectTechniqueMenu> implements JujutsucraftModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   public static Checkbox curse_user;
   public static Checkbox cursed_spirit;
   Button button_random1;
   Button button_gojo1;
   Button button_megumi_fushiguro1;
   Button button_maki_zenin1;
   Button button_sukuna1;
   Button button_inumaki1;
   Button button_okkotsu1;
   Button button_jogo1;
   Button button_kashimo1;
   Button button_dagon1;
   Button button_tsukumo1;
   Button button_choso1;
   Button button_mei_mei1;
   Button button_ishigori1;
   Button button_nanami1;
   Button button_hanami1;
   Button button_mahito1;
   Button button_mahoraga1;
   Button button_nonsorcerer1;
   Button button_takaba1;
   Button button_geto1;
   Button button_naoya1;
   Button button_todo1;
   Button button_itadori1;
   Button button_jinichi1;
   Button button_0123456789;
   Button button_uraume1234;
   Button button_ogi1234566;
   Button button_higuruma01;
   Button button_angel01234;
   Button button_hakari0000;
   Button button_miguel0124;
   Button button_kusakabe00;
   Button button_chojuro000;
   Button button_yaga000000;
   Button button_kugisaki00;
   Button button_junpei0000;
   Button button_nishimiya0;
   Button button_dhruv00000;
   Button button_yorozu0000;
   Button button_uro0000000;
   Button button_smallpox00;
   Button button_ino0000000;
   Button button_kaori00000;
   Button button_rozetsu;
   private static final ResourceLocation texture;

   public SelectTechniqueScreen(SelectTechniqueMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.f_97726_ = 419;
      this.f_97727_ = 246;
   }

   public void m_88315_(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.m_280273_(guiGraphics);
      super.m_88315_(guiGraphics, mouseX, mouseY, partialTicks);
      this.m_280072_(guiGraphics, mouseX, mouseY);
   }

   protected void m_7286_(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.m_280163_(texture, this.f_97735_, this.f_97736_, 0.0F, 0.0F, this.f_97726_, this.f_97727_, this.f_97726_, this.f_97727_);
      RenderSystem.disableBlend();
   }

   public HashMap<String, Object> getWidgets() {
      return guistate;
   }

   public boolean m_7933_(int key, int b, int c) {
      if (key == 256) {
         this.f_96541_.f_91074_.m_6915_();
         return true;
      } else {
         return super.m_7933_(key, b, c);
      }
   }

   protected void m_280003_(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_other"), 11, 11, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_jujutsu_sorcerer"), 110, 11, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_sorcerer"), 191, 11, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_culling_game"), 254, 11, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_cursed_spirits_curse_users"), 335, 2, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_curse_users"), 335, 11, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_jujutsu"), 173, 2, -12829636, false);
      guiGraphics.m_280614_(this.f_96547_, Component.m_237115_("gui.jujutsucraft.select_technique.label_jujutsu1"), 92, 2, -12829636, false);
   }

   public void m_7856_() {
      super.m_7856_();
      this.button_random1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_random1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_random1", this.button_random1);
      this.m_142416_(this.button_random1);
      this.button_gojo1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_gojo1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_gojo1", this.button_gojo1);
      this.m_142416_(this.button_gojo1);
      this.button_megumi_fushiguro1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_megumi_fushiguro1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(2, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 65, 77, 20).m_253136_();
      guistate.put("button:button_megumi_fushiguro1", this.button_megumi_fushiguro1);
      this.m_142416_(this.button_megumi_fushiguro1);
      this.button_maki_zenin1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_maki_zenin1"), (e) -> {
         if (ButtonMakiProcedure.execute(guistate)) {
            textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
            textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(3, this.x, this.y, this.z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
         }

      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 133, 77, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ButtonMakiProcedure.execute(SelectTechniqueScreen.guistate)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_maki_zenin1", this.button_maki_zenin1);
      this.m_142416_(this.button_maki_zenin1);
      this.button_sukuna1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_sukuna1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(4, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_sukuna1", this.button_sukuna1);
      this.m_142416_(this.button_sukuna1);
      this.button_inumaki1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_inumaki1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(5, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 110, 77, 20).m_253136_();
      guistate.put("button:button_inumaki1", this.button_inumaki1);
      this.m_142416_(this.button_inumaki1);
      this.button_okkotsu1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_okkotsu1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(6, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 155, 77, 20).m_253136_();
      guistate.put("button:button_okkotsu1", this.button_okkotsu1);
      this.m_142416_(this.button_okkotsu1);
      this.button_jogo1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_jogo1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(7, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 133, 77, 20).m_253136_();
      guistate.put("button:button_jogo1", this.button_jogo1);
      this.m_142416_(this.button_jogo1);
      this.button_kashimo1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_kashimo1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(8, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 8, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 133, 77, 20).m_253136_();
      guistate.put("button:button_kashimo1", this.button_kashimo1);
      this.m_142416_(this.button_kashimo1);
      this.button_dagon1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_dagon1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(9, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 9, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 110, 77, 20).m_253136_();
      guistate.put("button:button_dagon1", this.button_dagon1);
      this.m_142416_(this.button_dagon1);
      this.button_tsukumo1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_tsukumo1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(10, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 10, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 133, 77, 20).m_253136_();
      guistate.put("button:button_tsukumo1", this.button_tsukumo1);
      this.m_142416_(this.button_tsukumo1);
      this.button_choso1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_choso1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(11, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 11, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 178, 77, 20).m_253136_();
      guistate.put("button:button_choso1", this.button_choso1);
      this.m_142416_(this.button_choso1);
      this.button_mei_mei1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_mei_mei1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(12, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 12, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 65, 77, 20).m_253136_();
      guistate.put("button:button_mei_mei1", this.button_mei_mei1);
      this.m_142416_(this.button_mei_mei1);
      this.button_ishigori1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_ishigori1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(13, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 13, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 110, 77, 20).m_253136_();
      guistate.put("button:button_ishigori1", this.button_ishigori1);
      this.m_142416_(this.button_ishigori1);
      this.button_nanami1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_nanami1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(14, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 14, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_nanami1", this.button_nanami1);
      this.m_142416_(this.button_nanami1);
      this.button_hanami1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_hanami1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(15, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 15, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 88, 77, 20).m_253136_();
      guistate.put("button:button_hanami1", this.button_hanami1);
      this.m_142416_(this.button_hanami1);
      this.button_mahito1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_mahito1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(16, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 16, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 155, 77, 20).m_253136_();
      guistate.put("button:button_mahito1", this.button_mahito1);
      this.m_142416_(this.button_mahito1);
      this.button_mahoraga1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_mahoraga1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(17, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 17, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 110, 77, 20).m_253136_();
      guistate.put("button:button_mahoraga1", this.button_mahoraga1);
      this.m_142416_(this.button_mahoraga1);
      this.button_nonsorcerer1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_nonsorcerer1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(18, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 18, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 43, 77, 20).m_253136_();
      guistate.put("button:button_nonsorcerer1", this.button_nonsorcerer1);
      this.m_142416_(this.button_nonsorcerer1);
      this.button_takaba1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_takaba1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(19, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 19, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 155, 77, 20).m_253136_();
      guistate.put("button:button_takaba1", this.button_takaba1);
      this.m_142416_(this.button_takaba1);
      this.button_geto1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_geto1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(20, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 20, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 65, 77, 20).m_253136_();
      guistate.put("button:button_geto1", this.button_geto1);
      this.m_142416_(this.button_geto1);
      this.button_naoya1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_naoya1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(21, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 21, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 223, 77, 20).m_253136_();
      guistate.put("button:button_naoya1", this.button_naoya1);
      this.m_142416_(this.button_naoya1);
      this.button_todo1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_todo1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(22, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 22, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 223, 77, 20).m_253136_();
      guistate.put("button:button_todo1", this.button_todo1);
      this.m_142416_(this.button_todo1);
      this.button_itadori1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_itadori1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(23, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 23, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 43, 77, 20).m_253136_();
      guistate.put("button:button_itadori1", this.button_itadori1);
      this.m_142416_(this.button_itadori1);
      this.button_jinichi1 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_jinichi1"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(24, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 24, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 200, 77, 20).m_253136_();
      guistate.put("button:button_jinichi1", this.button_jinichi1);
      this.m_142416_(this.button_jinichi1);
      this.button_0123456789 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_0123456789"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(25, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 25, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 65, 77, 20).m_253136_();
      guistate.put("button:button_0123456789", this.button_0123456789);
      this.m_142416_(this.button_0123456789);
      this.button_uraume1234 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_uraume1234"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(26, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 26, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 43, 77, 20).m_253136_();
      guistate.put("button:button_uraume1234", this.button_uraume1234);
      this.m_142416_(this.button_uraume1234);
      this.button_ogi1234566 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_ogi1234566"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(27, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 27, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 155, 77, 20).m_253136_();
      guistate.put("button:button_ogi1234566", this.button_ogi1234566);
      this.m_142416_(this.button_ogi1234566);
      this.button_higuruma01 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_higuruma01"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(28, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 28, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 20, 77, 20).m_253136_();
      guistate.put("button:button_higuruma01", this.button_higuruma01);
      this.m_142416_(this.button_higuruma01);
      this.button_angel01234 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_angel01234"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(29, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 29, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 178, 77, 20).m_253136_();
      guistate.put("button:button_angel01234", this.button_angel01234);
      this.m_142416_(this.button_angel01234);
      this.button_hakari0000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_hakari0000"), (e) -> {
         if (ButtonMakiProcedure.execute(guistate)) {
            textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
            textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
            JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(30, this.x, this.y, this.z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(this.entity, 30, this.x, this.y, this.z, textstate);
         }

      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 178, 77, 20).build((builder) -> new Button(builder) {
            public void m_88315_(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ButtonMakiProcedure.execute(SelectTechniqueScreen.guistate)) {
                  super.m_88315_(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_hakari0000", this.button_hakari0000);
      this.m_142416_(this.button_hakari0000);
      this.button_miguel0124 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_miguel0124"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(31, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 31, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 88, 77, 20).m_253136_();
      guistate.put("button:button_miguel0124", this.button_miguel0124);
      this.m_142416_(this.button_miguel0124);
      this.button_kusakabe00 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_kusakabe00"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(32, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 32, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 88, 77, 20).m_253136_();
      guistate.put("button:button_kusakabe00", this.button_kusakabe00);
      this.m_142416_(this.button_kusakabe00);
      this.button_chojuro000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_chojuro000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(33, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 33, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 178, 77, 20).m_253136_();
      guistate.put("button:button_chojuro000", this.button_chojuro000);
      this.m_142416_(this.button_chojuro000);
      this.button_yaga000000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_yaga000000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(34, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 34, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 110, 77, 20).m_253136_();
      guistate.put("button:button_yaga000000", this.button_yaga000000);
      this.m_142416_(this.button_yaga000000);
      this.button_kugisaki00 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_kugisaki00"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(35, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 35, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 88, 77, 20).m_253136_();
      guistate.put("button:button_kugisaki00", this.button_kugisaki00);
      this.m_142416_(this.button_kugisaki00);
      this.button_junpei0000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_junpei0000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(36, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 36, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 65, 77, 20).m_253136_();
      guistate.put("button:button_junpei0000", this.button_junpei0000);
      this.m_142416_(this.button_junpei0000);
      this.button_nishimiya0 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_nishimiya0"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(37, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 37, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 92, this.f_97736_ + 200, 77, 20).m_253136_();
      guistate.put("button:button_nishimiya0", this.button_nishimiya0);
      this.m_142416_(this.button_nishimiya0);
      this.button_dhruv00000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_dhruv00000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(38, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 38, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 43, 77, 20).m_253136_();
      guistate.put("button:button_dhruv00000", this.button_dhruv00000);
      this.m_142416_(this.button_dhruv00000);
      this.button_yorozu0000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_yorozu0000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(39, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 39, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 200, 77, 20).m_253136_();
      guistate.put("button:button_yorozu0000", this.button_yorozu0000);
      this.m_142416_(this.button_yorozu0000);
      this.button_uro0000000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_uro0000000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(40, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 40, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 254, this.f_97736_ + 88, 77, 20).m_253136_();
      guistate.put("button:button_uro0000000", this.button_uro0000000);
      this.m_142416_(this.button_uro0000000);
      this.button_smallpox00 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_smallpox00"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(41, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 41, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 200, 77, 20).m_253136_();
      guistate.put("button:button_smallpox00", this.button_smallpox00);
      this.m_142416_(this.button_smallpox00);
      this.button_ino0000000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_ino0000000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(42, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 42, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 173, this.f_97736_ + 43, 77, 20).m_253136_();
      guistate.put("button:button_ino0000000", this.button_ino0000000);
      this.m_142416_(this.button_ino0000000);
      this.button_kaori00000 = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_kaori00000"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(43, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 43, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 11, this.f_97736_ + 133, 77, 20).m_253136_();
      guistate.put("button:button_kaori00000", this.button_kaori00000);
      this.m_142416_(this.button_kaori00000);
      this.button_rozetsu = Button.m_253074_(Component.m_237115_("gui.jujutsucraft.select_technique.button_rozetsu"), (e) -> {
         textstate.put("checkboxin:curse_user", curse_user.m_93840_() ? "true" : "false");
         textstate.put("checkboxin:cursed_spirit", cursed_spirit.m_93840_() ? "true" : "false");
         JujutsucraftMod.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(44, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 44, this.x, this.y, this.z, textstate);
      }).m_252987_(this.f_97735_ + 335, this.f_97736_ + 223, 77, 20).m_253136_();
      guistate.put("button:button_rozetsu", this.button_rozetsu);
      this.m_142416_(this.button_rozetsu);
      curse_user = new Checkbox(this.f_97735_ + 2, this.f_97736_ + 205, 20, 20, Component.m_237115_("gui.jujutsucraft.select_technique.curse_user"), false);
      guistate.put("checkbox:curse_user", curse_user);
      this.m_142416_(curse_user);
      cursed_spirit = new Checkbox(this.f_97735_ + 2, this.f_97736_ + 223, 20, 20, Component.m_237115_("gui.jujutsucraft.select_technique.cursed_spirit"), false);
      guistate.put("checkbox:cursed_spirit", cursed_spirit);
      this.m_142416_(cursed_spirit);
   }

   static {
      guistate = SelectTechniqueMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("jujutsucraft:textures/screens/select_technique.png");
   }
}
