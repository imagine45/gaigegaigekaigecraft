package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemCooldowns;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.common.ForgeMod;

public class AIActive2Procedure {
   public AIActive2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_guard = false;
         boolean logic_heal = false;
         boolean logic_heal_cancel = false;
         boolean test = false;
         boolean target = false;
         boolean logic_avoid = false;
         boolean using = false;
         boolean output = false;
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
         logic_guard = false;
         logic_heal = false;
         logic_heal_cancel = true;
         logic_avoid = false;
         if (entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
            test = entity.getPersistentData().m_128459_("cnt_target") % 5.0 == 4.0;
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            target = var10000 instanceof LivingEntity;
         }

         distance = 99.0;
         if (entity.getPersistentData().m_128459_("skill") == 0.0) {
            if (target) {
               distance = GetDistanceProcedure.execute(entity);
               if (test) {
                  logic_heal_cancel = false;
               }

               label682: {
                  label694: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (_livEnt5.m_21023_((MobEffect)JujutsucraftModMobEffects.DAMAGE_EFFECT.get())) {
                           break label694;
                        }
                     }

                     LivingEntity var129;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var129 = _mobEnt.m_5448_();
                     } else {
                        var129 = null;
                     }

                     if (((Entity)var129).getPersistentData().m_128459_("skill") == 0.0) {
                        break label682;
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var129 = _mobEnt.m_5448_();
                     } else {
                        var129 = null;
                     }

                     if (!(((Entity)var129).getPersistentData().m_128459_("Damage") > 0.0)) {
                        break label682;
                     }
                  }

