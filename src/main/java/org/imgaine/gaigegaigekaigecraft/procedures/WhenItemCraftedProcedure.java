package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenItemCraftedProcedure {
   public WhenItemCraftedProcedure() {
   }

   @SubscribeEvent
   public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
      execute(event, event.getEntity(), event.getCrafting());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute((Event)null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         WhenItemPicksUpProcedure.execute(entity, itemstack);
      }
   }
}
