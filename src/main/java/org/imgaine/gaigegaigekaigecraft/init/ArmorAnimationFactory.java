package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.item.ClothesAngelItem;
import org.imgaine.gaigegaigekaigecraft.item.ClothesDagonItem;
import org.imgaine.gaigegaigekaigecraft.item.ClothesKusakabeItem;
import org.imgaine.gaigegaigekaigecraft.item.ClothesUroItem;
import org.imgaine.gaigegaigekaigecraft.item.HanamiEyeItem;
import org.imgaine.gaigegaigekaigecraft.item.HeadJetItem;
import org.imgaine.gaigegaigekaigecraft.item.HeadPropellerItem;
import org.imgaine.gaigegaigekaigecraft.item.InsectArmorItem;
import org.imgaine.gaigegaigekaigecraft.item.ItadoriYujiPaperItem;
import org.imgaine.gaigegaigekaigecraft.item.MythicalBeastAmberItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;

@EventBusSubscriber
public class ArmorAnimationFactory {
   public ArmorAnimationFactory() {
   }

   @SubscribeEvent
   public static void animatedArmors(TickEvent.PlayerTickEvent event) {
      String animation = "";
      if (event.phase == Phase.END) {
         if (event.player.m_6844_(EquipmentSlot.HEAD).m_41720_() != ItemStack.f_41583_.m_41720_() && event.player.m_6844_(EquipmentSlot.HEAD).m_41720_() instanceof GeoItem && !event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128461_("geckoAnim").equals("")) {
            animation = event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128461_("geckoAnim");
            event.player.m_6844_(EquipmentSlot.HEAD).m_41784_().m_128359_("geckoAnim", "");
            Item var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof ClothesAngelItem) {
               ClothesAngelItem animatable = (ClothesAngelItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof ClothesDagonItem) {
               ClothesDagonItem animatable = (ClothesDagonItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof ClothesKusakabeItem) {
               ClothesKusakabeItem animatable = (ClothesKusakabeItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof ClothesUroItem) {
               ClothesUroItem animatable = (ClothesUroItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof InsectArmorItem) {
               InsectArmorItem animatable = (InsectArmorItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof HeadJetItem) {
               HeadJetItem animatable = (HeadJetItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof HeadPropellerItem) {
               HeadPropellerItem animatable = (HeadPropellerItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof HanamiEyeItem) {
               HanamiEyeItem animatable = (HanamiEyeItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof MythicalBeastAmberItem) {
               MythicalBeastAmberItem animatable = (MythicalBeastAmberItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var3 = event.player.m_6844_(EquipmentSlot.HEAD).m_41720_();
            if (var3 instanceof ItadoriYujiPaperItem) {
               ItadoriYujiPaperItem animatable = (ItadoriYujiPaperItem)var3;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }
         }

         if (event.player.m_6844_(EquipmentSlot.CHEST).m_41720_() != ItemStack.f_41583_.m_41720_() && event.player.m_6844_(EquipmentSlot.CHEST).m_41720_() instanceof GeoItem && !event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128461_("geckoAnim").equals("")) {
            animation = event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128461_("geckoAnim");
            event.player.m_6844_(EquipmentSlot.CHEST).m_41784_().m_128359_("geckoAnim", "");
            Item var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof ClothesAngelItem) {
               ClothesAngelItem animatable = (ClothesAngelItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof ClothesDagonItem) {
               ClothesDagonItem animatable = (ClothesDagonItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof ClothesKusakabeItem) {
               ClothesKusakabeItem animatable = (ClothesKusakabeItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof ClothesUroItem) {
               ClothesUroItem animatable = (ClothesUroItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof InsectArmorItem) {
               InsectArmorItem animatable = (InsectArmorItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof HeadJetItem) {
               HeadJetItem animatable = (HeadJetItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof HeadPropellerItem) {
               HeadPropellerItem animatable = (HeadPropellerItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof HanamiEyeItem) {
               HanamiEyeItem animatable = (HanamiEyeItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof MythicalBeastAmberItem) {
               MythicalBeastAmberItem animatable = (MythicalBeastAmberItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var56 = event.player.m_6844_(EquipmentSlot.CHEST).m_41720_();
            if (var56 instanceof ItadoriYujiPaperItem) {
               ItadoriYujiPaperItem animatable = (ItadoriYujiPaperItem)var56;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }
         }

         if (event.player.m_6844_(EquipmentSlot.LEGS).m_41720_() != ItemStack.f_41583_.m_41720_() && event.player.m_6844_(EquipmentSlot.LEGS).m_41720_() instanceof GeoItem && !event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128461_("geckoAnim").equals("")) {
            animation = event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128461_("geckoAnim");
            event.player.m_6844_(EquipmentSlot.LEGS).m_41784_().m_128359_("geckoAnim", "");
            Item var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof ClothesAngelItem) {
               ClothesAngelItem animatable = (ClothesAngelItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof ClothesDagonItem) {
               ClothesDagonItem animatable = (ClothesDagonItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof ClothesKusakabeItem) {
               ClothesKusakabeItem animatable = (ClothesKusakabeItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof ClothesUroItem) {
               ClothesUroItem animatable = (ClothesUroItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof InsectArmorItem) {
               InsectArmorItem animatable = (InsectArmorItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof HeadJetItem) {
               HeadJetItem animatable = (HeadJetItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof HeadPropellerItem) {
               HeadPropellerItem animatable = (HeadPropellerItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof HanamiEyeItem) {
               HanamiEyeItem animatable = (HanamiEyeItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof MythicalBeastAmberItem) {
               MythicalBeastAmberItem animatable = (MythicalBeastAmberItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var66 = event.player.m_6844_(EquipmentSlot.LEGS).m_41720_();
            if (var66 instanceof ItadoriYujiPaperItem) {
               ItadoriYujiPaperItem animatable = (ItadoriYujiPaperItem)var66;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }
         }

         if (event.player.m_6844_(EquipmentSlot.FEET).m_41720_() != ItemStack.f_41583_.m_41720_() && event.player.m_6844_(EquipmentSlot.FEET).m_41720_() instanceof GeoItem && !event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128461_("geckoAnim").equals("")) {
            animation = event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128461_("geckoAnim");
            event.player.m_6844_(EquipmentSlot.FEET).m_41784_().m_128359_("geckoAnim", "");
            Item var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof ClothesAngelItem) {
               ClothesAngelItem animatable = (ClothesAngelItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof ClothesDagonItem) {
               ClothesDagonItem animatable = (ClothesDagonItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof ClothesKusakabeItem) {
               ClothesKusakabeItem animatable = (ClothesKusakabeItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof ClothesUroItem) {
               ClothesUroItem animatable = (ClothesUroItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof InsectArmorItem) {
               InsectArmorItem animatable = (InsectArmorItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof HeadJetItem) {
               HeadJetItem animatable = (HeadJetItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof HeadPropellerItem) {
               HeadPropellerItem animatable = (HeadPropellerItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof HanamiEyeItem) {
               HanamiEyeItem animatable = (HanamiEyeItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof MythicalBeastAmberItem) {
               MythicalBeastAmberItem animatable = (MythicalBeastAmberItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }

            var76 = event.player.m_6844_(EquipmentSlot.FEET).m_41720_();
            if (var76 instanceof ItadoriYujiPaperItem) {
               ItadoriYujiPaperItem animatable = (ItadoriYujiPaperItem)var76;
               if (event.player.m_9236_().m_5776_()) {
                  animatable.animationprocedure = animation;
               }
            }
         }
      }

   }
}
