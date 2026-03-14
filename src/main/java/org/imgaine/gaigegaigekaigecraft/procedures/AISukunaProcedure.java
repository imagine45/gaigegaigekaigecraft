package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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

public class AISukunaProcedure {
   public AISukunaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_head = ItemStack.f_41583_;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM_SUM = 0.0;
         double distance = 0.0;
         boolean domain = false;
         boolean infinity = false;
         boolean fushiguro_body = false;
         boolean mahoraga_exist = false;
         boolean vsMahoraga = false;
         boolean flag_megumiTechnique = false;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            fushiguro_body = entity instanceof SukunaFushiguroEntity;
            ItemStack var10000;
            if (entity instanceof LivingEntity) {
               LivingEntity _entGetArmor = (LivingEntity)entity;
               var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
            } else {
               var10000 = ItemStack.f_41583_;
            }

            item_head = var10000.m_41777_();
            if (fushiguro_body && !entity.getPersistentData().m_128471_("flag_start")) {
               entity.getPersistentData().m_128379_("flag_start", true);
               rnd = 4.0;

               for(int index0 = 0; index0 < 7; ++index0) {
                  entity.getPersistentData().m_128347_("TenShadowsTechnique" + Math.round(rnd), 1.0);
                  ++rnd;
               }

               entity.getPersistentData().m_128347_("TenShadowsTechnique1", -2.0);
               entity.getPersistentData().m_128347_("TenShadowsTechnique5", -2.0);
               entity.getPersistentData().m_128347_("TenShadowsTechnique14", 1.0);
            }

