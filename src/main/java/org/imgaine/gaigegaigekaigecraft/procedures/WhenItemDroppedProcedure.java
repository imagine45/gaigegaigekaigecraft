package org.imgaine.gaigegaigekaigecraft.procedures;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
      execute(event, event.getPlayer(), event.getEntity().getItem());
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      execute((Event)null, entity, itemstack);
   }

   private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
      if (entity != null) {
         boolean remove_item;
         int var10000;
         label67: {
            remove_item = false;
            String dd = "";
            String MM = "";
            String pattern = "";
            String yyyy = "";
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getAmplifier();
                  break label67;
               }
            }

            var10000 = 0;
         }

         if (var10000 >= 1) {
            if (event != null && event.isCancelable()) {
               event.setCanceled(true);
            }

         } else {
            if (itemstack.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get() || itemstack.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get() || itemstack.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
               remove_item = true;
            }

            if (itemstack.getItem() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get() && itemstack.getOrCreateTag().getDouble("skill") != 0.0) {
               remove_item = true;
            }

            if (itemstack.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get()) {
               remove_item = true;
            }

            if (remove_item) {
               itemstack.setCount(0);
               if (event != null && event.isCancelable()) {
                  event.setCanceled(true);
               }

            } else {
               if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && (entity.getPersistentData().getString("crime2").isEmpty() || Math.random() < 0.1)) {
                  String var11 = Component.translatable("jujutsu.message.higuruma_date").getString();
                  String var12 = (new SimpleDateFormat("yyyy")).format(Calendar.getInstance().getTime());
                  String var10 = (new SimpleDateFormat("MM")).format(Calendar.getInstance().getTime());
                  String var9 = (new SimpleDateFormat("dd")).format(Calendar.getInstance().getTime());
                  entity.getPersistentData().putString("crime2", Component.translatable("jujutsu.message.higuruma10").getString().replace("[guilt]", Component.translatable("jujutsu.message.higuruma13").getString().replace("[item]", itemstack.getDisplayName().getString())).replace("[date]", var11.replace("yyyy", var12).replace("MM", GetMonthProcedure.execute(var10)).replace("dd", var9)));
               }

            }
         }
      }
   }
}
