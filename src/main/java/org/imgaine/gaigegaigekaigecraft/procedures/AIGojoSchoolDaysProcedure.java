package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIGojoSchoolDaysProcedure {
   public AIGojoSchoolDaysProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean adult = false;
         boolean defense = false;
         boolean domain = false;
         boolean simple = false;
         boolean purple = false;
         boolean red = false;
         boolean target_sukuna = false;
         Entity target_entity = null;
         double rnd = 0.0;
         double strlv = 0.0;
         double tick = 0.0;
         double health = 0.0;
         double z_pos = 0.0;
         double num1 = 0.0;
         double distance = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
               GojoSatoruSchoolDaysEntity _datEntL2 = (GojoSatoruSchoolDaysEntity)entity;
               if ((Boolean)_datEntL2.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_dying)) {
                  entity.getPersistentData().putDouble("cnt_target", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 99, false, false));
                     }
                  }

                  if (!((GojoSatoruSchoolDaysEntity)entity).getSyncedAnimation().equals("death") && entity instanceof GojoSatoruSchoolDaysEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "death");
                  }

                  entity.getPersistentData().putDouble("cnt_dying", entity.getPersistentData().getDouble("cnt_dying") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_dying") > 200.0) {
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                     }

                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.getEntityData().set(GojoSatoruSchoolDaysEntity.DATA_dying, false);
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:0b}");
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect(MobEffects.DAMAGE_BOOST);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var115;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var115 = _livEnt.getMaxHealth();
                        } else {
                           var115 = -1.0F;
                        }

                        _entity.setHealth(var115);
                     }

                     AnimationResetProcedure.execute(entity);
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                  }

                  return;
               }
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putBoolean("infinity", true);
            WhenPlayerActiveTickInfinityProcedure.execute(entity);
            if (entity.getPersistentData().getBoolean("GojoNoUseInfinity")) {
               if (entity.getPersistentData().getDouble("cnt_target") > 50.0) {
                  entity.getPersistentData().putBoolean("GojoNoUseInfinity", false);
               } else if (entity.getPersistentData().getDouble("cnt_target") > 3.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
                     }
                  }
               } else {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (!(var10000 instanceof LivingEntity) && !world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).isEmpty()) {
                     target_entity = (Entity)world.getEntitiesOfClass(SukunaFushiguroEntity.class, AABB.ofSize(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x, y, z)).findFirst().orElse((SukunaFushiguroEntity) null);
                     if (entity instanceof Mob) {
                        Mob _entity = (Mob)entity;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _ent = (LivingEntity)target_entity;
                           _entity.setTarget(_ent);
                        }
                     }
                  }
               }
            }

            LivingEntity var103;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var103 = _mobEnt.getTarget();
            } else {
               var103 = null;
            }
            LivingEntity var43;
            label632: {
               var43 = var103;
               adult = entity instanceof GojoSatoruEntity;
               target_sukuna = var43 instanceof SukunaFushiguroEntity;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt33 = (LivingEntity)entity;
                  if (_livEnt33.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label632;
                  }
               }

               if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
                  GojoSatoruSchoolDaysEntity _datEntL35 = (GojoSatoruSchoolDaysEntity)entity;
                  if ((Boolean)_datEntL35.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 26, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 2147483647, 26, false, false));
                        }
                     }
                     break label632;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, adult ? 29 : 20, false, false));
                  }
               }
            }

            label606: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt39 = (LivingEntity)entity;
                  if (_livEnt39.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label606;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
                  }
               }
            }

            label601: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt41 = (LivingEntity)entity;
                  if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                     break label601;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get(), 2147483647, 4, false, false));
                  }
               }
            }

            if (entity instanceof GojoSatoruEntity) {
               GojoSatoruEntity _datEntL43 = (GojoSatoruEntity)entity;
               if ((Boolean)_datEntL43.getEntityData().get(GojoSatoruEntity.DATA_ghost)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt45 = (LivingEntity)entity;
                     if (_livEnt45.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                     }
                  }
               }
            }

            if (var43 instanceof LivingEntity) {
               if (entity.getPersistentData().getDouble("cnt_target") > 150.0 && target_sukuna) {
                  if (var43 instanceof Mob) {
                     Mob _mobEnt = (Mob)var43;
                     var103 = _mobEnt.getTarget();
                  } else {
                     var103 = null;
                  }

                  if (!(var103 instanceof LivingEntity) && var43 instanceof Mob) {
                     Mob _entity = (Mob)var43;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _ent = (LivingEntity)entity;
                        _entity.setTarget(_ent);
                     }
                  }
               }

               ItemStack var105;
               if (var43 instanceof LivingEntity) {
                  LivingEntity _livEnt = var43;
                  var105 = _livEnt.getMainHandItem();
               } else {
                  var105 = ItemStack.EMPTY;
               }
               boolean var107;
               label591: {
                  if (var105.getItem() != JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get()) {
                     if (var43 instanceof LivingEntity) {
                        LivingEntity _livEnt = var43;
                        var105 = _livEnt.getMainHandItem();
                     } else {
                        var105 = ItemStack.EMPTY;
                     }

                     if (var105.getItem() != JujutsucraftModItems.BLACK_ROPE.get()) {
                        var107 = false;
                        break label591;
                     }
                  }

                  var107 = true;
               }

               defense = var107;
               domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && adult;
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  if (!entity.getPersistentData().getBoolean("GojoNoUseInfinity") && target_sukuna) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var105 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
                     } else {
                        var105 = ItemStack.EMPTY;
                     }

                     if (var105.getItem() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(3, ItemStack.EMPTY);
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.getInventory().armor.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                           _player.getInventory().setChanged();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.setItemSlot(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                        }
                     }
                  }

                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  float var109;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var109 = _livEnt.getHealth();
                  } else {
                     var109 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.getMaxHealth();
                  } else {
                     var10001 = -1.0F;
                  }

                  label670: {
                     health = (double)(var109 / var10001);
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                           break label670;
                        }

                        GojoSatoruSchoolDaysEntity _datEntL71 = (GojoSatoruSchoolDaysEntity)entity;
                        if (!(Boolean)_datEntL71.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                           break label670;
                        }
                     }

                     purple = entity.getPersistentData().getBoolean("GojoNoUseInfinity") && distance > 32.0;
                     if (!entity.getPersistentData().getBoolean("flag1") && health < 0.3 && (!adult || distance < 32.0)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 20, 0, false, false));
                           }
                        }

                        purple = true;
                     }
                  }

                  if (!domain) {
                     label652: {
                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                           if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                              break label652;
                           }

                           GojoSatoruSchoolDaysEntity _datEntL76 = (GojoSatoruSchoolDaysEntity)entity;
                           if (!(Boolean)_datEntL76.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                              break label652;
                           }
                        }

                        if (distance < 24.0 && var43 instanceof LivingEntity) {
                           LivingEntity _livEnt77 = var43;
                           if (_livEnt77.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              label655: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt78 = (LivingEntity)entity;
                                    if (_livEnt78.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label655;
                                    }
                                 }
                                 int var110;
                                 label551: {
                                    if (var43 instanceof LivingEntity) {
                                       LivingEntity _livEnt = var43;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          var110 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                          break label551;
                                       }
                                    }

                                    var110 = 0;
                                 }

                                 if (var110 <= 600) {
                                    red = true;
                                 }
                              }
                           }
                        }
                     }
                  }

                  label638: {
                     label532: {
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (defense ? 0.3 : 0.5)) {
                              break label532;
                           }

                           if (purple || red) {
                              if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                 break label532;
                              }

                              if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                 GojoSatoruSchoolDaysEntity _datEntL81 = (GojoSatoruSchoolDaysEntity)entity;
                                 if ((Boolean)_datEntL81.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                    break label532;
                                 }
                              }
                           }
                        }

                        if (!domain) {
                           CalculateAttackProcedure.execute(world, entity);
                           break label638;
                        }
                     }

                     if (domain) {
                        rnd = 20.0;
                        tick = 20.0;
                     } else {
                        label516: {
                           label640: {
                              if (!entity.getPersistentData().getBoolean("flag2")) {
                                 if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       GojoSatoruSchoolDaysEntity _datEntL84 = (GojoSatoruSchoolDaysEntity)entity;
                                       if ((Boolean)_datEntL84.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                          break label640;
                                       }
                                    }
                                 } else if (health < 0.5 && distance < 16.0) {
                                    break label640;
                                 }
                              }

                              label641: {
                                 if (!entity.getPersistentData().getBoolean("flag1")) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL88 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL88.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking) && health < 0.5) {
                                             break label641;
                                          }
                                       }
                                    } else if (health < 0.3 && distance < 40.0) {
                                       break label641;
                                    }
                                 }

                                 label642: {
                                    if (red) {
                                       if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                          break label642;
                                       }

                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL91 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL91.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                             break label642;
                                          }
                                       }
                                    }

                                    label643: {
                                       if (purple) {
                                          if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                             break label643;
                                          }

                                          if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                             GojoSatoruSchoolDaysEntity _datEntL93 = (GojoSatoruSchoolDaysEntity)entity;
                                             if ((Boolean)_datEntL93.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                break label643;
                                             }
                                          }
                                       }

                                       num1 = 0.0;
                                       int index0 = 0;

                                       while(true) {
                                          if (index0 >= 128) {
                                             break label516;
                                          }

                                          ++num1;
                                          if (num1 > 96.0) {
                                             rnd = 0.0;
                                             break label516;
                                          }

                                          label473: {
                                             rnd = (double)Math.round(4.0 + Math.random() * 16.0);
                                             if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                label645: {
                                                   if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                      GojoSatoruSchoolDaysEntity _datEntL96 = (GojoSatoruSchoolDaysEntity)entity;
                                                      if ((Boolean)_datEntL96.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                         break label645;
                                                      }
                                                   }

                                                   if (rnd == 7.0 || rnd == 15.0) {
                                                      break label473;
                                                   }
                                                }
                                             }

                                             if (rnd == 6.0) {
                                                int var111;
                                                label439: {
                                                   tick = 100.0;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var111 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                         break label439;
                                                      }
                                                   }

                                                   var111 = 0;
                                                }

                                                if (var111 <= 0) {
                                                   break label516;
                                                }
                                             } else if (rnd == 7.0) {
                                                tick = 250.0;
                                                if (!(Math.random() > 0.5) && !(distance > 16.0)) {
                                                   int var112;
                                                   label444: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var112 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                            break label444;
                                                         }
                                                      }

                                                      var112 = 0;
                                                   }

                                                   if (var112 <= 0) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label516;
                                                      }

                                                      LivingEntity _livEnt99 = (LivingEntity)entity;
                                                      if (!_livEnt99.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label516;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == 8.0) {
                                                int var113;
                                                label451: {
                                                   tick = 100.0;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var113 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                         break label451;
                                                      }
                                                   }

                                                   var113 = 0;
                                                }

                                                if (var113 <= 0) {
                                                   break label516;
                                                }
                                             } else if (rnd == 15.0) {
                                                tick = 500.0;
                                                if (!target_sukuna && !(distance < 8.0)) {
                                                   int var114;
                                                   label456: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var114 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                                            break label456;
                                                         }
                                                      }

                                                      var114 = 0;
                                                   }

                                                   if (var114 <= 0 && !(Math.random() > 0.1)) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label516;
                                                      }

                                                      LivingEntity _livEnt102 = (LivingEntity)entity;
                                                      if (!_livEnt102.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label516;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == 20.0) {
                                                tick = 20.0;
                                                if (adult && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   if (!(var43 instanceof LivingEntity)) {
                                                      break label516;
                                                   }

                                                   LivingEntity _livEnt103 = var43;
                                                   if (!_livEnt103.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                                      break label516;
                                                   }
                                                }
                                             }
                                          }

                                          ++index0;
                                       }
                                    }

                                    entity.getPersistentData().putBoolean("GojoNoUseInfinity", false);
                                    rnd = 15.0;
                                    tick = 500.0;
                                    break label516;
                                 }

                                 rnd = 7.0;
                                 tick = 250.0;
                                 break label516;
                              }

                              entity.getPersistentData().putBoolean("flag1", true);
                              rnd = 15.0;
                              tick = 500.0;
                              break label516;
                           }

                           entity.getPersistentData().putBoolean("flag2", true);
                           rnd = 7.0;
                           tick = 250.0;
                        }
                     }

                     if (rnd > 0.0) {
                        entity.getPersistentData().putDouble("skill", (double)Math.round(200.0 + rnd));
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }

                  if (rnd == 20.0) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.getInventory().armor.set(3, ItemStack.EMPTY);
                        _player.getInventory().setChanged();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.setItemSlot(EquipmentSlot.HEAD, ItemStack.EMPTY);
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               if (health >= 0.5) {
                  entity.getPersistentData().putBoolean("flag2", false);
               }

               if (health >= 0.3) {
                  entity.getPersistentData().putBoolean("flag1", false);
               }
            }
         }

      }
   }
}
