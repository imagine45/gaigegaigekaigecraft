package org.imgaine.gaigegaigekaigecraft.init;

import java.util.HashMap;
import org.imgaine.gaigegaigekaigecraft.client.gui.SelectProfessionScreen;
import org.imgaine.gaigegaigekaigecraft.client.gui.SelectTechnique2Screen;
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
      event.enqueueWork(() -> {
         MenuScreens.register((MenuType)JujutsucraftModMenus.SELECT_TECHNIQUE.get(), SelectTechniqueScreen::new);
         MenuScreens.register((MenuType)JujutsucraftModMenus.SELECT_PROFESSION.get(), SelectProfessionScreen::new);
         MenuScreens.register((MenuType)JujutsucraftModMenus.SELECT_TECHNIQUE_2.get(), SelectTechnique2Screen::new);
      });
   }

   static void handleTextBoxMessage(JujutsucraftModMenus.GuiSyncMessage message) {
      String editbox = message.editbox();
      String value = message.value();
      Screen currentScreen = Minecraft.getInstance().screen;
      if (currentScreen instanceof WidgetScreen sc) {
         HashMap<String, Object> widgets = sc.getWidgets();
         Object obj = widgets.get("text:" + editbox);
         if (obj instanceof EditBox box) {
            box.setValue(value);
         }
      }

   }

   public interface WidgetScreen {
      HashMap<String, Object> getWidgets();
   }
}
