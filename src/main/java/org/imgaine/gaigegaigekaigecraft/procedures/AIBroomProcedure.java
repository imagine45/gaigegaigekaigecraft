package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.NishimiyaMomoEntity;
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
import net.minecraftforge.items.ItemHandlerHelper;

public class AIBroomProcedure {
   public AIBroomProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity owner_uuid = null;
         double y_power = 0.0;
         double z_power = 0.0;
         double NUM2 = 0.0;
         double x_power = 0.0;
         double speed = 0.0;
         double NUM1 = 0.0;
         owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         if (owner_uuid instanceof Player) {
            if (!owner_uuid.isAlive()) {
               if (owner_uuid instanceof Player) {
                  Player _player = (Player)owner_uuid;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            } else if (owner_uuid.getVehicle() != entity) {
               ItemStack var10000;
               if (owner_uuid instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)owner_uuid;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (owner_uuid instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)owner_uuid;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (owner_uuid instanceof Player) {
                  Player _player = (Player)owner_uuid;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.BROOM.get())).copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (!entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (owner_uuid instanceof LivingEntity) {
            entity.getPersistentData().putBoolean("flag_pet", true);
         } else if (entity.getPersistentData().getBoolean("flag_pet") && !entity.level().isClientSide()) {
            entity.discard();
         }

         if (owner_uuid instanceof LivingEntity && (owner_uuid instanceof NishimiyaMomoEntity || ((JujutsucraftModVariables.PlayerVariables)owner_uuid.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 36.0 || ((JujutsucraftModVariables.PlayerVariables)owner_uuid.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 36.0)) {
            AIRideableControlProcedure.execute(entity);
         }

      }
   }
}
