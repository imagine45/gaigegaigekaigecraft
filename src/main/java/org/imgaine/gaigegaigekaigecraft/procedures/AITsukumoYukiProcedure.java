package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AITsukumoYukiProcedure {
   public AITsukumoYukiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         double health = 0.0;
         boolean logic_a = false;
         boolean logic_start = false;
         boolean domain = false;
         boolean adult = false;
         Entity entity_rika = null;
         if (entity.m_6084_()) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.m_5448_();
               } else {
                  var10000 = null;
               }

               label294: {
                  LivingEntity var27 = var10000;
                  if (var27 instanceof LivingEntity) {
                     LivingEntity _livEnt = var27;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var63 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label294;
                     }
                  }

                  var63 = 0;
               }

               int var10001;
               label289: {
                  var64 = (double)var63 * 0.75;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                        var10001 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                        break label289;
                     }
                  }

                  var10001 = 0;
               }

               if (var64 <= (double)var10001 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get(), 10, 9, false, false));
                  }
               }
            }

            label281: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt7 = (LivingEntity)entity;
                  if (_livEnt7.m_21023_(MobEffects.f_19600_)) {
                     break label281;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 18, false, false));
                  }
               }
            }

            label276: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19606_)) {
                     break label276;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

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
                  if (LogicStartPassiveProcedure.execute(entity) && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 2147483647, 9, false, false));
                     }
                  }

                  label320: {
                     label307: {
                        logic_a = LocateGarudaProcedure.execute(world, entity);
                        logic_start = LogicStartProcedure.execute(entity);
                        domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                        distance = GetDistanceProcedure.execute(entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt19 = (LivingEntity)entity;
                           if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label307;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        LivingEntity _livEnt = var10000;
                        if (_livEnt instanceof Mob) {
                           Mob _mobEnt = (Mob)_livEnt;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 instanceof GarudaEntity || Math.random() < 0.15 && distance < 8.0) {
                           rnd = 4.0;
                           level = 1.0;
                           tick = 50.0;
                           break label320;
                        }
                     }

                     if (logic_start && (Math.random() > 0.75 || !logic_a) || domain) {
                        if (domain) {
                           level = 0.0;
                           tick = 20.0;
                           rnd = 20.0;
                        } else if (!logic_a && logic_start) {
                           rnd = 6.0;
                           level = 0.0;
                           tick = 38.0;
                        } else {
                           float var68;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var68 = _livEnt.m_21223_();
                           } else {
                              var68 = -1.0F;
                           }

                           float var71;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var71 = _livEnt.m_21233_();
                           } else {
                              var71 = -1.0F;
                           }

                           health = (double)(var68 / var71);
                           if (health >= 0.3) {
                              entity.getPersistentData().m_128379_("flag1", false);
                           }

                           if (!entity.getPersistentData().m_128471_("flag1") && health < 0.3 && distance < 32.0) {
                              label238: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var69 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label238;
                                    }
                                 }

                                 var69 = 0;
                              }

                              double var70 = (double)var69 * 0.75;
                              LivingEntity var72;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var72 = _mobEnt.m_5448_();
                              } else {
                                 var72 = null;
                              }

                              label232: {
                                 LivingEntity var30 = var72;
                                 if (var30 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var30;
                                    if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                       var73 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                       break label232;
                                    }
                                 }

                                 var73 = 0;
                              }

                              if (var70 <= (double)var73) {
                                 entity.getPersistentData().m_128379_("flag1", true);
                                 level = 0.0;
                                 rnd = 10.0;
                                 tick = 0.0;
                              }
                           }

                           if (rnd == 0.0) {
                              for(int index0 = 0; index0 < 64; ++index0) {
                                 rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 7);
                                 if (rnd == 7.0) {
                                    rnd = 20.0;
                                 }

                                 if (rnd == 5.0 && logic_start) {
                                    level = 0.0;
                                    tick = 250.0;
                                    if (!(Math.random() < 0.66) && !(distance < 6.0)) {
                                       break;
                                    }
                                 } else {
                                    if (rnd == 6.0 && logic_start) {
                                       level = 0.0;
                                       tick = 38.0;
                                       break;
                                    }

                                    if (rnd == 20.0) {
                                       level = 0.0;
                                       tick = 20.0;
                                       if (!(Math.random() > 0.075)) {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt32 = (LivingEntity)entity;
                                             if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                continue;
                                             }
                                          }

                                          if (!AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                             break;
                                          }
                                       }
                                    } else {
                                       rnd = 0.0;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(900.0 + rnd));
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

                     if ((rnd == 4.0 || rnd == 5.0) && entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                        entity_rika = (new BiFunction<LevelAccessor, String, Entity>() {
                           public Entity apply(LevelAccessor levelAccessor, String uuid) {
                              if (levelAccessor instanceof ServerLevel serverLevel) {
                                 try {
                                    return serverLevel.m_8791_(UUID.fromString(uuid));
                                 } catch (Exception var5) {
                                 }
                              }

                              return null;
                           }
                        }).apply(world, entity.getPersistentData().m_128461_("GARUDA_UUID"));
                        if ((entity_rika instanceof GarudaEntity || entity_rika instanceof GarudaBallEntity) && entity.getPersistentData().m_128459_("friend_num") == entity_rika.getPersistentData().m_128459_("friend_num") && !entity_rika.m_9236_().m_5776_()) {
                           entity_rika.m_146870_();
                        }
                     }

                     if (rnd == 4.0 && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     if (rnd == 5.0 && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GARUDA_ITEM_BALL.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
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
