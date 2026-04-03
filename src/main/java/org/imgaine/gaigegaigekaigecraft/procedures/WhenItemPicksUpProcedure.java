package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenItemPicksUpProcedure {
   public WhenItemPicksUpProcedure() {
   }

   @SubscribeEvent
   public static void onPickup(EntityItemPickupEvent event) {
      execute(event, event.getEntity(), event.getItem().getItem());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute((Event)null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         double mode = 0.0;
         String dd = "";
         String MM = "";
         String pattern = "";
         String yyyy = "";
         String str1 = "";
         if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living")))) {
            if (!(itemstack.getItem() instanceof SwordItem) && !(itemstack.getItem() instanceof TridentItem) && !(itemstack.getItem() instanceof BowItem) && !itemstack.is(ItemTags.create(new ResourceLocation("forge:sword"))) && !itemstack.is(ItemTags.create(new ResourceLocation("forge:rifle"))) && !itemstack.is(ItemTags.create(new ResourceLocation("forge:bow"))) && itemstack.getItem() != Blocks.COMMAND_BLOCK.asItem() && itemstack.getItem() != Blocks.REPEATING_COMMAND_BLOCK.asItem() && itemstack.getItem() != Blocks.CHAIN_COMMAND_BLOCK.asItem() && itemstack.getItem() != Items.COMMAND_BLOCK_MINECART && itemstack.getItem() != Items.LAVA_BUCKET && itemstack.getItem() != Blocks.SPAWNER.asItem() && itemstack.getItem() != Blocks.WITHER_SKELETON_SKULL.asItem() && itemstack.getItem() != Blocks.WITHER_ROSE.asItem()) {
               if (itemstack.getItem() == Items.GUNPOWDER || itemstack.getItem() == Items.FIRE_CHARGE || itemstack.getItem() == Items.END_CRYSTAL || itemstack.getItem() == Blocks.RESPAWN_ANCHOR.asItem() || itemstack.getItem() == Items.CREEPER_SPAWN_EGG || itemstack.getItem() == Blocks.TNT.asItem() || itemstack.getItem() == Items.TNT_MINECART || itemstack.is(ItemTags.create(new ResourceLocation("minecraft:beds")))) {
                  str1 = "jujutsu.message.higuruma12_2";
                  mode = 1.0;
               }
            } else {
               str1 = "jujutsu.message.higuruma12";
               mode = 2.0;
            }

            if (mode != 0.0 && (entity.getPersistentData().getString("crime4").isEmpty() || Math.random() < 0.1)) {
               pattern = Component.translatable("jujutsu.message.higuruma_date").getString();
               yyyy = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
               MM = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
               dd = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
               entity.getPersistentData().putString("crime4", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable(str1).getString().replace("[item]", (mode == 1.0 ? "§4" : "") + itemstack.getDisplayName().getString())).replace("[date]", pattern.replace("yyyy", yyyy).replace("MM", GetMonthProcedure.execute(MM)).replace("dd", dd)));
            }

            if (entity.getPersistentData().getString("crime2").contains(itemstack.getDisplayName().getString())) {
               entity.getPersistentData().putString("crime2", "");
            }
         }

      }
   }
}
