package org.imgaine.gaigegaigekaigecraft.init;

import java.util.List;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(
   bus = Bus.FORGE
)
public class JujutsucraftModTrades {
   public JujutsucraftModTrades() {
   }

   @SubscribeEvent
   public static void registerTrades(VillagerTradesEvent event) {
      if (event.getType() == JujutsucraftModVillagerProfessions.PROFESSION_JUJUTSU_SORCERER.get()) {
         ((List)event.getTrades().get(1)).add(new BasicItemListing(new ItemStack(Items.GOLD_INGOT, 9), new ItemStack((ItemLike)JujutsucraftModItems.STEVENSON_SCREEN_SPAWN_EGG.get()), 10, 5, 0.05F));
      }

   }
}
