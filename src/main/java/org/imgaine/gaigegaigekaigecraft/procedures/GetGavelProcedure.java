package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.ThrowingItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

public class GetGavelProcedure {
   public GetGavelProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double set = 0.0;
         boolean successed = false;
         ItemStack item_gavel = ItemStack.EMPTY;
         ItemStack item_a = ItemStack.EMPTY;
         ItemStack old_item = ItemStack.EMPTY;
         ItemStack handItem = ItemStack.EMPTY;
         Entity entity_owner = null;
         item_gavel = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).copy();
         set = 1.0;
         if (!successed) {
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            handItem = var10000.copy();
            if (handItem.getItem() == JujutsucraftModItems.GAVEL.get() || handItem.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || handItem.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || handItem.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
               successed = true;
               set = 0.0;
            }
         }

         if (!successed) {
            AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
            LazyOptional var46 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
            Objects.requireNonNull(_iitemhandlerref);
            var46.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
            if (_iitemhandlerref.get() != null) {
               for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                  int _realidx = _idx;
                  ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                  ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                  if (itemstackiterator.getItem() == JujutsucraftModItems.GAVEL.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || itemstackiterator.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || itemstackiterator.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     successed = true;
                     item_gavel = itemstackiterator.copy().copy();
                     ItemStack _setstack = ItemStack.EMPTY.copy();
                     _setstack.setCount(1);
                     entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null).ifPresent((capability) -> {
                        if (capability instanceof IItemHandlerModifiable _modHandlerEntSetSlot) {
                           _modHandlerEntSetSlot.setStackInSlot(_realidx, _setstack);
                        }

                     });
                     break;
                  }
               }
            }
         }

         if (!successed) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(128.0), (e) -> true)) {
               if (entity != entityiterator) {
                  item_a = ItemStack.EMPTY.copy();
                  if (entityiterator instanceof ItemEntity) {
                     ItemStack var47;
                     if (entityiterator instanceof ItemEntity) {
                        ItemEntity _itemEnt = (ItemEntity)entityiterator;
                        var47 = _itemEnt.getItem();
                     } else {
                        var47 = ItemStack.EMPTY;
                     }

                     item_a = var47.copy().copy();
                  }

                  if (entityiterator instanceof ThrowingItemEntity) {
                     entity_owner = GetEntityFromUUIDProcedure.execute(world, entityiterator.getPersistentData().getString("OWNER_UUID"));
                     if (!(entity_owner instanceof LivingEntity) || entity_owner == entity) {
                        ItemStack var48;
                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entityiterator;
                           var48 = _livEnt.getMainHandItem();
                        } else {
                           var48 = ItemStack.EMPTY;
                        }

                        item_a = var48.copy().copy();
                     }
                  }

                  if (item_a.getItem() == JujutsucraftModItems.GAVEL.get() || item_a.getItem() == JujutsucraftModItems.GAVEL_LONG.get() || item_a.getItem() == JujutsucraftModItems.GAVEL_BIG.get() || item_a.getItem() == JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     if (entityiterator instanceof ThrowingItemEntity && entityiterator instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityiterator;
                        ItemStack _setstack = ItemStack.EMPTY.copy();
                        _setstack.setCount(1);
                        _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.getInventory().setChanged();
                        }
                     }

                     successed = true;
                     item_gavel = item_a.copy();
                     if (!entityiterator.level().isClientSide()) {
                        entityiterator.discard();
                     }
                     break;
                  }
               }
            }
         }

         if (set != 0.0) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound minecraft:entity.item.pickup player @s");
            }

            if (set == 1.0) {
               ItemStack var49;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var49 = _livEnt.getMainHandItem();
               } else {
                  var49 = ItemStack.EMPTY;
               }

               old_item = var49.copy().copy();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = item_gavel.copy();
                  _setstack.setCount(item_gavel.getCount());
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (old_item.getItem() != ItemStack.EMPTY.getItem() && entity instanceof Player) {
                  Player _player = (Player)entity;
                  ItemStack _setstack = old_item.copy();
                  _setstack.setCount(old_item.getCount());
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            } else if (set == 2.0 && entity instanceof Player) {
               Player _player = (Player)entity;
               ItemStack _setstack = item_gavel.copy();
               _setstack.setCount(1);
               ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
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
}
