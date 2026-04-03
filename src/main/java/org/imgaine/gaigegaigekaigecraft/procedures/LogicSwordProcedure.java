package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;

public class LogicSwordProcedure {
   public LogicSwordProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         ItemStack mainHandItem = ItemStack.EMPTY;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         mainHandItem = var10000.copy();
         if (!(mainHandItem.getItem() instanceof SwordItem) && !(mainHandItem.getItem() instanceof AxeItem) && !(mainHandItem.getItem() instanceof PickaxeItem) && !(mainHandItem.getItem() instanceof ShovelItem) && !(mainHandItem.getItem() instanceof HoeItem) && !mainHandItem.is(ItemTags.create(new ResourceLocation("forge:sword"))) && !mainHandItem.is(ItemTags.create(new ResourceLocation("forge:whip"))) && (!mainHandItem.is(ItemTags.create(new ResourceLocation("forge:metallic"))) || !mainHandItem.is(ItemTags.create(new ResourceLocation("minecraft:pickaxes"))))) {
            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:have_claws")))) {
               return true;
            } else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:iron_body")))) {
               return true;
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               return var10000.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get();
            }
         } else {
            return true;
         }
      }
   }
}
