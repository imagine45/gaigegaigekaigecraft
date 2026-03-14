package org.imgaine.gaigegaigekaigecraft.network;

import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import org.imgaine.gaigegaigekaigecraft.procedures.KeySwitchCursedTechniqueOnKeyPressedProcedure;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class KeySwitchCursedTechniqueMessage {
   int type;
   int pressedms;

   public KeySwitchCursedTechniqueMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public KeySwitchCursedTechniqueMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(KeySwitchCursedTechniqueMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(KeySwitchCursedTechniqueMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedms));
      context.setPacketHandled(true);
   }

   public static void pressAction(Player entity, int type, int pressedms) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      if (world.m_46805_(entity.m_20183_())) {
         if (type == 0) {
            KeySwitchCursedTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(KeySwitchCursedTechniqueMessage.class, KeySwitchCursedTechniqueMessage::buffer, KeySwitchCursedTechniqueMessage::new, KeySwitchCursedTechniqueMessage::handler);
   }
}
