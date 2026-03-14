package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
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

public class AIEightHandledSwrodDivergentSilaDivineGeneralMahoragaProcedure {
   public AIEightHandledSwrodDivergentSilaDivineGeneralMahoragaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double NUM2 = 0.0;
         double NUM1 = 0.0;
         double tick = 0.0;
         double setItem = 0.0;
         double level = 0.0;
         double distance = 0.0;
         boolean StrongEnemy = false;
         boolean cut_the_world = false;
         if (entity.m_6084_()) {
            label193: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               FollowEntityProcedure.execute(world, entity);
               entity.getPersistentData().m_128347_("KnockbackFix", 2.0);
               NUM1 = (double)(23L + Math.round(entity.getPersistentData().m_128459_("Strength") * 0.25));
               NUM2 = Math.min(Math.floor(NUM1 / 4.0), 3.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label193;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            label188: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label188;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)NUM2, false, false));
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
                  label215: {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     ResetCounterProcedure.execute(entity);
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt14 = (LivingEntity)entity;
                        if (_livEnt14.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label215;
                        }
                     }

                     if ((!(distance > 8.0) || !(Math.random() < 0.05)) && (!entity.m_20069_() || !(Math.random() < 0.25))) {
                        if (distance > 8.0 && Math.random() < 0.25) {
                           entity.getPersistentData().m_128347_("skill", (double)Math.round(1608.0F));
                           level = 1.0;
                           tick = 75.0;
                        }
                     } else {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1607.0F));
                        level = 1.0;
                        tick = 125.0;
                     }

                     if (distance < 24.0 && Math.random() < 0.1) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1615.0F));
                        level = 1.0;
                        tick = 150.0;
                     }
                  }

                  if (LogicStartProcedure.execute(entity)) {
                     cut_the_world = false;
                     ItemStack var50;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var50 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var50 = ItemStack.f_41583_;
                     }

                     label204: {
                        if (var50.m_41720_() != JujutsucraftModItems.MAHORAGA_WHEEL_HELMET.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var50 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var50 = ItemStack.f_41583_;
                           }

                           if (var50.m_41720_() != JujutsucraftModItems.MAHORAGA_BODY_HELMET.get()) {
                              break label204;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var50 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var50 = ItemStack.f_41583_;
                        }

                        if (var50.m_41784_().m_128459_("skill205") >= 1000.0) {
                           cut_the_world = true;
                        }
                     }

                     if (cut_the_world && distance < 40.0) {
                        entity.getPersistentData().m_128347_("skill", (double)Math.round(1619.0F));
                        level = 0.0;
                        tick = 250.0;
                     }
                  }

                  label212: {
                     if (entity.getPersistentData().m_128459_("skill") != 0.0) {
                        label208: {
                           if (level > 0.0) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt27 = (LivingEntity)entity;
                                 if (_livEnt27.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                    break label208;
                                 }
                              }
                           } else if (!LogicStartProcedure.execute(entity)) {
                              break label208;
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                              }
                           }

                           if (level > 0.0) {
                              setItem = 1.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)tick, 0, false, false));
                                 }
                              }
                           } else {
                              setItem = 2.0;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 if (!_entity.m_9236_().m_5776_()) {
                                    _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)tick, 0, false, false));
                                 }
                              }
                           }
                           break label212;
                        }
                     }

                     CalculateAttackProcedure.execute(world, entity);
                     if (entity.getPersistentData().m_128459_("skill") != 0.0) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.m_5448_();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().m_128471_("CursedSpirit")) {
                           setItem = 2.0;
                        } else {
                           setItem = Math.random() < 0.5 ? 2.0 : 1.0;
                        }
                     }
                  }

                  if (setItem == 1.0) {
                     ItemStack var54;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var54 = _livEnt.m_21205_();
                     } else {
                        var54 = ItemStack.f_41583_;
                     }

                     if (var54.m_41720_() == JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  } else if (setItem == 2.0) {
                     ItemStack var55;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var55 = _livEnt.m_21205_();
                     } else {
                        var55 = ItemStack.f_41583_;
                     }

                     if (var55.m_41720_() != JujutsucraftModItems.SWORD_OF_EXTERMINATION.get() && entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        ItemStack _setstack = (new ItemStack((ItemLike)JujutsucraftModItems.SWORD_OF_EXTERMINATION.get())).m_41777_();
                        _setstack.m_41764_(1);
                        _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                        if (_entity instanceof Player) {
                           Player _player = (Player)_entity;
                           _player.m_150109_().m_6596_();
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
            }
         }

      }
   }
}
