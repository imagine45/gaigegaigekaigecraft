package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShinjukuEntity;
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelAccessor;

public class AIItadoriYujiProcedure {
   public AIItadoriYujiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double rnd = 0.0;
         double lv_st = 0.0;
         double lv_df = 0.0;
         double distance = 0.0;
         double tick = 0.0;
         double level = 0.0;
         if (entity.m_6084_()) {
            AIActiveProcedure.execute(world, x, y, z, entity);
            if (entity instanceof ItadoriYujiShinjukuEntity) {
               lv_st = 18.0;
               lv_df = 3.0;
            } else if (entity instanceof ItadoriYujiShibuyaEntity) {
               lv_st = 10.0;
               lv_df = 3.0;
            } else {
               lv_st = 7.0;
               lv_df = 2.0;
            }

            label224: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.m_21023_(MobEffects.f_19600_)) {
                     break label224;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, (int)lv_st, false, false));
                  }
               }
            }

            label219: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.m_21023_(MobEffects.f_19606_)) {
                     break label219;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19606_, 2147483647, (int)lv_df, false, false));
                  }
               }
            }

            if (entity instanceof ItadoriYujiEntity) {
               label239: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt8 = (LivingEntity)entity;
                     if (_livEnt8.m_21023_(MobEffects.f_19609_)) {
                        ItemStack var54;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var54 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var54 = ItemStack.f_41583_;
                        }

                        if (var54.m_41720_() != JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s invisibility 1000000 0 true");
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_150109_().f_35975_.set(3, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                              _player.m_150109_().m_6596_();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.m_8061_(EquipmentSlot.HEAD, new ItemStack((ItemLike)JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()));
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_150109_().f_35975_.set(2, ItemStack.f_41583_);
                              _player.m_150109_().m_6596_();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.m_8061_(EquipmentSlot.CHEST, ItemStack.f_41583_);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_150109_().f_35975_.set(1, ItemStack.f_41583_);
                              _player.m_150109_().m_6596_();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.m_8061_(EquipmentSlot.LEGS, ItemStack.f_41583_);
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              _player.m_150109_().f_35975_.set(0, ItemStack.f_41583_);
                              _player.m_150109_().m_6596_();
                           } else if (entity instanceof LivingEntity) {
                              LivingEntity _living = (LivingEntity)entity;
                              _living.m_8061_(EquipmentSlot.FEET, ItemStack.f_41583_);
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.MAIN_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              ItemStack _setstack = ItemStack.f_41583_.m_41777_();
                              _setstack.m_41764_(1);
                              _entity.m_21008_(InteractionHand.OFF_HAND, _setstack);
                              if (_entity instanceof Player) {
                                 Player _player = (Player)_entity;
                                 _player.m_150109_().m_6596_();
                              }
                           }
                        }
                        break label239;
                     }
                  }

                  ItemStack var10000;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entGetArmor = (LivingEntity)entity;
                     var10000 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                  } else {
                     var10000 = ItemStack.f_41583_;
                  }

                  if (var10000.m_41720_() == JujutsucraftModItems.ITADORI_YUJI_PAPER_HELMET.get()) {
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

            LivingEntity var55;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var55 = _mobEnt.m_5448_();
            } else {
               var55 = null;
            }

            if (var55 instanceof LivingEntity) {
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  entity.getPersistentData().m_128347_("cnt_x", 0.0);
                  distance = GetDistanceProcedure.execute(entity);
                  if (LogicStartProcedure.execute(entity) && entity instanceof ItadoriYujiShinjukuEntity) {
                     if (distance < 6.0 && Math.random() < 0.1) {
                        level = 0.0;
                        rnd = 2108.0;
                        tick = 100.0;
                     }

                     if (distance > 12.0 && Math.random() < 0.1) {
                        level = 0.0;
                        rnd = 2113.0;
                        tick = 100.0;
                     }

                     if (distance < 8.0 && Math.random() < 0.1) {
                        level = 0.0;
                        rnd = 2114.0;
                        tick = 50.0;
                     }
                  }

                  label244: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt35 = (LivingEntity)entity;
                        if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           break label244;
                        }
                     }

                     if (entity instanceof ItadoriYujiShibuyaEntity || entity instanceof ItadoriYujiShinjukuEntity) {
                        float var56;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var56 = _livEnt.m_21223_();
                        } else {
                           var56 = -1.0F;
                        }

                        double var57 = (double)var56;
                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.m_21233_();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var57 < (double)var10001 * 0.75 || entity.getPersistentData().m_128459_("cnt_target") > 1200.0) {
                           label245: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get())) {
                                    break label245;
                                 }
                              }

                              level = 1.0;
                              rnd = 2118.0;
                              tick = 50.0;
                           }
                        }
                     }

                     if (distance < 8.0 && Math.random() < 0.2) {
                        level = 1.0;
                        rnd = 2105.0;
                        tick = 25.0;
                     }

                     if (Math.random() < 0.2 && distance < 8.0) {
                        level = 1.0;
                        rnd = 2106.0;
                        tick = 50.0;
                     }
                  }

                  if (rnd > 0.0) {
                     ResetCounterProcedure.execute(entity);
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(rnd));
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
