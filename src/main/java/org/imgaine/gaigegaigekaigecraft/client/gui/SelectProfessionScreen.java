package org.imgaine.gaigegaigekaigecraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModScreens;
import org.imgaine.gaigegaigekaigecraft.network.SelectProfessionButtonMessage;
import org.imgaine.gaigegaigekaigecraft.procedures.ProfessionLogicProcedure;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectProfessionMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SelectProfessionScreen extends AbstractContainerScreen<SelectProfessionMenu> implements JujutsucraftModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_curse_user;
   Button button_jujutsu_sorcerer;
   Button button_cursed_spirit;
   private static final ResourceLocation texture;

   public SelectProfessionScreen(SelectProfessionMenu container, Inventory inventory, Component text) {
      super(container, inventory, text);
      this.world = container.world;
      this.x = container.x;
      this.y = container.y;
      this.z = container.z;
      this.entity = container.entity;
      this.imageWidth = 128;
      this.imageHeight = 100;
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
      guiGraphics.drawString(this.font, Component.translatable("gui.gaigegaigekaigecraft.select_profession.label_you_are"), 18, 10, -12829636, false);
   }

   public void init() {
      super.init();
      this.button_curse_user = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_profession.button_curse_user"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectProfessionButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 18, this.topPos + 46, 90, 20).build();
      guistate.put("button:button_curse_user", this.button_curse_user);
      this.addRenderableWidget(this.button_curse_user);
      this.button_jujutsu_sorcerer = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_profession.button_jujutsu_sorcerer"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectProfessionButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 18, this.topPos + 24, 90, 20).build();
      guistate.put("button:button_jujutsu_sorcerer", this.button_jujutsu_sorcerer);
      this.addRenderableWidget(this.button_jujutsu_sorcerer);
      this.button_cursed_spirit = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_profession.button_cursed_spirit"), (e) -> {
         if (ProfessionLogicProcedure.execute(this.entity)) {
            Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectProfessionButtonMessage(2, this.x, this.y, this.z, textstate));
            SelectProfessionButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
         }

      }).bounds(this.leftPos + 18, this.topPos + 69, 90, 20).build((builder) -> new Button(builder) {
            public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
               if (ProfessionLogicProcedure.execute(SelectProfessionScreen.this.entity)) {
                  super.render(guiGraphics, gx, gy, ticks);
               }

            }
         });
      guistate.put("button:button_cursed_spirit", this.button_cursed_spirit);
      this.addRenderableWidget(this.button_cursed_spirit);
   }

   static {
      guistate = SelectProfessionMenu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("gaigegaigekaigecraft:textures/screens/select_profession.png");
   }
}
