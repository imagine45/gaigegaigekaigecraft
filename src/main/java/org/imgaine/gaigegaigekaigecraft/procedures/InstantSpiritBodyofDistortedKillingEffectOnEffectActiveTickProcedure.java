package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

public class InstantSpiritBodyofDistortedKillingEffectOnEffectActiveTickProcedure {
   public InstantSpiritBodyofDistortedKillingEffectOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player;
         double var10000;
         label274: {
            Player = false;
            boolean kashimo = false;
            ItemStack item_a = ItemStack.EMPTY;
            double amount = 0.0;
            double x_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double yaw_fix = 0.0;
            double loop_num = 0.0;
            double width = 0.0;
            double pitch = 0.0;
            double y_pos = 0.0;
            double height = 0.0;
            double tick = 0.0;
            Player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get()).getDuration();
                  break label274;
               }
            }

            var10000 = 0.0;
         }

         double var38 = var10000;
         if (Player) {
            ItemStack var87;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var87 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var87 = ItemStack.EMPTY;
            }

            if (var87.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get()) {
               ItemStack var35 = (new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get())).copy();
               var35.getOrCreateTag().putBoolean("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var87 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var87 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var87.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, var35.copy());
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, var35.copy());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var89 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var89.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(3, itemstackiterator.copy());
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.HEAD, itemstackiterator.copy());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().clearOrCountMatchingItems((p) -> itemstackiterator.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                        break;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var87 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var87 = ItemStack.EMPTY;
            }

            if (var87.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get()) {
               ItemStack var36 = (new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get())).copy();
               var36.getOrCreateTag().putBoolean("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var87 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var87 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var87.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(2, var36.copy());
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.CHEST, var36.copy());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var92 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var92.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(2, itemstackiterator.copy());
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.CHEST, itemstackiterator.copy());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().clearOrCountMatchingItems((p) -> itemstackiterator.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                        break;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var87 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var87 = ItemStack.EMPTY;
            }

            if (var87.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
               ItemStack var37 = (new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get())).copy();
               var37.getOrCreateTag().putBoolean("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var87 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                  } else {
                     var87 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var87.copy().copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(1, var37.copy());
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.LEGS, var37.copy());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var95 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var95.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                     if (itemstackiterator.getItem() == JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(1, itemstackiterator.copy());
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.LEGS, itemstackiterator.copy());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().clearOrCountMatchingItems((p) -> itemstackiterator.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
                        }
                        break;
                     }
                  }
               }
            }
         } else {
            ItemStack var96;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var96 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var96 = ItemStack.EMPTY;
            }

            if (var96.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_HELMET.get()));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var96 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var96 = ItemStack.EMPTY;
            }

            if (var96.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_CHESTPLATE.get()));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var96 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var96 = ItemStack.EMPTY;
            }

            if (var96.getItem() != JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()));
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.ARMOR_INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_LEGGINGS.get()));
               }
            }
         }

         if (!entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get());
            }
         } else {
            int var99;
            label220: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                     var99 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get()).getAmplifier();
                     break label220;
                  }
               }

               var99 = 0;
            }

            int var10001;
            label215: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label215;
                  }
               }

               var10001 = 0;
            }

            if (var99 < var10001) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffect var10003;
                     int var10004;
                     int var10005;
                     MobEffectInstance var100;
                     label208: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get();
                        var10004 = (int)var38;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label208;
                           }
                        }

                        var10005 = 0;
                     }

                     var100 = new MobEffectInstance(var10003, var10004, var10005, true, true);
                     _entity.addEffect(var100);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt66 = (LivingEntity)entity;
               if (_livEnt66.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 2, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 2, 1, false, false));
               }
            }
         }

      }
   }
}
