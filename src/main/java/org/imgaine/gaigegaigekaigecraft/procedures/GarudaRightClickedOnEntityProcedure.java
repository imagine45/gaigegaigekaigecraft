package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.items.ItemHandlerHelper;

public class GarudaRightClickedOnEntityProcedure {
   public GarudaRightClickedOnEntityProcedure() {
   }

   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity.getPersistentData().getDouble("friend_num") != 0.0 && sourceentity.getPersistentData().getDouble("skill") == 0.0 && entity.getPersistentData().getDouble("friend_num") == sourceentity.getPersistentData().getDouble("friend_num")) {
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)sourceentity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            ItemStack var10000;
            if (sourceentity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)sourceentity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)sourceentity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }
            } else if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
            }

            if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.GARUDA_ITEM.get(), 20);
            }

            if (sourceentity instanceof Player) {
               Player _player = (Player)sourceentity;
               _player.getCooldowns().addCooldown((Item)JujutsucraftModItems.GARUDA_ITEM_BALL.get(), 20);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
