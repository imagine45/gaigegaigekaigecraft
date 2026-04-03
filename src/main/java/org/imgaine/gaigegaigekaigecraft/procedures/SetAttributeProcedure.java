package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.List;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class SetAttributeProcedure {
   public SetAttributeProcedure() {
   }

   @OnlyIn(Dist.CLIENT)
   @SubscribeEvent
   public static void onItemTooltip(ItemTooltipEvent event) {
      execute(event, event.getItemStack(), event.getToolTip());
   }

   public static void execute(ItemStack itemstack, List<Component> tooltip) {
      execute((Event)null, itemstack, tooltip);
   }

   private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
      if (tooltip != null) {
         double curse_value = 0.0;
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         String color = "";
         String STR1 = "";
         if (itemstack.getItem() != ItemStack.EMPTY.getItem()) {
            SetAttributeMainhandProcedure.execute(itemstack);
            if (itemstack.getOrCreateTag().contains("CursePower") && itemstack.getOrCreateTag().getDouble("CursePower") != 0.0) {
               curse_value = itemstack.getOrCreateTag().getDouble("CursePower");
               color = curse_value > 0.0 ? "§c" : "§9";
               tooltip.add(Component.literal(color + Component.translatable("jujutsu.overlay.curse_power").getString() + " Lv." + Math.round(curse_value)));
            }

            if (itemstack.getOrCreateTag().contains("Power") && itemstack.getOrCreateTag().getDouble("Power") != 0.0) {
               NUM2 = itemstack.getOrCreateTag().getDouble("Power") * 4.0;
               if (NUM2 == 0.0) {
                  color = "§f";
               } else {
                  color = NUM2 > 0.0 ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = -4.0;

               for(int index0 = 0; index0 < 9; ++index0) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var10001 = Component.translatable("jujutsu.overlay.weight").getString();
               tooltip.add(Component.literal(var10001 + " " + STR1));
            }

            if (itemstack.getOrCreateTag().contains("Reach") && itemstack.getOrCreateTag().getDouble("Reach") != 0.0) {
               NUM2 = itemstack.getOrCreateTag().getDouble("Reach") * 4.0;
               if (NUM2 == 0.0) {
                  color = "§f";
               } else {
                  color = NUM2 > 0.0 ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = -4.0;

               for(int index1 = 0; index1 < 9; ++index1) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var33 = Component.translatable("jujutsu.overlay.reach").getString();
               tooltip.add(Component.literal(var33 + " " + STR1));
            }

            if (itemstack.getOrCreateTag().contains("Range") && itemstack.getOrCreateTag().getDouble("Range") != 0.0) {
               NUM2 = itemstack.getOrCreateTag().getDouble("Range") * 4.0;
               if (NUM2 == 0.0) {
                  color = "§f";
               } else {
                  color = NUM2 > 0.0 ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = -4.0;

               for(int index2 = 0; index2 < 9; ++index2) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var34 = Component.translatable("jujutsu.overlay.range").getString();
               tooltip.add(Component.literal(var34 + " " + STR1));
            }

            if (itemstack.getOrCreateTag().contains("Knockback") && itemstack.getOrCreateTag().getDouble("Knockback") != 0.0) {
               NUM2 = itemstack.getOrCreateTag().getDouble("Knockback") * 4.0;
               if (NUM2 == 0.0) {
                  color = "§f";
               } else {
                  color = NUM2 > 0.0 ? "§9" : "§c";
               }

               STR1 = color;
               NUM1 = -4.0;

               for(int index3 = 0; index3 < 9; ++index3) {
                  if (NUM1 >= NUM2) {
                     STR1 = STR1 + "§r§8";
                  }

                  STR1 = STR1 + "■";
                  ++NUM1;
               }

               String var35 = Component.translatable("jujutsu.overlay.knockback").getString();
               tooltip.add(Component.literal(var35 + " " + STR1));
            }

            if (itemstack.getItem() == JujutsucraftModItems.HANAMI_HAND.get()) {
               String var36 = Component.translatable("jujutsu.overlay.curse_power").getString();
               tooltip.add(Component.literal("§c" + var36 + ": " + Math.round(Math.ceil(Math.sqrt(itemstack.getOrCreateTag().getDouble("C_Power"))))));
            }

            if (itemstack.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) {
               String var37 = itemstack.getOrCreateTag().getDouble("power_energy") >= 5.0 ? "§9" : "§7";
               tooltip.add(Component.literal(var37 + "Energy: " + Math.round(itemstack.getOrCreateTag().getDouble("power_energy"))));
            }

         }
      }
   }
}
