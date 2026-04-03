package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Iterator;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.entity.KenjakuEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class DomainExpansionOnEffectActiveTickProcedure {
   public DomainExpansionOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean failed = false;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean noClosing = false;
         boolean update1 = false;
         boolean old_failed = false;
         boolean use_old = false;
         double range = 0.0;
         double level = 0.0;
         double tick = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double tick_1 = 0.0;
         double tick_2 = 0.0;
         double distance = 0.0;
         double old_skill = 0.0;
         double domainPower1 = 0.0;
         double domainPower2 = 0.0;
         double str_lv = 0.0;
         double x_dis = 0.0;
         double y_dis = 0.0;
         double z_dis = 0.0;
         if (entity.isAlive()) {
            double var10000;
            label591: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                     break label591;
                  }
               }

               var10000 = 0.0;
            }
            int var136;
            label586: {
               tick_1 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var136 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label586;
                  }
               }

               var136 = 0;
            }
            int var137;
            label581: {
               str_lv = (double)(var136 + 10);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var137 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                     break label581;
                  }
               }

               var137 = 0;
            }

            if (var137 > 0) {
               str_lv *= 1.15;
            }

            if (entity.getPersistentData().getDouble("select") != 27.0 && entity.getPersistentData().getDouble("skill_domain") != 27.0) {
               if (entity.getPersistentData().getDouble("select") == 29.0 || entity.getPersistentData().getDouble("skill_domain") == 29.0) {
                  str_lv *= 2.0;
               }
            } else {
               str_lv *= 1.5;
            }

            if (entity.getPersistentData().getDouble("skill_domain") == 0.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
               entity.getPersistentData().putDouble("skill_domain", entity.getPersistentData().getDouble("select"));
               entity.getPersistentData().putDouble("select", 0.0);
               update1 = true;
            }

            if (entity.getPersistentData().getDouble("skill_domain") > 0.0) {
               if (!update1) {
                  DomainActiveProcedure.execute(world, x, y, z, entity);
               }

               int var10001;
               label564: {
                  var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                        break label564;
                     }
                  }

                  var10001 = 0;
               }

               range = var10000 * (double)(var10001 > 0 ? 18 : 2);
            }

            old_skill = entity.getPersistentData().getDouble("skill");
            entity.getPersistentData().putDouble("skill", 0.0);
            if (tick_1 % 10.0 == 0.0 || update1) {
               logic_a = false;
               Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
                  x_dis = entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                  y_dis = entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                  z_dis = entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                  distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                  if (distance < range * 0.5 * range * 0.5) {
                     if (entity == entityiterator) {
                        logic_a = true;
                     } else {
                        label550: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt28 = (LivingEntity)entityiterator;
                              if (_livEnt28.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 label545: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                                          break label545;
                                       }
                                    }

                                    var10000 = 0.0;
                                 }

                                 label540: {
                                    level = var10000;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                                          break label540;
                                       }
                                    }

                                    var10000 = 0.0;
                                 }

                                 tick = var10000;
                                 tick -= (double)Math.round(Math.sqrt(str_lv + 1.0) * 10.0);
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                                 }

                                 if (level >= 0.0 && entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.level().isClientSide()) {
                                       _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)tick, (int)level, true, true));
                                    }
                                 }
                                 break label550;
                              }
                           }

                           if (tick_1 % 20.0 == 0.0) {
                              EffectCharactorProcedure.execute(world, entity, entityiterator);
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt33 = (LivingEntity)entityiterator;
                           if (_livEnt33.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().getDouble("select") == 0.0 && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 20, (int)(entity.getPersistentData().getDouble("skill_domain") + 10.0), false, false));
                           }
                        }
                     }
                  }
               }

               if (!logic_a && entity.getPersistentData().getDouble("skill_domain") > 0.0) {
                  int var141;
                  label528: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var141 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                           break label528;
                        }
                     }

                     var141 = 0;
                  }

                  if (var141 == 0 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }

            var10000 = entity.getPersistentData().getDouble("oldHealth");
            float var157;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var157 = _livEnt.getHealth();
            } else {
               var157 = -1.0F;
            }

            if (var10000 != (double)var157) {
               var10000 = entity.getPersistentData().getDouble("oldHealth");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var157 = _livEnt.getHealth();
               } else {
                  var157 = -1.0F;
               }

               if (var10000 > (double)var157) {
                  CompoundTag var144 = entity.getPersistentData();
                  double var10002 = entity.getPersistentData().getDouble("totalDamage") + entity.getPersistentData().getDouble("oldHealth");
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.getHealth();
                  } else {
                     var10003 = -1.0F;
                  }

                  var144.putDouble("totalDamage", var10002 - (double)var10003);
               } else {
                  CompoundTag var145 = entity.getPersistentData();
                  double var165 = entity.getPersistentData().getDouble("totalDamage");
                  double var169 = entity.getPersistentData().getDouble("oldHealth");
                  float var10004;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10004 = _livEnt.getHealth();
                  } else {
                     var10004 = -1.0F;
                  }

                  var145.putDouble("totalDamage", var165 + (var169 - (double)var10004) * 0.5);
               }
            }

            CompoundTag var146 = entity.getPersistentData();
            double var166;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var166 = (double)_livEnt.getHealth();
            } else {
               var166 = -1.0;
            }

            var146.putDouble("oldHealth", var166);
            if ((tick_1 % 20.0 == 0.0 || update1) && entity.getPersistentData().getDouble("select") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var157 = _livEnt.getMaxHealth();
               } else {
                  var157 = -1.0F;
               }

               double var160 = Math.max((double)Math.max(var157, 1.0F) - Math.max(entity.getPersistentData().getDouble("totalDamage"), 0.0) * 2.0, 0.0);
               float var167;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var167 = _livEnt.getMaxHealth();
               } else {
                  var167 = -1.0F;
               }

               domainPower1 = str_lv * (var160 / (double)Math.max(var167, 1.0F)) * Math.min(Math.min(tick_1, 1200.0) / 2400.0 + 0.5, 1.0);
               failed = false;
               logic_a = false;
               logic_b = false;

               for(int index0 = 0; index0 < 2; ++index0) {
                  Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));
                  List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true);
                  Iterator var118 = _entfound.iterator();

                  label502:
                  while(true) {
                     Entity entityiterator;
                     while(true) {
                        if (!var118.hasNext()) {
                           break label502;
                        }
                        int var147;
                        label384: {
                           entityiterator = (Entity)var118.next();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var147 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                 break label384;
                              }
                           }

                           var147 = 0;
                        }
                        int var148;
                        boolean var149;
                        label394: {
                           if (var147 > 0) {
                              label391: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var148 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                       break label391;
                                    }
                                 }

                                 var148 = 0;
                              }

                              if (var148 == 0) {
                                 var149 = true;
                                 break label394;
                              }
                           }

                           var149 = false;
                        }

                        noClosing = var149;
                        if (entity != entityiterator) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt65 = (LivingEntity)entityiterator;
                              if (_livEnt65.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break;
                              }
                           }

                           if (entityiterator.getPersistentData().getDouble("select") != 0.0) {
                              break;
                           }
                        }
                     }

                     x_dis = entity.getPersistentData().getDouble("x_pos_doma") - entityiterator.getX();
                     y_dis = entity.getPersistentData().getDouble("y_pos_doma") - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     z_dis = entity.getPersistentData().getDouble("z_pos_doma") - entityiterator.getZ();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (distance < range * 0.5 * range * 0.5) {
                        int var150;
                        label414: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var150 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label414;
                              }
                           }

                           var150 = 0;
                        }
                        int var151;
                        label419: {
                           domainPower2 = (double)(var150 + 10);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var151 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                 break label419;
                              }
                           }

                           var151 = 0;
                        }

                        if (var151 > 0) {
                           domainPower2 *= 1.15;
                        }

                        if (entityiterator.getPersistentData().getDouble("select") != 27.0 && entityiterator.getPersistentData().getDouble("skill_domain") != 27.0) {
                           if (entityiterator.getPersistentData().getDouble("select") == 29.0 || entityiterator.getPersistentData().getDouble("skill_domain") == 29.0) {
                              domainPower2 *= 2.0;
                           }
                        } else {
                           domainPower2 *= 1.5;
                        }

                        if (entityiterator.getPersistentData().getDouble("select") != 0.0) {
                           tick_2 = 1200.0;
                        } else {
                           double var152;
                           label436: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var152 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                                    break label436;
                                 }
                              }

                              var152 = 0.0;
                           }

                           tick_2 = var152;
                           float var161;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var161 = _livEnt.getMaxHealth();
                           } else {
                              var161 = -1.0F;
                           }

                           double var162 = Math.max((double)Math.max(var161, 1.0F) - Math.max(entityiterator.getPersistentData().getDouble("totalDamage"), 0.0) * 2.0, 0.0);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var167 = _livEnt.getMaxHealth();
                           } else {
                              var167 = -1.0F;
                           }

                           domainPower2 = domainPower2 * (var162 / (double)Math.max(var167, 1.0F)) * Math.min(Math.min(tick_2, 1200.0) / 2400.0 + 0.5, 1.0);
                        }

                        label490: {
                           if (!(domainPower1 - domainPower2 >= 10.0)) {
                              if (!logic_a) {
                                 break label490;
                              }
                              int var153;
                              label486: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var153 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                       break label486;
                                    }
                                 }

                                 var153 = 0;
                              }

                              if (var153 > 0) {
                                 break label490;
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt86 = (LivingEntity)entityiterator;
                              if (_livEnt86.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label499: {
                                    failed = false;
                                    logic_b = true;
                                    entityiterator.getPersistentData().putBoolean("Failed", false);
                                    entityiterator.getPersistentData().putBoolean("DomainDefeated", !noClosing);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt89 = (LivingEntity)entityiterator;
                                       if (_livEnt89.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label499;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.level().isClientSide()) {
                                          _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 5, 0, false, false));
                                       }
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                 }
                                 continue;
                              }
                           }
                        }

                        if (noClosing) {
                           label477: {
                              if (tick_1 <= tick_2) {
                                 if (!(tick_2 < 1000.0)) {
                                    break label477;
                                 }
                              } else if (!(tick_1 < 1000.0)) {
                                 break label477;
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt92 = (LivingEntity)entityiterator;
                                 if (_livEnt92.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    label469: {
                                       label611: {
                                          logic_a = true;
                                          if (entityiterator instanceof Player) {
                                             if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr94 = (ServerPlayer)entityiterator;
                                                if (_plr94.level() instanceof ServerLevel && _plr94.getAdvancements().getOrStartProgress(_plr94.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:anti_open_barrier_type_domain"))).isDone()) {
                                                   break label611;
                                                }
                                             }
                                          } else if (entityiterator.getPersistentData().getDouble("cnt_learn_domain") > 0.0) {
                                             break label611;
                                          }

                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livEnt96 = (LivingEntity)entityiterator;
                                             if (_livEnt96.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                break label611;
                                             }
                                          }

                                          if (!(entityiterator instanceof GojoSatoruEntity) && !(entityiterator instanceof HigurumaHiromiEntity) && !(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity) && !(entityiterator instanceof KenjakuEntity)) {
                                             if (!(entityiterator instanceof Player) || !(entityiterator instanceof ServerPlayer)) {
                                                break label469;
                                             }

                                             ServerPlayer _player = (ServerPlayer)entityiterator;
                                             Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:anti_open_barrier_type_domain"));
                                             AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                                             if (_ap.isDone()) {
                                                break label469;
                                             }

                                             Iterator var61 = _ap.getRemainingCriteria().iterator();

                                             while(true) {
                                                if (!var61.hasNext()) {
                                                   break label469;
                                                }

                                                String criteria = (String)var61.next();
                                                _player.getAdvancements().award(_adv, criteria);
                                             }
                                          }

                                          entityiterator.getPersistentData().putDouble("cnt_learn_domain", 1.0);
                                          break label469;
                                       }

                                       logic_a = false;
                                    }

                                    if (logic_a) {
                                       break;
                                    }
                                 }
                              }
                           }
                        }

                        if (!logic_b) {
                           if (distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius) {
                              entity.getPersistentData().putBoolean("Failed", true);
                           } else {
                              use_old = true;
                              old_failed = entity.getPersistentData().getBoolean("Failed");
                              entity.getPersistentData().putBoolean("Failed", true);
                           }

                           failed = true;
                        }
                     }
                  }

                  if (!logic_a) {
                     break;
                  }
               }
            } else {
               failed = true;
            }

            entity.getPersistentData().putDouble("skill", old_skill);
            if (!entity.getPersistentData().getBoolean("Failed") && !entity.getPersistentData().getBoolean("Cover")) {
               int var155;
               label344: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var155 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getDuration();
                        break label344;
                     }
                  }

                  var155 = 0;
               }

               if (var155 < 10 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 10, 0, false, false));
                  }
               }
            } else {
               if (!failed && !entity.getPersistentData().getBoolean("Cover")) {
                  label628: {
                     x_dis = entity.getPersistentData().getDouble("x_pos_doma") - entity.getX();
                     y_dis = entity.getPersistentData().getDouble("y_pos_doma") - (entity.getY() + (double)entity.getBbHeight() * 0.5);
                     z_dis = entity.getPersistentData().getDouble("z_pos_doma") - entity.getZ();
                     distance = x_dis * x_dis + y_dis * y_dis + z_dis * z_dis;
                     if (!(distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius)) {
                        int var154;
                        label364: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var154 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                 break label364;
                              }
                           }

                           var154 = 0;
                        }

                        if (var154 == 0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                           }
                           break label628;
                        }
                     }

                     entity.getPersistentData().putDouble("cnt_cover", 1.0);
                     old_failed = false;
                     entity.getPersistentData().putBoolean("Failed", false);
                     entity.getPersistentData().putBoolean("Cover", true);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           MobEffect var170;
                           int var171;
                           int var10005;
                           MobEffectInstance var163;
                           label355: {
                              var170 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                              var171 = (int)(tick_1 + 100.0);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var10005 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getAmplifier();
                                    break label355;
                                 }
                              }

                              var10005 = 0;
                           }

                           var163 = new MobEffectInstance(var170, var171, var10005, true, false);
                           _entity.addEffect(var163);
                        }
                     }

                     entity.getPersistentData().putDouble("x_pos_doma2", (double)Math.round(entity.getX()));
                     entity.getPersistentData().putDouble("y_pos_doma2", (double)Math.round(entity.getY()));
                     entity.getPersistentData().putDouble("z_pos_doma2", (double)Math.round(entity.getZ()));
                  }
               }

               if (entity.getPersistentData().getBoolean("Cover")) {
                  x_pos = entity.getPersistentData().getDouble("x_pos_doma");
                  y_pos = entity.getPersistentData().getDouble("y_pos_doma");
                  z_pos = entity.getPersistentData().getDouble("z_pos_doma");
               } else {
                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();
               }

               old_skill = entity.getPersistentData().getDouble("cnt1");
               entity.getPersistentData().putDouble("cnt1", 0.0);
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("cnt1", old_skill);
               if (use_old) {
                  entity.getPersistentData().putBoolean("Failed", old_failed);
               }

               if (entity.getPersistentData().getBoolean("Cover")) {
                  entity.getPersistentData().putDouble("cnt_cover", entity.getPersistentData().getDouble("cnt_cover") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_cover") > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 + 1.0) {
                     entity.getPersistentData().putBoolean("Cover", false);
                  }
               }
            }

            if (!entity.getPersistentData().getBoolean("Cover")) {
               if (entity instanceof Player) {
                  if (tick_1 % 20.0 == 0.0) {
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange -= 20.0;
                        if (capability.PlayerCursePower + capability.PlayerCursePowerChange <= 0.0 && entity instanceof LivingEntity _entity) {
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                        }

                     });
                  }
               } else if (entity.getPersistentData().getDouble("cnt_target") > 5.0) {
                  entity.getPersistentData().putDouble("cnt_domain_cancel", 0.0);
               } else {
                  double var156;
                  int var164;
                  label335: {
                     entity.getPersistentData().putDouble("cnt_domain_cancel", entity.getPersistentData().getDouble("cnt_domain_cancel") + 1.0);
                     var156 = entity.getPersistentData().getDouble("cnt_domain_cancel");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt158 = (LivingEntity)entity;
                        if (_livEnt158.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var164 = 600;
                           break label335;
                        }
                     }

                     var164 = 100;
                  }

                  if (var156 > (double)var164 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
         }

      }
   }
}
