package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         if (entity.m_6084_()) {
            if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
               GojoSatoruSchoolDaysEntity _datEntL2 = (GojoSatoruSchoolDaysEntity)entity;
               if ((Boolean)_datEntL2.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_dying)) {
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 99, false, false));
                     }
                  }

                  if (!((GojoSatoruSchoolDaysEntity)entity).animationprocedure.equals("death") && entity instanceof GojoSatoruSchoolDaysEntity) {
                     ((GojoSatoruSchoolDaysEntity)entity).setAnimation("death");
                  }

                  entity.getPersistentData().m_128347_("cnt_dying", entity.getPersistentData().m_128459_("cnt_dying") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_dying") > 200.0) {
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_awaking, true);
                     }

                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        GojoSatoruSchoolDaysEntity _datEntSetL = (GojoSatoruSchoolDaysEntity)entity;
                        _datEntSetL.m_20088_().m_135381_(GojoSatoruSchoolDaysEntity.DATA_dying, false);
                     }

                     if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "data merge entity @s {Invulnerable:0b}");
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19600_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        float var131;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var131 = _livEnt.m_21233_();
                        } else {
                           var131 = -1.0F;
                        }

                        _entity.m_21153_(var131);
                     }

                     AnimationResetProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                  }

                  return;
               }
            }

            AIActiveProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128379_("infinity", true);
            WhenPlayerActiveTickInfinityProcedure.execute(entity);
            if (entity.getPersistentData().m_128471_("GojoNoUseInfinity")) {
               if (entity.getPersistentData().m_128459_("cnt_target") > 50.0) {
                  entity.getPersistentData().m_128379_("GojoNoUseInfinity", false);
               } else if (entity.getPersistentData().m_128459_("cnt_target") > 3.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 20, 9, false, false));
                     }
                  }
               } else {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (!(var10000 instanceof LivingEntity) && !world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).isEmpty()) {
                     target_entity = (Entity)world.m_6443_(SukunaFushiguroEntity.class, AABB.m_165882_(new Vec3(x, y, z), 256.0, 256.0, 256.0), (e) -> true).stream().sorted(((<undefinedtype>)(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                           return Comparator.comparingDouble((_entcnd) -> _entcnd.m_20275_(_x, _y, _z));
                        }
                     })).compareDistOf(x, y, z)).findFirst().orElse((Object)null);
                     if (entity instanceof Mob) {
                        Mob _entity = (Mob)entity;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _ent = (LivingEntity)target_entity;
                           _entity.m_6710_(_ent);
                        }
                     }
                  }
               }
            }

            adult = entity instanceof GojoSatoruEntity;
            LivingEntity var114;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var114 = _mobEnt.m_5448_();
            } else {
               var114 = null;
            }

            label658: {
               target_sukuna = var114 instanceof SukunaFushiguroEntity;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt33 = (LivingEntity)entity;
                  if (_livEnt33.m_21023_(MobEffects.f_19600_)) {
                     break label658;
                  }
               }

               if (entity instanceof GojoSatoruSchoolDaysEntity && entity instanceof GojoSatoruSchoolDaysEntity) {
                  GojoSatoruSchoolDaysEntity _datEntL35 = (GojoSatoruSchoolDaysEntity)entity;
                  if ((Boolean)_datEntL35.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, 26, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 2147483647, 26, false, false));
                        }
                     }
                     break label658;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, adult ? 29 : 20, false, false));
                  }
               }
            }

            label632: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt39 = (LivingEntity)entity;
                  if (_livEnt39.m_21023_(MobEffects.f_19606_)) {
                     break label632;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            label627: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt41 = (LivingEntity)entity;
                  if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                     break label627;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get(), 2147483647, 4, false, false));
                  }
               }
            }

            if (entity instanceof GojoSatoruEntity) {
               GojoSatoruEntity _datEntL43 = (GojoSatoruEntity)entity;
               if ((Boolean)_datEntL43.m_20088_().m_135370_(GojoSatoruEntity.DATA_ghost)) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19613_, 60, 1, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt45 = (LivingEntity)entity;
                     if (_livEnt45.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                        entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                     }
                  }
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var114 = _mobEnt.m_5448_();
            } else {
               var114 = null;
            }

            if (var114 instanceof LivingEntity) {
               if (entity.getPersistentData().m_128459_("cnt_target") > 150.0 && target_sukuna) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var114 = _mobEnt.m_5448_();
                  } else {
                     var114 = null;
                  }

                  LivingEntity var34 = var114;
                  if (var34 instanceof Mob) {
                     Mob _mobEnt = (Mob)var34;
                     var114 = _mobEnt.m_5448_();
                  } else {
                     var114 = null;
                  }

                  if (!(var114 instanceof LivingEntity)) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var114 = _mobEnt.m_5448_();
                     } else {
                        var114 = null;
                     }

                     Entity var46 = var114;
                     if (var46 instanceof Mob) {
                        Mob _entity = (Mob)var46;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _ent = (LivingEntity)entity;
                           _entity.m_6710_(_ent);
                        }
                     }
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var114 = _mobEnt.m_5448_();
               } else {
                  var114 = null;
               }

               LivingEntity _livEnt80 = var114;
               ItemStack var120;
               if (_livEnt80 instanceof LivingEntity) {
                  LivingEntity _livEnt = _livEnt80;
                  var120 = _livEnt.m_21205_();
               } else {
                  var120 = ItemStack.f_41583_;
               }

               defense = var120.m_41720_() == JujutsucraftModItems.INVERTED_SPEAR_OF_HEAVEN.get();
               domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && adult;
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  if (!entity.getPersistentData().m_128471_("GojoNoUseInfinity") && target_sukuna) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var120 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
                     } else {
                        var120 = ItemStack.f_41583_;
                     }

                     if (var120.m_41720_() == JujutsucraftModItems.CLOTHES_DECISIVE_BATTLE_CHESTPLATE.get()) {
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(2, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.CHEST, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_CHESTPLATE.get()));
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_150109_().f_35975_.set(1, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                           _player.m_150109_().m_6596_();
                        } else if (entity instanceof LivingEntity) {
                           LivingEntity _living = (LivingEntity)entity;
                           _living.m_8061_(EquipmentSlot.LEGS, new ItemStack((ItemLike)JujutsucraftModItems.CLOTHES_FUSHIGURO_TOJI_LEGGINGS.get()));
                        }
                     }
                  }

                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  float var122;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var122 = _livEnt.m_21223_();
                  } else {
                     var122 = -1.0F;
                  }

                  float var10001;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10001 = _livEnt.m_21233_();
                  } else {
                     var10001 = -1.0F;
                  }

                  label699: {
                     health = (double)(var122 / var10001);
                     if (entity instanceof GojoSatoruSchoolDaysEntity) {
                        if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                           break label699;
                        }

                        GojoSatoruSchoolDaysEntity _datEntL73 = (GojoSatoruSchoolDaysEntity)entity;
                        if (!(Boolean)_datEntL73.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                           break label699;
                        }
                     }

                     purple = entity.getPersistentData().m_128471_("GojoNoUseInfinity") && distance > 32.0;
                     if (!entity.getPersistentData().m_128471_("flag1") && health < 0.3 && (!adult || distance < 32.0)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 20, 0, false, false));
                           }
                        }

                        purple = true;
                     }
                  }

                  if (!domain) {
                     label681: {
                        if (entity instanceof GojoSatoruSchoolDaysEntity) {
                           if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                              break label681;
                           }

                           GojoSatoruSchoolDaysEntity _datEntL78 = (GojoSatoruSchoolDaysEntity)entity;
                           if (!(Boolean)_datEntL78.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                              break label681;
                           }
                        }

                        if (distance < 24.0) {
                           LivingEntity var123;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var123 = _mobEnt.m_5448_();
                           } else {
                              var123 = null;
                           }

                           LivingEntity var36 = var123;
                           if (var36 instanceof LivingEntity) {
                              _livEnt80 = var36;
                              if (_livEnt80.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label684: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt81 = (LivingEntity)entity;
                                       if (_livEnt81.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label684;
                                       }
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var123 = _mobEnt.m_5448_();
                                    } else {
                                       var123 = null;
                                    }

                                    label578: {
                                       LivingEntity var38 = var123;
                                       if (var38 instanceof LivingEntity) {
                                          LivingEntity _livEnt = var38;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             var125 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                             break label578;
                                          }
                                       }

                                       var125 = 0;
                                    }

                                    if (var125 <= 600) {
                                       red = true;
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  label665: {
                     label560: {
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (defense ? 0.3 : 0.5)) {
                              break label560;
                           }

                           if (purple || red) {
                              if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                 break label560;
                              }

                              if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                 GojoSatoruSchoolDaysEntity _datEntL85 = (GojoSatoruSchoolDaysEntity)entity;
                                 if ((Boolean)_datEntL85.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                    break label560;
                                 }
                              }
                           }
                        }

                        if (!domain) {
                           CalculateAttackProcedure.execute(world, entity);
                           break label665;
                        }
                     }

                     if (domain) {
                        rnd = 20.0;
                        tick = 20.0;
                     } else {
                        label544: {
                           label667: {
                              if (!entity.getPersistentData().m_128471_("flag2")) {
                                 if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       GojoSatoruSchoolDaysEntity _datEntL88 = (GojoSatoruSchoolDaysEntity)entity;
                                       if ((Boolean)_datEntL88.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                          break label667;
                                       }
                                    }
                                 } else if (health < 0.5 && distance < 16.0) {
                                    break label667;
                                 }
                              }

                              label668: {
                                 if (!entity.getPersistentData().m_128471_("flag1")) {
                                    if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL92 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL92.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking) && health < 0.5) {
                                             break label668;
                                          }
                                       }
                                    } else if (health < 0.3 && distance < 40.0) {
                                       break label668;
                                    }
                                 }

                                 label669: {
                                    if (red) {
                                       if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                          break label669;
                                       }

                                       if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                          GojoSatoruSchoolDaysEntity _datEntL95 = (GojoSatoruSchoolDaysEntity)entity;
                                          if ((Boolean)_datEntL95.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                             break label669;
                                          }
                                       }
                                    }

                                    label670: {
                                       if (purple) {
                                          if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                                             break label670;
                                          }

                                          if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                             GojoSatoruSchoolDaysEntity _datEntL97 = (GojoSatoruSchoolDaysEntity)entity;
                                             if ((Boolean)_datEntL97.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                break label670;
                                             }
                                          }
                                       }

                                       num1 = 0.0;
                                       int index0 = 0;

                                       while(true) {
                                          if (index0 >= 128) {
                                             break label544;
                                          }

                                          ++num1;
                                          if (num1 > 96.0) {
                                             rnd = 0.0;
                                             break label544;
                                          }

                                          label501: {
                                             rnd = (double)Math.round(4.0 + Math.random() * 16.0);
                                             if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                label672: {
                                                   if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                                      GojoSatoruSchoolDaysEntity _datEntL100 = (GojoSatoruSchoolDaysEntity)entity;
                                                      if ((Boolean)_datEntL100.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                                         break label672;
                                                      }
                                                   }

                                                   if (rnd == 7.0 || rnd == 15.0) {
                                                      break label501;
                                                   }
                                                }
                                             }

                                             if (rnd == 6.0) {
                                                label467: {
                                                   tick = 100.0;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var126 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                         break label467;
                                                      }
                                                   }

                                                   var126 = 0;
                                                }

                                                if (var126 <= 0) {
                                                   break label544;
                                                }
                                             } else if (rnd == 7.0) {
                                                tick = 250.0;
                                                if (!(Math.random() > 0.5) && !(distance > 16.0)) {
                                                   label472: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var127 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                            break label472;
                                                         }
                                                      }

                                                      var127 = 0;
                                                   }

                                                   if (var127 <= 0) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label544;
                                                      }

                                                      LivingEntity _livEnt103 = (LivingEntity)entity;
                                                      if (!_livEnt103.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label544;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == 8.0) {
                                                label479: {
                                                   tick = 100.0;
                                                   if (entity instanceof LivingEntity) {
                                                      LivingEntity _livEnt = (LivingEntity)entity;
                                                      if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                         var128 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                         break label479;
                                                      }
                                                   }

                                                   var128 = 0;
                                                }

                                                if (var128 <= 0) {
                                                   break label544;
                                                }
                                             } else if (rnd == 15.0) {
                                                tick = 500.0;
                                                if (!target_sukuna && !(distance < 8.0)) {
                                                   label484: {
                                                      if (entity instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entity;
                                                         if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                            var129 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                                            break label484;
                                                         }
                                                      }

                                                      var129 = 0;
                                                   }

                                                   if (var129 <= 0 && !(Math.random() > 0.1)) {
                                                      if (!(entity instanceof LivingEntity)) {
                                                         break label544;
                                                      }

                                                      LivingEntity _livEnt106 = (LivingEntity)entity;
                                                      if (!_livEnt106.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                         break label544;
                                                      }
                                                   }
                                                }
                                             } else if (rnd == 20.0) {
                                                tick = 20.0;
                                                if (adult && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                                   LivingEntity var130;
                                                   if (entity instanceof Mob) {
                                                      Mob _mobEnt = (Mob)entity;
                                                      var130 = _mobEnt.m_5448_();
                                                   } else {
                                                      var130 = null;
                                                   }

                                                   LivingEntity var40 = var130;
                                                   if (!(var40 instanceof LivingEntity)) {
                                                      break label544;
                                                   }

                                                   LivingEntity _livEnt108 = var40;
                                                   if (!_livEnt108.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()) || LogicConfilmDomainProcedure.execute(world, x, y, z, entity)) {
                                                      break label544;
                                                   }
                                                }
                                             }
                                          }

                                          ++index0;
                                       }
                                    }

                                    entity.getPersistentData().m_128379_("GojoNoUseInfinity", false);
                                    rnd = 15.0;
                                    tick = 500.0;
                                    break label544;
                                 }

                                 rnd = 7.0;
                                 tick = 250.0;
                                 break label544;
                              }

                              entity.getPersistentData().m_128379_("flag1", true);
                              rnd = 15.0;
                              tick = 500.0;
                              break label544;
                           }

                           entity.getPersistentData().m_128379_("flag2", true);
                           rnd = 7.0;
                           tick = 250.0;
                        }
                     }

                     if (rnd > 0.0) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(200.0 + rnd));
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
                     } else {
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  }

                  if (rnd == 20.0) {
                     if (entity instanceof Player) {
                        Player _player = (Player)entity;
                        _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                        _player.m_150109_().m_6596_();
                     } else if (entity instanceof LivingEntity) {
                        _livEnt80 = (LivingEntity)entity;
                        _livEnt80.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               if (health >= 0.5) {
                  entity.getPersistentData().m_128379_("flag2", false);
               }

               if (health >= 0.3) {
                  entity.getPersistentData().m_128379_("flag1", false);
               }
            }
         }

      }
   }
}
