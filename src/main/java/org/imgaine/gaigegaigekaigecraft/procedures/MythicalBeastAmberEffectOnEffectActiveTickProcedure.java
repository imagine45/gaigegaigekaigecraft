package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.KashimoHajimeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
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

public class MythicalBeastAmberEffectOnEffectActiveTickProcedure {
   public MythicalBeastAmberEffectOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean kashimo = false;
         ItemStack item_a = ItemStack.EMPTY;
         double range = 0.0;
         double tick = 0.0;
         if (entity.isAlive()) {
            double var10000;
            label196: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()).getDuration();
                     break label196;
                  }
               }

               var10000 = 0.0;
            }

            tick = var10000;
            kashimo = entity instanceof KashimoHajimeEntity;
            Player = entity instanceof Player;
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 5, 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 219, 1, false, false));
               }
            }
            int var47;
            label188: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                     var47 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get()).getAmplifier();
                     break label188;
                  }
               }

               var47 = 0;
            }

            int var10001;
            label183: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label183;
                  }
               }

               var10001 = 0;
            }

            if (var47 < var10001) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffect var10003;
                     int var10004;
                     int var10005;
                     MobEffectInstance var54;
                     label176: {
                        var10003 = (MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get();
                        var10004 = (int)tick;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label176;
                           }
                        }

                        var10005 = 0;
                     }

                     var54 = new MobEffectInstance(var10003, var10004, var10005, true, true);
                     _entity.addEffect(var54);
                  }
               }
            }

            if (Player) {
               if (entity.tickCount % 10 == 0) {
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange -= 10.0;
                     if (capability.PlayerCursePower + capability.PlayerCursePowerChange <= 0.0 && entity instanceof LivingEntity _entity) {
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
                     }

                  });
               }
            } else {
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

            if (Player) {
               ItemStack var51;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var51 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var51 = ItemStack.EMPTY;
               }

               if (var51.getItem() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
                  item_a = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).copy();
                  AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                  LazyOptional var52 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                  Objects.requireNonNull(_iitemhandlerref);
                  var52.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                  if (_iitemhandlerref.get() != null) {
                     for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                        ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                        ItemStack _itemstack = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                        if (_itemstack.getItem() == JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && (!_itemstack.getOrCreateTag().contains("hand") || !_itemstack.getOrCreateTag().getBoolean("hand")) && _itemstack.getOrCreateTag().contains("effect_item") && _itemstack.getOrCreateTag().getBoolean("effect_item")) {
                           item_a = _itemstack.copy();
                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.getInventory().clearOrCountMatchingItems((p) -> _itemstack.getItem() == p.getItem(), _itemstack.getCount(), _player.inventoryMenu.getCraftSlots());
                           }
                           break;
                        }
                     }
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     ItemStack var53;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var53 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var53 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var53.copy().copy();
                     _setstack.setCount(1);
                     ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, item_a);
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, item_a);
                  }
               }
            } else {
               ItemStack var48;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var48 = _livEnt.getMainHandItem();
               } else {
                  var48 = ItemStack.EMPTY;
               }

               if (var48.getItem() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var48 = _livEnt.getOffhandItem();
               } else {
                  var48 = ItemStack.EMPTY;
               }

               if (var48.getItem() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get() && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get())).copy();
                  _setstack.setCount(1);
                  _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var48 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
               } else {
                  var48 = ItemStack.EMPTY;
               }

               if (var48.getItem() != JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getInventory().armor.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()));
                     _player.getInventory().setChanged();
                  } else if (entity instanceof LivingEntity) {
                     LivingEntity _living = (LivingEntity)entity;
                     _living.setItemSlot(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MYTHICAL_BEAST_AMBER_HELMET.get()));
                  }
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               range = ReturnEntitySizeProcedure.execute(entity);
               ParticleGeneratorCircleProcedure.execute(world, 1.0 * range, 90.0, 0.5 * range, 0.75 * range, 0.75 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), Math.random() < 0.75 ? "gaigegaigekaigecraft:particle_flame_purple" : "gaigegaigekaigecraft:particle_thunder_purple");
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get());
         }

      }
   }
}
