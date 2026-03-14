package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class AIActiveProcedure {
   public AIActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean physicalGifted = false;
         boolean simpleDomain = false;
         boolean simpleDomainning = false;
         boolean logic_run = false;
         boolean zeroCursePower = false;
         boolean Itadori = false;
         boolean blue = false;
         double level_speed = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_health = 0.0;
         double level_speed_set = 0.0;
         double distance = 0.0;
         double level_jump_set = 0.0;
         double level_speed_acceleration = 0.0;
         if (entity.getPersistentData().m_128459_("skill") == 0.0 && (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_simple_domain"))) || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_falling_blossom_emotion"))))) {
            entity.getPersistentData().m_128347_("cnt_simpleDomain", entity.getPersistentData().m_128459_("cnt_simpleDomain") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_simpleDomain") > 10.0) {
               int var10000;
               label453: {
                  entity.getPersistentData().m_128347_("cnt_simpleDomain", 0.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                        break label453;
                     }
                  }

                  var10000 = 0;
               }

               label489: {
                  if (var10000 <= 0) {
                     label479: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt8 = (LivingEntity)entity;
                           if (_livEnt8.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                              break label479;
                           }
                        }

                        var10000 = 0;
                        break label489;
                     }
                  }

                  var10000 = 1;
               }

               label439: {
                  label466: {
                     simpleDomainning = (boolean)var10000;
                     simpleDomain = false;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt9 = (LivingEntity)entity;
                        if (_livEnt9.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label466;
                        }
                     }

                     label433: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label433;
                           }
                        }

                        var10000 = 0;
                     }

                     if (var10000 > 0) {
                        label467: {
                           label427: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                    var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                    break label427;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 == 37) {
                              label420: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()).m_19564_();
                                       break label420;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 > 0) {
                                 break label467;
                              }
                           }

                           label413: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                    var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                    break label413;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 != 39) {
                              label407: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19557_();
                                       break label407;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 >= 5) {
                                 if (simpleDomainning) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label439;
                                    }

                                    LivingEntity _livEnt15 = (LivingEntity)entity;
                                    if (!_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get()) || !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_simple_domain")))) {
                                       break label439;
                                    }

                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt17 = (LivingEntity)entity;
                                       if (_livEnt17.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                                          break label439;
                                       }
                                    }

                                    simpleDomain = true;
                                    break label439;
                                 }

                                 if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_falling_blossom_emotion"))) && entity instanceof LivingEntity) {
                                    LivingEntity _livEnt19 = (LivingEntity)entity;
                                    if (_livEnt19.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                                       break label439;
                                    }
                                 }

                                 entity.getPersistentData().m_128347_("cnt_simpleDomain_spread", entity.getPersistentData().m_128459_("cnt_simpleDomain_spread") + 1.0);
                                 if (entity.getPersistentData().m_128459_("cnt_simpleDomain_spread") > 2.0) {
                                    simpleDomain = true;
                                 }
                                 break label439;
                              }
                           }
                        }
                     }
                  }

                  if (simpleDomainning) {
                     simpleDomain = true;
                  }
               }

               if (simpleDomain) {
                  KeySimpleDomainOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  entity.getPersistentData().m_128347_("cnt_simpleDomain_spread", 0.0);
               }
            }
         }

         LivingEntity var86;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var86 = _mobEnt.m_5448_();
         } else {
            var86 = null;
         }

         if (var86 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 10.0) {
            label369: {
               blue = entity instanceof GojoSatoruEntity && LogicStartPassiveProcedure.execute(entity);
               Itadori = entity instanceof ItadoriYujiEntity || entity instanceof ItadoriYujiShibuyaEntity;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt30 = (LivingEntity)entity;
                  if (_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var87 = true;
                     break label369;
                  }
               }

               var87 = false;
            }

            label364: {
               physicalGifted = var87;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var88 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label364;
                  }
               }

               var88 = 0;
            }

            level = (double)Math.min(var88, 30);
            distance = GetDistanceProcedure.execute(entity);
            if (physicalGifted) {
               label357: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        var89 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                        break label357;
                     }
                  }

                  var89 = 0;
               }

               zeroCursePower = var89 > 0;
               level = zeroCursePower ? (double)Math.round(Math.max(level + 10.0, level * 1.5)) : (double)Math.round(Math.max(level + 3.0, level * 1.2));
            }

            logic_run = false;
            if (distance > 32.0) {
               logic_run = true;
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
               if (distance > 2.0) {
                  logic_run = true;
               }
            } else {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var86 = _mobEnt.m_5448_();
               } else {
                  var86 = null;
               }

               if (((Entity)var86).m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                  logic_run = false;
               }

               if (distance > 4.0) {
                  label345: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           var91 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                           break label345;
                        }
                     }

                     var91 = 0;
                  }

                  if ((double)var91 > distance * 2.0) {
                     logic_run = true;
                  }
               }
            }

            if (distance < 12.0) {
               label335: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        var92 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                        break label335;
                     }
                  }

                  var92 = 0;
               }

               if (var92 > 0) {
                  label329: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                           var93 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                           break label329;
                        }
                     }

                     var93 = 0;
                  }

                  if (var93 > 15) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var86 = _mobEnt.m_5448_();
                     } else {
                        var86 = null;
                     }

                     if (((Entity)var86).getPersistentData().m_128459_("skill") != 0.0) {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var86 = _mobEnt.m_5448_();
                        } else {
                           var86 = null;
                        }

                        if (((Entity)var86).getPersistentData().m_128459_("Damage") > 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var86 = _mobEnt.m_5448_();
                           } else {
                              var86 = null;
                           }

                           if (((Entity)var86).getPersistentData().m_128471_("attack")) {
                              logic_run = false;
                           }
                        }
                     }
                  }
               }
            }

            if (!logic_run) {
               entity.m_6858_(false);
            } else {
               level_speed = (double)Math.round(level / 4.0);
               if (!physicalGifted && !Itadori && !blue) {
                  Math.min(level_speed, 6.0);
               } else {
                  Math.min(level_speed * 1.5, 9.0);
               }

               if (!blue && !zeroCursePower) {
                  if (Itadori) {
                     level_speed_set = 2.0;
                  } else if (physicalGifted) {
                     level_speed_set = 1.0;
                  } else {
                     level_speed_set = 0.0;
                  }
               } else {
                  level_speed_set = 3.0;
               }

               double var10001;
               label308: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19596_)) {
                        var10001 = (double)_livEnt.m_21124_(MobEffects.f_19596_).m_19564_();
                        break label308;
                     }
                  }

                  var10001 = 0.0;
               }

               label475: {
                  label302: {
                     level_speed_set = Math.max(level_speed_set, var10001);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt46 = (LivingEntity)entity;
                        if (_livEnt46.m_21023_(MobEffects.f_19596_)) {
                           break label302;
                        }
                     }

                     if (!entity.m_20096_()) {
                        break label475;
                     }
                  }

                  label295: {
                     level_speed = (double)Math.min(Math.round(level / 4.0), 3L);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt48 = (LivingEntity)entity;
                        if (_livEnt48.m_21023_(MobEffects.f_19596_)) {
                           label291: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19596_)) {
                                    var98 = _livEnt.m_21124_(MobEffects.f_19596_).m_19564_();
                                    break label291;
                                 }
                              }

                              var98 = 0;
                           }

                           ++var98;
                           break label295;
                        }
                     }

                     var98 = 0;
                  }

                  label285: {
                     level_speed_set = (double)var98;
                     level_speed_acceleration = 10.0;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_(MobEffects.f_19596_)) {
                           var99 = _livEnt.m_21124_(MobEffects.f_19596_).m_19557_();
                           break label285;
                        }
                     }

                     var99 = 0;
                  }

                  if (var99 <= 2 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19596_, (int)level_speed_acceleration, (int)Math.min(level_speed_set, level_speed), false, false));
                     }
                  }
               }

               label280: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                        var100 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                        break label280;
                     }
                  }

                  var100 = 0;
               }

               if (var100 < 6) {
                  entity.m_6858_(true);
                  if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                     ItemStack var104;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var104 = _livEnt.m_21205_();
                     } else {
                        var104 = ItemStack.f_41583_;
                     }

                     PlayAnimationItemProcedure.execute(entity, var104, "sprint");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var104 = _livEnt.m_21206_();
                     } else {
                        var104 = ItemStack.f_41583_;
                     }

                     PlayAnimationItemProcedure.execute(entity, var104, "sprint");
                  }
               }
            }

            if (distance > 12.0 || !entity.m_20096_()) {
               level_jump = (double)Math.round(Math.min(level / 4.0, 6.0));
               if (entity.m_20096_()) {
                  level_jump_set = (double)Math.round(Math.min(level_speed_set / 4.0, level / 4.0));
               } else {
                  label267: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt60 = (LivingEntity)entity;
                        if (_livEnt60.m_21023_(MobEffects.f_19603_)) {
                           label262: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                                    var102 = _livEnt.m_21124_(MobEffects.f_19603_).m_19564_();
                                    break label262;
                                 }
                              }

                              var102 = 0;
                           }

                           ++var102;
                           break label267;
                        }
                     }

                     var102 = 0;
                  }

                  level_jump_set = (double)var102;
               }

               label255: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19603_)) {
                        var103 = _livEnt.m_21124_(MobEffects.f_19603_).m_19557_();
                        break label255;
                     }
                  }

                  var103 = 0;
               }

               if (var103 < 2 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance(MobEffects.f_19603_, 8, (int)Math.min(level_jump, level_jump_set), false, false));
                  }
               }
            }
         } else {
            entity.m_6858_(false);
         }

         AIActive2Procedure.execute(world, x, y, z, entity);
      }
   }
}
