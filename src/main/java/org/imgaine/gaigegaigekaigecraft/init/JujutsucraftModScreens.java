package org.imgaine.gaigegaigekaigecraft.init;

import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.client.gui.SelectTechniqueScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class JujutsucraftModScreens {
   public JujutsucraftModScreens() {
   }

   @SubscribeEvent
   public static void clientLoad(FMLClientSetupEvent event) {
      event.enqueueWork(() -> MenuScreens.m_96206_((MenuType)JujutsucraftModMenus.SELECT_TECHNIQUE.get(), SelectTechniqueScreen::new));
   }

   static void handleTextBoxMessage(JujutsucraftModMenus.GuiSyncMessage message) {
      String editbox = message.editbox();
      String value = message.value();
      Screen currentScreen = Minecraft.m_91087_().f_91080_;
      if (currentScreen instanceof WidgetScreen sc) {
         HashMap<String, Object> widgets = sc.getWidgets();
         Object obj = widgets.get("text:" + editbox);
         if (obj instanceof EditBox box) {
            box.m_94144_(value);
         }
      }

   }

   public interface WidgetScreen {
      HashMap<String, Object> getWidgets();
   }
}
