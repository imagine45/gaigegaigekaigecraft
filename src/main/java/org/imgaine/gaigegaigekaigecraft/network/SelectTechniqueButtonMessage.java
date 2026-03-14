package org.imgaine.gaigegaigekaigecraft.network;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectAngelProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectChojuroProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectChosoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectDagonProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectDhruvLakdawallaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectFushiguroProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectGetoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectGojoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectHakariProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectHanamiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectHigurumaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectInoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectInumakiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectIshigoriProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectItadoriProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectJinichiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectJogoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectJunpeProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectKaoriProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectKashimoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectKugisakiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectKurourushiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectKusakabeProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectMahitoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectMahoragaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectMakiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectMeiMeiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectMiguelProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectNanamiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectNaoyaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectNishimiyaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectNonSorcererProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectOgiProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectOkkotsuProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectRandomProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectRozetsuProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectSmallpoxDeityProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectSukunaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectTakabaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectTakakoUroProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectTodoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectTsukumoProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectUraumeProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectYagaProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SelectYorozuProcedure;
import org.imgaine.gaigegaigekaigecraft.world.inventory.SelectTechniqueMenu;
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
public class SelectTechniqueButtonMessage {
   private final int buttonID;
   private final int x;
   private final int y;
   private final int z;
   private HashMap<String, String> textstate;

   public SelectTechniqueButtonMessage(FriendlyByteBuf buffer) {
      this.buttonID = buffer.readInt();
      this.x = buffer.readInt();
      this.y = buffer.readInt();
      this.z = buffer.readInt();
      this.textstate = readTextState(buffer);
   }

   public SelectTechniqueButtonMessage(int buttonID, int x, int y, int z, HashMap<String, String> textstate) {
      this.buttonID = buttonID;
      this.x = x;
      this.y = y;
      this.z = z;
      this.textstate = textstate;
   }

   public static void buffer(SelectTechniqueButtonMessage message, FriendlyByteBuf buffer) {
      buffer.writeInt(message.buttonID);
      buffer.writeInt(message.x);
      buffer.writeInt(message.y);
      buffer.writeInt(message.z);
      writeTextState(message.textstate, buffer);
   }

   public static void handler(SelectTechniqueButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
      Level world = entity.m_9236_();
      HashMap guistate = SelectTechniqueMenu.guistate;

      for(Map.Entry<String, String> entry : textstate.entrySet()) {
         String key = (String)entry.getKey();
         String value = (String)entry.getValue();
         guistate.put(key, value);
      }

      if (world.m_46805_(new BlockPos(x, y, z))) {
         if (buttonID == 0) {
            SelectRandomProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 1) {
            SelectGojoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 2) {
            SelectFushiguroProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 3) {
            SelectMakiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 4) {
            SelectSukunaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 5) {
            SelectInumakiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 6) {
            SelectOkkotsuProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 7) {
            SelectJogoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 8) {
            SelectKashimoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 9) {
            SelectDagonProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 10) {
            SelectTsukumoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 11) {
            SelectChosoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 12) {
            SelectMeiMeiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 13) {
            SelectIshigoriProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 14) {
            SelectNanamiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 15) {
            SelectHanamiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 16) {
            SelectMahitoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 17) {
            SelectMahoragaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 18) {
            SelectNonSorcererProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 19) {
            SelectTakabaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 20) {
            SelectGetoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 21) {
            SelectNaoyaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 22) {
            SelectTodoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 23) {
            SelectItadoriProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 24) {
            SelectJinichiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 25) {
            SelectKurourushiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 26) {
            SelectUraumeProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 27) {
            SelectOgiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 28) {
            SelectHigurumaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 29) {
            SelectAngelProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 30) {
            SelectHakariProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 31) {
            SelectMiguelProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 32) {
            SelectKusakabeProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 33) {
            SelectChojuroProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 34) {
            SelectYagaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 35) {
            SelectKugisakiProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 36) {
            SelectJunpeProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 37) {
            SelectNishimiyaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 38) {
            SelectDhruvLakdawallaProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 39) {
            SelectYorozuProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 40) {
            SelectTakakoUroProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 41) {
            SelectSmallpoxDeityProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 42) {
            SelectInoProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 43) {
            SelectKaoriProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

         if (buttonID == 44) {
            SelectRozetsuProcedure.execute(world, (double)x, (double)y, (double)z, entity, guistate);
         }

      }
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      JujutsucraftMod.addNetworkMessage(SelectTechniqueButtonMessage.class, SelectTechniqueButtonMessage::buffer, SelectTechniqueButtonMessage::new, SelectTechniqueButtonMessage::handler);
   }

   public static void writeTextState(HashMap<String, String> map, FriendlyByteBuf buffer) {
      buffer.writeInt(map.size());

      for(Map.Entry<String, String> entry : map.entrySet()) {
         buffer.m_130083_(Component.m_237113_((String)entry.getKey()));
         buffer.m_130083_(Component.m_237113_((String)entry.getValue()));
      }

   }

   public static HashMap<String, String> readTextState(FriendlyByteBuf buffer) {
      int size = buffer.readInt();
      HashMap<String, String> map = new HashMap();

      for(int i = 0; i < size; ++i) {
         String key = buffer.m_130238_().getString();
         String value = buffer.m_130238_().getString();
         map.put(key, value);
      }

      return map;
   }
}
