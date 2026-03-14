package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaPerfectEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot.Type;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIOkkotsuProcedure {
   public AIOkkotsuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM1 = ItemStack.f_41583_;
         double rnd = 0.0;
         double tick = 0.0;
         double NUM_COPY = 0.0;
         double copyNum = 0.0;
         double distance = 0.0;
         double level_strength = 0.0;
         double level_resistance = 0.0;
         double level_physical_gifted = 0.0;
         boolean StrongEnemy = false;
         boolean PureLoveCannon = false;
         boolean use_copy = false;
         boolean domain = false;
         boolean awaked = false;
         boolean logicLocateRika = false;
         boolean canUseCopy = false;
         if (entity.m_6084_()) {
            label577: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.m_21023_(MobEffects.f_19600_)) {
                     break label577;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19600_, 2147483647, entity instanceof OkkotsuYutaCullingGameEntity ? 20 : 18, false, false));
                  }
               }
            }

            label572: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.m_21023_(MobEffects.f_19606_)) {
                     break label572;
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

            if (var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               entity.getPersistentData().m_128347_("cnt_rika", 0.0);
               entity.getPersistentData().m_128347_("cnt_x", entity.getPersistentData().m_128459_("cnt_x") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_x") > 10.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
                  label604: {
                     entity.getPersistentData().m_128347_("cnt_x", 0.0);
                     logicLocateRika = LocateRikaProcedure.execute(world, entity);
                     if (!logicLocateRika) {
                        label603: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt15 = (LivingEntity)entity;
                              if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()) && !entity.getPersistentData().m_128471_("Failed")) {
                                 break label603;
                              }
                           }

                           var94 = false;
                           break label604;
                        }
                     }

                     var94 = true;
                  }

                  canUseCopy = var94;
                  if (entity instanceof OkkotsuYutaCullingGameEntity) {
                     CompoundTag var95 = entity.getPersistentData();
                     float var10002;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10002 = _livEnt.m_21223_();
                     } else {
                        var10002 = -1.0F;
                     }

                     double var118 = (double)var10002;
                     float var10003;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var10003 = _livEnt.m_21233_();
                     } else {
                        var10003 = -1.0F;
                     }

                     label548: {
                        label587: {
                           if (!(var118 < (double)var10003 * 0.5)) {
                              LivingEntity var119;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var119 = _mobEnt.m_5448_();
                              } else {
                                 var119 = null;
                              }

                              if (!(var119 instanceof SukunaPerfectEntity)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var119 = _mobEnt.m_5448_();
                                 } else {
                                    var119 = null;
                                 }

                                 if (!(var119 instanceof SukunaFushiguroEntity)) {
                                    break label587;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var119 = _mobEnt.m_5448_();
                              } else {
                                 var119 = null;
                              }

                              LivingEntity var42 = var119;
                              if (!(var42 instanceof LivingEntity)) {
                                 break label587;
                              }

                              LivingEntity _livEnt25 = var42;
                              if (!_livEnt25.m_21023_((MobEffect)JujutsucraftModMobEffects.BRAIN_DAMAGE.get()) || !(entity.getPersistentData().m_128459_("cnt_target") >= 100.0)) {
                                 break label587;
                              }
                           }

                           label532: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var122 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label532;
                                 }
                              }

                              var122 = 0;
                           }

                           int var123 = var122 - 10;
                           LivingEntity var125;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var125 = _mobEnt.m_5448_();
                           } else {
                              var125 = null;
                           }

                           label526: {
                              LivingEntity var89 = var125;
                              if (var89 instanceof LivingEntity) {
                                 LivingEntity _livEnt = var89;
                                 if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                    var126 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                    break label526;
                                 }
                              }

                              var126 = 0;
                           }

                           if (var123 <= var126) {
                              var124 = true;
                              break label548;
                           }
                        }

                        var124 = false;
                     }

                     var95.m_128379_("flag_domain", var124);
                     domain = LogicConfilmDomainProcedure.execute(world, x, y, z, entity);
                  }

                  if (entity instanceof OkkotsuYutaEntity) {
                     label517: {
                        label516: {
                           if (LocateRikaProcedure.execute(world, entity)) {
                              float var96;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var96 = _livEnt.m_21223_();
                              } else {
                                 var96 = -1.0F;
                              }

                              double var97 = (double)var96;
                              float var10001;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var10001 = _livEnt.m_21233_();
                              } else {
                                 var10001 = -1.0F;
                              }

                              if (var97 <= (double)var10001 * 0.2) {
                                 break label516;
                              }

                              LivingEntity var98;
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var98 = _mobEnt.m_5448_();
                              } else {
                                 var98 = null;
                              }

                              if (((Entity)var98).getPersistentData().m_128459_("skill") % 100.0 == 15.0) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var98 = _mobEnt.m_5448_();
                                 } else {
                                    var98 = null;
                                 }

                                 if (((Entity)var98).getPersistentData().m_128459_("skill") != 1815.0) {
                                    break label516;
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var98 = _mobEnt.m_5448_();
                                 } else {
                                    var98 = null;
                                 }

                                 if (((Entity)var98).getPersistentData().m_128459_("cnt9") >= 20.0) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var98 = _mobEnt.m_5448_();
                                    } else {
                                       var98 = null;
                                    }

                                    if (((Entity)var98).getPersistentData().m_128459_("cnt9") <= 25.0) {
                                       break label516;
                                    }
                                 }
                              }
                           }

                           var102 = false;
                           break label517;
                        }

                        var102 = true;
                     }

                     PureLoveCannon = var102;
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  label498: {
                     LivingEntity _entGetArmor = var10000;
                     if (_entGetArmor instanceof LivingEntity) {
                        LivingEntity _livEnt = _entGetArmor;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var104 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label498;
                        }
                     }

                     var104 = 0;
                  }

                  int var117;
                  label493: {
                     var105 = (double)var104;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                           var117 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                           break label493;
                        }
                     }

                     var117 = 0;
                  }

                  StrongEnemy = var105 >= (double)var117 * 0.5 || entity.getPersistentData().m_128459_("cnt_target") > 600.0;
                  ResetCounterProcedure.execute(entity);
                  rnd = 0.0;
                  if (LogicStartProcedure.execute(entity) || domain) {
                     if (domain) {
                        entity.getPersistentData().m_128379_("flag_domain", false);
                        rnd = 20.0;
                        tick = 20.0;
                     } else if ((logicLocateRika || !StrongEnemy) && !PureLoveCannon) {
                        if (Math.random() > 0.75) {
                           rnd = 10.0;
                           tick = 75.0;
                        } else if (!AIDomainLogicProcedure.execute(world, x, y, z, entity) && Math.random() > 0.95 && entity instanceof OkkotsuYutaCullingGameEntity && StrongEnemy) {
                           rnd = 20.0;
                           tick = 20.0;
                        } else if (Math.random() > 0.8) {
                           distance = GetDistanceProcedure.execute(entity);

                           for(int index0 = 0; index0 < 256; ++index0) {
                              rnd = (double)Math.round(Math.random() * 10.0);
                              if (rnd == 3.0) {
                                 tick = 20.0;
                                 if (!(distance < 6.0)) {
                                    break;
                                 }
                              } else if (rnd == 5.0) {
                                 tick = 250.0;
                                 if (canUseCopy && !(Math.random() < 0.5)) {
                                    break;
                                 }
                              } else if (rnd == 6.0) {
                                 tick = 150.0;
                                 if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance < 6.0)) {
                                    break;
                                 }
                              } else if (rnd == 7.0) {
                                 tick = 100.0;
                                 if (entity instanceof OkkotsuYutaCullingGameEntity && canUseCopy && !(distance > 6.0)) {
                                    break;
                                 }
                              } else if (rnd == 10.0) {
                                 tick = 10.0;
                                 if (!(Math.random() < 0.5)) {
                                    break;
                                 }
                              }
                           }
                        } else if (entity instanceof OkkotsuYutaCullingGameEntity && Math.random() > 0.8 && GetDistanceProcedure.execute(entity) < 4.0 && canUseCopy) {
                           use_copy = true;
                           rnd = 106.0;
                           tick = 50.0;
                        } else {
                           label625: {
                              if (entity instanceof OkkotsuYutaEntity) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.m_5448_();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (var10000 instanceof GetoSuguruCurseUserEntity) {
                                    break label625;
                                 }
                              }

                              if (canUseCopy) {
                                 use_copy = false;
                                 NUM_COPY = Math.floor(Math.random() * 4.0);

                                 for(int index1 = 0; index1 < 4; ++index1) {
                                    ItemStack var107;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _entGetArmor = (LivingEntity)entity;
                                       var107 = _entGetArmor.m_6844_(EquipmentSlot.m_20744_(Type.ARMOR, (int)NUM_COPY));
                                    } else {
                                       var107 = ItemStack.f_41583_;
                                    }

                                    ITEM1 = var107.m_41777_();
                                    if (ITEM1.m_41784_().m_128459_("skill") > 0.0) {
                                       use_copy = true;
                                       rnd = ITEM1.m_41784_().m_128459_("skill");
                                       tick = ITEM1.m_41784_().m_128459_("COOLDOWN_TICKS");
                                       break;
                                    }

                                    ++NUM_COPY;
                                    if (NUM_COPY > 3.0) {
                                       NUM_COPY = 0.0;
                                    }
                                 }
                              }
                           }
                        }
                     } else {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 19, false, false));
                           }
                        }

                        if (PureLoveCannon) {
                           rnd = 15.0;
                           tick = 500.0;
                        } else {
                           rnd = 10.0;
                           tick = 75.0;
                        }
                     }
                  }

                  if (rnd > 0.0) {
                     entity.getPersistentData().m_128347_("skill", (double)Math.round(use_copy ? rnd : 500.0 + rnd));
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

                     if (rnd == 15.0) {
                        ItemStack var108;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var108 = _livEnt.m_21205_();
                        } else {
                           var108 = ItemStack.f_41583_;
                        }

                        if (var108.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var108 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var108 = ItemStack.f_41583_;
                           }

                           if (var108.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var108 = _livEnt.m_21205_();
                              } else {
                                 var108 = ItemStack.f_41583_;
                              }

                              CompoundTag _nbtTag = var108.m_41783_();
                              if (_nbtTag != null) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entGetArmor = (LivingEntity)entity;
                                    var108 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                                 } else {
                                    var108 = ItemStack.f_41583_;
                                 }

                                 var108.m_41751_(_nbtTag.m_6426_());
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                              }
                           }
                        }
                     }
                  } else if (PureLoveCannon) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 30, 19, false, false));
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_x", 5.0);
                  } else {
                     CalculateAttackProcedure.execute(world, entity);
                     ItemStack var112;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var112 = _livEnt.m_21205_();
                     } else {
                        var112 = ItemStack.f_41583_;
                     }

                     if (var112.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entGetArmor = (LivingEntity)entity;
                           var112 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                        } else {
                           var112 = ItemStack.f_41583_;
                        }

                        if (var112.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with jujutsucraft:sword_okkotsu_yuta");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var112 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var112 = ItemStack.f_41583_;
                           }

                           CompoundTag _nbtTag = var112.m_41783_();
                           if (_nbtTag != null) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 var112 = _livEnt.m_21205_();
                              } else {
                                 var112 = ItemStack.f_41583_;
                              }

                              var112.m_41751_(_nbtTag.m_6426_());
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with air");
                           }
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_x", 0.0);
               entity.getPersistentData().m_128347_("cnt_rika", entity.getPersistentData().m_128459_("cnt_rika") + 1.0);
               if (entity.getPersistentData().m_128459_("cnt_rika") % 200.0 == 190.0) {
                  if (LocateRikaProcedure.execute(world, entity)) {
                     entity.getPersistentData().m_128347_("cnt1", 20.0);
                     TechniqueRika2Procedure.execute(world, x, y, z, entity);
                  }

                  ItemStack var90;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var90 = _livEnt.m_21205_();
                  } else {
                     var90 = ItemStack.f_41583_;
                  }

                  if (var90.m_41720_() == JujutsucraftModItems.SWORD_OKKOTSU_YUTA.get()) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entGetArmor = (LivingEntity)entity;
                        var90 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                     } else {
                        var90 = ItemStack.f_41583_;
                     }

                     if (var90.m_41720_() == ItemStack.f_41583_.m_41720_()) {
                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s armor.head with jujutsucraft:sword_okkotsu_yuta");
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var90 = _livEnt.m_21205_();
                        } else {
                           var90 = ItemStack.f_41583_;
                        }

                        CompoundTag _nbtTag = var90.m_41783_();
                        if (_nbtTag != null) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entGetArmor = (LivingEntity)entity;
                              var90 = _entGetArmor.m_6844_(EquipmentSlot.HEAD);
                           } else {
                              var90 = ItemStack.f_41583_;
                           }

                           var90.m_41751_(_nbtTag.m_6426_());
                        }

                        if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                           entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
                        }
                     }
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               ItemStack var116;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var116 = _livEnt.m_21205_();
               } else {
                  var116 = ItemStack.f_41583_;
               }

               if (var116.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && !entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "item replace entity @s weapon.mainhand with air");
               }
            }
         }

      }
   }
}
