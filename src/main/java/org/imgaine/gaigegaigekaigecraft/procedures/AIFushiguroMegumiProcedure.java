package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIFushiguroMegumiProcedure {
   public AIFushiguroMegumiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean flagMahorage = false;
         boolean reChange = false;
         boolean young = false;
         boolean domain = false;
         boolean StrongEnemy = false;
         boolean sukuna = false;
         boolean failed = false;
         boolean awaked = false;
         double NUM2 = 0.0;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM1 = 0.0;
         double count_a = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         if (entity.isAlive()) {
            young = entity instanceof FushiguroMegumiEntity;
            sukuna = entity instanceof SukunaFushiguroEntity;
            if (!sukuna) {
               label508: {
                  AIActiveProcedure.execute(world, x, y, z, entity);
                  if (!entity.getPersistentData().getBoolean("flag_start")) {
                     entity.getPersistentData().putBoolean("flag_start", true);
                     entity.getPersistentData().putBoolean("HasWeapon1", true);
                     rnd = 4.0;

                     for(int index0 = 0; index0 < 5; ++index0) {
                        entity.getPersistentData().putDouble("TenShadowsTechnique" + Math.round(rnd), 1.0);
                        ++rnd;
                     }

                     if (!young) {
                        entity.getPersistentData().putDouble("TenShadowsTechnique1", -2.0);
                        entity.getPersistentData().putDouble("TenShadowsTechnique5", -2.0);
                     }
                  }

                  if (young) {
                     NUM1 = 7.0;
                     NUM2 = 2.0;
                  } else {
                     NUM1 = 10.0;
                     NUM2 = 3.0;
                  }

                  label468: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           break label468;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                        }
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt11 = (LivingEntity)entity;
                     if (_livEnt11.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                        break label508;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
                     }
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                  entity.getPersistentData().putDouble("cnt_rest", 0.0);
                  if (entity.getPersistentData().getDouble("TenShadowsTechnique14") < (double)(sukuna ? 1 : 0)) {
                     flagMahorage = false;
                  } else {
                     boolean var76;
                     label449: {
                        flagMahorage = entity.getPersistentData().getBoolean("flag_mahoraga");
                        if (!flagMahorage) {
                           int var74;
                           label446: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var74 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label446;
                                 }
                              }

                              var74 = 0;
                           }

                           int var75 = var74 * 2;
                           LivingEntity var10001;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10001 = _mobEnt.getTarget();
                           } else {
                              var10001 = null;
                           }
                           int var88;
                           label440: {
                              LivingEntity var36 = var10001;
                              if (var36 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var36;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var88 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label440;
                                 }
                              }

                              var88 = 0;
                           }

                           if (var75 > var88) {
                              var76 = false;
                              break label449;
                           }
                        }

                        var76 = true;
                     }
                     boolean var79;
                     label522: {
                        flagMahorage = var76;
                        if (!flagMahorage) {
                           label512: {
                              if (young) {
                                 float var77;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var77 = _livEnt.getHealth();
                                 } else {
                                    var77 = -1.0F;
                                 }

                                 double var78 = (double)var77;
                                 float var89;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var89 = _livEnt.getMaxHealth();
                                 } else {
                                    var89 = -1.0F;
                                 }

                                 if (var78 < (double)var89 * 0.25) {
                                    break label512;
                                 }
                              }

                              var79 = false;
                              break label522;
                           }
                        }

                        var79 = true;
                     }
                     boolean var82;
                     label523: {
                        flagMahorage = var79;
                        if (!flagMahorage) {
                           label513: {
                              if (sukuna) {
                                 float var80;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var80 = _livEnt.getHealth();
                                 } else {
                                    var80 = -1.0F;
                                 }

                                 double var81 = (double)var80;
                                 float var90;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var90 = _livEnt.getMaxHealth();
                                 } else {
                                    var90 = -1.0F;
                                 }

                                 if (var81 < (double)var90 * 0.75) {
                                    break label513;
                                 }
                              }

                              var82 = false;
                              break label523;
                           }
                        }

                        var82 = true;
                     }

                     flagMahorage = var82;
                  }

                  if (!sukuna) {
                     int var83;
                     label409: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var83 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label409;
                           }
                        }

                        var83 = 0;
                     }

                     int var84 = var83 - 10;
                     LivingEntity var91;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var91 = _mobEnt.getTarget();
                     } else {
                        var91 = null;
                     }
                     int var92;
                     label403: {
                        LivingEntity var71 = var91;
                        if (var71 instanceof LivingEntity) {
                           LivingEntity _livEnt = var71;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var92 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label403;
                           }
                        }

                        var92 = 0;
                     }

                     StrongEnemy = var84 < var92;
                     CompoundTag var85 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.getHealth();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var93 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.getMaxHealth();
                     } else {
                        var10003 = -1.0F;
                     }

                     var85.putBoolean("flag_domain", var93 < (double)var10003 * 0.5 && StrongEnemy);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !young && !sukuna;
                  }

                  if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                     DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
                     ResetCounterProcedure.execute(entity);
                     if ((!LogicStartProcedure.execute(entity) || (entity.getPersistentData().getDouble("NUM_TenShadowsTechnique") != 0.0 && (entity.getPersistentData().getDouble("NUM_TenShadowsTechnique") != 1.0 || !(Math.random() > 0.75)) && (!(entity.getPersistentData().getDouble("NUM_TenShadowsTechnique") > 1.0) || !(Math.random() > 0.95)) || !StrongEnemy) && !flagMahorage && !sukuna) && !domain) {
                        CalculateAttackProcedure.execute(world, entity);
                        if (!sukuna) {
                           ItemStack var86;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var86 = _livEnt.getMainHandItem();
                           } else {
                              var86 = ItemStack.EMPTY;
                           }

                           if (!(var86.getItem() instanceof SwordItem) && entity.getPersistentData().getBoolean("HasWeapon1")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = (young ? new ItemStack((ItemLike)JujutsucraftModItems.SWORD_BLACK.get()) : new ItemStack(Items.IRON_SWORD)).copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }

                              entity.getPersistentData().putBoolean("HasWeapon1", false);
                           }
                        }
                     } else {
                        if (domain) {
                           rnd = 20.0;
                           tick = 20.0;
                           entity.getPersistentData().putBoolean("flag_domain", false);
                        } else {
                           for(int index1 = 0; index1 < 256; ++index1) {
                              rnd = 4.0 + Math.ceil(Math.random() * 16.0);
                              ++count_a;
                              if (count_a > 128.0) {
                                 failed = true;
                                 break;
                              }

                              if (flagMahorage) {
                                 if (!(entity.getPersistentData().getDouble("TenShadowsTechnique14") >= (double)(sukuna ? 1 : 0))) {
                                    flagMahorage = false;
                                    continue;
                                 }

                                 rnd = 18.0;
                              } else if (entity.getPersistentData().getBoolean("flag_agito")) {
                                 if (!(entity.getPersistentData().getDouble("TenShadowsTechnique13") >= 0.0)) {
                                    entity.getPersistentData().putBoolean("flag_agito", false);
                                    continue;
                                 }

                                 rnd = 17.0;
                              } else if (entity.getPersistentData().getDouble("TenShadowsTechnique" + Math.round(rnd - 4.0)) <= 0.0 && rnd != 7.0 && rnd != 17.0) {
                                 continue;
                              }

                              if ((!(entity.getPersistentData().getDouble("TenShadowsTechnique3") < 0.0) || rnd != 5.0 && rnd != 6.0) && (!(entity.getPersistentData().getDouble("TenShadowsTechnique13") < 0.0) || rnd != 8.0 && rnd != 9.0 && rnd != 13.0 && rnd != 15.0)) {
                                 if (rnd != 5.0 && rnd != 6.0) {
                                    if (rnd == 7.0) {
                                       tick = 20.0;
                                       if (entity.getPersistentData().getDouble("TenShadowsTechnique1") <= -2.0 && entity.getPersistentData().getDouble("TenShadowsTechnique2") >= 0.0 || entity.getPersistentData().getDouble("TenShadowsTechnique1") >= 0.0 && entity.getPersistentData().getDouble("TenShadowsTechnique2") <= -2.0) {
                                          break;
                                       }
                                    } else {
                                       if (rnd == 8.0) {
                                          tick = 20.0;
                                          break;
                                       }

                                       if (rnd == 9.0) {
                                          tick = 20.0;
                                          break;
                                       }

                                       if (rnd == 10.0) {
                                          tick = 20.0;
                                          if (!sukuna) {
                                             break;
                                          }
                                       } else if (rnd == 11.0) {
                                          tick = 20.0;
                                          if (!(Math.random() < 0.5)) {
                                             break;
                                          }
                                       } else if (rnd == 12.0) {
                                          tick = 20.0;
                                          if (!(Math.random() < 0.8)) {
                                             break;
                                          }
                                       } else {
                                          if (rnd == 13.0) {
                                             tick = 20.0;
                                             break;
                                          }

                                          if (rnd == 14.0) {
                                             tick = 20.0;
                                             break;
                                          }

                                          if (rnd == 15.0) {
                                             tick = 20.0;
                                             break;
                                          }

                                          if (rnd == 17.0) {
                                             tick = 20.0;
                                             if (entity.getPersistentData().getDouble("TenShadowsTechnique4") > 0.0 && entity.getPersistentData().getDouble("TenShadowsTechnique5") <= -2.0 && entity.getPersistentData().getDouble("TenShadowsTechnique9") <= -2.0 && entity.getPersistentData().getDouble("TenShadowsTechnique11") <= -2.0) {
                                                break;
                                             }
                                          } else if (rnd == 18.0) {
                                             tick = 20.0;
                                             if (flagMahorage || !sukuna) {
                                                break;
                                             }
                                          } else if (rnd == 20.0) {
                                             tick = 20.0;
                                             if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && !young && !sukuna) {
                                                break;
                                             }
                                          }
                                       }
                                    }
                                 } else {
                                    tick = 20.0;
                                    if (young) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (failed) {
                           CalculateAttackProcedure.execute(world, entity);
                        } else {
                           entity.getPersistentData().putDouble("cnt_x", 0.0);
                           ItemStack var87;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var87 = _livEnt.getMainHandItem();
                           } else {
                              var87 = ItemStack.EMPTY;
                           }

                           if (var87.getItem() == (young ? (Item)JujutsucraftModItems.SWORD_BLACK.get() : Items.IRON_SWORD)) {
                              entity.getPersistentData().putBoolean("HasWeapon1", true);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 ItemStack _setstack = ItemStack.EMPTY.copy();
                                 _setstack.setCount(1);
                                 _entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
                                 if (_entity instanceof Player) {
                                    Player _player = (Player)_entity;
                                    _player.getInventory().setChanged();
                                 }
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.EMPTY.copy();
                              _setstack.setCount(1);
                              _entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.getInventory().setChanged();
                              }
                           }

                           entity.getPersistentData().putDouble("skill", (double)(600L + Math.round(rnd)));
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.level().isClientSide()) {
                                 _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              }
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
               entity.getPersistentData().putDouble("cnt_rest", entity.getPersistentData().getDouble("cnt_rest") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_rest") > 120.0) {
                  entity.getPersistentData().putDouble("cnt_rest", 0.0);
                  entity.getPersistentData().putDouble("skill", 1.0);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

      }
   }
}
