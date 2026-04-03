package org.imgaine.gaigegaigekaigecraft.procedures;

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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CalculateAttackProcedure {
   public CalculateAttackProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean success;
         boolean danger;
         double rnd;
         double ticks;
         double level;
         int var10000;
         label534: {
            success = false;
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
            rnd = 0.0;
            double distance1 = 0.0;
            ticks = 0.0;
            level = 0.0;
            double weapon_size = 0.0;
            double range = 0.0;
            double x_pos = 0.0;
            double attack_reach = 0.0;
            double pitch = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = 1;
                  break label534;
               }
            }

            var10000 = 0;
         }

         boolean var52;
         label529: {
            var52 = var10000 != 0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                  break label529;
               }
            }

            var10000 = 0;
         }

         label569: {
            boolean var54 = var10000 > 0;
            if (!var52 || !var54) {
               label568: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt2 = (LivingEntity)entity;
                     if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label568;
                     }
                  }

                  if (entity.getPersistentData().getDouble("skill") == 0.0) {
                     double var57 = GetWeaponSizeProcedure.execute(entity);
                     double var61 = GetReachProcedure.execute(entity);
                     double var58 = ReturnEntitySizeProcedure.execute(entity);
                     var58 = var58 * var58 * Math.sqrt(var57 * var61);
                     double var65 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                     double var62 = Math.toRadians((double)entity.getXRot());
                     double var66 = 2.5 * var58;
                     double var60 = entity.getX() + Math.cos(var65) * Math.cos(var62) * var66;
                     double var63 = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(var62) * -1.0 * var66;
                     double var64 = entity.getZ() + Math.sin(var65) * Math.cos(var62) * var66;
                     Vec3 _center = new Vec3(var60, var63, var64);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0 * var58 / 2.0), (e) -> true)) {
                        if (entity != entityiterator) {
                           if (entityiterator instanceof Projectile) {
                              if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                 danger = true;
                                 break;
                              }
                           } else {
                              boolean var47 = LogicAttackProcedure.execute(world, entity, entityiterator);
                              if (var47) {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt12 = (LivingEntity)entity;
                                    if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                                       label501: {
                                          if (entity instanceof LivingEntity) {
                                             LivingEntity _livEnt13 = (LivingEntity)entity;
                                             if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                                break label501;
                                             }
                                          }

                                          if (!AntiInfinityProcedure.execute(entityiterator)) {
                                             continue;
                                          }
                                       }
                                    }
                                 }

                                 if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 && entityiterator.getPersistentData().getDouble("skill") > 0.0 && entityiterator.isAlive()) {
                                    danger = true;
                                    break;
                                 }

                                 if (var47 && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                    danger = true;
                                    break;
                                 }
                              }
                           }
                        }
                     }

                     double var56;
                     label484: {
                        var56 = GetDistanceProcedure.execute(entity);
                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:cant_barrage_attack"))) && !var54) {
                           label480: {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get())) {
                                    var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SPECIAL.get()).getAmplifier();
                                    break label480;
                                 }
                              }

                              var10000 = 0;
                           }

                           if (var10000 < 1) {
                              var10000 = 1;
                              break label484;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var49;
                     label473: {
                        label472: {
                           var49 = var10000 != 0;
                           if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:jumping_attackable")))) {
                              label469: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                       break label469;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 if (!(entity instanceof LivingEntity)) {
                                    break label472;
                                 }

                                 LivingEntity _livEnt23 = (LivingEntity)entity;
                                 if (!_livEnt23.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                    break label472;
                                 }
                              }
                           }

                           if (!var52 && var56 > 8.0 && var56 < 32.0 && !danger) {
                              var10000 = 1;
                              break label473;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var50;
                     label454: {
                        label453: {
                           label541: {
                              var50 = var10000 != 0;
                              if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:running_attackable")))) {
                                 label449: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                          var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                          break label449;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 <= 3) {
                                    label542: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt26 = (LivingEntity)entity;
                                          if (_livEnt26.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                                             break label542;
                                          }
                                       }

                                       if (!(entity instanceof LivingEntity)) {
                                          break label541;
                                       }

                                       LivingEntity _livEnt27 = (LivingEntity)entity;
                                       if (!_livEnt27.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                          break label541;
                                       }
                                    }
                                 }
                              }

                              if (!var52) {
                                 label438: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                          var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                                          break label438;
                                       }
                                    }

                                    var10000 = 0;
                                 }

                                 if (var10000 < 1) {
                                    if (!(entity instanceof LivingEntity)) {
                                       break label453;
                                    }

                                    LivingEntity _livEnt29 = (LivingEntity)entity;
                                    if (!_livEnt29.hasEffect(MobEffects.HUNGER)) {
                                       break label453;
                                    }
                                 }
                              }
                           }

                           var10000 = 0;
                           break label454;
                        }

                        var10000 = 1;
                     }

                     boolean var48;
                     label421: {
                        label420: {
                           var48 = var10000 != 0;
                           if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:overhead_attackable")))) {
                              label417: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                                       var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier();
                                       break label417;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 3) {
                                 label543: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt32 = (LivingEntity)entity;
                                       if (_livEnt32.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                          break label543;
                                       }
                                    }

                                    if (!(entity instanceof LivingEntity)) {
                                       break label420;
                                    }

                                    LivingEntity _livEnt33 = (LivingEntity)entity;
                                    if (!_livEnt33.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                       break label420;
                                    }
                                 }
                              }
                           }

                           if (!var52 && var56 < 8.0) {
                              var10000 = 1;
                              break label421;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var51;
                     label400: {
                        label572: {
                           var51 = var10000 != 0;
                           if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:speed_attackable"))) || !(Math.random() < 0.1)) {
                              label570: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt35 = (LivingEntity)entity;
                                    if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.INSECT_ARMOR_TECHNIQUE.get())) {
                                       break label570;
                                    }
                                 }

                                 if (!(entity instanceof LivingEntity)) {
                                    break label572;
                                 }

                                 LivingEntity _livEnt36 = (LivingEntity)entity;
                                 if (!_livEnt36.hasEffect((MobEffect)JujutsucraftModMobEffects.INSTANT_SPIRIT_BODYOF_DISTORTED_KILLING_EFFECT.get())) {
                                    break label572;
                                 }
                              }
                           }

                           if (!var52 && var56 > 8.0 && var56 < 24.0) {
                              var10000 = 1;
                              break label400;
                           }
                        }

                        var10000 = 0;
                     }

                     boolean var53 = var10000 != 0;
                     boolean var55 = LogicRifleProcedure.execute(world, entity);
                     int index0 = 0;

                     while(true) {
                        if (index0 >= 32) {
                           break label569;
                        }

                        if (var52) {
                           rnd = (double)Mth.nextInt(RandomSource.create(), 1, 3);
                        } else {
                           rnd = (double)Mth.nextInt(RandomSource.create(), 1, 7);
                        }

                        label546: {
                           if (rnd >= 1.0 && rnd <= 3.0) {
                              if (rnd == 1.0 && Math.random() < (var49 ? 0.5 : 0.75)) {
                                 break label546;
                              }

                              if (rnd == 2.0) {
                              }

                              if (rnd == 3.0 && !var49) {
                                 break label546;
                              }
                           }

                           if (!(rnd >= 4.0) || !(rnd <= 7.0) || (rnd != 4.0 || var50) && (rnd != 5.0 || var48) && (rnd != 6.0 || var51) && (rnd != 7.0 || var53)) {
                              if (var56 > 20.0 * var58) {
                                 if (rnd == 4.0 || rnd == 5.0) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > 10.0 * var58) {
                                 if (rnd == 4.0 || rnd == 5.0 || rnd == 7.0) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > 5.0 * var58) {
                                 if (rnd == 4.0 || rnd == 5.0 || rnd == 6.0 || rnd == 7.0) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var56 > 2.5 * var58) {
                                 if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (rnd == 1.0 || rnd == 2.0 || rnd == 3.0 || rnd == 5.0 || rnd == 6.0) {
                                 success = true;
                                 break label569;
                              }

                              if (danger) {
                                 if ((rnd == 3.0 || !(Math.random() < 0.75)) && rnd != 2.0 && rnd != 4.0) {
                                    success = true;
                                    break label569;
                                 }
                              } else if (var55 && var56 > 6.0 && var56 < 24.0 && (rnd == 1.0 || rnd == 2.0 || rnd == 3.0)) {
                                 success = true;
                                 break label569;
                              }
                           }
                        }

                        ++index0;
                     }
                  }
               }
            }

            success = false;
         }

         if (success) {
            entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
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
            entity.getPersistentData().putDouble("skill", 4199.0 + rnd);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
               }
            }

            if (level > 0.0) {
               ItemStack var104;
               if (entity instanceof LivingEntity) {
                  LivingEntity _entGetArmor = (LivingEntity)entity;
                  var104 = _entGetArmor.getItemBySlot(EquipmentSlot.CHEST);
               } else {
                  var104 = ItemStack.EMPTY;
               }

               if (var104.getItem() == JujutsucraftModItems.SUKUNA_BODY_CHESTPLATE.get()) {
                  ticks *= 0.5;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity45 = (LivingEntity)entity;
                  if (_livingEntity45.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                     double var10003;
                     label269: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity46 = (LivingEntity)entity;
                           if (_livingEntity46.getAttributes().hasAttribute(Attributes.ATTACK_SPEED)) {
                              var10003 = _livingEntity46.getAttribute(Attributes.ATTACK_SPEED).getValue();
                              break label269;
                           }
                        }

                        var10003 = 0.0;
                     }

                     ticks += 20.0 * Math.max(1.7 - var10003, 0.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 1, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)Math.round(ticks), 0, false, false));
               }
            }

            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_domain_amplification")))) {
               LivingEntity var105;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var105 = _mobEnt.getTarget();
               } else {
                  var105 = null;
               }

               LivingEntity _entity = var105;
               if (_entity instanceof LivingEntity) {
                  LivingEntity _livEnt51 = _entity;
                  if (_livEnt51.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     if (entity instanceof LivingEntity) {
                        _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     KeyDomainAmplificationOnKeyPressedProcedure.execute(entity);
                  }
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 0.0));
         }

      }
   }
}
