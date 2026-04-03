package org.imgaine.gaigegaigekaigecraft.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.procedures.PageUndoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectCrystalCurseProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectRozetsuProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectSmallpoxDeityProcedure;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechnique2Menu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
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
public class SelectTechnique2ButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;
   private HashMap<String, String> textstate;

   public SelectTechnique2ButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public SelectTechnique2ButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.textstate = textstate;
   }

   public static void buffer(SelectTechnique2ButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(SelectTechnique2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
      NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
      context.enqueueWork(() -> {
         Player entity = context.getSender();
         int buttonID = message.buttonID;
         int x = message.x;
         int y = message.y;
         int z = message.z;
         HashMap<String, String> textstate = message.textstate;
         handleButtonAction(entity, buttonID, x, y, z, textstate);
      });
      context.setPacketHandled(true);
   }

   public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      Level world = entity.level();
      HashMap guistate = SelectTechnique2Menu.guistate;

      for(Map.Entry<String, String> entry : textstate.entrySet()) {
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         guistate.put(key, value);
      }

      if (world.hasChunkAt(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            SelectSmallpoxDeityProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 1) {
            SelectRozetsuProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 2) {
            PageUndoProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

         if (buttonID == 3) {
            SelectCrystalCurseProcedure.execute(world, (double)x, (double)y, (double)z, entity);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      Gaigegaigekaigecraft.addNetworkMessage(SelectTechnique2ButtonMessage.class, SelectTechnique2ButtonMessage::buffer, SelectTechnique2ButtonMessage::new, SelectTechnique2ButtonMessage::handler);
   }

   public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
      buffer.writeInt(map.size());

      for(Map.Entry<String, String> entry : map.entrySet()) {
         buffer.writeComponent(Component.literal((String)entry.getKey()));
         buffer.writeComponent(Component.literal((String)entry.getValue()));
      }

   }

   public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
      int size = buffer.readInt();
      HashMap<String, String> map = new HashMap();

      for(int i = 0; i < size; ++i) {
         String key = buffer.readComponent().getString();
         String value = buffer.readComponent().getString();
         map.put(key, value);
      }

      return map;
   }
}
