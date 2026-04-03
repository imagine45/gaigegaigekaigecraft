package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class GavelRightClicked2Procedure {
   public GavelRightClicked2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM_A = ItemStack.EMPTY;
         ItemStack ITEM_REPLACE = ItemStack.EMPTY;
         boolean RIGHT_HAND = false;
         boolean success = false;
         ItemStack var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var10000 = _livEnt.getMainHandItem();
         } else {
            var10000 = ItemStack.EMPTY;
         }

         ITEM_A = var10000.copy();
         RIGHT_HAND = true;

         for(int index0 = 0; index0 < 2; ++index0) {
            success = true;
            if (ITEM_A.getItem() == JujutsucraftModItems.GAVEL.get()) {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_LONG.get())).copy();
            } else if (ITEM_A.getItem() == JujutsucraftModItems.GAVEL_LONG.get()) {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_BIG.get())).copy();
            } else if (ITEM_A.getItem() != JujutsucraftModItems.GAVEL_BIG.get() && ITEM_A.getItem() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
               success = false;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getOffhandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               ITEM_A = var10000.copy();
               RIGHT_HAND = false;
            } else {
               ITEM_REPLACE = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).copy();
            }

            if (success) {
               SetAttributeMainhandProcedure.execute(ITEM_REPLACE);
               if (RIGHT_HAND) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = ITEM_REPLACE.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = ITEM_REPLACE.copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getCooldowns().addCooldown(ITEM_A.getItem(), 10);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getCooldowns().addCooldown(ITEM_REPLACE.getItem(), 10);
               }
               break;
            }
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
