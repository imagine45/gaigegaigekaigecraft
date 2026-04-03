package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.Commands;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;

public class AIActive2Procedure {
   public AIActive2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         ItemStack mainItem = ItemStack.EMPTY;
         ItemStack offItem = ItemStack.EMPTY;
         boolean logic_guard = false;
         boolean logic_heal = false;
         boolean logic_heal_cancel = false;
         boolean test = false;
         boolean target = false;
         boolean logic_avoid = false;
         boolean using = false;
         boolean output = false;
         boolean infinity = false;
         boolean using2 = false;
         double x_knockback = 0.0;
         double y_knockback = 0.0;
         double z_knockback = 0.0;
         double dis = 0.0;
         double old_skill = 0.0;
         double limit = 0.0;
         double distance = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double fix = 0.0;
         double x_power = 0.0;
         double speed = 0.0;
         double level_neutralization = 0.0;
         logic_heal_cancel = true;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }
         LivingEntity var54;
         double var133;
         label754: {
            var54 = var10000;
            entity.getPersistentData().putDouble("cnt_guard", Math.max(entity.getPersistentData().getDouble("cnt_guard") - 1.0, 0.0));
            entity.getPersistentData().putDouble("cnt_backstep", Math.max(entity.getPersistentData().getDouble("cnt_backstep") - 1.0, 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  var133 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                  break label754;
               }
            }

            var133 = 0.0;
         }

         level_neutralization = var133;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt6 = (LivingEntity)entity;
            if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()) && level_neutralization == 37.0) {
               return;
            }
         }

         if (entity.getPersistentData().getDouble("cnt_target") > 6.0) {
            test = entity.getPersistentData().getDouble("cnt_target") % 5.0 == 4.0;
            target = var54 instanceof LivingEntity;
         }

         distance = 99.0;
         if (entity.getPersistentData().getDouble("skill") == 0.0) {
            if (target) {
               boolean var134;
               label743: {
                  label742: {
                     distance = GetDistanceProcedure.execute(entity);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                           if (!(entity instanceof LivingEntity)) {
                              break label742;
                           }

                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (!_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label742;
                           }
                        }
                     }

                     var134 = false;
                     break label743;
                  }

                  var134 = true;
               }

               infinity = var134;
               if (test) {
                  logic_heal_cancel = false;
               }

               label761: {
                  label762: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt13 = (LivingEntity)entity;
                        if (_livEnt13.hasEffect((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                           break label762;
                        }
                     }

                     if (((Entity)var54).getPersistentData().getDouble("skill") == 0.0 || !(((Entity)var54).getPersistentData().getDouble("Damage") > 0.0)) {
                        break label761;
                     }
                  }

                  if (!infinity || AntiInfinityProcedure.execute(var54)) {
                     logic_heal_cancel = true;
                     if (test) {
                        logic_guard = true;
                     }
                  }
               }

               if (test) {
                  if (!logic_guard) {
                     label716: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt16 = (LivingEntity)entity;
                           if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              break label716;
                           }
                        }

                        if (level_neutralization > 0.0 && level_neutralization != 37.0) {
                           logic_guard = true;
                        }
                     }
                  }

                  if (!logic_guard) {
                     label709: {
                        dis = 24.0;
                        if (!(entity instanceof UroTakakoEntity)) {
                           if (!(entity instanceof LivingEntity)) {
                              break label709;
                           }

                           LivingEntity _livEnt18 = (LivingEntity)entity;
                           if (!_livEnt18.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label709;
                           }
                        }

                        dis = 36.0;
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis / 2.0), (e) -> true)) {
                        if (entity != entityiterator && (!infinity || AntiInfinityProcedure.execute(entityiterator))) {
                           if (entityiterator instanceof Projectile) {
                              if (DetectEnemyProjectileProcedure.execute(entity, entityiterator)) {
                                 logic_avoid = true;
                                 logic_guard = true;
                                 break;
                              }
                           } else if ((entityiterator.getPersistentData().getDouble("skill") != 0.0 || entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) && entityiterator.getPersistentData().getDouble("Damage") > 0.0 && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              logic_avoid = true;
                              logic_guard = true;
                              break;
                           }
                        }
                     }
                  }

                  if (!logic_guard) {
                     dis = 16.0;
                     if (entity instanceof UroTakakoEntity) {
                        dis = 32.0;
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis / 2.0), (e) -> true)) {
                        if (entity != entityiterator && (!infinity || AntiInfinityProcedure.execute(entityiterator)) && entityiterator.getPersistentData().getDouble("skill") != 0.0 && (entityiterator.getPersistentData().getDouble("Damage") > 0.0 || entityiterator.getPersistentData().getBoolean("PRESS_Z")) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_avoid = true;
                           logic_guard = true;
                           break;
                        }
                     }
                  }

                  if (logic_avoid) {
                     int var135;
                     label768: {
                        if (entity.getPersistentData().getDouble("skill") != 0.0) {
                           logic_avoid = false;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt32 = (LivingEntity)entity;
                           if (_livEnt32.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              label659: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var135 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                       break label659;
                                    }
                                 }

                                 var135 = 0;
                              }

                              if (var135 < 6) {
                                 logic_avoid = false;
                              }
                              break label768;
                           }
                        }

                        logic_avoid = false;
                     }
                  }

                  if (entity.getPersistentData().getBoolean("CursedSpirit") && entity instanceof LivingEntity) {
                     LivingEntity _livEnt35 = (LivingEntity)entity;
                     if (_livEnt35.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        logic_avoid = true;
                     }
                  }
               }
               int var136;
               logic_heal_cancel = logic_heal_cancel || logic_guard;
               if (!logic_avoid && (!infinity || AntiInfinityProcedure.execute(var54))) {
                  label645: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           var136 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                           break label645;
                        }
                     }

                     var136 = 0;
                  }
                  if (var136 > 10 || entity.getPersistentData().getDouble("cnt_x") < 0.0) {
                     int var137;
                     label639: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              var137 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getAmplifier();
                              break label639;
                           }
                        }

                        var137 = 0;
                     }

                     if (var137 > 0) {
                        int var138;
                        label632: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                 var138 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                 break label632;
                              }
                           }

                           var138 = 0;
                        }

                        if (var138 > 10 && distance < 6.0) {
                           logic_avoid = true;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt40 = (LivingEntity)entity;
                        if (_livEnt40.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()) && distance < 24.0 && ((Entity)var54).getPersistentData().getDouble("skill") != 0.0 && ((Entity)var54).getPersistentData().getDouble("skill") > -900.0) {
                           logic_avoid = true;
                        }
                     }
                  }
               }

               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:no_guard")))) {
                  logic_guard = false;
               }

               logic_heal_cancel = logic_heal_cancel || logic_avoid;
            } else {
               logic_heal_cancel = false;
            }
         }

         if (logic_guard) {
            StartGuardProcedure.execute(world, entity);
            entity.getPersistentData().putDouble("cnt_guard", 20.0);
            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_domain_amplification")))) {
               label612: {
                  if (var54 instanceof LivingEntity) {
                     if (!(((Entity)var54).getPersistentData().getDouble("skill") % 100.0 > 2.0) || ((Entity)var54).getPersistentData().getBoolean("attack") || !(var54 instanceof LivingEntity)) {
                        break label612;
                     }

                     LivingEntity _livEnt49 = var54;
                     if (!_livEnt49.hasEffect((MobEffect)JujutsucraftModMobEffects.ATTACKING.get())) {
                        break label612;
                     }
                  }

                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     CommandSourceStack var10001;
                     float var10002;
                     Commands var139;
                     label598: {
                        var139 = entity.getServer().getCommands();
                        var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10002 = (float)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label598;
                           }
                        }

                        var10002 = 0.0F;
                     }

                     var139.performPrefixedCommand(var10001, "effect give @s gaigegaigekaigecraft:domain_amplification 1 " + Math.round(var10002) + " false");
                  }
               }
            }
         }

         if (logic_avoid && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:no_guard")))) {
            if (entity.onGround() && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               entity.getPersistentData().putBoolean("PRESS_S", true);
               WhenBackStepProcedure.execute(world, entity);
               entity.getPersistentData().putBoolean("PRESS_S", false);
               entity.getPersistentData().putDouble("cnt_backstep", 20.0);
               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.getNavigation().stop();
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt59 = (LivingEntity)entity;
               if (_livEnt59.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                  entity.getPersistentData().putDouble("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
               }
            }
         }

         if (test && (logic_avoid || Math.random() < 0.2) && GetDistanceProcedure.execute(entity) > 8.0 && entity instanceof LivingEntity) {
            LivingEntity _livEnt61 = (LivingEntity)entity;
            if (_livEnt61.hasEffect((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
               KeySpaceOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

         float var140;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var140 = _livEnt.getMaxHealth();
         } else {
            var140 = -1.0F;
         }

         label810: {
            limit = (double)(var140 >= 800.0F ? 150 : 50);
            if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_reverse_cursed_technique"))) && (!entity.getPersistentData().contains("entity_can_use_rct") || !entity.getPersistentData().getBoolean("entity_can_use_rct"))) {
               if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                  break label810;
               }

               GojoSatoruSchoolDaysEntity _datEntL66 = (GojoSatoruSchoolDaysEntity)entity;
               if (!(Boolean)_datEntL66.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                  break label810;
               }
            }

            output = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_reverse_cursed_technique_output")));
            if (!logic_heal_cancel) {
               if (distance < 8.0) {
                  label775: {
                     logic_heal_cancel = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var140 = _livEnt.getHealth();
                     } else {
                        var140 = -1.0F;
                     }

                     double var142 = (double)var140;
                     float var149;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var149 = _livEnt.getMaxHealth();
                     } else {
                        var149 = -1.0F;
                     }

                     if (var142 <= (double)var149 * 0.5) {
                        logic_heal_cancel = false;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt70 = (LivingEntity)entity;
                        if (_livEnt70.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label775;
                        }
                     }
                     int var143;
                     label565: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var143 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                              break label565;
                           }
                        }

                        var143 = 0;
                     }

                     if (var143 >= 1) {
                        logic_heal_cancel = false;
                     }
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var140 = _livEnt.getHealth();
               } else {
                  var140 = -1.0F;
               }

               float var150;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var150 = _livEnt.getMaxHealth();
               } else {
                  var150 = -1.0F;
               }

               if (var140 >= var150) {
                  logic_heal_cancel = true;
               }
            }

            if (entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0 >= limit) {
               logic_heal_cancel = true;
               output = false;
            }

            if (output) {
               output = false;
               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:cant_combat"))) || entity.getPersistentData().getDouble("cnt_target") <= 6.0) {
                  dis = (double)(entity.getBbWidth() * 1.0F);
                  using = false;
                  Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * dis, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * dis, entity.getZ() + entity.getLookAngle().z * dis);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(dis * 3.0 / 2.0), (e) -> true)) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:not_living"))) && entityiterator.isAlive() && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().getBoolean("CursedSpirit")) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var140 = _livEnt.getHealth();
                           } else {
                              var140 = -1.0F;
                           }

                           float var151;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var151 = _livEnt.getMaxHealth();
                           } else {
                              var151 = -1.0F;
                           }

                           if (var140 < var151) {
                              using = true;
                           }
                        }

                        if (using) {
                           output = true;
                           logic_heal_cancel = false;
                           break;
                        }
                     }
                  }
               }
            }

            if (logic_heal_cancel) {
               logic_heal = false;
            } else {
               logic_heal = true;
               if (output) {
                  entity.getPersistentData().putDouble("cnt_reverse_test", Math.max(entity.getPersistentData().getDouble("cnt_reverse_test"), 100.0));
               }
            }

            entity.getPersistentData().putDouble("cnt_reverse_test", entity.getPersistentData().getDouble("cnt_reverse_test") + 1.0);
            if (logic_heal) {
               if (entity.getPersistentData().getDouble("cnt_reverse_test") > 100.0) {
                  label804: {
                     entity.getPersistentData().putDouble("cnt_reverse_test", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt100 = (LivingEntity)entity;
                        if (_livEnt100.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                           break label804;
                        }
                     }

                     if (!entity.getPersistentData().getBoolean("PRESS_M")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 18, 9, false, false));
                           }
                        }

                        entity.getPersistentData().putDouble("cnt_reverse", 15.0);
                        KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                     }
                  }
               }
            } else if (!target) {
               entity.getPersistentData().putDouble("cnt_reverse_lim", Math.max(entity.getPersistentData().getDouble("cnt_reverse_lim") - 0.1, 0.0));
            }

            if (entity.getPersistentData().getBoolean("PRESS_M")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt107 = (LivingEntity)entity;
                  if (_livEnt107.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                     entity.getPersistentData().putDouble("cnt_reverse_lim", entity.getPersistentData().getDouble("cnt_reverse_lim") + 1.0);
                  }
               }

               entity.getPersistentData().putDouble("cnt_reverse", Math.max(entity.getPersistentData().getDouble("cnt_reverse") - 1.0, 0.0));
               if (!logic_heal) {
                  label528: {
                     if (!(entity.getPersistentData().getDouble("cnt_reverse") <= 0.0) && !(entity.getPersistentData().getDouble("cnt_reverse_lim") >= limit)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var140 = _livEnt.getHealth();
                        } else {
                           var140 = -1.0F;
                        }

                        float var152;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var152 = _livEnt.getMaxHealth();
                        } else {
                           var152 = -1.0F;
                        }

                        if (!(var140 >= var152) || output) {
                           break label528;
                        }
                     }

                     entity.getPersistentData().putDouble("cnt_reverse", 0.0);
                     KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                  }
               }
            }
         }

         if (target && entity.getPersistentData().getDouble("skill") == 0.0) {
            entity.getPersistentData().putDouble("cnt_weapon_main", entity.getPersistentData().getDouble("cnt_weapon_main") + 1.0);
            entity.getPersistentData().putDouble("cnt_weapon_off", entity.getPersistentData().getDouble("cnt_weapon_off") + 1.0);
            using = false;
            using2 = false;
            mainItem = ItemStack.EMPTY.copy();
            offItem = ItemStack.EMPTY.copy();
            if (entity.getPersistentData().getDouble("cnt_weapon_main") > 20.0) {
               entity.getPersistentData().putDouble("cnt_weapon_main", 0.0);
               entity.getPersistentData().putDouble("cnt_weapon_off", Math.min(entity.getPersistentData().getDouble("cnt_weapon_off"), 100.0));
               if (Math.abs(entity.getPersistentData().getDouble("cnt_weapon_main") - entity.getPersistentData().getDouble("cnt_weapon_off")) < 20.0) {
                  entity.getPersistentData().putDouble("cnt_weapon_main", entity.getPersistentData().getDouble("cnt_weapon_off") - 20.0);
               }

               using = true;
               ItemStack var147;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var147 = _livEnt.getMainHandItem();
               } else {
                  var147 = ItemStack.EMPTY;
               }

               mainItem = var147;
            }

            if (entity.getPersistentData().getDouble("cnt_weapon_off") > 60.0) {
               entity.getPersistentData().putDouble("cnt_weapon_off", 40.0);
               if (Math.abs(entity.getPersistentData().getDouble("cnt_weapon_main") - entity.getPersistentData().getDouble("cnt_weapon_off")) < 20.0) {
                  entity.getPersistentData().putDouble("cnt_weapon_off", entity.getPersistentData().getDouble("cnt_weapon_main") - 20.0);
               }

               using2 = true;
               ItemStack var148;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var148 = _livEnt.getOffhandItem();
               } else {
                  var148 = ItemStack.EMPTY;
               }

               offItem = var148;
            }

            if (using ^ using2) {
               fix = 0.0;
               if ((using && mainItem.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get() || using2 && offItem.getItem() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) && distance < 40.0) {
                  SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
                  fix = 200.0;
               }

               if ((using && mainItem.getItem() == JujutsucraftModItems.DAITENGU_FAN.get() || using2 && offItem.getItem() == JujutsucraftModItems.DAITENGU_FAN.get()) && distance < 24.0) {
                  DaitenguFanRightclickedProcedure.execute(world, x, y, z, entity);
                  fix = 200.0;
               }

               if ((using && mainItem.getItem() == JujutsucraftModItems.DRAGON_BONE.get() || using2 && offItem.getItem() == JujutsucraftModItems.DRAGON_BONE.get()) && distance < 32.0) {
                  DragonBoneRightclickedProcedure.execute(world, entity);
                  fix = 100.0;
               }

               if (fix > 0.0) {
                  if (using) {
                     entity.getPersistentData().putDouble("cnt_weapon_main", 20.0 - fix);
                  } else if (using2) {
                     entity.getPersistentData().putDouble("cnt_weapon_off", 60.0 - fix);
                  }
               }
            }
         }

         if (test && entity.getPersistentData().getDouble("skill") == 0.0 && entity.isInWaterOrBubble() && entity.isSprinting() && entity instanceof LivingEntity) {
            LivingEntity _livingEntity149 = (LivingEntity)entity;
            if (_livingEntity149.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
               if (var54 instanceof LivingEntity) {
                  RotateEntityProcedure.execute(((Entity)var54).getX(), ((Entity)var54).getY() + (double)((Entity)var54).getBbHeight() * 0.5, ((Entity)var54).getZ(), entity);
                  if (entity.getAirSupply() < 4) {
                     entity.setYRot(entity.getYRot());
                     entity.setXRot(-90.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }
                  } else {
                     fix = entity.getY();

                     for(int index0 = 0; index0 < (int)Math.round(Math.ceil((double)entity.getBbHeight())); ++index0) {
                        if (!(world.getBlockState(BlockPos.containing(entity.getX(), fix, entity.getZ())).getBlock() instanceof LiquidBlock)) {
                           entity.setYRot(entity.getYRot());
                           entity.setXRot((float)Math.max((double)entity.getXRot(), 22.5));
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }
                           break;
                        }

                        ++fix;
                     }
                  }
               }

               if (!InsideSolidCalculateProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), 1.0, (double)(entity.getBbWidth() + 1.0F))) {
                  fix = 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt171 = (LivingEntity)entity;
                     if (_livEnt171.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                        int var154;
                        label460: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                 var154 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                                 break label460;
                              }
                           }

                           var154 = 0;
                        }

                        fix = Math.max(fix - 0.15 * (double)(var154 + 1), 0.0);
                     }
                  }

                  double var153;
                  label451: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity173 = (LivingEntity)entity;
                        if (_livingEntity173.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
                           var153 = _livingEntity173.getAttribute((Attribute)ForgeMod.SWIM_SPEED.get()).getValue();
                           break label451;
                        }
                     }

                     var153 = 0.0;
                  }

                  fix *= Math.min(Math.max(var153, 0.0), 4.0);
                  speed = 0.75 * fix;
                  x_power = entity.getDeltaMovement().x() + entity.getLookAngle().x * speed;
                  y_power = entity.getDeltaMovement().y() + entity.getLookAngle().y * speed;
                  z_power = entity.getDeltaMovement().z() + entity.getLookAngle().z * speed;
                  x_power = x_power < 0.0 ? Math.min(entity.getDeltaMovement().x(), Math.max(x_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().x(), Math.min(x_power, speed * 1.0));
                  y_power = y_power < 0.0 ? Math.min(entity.getDeltaMovement().y(), Math.max(y_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().y(), Math.min(y_power, speed * 1.0));
                  z_power = z_power < 0.0 ? Math.min(entity.getDeltaMovement().z(), Math.max(z_power, speed * -1.0)) : Math.max(entity.getDeltaMovement().z(), Math.min(z_power, speed * 1.0));
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.getNavigation().stop();
                  }
               }
            }
         }

      }
   }
}