            label756: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt9 = (LivingEntity)entity;
                  if (_livEnt9.m_21023_(MobEffects.f_19600_)) {
                     break label756;
                  }
               }

               label801: {
                  if (!(entity instanceof SukunaPerfectEntity)) {
                     label780: {
                        if (entity instanceof SukunaFushiguroEntity) {
                           SukunaFushiguroEntity _datEntL11 = (SukunaFushiguroEntity)entity;
                           if ((Boolean)_datEntL11.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                              break label780;
                           }
                        }

                        if (fushiguro_body) {
                           rnd = 30.0;
                        } else {
                           rnd = 25.0;
                        }
                        break label801;
                     }
                  }

                  rnd = 35.0;
                  entity.getPersistentData().m_128347_("KnockbackFix", 1.0);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)Math.round(rnd), false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), 2147483647, (int)Math.round(Math.min(Math.max(rnd - 11.0, 0.0), 19.0)), false, false));
                  }
               }
            }

            label721: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt15 = (LivingEntity)entity;
                  if (_livEnt15.m_21023_(MobEffects.f_19606_)) {
                     break label721;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, 3, false, false));
                  }
               }
            }

            LivingEntity var111;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var111 = _mobEnt.m_5448_();
            } else {
               var111 = null;
            }

            if (var111 instanceof JogoEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.m_5448_();
               } else {
                  var111 = null;
               }

               if (((Entity)var111).getPersistentData().m_128459_("skill") == 415.0) {
                  if (!entity.getPersistentData().m_128471_("flag2")) {
                     entity.getPersistentData().m_128379_("flag2", true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                     }
                  }
               } else if (entity.getPersistentData().m_128471_("flag2")) {
                  if (GetDistanceProcedure.execute(entity) < 32.0) {
                     if (GetDistanceProcedure.execute(entity) < 6.0 && entity.m_20096_()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.m_21195_(MobEffects.f_19597_);
                        }

                        entity.getPersistentData().m_128379_("PRESS_S", true);
                        WhenBackStepProcedure.execute(world, entity);
                        entity.getPersistentData().m_128379_("PRESS_S", false);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.m_21195_(MobEffects.f_19596_);
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     LivingEntity var27 = var111;
                     if (var27 instanceof LivingEntity) {
                        LivingEntity _entity = var27;
                        _entity.m_21195_(MobEffects.f_19596_);
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     var27 = var111;
                     if (var27 instanceof LivingEntity) {
                        LivingEntity _entity = var27;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 10, 9, false, false));
                        }
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     var27 = var111;
                     if (var27 instanceof LivingEntity) {
                        LivingEntity _entity = var27;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                        }
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var111 = _mobEnt.m_5448_();
                  } else {
                     var111 = null;
                  }

                  if (((Entity)var111).m_20159_()) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     if (((Entity)var111).m_20202_() instanceof MeteorEntity) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 10, 0, false, false));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 10, 0, false, false));
                           }
                        }
                     }
                  }
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var111 = _mobEnt.m_5448_();
            } else {
               var111 = null;
            }

            if (var111 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               if (fushiguro_body) {
                  label781: {
                     if (entity instanceof SukunaFushiguroEntity) {
                        SukunaFushiguroEntity _datEntL50 = (SukunaFushiguroEntity)entity;
                        if ((Boolean)_datEntL50.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                           break label781;
                        }
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     if (!(var111 instanceof GojoSatoruEntity)) {
                        float var120;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var120 = _livEnt.m_21223_();
                        } else {
                           var120 = -1.0F;
                        }

                        double var121 = (double)var120;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var121 <= (double)var10001 * 0.3) {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntSetL = (SukunaFushiguroEntity)entity;
                              _datEntSetL.m_20088_().m_135381_(SukunaFushiguroEntity.DATA_perfect_mode, true);
                           }

                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity animatable = (SukunaFushiguroEntity)entity;
                              animatable.setTexture("sukuna_perfect");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19601_, 10, 10, false, false));
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.offhand with jujutsucraft:supreme_martial_solution");
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.chest with jujutsucraft:sukuna_body_chestplate");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_(MobEffects.f_19600_);
                           }

                           entity.getPersistentData().m_128347_("cnt_reverse_lim", 0.0);
                           entity.getPersistentData().m_128347_("skill", 1.0);
                           ReturnShadowProcedure.execute(world, x, y, z, entity);
                           entity.getPersistentData().m_128347_("skill", 0.0);
                           if (item_head.m_41720_() == JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 _player.m_150109_().f_35975_.set(3, ItemStack.f_41583_);
                                 _player.m_150109_().m_6596_();
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _living = (LivingEntity)entity;
                                 _living.m_8061_(EquipmentSlot.HEAD, ItemStack.f_41583_);
                              }
                           }
                        }
                     }
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var111 = _mobEnt.m_5448_();
               } else {
                  var111 = null;
               }

               label700: {
                  LivingEntity _player = var111;
                  if (_player instanceof LivingEntity) {
                     LivingEntity _livEnt68 = _player;
                     if (_livEnt68.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                        var123 = true;
                        break label700;
                     }
                  }

                  var123 = false;
               }

               infinity = var123;
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               entity.getPersistentData().m_128347_("cnt_rest", 0.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  label812: {
                     mahoraga_exist = entity.getPersistentData().m_128459_("TenShadowsTechnique14") == -1.0;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var111 = _mobEnt.m_5448_();
                     } else {
                        var111 = null;
                     }

                     vsMahoraga = var111 instanceof EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
                     distance = GetDistanceProcedure.execute(entity);
                     if (vsMahoraga && entity.getPersistentData().m_128459_("cnt_target") >= 2400.0 && entity.getPersistentData().m_128459_("cnt_target") <= 3600.0) {
                        entity.getPersistentData().m_128379_("flag_domain", true);
                     }

                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity) && !mahoraga_exist;
                     ResetCounterProcedure.execute(entity);
                     if (fushiguro_body) {
                        label687: {
                           if (entity instanceof SukunaFushiguroEntity) {
                              SukunaFushiguroEntity _datEntL80 = (SukunaFushiguroEntity)entity;
                              if ((Boolean)_datEntL80.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                 break label687;
                              }
                           }

                           if (entity.getPersistentData().m_128459_("cnt_target") > 200.0 && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= 1.0 && item_head.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                              if (entity instanceof Player) {
                                 Player _player = (Player)entity;
                                 _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                                 _player.m_150109_().m_6596_();
                              } else if (entity instanceof LivingEntity) {
                                 LivingEntity _living = (LivingEntity)entity;
                                 _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()));
                              }
                           }
                        }
                     }

                     label682: {
                        label681: {
                           if (!entity.getPersistentData().m_128471_("flag1") && entity instanceof LivingEntity) {
                              LivingEntity _livEnt86 = (LivingEntity)entity;
                              if (_livEnt86.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break label681;
                              }
                           }

                           if (!entity.getPersistentData().m_128471_("flag2")) {
                              break label682;
                           }
                        }

                        if (distance < 48.0 && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19612_, 20, 0, false, false));
                           }
                        }
                     }

                     label803: {
                        if (fushiguro_body) {
                           label818: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL89 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL89.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label818;
                                 }
                              }

                              boolean var143;
                              label662: {
                                 entity.getPersistentData().m_128379_("flag_mahoraga", entity.getPersistentData().m_128459_("TenShadowsTechnique14") > 0.0);
                                 var125 = entity.getPersistentData();
                                 if (entity.getPersistentData().m_128471_("flag_mahoraga")) {
                                    float var10002;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10002 = _livEnt.m_21223_();
                                    } else {
                                       var10002 = -1.0F;
                                    }

                                    double var142 = (double)var10002;
                                    float var10003;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       var10003 = _livEnt.m_21233_();
                                    } else {
                                       var10003 = -1.0F;
                                    }

                                    if (var142 < (double)var10003 * 0.6 || item_head.m_41784_().m_128459_("skill205") >= 100.0 && infinity) {
                                       var143 = true;
                                       break label662;
                                    }
                                 }

                                 var143 = false;
                              }

                              var125.m_128379_("flag_mahoraga", var143);
                              float var126;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var126 = _livEnt.m_21223_();
                              } else {
                                 var126 = -1.0F;
                              }

                              double var127 = (double)var126;
                              float var141;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var141 = _livEnt.m_21233_();
                              } else {
                                 var141 = -1.0F;
                              }

                              if (var127 > (double)var141 * 0.6) {
                                 LivingEntity var128;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var128 = _mobEnt.m_5448_();
                                 } else {
                                    var128 = null;
                                 }

                                 if (var128 instanceof GojoSatoruEntity) {
                                    label648: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                             var129 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()).m_19564_();
                                             break label648;
                                          }
                                       }

                                       var129 = 0;
                                    }

                                    if (var129 < 1) {
                                       entity.getPersistentData().m_128379_("flag_mahoraga", false);
                                    }
                                 }
                              }
                              break label803;
                           }
                        }

                        entity.getPersistentData().m_128379_("flag_mahoraga", false);
                     }

                     label804: {
                        if (fushiguro_body) {
                           label789: {
                              if (entity instanceof SukunaFushiguroEntity) {
                                 SukunaFushiguroEntity _datEntL104 = (SukunaFushiguroEntity)entity;
                                 if ((Boolean)_datEntL104.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
                                    break label789;
                                 }
                              }

                              label815: {
                                 if (entity.getPersistentData().m_128471_("flag_mahoraga") || Math.random() < 0.2 && !infinity) {
                                    label814: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt106 = (LivingEntity)entity;
                                          if (_livEnt106.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                             break label814;
                                          }
                                       }

                                       if (!domain && entity.getPersistentData().m_128459_("TenShadowsTechnique14") >= 1.0) {
                                          break label815;
                                       }
                                    }
                                 }

                                 if (!entity.getPersistentData().m_128471_("flag_agito") || !(entity.getPersistentData().m_128459_("TenShadowsTechnique13") >= 0.0)) {
                                    var130 = false;
                                    break label804;
                                 }
                              }

                              var130 = true;
                              break label804;
                           }
                        }

                        var130 = false;
                     }

                     label615: {
                        flag_megumiTechnique = var130;
                        if (LogicStartProcedure.execute(entity)) {
                           if (Math.random() > (infinity ? 0.75 : 0.0) && distance < 48.0) {
                              break label615;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt110 = (LivingEntity)entity;
                              if (_livEnt110.m_21023_(MobEffects.f_19612_)) {
                                 break label615;
                              }
                           }

                           if (flag_megumiTechnique) {
                              break label615;
                           }
                        }

                        if (!domain) {
                           entity.getPersistentData().m_128347_("cnt_x", 0.0);
                           CalculateAttackProcedure.execute(world, entity);
                           break label812;
                        }
                     }

                     if (flag_megumiTechnique) {
                        AIFushiguroMegumiProcedure.execute(world, x, y, z, entity);
                     } else {
                        entity.getPersistentData().m_128347_("cnt_x", 0.0);
                        if (domain) {
                           rnd = 20.0;
                           tick = 20.0;
                        } else if (entity.getPersistentData().m_128471_("flag2")) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var111 = _mobEnt.m_5448_();
                           } else {
                              var111 = null;
                           }

                           label536: {
                              LivingEntity var32 = var111;
                              if (var32 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var32;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var132 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                    break label536;
                                 }
                              }

                              var132 = 0;
                           }

                           if (var132 <= 20) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var111 = _mobEnt.m_5448_();
                              } else {
                                 var111 = null;
                              }

                              label529: {
                                 LivingEntity var108 = var111;
                                 if (var108 instanceof LivingEntity) {
                                    LivingEntity _livEnt = var108;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var134 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19557_();
                                       break label529;
                                    }
                                 }

                                 var134 = 0;
                              }

                              if (var134 <= 20) {
                                 entity.getPersistentData().m_128379_("flag2", false);
                                 rnd = 7.0;
                                 tick = 250.0;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get());
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get());
                                 }
                              }
                           }
                        } else {
                           label819: {
                              if (!entity.getPersistentData().m_128471_("flag1")) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var111 = _mobEnt.m_5448_();
                                 } else {
                                    var111 = null;
                                 }

                                 if (!(var111 instanceof GojoSatoruEntity) && entity instanceof LivingEntity) {
                                    LivingEntity _livEnt123 = (LivingEntity)entity;
                                    if (_livEnt123.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed") && entity.getPersistentData().m_128459_("dust_amount") > 100.0) {
                                       label596: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt = (LivingEntity)entity;
                                             if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                                var136 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                                break label596;
                                             }
                                          }

                                          var136 = 0;
                                       }

                                       if (var136 < 600 || vsMahoraga) {
                                          entity.getPersistentData().m_128379_("flag1", true);
                                          rnd = 7.0;
                                          tick = 250.0;
                                          break label819;
                                       }
                                    }
                                 }
                              }

                              for(int index1 = 0; index1 < 256; ++index1) {
                                 rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 5, 8);
                                 if (rnd == 8.0) {
                                    rnd = 20.0;
                                 }

                                 if (rnd == 5.0) {
                                    tick = 50.0;
                                    break;
                                 }

                                 if (rnd == 6.0) {
                                    tick = 100.0;
                                    if (!(Math.random() < 0.5) && !infinity && !vsMahoraga) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var111 = _mobEnt.m_5448_();
                                       } else {
                                          var111 = null;
                                       }

                                       if (!(var111 instanceof GojoSatoruEntity)) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var111 = _mobEnt.m_5448_();
                                          } else {
                                             var111 = null;
                                          }

                                          if (!(var111 instanceof JogoEntity) && !(distance > 4.0)) {
                                             break;
                                          }
                                       }
                                    }
                                 } else if (rnd == 7.0) {
                                    tick = 250.0;
                                    if (!infinity) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var111 = _mobEnt.m_5448_();
                                       } else {
                                          var111 = null;
                                       }

                                       if (!(var111 instanceof GojoSatoruEntity)) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var111 = _mobEnt.m_5448_();
                                          } else {
                                             var111 = null;
                                          }

                                          if (!(var111 instanceof JogoEntity) && !(entity.getPersistentData().m_128459_("cnt_target") <= 1200.0) && (!vsMahoraga || entity.getPersistentData().m_128471_("flag1")) && !(Math.random() < 0.9) && !(distance < 8.0)) {
                                             break;
                                          }
                                       }
                                    }
                                 } else if (rnd == 20.0) {
                                    tick = 20.0;
                                    if (!mahoraga_exist && !AIDomainLogicProcedure.execute(world, x, y, z, entity)) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (!(rnd > 0.0)) {
                           CalculateAttackProcedure.execute(world, entity);
                        } else {
                           if (rnd == 20.0) {
                              label522: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt139 = (LivingEntity)entity;
                                    if (_livEnt139.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get())) {
                                       break label522;
                                    }
                                 }

                                 entity.getPersistentData().m_128347_("skill", 1.0);
                                 ReturnShadowProcedure.execute(world, x, y, z, entity);
                              }
                           }

                           if (mahoraga_exist && rnd == 7.0) {
                              tick = 100.0;
                              entity.getPersistentData().m_128347_("skill", 1007.0);
                           } else {
                              entity.getPersistentData().m_128347_("skill", 100.0 + rnd);
                           }

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
                        }
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt146 = (LivingEntity)entity;
                  if (_livEnt146.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt147 = (LivingEntity)entity;
                        if (_livEnt147.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           return;
                        }
                     }

                     entity.getPersistentData().m_128379_("flag1", false);
                  }
               }
            } else {
               entity.getPersistentData().m_128379_("flag2", false);
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_rest", entity.getPersistentData().m_128459_("cnt_rest") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_rest") > 120.0) {
                  entity.getPersistentData().m_128347_("cnt_rest", 0.0);
                  entity.getPersistentData().m_128347_("skill", 1.0);
                  ReturnShadowProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("skill", 0.0);
               }
            }
         }

      }
   }
}
