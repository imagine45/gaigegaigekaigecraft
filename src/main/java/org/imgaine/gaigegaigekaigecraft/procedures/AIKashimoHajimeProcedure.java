package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.HakariKinjiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIKashimoHajimeProcedure {
   public AIKashimoHajimeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean vsSukuna = false;
         boolean MythicalBeastAmber = false;
         double rnd = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         if (entity.m_6084_()) {
            label240: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label240;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 19, false, false));
                  }
               }
            }

            label235: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label235;
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
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  rnd = 0.0;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  label225: {
                     LivingEntity var19 = var10000;
                     if (var19 instanceof LivingEntity) {
                        LivingEntity _livEnt13 = var19;
                        if (_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var52 = true;
                           break label225;
                        }
                     }

                     var52 = false;
                  }

                  label220: {
                     vsSukuna = var52;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt14 = (LivingEntity)entity;
                        if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var53 = true;
                           break label220;
                        }
                     }

                     var53 = false;
                  }

                  MythicalBeastAmber = var53;
                  distance = GetDistanceProcedure.execute(entity);
                  if (MythicalBeastAmber) {
                     entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), 5.0));
                     if (LogicStartProcedure.execute(entity)) {
                        if (Math.random() < 0.25 && distance < 16.0) {
                           rnd = 16.0;
                           tick = 50.0;
                        }

                        if (Math.random() < 0.25 && distance > 6.0) {
                           rnd = 17.0;
                           tick = 125.0;
                        }
                     }
                  }

                  if (rnd == 0.0) {
                     label258: {
                        label261: {
                           if (!MythicalBeastAmber) {
                              if (vsSukuna) {
                                 break label261;
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.m_5448_();
                              } else {
                                 var10000 = null;
                              }

                              label209: {
                                 LivingEntity var33 = var10000;
                                 if (var33 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var33;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var55 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label209;
                                    }
                                 }

                                 var55 = 0;
                              }

                              int var10001;
                              label204: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label204;
                                    }
                                 }

                                 var10001 = 0;
                              }

                              if (var55 >= var10001 * 2) {
                                 break label261;
                              }
                           }

                           label251: {
                              label252: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt20 = (LivingEntity)entity;
                                    if (_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       break label252;
                                    }
                                 }

                                 float var56;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var56 = _livEnt.m_21223_();
                                 } else {
                                    var56 = -1.0F;
                                 }

                                 double var57 = (double)var56;
                                 float var64;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    var64 = _livEnt.m_21233_();
                                 } else {
                                    var64 = -1.0F;
                                 }

                                 if (var57 < (double)var64 * 0.5) {
                                    break label251;
                                 }

                                 LivingEntity var58;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var58 = _mobEnt.m_5448_();
                                 } else {
                                    var58 = null;
                                 }

                                 LivingEntity var48 = var58;
                                 if (var48 instanceof LivingEntity) {
                                    LivingEntity _livEnt24 = var48;
                                    if (_livEnt24.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var58 = _mobEnt.m_5448_();
                                       } else {
                                          var58 = null;
                                       }

                                       var48 = var58;
                                       if (!(var48 instanceof LivingEntity)) {
                                          break label251;
                                       }

                                       LivingEntity _livEnt26 = var48;
                                       if (!_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label251;
                                       }
                                    }
                                 }
                              }

                              label172: {
                                 label265: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt27 = (LivingEntity)entity;
                                       if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                          break label265;
                                       }
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var10000 = _mobEnt.m_5448_();
                                    } else {
                                       var10000 = null;
                                    }

                                    if (!(((Entity)var10000).getPersistentData().m_128459_("Thunder") >= 5.0) && !entity.m_20069_() || !(Math.random() > 0.5) && !(distance > 6.0)) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var10000 = _mobEnt.m_5448_();
                                       } else {
                                          var10000 = null;
                                       }

                                       if (!(((Entity)var10000).getPersistentData().m_128459_("Thunder") >= 15.0)) {
                                          break label265;
                                       }
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var10000 = _mobEnt.m_5448_();
                                    } else {
                                       var10000 = null;
                                    }

                                    if (!(var10000 instanceof HakariKinjiEntity)) {
                                       break label172;
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var10000 = _mobEnt.m_5448_();
                                    } else {
                                       var10000 = null;
                                    }

                                    LivingEntity var50 = var10000;
                                    if (!(var50 instanceof LivingEntity)) {
                                       break label172;
                                    }

                                    LivingEntity _livEnt36 = var50;
                                    if (!_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       break label172;
                                    }
                                 }

                                 rnd = 0.0;
                                 tick = 0.0;
                                 break label258;
                              }

                              rnd = 5.0;
                              tick = 10.0;
                              break label258;
                           }

                           rnd = 10.0;
                           tick = 10.0;
                           break label258;
                        }

                        rnd = 15.0;
                        tick = 10.0;
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", 700.0 + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
