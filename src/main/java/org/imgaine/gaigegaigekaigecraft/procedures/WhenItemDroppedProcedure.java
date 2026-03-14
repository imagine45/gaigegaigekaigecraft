package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenItemDroppedProcedure {
   public WhenItemDroppedProcedure() {
   }

   @SubscribeEvent
   public static void onGemDropped(ItemTossEvent event) {
      execute(event, event.getEntity().m_32055_());
   }

   public static void execute(ItemStack itemstack) {
      execute((Event)null, itemstack);
   }

   private static void execute(@Nullable Event event, ItemStack itemstack) {
      if (itemstack.m_41720_() != JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstack.m_41720_() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get() && itemstack.m_41720_() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get() && itemstack.m_41720_() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
         if (itemstack.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && itemstack.m_41784_().m_128459_("skill") != 0.0) {
            itemstack.m_41774_(itemstack.m_41613_());
         }
      } else {
         itemstack.m_41774_(itemstack.m_41613_());
      }

   }
}
