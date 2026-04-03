package org.imgaine.gaigegaigekaigecraft.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModScreens;
import org.imgaine.gaigegaigekaigecraft.network.SelectTechnique2ButtonMessage;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechnique2Menu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SelectTechnique2Screen extends AbstractContainerScreen<SelectTechnique2Menu> implements JujutsucraftModScreens.WidgetScreen {
   private static final HashMap<String, Object> guistate;
   private final Level world;
   private final int x;
   private final int y;
   private final int z;
   private final Player entity;
   private static final HashMap<String, String> textstate;
   Button button_smallpox00;
   Button button_rozetsu;
   Button button_empty;
   Button button_crystal_curse;
   private static final ResourceLocation texture;

   public SelectTechnique2Screen(SelectTechnique2Menu container, Inventory inventory, Component text) {
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
   }

   public void init() {
      super.init();
      this.button_smallpox00 = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique_2.button_smallpox00"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(0, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 0, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 20, 77, 20).build();
      guistate.put("button:button_smallpox00", this.button_smallpox00);
      this.addRenderableWidget(this.button_smallpox00);
      this.button_rozetsu = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique_2.button_rozetsu"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(1, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 1, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 200, 77, 20).build();
      guistate.put("button:button_rozetsu", this.button_rozetsu);
      this.addRenderableWidget(this.button_rozetsu);
      this.button_empty = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique_2.button_empty"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(2, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 2, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 11, this.topPos + 223, 18, 20).build();
      guistate.put("button:button_empty", this.button_empty);
      this.addRenderableWidget(this.button_empty);
      this.button_crystal_curse = Button.builder(Component.translatable("gui.gaigegaigekaigecraft.select_technique_2.button_crystal_curse"), (e) -> {
         Gaigegaigekaigecraft.PACKET_HANDLER.sendToServer(new SelectTechnique2ButtonMessage(3, this.x, this.y, this.z, textstate));
         SelectTechnique2ButtonMessage.handleButtonAction(this.entity, 3, this.x, this.y, this.z, textstate);
      }).bounds(this.leftPos + 335, this.topPos + 178, 77, 20).build();
      guistate.put("button:button_crystal_curse", this.button_crystal_curse);
      this.addRenderableWidget(this.button_crystal_curse);
   }

   static {
      guistate = SelectTechnique2Menu.guistate;
      textstate = new HashMap();
      texture = new ResourceLocation("gaigegaigekaigecraft:textures/screens/select_technique_2.png");
   }
}
