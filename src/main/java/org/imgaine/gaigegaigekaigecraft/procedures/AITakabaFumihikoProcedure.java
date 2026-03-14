package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
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

public class AITakabaFumihikoProcedure {
   public AITakabaFumihikoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double tick = 0.0;
         double level = 0.0;
         double distance = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  MobEffectInstance var10001 = new MobEffectInstance;
                  MobEffect var10003 = MobEffects.f_19600_;
                  LivingEntity var10005;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10005 = _mobEnt.m_5448_();
                  } else {
                     var10005 = null;
                  }

                  label166: {
                     LivingEntity var20 = var10005;
                     if (var20 instanceof LivingEntity) {
                        LivingEntity _livEnt = var20;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var49 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label166;
                        }
                     }

                     var49 = 0;
                  }

                  var10001.<init>(var10003, 20, var49, false, false);
                  _entity.m_7292_(var10001);
               }
            }

            label154: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt6 = (LivingEntity)entity;
                  if (_livEnt6.m_21023_(MobEffects.f_19606_)) {
                     break label154;
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
               entity.getPersistentData().m_128347_("cnt_x2", Math.max(entity.getPersistentData().m_128459_("cnt_x2"), 20.0) + 1.0);
               if (entity.getPersistentData().m_128459_("skill") == 0.0 && entity.getPersistentData().m_128459_("cnt_x2") > 30.0) {
                  ItemStack var46;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var46 = _livEnt.m_21205_();
                  } else {
                     var46 = ItemStack.f_41583_;
                  }

                  if (var46.m_41720_() != JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.HARISEN.get())).m_41777_();
                     _setstack.m_41764_(1);
                     _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                     if (_entity instanceof Player) {
                        Player _player = (Player)_entity;
                        _player.m_150109_().m_6596_();
                     }
                  }
               }

               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  ResetCounterProcedure.execute(entity);
                  distance = GetDistanceProcedure.execute(entity);
                  rnd = 0.0;
                  level = 0.0;
                  tick = 0.0;
                  if (LogicStartProcedure.execute(entity)) {
                     label186: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt22 = (LivingEntity)entity;
                           if (_livEnt22.m_21023_((MobEffect)JujutsucraftModMobEffects.COMEDIAN.get())) {
                              if (distance > 4.0 && distance < 24.0 && Math.random() < 0.25) {
                                 rnd = 10.0;
                                 level = 0.0;
                                 tick = 200.0;
                              }
                              break label186;
                           }
                        }

                        rnd = 15.0;
                        level = 0.0;
                        tick = 100.0;
                     }
                  }

                  if (rnd != 15.0) {
                     label187: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt23 = (LivingEntity)entity;
                           if (_livEnt23.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              break label187;
                           }
                        }

                        if (distance > 4.0 && distance < 16.0 && Math.random() < 0.25) {
                           rnd = 6.0;
                           level = 1.0;
                           tick = 50.0;
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", 1700.0 + rnd);
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

                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                        }
                     }

                     ItemStack var47;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var47 = _livEnt.m_21205_();
                     } else {
                        var47 = ItemStack.f_41583_;
                     }

                     if (var47.m_41720_() == JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.f_41583_.m_41777_();
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
               if (entity.getPersistentData().m_128459_("cnt_x2") > 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x2", Math.min(entity.getPersistentData().m_128459_("cnt_x2"), 20.0) - 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_x2") <= 0.0) {
                     ItemStack var48;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var48 = _livEnt.m_21205_();
                     } else {
                        var48 = ItemStack.f_41583_;
                     }

                     if (var48.m_41720_() == JujutsucraftModItems.HARISEN.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_x2", 0.0);
                  }
               }

               entity.getPersistentData().m_128379_("flag1", false);
            }
         }

      }
   }
}
