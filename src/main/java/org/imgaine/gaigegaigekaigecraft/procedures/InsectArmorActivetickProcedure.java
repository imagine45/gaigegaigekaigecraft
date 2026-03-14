package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
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

public class InsectArmorActivetickProcedure {
   public InsectArmorActivetickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean Player;
         double var10000;
         label282: {
            Player = false;
            boolean kashimo = false;
            ItemStack item_a = ItemStack.f_41583_;
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
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get()).m_19557_();
                  break label282;
               }
            }

            var10000 = 0.0;
         }

         double var39 = var10000;
         if (Player) {
            ItemStack var89;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var89 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var89 = ItemStack.f_41583_;
            }

            if (var89.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
               ItemStack var36 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get())).m_41777_();
               var36.m_41784_().m_128379_("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var89 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var89 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var89.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, var36.m_41777_());
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, var36.m_41777_());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var91 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var91.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(3, itemstackiterator.m_41777_());
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.HEAD, itemstackiterator.m_41777_());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().m_36022_((p) -> itemstackiterator.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                        }
                        break;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var89 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var89 = ItemStack.f_41583_;
            }

            if (var89.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               ItemStack var37 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get())).m_41777_();
               var37.m_41784_().m_128379_("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var89 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var89 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var89.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(2, var37.m_41777_());
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.CHEST, var37.m_41777_());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var94 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var94.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(2, itemstackiterator.m_41777_());
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.CHEST, itemstackiterator.m_41777_());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().m_36022_((p) -> itemstackiterator.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
                        }
                        break;
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var89 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var89 = ItemStack.f_41583_;
            }

            if (var89.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
               ItemStack var38 = (new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get())).m_41777_();
               var38.m_41784_().m_128379_("effect_item", true);
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var89 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                  } else {
                     var89 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var89.m_41777_().m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(1, var38.m_41777_());
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.LEGS, var38.m_41777_());
               }

               AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
               LazyOptional var97 = entity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
               Objects.requireNonNull(_iitemhandlerref);
               var97.ifPresent(_iitemhandlerref::set);
               if (_iitemhandlerref.get() != null) {
                  for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                     ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                     ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx);
                     if (itemstackiterator.m_41720_() == JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(1, itemstackiterator.m_41777_());
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.LEGS, itemstackiterator.m_41777_());
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().m_36022_((p) -> itemstackiterator.m_41720_() == p.m_41720_(), 1, _player.f_36095_.m_39730_());
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
               var98 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var98 = ItemStack.f_41583_;
            }

            if (var98.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_HELMET.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_HELMET.get()));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var98 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var98 = ItemStack.f_41583_;
            }

            if (var98.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_CHESTPLATE.get()));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var98 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var98 = ItemStack.f_41583_;
            }

            if (var98.m_41720_() != JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()));
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.INSECT_ARMOR_LEGGINGS.get()));
               }
            }
         }

         if (!entity.m_6084_()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
            }
         } else {
            label228: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                     var101 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get()).m_19564_();
                     break label228;
                  }
               }

               var101 = 0;
            }

            int var10001;
            label223: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label223;
                  }
               }

               var10001 = 0;
            }

            if (var101 < var10001) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffect var10003;
                     int var10004;
                     int var10005;
                     label216: {
                        var102 = new MobEffectInstance;
                        var10003 = (MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get();
                        var10004 = (int)var39;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10005 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label216;
                           }
                        }

                        var10005 = 0;
                     }

                     var102.<init>(var10003, var10004, var10005, true, true);
                     _entity.m_7292_(var102);
                  }
               }
            }

            label296: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt66 = (LivingEntity)entity;
                  if (_livEnt66.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     break label296;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 2, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 2, 1, false, false));
                  }
               }
            }

            if (entity instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get());
            }
         }

         entity.getPersistentData().m_128379_("canFly", true);
      }
   }
}
