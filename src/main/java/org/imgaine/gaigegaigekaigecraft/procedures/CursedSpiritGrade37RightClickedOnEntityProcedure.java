package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.items.ItemHandlerHelper;

public class CursedSpiritGrade37RightClickedOnEntityProcedure {
   public CursedSpiritGrade37RightClickedOnEntityProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof TamableAnimal) {
            TamableAnimal _toTame = (TamableAnimal)entity;
            if (sourceentity instanceof Player) {
               Player _owner = (Player)sourceentity;
               _toTame.tame(_owner);
            }
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
               ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get())).copy();
               _setstack.setCount(1);
               _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
               if (_entity instanceof Player) {
                  Player _player = (Player)_entity;
                  _player.getInventory().setChanged();
               }
            }
         } else if (sourceentity instanceof Player) {
            Player _player = (Player)sourceentity;
            ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.CURSED_SPIRIT_ARMOURY_CHESTPLATE.get())).copy();
            _setstack.setCount(1);
            ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
         }

         CursedSpiritGrade37EntityDiesProcedure.execute(world, x, y, z);
         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
