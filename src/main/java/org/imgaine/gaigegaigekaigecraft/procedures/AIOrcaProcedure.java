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
         if (entity.m_6084_()) {
            LivingEntity var10000;
            if (entity instanceof TamableAnimal) {
               TamableAnimal _tamEnt = (TamableAnimal)entity;
               var10000 = _tamEnt.m_269323_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               LivingEntity var10001;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.m_269323_();
               } else {
                  var10001 = null;
               }

               entity.m_20260_(((Entity)var10001).m_6144_());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.m_269323_();
               } else {
                  var10001 = null;
               }

               entity.m_6858_(((Entity)var10001).m_20142_());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10000 = _tamEnt.m_269323_();
               } else {
                  var10000 = null;
               }

               if (((Entity)var10000).m_6060_()) {
                  entity.m_20254_(1);
               } else {
                  entity.m_20095_();
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var148 = _player.m_150109_().f_35975_;
                  LivingEntity var10002;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10002 = _tamEnt.m_269323_();
                  } else {
                     var10002 = null;
                  }

                  LivingEntity var15 = var10002;
                  ItemStack var192;
                  if (var15 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var15;
                     var192 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var192 = ItemStack.f_41583_;
                  }

                  var148.set(3, var192);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var176 = EquipmentSlot.HEAD;
                  LivingEntity var193;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var193 = _tamEnt.m_269323_();
                  } else {
                     var193 = null;
                  }

                  LivingEntity var122 = var193;
                  ItemStack var194;
                  if (var122 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var122;
                     var194 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var194 = ItemStack.f_41583_;
                  }

                  _living.m_8061_(var176, var194);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var149 = _player.m_150109_().f_35975_;
                  LivingEntity var195;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var195 = _tamEnt.m_269323_();
                  } else {
                     var195 = null;
                  }

                  LivingEntity var123 = var195;
                  ItemStack var196;
                  if (var123 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var123;
                     var196 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var196 = ItemStack.f_41583_;
                  }

                  var149.set(2, var196);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var177 = EquipmentSlot.CHEST;
                  LivingEntity var197;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var197 = _tamEnt.m_269323_();
                  } else {
                     var197 = null;
                  }

                  LivingEntity var124 = var197;
                  ItemStack var198;
                  if (var124 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var124;
                     var198 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                  } else {
                     var198 = ItemStack.f_41583_;
                  }

                  _living.m_8061_(var177, var198);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var150 = _player.m_150109_().f_35975_;
                  LivingEntity var199;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var199 = _tamEnt.m_269323_();
                  } else {
                     var199 = null;
                  }

                  LivingEntity var125 = var199;
                  ItemStack var200;
                  if (var125 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var125;
                     var200 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                  } else {
                     var200 = ItemStack.f_41583_;
                  }

                  var150.set(1, var200);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var178 = EquipmentSlot.LEGS;
                  LivingEntity var201;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var201 = _tamEnt.m_269323_();
                  } else {
                     var201 = null;
                  }

                  LivingEntity var126 = var201;
                  ItemStack var202;
                  if (var126 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var126;
                     var202 = _entGetArmor.m_6844_(EquipmentSlot.LEGS);
                  } else {
                     var202 = ItemStack.f_41583_;
                  }

                  _living.m_8061_(var178, var202);
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  NonNullList var151 = _player.m_150109_().f_35975_;
                  LivingEntity var203;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var203 = _tamEnt.m_269323_();
                  } else {
                     var203 = null;
                  }

                  LivingEntity var127 = var203;
                  ItemStack var204;
                  if (var127 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var127;
                     var204 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                  } else {
                     var204 = ItemStack.f_41583_;
                  }

                  var151.set(0, var204);
                  _player.m_150109_().m_6596_();
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _living = (LivingEntity)entity;
                  EquipmentSlot var179 = EquipmentSlot.FEET;
                  LivingEntity var205;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var205 = _tamEnt.m_269323_();
                  } else {
                     var205 = null;
                  }

                  LivingEntity var128 = var205;
                  ItemStack var206;
                  if (var128 instanceof LivingEntity) {
                     LivingEntity _entGetArmor = var128;
                     var206 = _entGetArmor.m_6844_(EquipmentSlot.FEET);
                  } else {
                     var206 = ItemStack.f_41583_;
                  }

                  _living.m_8061_(var179, var206);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10000 = _tamEnt.m_269323_();
                  } else {
                     var10000 = null;
                  }

                  LivingEntity _tamEnt = var10000;
                  ItemStack var153;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var153 = _livEnt.m_21205_();
                  } else {
                     var153 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var153.m_41777_();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10001 = _tamEnt.m_269323_();
                  } else {
                     var10001 = null;
                  }

                  _tamEnt = var10001;
                  ItemStack var181;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var181 = _livEnt.m_21205_();
                  } else {
                     var181 = ItemStack.f_41583_;
                  }

                  _setstack.m_41764_(var181.m_41613_());
                  _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10000 = _tamEnt.m_269323_();
                  } else {
                     var10000 = null;
                  }

                  LivingEntity _tamEnt = var10000;
                  ItemStack var155;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var155 = _livEnt.m_21206_();
                  } else {
                     var155 = ItemStack.f_41583_;
                  }

                  ItemStack _setstack = var155.m_41777_();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var10001 = _tamEnt.m_269323_();
                  } else {
                     var10001 = null;
                  }

                  _tamEnt = var10001;
                  ItemStack var183;
                  if (_tamEnt instanceof LivingEntity) {
                     LivingEntity _livEnt = _tamEnt;
                     var183 = _livEnt.m_21206_();
                  } else {
                     var183 = ItemStack.f_41583_;
                  }

                  _setstack.m_41764_(var183.m_41613_());
                  _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                  if (_entity instanceof Player) {
                     Player _player = (Player)_entity;
                     _player.m_150109_().m_6596_();
                  }
               }

               CompoundTag var156 = entity.getPersistentData();
               LivingEntity var207;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.m_269323_();
               } else {
                  var207 = null;
               }

               var156.m_128379_("PRESS_Z", ((Entity)var207).getPersistentData().m_128471_("PRESS_Z"));
               LivingEntity var157;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.m_269323_();
               } else {
                  var157 = null;
               }

               label600: {
                  LivingEntity _livEnt42 = var157;
                  if (_livEnt42 instanceof LivingEntity) {
                     LivingEntity _livEnt41 = _livEnt42;
                     if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt42 = (LivingEntity)entity;
                           if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                              break label600;
                           }
                        }

                        CompoundTag var158 = entity.getPersistentData();
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var207 = _tamEnt.m_269323_();
                        } else {
                           var207 = null;
                        }

                        var158.m_128347_("skill", ((Entity)var207).getPersistentData().m_128459_("skill"));
                        ResetCounterProcedure.execute(entity);
                        if (!(entity instanceof LivingEntity)) {
                           break label600;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.m_9236_().m_5776_()) {
                           break label600;
                        }

                        MobEffectInstance var184 = new MobEffectInstance;
                        MobEffect var10003 = (MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get();
                        LivingEntity var10004;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var10004 = _tamEnt.m_269323_();
                        } else {
                           var10004 = null;
                        }

                        label593: {
                           LivingEntity var18 = var10004;
                           if (var18 instanceof LivingEntity) {
                              LivingEntity _livEnt = var18;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                 var217 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).m_19557_();
                                 break label593;
                              }
                           }

                           var217 = 0;
                        }

                        LivingEntity var10005;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var10005 = _tamEnt.m_269323_();
                        } else {
                           var10005 = null;
                        }

                        label587: {
                           LivingEntity var142 = var10005;
                           if (var142 instanceof LivingEntity) {
                              LivingEntity _livEnt = var142;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                                 var228 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()).m_19564_();
                                 break label587;
                              }
                           }

                           var228 = 0;
                        }

                        var184.<init>(var10003, var217, var228, false, false);
                        _entity.m_7292_(var184);
                        break label600;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt42 = (LivingEntity)entity;
                     if (_livEnt42.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
                     }
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.m_269323_();
               } else {
                  var157 = null;
               }

               label574: {
                  LivingEntity _livEnt55 = var157;
                  if (_livEnt55 instanceof LivingEntity) {
                     LivingEntity _livEnt54 = _livEnt55;
                     if (_livEnt54.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt55 = (LivingEntity)entity;
                           if (_livEnt55.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                              break label574;
                           }
                        }

                        if (!(entity instanceof LivingEntity)) {
                           break label574;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.m_9236_().m_5776_()) {
                           break label574;
                        }

                        MobEffectInstance var185 = new MobEffectInstance;
                        MobEffect var212 = (MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get();
                        LivingEntity var218;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var218 = _tamEnt.m_269323_();
                        } else {
                           var218 = null;
                        }

                        label567: {
                           LivingEntity var143 = var218;
                           if (var143 instanceof LivingEntity) {
                              LivingEntity _livEnt = var143;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                 var219 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).m_19557_();
                                 break label567;
                              }
                           }

                           var219 = 0;
                        }

                        LivingEntity var229;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var229 = _tamEnt.m_269323_();
                        } else {
                           var229 = null;
                        }

                        label561: {
                           LivingEntity var144 = var229;
                           if (var144 instanceof LivingEntity) {
                              LivingEntity _livEnt = var144;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                                 var230 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()).m_19564_();
                                 break label561;
                              }
                           }

                           var230 = 0;
                        }

                        var185.<init>(var212, var219, var230, false, false);
                        _entity.m_7292_(var185);
                        break label574;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt55 = (LivingEntity)entity;
                     if (_livEnt55.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
                     }
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.m_269323_();
               } else {
                  var157 = null;
               }

               label549: {
                  LivingEntity _livEnt65 = var157;
                  if (_livEnt65 instanceof LivingEntity) {
                     LivingEntity _livEnt64 = _livEnt65;
                     if (_livEnt64.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        if (entity instanceof LivingEntity) {
                           _livEnt65 = (LivingEntity)entity;
                           if (_livEnt65.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              break label549;
                           }
                        }

                        if (!(entity instanceof LivingEntity)) {
                           break label549;
                        }

                        LivingEntity _entity = (LivingEntity)entity;
                        if (_entity.m_9236_().m_5776_()) {
                           break label549;
                        }

                        MobEffectInstance var186 = new MobEffectInstance;
                        MobEffect var213 = (MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get();
                        LivingEntity var220;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var220 = _tamEnt.m_269323_();
                        } else {
                           var220 = null;
                        }

                        label542: {
                           LivingEntity var145 = var220;
                           if (var145 instanceof LivingEntity) {
                              LivingEntity _livEnt = var145;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 var221 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                                 break label542;
                              }
                           }

                           var221 = 0;
                        }

                        LivingEntity var231;
                        if (entity instanceof TamableAnimal) {
                           TamableAnimal _tamEnt = (TamableAnimal)entity;
                           var231 = _tamEnt.m_269323_();
                        } else {
                           var231 = null;
                        }

                        label536: {
                           LivingEntity var146 = var231;
                           if (var146 instanceof LivingEntity) {
                              LivingEntity _livEnt = var146;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 var232 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                                 break label536;
                              }
                           }

                           var232 = 0;
                        }

                        var186.<init>(var213, var221, var232, false, false);
                        _entity.m_7292_(var186);
                        break label549;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     _livEnt65 = (LivingEntity)entity;
                     if (_livEnt65.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()) && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var187 = new MobEffectInstance;
                     MobEffect var214 = MobEffects.f_19600_;
                     LivingEntity var222;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var222 = _tamEnt.m_269323_();
                     } else {
                        var222 = null;
                     }

                     label523: {
                        LivingEntity var132 = var222;
                        if (var132 instanceof LivingEntity) {
                           LivingEntity _livEnt = var132;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var223 = _livEnt.m_21124_(MobEffects.f_19600_).m_19557_();
                              break label523;
                           }
                        }

                        var223 = 0;
                     }

                     LivingEntity var233;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var233 = _tamEnt.m_269323_();
                     } else {
                        var233 = null;
                     }

                     label517: {
                        LivingEntity var133 = var233;
                        if (var133 instanceof LivingEntity) {
                           LivingEntity _livEnt = var133;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var234 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label517;
                           }
                        }

                        var234 = 0;
                     }

                     var187.<init>(var214, var223, var234, false, false);
                     _entity.m_7292_(var187);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var188 = new MobEffectInstance;
                     MobEffect var215 = MobEffects.f_19606_;
                     LivingEntity var224;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var224 = _tamEnt.m_269323_();
                     } else {
                        var224 = null;
                     }

                     label505: {
                        LivingEntity var134 = var224;
                        if (var134 instanceof LivingEntity) {
                           LivingEntity _livEnt = var134;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var225 = _livEnt.m_21124_(MobEffects.f_19606_).m_19557_();
                              break label505;
                           }
                        }

                        var225 = 0;
                     }

                     LivingEntity var235;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var235 = _tamEnt.m_269323_();
                     } else {
                        var235 = null;
                     }

                     label499: {
                        LivingEntity var135 = var235;
                        if (var135 instanceof LivingEntity) {
                           LivingEntity _livEnt = var135;
                           if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                              var236 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                              break label499;
                           }
                        }

                        var236 = 0;
                     }

                     var188.<init>(var215, var225, var236, false, false);
                     _entity.m_7292_(var188);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     MobEffectInstance var189 = new MobEffectInstance;
                     MobEffect var216 = MobEffects.f_19603_;
                     LivingEntity var226;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var226 = _tamEnt.m_269323_();
                     } else {
                        var226 = null;
                     }

                     label487: {
                        LivingEntity var136 = var226;
                        if (var136 instanceof LivingEntity) {
                           LivingEntity _livEnt = var136;
                           if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                              var227 = _livEnt.m_21124_(MobEffects.f_19603_).m_19557_();
                              break label487;
                           }
                        }

                        var227 = 0;
                     }

                     LivingEntity var237;
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var237 = _tamEnt.m_269323_();
                     } else {
                        var237 = null;
                     }

                     label481: {
                        LivingEntity var137 = var237;
                        if (var137 instanceof LivingEntity) {
                           LivingEntity _livEnt = var137;
                           if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                              var238 = _livEnt.m_21124_(MobEffects.f_19603_).m_19564_();
                              break label481;
                           }
                        }

                        var238 = 0;
                     }

                     var189.<init>(var216, var227, var238, false, false);
                     _entity.m_7292_(var189);
                  }
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.m_269323_();
               } else {
                  var10001 = null;
               }

               entity.m_146922_(((Entity)var10001).m_146908_());
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var10001 = _tamEnt.m_269323_();
               } else {
                  var10001 = null;
               }

               entity.m_146926_(((Entity)var10001).m_146909_());
               entity.m_5618_(entity.m_146908_());
               entity.m_5616_(entity.m_146908_());
               entity.f_19859_ = entity.m_146908_();
               entity.f_19860_ = entity.m_146909_();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.f_20884_ = _entity.m_146908_();
                  _entity.f_20886_ = _entity.m_146908_();
               }

               if (entity.getPersistentData().m_128471_("check")) {
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  x_velocity = ((Entity)var157).m_20185_() - entity.getPersistentData().m_128459_("old_x");
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  y_velocity = ((Entity)var157).m_20186_() - entity.getPersistentData().m_128459_("old_y");
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  z_velocity = ((Entity)var157).m_20189_() - entity.getPersistentData().m_128459_("old_z");
                  distance = Math.sqrt(Math.pow(x_velocity, 2.0) + Math.pow(y_velocity, 2.0) + Math.pow(z_velocity, 2.0));
                  if (distance > 8.0) {
                     entity.m_6021_(entity.m_20185_() + x_velocity, entity.m_20186_() + y_velocity, entity.m_20189_() + z_velocity);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.f_8906_.m_9774_(entity.m_20185_() + x_velocity, entity.m_20186_() + y_velocity, entity.m_20189_() + z_velocity, entity.m_146908_(), entity.m_146909_());
                     }

                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.m_269323_();
                     } else {
                        var157 = null;
                     }

                     x_velocity = ((Entity)var157).m_20184_().m_7096_();
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.m_269323_();
                     } else {
                        var157 = null;
                     }

                     y_velocity = ((Entity)var157).m_20184_().m_7098_();
                     if (entity instanceof TamableAnimal) {
                        TamableAnimal _tamEnt = (TamableAnimal)entity;
                        var157 = _tamEnt.m_269323_();
                     } else {
                        var157 = null;
                     }

                     z_velocity = ((Entity)var157).m_20184_().m_7094_();
                  }
               } else {
                  entity.getPersistentData().m_128379_("check", true);
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  x_velocity = ((Entity)var157).m_20184_().m_7096_();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  y_velocity = ((Entity)var157).m_20184_().m_7098_();
                  if (entity instanceof TamableAnimal) {
                     TamableAnimal _tamEnt = (TamableAnimal)entity;
                     var157 = _tamEnt.m_269323_();
                  } else {
                     var157 = null;
                  }

                  z_velocity = ((Entity)var157).m_20184_().m_7094_();
               }

               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var157 = _tamEnt.m_269323_();
               } else {
                  var157 = null;
               }

               if (((Entity)var157).m_20096_()) {
                  y_velocity = entity.m_20184_().m_7098_();
               }

               entity.m_20256_(new Vec3(x_velocity, y_velocity, z_velocity));
               CompoundTag var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.m_269323_();
               } else {
                  var207 = null;
               }

               var171.m_128347_("old_x", ((Entity)var207).m_20185_());
               var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.m_269323_();
               } else {
                  var207 = null;
               }

               var171.m_128347_("old_y", ((Entity)var207).m_20186_());
               var171 = entity.getPersistentData();
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var207 = _tamEnt.m_269323_();
               } else {
                  var207 = null;
               }

               var171.m_128347_("old_z", ((Entity)var207).m_20189_());
               LivingEntity var174;
               if (entity instanceof TamableAnimal) {
                  TamableAnimal _tamEnt = (TamableAnimal)entity;
                  var174 = _tamEnt.m_269323_();
               } else {
                  var174 = null;
               }

               if (!((Entity)var174).m_6084_() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
               }
            }
         }

      }
   }
}
