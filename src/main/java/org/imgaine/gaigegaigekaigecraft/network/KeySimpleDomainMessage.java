package org.imgaine.gaigegaigekaigecraft.network;

import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.procedures.KeySimpleDomainOnKeyPressedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.KeySimpleDomainOnKeyReleasedProcedure;
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
public class KeySimpleDomainMessage {
   int type;
   int pressedms;

   public KeySimpleDomainMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public KeySimpleDomainMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(KeySimpleDomainMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(KeySimpleDomainMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> pressAction(context.getSender(), message.type, message.pressedms));
      context.setPacketHandled(true);
   }

   public static void pressAction(Player entity, int type, int pressedms) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      if (world.hasChunkAt(entity.blockPosition())) {
         if (type == 0) {
            KeySimpleDomainOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         if (type == 1) {
            KeySimpleDomainOnKeyReleasedProcedure.execute(entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      Gaigegaigekaigecraft.addNetworkMessage(KeySimpleDomainMessage.class, KeySimpleDomainMessage::buffer, KeySimpleDomainMessage::new, KeySimpleDomainMessage::handler);
   }
}
