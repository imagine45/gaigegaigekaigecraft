package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
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

public class InsectArmorActivetickProcedure {
   public InsectArmorActivetickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player;
         double var10000;
         label286: {
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
            Entity entity_a = null;
            Player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get()).getDuration();
                  break label286;
               }
            }

            var10000 = 0.0;
         }

         double var39 = var10000;
         if (var39 % 10.0 == 0.0) {
            if (Player) {
               ItemStack var89;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var89 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var89 = ItemStack.EMPTY;
               }

               if (var89.getItem() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
                  ItemStack var36 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get())).copy();
                  var36.getOrCreateTag().putBoolean("effect_item", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var89 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var89 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var89.copy().copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, var36.copy());
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, var36.copy());
                  }

                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var91 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var91.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                        if (itemstackiterator.getItem() == JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
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
                  var89 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var89 = ItemStack.EMPTY;
               }

               if (var89.getItem() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
                  ItemStack var37 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get())).copy();
                  var37.getOrCreateTag().putBoolean("effect_item", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var89 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var89 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var89.copy().copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, var37.copy());
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, var37.copy());
                  }

                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var94 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var94.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                        if (itemstackiterator.getItem() == JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
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
                  var89 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
               } else {
                  var89 = ItemStack.EMPTY;
               }

               if (var89.getItem() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
                  ItemStack var38 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get())).copy();
                  var38.getOrCreateTag().putBoolean("effect_item", true);
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var89 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                     } else {
                        var89 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var89.copy().copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, var38.copy());
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, var38.copy());
                  }

                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var97 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var97.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                        if (itemstackiterator.getItem() == JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
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
               ItemStack var98;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var98 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var98 = ItemStack.EMPTY;
               }

               if (var98.getItem() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get()));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var98 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var98 = ItemStack.EMPTY;
               }

               if (var98.getItem() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var98 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
               } else {
                  var98 = ItemStack.EMPTY;
               }

               if (var98.getItem() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()));
                  }
               }
            }
         }

         if (!entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
            }
         } else {
            label298: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt61 = (LivingEntity)entity;
                  if (_livEnt61.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label298;
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

            if (var39 % 10.0 == 0.0) {
               int var101;
               label225: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                        var101 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get()).getAmplifier();
                        break label225;
                     }
                  }

                  var101 = 0;
               }

               int var10001;
               label220: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label220;
                     }
                  }

                  var10001 = 0;
               }

               if (var101 < var10001) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        MobEffect var10003;
                        int var10004;
                        int var10005;
                        MobEffectInstance var102;
                        label213: {
                           var10003 = (MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get();
                           var10004 = (int)var39;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label213;
                              }
                           }

                           var10005 = 0;
                        }

                        var102 = new MobEffectInstance(var10003, var10004, var10005, true, true);
                        _entity.addEffect(var102);
                     }
                  }
               }

               if (entity instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
               }
            }
         }

         entity.getPersistentData().putBoolean("canFly", true);
      }
   }
}
