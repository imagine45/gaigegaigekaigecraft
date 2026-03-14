package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.item.BlackRopeItem;
import org.imgaine.gaigegaigekaigecraft.item.DeathPaintingItem;
import org.imgaine.gaigegaigekaigecraft.item.ExecutionersSwordItem;
import org.imgaine.gaigegaigekaigecraft.item.GavelItem;
import org.imgaine.gaigegaigekaigecraft.item.MahitoHand1Item;
import org.imgaine.gaigegaigekaigecraft.item.PlayfulCloudItem;
import org.imgaine.gaigegaigekaigecraft.item.SwordOptionItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ItemAnimationFactory {
   public ItemAnimationFactory() {
   }

   @SubscribeEvent
   public static void animatedItems(TickEvent.PlayerTickEvent event) {
      String animation = "";
      ItemStack mainhandItem = event.player.m_21205_().m_41777_();
      ItemStack offhandItem = event.player.m_21206_().m_41777_();
      if (event.phase == Phase.START && (mainhandItem.m_41720_() instanceof GeoItem || offhandItem.m_41720_() instanceof GeoItem)) {
         Item var5 = mainhandItem.m_41720_();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((GavelItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ExecutionersSwordItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((ExecutionersSwordItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SwordOptionItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((SwordOptionItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PlayfulCloudItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((PlayfulCloudItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BlackRopeItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((BlackRopeItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MahitoHand1Item)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((MahitoHand1Item)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.m_41720_();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = mainhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21205_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((DeathPaintingItem)event.player.m_21205_().m_41720_()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.m_41720_();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = offhandItem.m_41784_().m_128461_("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.m_21206_().m_41784_().m_128359_("geckoAnim", "");
               if (event.player.m_9236_().m_5776_()) {
                  ((DeathPaintingItem)event.player.m_21206_().m_41720_()).animationprocedure = animation;
               }
            }
         }
      }

   }
}
