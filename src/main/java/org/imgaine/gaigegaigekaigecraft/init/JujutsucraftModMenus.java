package org.imgaine.gaigegaigekaigecraft.init;

import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechniqueMenu;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class JujutsucraftModMenus {
   public static final DeferredRegister<MenuType<?>> REGISTRY;
   public static final RegistryObject<MenuType<SelectTechniqueMenu>> SELECT_TECHNIQUE;

   public JujutsucraftModMenus() {
   }

   public static void setText(String boxname, String value, @Nullable ServerPlayer player) {
      if (player != null) {
         JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> player), new GuiSyncMessage(boxname, value));
      } else {
         JujutsucraftMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new GuiSyncMessage(boxname, value));
      }

   }

   @SubscribeEvent
   public static void init(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(GuiSyncMessage.class, GuiSyncMessage::buffer, GuiSyncMessage::new, GuiSyncMessage::handleData);
   }

   static {
      REGISTRY = DeferredRegister.create(ForgeRegistries.MENU_TYPES, "jujutsucraft");
      SELECT_TECHNIQUE = REGISTRY.register("select_technique", () -> IForgeMenuType.create(SelectTechniqueMenu::new));
   }

   public static class GuiSyncMessage {
      private final String textboxid;
      private final String data;

      public GuiSyncMessage(FriendlyByteBuf buffer) {
         this.textboxid = buffer.m_130238_().getString();
         this.data = buffer.m_130238_().getString();
      }

      public GuiSyncMessage(String textboxid, String data) {
         this.textboxid = textboxid;
         this.data = data;
      }

      public static void buffer(GuiSyncMessage message, FriendlyByteBuf buffer) {
         buffer.m_130083_(Component.m_237113_(message.textboxid));
         buffer.m_130083_(Component.m_237113_(message.data));
      }

      public static void handleData(GuiSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (!context.getDirection().getReceptionSide().isServer()) {
               JujutsucraftModScreens.handleTextBoxMessage(message);
            }

         });
         context.setPacketHandled(true);
      }

      String editbox() {
         return this.textboxid;
      }

      String value() {
         return this.data;
      }
   }
}
