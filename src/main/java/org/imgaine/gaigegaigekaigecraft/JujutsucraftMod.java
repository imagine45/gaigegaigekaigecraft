package org.imgaine.gaigegaigekaigecraft;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlockEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModBlocks;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMenus;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModSounds;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModTabs;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModVillagerProfessions;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("jujutsucraft")
public class JujutsucraftMod {
   public static final Logger LOGGER = LogManager.getLogger(JujutsucraftMod.class);
   public static final String MODID = "jujutsucraft";
   private static final String PROTOCOL_VERSION = "1";
   public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation("jujutsucraft", "jujutsucraft"), () -> "1", "1"::equals, "1"::equals);
   private static int messageID = 0;
   private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue();

   public JujutsucraftMod() {
      MinecraftForge.EVENT_BUS.register(this);
      IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
      JujutsucraftModSounds.REGISTRY.register(bus);
      JujutsucraftModBlocks.REGISTRY.register(bus);
      JujutsucraftModBlockEntities.REGISTRY.register(bus);
      JujutsucraftModItems.REGISTRY.register(bus);
      JujutsucraftModEntities.REGISTRY.register(bus);
      JujutsucraftModTabs.REGISTRY.register(bus);
      JujutsucraftModMobEffects.REGISTRY.register(bus);
      JujutsucraftModParticleTypes.REGISTRY.register(bus);
      JujutsucraftModVillagerProfessions.PROFESSIONS.register(bus);
      JujutsucraftModMenus.REGISTRY.register(bus);
      JujutsucraftModAttributes.REGISTRY.register(bus);
   }

   public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
      PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
      ++messageID;
   }

   public static void queueServerWork(int tick, Runnable action) {
      if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER) {
         workQueue.add(new AbstractMap.SimpleEntry(action, tick));
      }

   }

   @SubscribeEvent
   public void tick(TickEvent.ServerTickEvent event) {
      if (event.phase == Phase.END) {
         List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList();
         workQueue.forEach((work) -> {
            work.setValue((Integer)work.getValue() - 1);
            if ((Integer)work.getValue() == 0) {
               actions.add(work);
            }

         });
         actions.forEach((e) -> ((Runnable)e.getKey()).run());
         workQueue.removeAll(actions);
      }

   }
}
