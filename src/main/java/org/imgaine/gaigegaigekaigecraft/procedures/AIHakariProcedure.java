package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIHakariProcedure {
   public AIHakariProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double tick = 0.0;
         double distance = 0.0;
         double level = 0.0;
         if (entity.m_6084_()) {
            entity.getPersistentData().m_128347_("cnt_break", 0.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get()) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 20, 9, false, false));
                  }
               }
            }

            label225: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19600_)) {
                     break label225;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 11, false, false));
                  }
               }
            }

            label220: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label220;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            label215: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt8 = (LivingEntity)entity;
                  if (_livEnt8.m_21023_(MobEffects.f_19621_)) {
                     break label215;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19621_, 2147483647, 1, false, false));
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
                  if (entity.getPersistentData().m_128459_("cnt_target") > 600.0) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(2, ItemStack.f_41583_);
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _living = (LivingEntity)entity;
                        _living.m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
                     }
                  }

                  ResetCounterProcedure.execute(entity);
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  if (LogicStartProcedure.execute(entity)) {
                     label246: {
                        if ((!(Math.random() < 0.1) || AIDomainLogicProcedure.execute(world, x, y, z, entity)) && !(entity.getPersistentData().m_128459_("cnt_target") > 600.0)) {
                           float var49;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var49 = _livEnt.m_21223_();
                           } else {
                              var49 = -1.0F;
                           }

                           double var50 = (double)var49;
                           float var10001;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10001 = _livEnt.m_21233_();
                           } else {
                              var10001 = -1.0F;
                           }

                           if (!(var50 <= (double)var10001 * 0.75)) {
                              LivingEntity var51;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var51 = _mobEnt.m_5448_();
                              } else {
                                 var51 = null;
                              }

                              label194: {
                                 LivingEntity var27 = var51;
                                 if (var27 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var27;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var52 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label194;
                                    }
                                 }

                                 var52 = 0;
                              }

                              label189: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var55 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label189;
                                    }
                                 }

                                 var55 = 0;
                              }

                              if (var52 < var55 + 5) {
                                 break label246;
                              }
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt26 = (LivingEntity)entity;
                           if (_livEnt26.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label246;
                           }
                        }

                        entity.getPersistentData().m_128379_("flag_domain", true);
                     }
                  }

                  distance = GetDistanceProcedure.execute(entity);
                  rnd = 0.0;
                  if (LogicStartProcedure.execute(entity)) {
                     label243: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt28 = (LivingEntity)entity;
                           if (_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                              if (entity.getPersistentData().m_128459_("Reserve") != 0.0) {
                                 break label243;
                              }

                              float var53;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var53 = _livEnt.m_21223_();
                              } else {
                                 var53 = -1.0F;
                              }

                              double var54 = (double)var53;
                              float var56;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var56 = _livEnt.m_21233_();
                              } else {
                                 var56 = -1.0F;
                              }

                              if (var54 <= (double)var56 * 0.75 && entity.getPersistentData().m_128459_("mode_hakari") == 2.0) {
                                 level = 0.0;
                                 rnd = 7.0;
                                 tick = 0.0;
                                 break label243;
                              }

                              level = 0.0;
                              rnd = 6.0;
                              tick = 37.0;
                              break label243;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt34 = (LivingEntity)entity;
                           if (_livEnt34.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label243;
                           }
                        }

                        if (distance > 6.0 && distance < 12.0 && Math.random() < 0.2) {
                           level = 0.0;
                           rnd = 6.0;
                           tick = 37.0;
                        }
                     }
                  }

                  label161: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label161;
                        }
                     }

                     if (distance > 6.0 && distance < 15.0 && Math.random() < 0.1) {
                        level = 1.0;
                        rnd = 4.0;
                        tick = 50.0;
                     }
                  }

                  if (LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                     label244: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt36 = (LivingEntity)entity;
                           if (_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.JACKPOT.get())) {
                              break label244;
                           }
                        }

                        level = 0.0;
                        rnd = 20.0;
                        tick = 20.0;
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", 2900.0 + rnd);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     if (level > 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                           }
                        }
                     } else if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                        }
                     }

                     if (rnd == 20.0) {
                        entity.getPersistentData().m_128379_("flag_domain", false);
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