                  logic_heal_cancel = true;
                  if (test) {
                     logic_guard = true;
                  }
               }

               if (test) {
                  if (!logic_guard) {
                     label696: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt10 = (LivingEntity)entity;
                           if (_livEnt10.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              break label696;
                           }
                        }

                        int var131;
                        label662: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                                 var131 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                                 break label662;
                              }
                           }

                           var131 = 0;
                        }

                        if (var131 > 0) {
                           logic_guard = true;
                        }
                     }
                  }

                  if (!logic_guard) {
                     label655: {
                        dis = 24.0;
                        if (!(entity instanceof UroTakakoEntity)) {
                           if (!(entity instanceof LivingEntity)) {
                              break label655;
                           }

                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (!_livEnt13.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label655;
                           }
                        }

                        dis = 36.0;
                     }

                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator) {
                           double var132;
                           if (entityiterator instanceof Projectile) {
                              Projectile _projEnt = (Projectile)entityiterator;
                              var132 = _projEnt.m_20184_().m_82553_();
                           } else {
                              var132 = 0.0;
                           }

                           if (var132 > 0.0 && !entity.m_20149_().equals(entityiterator.m_20149_())) {
                              logic_avoid = true;
                              logic_guard = true;
                              break;
                           }

                           if ((entityiterator.getPersistentData().m_128459_("skill") != 0.0 || entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:ranged_ammo")))) && entityiterator.getPersistentData().m_128459_("Damage") > 0.0 && LogicAttackProcedure.execute(world, entity, entityiterator)) {
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

                     for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                        if (entity != entityiterator && entityiterator.getPersistentData().m_128459_("skill") != 0.0 && (entityiterator.getPersistentData().m_128459_("Damage") > 0.0 || entityiterator.getPersistentData().m_128471_("PRESS_Z")) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_avoid = true;
                           logic_guard = true;
                           break;
                        }
                     }
                  }

                  if (logic_avoid) {
                     label700: {
                        if (entity.getPersistentData().m_128459_("skill") != 0.0) {
                           logic_avoid = false;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt29 = (LivingEntity)entity;
                           if (_livEnt29.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                              int var133;
                              label611: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var133 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                       break label611;
                                    }
                                 }

                                 var133 = 0;
                              }

                              if (var133 < 6) {
                                 logic_avoid = false;
                              }
                              break label700;
                           }
                        }

                        logic_avoid = false;
                     }
                  }

                  if (entity.getPersistentData().m_128471_("CursedSpirit") && entity instanceof LivingEntity) {
                     LivingEntity _livEnt32 = (LivingEntity)entity;
                     if (_livEnt32.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                        logic_avoid = true;
                     }
                  }
               }

               logic_heal_cancel = logic_heal_cancel || logic_guard;
               if (!logic_avoid) {
                  if (distance < 2.0) {
                     logic_avoid = true;
                  }

                  int var134;
                  label597: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                           var134 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                           break label597;
                        }
                     }

                     var134 = 0;
                  }

                  if ((var134 > 10 || entity.getPersistentData().m_128459_("cnt_x") < 0.0) && entity instanceof LivingEntity) {
                     LivingEntity _livEnt35 = (LivingEntity)entity;
                     if (_livEnt35.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                        if (distance < 6.0) {
                           logic_avoid = true;
                        }

                        if (distance < 24.0) {
                           LivingEntity var135;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var135 = _mobEnt.m_5448_();
                           } else {
                              var135 = null;
                           }

                           if (((Entity)var135).getPersistentData().m_128459_("skill") != 0.0) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var135 = _mobEnt.m_5448_();
                              } else {
                                 var135 = null;
                              }

                              if (((Entity)var135).getPersistentData().m_128459_("skill") > -900.0) {
                                 logic_avoid = true;
                              }
                           }
                        }
                     }
                  }
               }

               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:no_guard")))) {
                  logic_guard = false;
               }

               logic_heal_cancel = logic_heal_cancel || logic_avoid;
            } else {
               logic_heal_cancel = false;
            }
         }

         if (logic_guard) {
            StartGuardProcedure.execute(world, entity);
            entity.m_20260_(true);
            if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_domain_amplification")))) {
               label702: {
                  LivingEntity var137;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var137 = _mobEnt.m_5448_();
                  } else {
                     var137 = null;
                  }

                  if (var137 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var137 = _mobEnt.m_5448_();
                     } else {
                        var137 = null;
                     }

                     if (((Entity)var137).getPersistentData().m_128471_("attack")) {
                        break label702;
                     }
                  }

                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     CommandSourceStack var10001;
                     float var10002;
                     label568: {
                        var139 = entity.m_20194_().m_129892_();
                        var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                              var10002 = (float)_livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                              break label568;
                           }
                        }

                        var10002 = 0.0F;
                     }

                     var139.m_230957_(var10001, "effect give @s jujutsucraft:domain_amplification 1 " + Math.round(var10002) + " false");
                  }
               }
            }
         } else {
            entity.m_20260_(false);
         }

         if (logic_avoid && !entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:no_guard")))) {
            if (entity.m_20096_() && entity.getPersistentData().m_128459_("cnt_target") > 6.0) {
               entity.getPersistentData().m_128379_("PRESS_S", true);
               WhenBackStepProcedure.execute(world, entity);
               entity.getPersistentData().m_128379_("PRESS_S", false);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt55 = (LivingEntity)entity;
               if (_livEnt55.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                  entity.getPersistentData().m_128347_("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
               }
            }
         }

         if (test && (logic_avoid || Math.random() < 0.2) && GetDistanceProcedure.execute(entity) > 8.0 && entity instanceof LivingEntity) {
            LivingEntity _livEnt57 = (LivingEntity)entity;
            if (_livEnt57.m_21023_((MobEffect)JujutsucraftModMobEffects.DOUBLE_JUMP_EFFECT.get())) {
               KeySpaceOnKeyPressedProcedure.execute(world, x, y, z, entity);
            }
         }

         float var140;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt = (LivingEntity)entity;
            var140 = _livEnt.m_21233_();
         } else {
            var140 = -1.0F;
         }

         label736: {
            limit = (double)(var140 >= 800.0F ? 200 : 100);
            if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique")))) {
               if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                  break label736;
               }

               GojoSatoruSchoolDaysEntity _datEntL60 = (GojoSatoruSchoolDaysEntity)entity;
               if (!(Boolean)_datEntL60.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                  break label736;
               }
            }

            output = entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique_output")));
            if (!logic_heal_cancel) {
               if (distance < 8.0) {
                  label706: {
                     logic_heal_cancel = true;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var140 = _livEnt.m_21223_();
                     } else {
                        var140 = -1.0F;
                     }

                     double var142 = (double)var140;
                     float var154;
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var154 = _livEnt.m_21233_();
                     } else {
                        var154 = -1.0F;
                     }

                     if (var142 <= (double)var154 * 0.5) {
                        logic_heal_cancel = false;
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt64 = (LivingEntity)entity;
                        if (_livEnt64.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           break label706;
                        }
                     }

                     label539: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                              break label539;
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
                  var140 = _livEnt.m_21223_();
               } else {
                  var140 = -1.0F;
               }

               float var155;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var155 = _livEnt.m_21233_();
               } else {
                  var155 = -1.0F;
               }

               if (var140 >= var155) {
                  logic_heal_cancel = true;
               }
            }

            if (entity.getPersistentData().m_128459_("cnt_reverse_lim") + 1.0 >= limit) {
               logic_heal_cancel = true;
               output = false;
            }

            if (output) {
               output = false;
               if (entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:cant_combat"))) || entity.getPersistentData().m_128459_("cnt_target") <= 6.0) {
                  dis = (double)(entity.m_20205_() * 1.0F);
                  using = false;
                  Vec3 _center = new Vec3((double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_(), (double)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(dis)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_());

                  for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(dis * 3.0 / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                     if (entityiterator instanceof LivingEntity && !entityiterator.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("forge:not_living"))) && entityiterator.m_6084_() && entity != entityiterator) {
                        using = false;
                        if (LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           if (entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                              using = true;
                           }
                        } else if (!entityiterator.getPersistentData().m_128471_("CursedSpirit")) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var140 = _livEnt.m_21223_();
                           } else {
                              var140 = -1.0F;
                           }

                           float var156;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var156 = _livEnt.m_21233_();
                           } else {
                              var156 = -1.0F;
                           }

                           if (var140 < var156) {
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
                  entity.getPersistentData().m_128347_("cnt_reverse_test", Math.max(entity.getPersistentData().m_128459_("cnt_reverse_test"), 100.0));
               }
            }

            entity.getPersistentData().m_128347_("cnt_reverse_test", entity.getPersistentData().m_128459_("cnt_reverse_test") + 1.0);
            if (logic_heal) {
               if (entity.getPersistentData().m_128459_("cnt_reverse_test") > 100.0) {
                  label730: {
                     entity.getPersistentData().m_128347_("cnt_reverse_test", 0.0);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt90 = (LivingEntity)entity;
                        if (_livEnt90.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                           break label730;
                        }
                     }

                     if (!entity.getPersistentData().m_128471_("PRESS_M")) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 18, 9, false, false));
                           }
                        }

                        entity.getPersistentData().m_128347_("cnt_reverse", 15.0);
                        KeyReverseCursedTechniqueOnKeyPressedProcedure.execute(entity);
                     }
                  }
               }
            } else if (!target) {
               entity.getPersistentData().m_128347_("cnt_reverse_lim", Math.max(entity.getPersistentData().m_128459_("cnt_reverse_lim") - 0.1, 0.0));
            }

            if (entity.getPersistentData().m_128471_("PRESS_M")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt97 = (LivingEntity)entity;
                  if (_livEnt97.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
                     entity.getPersistentData().m_128347_("cnt_reverse_lim", entity.getPersistentData().m_128459_("cnt_reverse_lim") + 1.0);
                  }
               }

               entity.getPersistentData().m_128347_("cnt_reverse", Math.max(entity.getPersistentData().m_128459_("cnt_reverse") - 1.0, 0.0));
               if (!logic_heal) {
                  label502: {
                     if (!(entity.getPersistentData().m_128459_("cnt_reverse") <= 0.0) && !(entity.getPersistentData().m_128459_("cnt_reverse_lim") >= limit)) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var140 = _livEnt.m_21223_();
                        } else {
                           var140 = -1.0F;
                        }

                        float var157;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var157 = _livEnt.m_21233_();
                        } else {
                           var157 = -1.0F;
                        }

                        if (!(var140 >= var157) || output) {
                           break label502;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_reverse", 0.0);
                     KeyReverseCursedTechniqueOnKeyReleasedProcedure.execute(entity);
                  }
               }
            }
         }

         if (target && entity.getPersistentData().m_128459_("skill") == 0.0) {
            entity.getPersistentData().m_128347_("cnt_weapon", entity.getPersistentData().m_128459_("cnt_weapon") + 1.0);
            if (entity.getPersistentData().m_128459_("cnt_weapon") > 200.0) {
               label711: {
                  entity.getPersistentData().m_128347_("cnt_weapon", 0.0);
                  ItemStack var147;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var147 = _livEnt.m_21205_();
                  } else {
                     var147 = ItemStack.f_41583_;
                  }

                  label712: {
                     if (var147.m_41720_() == JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                        if (!(entity instanceof Player)) {
                           break label712;
                        }

                        Player _plrCldCheck115 = (Player)entity;
                        ItemCooldowns var148 = _plrCldCheck115.m_36335_();
                        ItemStack var158;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var158 = _livEnt.m_21205_();
                        } else {
                           var158 = ItemStack.f_41583_;
                        }

                        if (!var148.m_41519_(var158.m_41720_())) {
                           break label712;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        var147 = _livEnt.m_21206_();
                     } else {
                        var147 = ItemStack.f_41583_;
                     }

                     if (var147.m_41720_() != JujutsucraftModItems.SUPREME_MARTIAL_SOLUTION.get()) {
                        break label711;
                     }

                     if (entity instanceof Player) {
                        Player _plrCldCheck119 = (Player)entity;
                        ItemCooldowns var150 = _plrCldCheck119.m_36335_();
                        ItemStack var159;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var159 = _livEnt.m_21206_();
                        } else {
                           var159 = ItemStack.f_41583_;
                        }

                        if (var150.m_41519_(var159.m_41720_())) {
                           break label711;
                        }
                     }
                  }

                  if (distance > 8.0) {
                     SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
                  } else {
                     entity.getPersistentData().m_128347_("cnt_weapon", 160.0);
                  }
               }
            }
         }

         if (test && Math.random() < 1.0 && entity.m_20072_() && entity.m_20142_() && entity instanceof LivingEntity) {
            LivingEntity _livingEntity123 = (LivingEntity)entity;
            if (_livingEntity123.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
               LivingEntity var151;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var151 = _mobEnt.m_5448_();
               } else {
                  var151 = null;
               }

               if (var151 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var151 = _mobEnt.m_5448_();
                  } else {
                     var151 = null;
                  }

                  double var153 = ((Entity)var151).m_20185_();
                  LivingEntity var160;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var160 = _mobEnt.m_5448_();
                  } else {
                     var160 = null;
                  }

                  double var161 = ((Entity)var160).m_20186_();
                  LivingEntity var164;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var164 = _mobEnt.m_5448_();
                  } else {
                     var164 = null;
                  }

                  var161 += (double)((Entity)var164).m_20206_() * 0.5;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var164 = _mobEnt.m_5448_();
                  } else {
                     var164 = null;
                  }

                  RotateEntityProcedure.execute(var153, var161, ((Entity)var164).m_20189_(), entity);
                  if (entity.m_20146_() < 4) {
                     entity.m_146922_(entity.m_146908_());
                     entity.m_146926_(-90.0F);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }
                  } else {
                     fix = entity.m_20186_();

                     for(int index0 = 0; index0 < (int)Math.round(Math.ceil((double)entity.m_20206_())); ++index0) {
                        if (!(world.m_8055_(BlockPos.m_274561_(entity.m_20185_(), fix, entity.m_20189_())).m_60734_() instanceof LiquidBlock)) {
                           entity.m_146922_(entity.m_146908_());
                           entity.m_146926_((float)Math.max((double)entity.m_146909_(), 22.5));
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }
                           break;
                        }

                        ++fix;
                     }
                  }
               }

               if (entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(1.0 + (double)entity.m_20205_() * 0.5)), Block.COLLIDER, Fluid.NONE, entity)).m_6662_() != Type.BLOCK) {
                  fix = 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt148 = (LivingEntity)entity;
                     if (_livEnt148.m_21023_(MobEffects.f_19597_)) {
                        int var166;
                        label449: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                                 var166 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                                 break label449;
                              }
                           }

                           var166 = 0;
                        }

                        fix = Math.max(fix - 0.15 * (double)(var166 + 1), 0.0);
                     }
                  }

                  double var163;
                  label440: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity150 = (LivingEntity)entity;
                        if (_livingEntity150.m_21204_().m_22171_((Attribute)ForgeMod.SWIM_SPEED.get())) {
                           var163 = _livingEntity150.getAttribute_((Attribute)ForgeMod.SWIM_SPEED.get()).m_22135_();
                           break label440;
                        }
                     }

                     var163 = 0.0;
                  }

                  fix *= Math.min(Math.max(var163, 0.0), 4.0);
                  speed = 0.75 * fix;
                  x_power = entity.m_20184_().m_7096_() + entity.m_20154_().f_82479_ * speed;
                  y_power = entity.m_20184_().m_7098_() + entity.m_20154_().f_82480_ * speed;
                  z_power = entity.m_20184_().m_7094_() + entity.m_20154_().f_82481_ * speed;
                  x_power = x_power < 0.0 ? Math.min(entity.m_20184_().m_7096_(), Math.max(x_power, speed * -1.0)) : Math.max(entity.m_20184_().m_7096_(), Math.min(x_power, speed * 1.0));
                  y_power = y_power < 0.0 ? Math.min(entity.m_20184_().m_7098_(), Math.max(y_power, speed * -1.0)) : Math.max(entity.m_20184_().m_7098_(), Math.min(y_power, speed * 1.0));
                  z_power = z_power < 0.0 ? Math.min(entity.m_20184_().m_7094_(), Math.max(z_power, speed * -1.0)) : Math.max(entity.m_20184_().m_7094_(), Math.min(z_power, speed * 1.0));
                  entity.m_20256_(new Vec3(x_power, y_power, z_power));
               }
            }
         }

      }
   }
}
