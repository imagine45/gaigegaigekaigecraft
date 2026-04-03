package org.imgaine.gaigegaigekaigecraft.network;

import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.procedures.KeyReverseCursedTechniqueOnKeyPressedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.KeyReverseCursedTechniqueOnKeyReleasedProcedure;
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
public class KeyReverseCursedTechniqueMessage {
   int type;
   int pressedms;

   public KeyReverseCursedTechniqueMessage(int type, int pressedms) {
      this.type = type;
      this.pressedms = pressedms;
   }

   public KeyReverseCursedTechniqueMessage(FriendlyByteBuf buffer) {
      this.type = buffer.readInt();
      this.pressedms = buffer.readInt();
   }

   public static void buffer(KeyReverseCursedTechniqueMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.type);
      buffer.writeInt(message.pressedms);
   }

   public static void handler(KeyReverseCursedTechniqueMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
            KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
         }

         if (type == 1) {
            KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      Gaigegaigekaigecraft.addNetworkMessage(KeyReverseCursedTechniqueMessage.class, KeyReverseCursedTechniqueMessage::buffer, KeyReverseCursedTechniqueMessage::new, KeyReverseCursedTechniqueMessage::handler);
   }
}
