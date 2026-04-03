package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Locale;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.registries.ForgeRegistries;

public class ConfiscationRightclickedProcedure {
   public ConfiscationRightclickedProcedure() {
   }

   public static void execute(Entity entity, ItemStack itemstack) {
      if (entity != null) {
         ItemStack item_replace = ItemStack.EMPTY;
         item_replace = (new ItemStack((ItemLike)ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemstack.getOrCreateTag().getString("confiscation_item").toLowerCase(Locale.ENGLISH))))).copy().copy();
         CompoundTag _nbtTag = itemstack.getTag();
         if (_nbtTag != null) {
            item_replace.setTag(_nbtTag.copy());
         }

         item_replace.getOrCreateTag().putDouble("CursePower", itemstack.getOrCreateTag().getDouble("CursePower_"));
         item_replace.getOrCreateTag().putDouble("Power", itemstack.getOrCreateTag().getDouble("Power_"));
         item_replace.getOrCreateTag().putDouble("Reach", itemstack.getOrCreateTag().getDouble("Reach_"));
         item_replace.getOrCreateTag().putDouble("Range", itemstack.getOrCreateTag().getDouble("Range_"));
         item_replace.getOrCreateTag().putDouble("Knockback", itemstack.getOrCreateTag().getDouble("Knockback_"));
         item_replace.getOrCreateTag().remove("confiscation_item");
         item_replace.getOrCreateTag().remove("CursePower_");
         item_replace.getOrCreateTag().remove("Power_");
         item_replace.getOrCreateTag().remove("Reach_");
         item_replace.getOrCreateTag().remove("Range_");
         item_replace.getOrCreateTag().remove("Knockback_");
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         if (var10000.getItem() == itemstack.getItem()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               ItemStack _setstack = item_replace.copy();
               _setstack.setCount(item_replace.getCount());
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == itemstack.getItem()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_replace.copy();
                  _setstack.setCount(item_replace.getCount());
                  _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }
            } else {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = item_replace.copy();
                  _setstack.setCount(item_replace.getCount());
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               itemstack.setCount(0);
            }
         }

      }
   }
}
