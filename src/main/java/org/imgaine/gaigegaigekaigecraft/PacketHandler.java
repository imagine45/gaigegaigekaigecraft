package org.imgaine.gaigegaigekaigecraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class PacketHandler {
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("gaigegaigekaigecraft", "main"), () -> "1", "1"::equals, "1"::equals);

   public PacketHandler() {
   }

   public static void registerMessages() {
      int id = 0;
      INSTANCE.registerMessage(id++, PlayerVelocityPacket.class, PlayerVelocityPacket::encode, PlayerVelocityPacket::decode, PlayerVelocityPacket::handle);
   }

   @SubscribeEvent
   public static void onCommonSetup(FMLCommonSetupEvent event) {
      registerMessages();
   }
}
