package org.imgaine.gaigegaigekaigecraft.procedures;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationAccess;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationFactory;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.network.NetworkEvent;

@EventBusSubscriber(
   modid = "gaigegaigekaigecraft",
   bus = Bus.MOD
)
public class SetupAnimationsProcedure {
   public SetupAnimationsProcedure() {
   }

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onClientSetup(FMLClientSetupEvent event) {
      PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(new ResourceLocation("gaigegaigekaigecraft", "player_animation"), 1000, SetupAnimationsProcedure::registerPlayerAnimations);
   }

   @OnlyIn(Dist.CLIENT)
   private static IAnimation registerPlayerAnimations(AbstractClientPlayer player) {
      return new ModifierLayer();
   }

   @SubscribeEvent
   public static void registerMessage(FMLCommonSetupEvent event) {
      Gaigegaigekaigecraft.addNetworkMessage(JujutsucraftModAnimationMessage.class, JujutsucraftModAnimationMessage::buffer, JujutsucraftModAnimationMessage::new, JujutsucraftModAnimationMessage::handler);
   }

   @OnlyIn(Dist.CLIENT)
   public static void setAnimationClientside(Player player, String anim, boolean override) {
      if (player instanceof AbstractClientPlayer player_) {
         ModifierLayer<IAnimation> animation = (ModifierLayer)PlayerAnimationAccess.getPlayerAssociatedData(player_).get(new ResourceLocation("gaigegaigekaigecraft", "player_animation"));
         if (animation == null) {
            return;
         }

         if (override || !animation.isActive()) {
            ResourceLocation animRL = new ResourceLocation("gaigegaigekaigecraft", anim);
            KeyframeAnimation retrievedAnimation = PlayerAnimationRegistry.getAnimation(animRL);
            if (retrievedAnimation == null) {
               return;
            }

            animation.setAnimation(new KeyframeAnimationPlayer(retrievedAnimation));
         }
      }

   }

   public static void execute() {
      execute((Event)null);
   }

   private static void execute(@Nullable Event event) {
   }

   public static class JujutsucraftModAnimationMessage {
      String animation;
      int target;
      boolean override;

      public JujutsucraftModAnimationMessage(String animation, int target, boolean override) {
         this.animation = animation;
         this.target = target;
         this.override = override;
      }

      public JujutsucraftModAnimationMessage(FriendlyByteBuf buffer) {
         this.animation = buffer.readUtf();
         this.target = buffer.readInt();
         this.override = buffer.readBoolean();
      }

      public static void buffer(JujutsucraftModAnimationMessage message, FriendlyByteBuf buffer) {
         buffer.writeUtf(message.animation);
         buffer.writeInt(message.target);
         buffer.writeBoolean(message.override);
      }

      public static void handler(JujutsucraftModAnimationMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
         NetworkEvent.Context context = (NetworkEvent.Context)contextSupplier.get();
         context.enqueueWork(() -> {
            if (context.getDirection().getReceptionSide().isClient()) {
               handleClientSide(message);
            }

         });
         context.setPacketHandled(true);
      }

      @OnlyIn(Dist.CLIENT)
      private static void handleClientSide(JujutsucraftModAnimationMessage message) {
         Minecraft mc = Minecraft.getInstance();
         if (mc.player != null && mc.level != null) {
            Player player = (Player)mc.level.getEntity(message.target);
            if (player instanceof AbstractClientPlayer) {
               SetupAnimationsProcedure.setAnimationClientside(player, message.animation, message.override);
            }
         }

      }
   }
}
