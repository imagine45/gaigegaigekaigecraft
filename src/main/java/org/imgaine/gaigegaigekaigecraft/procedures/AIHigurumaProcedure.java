package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerLevel;
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

public class AIHigurumaProcedure {
   public AIHigurumaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean domain = false;
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double tick = 0.0;
         double old_skill = 0.0;
         double distance = 0.0;
         double level = 0.0;
         if (entity.m_6084_()) {
            label271: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               lv_st = 10.0;
               lv_df = 3.0;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label271;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label266: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19606_)) {
                     break label266;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)lv_df, false, false));
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt10 = (LivingEntity)entity;
                  if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     label253: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                              var78 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                              break label253;
                           }
                        }

                        var78 = 0;
                     }

                     if (var78 > 0) {
                        entity.getPersistentData().m_128347_("cnt_x3", entity.getPersistentData().m_128459_("cnt_x3") + 1.0);
                        if (entity.getPersistentData().m_128459_("cnt_x3") > 100.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                           entity.getPersistentData().m_128347_("cnt_x3", 0.0);
                           tick = 20.0;
                           rnd = 19.0;
                           entity.getPersistentData().m_128347_("skill", (double)Math.round(2700.0 + rnd));
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

                              return;
                           }
                        }

                        return;
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  entity.getPersistentData().m_128347_("cnt_x2", 0.0);
                  entity.getPersistentData().m_128347_("cnt_x3", 0.0);
                  ItemStack var79;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var79 = _livEnt.m_21205_();
                  } else {
                     var79 = ItemStack.f_41583_;
                  }

                  if (var79.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get()) {
                     label284: {
                        LivingEntity var80;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var80 = _mobEnt.m_5448_();
                        } else {
                           var80 = null;
                        }

                        LivingEntity _livEnt = var80;
                        if (_livEnt instanceof LivingEntity) {
                           LivingEntity _livEnt28 = _livEnt;
                           if (_livEnt28.m_21023_(MobEffects.f_19613_)) {
                              break label284;
                           }
                        }

                        label241: {
                           if (entity instanceof LivingEntity) {
                              _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var81 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label241;
                              }
                           }

                           var81 = 0;
                        }

                        double var82 = (double)var81 * 0.8;
                        LivingEntity var10001;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10001 = _mobEnt.m_5448_();
                        } else {
                           var10001 = null;
                        }

                        label235: {
                           LivingEntity var32 = var10001;
                           if (var32 instanceof LivingEntity) {
                              LivingEntity _livEnt = var32;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var89 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label235;
                              }
                           }

                           var89 = 0;
                        }

                        if (var82 <= (double)var89) {
                           label285: {
                              float var83;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var83 = _livEnt.m_21223_();
                              } else {
                                 var83 = -1.0F;
                              }

                              double var84 = (double)var83;
                              float var90;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var90 = _livEnt.m_21233_();
                              } else {
                                 var90 = -1.0F;
                              }

                              if (!(var84 <= (double)var90 * 0.7) && !(entity.getPersistentData().m_128459_("cnt_target") > 900.0)) {
                                 label226: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var85 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label226;
                                       }
                                    }

                                    var85 = 0;
                                 }

                                 int var86 = var85 * 2;
                                 LivingEntity var91;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var91 = _mobEnt.m_5448_();
                                 } else {
                                    var91 = null;
                                 }

                                 label220: {
                                    LivingEntity var37 = var91;
                                    if (var37 instanceof LivingEntity) {
                                       LivingEntity _livEnt = var37;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var92 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label220;
                                       }
                                    }

                                    var92 = 0;
                                 }

                                 if (var86 > var92) {
                                    break label285;
                                 }
                              }

                              entity.getPersistentData().m_128379_("flag_domain", true);
                           }
                        }
                     }
                  }

                  domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  ResetCounterProcedure.execute(entity);
                  if (domain) {
                     tick = 20.0;
                     rnd = 20.0;
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(2700.0 + rnd));
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

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     entity.getPersistentData().m_128379_("flag_domain", false);
                  } else {
                     label205: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt44 = (LivingEntity)entity;
                           if (_livEnt44.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label205;
                           }
                        }

                        if (distance < 8.0 && Math.random() < 0.1) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var79 = _livEnt.m_21205_();
                           } else {
                              var79 = ItemStack.f_41583_;
                           }

                           if (var79.m_41720_() == JujutsucraftModItems.GAVEL_BIG.get()) {
                              rnd = 2704.0;
                              level = 1.0;
                              tick = 50.0;
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

                              entity.getPersistentData().m_128347_("skill", (double)Math.round(rnd));
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                    return;
                                 }
                              }

                              return;
                           }
                        }
                     }

                     old_skill = entity.getPersistentData().m_128459_("skill");
                     CalculateAttackProcedure.execute(world, entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var79 = _livEnt.m_21205_();
                     } else {
                        var79 = ItemStack.f_41583_;
                     }

                     if (var79.m_41720_() != JujutsucraftModItems.EXECUTIONERS_SWORD.get() && entity.getPersistentData().m_128459_("skill") != old_skill) {
                        rnd = Math.ceil(Math.random() * 3.0);
                        if (rnd == 1.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (rnd == 2.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_LONG.get())).m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        } else if (rnd == 3.0 && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.GAVEL_BIG.get())).m_41777_();
                           _setstack.m_41764_(1);
                           _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                           if (_entity instanceof Player) {
                              Player _player = (Player)_entity;
                              _player.m_150109_().m_6596_();
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_x2", entity.getPersistentData().m_128459_("cnt_x2") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x2") % 200.0 == 60.0 && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
