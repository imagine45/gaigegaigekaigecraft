package org.imgaine.gaigegaigekaigecraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModScreens;
import org.imgaine.gaigegaigekaigecraft.network.SelectTechniqueButtonMessage;
import org.imgaine.gaigegaigekaigecraft.procedures.ButtonMakiProcedure;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
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
   Button button_ino0000000;
   Button button_kaori00000;
   Button button_reggie_star;
   Button button_iori_hazenoki;
   Button button_ranta_zenin;
   Button button_empty;
   private static final ResourceLocation texture;

   public SelectTechniqueScreen(SelectTechniqueMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 419;
      this.imageHeight = 246;
   }

   public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
      this.renderBackground(guiGraphics);
      super.render(guiGraphics, mouseX, mouseY, partialTicks);
      this.renderTooltip(guiGraphics, mouseX, mouseY);
   }

   protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      guiGraphics.blit(texture, this.leftPos, this.topPos, 0.0F, 0.0F, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
      RenderSystem.disableBlend();
   }

   public HashMap<String, Object> getWidgets() {
      return guistate;
   }

   public boolean keyPressed(int key, int b, int c) {
      if (key == 256) {
         this.minecraft.player.closeContainer();
         return true;
      } else {
         return super.keyPressed(key, b, c);
      }
   }

   protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_other"), 11, 11, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_jujutsu_sorcerer"), 110, 11, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_sorcerer"), 191, 11, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_culling_game"), 254, 11, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_cursed_spirits_curse_users"), 335, 2, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_curse_users"), 335, 11, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_jujutsu"), 173, 2, -12829636, false);
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_technique.label_jujutsu1"), 92, 2, -12829636, false);
   }

   public void init() {
      super.init();
      this.button_random1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_random1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_random1", this.button_random1);
      this.addRenderableWidget(this.button_random1);
      this.button_gojo1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_gojo1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_gojo1", this.button_gojo1);
      this.addRenderableWidget(this.button_gojo1);
      this.button_megumi_fushiguro1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_megumi_fushiguro1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(2, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 65, 77, 20).build();
      guistate.put("button:button_megumi_fushiguro1", this.button_megumi_fushiguro1);
      this.addRenderableWidget(this.button_megumi_fushiguro1);
      this.button_maki_zenin1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_maki_zenin1"), (e) -> {
         if (ButtonMakiProcedure.execute(this.entity)) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(3, this.x, this.y, this.z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
         }

      }).bounds(this.leftPos + 92, this.topPos + 133, 77, 20).build((builder) -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ButtonMakiProcedure.execute(SelectTechniqueScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_maki_zenin1", this.button_maki_zenin1);
      this.addRenderableWidget(this.button_maki_zenin1);
      this.button_sukuna1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_sukuna1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(4, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 4, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_sukuna1", this.button_sukuna1);
      this.addRenderableWidget(this.button_sukuna1);
      this.button_inumaki1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_inumaki1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(5, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 5, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 110, 77, 20).build();
      guistate.put("button:button_inumaki1", this.button_inumaki1);
      this.addRenderableWidget(this.button_inumaki1);
      this.button_okkotsu1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_okkotsu1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(6, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 6, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 155, 77, 20).build();
      guistate.put("button:button_okkotsu1", this.button_okkotsu1);
      this.addRenderableWidget(this.button_okkotsu1);
      this.button_jogo1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_jogo1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(7, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 7, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 133, 77, 20).build();
      guistate.put("button:button_jogo1", this.button_jogo1);
      this.addRenderableWidget(this.button_jogo1);
      this.button_kashimo1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_kashimo1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(8, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 8, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 110, 77, 20).build();
      guistate.put("button:button_kashimo1", this.button_kashimo1);
      this.addRenderableWidget(this.button_kashimo1);
      this.button_dagon1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_dagon1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(9, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 9, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 110, 77, 20).build();
      guistate.put("button:button_dagon1", this.button_dagon1);
      this.addRenderableWidget(this.button_dagon1);
      this.button_tsukumo1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_tsukumo1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(10, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 10, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 110, 77, 20).build();
      guistate.put("button:button_tsukumo1", this.button_tsukumo1);
      this.addRenderableWidget(this.button_tsukumo1);
      this.button_choso1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_choso1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(11, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 11, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 110, 77, 20).build();
      guistate.put("button:button_choso1", this.button_choso1);
      this.addRenderableWidget(this.button_choso1);
      this.button_mei_mei1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_mei_mei1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(12, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 12, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 65, 77, 20).build();
      guistate.put("button:button_mei_mei1", this.button_mei_mei1);
      this.addRenderableWidget(this.button_mei_mei1);
      this.button_ishigori1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_ishigori1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(13, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 13, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 200, 77, 20).build();
      guistate.put("button:button_ishigori1", this.button_ishigori1);
      this.addRenderableWidget(this.button_ishigori1);
      this.button_nanami1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_nanami1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(14, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 14, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_nanami1", this.button_nanami1);
      this.addRenderableWidget(this.button_nanami1);
      this.button_hanami1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_hanami1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(15, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 15, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 88, 77, 20).build();
      guistate.put("button:button_hanami1", this.button_hanami1);
      this.addRenderableWidget(this.button_hanami1);
      this.button_mahito1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_mahito1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(16, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 16, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 155, 77, 20).build();
      guistate.put("button:button_mahito1", this.button_mahito1);
      this.addRenderableWidget(this.button_mahito1);
      this.button_mahoraga1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_mahoraga1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(17, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 17, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 133, 77, 20).build();
      guistate.put("button:button_mahoraga1", this.button_mahoraga1);
      this.addRenderableWidget(this.button_mahoraga1);
      this.button_nonsorcerer1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_nonsorcerer1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(18, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 18, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 43, 77, 20).build();
      guistate.put("button:button_nonsorcerer1", this.button_nonsorcerer1);
      this.addRenderableWidget(this.button_nonsorcerer1);
      this.button_takaba1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_takaba1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(19, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 19, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_takaba1", this.button_takaba1);
      this.addRenderableWidget(this.button_takaba1);
      this.button_geto1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_geto1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(20, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 20, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 65, 77, 20).build();
      guistate.put("button:button_geto1", this.button_geto1);
      this.addRenderableWidget(this.button_geto1);
      this.button_naoya1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_naoya1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(21, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 21, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 223, 77, 20).build();
      guistate.put("button:button_naoya1", this.button_naoya1);
      this.addRenderableWidget(this.button_naoya1);
      this.button_todo1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_todo1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(22, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 22, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 223, 77, 20).build();
      guistate.put("button:button_todo1", this.button_todo1);
      this.addRenderableWidget(this.button_todo1);
      this.button_itadori1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_itadori1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(23, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 23, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 43, 77, 20).build();
      guistate.put("button:button_itadori1", this.button_itadori1);
      this.addRenderableWidget(this.button_itadori1);
      this.button_jinichi1 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_jinichi1"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(24, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 24, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 200, 77, 20).build();
      guistate.put("button:button_jinichi1", this.button_jinichi1);
      this.addRenderableWidget(this.button_jinichi1);
      this.button_0123456789 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_0123456789"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(25, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 25, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 155, 77, 20).build();
      guistate.put("button:button_0123456789", this.button_0123456789);
      this.addRenderableWidget(this.button_0123456789);
      this.button_uraume1234 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_uraume1234"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(26, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 26, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 43, 77, 20).build();
      guistate.put("button:button_uraume1234", this.button_uraume1234);
      this.addRenderableWidget(this.button_uraume1234);
      this.button_ogi1234566 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_ogi1234566"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(27, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 27, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 178, 77, 20).build();
      guistate.put("button:button_ogi1234566", this.button_ogi1234566);
      this.addRenderableWidget(this.button_ogi1234566);
      this.button_higuruma01 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_higuruma01"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(28, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 28, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 88, 77, 20).build();
      guistate.put("button:button_higuruma01", this.button_higuruma01);
      this.addRenderableWidget(this.button_higuruma01);
      this.button_angel01234 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_angel01234"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(29, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 29, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 200, 77, 20).build();
      guistate.put("button:button_angel01234", this.button_angel01234);
      this.addRenderableWidget(this.button_angel01234);
      this.button_hakari0000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_hakari0000"), (e) -> {
         if (ButtonMakiProcedure.execute(this.entity)) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(30, this.x, this.y, this.z, textstate));
            SelectTechniqueButtonMessage.handleButtonAction(this.entity, 30, this.x, this.y, this.z, textstate);
         }

      }).bounds(this.leftPos + 11, this.topPos + 178, 77, 20).build((builder) -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ButtonMakiProcedure.execute(SelectTechniqueScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_hakari0000", this.button_hakari0000);
      this.addRenderableWidget(this.button_hakari0000);
      this.button_miguel0124 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_miguel0124"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(31, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 31, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 65, 77, 20).build();
      guistate.put("button:button_miguel0124", this.button_miguel0124);
      this.addRenderableWidget(this.button_miguel0124);
      this.button_kusakabe00 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_kusakabe00"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(32, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 32, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 88, 77, 20).build();
      guistate.put("button:button_kusakabe00", this.button_kusakabe00);
      this.addRenderableWidget(this.button_kusakabe00);
      this.button_chojuro000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_chojuro000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(33, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 33, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 155, 77, 20).build();
      guistate.put("button:button_chojuro000", this.button_chojuro000);
      this.addRenderableWidget(this.button_chojuro000);
      this.button_yaga000000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_yaga000000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(34, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 34, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 178, 77, 20).build();
      guistate.put("button:button_yaga000000", this.button_yaga000000);
      this.addRenderableWidget(this.button_yaga000000);
      this.button_kugisaki00 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_kugisaki00"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(35, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 35, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 88, 77, 20).build();
      guistate.put("button:button_kugisaki00", this.button_kugisaki00);
      this.addRenderableWidget(this.button_kugisaki00);
      this.button_junpei0000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_junpei0000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(36, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 36, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 88, 77, 20).build();
      guistate.put("button:button_junpei0000", this.button_junpei0000);
      this.addRenderableWidget(this.button_junpei0000);
      this.button_nishimiya0 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_nishimiya0"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(37, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 37, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 92, this.topPos + 200, 77, 20).build();
      guistate.put("button:button_nishimiya0", this.button_nishimiya0);
      this.addRenderableWidget(this.button_nishimiya0);
      this.button_dhruv00000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_dhruv00000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(38, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 38, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 133, 77, 20).build();
      guistate.put("button:button_dhruv00000", this.button_dhruv00000);
      this.addRenderableWidget(this.button_dhruv00000);
      this.button_yorozu0000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_yorozu0000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(39, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 39, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 223, 77, 20).build();
      guistate.put("button:button_yorozu0000", this.button_yorozu0000);
      this.addRenderableWidget(this.button_yorozu0000);
      this.button_uro0000000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_uro0000000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(40, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 40, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 178, 77, 20).build();
      guistate.put("button:button_uro0000000", this.button_uro0000000);
      this.addRenderableWidget(this.button_uro0000000);
      this.button_ino0000000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_ino0000000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(41, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 41, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 43, 77, 20).build();
      guistate.put("button:button_ino0000000", this.button_ino0000000);
      this.addRenderableWidget(this.button_ino0000000);
      this.button_kaori00000 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_kaori00000"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(42, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 42, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 155, 77, 20).build();
      guistate.put("button:button_kaori00000", this.button_kaori00000);
      this.addRenderableWidget(this.button_kaori00000);
      this.button_reggie_star = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_reggie_star"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(43, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 43, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 65, 77, 20).build();
      guistate.put("button:button_reggie_star", this.button_reggie_star);
      this.addRenderableWidget(this.button_reggie_star);
      this.button_iori_hazenoki = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_iori_hazenoki"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(44, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 44, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 254, this.topPos + 43, 77, 20).build();
      guistate.put("button:button_iori_hazenoki", this.button_iori_hazenoki);
      this.addRenderableWidget(this.button_iori_hazenoki);
      this.button_ranta_zenin = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_ranta_zenin"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(45, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 45, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 173, this.topPos + 133, 77, 20).build();
      guistate.put("button:button_ranta_zenin", this.button_ranta_zenin);
      this.addRenderableWidget(this.button_ranta_zenin);
      this.button_empty = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique.button_empty"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechniqueButtonMessage(46, this.x, this.y, this.z, textstate));
         SelectTechniqueButtonMessage.handleButtonAction(this.entity, 46, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 394, this.topPos + 223, 18, 20).build();
      guistate.put("button:button_empty", this.button_empty);
      this.addRenderableWidget(this.button_empty);
   }

   static {
      guistate = SelectTechniqueMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("gaigegaigekaigecraft:textures/screens/select_technique.png");
   }
}
