package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import net.minecraftforge.common.util.NonNullConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityItemEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

public class EntityItemRightClickedOnEntityProcedure {
   public EntityItemRightClickedOnEntityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean logic_a;
         label614: {
            ItemStack getItem = ItemStack.EMPTY;
            double num1 = 0.0;
            double num2 = 0.0;
            logic_a = false;
            logic_a = false;
            if (!entity.getPersistentData().getString("OWNER_UUID").equals("") && !entity.getPersistentData().getString("OWNER_UUID").equals(sourceentity.getStringUUID())) {
               if (!(sourceentity instanceof Player)) {
                  break label614;
               }

               Player _plr = (Player)sourceentity;
               if (!_plr.getAbilities().instabuild) {
                  break label614;
               }
            }

            logic_a = true;
         }

         double var16 = -200.0;
         if (logic_a && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(entity.getX(), var16, entity.getZ()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
            }
         }

         logic_a = false;
         Vec3 _center = new Vec3(entity.getX(), var16, entity.getZ());

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
            if (entityiterator instanceof Bat && entityiterator.isAlive()) {
               logic_a = true;
               if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                  entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
               }

               if (!entityiterator.level().isClientSide()) {
                  entityiterator.discard();
               }
               break;
            }
         }

         if (logic_a) {
            if (entity instanceof EntityItemEntity) {
               EntityItemEntity _datEntL14 = (EntityItemEntity)entity;
               if ((Boolean)_datEntL14.getEntityData().get(EntityItemEntity.DATA_domain_decoration)) {
                  logic_a = false;
                  if (!sourceentity.getPersistentData().getBoolean("Failed")) {
                     logic_a = true;
                  }

                  var16 = -200.0;
                  if (logic_a && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(entity.getX(), var16, entity.getZ()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.setYRot(world.getRandom().nextFloat() * 360.0F);
                     }
                  }

                  logic_a = false;
                  _center = new Vec3(entity.getX(), var16, entity.getZ());

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                     if (entityiterator instanceof Bat && entityiterator.isAlive()) {
                        logic_a = true;
                        if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                           entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                        }

                        if (!entityiterator.level().isClientSide()) {
                           entityiterator.discard();
                        }
                        break;
                     }
                  }

                  if (logic_a) {
                     ItemStack var163;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var163 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var163 = ItemStack.EMPTY;
                     }

                     ItemStack var15 = var163.copy();
                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        _player.getCooldowns().addCooldown(var15.getItem(), 10);
                     }

                     var15.getOrCreateTag().putDouble("skill", -1.0);
                     var15.getOrCreateTag().putDouble("COOLDOWN_TICKS", -1.0);
                     var16 = 0.0;
                     final AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                     LazyOptional var164 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var164.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref.set(o);
                     }
                  });
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                           if (itemstackiterator.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.getOrCreateTag().getDouble("skill") > 0.0) {
                              ++var16;
                           }
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr35 = (ServerPlayer)entity;
                        if (_plr35.level() instanceof ServerLevel && _plr35.getAdvancements().getOrStartProgress(_plr35.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_cursed_speech"))).isDone()) {
                           ++var16;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr36 = (ServerPlayer)entity;
                        if (_plr36.level() instanceof ServerLevel && _plr36.getAdvancements().getOrStartProgress(_plr36.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_dhruv_lakdawalla"))).isDone()) {
                           ++var16;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr37 = (ServerPlayer)entity;
                        if (_plr37.level() instanceof ServerLevel && _plr37.getAdvancements().getOrStartProgress(_plr37.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_takako_uro"))).isDone()) {
                           ++var16;
                        }
                     }

                     double var21 = Math.ceil(Math.random() * var16);
                     var16 = 0.0;
                     logic_a = false;
                     java.util.concurrent.atomic.AtomicReference<IItemHandler> _iitemhandlerref2 = new AtomicReference();
                     var164 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var164.ifPresent(new NonNullConsumer<IItemHandler>() {
                     @Override
                     public void accept(@NotNull IItemHandler o) {
                        _iitemhandlerref2.set(o);
                     }
                  });
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).copy();
                           if (itemstackiterator.getItem() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.getOrCreateTag().getDouble("skill") > 0.0) {
                              ++var16;
                              if (var16 >= var21) {
                                 logic_a = true;
                                 var15.setHoverName(Component.literal(itemstackiterator.getDisplayName().getString()));
                                 var15.getOrCreateTag().putDouble("skill", itemstackiterator.getOrCreateTag().getDouble("skill"));
                                 var15.getOrCreateTag().putDouble("COOLDOWN_TICKS", itemstackiterator.getOrCreateTag().getDouble("COOLDOWN_TICKS"));
                                 break;
                              }
                           }
                        }
                     }

                     if (!logic_a) {
                        for(int index0 = 0; index0 < 10000; ++index0) {
                           var16 = Math.ceil(Math.random() * 3.0);
                           if (var16 == 1.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr52 = (ServerPlayer)entity;
                                 if (_plr52.level() instanceof ServerLevel && _plr52.getAdvancements().getOrStartProgress(_plr52.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_cursed_speech"))).isDone()) {
                                    var15.setHoverName(Component.literal(Component.translatable("jujutsu.technique.dont_move").getString()));
                                    var15.getOrCreateTag().putDouble("skill", 308.0);
                                    var15.getOrCreateTag().putDouble("COOLDOWN_TICKS", 150.0);
                                    break;
                                 }
                              }
                           } else if (var16 == 2.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr57 = (ServerPlayer)entity;
                                 if (_plr57.level() instanceof ServerLevel && _plr57.getAdvancements().getOrStartProgress(_plr57.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_dhruv_lakdawalla"))).isDone()) {
                                    var15.setHoverName(Component.literal(Component.translatable("advancements.skill_copy_dhruv_lakdawalla.title").getString()));
                                    var15.getOrCreateTag().putDouble("skill", 506.0);
                                    var15.getOrCreateTag().putDouble("COOLDOWN_TICKS", 120.0);
                                    break;
                                 }
                              }
                           } else if (var16 == 3.0 && entity instanceof ServerPlayer) {
                              ServerPlayer _plr62 = (ServerPlayer)entity;
                              if (_plr62.level() instanceof ServerLevel && _plr62.getAdvancements().getOrStartProgress(_plr62.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_copy_takako_uro"))).isDone()) {
                                 var15.setHoverName(Component.literal(Component.translatable("advancements.skill_copy_takako_uro.title").getString()));
                                 var15.getOrCreateTag().putDouble("skill", 507.0);
                                 var15.getOrCreateTag().putDouble("COOLDOWN_TICKS", 200.0);
                                 break;
                              }
                           }
                        }
                     }

                     ItemStack var166;
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var166 = _livEnt.getMainHandItem();
                     } else {
                        var166 = ItemStack.EMPTY;
                     }

                     if (var166.getItem() == ItemStack.EMPTY.getItem()) {
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)sourceentity;
                           ItemStack _setstack = var15.copy();
                           _setstack.setCount(1);
                           _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.getInventory().setChanged();
                           }
                        }
                     } else if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        ItemStack _setstack = var15.copy();
                        _setstack.setCount(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (!entity.level().isClientSide()) {
                        entity.discard();
                        return;
                     }
                  }

                  return;
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label587: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label587;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var134 = _player.getCooldowns();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10001 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10001 = ItemStack.EMPTY;
                     }

                     Item var167 = var10001.getItem();
                     ItemStack var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10002 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10002 = ItemStack.EMPTY;
                     }

                     var134.addCooldown(var167, var10002.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label577: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label577;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var139 = _player.getCooldowns();
                     ItemStack var168;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var168 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var168 = ItemStack.EMPTY;
                     }

                     Item var169 = var168.getItem();
                     ItemStack var178;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var178 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var178 = ItemStack.EMPTY;
                     }

                     var139.addCooldown(var169, var178.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label567: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label567;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var144 = _player.getCooldowns();
                     ItemStack var170;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var170 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                     } else {
                        var170 = ItemStack.EMPTY;
                     }

                     Item var171 = var170.getItem();
                     ItemStack var179;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var179 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                     } else {
                        var179 = ItemStack.EMPTY;
                     }

                     var144.addCooldown(var171, var179.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label557: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label557;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var149 = _player.getCooldowns();
                     ItemStack var172;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var172 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                     } else {
                        var172 = ItemStack.EMPTY;
                     }

                     Item var173 = var172.getItem();
                     ItemStack var180;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var180 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                     } else {
                        var180 = ItemStack.EMPTY;
                     }

                     var149.addCooldown(var173, var180.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getMainHandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label547: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label547;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var154 = _player.getCooldowns();
                     ItemStack var174;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var174 = _livEnt.getMainHandItem();
                     } else {
                        var174 = ItemStack.EMPTY;
                     }

                     Item var175 = var174.getItem();
                     ItemStack var181;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var181 = _livEnt.getMainHandItem();
                     } else {
                        var181 = ItemStack.EMPTY;
                     }

                     var154.addCooldown(var175, var181.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getMainHandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getMainHandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.getOffhandItem();
            } else {
               var10000 = ItemStack.EMPTY;
            }

            if (var10000.getItem() != ItemStack.EMPTY.getItem()) {
               label537: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.getAbilities().instabuild) {
                        break label537;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var159 = _player.getCooldowns();
                     ItemStack var176;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var176 = _livEnt.getOffhandItem();
                     } else {
                        var176 = ItemStack.EMPTY;
                     }

                     Item var177 = var176.getItem();
                     ItemStack var182;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var182 = _livEnt.getOffhandItem();
                     } else {
                        var182 = ItemStack.EMPTY;
                     }

                     var159.addCooldown(var177, var182.getItem() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               if (var10000.getItem() == ItemStack.EMPTY.getItem()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.getOffhandItem();
                     } else {
                        var10000 = ItemStack.EMPTY;
                     }

                     ItemStack _setstack = var10000.copy();
                     _setstack.setCount(1);
                     _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.getInventory().setChanged();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.getOffhandItem();
                  } else {
                     var10000 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var10000.copy();
                  _setstack.setCount(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
