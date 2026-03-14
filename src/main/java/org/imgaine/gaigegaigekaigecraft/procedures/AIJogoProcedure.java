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
         if (entity.m_6084_()) {
            label316: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label316;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 18, false, false));
                  }
               }
            }

            label311: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label311;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  LivingEntity _livEnt = var10000;
                  if (_livEnt instanceof LivingEntity) {
                     LivingEntity _livEnt13 = _livEnt;
                     if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128459_("skill") == 107.0) {
                           label299: {
                              if (entity instanceof LivingEntity) {
                                 _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var58 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label299;
                                 }
                              }

                              var58 = 0;
                           }

                           if (var58 <= 30) {
                              label293: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var59 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19557_();
                                       break label293;
                                    }
                                 }

                                 var59 = 0;
                              }

                              if (var59 <= 30) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 60, 9, false, false));
                                    }
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 15, 0, false, false));
                                    }
                                 }

                                 flame_battle = true;
                              }
                           }
                        }
                     }
                  }

                  if ((!LogicStartProcedure.execute(entity) || !(Math.random() > 0.1) && !entity.getPersistentData().m_128471_("UseCursedTechnique") && !flame_battle) && !domain) {
                     CalculateAttackProcedure.execute(world, entity);
                  } else {
                     if (domain) {
                        tick = 20.0;
                        rnd = 20.0;
                     } else {
                        float var60;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var60 = _livEnt.m_21223_();
                        } else {
                           var60 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        health = (double)(var60 / var10001);
                        if (health >= 0.66) {
                           entity.getPersistentData().m_128379_("flag1", false);
                        }

                        if (health >= 0.33) {
                           entity.getPersistentData().m_128379_("flag2", false);
                        }

                        distance = GetDistanceProcedure.execute(entity);
                        if (flame_battle) {
                           rnd = 5.0;
                           tick = 90.0;
                        } else if (!entity.getPersistentData().m_128471_("flag1") && health < 0.66 && distance > 16.0) {
                           entity.getPersistentData().m_128379_("flag1", true);
                           rnd = 9.0;
                           tick = 250.0;
                        } else {
                           label342: {
                              label328: {
                                 if (!entity.getPersistentData().m_128471_("flag2") && health < 0.33 && distance < 16.0) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label328;
                                    }

                                    LivingEntity _livEnt28 = (LivingEntity)entity;
                                    if (!_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label328;
                                    }
                                 }

                                 int index0 = 0;

                                 while(true) {
                                    if (index0 >= 256) {
                                       break label342;
                                    }

                                    rnd = (double)(4L + Math.round(Math.random() * 16.0));
                                    if (rnd == 5.0) {
                                       tick = 90.0;
                                       break label342;
                                    }

                                    if (rnd == 6.0) {
                                       tick = 60.0;
                                       if (!(distance < 6.0) && !(distance > 12.0)) {
                                          break label342;
                                       }
                                    } else {
                                       if (rnd == 7.0) {
                                          tick = 75.0;
                                          break label342;
                                       }

                                       if (rnd == 8.0) {
                                          tick = 75.0;
                                          break label342;
                                       }

                                       if (rnd == 9.0) {
                                          tick = 250.0;
                                          if (!(Math.random() > 0.15) && !(distance < 16.0)) {
                                             break label342;
                                          }
                                       } else if (rnd != 10.0) {
                                          if (rnd == 15.0) {
                                             tick = 625.0;
                                             if (!(Math.random() > 0.075)) {
                                                if (!(entity instanceof LivingEntity)) {
                                                   break label342;
                                                }

                                                LivingEntity _livEnt36 = (LivingEntity)entity;
                                                if (!_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                   break label342;
                                                }
                                             }
                                          } else if (rnd == 20.0) {
                                             label331: {
                                                tick = 20.0;
                                                LivingEntity var61;
                                                if (entity instanceof Mob) {
                                                   Mob _mobEnt = (Mob)entity;
                                                   var61 = _mobEnt.m_5448_();
                                                } else {
                                                   var61 = null;
                                                }

                                                LivingEntity var27 = var61;
                                                if (var27 instanceof LivingEntity) {
                                                   _livEnt = var27;
                                                   if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                      if (entity instanceof Mob) {
                                                         Mob _mobEnt = (Mob)entity;
                                                         var61 = _mobEnt.m_5448_();
                                                      } else {
                                                         var61 = null;
                                                      }

                                                      label233: {
                                                         var27 = var61;
                                                         if (var27 instanceof LivingEntity) {
                                                            LivingEntity _livEnt = var27;
                                                            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                               var63 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                               break label233;
                                                            }
                                                         }

                                                         var63 = 0;
                                                      }

                                                      label228: {
                                                         if (entity instanceof LivingEntity) {
                                                            LivingEntity _livEnt = (LivingEntity)entity;
                                                            if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                                               var67 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                                               break label228;
                                                            }
                                                         }

                                                         var67 = 0;
                                                      }

                                                      if (var63 > var67) {
                                                         break label331;
                                                      }
                                                   }
                                                }

                                                if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   break label342;
                                                }
                                             }
                                          }
                                       }
                                    }

                                    ++index0;
                                 }
                              }

                              entity.getPersistentData().m_128379_("flag2", true);
                              LivingEntity var64;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var64 = _mobEnt.m_5448_();
                              } else {
                                 var64 = null;
                              }

                              label217: {
                                 LivingEntity var53 = var64;
                                 if (var53 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var53;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var65 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label217;
                                    }
                                 }

                                 var65 = 0;
                              }

                              label212: {
                                 if (entity instanceof LivingEntity) {
                                    _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var68 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label212;
                                    }
                                 }

                                 var68 = 0;
                              }

                              label207: {
                                 if (var65 >= var68 + 5) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var64 = _mobEnt.m_5448_();
                                    } else {
                                       var64 = null;
                                    }

                                    LivingEntity var54 = var64;
                                    if (!(var54 instanceof LivingEntity)) {
                                       break label207;
                                    }

                                    LivingEntity _livEnt34 = var54;
                                    if (!_livEnt34.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       break label207;
                                    }
                                 }

                                 entity.getPersistentData().m_128379_("flag_domain", true);
                                 if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                    tick = 20.0;
                                    rnd = 20.0;
                                 }
                                 break label342;
                              }

                              rnd = 15.0;
                              tick = 625.0;
                           }
                        }
                     }

                     entity.getPersistentData().m_128347_("skill", (double)Math.round(400.0 + rnd));
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     entity.getPersistentData().m_128379_("UseCursedTechnique", false);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
