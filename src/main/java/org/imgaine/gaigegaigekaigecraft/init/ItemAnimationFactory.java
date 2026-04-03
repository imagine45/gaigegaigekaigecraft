package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.item.BlackRopeItem;
import org.imgaine.gaigegaigekaigecraft.item.DeathPaintingItem;
import org.imgaine.gaigegaigekaigecraft.item.ExecutionersSwordItem;
import org.imgaine.gaigegaigekaigecraft.item.GavelBigItem;
import org.imgaine.gaigegaigekaigecraft.item.GavelItem;
import org.imgaine.gaigegaigekaigecraft.item.GavelLongItem;
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
      ItemStack mainhandItem = event.player.getMainHandItem().copy();
      ItemStack offhandItem = event.player.getOffhandItem().copy();
      if (event.phase == Phase.START && (mainhandItem.getItem() instanceof GeoItem || offhandItem.getItem() instanceof GeoItem)) {
         Item var5 = mainhandItem.getItem();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof GavelItem) {
            GavelItem animatable = (GavelItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ExecutionersSwordItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof ExecutionersSwordItem) {
            ExecutionersSwordItem animatable = (ExecutionersSwordItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((ExecutionersSwordItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SwordOptionItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof SwordOptionItem) {
            SwordOptionItem animatable = (SwordOptionItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((SwordOptionItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((PlayfulCloudItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof PlayfulCloudItem) {
            PlayfulCloudItem animatable = (PlayfulCloudItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((PlayfulCloudItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BlackRopeItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof BlackRopeItem) {
            BlackRopeItem animatable = (BlackRopeItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((BlackRopeItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((MahitoHand1Item)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof MahitoHand1Item) {
            MahitoHand1Item animatable = (MahitoHand1Item)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((MahitoHand1Item)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((DeathPaintingItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof DeathPaintingItem) {
            DeathPaintingItem animatable = (DeathPaintingItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((DeathPaintingItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof GavelLongItem) {
            GavelLongItem animatable = (GavelLongItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelLongItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof GavelLongItem) {
            GavelLongItem animatable = (GavelLongItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelLongItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = mainhandItem.getItem();
         if (var5 instanceof GavelBigItem) {
            GavelBigItem animatable = (GavelBigItem)var5;
            animation = mainhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getMainHandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelBigItem)event.player.getMainHandItem().getItem()).animationprocedure = animation;
               }
            }
         }

         var5 = offhandItem.getItem();
         if (var5 instanceof GavelBigItem) {
            GavelBigItem animatable = (GavelBigItem)var5;
            animation = offhandItem.getOrCreateTag().getString("geckoAnim");
            if (!animation.isEmpty()) {
               event.player.getOffhandItem().getOrCreateTag().putString("geckoAnim", "");
               if (event.player.level().isClientSide()) {
                  ((GavelBigItem)event.player.getOffhandItem().getItem()).animationprocedure = animation;
               }
            }
         }
      }

   }
}
