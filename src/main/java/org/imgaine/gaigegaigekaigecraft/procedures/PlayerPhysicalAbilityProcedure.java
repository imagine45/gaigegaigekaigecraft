package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerPhysicalAbilityProcedure {
   public PlayerPhysicalAbilityProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double level_jump_set = 0.0;
         double PlayerCT1 = 0.0;
         double level_armor = 0.0;
         double level = 0.0;
         double old_health = 0.0;
         double level_speed_set = 0.0;
         double level_sukuna = 0.0;
         double old_cool = 0.0;
         double level_speed = 0.0;
         double level_armorToughness = 0.0;
         double level_physicalGifted = 0.0;
         double level_power = 0.0;
         double level_resistance = 0.0;
         double level_jump = 0.0;
         double PlayerCT2 = 0.0;
         double level_health = 0.0;
         boolean projectionSorcery = false;
         boolean MythricalBeastAmberEffect = false;
         boolean blue = false;
         boolean YujiItadori = false;
         if (entity.m_6084_() && entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.f_19797_ % 2 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               level = playerVars.PlayerLevel;
               PlayerCT1 = playerVars.PlayerCurseTechnique;
               PlayerCT2 = playerVars.PlayerCurseTechnique2;
               if (PlayerCT1 != 0.0) {
                  boolean var10000;
                  label615: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt1 = (LivingEntity)entity;
                        if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var10000 = 1;
                           break label615;
                        }
                     }

                     var10000 = 0;
                  }

                  MythricalBeastAmberEffect = (boolean)var10000;
                  YujiItadori = PlayerCT1 == 21.0 || PlayerCT2 == 21.0;
                  if (PlayerCT1 == 2.0 || PlayerCT2 == 2.0) {
                     label603: {
                        if (LogicStartPassiveProcedure.execute(entity) && entity instanceof ServerPlayer) {
                           ServerPlayer _plr2 = (ServerPlayer)entity;
                           if (_plr2.m_9236_() instanceof ServerLevel && _plr2.m_8960_().m_135996_(_plr2.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:skill_high_speed"))).m_8193_()) {
                              var10000 = (boolean)1;
                              break label603;
                           }
                        }

                        var10000 = (boolean)0;
                     }

                     blue = var10000;
                  }

                  if (PlayerCT1 == 19.0 || PlayerCT2 == 19.0) {
                     projectionSorcery = LogicStartPassiveProcedure.execute(entity);
                  }

                  if (YujiItadori) {
                     level = Math.max(level + 3.0, level * 1.2);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt3 = (LivingEntity)entity;
                     if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        label585: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).m_19564_();
                                 break label585;
                              }
                           }

                           var10000 = 0;
                        }

                        level_sukuna = (double)Math.min(var10000 + 1, 20);
                        if (level_sukuna <= 10.0) {
                           level = Math.max(level, (double)(15L + Math.round(Math.floor(level_sukuna * 0.5))));
                        } else if (level_sukuna <= 19.0) {
                           level = Math.max(level, (double)(10L + Math.round(Math.floor(level_sukuna * 1.0))));
                        } else {
                           level = Math.max(level, 35.0);
                        }
                     }
                  }

                  if (playerVars.PlayerCursePowerFormer == 0.0) {
                     level = Math.max(level + 6.0, level * 1.4);
                     level_physicalGifted = 5.0;
                  } else if (playerVars.PlayerCursePowerFormer < 100.0) {
                     level = Math.max(level + 3.0, level * 1.2);
                     level_physicalGifted = 1.0;
                  }

                  if (level > 0.0) {
                     level = Math.max(level - 1.0, 0.0);
                     level_power = (double)Math.round(level);
                     level_power = level_power < 3.0 ? Math.min(level_power, 1.0) : level_power;
                     level_resistance = (double)Math.round(level < 3.0 ? 0.0 : Math.min(level / 4.0, 3.0));
                     level_health = (double)Math.round(level >= 19.0 ? 9.0 : Math.min(level / 3.0, 4.0));
                     if (level_sukuna > 0.0) {
                        level_health = (double)Math.round(Math.max(level_health, 14.0));
                     }

                     if (level > 0.0) {
                        if (entity.m_20142_()) {
                           label641: {
                              level_speed = level * 0.5;
                              if (projectionSorcery) {
                                 level_speed = (double)Math.round(Math.min(Math.max(level_speed * 3.0, 10.0), 120.0));
                              } else if (!(level_physicalGifted > 0.0) && !YujiItadori && !MythricalBeastAmberEffect && !blue) {
                                 level_speed = (double)Math.round(Math.min(level_speed, 15.0));
                              } else {
                                 level_speed = (double)Math.round(Math.min(Math.max(level_speed * 2.0, 3.0), 30.0));
                              }

                              label561: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_(MobEffects.f_19596_)) {
                                       var104 = (double)_livEnt.m_21124_(MobEffects.f_19596_).m_19564_();
                                       break label561;
                                    }
                                 }

                                 var104 = 0.0;
                              }

                              level_speed_set = var104;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt7 = (LivingEntity)entity;
                                 if (_livEnt7.m_21023_(MobEffects.f_19596_)) {
                                    label533: {
                                       level_speed_set += (double)(!(level_physicalGifted > 0.0) && !YujiItadori && !MythricalBeastAmberEffect && !projectionSorcery && !blue ? 1 : 2);
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_(MobEffects.f_19596_)) {
                                             var10000 = _livEnt.m_21124_(MobEffects.f_19596_).m_19557_();
                                             break label533;
                                          }
                                       }

                                       var10000 = 0;
                                    }

                                    if (var10000 <= 5 && entity instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entity;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 10, (int)Math.min(level_speed_set, level_speed), false, false));
                                       }
                                    }
                                    break label641;
                                 }
                              }

                              if (entity.m_20096_()) {
                                 if (PlayerCT1 >= 0.0 && PlayerCT2 >= 0.0) {
                                    if (projectionSorcery) {
                                       level_speed_set = 10.0;
                                    } else if (blue) {
                                       level_speed_set = 5.0;
                                    } else if (!YujiItadori && !MythricalBeastAmberEffect) {
                                       level_speed_set = 0.0;
                                    } else {
                                       level_speed_set = 3.0;
                                    }
                                 } else {
                                    level_speed_set = level_physicalGifted;
                                 }

                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entity;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, 20, (int)level_speed_set, false, false));
                                    }
                                 }
                              }
                           }
                        }

                        if (entity.m_6144_() || !entity.m_20096_()) {
                           if (!entity.m_6144_()) {
                              level_jump = (double)Math.round(Math.min(level_speed_set / 4.0, level / 4.0));
                              level_jump_set = level_jump;
                           } else {
                              label643: {
                                 label519: {
                                    level_jump = (double)Math.round(Math.min(level / 4.0, 6.0));
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                                          var106 = (double)_livEnt.m_21124_(MobEffects.f_19603_).m_19564_();
                                          break label519;
                                       }
                                    }

                                    var106 = 0.0;
                                 }

                                 level_jump_set = var106;
                                 ++level_jump_set;
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt16 = (LivingEntity)entity;
                                    if (_livEnt16.m_21023_(MobEffects.f_19603_)) {
                                       break label643;
                                    }
                                 }

                                 level_jump_set = level_speed_set - 1.0;
                              }
                           }

                           label509: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                                    var10000 = _livEnt.m_21124_(MobEffects.f_19603_).m_19557_();
                                    break label509;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 <= 5 && entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              if (!_entity.m_9236_().m_5776_()) {
                                 _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 10, (int)Math.min(level_jump, level_jump_set), false, false));
                              }
                           }
                        }
                     }

                     if (serverPlayer.f_19797_ % 100 == 10) {
                        label503: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt19 = (LivingEntity)entity;
                              if (_livEnt19.m_21023_(MobEffects.f_19600_)) {
                                 label499: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                          var10000 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                          break label499;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (!((double)var10000 < level_power)) {
                                    break label503;
                                 }
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:strength infinite " + Math.round(level_power) + " true");
                           }
                        }

                        label492: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt22 = (LivingEntity)entity;
                              if (_livEnt22.m_21023_(MobEffects.f_19606_)) {
                                 label488: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19606_)) {
                                          var10000 = _livEnt.m_21124_(MobEffects.f_19606_).m_19564_();
                                          break label488;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (!((double)var10000 < level_resistance)) {
                                    break label492;
                                 }
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:resistance infinite " + Math.round(level_resistance) + " true");
                           }
                        }

                        label632: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt25 = (LivingEntity)entity;
                              if (_livEnt25.m_21023_(MobEffects.f_19616_)) {
                                 label477: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_(MobEffects.f_19616_)) {
                                          var10000 = _livEnt.m_21124_(MobEffects.f_19616_).m_19564_();
                                          break label477;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (!((double)var10000 < level_health)) {
                                    break label632;
                                 }
                              }
                           }

                           float var111;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var111 = _livEnt.m_21223_();
                           } else {
                              var111 = -1.0F;
                           }

                           int var10003;
                           label469: {
                              var112 = (double)var111;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19616_)) {
                                    var10003 = _livEnt.m_21124_(MobEffects.f_19616_).m_19564_();
                                    break label469;
                                 }
                              }

                              var10003 = 0;
                           }

                           old_health = var112 + 4.0 * (level_health - (double)var10003 + 1.0);
                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:health_boost infinite " + Math.round(level_health) + " true");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21153_((float)old_health);
                           }
                        }

                        level_armor = level * 1.0;
                        level_armorToughness = level * 0.15;
                        if (YujiItadori) {
                           level_armor += 4.0;
                           level_armorToughness += 0.5;
                        }

                        double var10001;
                        label463: {
                           level_armor = Math.min(level_armor, 30.0);
                           level_armorToughness = Math.min(level_armorToughness, 20.0);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity31 = (LivingEntity)entity;
                              if (_livingEntity31.m_21204_().m_22171_(Attributes.f_22284_)) {
                                 var10001 = _livingEntity31.getAttribute_(Attributes.f_22284_).m_22115_();
                                 break label463;
                              }
                           }

                           var10001 = 0.0;
                        }

                        if (level_armor > var10001 && entity instanceof LivingEntity) {
                           LivingEntity _livingEntity32 = (LivingEntity)entity;
                           if (_livingEntity32.m_21204_().m_22171_(Attributes.f_22284_)) {
                              _livingEntity32.getAttribute_(Attributes.f_22284_).m_22100_(level_armor);
                           }
                        }

                        label457: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity33 = (LivingEntity)entity;
                              if (_livingEntity33.m_21204_().m_22171_(Attributes.f_22285_)) {
                                 var10001 = _livingEntity33.getAttribute_(Attributes.f_22285_).m_22115_();
                                 break label457;
                              }
                           }

                           var10001 = 0.0;
                        }

                        if (level_armorToughness > var10001 && entity instanceof LivingEntity) {
                           LivingEntity _livingEntity34 = (LivingEntity)entity;
                           if (_livingEntity34.m_21204_().m_22171_(Attributes.f_22285_)) {
                              _livingEntity34.getAttribute_(Attributes.f_22285_).m_22100_(level_armorToughness);
                           }
                        }

                        if (PlayerCT1 >= 0.0 && PlayerCT2 >= 0.0) {
                           if (PlayerCT1 != 1.0 && PlayerCT2 != 1.0 && PlayerCT1 != 4.0 && PlayerCT2 != 4.0) {
                              if (PlayerCT1 == 8.0 || PlayerCT2 == 8.0) {
                                 label671: {
                                    label433: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt37 = (LivingEntity)entity;
                                          if (_livEnt37.m_21023_(MobEffects.f_19593_)) {
                                             break label433;
                                          }
                                       }

                                       if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                          entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:dolphins_grace infinite 4 true");
                                       }
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt39 = (LivingEntity)entity;
                                       if (_livEnt39.m_21023_(MobEffects.f_19608_)) {
                                          break label671;
                                       }
                                    }

                                    if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                       entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:water_breathing infinite 0 true");
                                    }
                                 }
                              }
                           } else {
                              label670: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt35 = (LivingEntity)entity;
                                    if (_livEnt35.m_21023_(MobEffects.f_19607_)) {
                                       break label670;
                                    }
                                 }

                                 if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                    entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:fire_resistance infinite 0 true");
                                 }
                              }
                           }
                        } else if (level_physicalGifted > 0.0) {
                           label645: {
                              --level_physicalGifted;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt41 = (LivingEntity)entity;
                                 if (_livEnt41.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                    label445: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                             var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                             break label445;
                                          }
                                       }

                                       var10000 = 0;
                                    }

                                    if (!((double)var10000 < level_physicalGifted)) {
                                       break label645;
                                    }
                                 }
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:physical_gifted_effect infinite " + Math.round(level_physicalGifted) + " true");
                              }
                           }
                        }
                     }
                  }

                  if (serverPlayer.f_19797_ % 10 == 0 && PlayerCT1 == 10.0 && entity.m_20071_()) {
                     old_cool = entity.getPersistentData().m_128459_("COOLDOWN_TICKS");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                        }
                     }

                     entity.getPersistentData().m_128347_("COOLDOWN_TICKS", old_cool);
                  }

                  if (serverPlayer.f_19797_ % 100 == 10) {
                     if (playerVars.FlagSixEyes) {
                        label410: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt48 = (LivingEntity)entity;
                              if (_livEnt48.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                 break label410;
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:six_eyes infinite 0 true");
                           }
                        }
                     }

                     if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                        label404: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt51 = (LivingEntity)entity;
                              if (_livEnt51.m_21023_(MobEffects.f_19611_)) {
                                 break label404;
                              }
                           }

                           if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                              entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s minecraft:night_vision infinite 0 true");
                           }
                        }
                     }

                     if (playerVars.flag_sukuna) {
                        label647: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt53 = (LivingEntity)entity;
                              if (_livEnt53.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label647;
                              }
                           }

                           level_sukuna = GetSukunaLevelProcedure.execute(entity);
                           if (level_sukuna > 0.0) {
                              level_sukuna = (double)Math.round(Math.min(Math.max(level_sukuna, 1.0), 20.0));
                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:sukuna_effect infinite " + Math.round(level_sukuna) + " true");
                              }
                           }
                        }
                     }
                  }

                  if ((PlayerCT2 == 38.0 || PlayerCT1 == 38.0) && LogicStartPassiveProcedure.execute(entity)) {
                     entity.f_19789_ = 0.0F;
                     if (entity.m_20096_() || entity.m_20069_()) {
                        label383: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                                 var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).m_19564_();
                                 break label383;
                              }
                           }

                           var10000 = 0;
                        }

                        if (var10000 < 5 && entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              MobEffectInstance var116;
                              MobEffect var117;
                              int var10004;
                              label375: {
                                 var116 = new MobEffectInstance;
                                 var117 = (MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                                       var10004 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).m_19557_();
                                       break label375;
                                    }
                                 }

                                 var10004 = 0;
                              }

                              var116.<init>(var117, Math.min(var10004 + 10, 60), 0, true, true);
                              _entity.m_7292_(var116);
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
