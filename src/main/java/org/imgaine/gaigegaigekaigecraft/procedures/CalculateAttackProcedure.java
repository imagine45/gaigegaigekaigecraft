package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CalculateAttackProcedure {
   public CalculateAttackProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rnd;
         double ticks;
         double level;
         boolean danger;
         int var10000;
         label603: {
            rnd = 0.0;
            double distance1 = 0.0;
            ticks = 0.0;
            level = 0.0;
            boolean success = false;
            danger = false;
            boolean logic_attack = false;
            boolean can_run_attack = false;
            boolean can_bullet_attack = false;
            boolean can_jump_attack = false;
            boolean can_overhead_attack = false;
            boolean can_swim_attack = false;
            boolean cooltime_combat = false;
            boolean can_speed_attack = false;
            boolean cooltime_default = false;
            boolean logic_rifle = false;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19564_();
                  break label603;
               }
            }

            var10000 = 0;
         }

         boolean var37;
         label597: {
            var37 = var10000 > 0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = 1;
                  break label597;
               }
            }

            var10000 = 0;
         }

         boolean var29;
         label642: {
            boolean var35 = (boolean)var10000;
            if (!var37 || !var35) {
               label639: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entity;
                     if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label639;
                     }
                  }

                  if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                     var29 = false;
                     double var28 = GetDistanceNearestEnemyProcedure.execute(world, entity);
                     Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(5.0)), Block.COLLIDER, Fluid.NONE, entity)).m_82425_().m_123343_());

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(8.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator) {
                           boolean var30 = LogicAttackProcedure.execute(world, entity, entityiterator);
                           if (var30) {
                              if (entityiterator.getPersistentData().m_128459_("Damage") > 0.0 && entityiterator.getPersistentData().m_128459_("skill") > 0.0 && entityiterator.m_6084_()) {
                                 danger = true;
                                 break;
                              }

                              double var70;
                              if (entityiterator instanceof Projectile) {
                                 Projectile _projEnt = (Projectile)entityiterator;
                                 var70 = _projEnt.m_20184_().m_82553_();
                              } else {
                                 var70 = 0.0;
                              }

                              if (var70 > 0.0 && !entity.m_20149_().equals(entityiterator.m_20149_()) || var30 && entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) {
                                 danger = true;
                                 break;
                              }
                           }
                        }
                     }

                     label551: {
                        if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:cant_barrage_attack"))) && !var37) {
                           label547: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                    var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).m_19564_();
                                    break label547;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 < 1) {
                              var10000 = 1;
                              break label551;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var32;
                     label540: {
                        label539: {
                           var32 = (boolean)var10000;
                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:jumping_attackable")))) {
                              label536: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                       break label536;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 if (!(entity instanceof LivingEntity)) {
                                    break label539;
                                 }

                                 LivingEntity _livEnt20 = (LivingEntity)entity;
                                 if (!_livEnt20.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                    break label539;
                                 }
                              }
                           }

                           if (!var35) {
                              label643: {
                                 if (!(var28 > 8.0) || !(var28 < 24.0)) {
                                    double var74 = entity.m_20186_() + (double)entity.m_20206_() + 4.0;
                                    LivingEntity var10001;
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var10001 = _mobEnt.m_5448_();
                                    } else {
                                       var10001 = null;
                                    }

                                    if (!(var74 < ((Entity)var10001).m_20186_())) {
                                       break label643;
                                    }

                                    LivingEntity var75;
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var75 = _mobEnt.m_5448_();
                                    } else {
                                       var75 = null;
                                    }

                                    if (!((Entity)var75).m_20096_()) {
                                       break label643;
                                    }
                                 }

                                 if (!danger) {
                                    var10000 = 1;
                                    break label540;
                                 }
                              }
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var33;
                     label512: {
                        label511: {
                           label611: {
                              var33 = (boolean)var10000;
                              if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:running_attackable")))) {
                                 label507: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                          var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                          break label507;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 <= 3) {
                                    label612: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt29 = (LivingEntity)entity;
                                          if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                                             break label612;
                                          }
                                       }

                                       if (!(entity instanceof LivingEntity)) {
                                          break label611;
                                       }

                                       LivingEntity _livEnt30 = (LivingEntity)entity;
                                       if (!_livEnt30.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                          break label611;
                                       }
                                    }
                                 }
                              }

                              if (!var35) {
                                 label496: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                          var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                          break label496;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 < 1) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label511;
                                    }

                                    LivingEntity _livEnt32 = (LivingEntity)entity;
                                    if (!_livEnt32.m_21023_(MobEffects.f_19612_)) {
                                       break label511;
                                    }
                                 }
                              }
                           }

                           var10000 = 0;
                           break label512;
                        }

                        var10000 = 1;
                     }

                     boolean var31;
                     label479: {
                        label478: {
                           var31 = (boolean)var10000;
                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:overhead_attackable")))) {
                              label475: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                                       break label475;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 label613: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt35 = (LivingEntity)entity;
                                       if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                          break label613;
                                       }
                                    }

                                    if (!(entity instanceof LivingEntity)) {
                                       break label478;
                                    }

                                    LivingEntity _livEnt36 = (LivingEntity)entity;
                                    if (!_livEnt36.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                       break label478;
                                    }
                                 }
                              }
                           }

                           if (!var35 && var28 < 8.0) {
                              var10000 = 1;
                              break label479;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var34;
                     label458: {
                        label457: {
                           label456: {
                              var34 = (boolean)var10000;
                              if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:speed_attackable")))) {
                                 label614: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt38 = (LivingEntity)entity;
                                       if (_livEnt38.m_21023_((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                          break label614;
                                       }
                                    }

                                    if (!(entity instanceof LivingEntity)) {
                                       break label456;
                                    }

                                    LivingEntity _livEnt39 = (LivingEntity)entity;
                                    if (!_livEnt39.m_21023_((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                       break label456;
                                    }
                                 }
                              }

                              if (!var35) {
                                 if (var28 > 8.0 && var28 < 24.0) {
                                    break label457;
                                 }

                                 double var82 = entity.m_20186_() + (double)entity.m_20206_() + 4.0;
                                 LivingEntity var87;
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var87 = _mobEnt.m_5448_();
                                 } else {
                                    var87 = null;
                                 }

                                 if (var82 < ((Entity)var87).m_20186_()) {
                                    LivingEntity var83;
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var83 = _mobEnt.m_5448_();
                                    } else {
                                       var83 = null;
                                    }

                                    if (((Entity)var83).m_20096_()) {
                                       break label457;
                                    }
                                 }
                              }
                           }

                           var10000 = 0;
                           break label458;
                        }

                        var10000 = 1;
                     }

                     boolean var36 = (boolean)var10000;
                     boolean var38 = LogicRifleProcedure.execute(entity);
                     if (!var37 || var33 || var31 || var34 || var36) {
                        for(int index0 = 0; index0 < 255; ++index0) {
                           if (var35) {
                              rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 3);
                           } else if (var37) {
                              rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 4, 7);
                           } else {
                              rnd = (double)Mth.m_216271_(RandomSource.m_216327_(), 1, 7);
                           }

                           if (rnd >= 1.0 && rnd <= 3.0) {
                              if (var37 || rnd == 1.0 && Math.random() < (var32 ? 0.5 : 0.75)) {
                                 continue;
                              }

                              if (rnd == 2.0) {
                              }

                              if (rnd == 3.0 && !var32) {
                                 continue;
                              }
                           }

                           if (!(rnd >= 4.0) || !(rnd <= 7.0) || !var35 && (rnd != 4.0 || var33 && !(Math.random() < 0.5)) && (rnd != 5.0 || var31) && (rnd != 6.0 || var34 && !(Math.random() < 0.75)) && (rnd != 7.0 || var36 && !(Math.random() < 0.75))) {
                              if (var28 > 24.0) {
                                 if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0) {
                                    var29 = true;
                                    break label642;
                                 }
                              } else if (var28 > 16.0) {
                                 if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0 || rnd == 7.0) {
                                    var29 = true;
                                    break label642;
                                 }
                              } else if (var28 > 8.0) {
                                 if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0 || rnd == 7.0) {
                                    var29 = true;
                                    break label642;
                                 }
                              } else if (var28 > 4.0) {
                                 if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                    var29 = true;
                                    break label642;
                                 }
                              } else if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                 var29 = true;
                                 break label642;
                              }

                              if (danger) {
                                 if ((rnd == 3.0 || !(Math.random() < 0.5)) && rnd != 2.0 && rnd != 4.0) {
                                    var29 = true;
                                    break label642;
                                 }
                              } else if (var38 && var28 > 6.0 && var28 < 24.0 && (rnd == 1.0 || rnd == 2.0 || rnd == 3.0)) {
                                 var29 = true;
                                 break label642;
                              }
                           }
                        }
                     }
                     break label642;
                  }
               }
            }

            var29 = false;
         }

         if (var29) {
            entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), 0.0));
            if (rnd == 1.0) {
               ticks = 5.0;
               level = 1.0;
            } else if (rnd == 2.0) {
               ticks = 15.0;
               level = 1.0;
            } else if (rnd == 3.0) {
               ticks = 20.0;
               level = 1.0;
            } else if (rnd == 4.0) {
               ticks = 100.0;
               level = 0.0;
            } else if (rnd == 5.0) {
               ticks = 200.0;
               level = 0.0;
            } else if (rnd == 6.0) {
               ticks = 50.0;
               level = 0.0;
            } else if (rnd == 7.0) {
               ticks = 50.0;
               level = 0.0;
            }

            ResetCounterProcedure.execute(entity);
            entity.getPersistentData().m_128347_("skill", 4199.0 + rnd);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }

            if (level > 0.0) {
               ItemStack var85;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var85 = _entGetArmor.m_6844_(EquipmentSlot.CHEST);
               } else {
                  var85 = ItemStack.f_41583_;
               }

               if (var85.m_41720_() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                  ticks *= 0.5;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity55 = (LivingEntity)entity;
                  if (_livingEntity55.m_21204_().m_22171_(Attributes.f_22283_)) {
                     double var10003;
                     label302: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity56 = (LivingEntity)entity;
                           if (_livingEntity56.m_21204_().m_22171_(Attributes.f_22283_)) {
                              var10003 = _livingEntity56.getAttribute_(Attributes.f_22283_).m_22135_();
                              break label302;
                           }
                        }

                        var10003 = 0.0;
                     }

                     ticks += 20.0 * Math.max(1.7 - var10003, 0.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 1, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 0, false, false));
               }
            }

            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               LivingEntity var86;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var86 = _mobEnt.m_5448_();
               } else {
                  var86 = null;
               }

               LivingEntity _entity = var86;
               if (_entity instanceof LivingEntity) {
                  LivingEntity _livEnt61 = _entity;
                  if (_livEnt61.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
                  }
               }
            }
         } else {
            entity.getPersistentData().m_128347_("cnt_x", Math.max(entity.getPersistentData().m_128459_("cnt_x"), 0.0));
         }

      }
   }
}
