package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIJogoProcedure {
   public AIJogoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double health = 0.0;
         double distance = 0.0;
         boolean infinity = false;
         boolean domain = false;
         boolean flame_battle = false;
         if (entity.isAlive()) {
            label332: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label332;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, 18, false, false));
                  }
               }
            }

            label327: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     break label327;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, 3, false, false));
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

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().putDouble("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  LivingEntity _livEnt = var10000;
                  if (_livEnt instanceof LivingEntity) {
                     LivingEntity _livEnt13 = _livEnt;
                     if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") == 107.0) {
                           int var60;
                           label315: {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var60 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label315;
                                 }
                              }

                              var60 = 0;
                           }

                           if (var60 <= 30) {
                              int var61;
                              label309: {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var61 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).getDuration();
                                       break label309;
                                    }
                                 }

                                 var61 = 0;
                              }

                              if (var61 <= 30) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 9, false, false));
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 15, 0, false, false));
                                    }
                                 }

                                 flame_battle = true;
                              }
                           }
                        }
                     }
                  }

                  if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.1) && !entity.getPersistentData().getBoolean("UseCursedTechnique") && !flame_battle) && !domain) {
                     CalculateAttackProcedure.execute(world, entity);
                  } else {
                     if (domain) {
                        tick = 20.0;
                        rnd = 20.0;
                     } else {
                        float var62;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var62 = _livEnt.getHealth();
                        } else {
                           var62 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        health = (double)(var62 / var10001);
                        if (health >= 0.66) {
                           entity.getPersistentData().putBoolean("flag1", false);
                        }

                        if (health >= 0.33) {
                           entity.getPersistentData().putBoolean("flag2", false);
                        }

                        distance = GetDistanceProcedure.execute(entity);
                        if (flame_battle) {
                           rnd = 5.0;
                           tick = 90.0;
                        } else if (!entity.getPersistentData().getBoolean("flag1") && health < 0.66 && distance > 16.0) {
                           entity.getPersistentData().putBoolean("flag1", true);
                           rnd = 9.0;
                           tick = 250.0;
                        } else {
                           label359: {
                              label344: {
                                 if (!entity.getPersistentData().getBoolean("flag2") && health < 0.33 && distance < 16.0) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label344;
                                    }

                                    LivingEntity _livEnt28 = (LivingEntity)entity;
                                    if (!_livEnt28.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label344;
                                    }
                                 }

                                 int index0 = 0;

                                 while(true) {
                                    if (index0 >= 256) {
                                       break label359;
                                    }

                                    rnd = (double)(4L + Math.round(Math.random() * 16.0));
                                    if (rnd == 5.0) {
                                       tick = 90.0;
                                       break label359;
                                    }

                                    if (rnd == 6.0) {
                                       tick = 60.0;
                                       if (!(distance < 6.0) && !(distance > 12.0)) {
                                          break label359;
                                       }
                                    } else {
                                       if (rnd == 7.0) {
                                          tick = 75.0;
                                          break label359;
                                       }

                                       if (rnd == 8.0) {
                                          tick = 75.0;
                                          break label359;
                                       }

                                       if (rnd == 9.0) {
                                          tick = 250.0;
                                          if (!(Math.random() > 0.15) && !(distance < 16.0)) {
                                             break label359;
                                          }
                                       } else if (rnd != 10.0) {
                                          if (rnd == 15.0) {
                                             tick = 625.0;
                                             if (!(entity.getPersistentData().getDouble("cnt_target") < 600.0)) {
                                                if (entity instanceof LivingEntity) {
                                                   _livEnt = (LivingEntity)entity;
                                                   var62 = _livEnt.getHealth();
                                                } else {
                                                   var62 = -1.0F;
                                                }

                                                if (entity instanceof LivingEntity) {
                                                   _livEnt = (LivingEntity)entity;
                                                   var10001 = _livEnt.getMaxHealth();
                                                } else {
                                                   var10001 = -1.0F;
                                                }

                                                if (!((double)(var62 / var10001) > 0.33) && !(Math.random() > 0.075)) {
                                                   if (!(entity instanceof LivingEntity)) {
                                                      break label359;
                                                   }

                                                   LivingEntity _livEnt39 = (LivingEntity)entity;
                                                   if (!_livEnt39.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                      break label359;
                                                   }
                                                }
                                             }
                                          } else if (rnd == 20.0) {
                                             label348: {
                                                tick = 20.0;
                                                LivingEntity var64;
                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var64 = _mobEnt.getTarget();
                                                } else {
                                                   var64 = null;
                                                }

                                                LivingEntity var27 = var64;
                                                if (var27 instanceof LivingEntity) {
                                                   _livEnt = var27;
                                                   if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                      if (entity instanceof Mob) {
                                                         Mob _mobEnt = (Mob)entity;
                                                         var64 = _mobEnt.getTarget();
                                                      } else {
                                                         var64 = null;
                                                      }
                                                      int var66;
                                                      label249: {
                                                         var27 = var64;
                                                         if (var27 instanceof LivingEntity) {
                                                            _livEnt = var27;
                                                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                               var66 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                               break label249;
                                                            }
                                                         }

                                                         var66 = 0;
                                                      }
                                                      int var71;
                                                      label244: {
                                                         if (entity instanceof LivingEntity) {
                                                            _livEnt = (LivingEntity)entity;
                                                            if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                               var71 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                               break label244;
                                                            }
                                                         }

                                                         var71 = 0;
                                                      }

                                                      if (var66 > var71) {
                                                         break label348;
                                                      }
                                                   }
                                                }

                                                if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   break label359;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++index0;
                                 }
                              }

                              entity.getPersistentData().putBoolean("flag2", true);
                              LivingEntity var67;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var67 = _mobEnt.getTarget();
                              } else {
                                 var67 = null;
                              }
                              int var68;
                              label233: {
                                 LivingEntity var55 = var67;
                                 if (var55 instanceof LivingEntity) {
                                    _livEnt = var55;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var68 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label233;
                                    }
                                 }

                                 var68 = 0;
                              }
                              int var72;
                              label228: {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var72 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label228;
                                    }
                                 }

                                 var72 = 0;
                              }

                              label223: {
                                 if (var68 >= var72 + 5) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var67 = _mobEnt.getTarget();
                                    } else {
                                       var67 = null;
                                    }

                                    LivingEntity var56 = var67;
                                    if (!(var56 instanceof LivingEntity)) {
                                       break label223;
                                    }

                                    LivingEntity _livEnt34 = var56;
                                    if (!_livEnt34.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       break label223;
                                    }
                                 }

                                 entity.getPersistentData().putBoolean("flag_domain", true);
                                 if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                    tick = 20.0;
                                    rnd = 20.0;
                                 }
                                 break label359;
                              }

                              rnd = 15.0;
                              tick = 625.0;
                           }
                        }
                     }

                     entity.getPersistentData().putDouble("skill", (double)Math.round(400.0 + rnd));
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

                     entity.getPersistentData().putBoolean("UseCursedTechnique", false);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_x", 0.0);
            }
         }

      }
   }
}
