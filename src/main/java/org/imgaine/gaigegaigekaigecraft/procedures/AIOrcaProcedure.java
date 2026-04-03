package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class AIOrcaProcedure {
   public AIOrcaProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double y_velocity = 0.0;
         double x_velocity = 0.0;
         double z_velocity = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            LivingEntity var10000;
            if (entity instanceof TamableAnimal) {
               TamableAnimal _tamEnt = (TamableAnimal)entity;
               var10000 = _tamEnt.getOwner();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               LivingEntity var10001;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.getOwner();
               } else {
                  var10001 = null;
               }

               entity.setShiftKeyDown(((Entity)var10001).isShiftKeyDown());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.getOwner();
               } else {
                  var10001 = null;
               }

               entity.setSprinting(((Entity)var10001).isSprinting());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10000 = _tamEnt.getOwner();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).isOnFire()) {
                  entity.setSecondsOnFire(1);
               } else {
                  entity.clearFire();
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var148 = _player.getInventory().armor;
                  LivingEntity var10002;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10002 = _tamEnt.getOwner();
                  } else {
                     var10002 = null;
                  }

                  LivingEntity var15 = var10002;
                  ItemStack var192;
                  if (var15 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var15;
                     var192 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var192 = ItemStack.EMPTY;
                  }

                  var148.set(3, var192);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var176 = EquipmentSlot.HEAD;
                  LivingEntity var193;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var193 = _tamEnt.getOwner();
                  } else {
                     var193 = null;
                  }

                  LivingEntity var122 = var193;
                  ItemStack var194;
                  if (var122 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var122;
                     var194 = _entGetArmor.getItemBySlot(EquipmentSlot.HEAD);
                  } else {
                     var194 = ItemStack.EMPTY;
                  }

                  _living.setItemSlot(var176, var194);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var149 = _player.getInventory().armor;
                  LivingEntity var195;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var195 = _tamEnt.getOwner();
                  } else {
                     var195 = null;
                  }

                  LivingEntity var123 = var195;
                  ItemStack var196;
                  if (var123 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var123;
                     var196 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var196 = ItemStack.EMPTY;
                  }

                  var149.set(2, var196);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var177 = EquipmentSlot.CHEST;
                  LivingEntity var197;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var197 = _tamEnt.getOwner();
                  } else {
                     var197 = null;
                  }

                  LivingEntity var124 = var197;
                  ItemStack var198;
                  if (var124 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var124;
                     var198 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                  } else {
                     var198 = ItemStack.EMPTY;
                  }

                  _living.setItemSlot(var177, var198);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var150 = _player.getInventory().armor;
                  LivingEntity var199;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var199 = _tamEnt.getOwner();
                  } else {
                     var199 = null;
                  }

                  LivingEntity var125 = var199;
                  ItemStack var200;
                  if (var125 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var125;
                     var200 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                  } else {
                     var200 = ItemStack.EMPTY;
                  }

                  var150.set(1, var200);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var178 = EquipmentSlot.LEGS;
                  LivingEntity var201;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var201 = _tamEnt.getOwner();
                  } else {
                     var201 = null;
                  }

                  LivingEntity var126 = var201;
                  ItemStack var202;
                  if (var126 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var126;
                     var202 = _entGetArmor.getItemBySlot(EquipmentSlot.LEGS);
                  } else {
                     var202 = ItemStack.EMPTY;
                  }

                  _living.setItemSlot(var178, var202);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var151 = _player.getInventory().armor;
                  LivingEntity var203;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var203 = _tamEnt.getOwner();
                  } else {
                     var203 = null;
                  }

                  LivingEntity var127 = var203;
                  ItemStack var204;
                  if (var127 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var127;
                     var204 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                  } else {
                     var204 = ItemStack.EMPTY;
                  }

                  var151.set(0, var204);
                  _player.getInventory().setChanged();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var179 = EquipmentSlot.FEET;
                  LivingEntity var205;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var205 = _tamEnt.getOwner();
                  } else {
                     var205 = null;
                  }

                  LivingEntity var128 = var205;
                  ItemStack var206;
                  if (var128 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var128;
                     var206 = _entGetArmor.getItemBySlot(EquipmentSlot.FEET);
                  } else {
                     var206 = ItemStack.EMPTY;
                  }

                  _living.setItemSlot(var179, var206);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10000 = _tamEnt.getOwner();
                  } else {
                     var10000 = null;
                  }

                  TamableAnimal _tamEnt = (TamableAnimal)var10000;
                  ItemStack var153;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var153 = _livEnt.getMainHandItem();
                  } else {
                     var153 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var153.copy();
                  if (entity instanceof TamableAnimal) {
                     _tamEnt = (TamableAnimal)entity;
                     var10001 = _tamEnt.getOwner();
                  } else {
                     var10001 = null;
                  }

                  _tamEnt = (TamableAnimal) var10001;
                  ItemStack var181;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var181 = _livEnt.getMainHandItem();
                  } else {
                     var181 = ItemStack.EMPTY;
                  }

                  _setstack.setCount(var181.getCount());
                  _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10000 = _tamEnt.getOwner();
                  } else {
                     var10000 = null;
                  }

                  TamableAnimal _tamEnt = (TamableAnimal) var10000;
                  ItemStack var155;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var155 = _livEnt.getOffhandItem();
                  } else {
                     var155 = ItemStack.EMPTY;
                  }

                  ItemStack _setstack = var155.copy();
                  if (entity instanceof TamableAnimal) {
                     _tamEnt = (TamableAnimal)entity;
                     var10001 = _tamEnt.getOwner();
                  } else {
                     var10001 = null;
                  }

                  _tamEnt = (TamableAnimal) var10001;
                  ItemStack var183;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var183 = _livEnt.getOffhandItem();
                  } else {
                     var183 = ItemStack.EMPTY;
                  }

                  _setstack.setCount(var183.getCount());
                  _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.getInventory().setChanged();
                  }
               }

               CompoundTag var156 = entity.getPersistentData();
               LivingEntity var207;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.getOwner();
               } else {
                  var207 = null;
               }

               var156.putBoolean("PRESS_Z", ((Entity)var207).getPersistentData().getBoolean("PRESS_Z"));
               LivingEntity var157;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.getOwner();
               } else {
                  var157 = null;
               }

               label600: {
                  LivingEntity _livEnt42 = var157;
                  if (_livEnt42 instanceof LivingEntity) {
                     LivingEntity _livEnt41 = _livEnt42;
                     if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt42 = (LivingEntity)entity;
                           if (_livEnt42.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label600;
                           }
                        }

                        CompoundTag var158 = entity.getPersistentData();
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var207 = _tamEnt.getOwner();
                        } else {
                           var207 = null;
                        }

                        var158.putDouble("skill", ((Entity)var207).getPersistentData().getDouble("skill"));
                        ResetCounterProcedure.execute(entity);
                        if (!(entity instanceof LivingEntity)) {
                           break label600;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.level().isClientSide()) {
                           break label600;
                        }

                        MobEffectInstance var184;
                        MobEffect var10003 = (MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get();
                        LivingEntity var10004;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var10004 = _tamEnt.getOwner();
                        } else {
                           var10004 = null;
                        }
                        int var217;
                        label593: {
                           LivingEntity var18 = var10004;
                           if (var18 instanceof LivingEntity) {
                              LivingEntity _livEnt = var18;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                 var217 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getDuration();
                                 break label593;
                              }
                           }

                           var217 = 0;
                        }

                        LivingEntity var10005;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var10005 = _tamEnt.getOwner();
                        } else {
                           var10005 = null;
                        }
                        int var228;
                        label587: {
                           LivingEntity var142 = var10005;
                           if (var142 instanceof LivingEntity) {
                              LivingEntity _livEnt = var142;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                 var228 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).getAmplifier();
                                 break label587;
                              }
                           }

                           var228 = 0;
                        }

                        var184 = new MobEffectInstance(var10003, var217, var228, false, false);
                        _entity.addEffect(var184);
                        break label600;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt42 = (LivingEntity)entity;
                     if (_livEnt42.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.getOwner();
               } else {
                  var157 = null;
               }

               label574: {
                  LivingEntity _livEnt55 = var157;
                  if (_livEnt55 instanceof LivingEntity) {
                     LivingEntity _livEnt54 = _livEnt55;
                     if (_livEnt54.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt55 = (LivingEntity)entity;
                           if (_livEnt55.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                              break label574;
                           }
                        }

                        if (!(entity instanceof LivingEntity)) {
                           break label574;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.level().isClientSide()) {
                           break label574;
                        }

                        MobEffectInstance var185;
                        MobEffect var212 = (MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get();
                        LivingEntity var218;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var218 = _tamEnt.getOwner();
                        } else {
                           var218 = null;
                        }
                        int var219;
                        label567: {
                           LivingEntity var143 = var218;
                           if (var143 instanceof LivingEntity) {
                              LivingEntity _livEnt = var143;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                 var219 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getDuration();
                                 break label567;
                              }
                           }

                           var219 = 0;
                        }

                        LivingEntity var229;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var229 = _tamEnt.getOwner();
                        } else {
                           var229 = null;
                        }

                        int var230;
                        label561: {
                           LivingEntity var144 = var229;
                           if (var144 instanceof LivingEntity) {
                              LivingEntity _livEnt = var144;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                 var230 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).getAmplifier();
                                 break label561;
                              }
                           }

                           var230 = 0;
                        }

                        var185 = new MobEffectInstance(var212, var219, var230, false, false);
                        _entity.addEffect(var185);
                        break label574;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt55 = (LivingEntity)entity;
                     if (_livEnt55.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                     }
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.getOwner();
               } else {
                  var157 = null;
               }

               label549: {
                  LivingEntity _livEnt65 = var157;
                  if (_livEnt65 instanceof LivingEntity) {
                     LivingEntity _livEnt64 = _livEnt65;
                     if (_livEnt64.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt65 = (LivingEntity)entity;
                           if (_livEnt65.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              break label549;
                           }
                        }

                        if (!(entity instanceof LivingEntity)) {
                           break label549;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.level().isClientSide()) {
                           break label549;
                        }

                        MobEffectInstance var186;
                        MobEffect var213 = (MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get();
                        LivingEntity var220;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var220 = _tamEnt.getOwner();
                        } else {
                           var220 = null;
                        }

                        int var221;
                        label542: {
                           LivingEntity var145 = var220;
                           if (var145 instanceof LivingEntity) {
                              LivingEntity _livEnt = var145;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 var221 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                                 break label542;
                              }
                           }

                           var221 = 0;
                        }

                        LivingEntity var231;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var231 = _tamEnt.getOwner();
                        } else {
                           var231 = null;
                        }


                        int var232;
                        label536: {
                           LivingEntity var146 = var231;
                           if (var146 instanceof LivingEntity) {
                              LivingEntity _livEnt = var146;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 var232 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                                 break label536;
                              }
                           }

                           var232 = 0;
                        }

                        var186 = new MobEffectInstance(var213, var221, var232, false, false);
                        _entity.addEffect(var186);
                        break label549;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt65 = (LivingEntity)entity;
                     if (_livEnt65.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var187;
                     MobEffect var214 = MobEffects.DAMAGE_BOOST;
                     LivingEntity var222;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var222 = _tamEnt.getOwner();
                     } else {
                        var222 = null;
                     }
                     int var223;
                     label523: {
                        LivingEntity var132 = var222;
                        if (var132 instanceof LivingEntity) {
                           LivingEntity _livEnt = var132;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var223 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getDuration();
                              break label523;
                           }
                        }

                        var223 = 0;
                     }

                     LivingEntity var233;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var233 = _tamEnt.getOwner();
                     } else {
                        var233 = null;
                     }
                     int var234;
                     label517: {
                        LivingEntity var133 = var233;
                        if (var133 instanceof LivingEntity) {
                           LivingEntity _livEnt = var133;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var234 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label517;
                           }
                        }

                        var234 = 0;
                     }

                     var187 = new MobEffectInstance(var214, var223, var234, false, false);
                     _entity.addEffect(var187);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var188;
                     MobEffect var215 = MobEffects.DAMAGE_RESISTANCE;
                     LivingEntity var224;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var224 = _tamEnt.getOwner();
                     } else {
                        var224 = null;
                     }
                     int var225;
                     label505: {
                        LivingEntity var134 = var224;
                        if (var134 instanceof LivingEntity) {
                           LivingEntity _livEnt = var134;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                              var225 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getDuration();
                              break label505;
                           }
                        }

                        var225 = 0;
                     }

                     LivingEntity var235;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var235 = _tamEnt.getOwner();
                     } else {
                        var235 = null;
                     }
                     int var236;
                     label499: {
                        LivingEntity var135 = var235;
                        if (var135 instanceof LivingEntity) {
                           LivingEntity _livEnt = var135;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                              var236 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                              break label499;
                           }
                        }

                        var236 = 0;
                     }

                     var188 = new MobEffectInstance(var215, var225, var236, false, false);
                     _entity.addEffect(var188);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     MobEffectInstance var189;
                     MobEffect var216 = MobEffects.JUMP;
                     LivingEntity var226;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var226 = _tamEnt.getOwner();
                     } else {
                        var226 = null;
                     }


                     int var227;
                     label487: {
                        LivingEntity var136 = var226;
                        if (var136 instanceof LivingEntity) {
                           LivingEntity _livEnt = var136;
                           if (_livEnt.hasEffect(MobEffects.JUMP)) {
                              var227 = _livEnt.getEffect(MobEffects.JUMP).getDuration();
                              break label487;
                           }
                        }

                        var227 = 0;
                     }

                     LivingEntity var237;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var237 = _tamEnt.getOwner();
                     } else {
                        var237 = null;
                     }
                     int var238;
                     label481: {
                        LivingEntity var137 = var237;
                        if (var137 instanceof LivingEntity) {
                           LivingEntity _livEnt = var137;
                           if (_livEnt.hasEffect(MobEffects.JUMP)) {
                              var238 = _livEnt.getEffect(MobEffects.JUMP).getAmplifier();
                              break label481;
                           }
                        }

                        var238 = 0;
                     }

                     var189 = new MobEffectInstance(var216, var227, var238, false, false);
                     _entity.addEffect(var189);
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.getOwner();
               } else {
                  var10001 = null;
               }

               entity.setYRot(((Entity)var10001).getYRot());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.getOwner();
               } else {
                  var10001 = null;
               }

               entity.setXRot(((Entity)var10001).getXRot());
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (entity.getPersistentData().getBoolean("check")) {
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  x_velocity = ((Entity)var157).getX() - entity.getPersistentData().getDouble("old_x");
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  y_velocity = ((Entity)var157).getY() - entity.getPersistentData().getDouble("old_y");
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  z_velocity = ((Entity)var157).getZ() - entity.getPersistentData().getDouble("old_z");
                  distance = Math.sqrt(Math.pow(x_velocity, 2.0) + Math.pow(y_velocity, 2.0) + Math.pow(z_velocity, 2.0));
                  if (distance > 8.0) {
                     entity.teleportTo(entity.getX() + x_velocity, entity.getY() + y_velocity, entity.getZ() + z_velocity);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_velocity, entity.getY() + y_velocity, entity.getZ() + z_velocity, entity.getYRot(), entity.getXRot());
                     }

                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.getOwner();
                     } else {
                        var157 = null;
                     }

                     x_velocity = ((Entity)var157).getDeltaMovement().x();
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.getOwner();
                     } else {
                        var157 = null;
                     }

                     y_velocity = ((Entity)var157).getDeltaMovement().y();
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.getOwner();
                     } else {
                        var157 = null;
                     }

                     z_velocity = ((Entity)var157).getDeltaMovement().z();
                  }
               } else {
                  entity.getPersistentData().putBoolean("check", true);
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  x_velocity = ((Entity)var157).getDeltaMovement().x();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  y_velocity = ((Entity)var157).getDeltaMovement().y();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.getOwner();
                  } else {
                     var157 = null;
                  }

                  z_velocity = ((Entity)var157).getDeltaMovement().z();
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.getOwner();
               } else {
                  var157 = null;
               }

               if (((Entity)var157).onGround()) {
                  y_velocity = entity.getDeltaMovement().y();
               }

               entity.setDeltaMovement(new Vec3(x_velocity, y_velocity, z_velocity));
               CompoundTag var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.getOwner();
               } else {
                  var207 = null;
               }

               var171.putDouble("old_x", ((Entity)var207).getX());
               var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.getOwner();
               } else {
                  var207 = null;
               }

               var171.putDouble("old_y", ((Entity)var207).getY());
               var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.getOwner();
               } else {
                  var207 = null;
               }

               var171.putDouble("old_z", ((Entity)var207).getZ());
               LivingEntity var174;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var174 = _tamEnt.getOwner();
               } else {
                  var174 = null;
               }

               if (!((Entity)var174).isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }
         }

      }
   }
}
