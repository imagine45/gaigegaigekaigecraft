package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemHandlerHelper;

public class SelectedArmorEquipProcedure {
   public SelectedArmorEquipProcedure() {
   }

   public static void execute(Entity entity, ItemStack armor_chest, ItemStack armor_feet, ItemStack armor_head, ItemStack armor_legs, ItemStack other_item1, ItemStack other_item2, ItemStack weapon_mainhand, ItemStack weapon_offhand) {
      if (entity != null) {
         ItemStack item5_old = ItemStack.EMPTY;
         ItemStack item6_old = ItemStack.EMPTY;
         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(weapon_mainhand).copy();
            _setstack.setCount(Math.max(weapon_mainhand.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(weapon_offhand).copy();
            _setstack.setCount(Math.max(weapon_offhand.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_head).copy();
            _setstack.setCount(Math.max(armor_head.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_chest).copy();
            _setstack.setCount(Math.max(armor_chest.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_legs).copy();
            _setstack.setCount(Math.max(armor_legs.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(armor_feet).copy();
            _setstack.setCount(Math.max(armor_feet.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(other_item1).copy();
            _setstack.setCount(Math.max(other_item1.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            ItemStack _setstack = ReturnSelectedItemProcedure.execute(other_item2).copy();
            _setstack.setCount(Math.max(other_item2.getCount(), 1));
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

      }
   }
}
