package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
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

public class EntityItemRightClickedOnEntityProcedure {
   public EntityItemRightClickedOnEntityProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         boolean logic_a;
         label614: {
            ItemStack getItem = ItemStack.f_41583_;
            double num1 = 0.0;
            double num2 = 0.0;
            logic_a = false;
            logic_a = false;
            if (!entity.getPersistentData().m_128461_("OWNER_UUID").equals("") && !entity.getPersistentData().m_128461_("OWNER_UUID").equals(sourceentity.m_20149_())) {
               if (!(sourceentity instanceof Player)) {
                  break label614;
               }

               Player _plr = (Player)sourceentity;
               if (!_plr.m_150110_().f_35937_) {
                  break label614;
               }
            }

            logic_a = true;
         }

         double var16 = -200.0;
         if (logic_a && world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), var16, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
            }
         }

         logic_a = false;
         Vec3 _center = new Vec3(entity.m_20185_(), var16, entity.m_20189_());

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
               logic_a = true;
               if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                  entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
               }

               if (!entityiterator.m_9236_().m_5776_()) {
                  entityiterator.m_146870_();
               }
               break;
            }
         }

         if (logic_a) {
            if (entity instanceof EntityItemEntity) {
               EntityItemEntity _datEntL14 = (EntityItemEntity)entity;
               if ((Boolean)_datEntL14.m_20088_().m_135370_(EntityItemEntity.DATA_domain_decoration)) {
                  logic_a = false;
                  if (!sourceentity.getPersistentData().m_128471_("Failed")) {
                     logic_a = true;
                  }

                  var16 = -200.0;
                  if (logic_a && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     Entity entityToSpawn = EntityType.f_20549_.m_262496_(_level, BlockPos.m_274561_(entity.m_20185_(), var16, entity.m_20189_()), MobSpawnType.MOB_SUMMONED);
                     if (entityToSpawn != null) {
                        entityToSpawn.m_146922_(world.m_213780_().m_188501_() * 360.0F);
                     }
                  }

                  logic_a = false;
                  Vec3 _center = new Vec3(entity.m_20185_(), var16, entity.m_20189_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(0.5), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof Bat && entityiterator.m_6084_()) {
                        logic_a = true;
                        if (!entityiterator.m_9236_().m_5776_() && entityiterator.m_20194_() != null) {
                           entityiterator.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entityiterator.m_20182_(), entityiterator.m_20155_(), entityiterator.m_9236_() instanceof ServerLevel ? (ServerLevel)entityiterator.m_9236_() : null, 4, entityiterator.m_7755_().getString(), entityiterator.m_5446_(), entityiterator.m_9236_().m_7654_(), entityiterator), "kill @s");
                        }

                        if (!entityiterator.m_9236_().m_5776_()) {
                           entityiterator.m_146870_();
                        }
                        break;
                     }
                  }

                  if (logic_a) {
                     ItemStack var163;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var163 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var163 = ItemStack.f_41583_;
                     }

                     ItemStack var15 = var163.m_41777_();
                     if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        _player.m_36335_().m_41524_(var15.m_41720_(), 10);
                     }

                     var15.m_41784_().m_128347_("skill", -1.0);
                     var15.m_41784_().m_128347_("COOLDOWN_TICKS", -1.0);
                     var16 = 0.0;
                     AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference();
                     LazyOptional var164 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var164.ifPresent(_iitemhandlerref::set);
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                           if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") > 0.0) {
                              ++var16;
                           }
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr35 = (ServerPlayer)entity;
                        if (_plr35.m_9236_() instanceof ServerLevel && _plr35.m_8960_().m_135996_(_plr35.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"))).m_8193_()) {
                           ++var16;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr36 = (ServerPlayer)entity;
                        if (_plr36.m_9236_() instanceof ServerLevel && _plr36.m_8960_().m_135996_(_plr36.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_dhruv_lakdawalla"))).m_8193_()) {
                           ++var16;
                        }
                     }

                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _plr37 = (ServerPlayer)entity;
                        if (_plr37.m_9236_() instanceof ServerLevel && _plr37.m_8960_().m_135996_(_plr37.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"))).m_8193_()) {
                           ++var16;
                        }
                     }

                     double var21 = Math.ceil(Math.random() * var16);
                     var16 = 0.0;
                     logic_a = false;
                     _iitemhandlerref = new AtomicReference();
                     var164 = sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, (Direction)null);
                     Objects.requireNonNull(_iitemhandlerref);
                     var164.ifPresent(_iitemhandlerref::set);
                     if (_iitemhandlerref.get() != null) {
                        for(int _idx = 0; _idx < ((IItemHandler)_iitemhandlerref.get()).getSlots(); ++_idx) {
                           ItemStack itemstackiterator = ((IItemHandler)_iitemhandlerref.get()).getStackInSlot(_idx).m_41777_();
                           if (itemstackiterator.m_41720_() == JujutsucraftModItems.COPIED_CURSED_TECHNIQUE.get() && itemstackiterator.m_41784_().m_128459_("skill") > 0.0) {
                              ++var16;
                              if (var16 >= var21) {
                                 logic_a = true;
                                 var15.m_41714_(Component.m_237113_(itemstackiterator.m_41611_().getString()));
                                 var15.m_41784_().m_128347_("skill", itemstackiterator.m_41784_().m_128459_("skill"));
                                 var15.m_41784_().m_128347_("COOLDOWN_TICKS", itemstackiterator.m_41784_().m_128459_("COOLDOWN_TICKS"));
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
                                 if (_plr52.m_9236_() instanceof ServerLevel && _plr52.m_8960_().m_135996_(_plr52.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_cursed_speech"))).m_8193_()) {
                                    var15.m_41714_(Component.m_237113_(Component.m_237115_("jujutsu.technique.dont_move").getString()));
                                    var15.m_41784_().m_128347_("skill", 308.0);
                                    var15.m_41784_().m_128347_("COOLDOWN_TICKS", 150.0);
                                    break;
                                 }
                              }
                           } else if (var16 == 2.0) {
                              if (entity instanceof ServerPlayer) {
                                 ServerPlayer _plr57 = (ServerPlayer)entity;
                                 if (_plr57.m_9236_() instanceof ServerLevel && _plr57.m_8960_().m_135996_(_plr57.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_dhruv_lakdawalla"))).m_8193_()) {
                                    var15.m_41714_(Component.m_237113_(Component.m_237115_("advancements.skill_copy_dhruv_lakdawalla.title").getString()));
                                    var15.m_41784_().m_128347_("skill", 506.0);
                                    var15.m_41784_().m_128347_("COOLDOWN_TICKS", 120.0);
                                    break;
                                 }
                              }
                           } else if (var16 == 3.0 && entity instanceof ServerPlayer) {
                              ServerPlayer _plr62 = (ServerPlayer)entity;
                              if (_plr62.m_9236_() instanceof ServerLevel && _plr62.m_8960_().m_135996_(_plr62.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_copy_takako_uro"))).m_8193_()) {
                                 var15.m_41714_(Component.m_237113_(Component.m_237115_("advancements.skill_copy_takako_uro.title").getString()));
                                 var15.m_41784_().m_128347_("skill", 507.0);
                                 var15.m_41784_().m_128347_("COOLDOWN_TICKS", 200.0);
                                 break;
                              }
                           }
                        }
                     }

                     ItemStack var166;
                     if (sourceentity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)sourceentity;
                        var166 = _livEnt.m_21205_();
                     } else {
                        var166 = ItemStack.f_41583_;
                     }

                     if (var166.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                        if (sourceentity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)sourceentity;
                           ItemStack _setstack = var15.m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }
                     } else if (sourceentity instanceof Player) {
                        Player _player = (Player)sourceentity;
                        ItemStack _setstack = var15.m_41777_();
                        _setstack.m_41764_(1);
                        ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
                     }

                     if (!entity.m_9236_().m_5776_()) {
                        entity.m_146870_();
                        return;
                     }
                  }

                  return;
               }
            }

            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label587: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label587;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var134 = _player.m_36335_();
                     ItemStack var10001;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10001 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10001 = ItemStack.f_41583_;
                     }

                     Item var167 = var10001.m_41720_();
                     ItemStack var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10002 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10002 = ItemStack.f_41583_;
                     }

                     var134.m_41524_(var167, var10002.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label577: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label577;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var139 = _player.m_36335_();
                     ItemStack var168;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var168 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var168 = ItemStack.f_41583_;
                     }

                     Item var169 = var168.m_41720_();
                     ItemStack var178;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var178 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var178 = ItemStack.f_41583_;
                     }

                     var139.m_41524_(var169, var178.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label567: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label567;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var144 = _player.m_36335_();
                     ItemStack var170;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var170 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                     } else {
                        var170 = ItemStack.f_41583_;
                     }

                     Item var171 = var170.m_41720_();
                     ItemStack var179;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var179 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                     } else {
                        var179 = ItemStack.f_41583_;
                     }

                     var144.m_41524_(var171, var179.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label557: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label557;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var149 = _player.m_36335_();
                     ItemStack var172;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var172 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                     } else {
                        var172 = ItemStack.f_41583_;
                     }

                     Item var173 = var172.m_41720_();
                     ItemStack var180;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var180 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                     } else {
                        var180 = ItemStack.f_41583_;
                     }

                     var149.m_41524_(var173, var180.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var10000 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21205_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label547: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label547;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var154 = _player.m_36335_();
                     ItemStack var174;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var174 = _livEnt.m_21205_();
                     } else {
                        var174 = ItemStack.f_41583_;
                     }

                     Item var175 = var174.m_41720_();
                     ItemStack var181;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var181 = _livEnt.m_21205_();
                     } else {
                        var181 = ItemStack.f_41583_;
                     }

                     var154.m_41524_(var175, var181.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21205_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21205_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var10000 = _livEnt.m_21206_();
            } else {
               var10000 = ItemStack.f_41583_;
            }

            if (var10000.m_41720_() != ItemStack.f_41583_.m_41720_()) {
               label537: {
                  if (sourceentity instanceof Player) {
                     Player _plr = (Player)sourceentity;
                     if (_plr.m_150110_().f_35937_) {
                        break label537;
                     }
                  }

                  if (sourceentity instanceof Player) {
                     Player _player = (Player)sourceentity;
                     ItemCooldowns var159 = _player.m_36335_();
                     ItemStack var176;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var176 = _livEnt.m_21206_();
                     } else {
                        var176 = ItemStack.f_41583_;
                     }

                     Item var177 = var176.m_41720_();
                     ItemStack var182;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var182 = _livEnt.m_21206_();
                     } else {
                        var182 = ItemStack.f_41583_;
                     }

                     var159.m_41524_(var177, var182.m_41720_() == JujutsucraftModItems.NYOI_STAFF.get() ? 400 : 10);
                  }
               }

               if (sourceentity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)sourceentity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               if (var10000.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                  if (sourceentity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)sourceentity;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10000 = _livEnt.m_21206_();
                     } else {
                        var10000 = ItemStack.f_41583_;
                     }

                     ItemStack _setstack = var10000.m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               } else if (sourceentity instanceof Player) {
                  Player _player = (Player)sourceentity;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10000 = _livEnt.m_21206_();
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var10000.m_41777_();
                  _setstack.m_41764_(1);
                  ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
               }
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         }

      }
   }
}
