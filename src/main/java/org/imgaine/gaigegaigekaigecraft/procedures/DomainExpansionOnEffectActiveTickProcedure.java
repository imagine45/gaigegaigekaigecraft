package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
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
         if (entity.m_6084_()) {
            double var10000;
            label594: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                     break label594;
                  }
               }

               var10000 = 0.0;
            }

            label589: {
               tick_1 = var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                     var138 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                     break label589;
                  }
               }

               var138 = 0;
            }

            label584: {
               str_lv = (double)(var138 + 10);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     var139 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                     break label584;
                  }
               }

               var139 = 0;
            }

            if (var139 > 0) {
               str_lv *= 1.15;
            }

            if (entity.getPersistentData().m_128459_("select") != 27.0 && entity.getPersistentData().m_128459_("skill_domain") != 27.0) {
               if (entity.getPersistentData().m_128459_("select") == 29.0 || entity.getPersistentData().m_128459_("skill_domain") == 29.0) {
                  str_lv *= 2.0;
               }
            } else {
               str_lv *= 1.5;
            }

            if (entity.getPersistentData().m_128459_("skill_domain") == 0.0 && entity.getPersistentData().m_128459_("skill") == 0.0) {
               entity.getPersistentData().m_128347_("skill_domain", entity.getPersistentData().m_128459_("select"));
               entity.getPersistentData().m_128347_("select", 0.0);
               update1 = true;
            }

            if (entity.getPersistentData().m_128459_("skill_domain") > 0.0) {
               if (!update1) {
                  DomainActiveProcedure.execute(world, x, y, z, entity);
               }

               int var10001;
               label567: {
                  var10000 = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                        var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                        break label567;
                     }
                  }

                  var10001 = 0;
               }

               range = var10000 * (double)(var10001 > 0 ? 18 : 2);
            }

            old_skill = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", 0.0);
            if (tick_1 % 10.0 == 0.0 || update1) {
               logic_a = false;
               Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));

               for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                  x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                  y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5);
                  z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                  distance = Math.sqrt(x_dis * x_dis + y_dis * y_dis + z_dis * z_dis);
                  if (distance < range * 0.5) {
                     if (entity == entityiterator) {
                        logic_a = true;
                     } else {
                        label553: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt28 = (LivingEntity)entityiterator;
                              if (_livEnt28.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 label548: {
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19564_();
                                          break label548;
                                       }
                                    }

                                    var10000 = 0.0;
                                 }

                                 label543: {
                                    level = var10000;
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entityiterator;
                                       if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                          var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).m_19557_();
                                          break label543;
                                       }
                                    }

                                    var10000 = 0.0;
                                 }

                                 tick = var10000;
                                 tick -= (double)Math.round(Math.sqrt(str_lv + 1.0) * 10.0);
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
                                 }

                                 if (level >= 0.0 && entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    if (!_entity.m_9236_().m_5776_()) {
                                       _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)tick, (int)level, true, true));
                                    }
                                 }
                                 break label553;
                              }
                           }

                           if (tick_1 % 20.0 == 0.0) {
                              EffectCharactorProcedure.execute(world, entity, entityiterator);
                           }
                        }

                        if (entityiterator instanceof LivingEntity) {
                           LivingEntity _livEnt33 = (LivingEntity)entityiterator;
                           if (_livEnt33.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                              continue;
                           }
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") == 0.0 && entityiterator instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityiterator;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get(), 20, (int)(entity.getPersistentData().m_128459_("skill_domain") + 10.0), false, false));
                           }
                        }
                     }
                  }
               }

               if (!logic_a && entity.getPersistentData().m_128459_("skill_domain") > 0.0) {
                  label531: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                           var143 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                           break label531;
                        }
                     }

                     var143 = 0;
                  }

                  if (var143 == 0 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }

            var10000 = entity.getPersistentData().m_128459_("oldHealth");
            float var159;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var159 = _livEnt.m_21223_();
            } else {
               var159 = -1.0F;
            }

            if (var10000 != (double)var159) {
               var10000 = entity.getPersistentData().m_128459_("oldHealth");
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var159 = _livEnt.m_21223_();
               } else {
                  var159 = -1.0F;
               }

               if (var10000 > (double)var159) {
                  CompoundTag var146 = entity.getPersistentData();
                  double var10002 = entity.getPersistentData().m_128459_("totalDamage") + entity.getPersistentData().m_128459_("oldHealth");
                  float var10003;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10003 = _livEnt.m_21223_();
                  } else {
                     var10003 = -1.0F;
                  }

                  var146.m_128347_("totalDamage", var10002 - (double)var10003);
               } else {
                  CompoundTag var147 = entity.getPersistentData();
                  double var167 = entity.getPersistentData().m_128459_("totalDamage");
                  double var171 = entity.getPersistentData().m_128459_("oldHealth");
                  float var10004;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var10004 = _livEnt.m_21223_();
                  } else {
                     var10004 = -1.0F;
                  }

                  var147.m_128347_("totalDamage", var167 + (var171 - (double)var10004) * 0.5);
               }
            }

            CompoundTag var148 = entity.getPersistentData();
            double var168;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               var168 = (double)_livEnt.m_21223_();
            } else {
               var168 = -1.0;
            }

            var148.m_128347_("oldHealth", var168);
            if ((tick_1 % 20.0 == 0.0 || update1) && entity.getPersistentData().m_128459_("select") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var159 = _livEnt.m_21233_();
               } else {
                  var159 = -1.0F;
               }

               double var162 = Math.max((double)Math.max(var159, 1.0F) - Math.max(entity.getPersistentData().m_128459_("totalDamage"), 0.0) * 2.0, 0.0);
               float var169;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var169 = _livEnt.m_21233_();
               } else {
                  var169 = -1.0F;
               }

               domainPower1 = str_lv * (var162 / (double)Math.max(var169, 1.0F)) * Math.min(Math.min(tick_1, 1200.0) / 2400.0 + 0.5, 1.0);
               failed = false;
               logic_a = false;
               logic_b = false;

               for(int index0 = 0; index0 < 2; ++index0) {
                  Vec3 _center = new Vec3(entity.getPersistentData().m_128459_("x_pos_doma"), entity.getPersistentData().m_128459_("y_pos_doma"), entity.getPersistentData().m_128459_("z_pos_doma"));
                  List<Entity> _entfound = world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(range / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList();
                  Iterator var120 = _entfound.iterator();

                  label505:
                  while(true) {
                     Entity entityiterator;
                     while(true) {
                        if (!var120.hasNext()) {
                           break label505;
                        }

                        label387: {
                           entityiterator = (Entity)var120.next();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var149 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label387;
                              }
                           }

                           var149 = 0;
                        }

                        label397: {
                           if (var149 > 0) {
                              label394: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var150 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                       break label394;
                                    }
                                 }

                                 var150 = 0;
                              }

                              if (var150 == 0) {
                                 var151 = true;
                                 break label397;
                              }
                           }

                           var151 = false;
                        }

                        noClosing = var151;
                        if (entity != entityiterator) {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt65 = (LivingEntity)entityiterator;
                              if (_livEnt65.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 break;
                              }
                           }

                           if (entityiterator.getPersistentData().m_128459_("select") != 0.0) {
                              break;
                           }
                        }
                     }

                     x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entityiterator.m_20185_();
                     y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entityiterator.m_20186_() + (double)entityiterator.m_20206_() * 0.5);
                     z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entityiterator.m_20189_();
                     distance = Math.sqrt(x_dis * x_dis + y_dis * y_dis + z_dis * z_dis);
                     if (distance < range * 0.5) {
                        label417: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_(MobEffects.f_19600_)) {
                                 var152 = _livEnt.m_21124_(MobEffects.f_19600_).m_19564_();
                                 break label417;
                              }
                           }

                           var152 = 0;
                        }

                        label422: {
                           domainPower2 = (double)(var152 + 10);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var153 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label422;
                              }
                           }

                           var153 = 0;
                        }

                        if (var153 > 0) {
                           domainPower2 *= 1.15;
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") != 27.0 && entityiterator.getPersistentData().m_128459_("skill_domain") != 27.0) {
                           if (entityiterator.getPersistentData().m_128459_("select") == 29.0 || entityiterator.getPersistentData().m_128459_("skill_domain") == 29.0) {
                              domainPower2 *= 2.0;
                           }
                        } else {
                           domainPower2 *= 1.5;
                        }

                        if (entityiterator.getPersistentData().m_128459_("select") != 0.0) {
                           tick_2 = 1200.0;
                        } else {
                           label439: {
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var154 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19557_();
                                    break label439;
                                 }
                              }

                              var154 = 0.0;
                           }

                           tick_2 = var154;
                           float var163;
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var163 = _livEnt.m_21233_();
                           } else {
                              var163 = -1.0F;
                           }

                           double var164 = Math.max((double)Math.max(var163, 1.0F) - Math.max(entityiterator.getPersistentData().m_128459_("totalDamage"), 0.0) * 2.0, 0.0);
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entityiterator;
                              var169 = _livEnt.m_21233_();
                           } else {
                              var169 = -1.0F;
                           }

                           domainPower2 = domainPower2 * (var164 / (double)Math.max(var169, 1.0F)) * Math.min(Math.min(tick_2, 1200.0) / 2400.0 + 0.5, 1.0);
                        }

                        label493: {
                           if (!(domainPower1 - domainPower2 >= 10.0)) {
                              if (!logic_a) {
                                 break label493;
                              }

                              label489: {
                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entityiterator;
                                    if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                       var155 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                       break label489;
                                    }
                                 }

                                 var155 = 0;
                              }

                              if (var155 > 0) {
                                 break label493;
                              }
                           }

                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livEnt86 = (LivingEntity)entityiterator;
                              if (_livEnt86.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 label502: {
                                    failed = false;
                                    logic_b = true;
                                    entityiterator.getPersistentData().m_128379_("Failed", false);
                                    entityiterator.getPersistentData().m_128379_("DomainDefeated", !noClosing);
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _livEnt89 = (LivingEntity)entityiterator;
                                       if (_livEnt89.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                          break label502;
                                       }
                                    }

                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       if (!_entity.m_9236_().m_5776_()) {
                                          _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get(), 5, 0, false, false));
                                       }
                                    }
                                 }

                                 if (entityiterator instanceof LivingEntity) {
                                    LivingEntity _entity = (LivingEntity)entityiterator;
                                    _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                                 }
                                 continue;
                              }
                           }
                        }

                        if (noClosing) {
                           label480: {
                              if (tick_1 <= tick_2) {
                                 if (!(tick_2 < 1000.0)) {
                                    break label480;
                                 }
                              } else if (!(tick_1 < 1000.0)) {
                                 break label480;
                              }

                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt92 = (LivingEntity)entityiterator;
                                 if (_livEnt92.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    label472: {
                                       label614: {
                                          logic_a = true;
                                          if (entityiterator instanceof Player) {
                                             if (entityiterator instanceof ServerPlayer) {
                                                ServerPlayer _plr94 = (ServerPlayer)entityiterator;
                                                if (_plr94.m_9236_() instanceof ServerLevel && _plr94.m_8960_().m_135996_(_plr94.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"))).m_8193_()) {
                                                   break label614;
                                                }
                                             }
                                          } else if (entityiterator.getPersistentData().m_128459_("cnt_learn_domain") > 0.0) {
                                             break label614;
                                          }

                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livEnt96 = (LivingEntity)entityiterator;
                                             if (_livEnt96.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                                break label614;
                                             }
                                          }

                                          if (!(entityiterator instanceof GojoSatoruEntity) && !(entityiterator instanceof HigurumaHiromiEntity) && !(entityiterator instanceof OkkotsuYutaEntity) && !(entityiterator instanceof OkkotsuYutaCullingGameEntity) && !(entityiterator instanceof KenjakuEntity)) {
                                             if (!(entityiterator instanceof Player) || !(entityiterator instanceof ServerPlayer)) {
                                                break label472;
                                             }

                                             ServerPlayer _player = (ServerPlayer)entityiterator;
                                             Advancement _adv = _player.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:anti_open_barrier_type_domain"));
                                             AdvancementProgress _ap = _player.m_8960_().m_135996_(_adv);
                                             if (_ap.m_8193_()) {
                                                break label472;
                                             }

                                             Iterator var61 = _ap.m_8219_().iterator();

                                             while(true) {
                                                if (!var61.hasNext()) {
                                                   break label472;
                                                }

                                                String criteria = (String)var61.next();
                                                _player.m_8960_().m_135988_(_adv, criteria);
                                             }
                                          }

                                          entityiterator.getPersistentData().m_128347_("cnt_learn_domain", 1.0);
                                          break label472;
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
                              entity.getPersistentData().m_128379_("Failed", true);
                           } else {
                              use_old = true;
                              old_failed = entity.getPersistentData().m_128471_("Failed");
                              entity.getPersistentData().m_128379_("Failed", true);
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

            entity.getPersistentData().m_128347_("skill", old_skill);
            if (!entity.getPersistentData().m_128471_("Failed") && !entity.getPersistentData().m_128471_("Cover")) {
               label347: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        var157 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19557_();
                        break label347;
                     }
                  }

                  var157 = 0;
               }

               if (var157 < 10 && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 10, 0, false, false));
                  }
               }
            } else {
               if (!failed && !entity.getPersistentData().m_128471_("Cover")) {
                  label631: {
                     x_dis = entity.getPersistentData().m_128459_("x_pos_doma") - entity.m_20185_();
                     y_dis = entity.getPersistentData().m_128459_("y_pos_doma") - (entity.m_20186_() + (double)entity.m_20206_() * 0.5);
                     z_dis = entity.getPersistentData().m_128459_("z_pos_doma") - entity.m_20189_();
                     distance = Math.sqrt(x_dis * x_dis + y_dis * y_dis + z_dis * z_dis);
                     if (!(distance < JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius)) {
                        label367: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                 var156 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                 break label367;
                              }
                           }

                           var156 = 0;
                        }

                        if (var156 == 0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                           }
                           break label631;
                        }
                     }

                     entity.getPersistentData().m_128347_("cnt_cover", 1.0);
                     old_failed = false;
                     entity.getPersistentData().m_128379_("Failed", false);
                     entity.getPersistentData().m_128379_("Cover", true);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           MobEffect var172;
                           int var173;
                           int var10005;
                           label358: {
                              var165 = new MobEffectInstance;
                              var172 = (MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get();
                              var173 = (int)(tick_1 + 100.0);
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                                    var10005 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).m_19564_();
                                    break label358;
                                 }
                              }

                              var10005 = 0;
                           }

                           var165.<init>(var172, var173, var10005, true, false);
                           _entity.m_7292_(var165);
                        }
                     }

                     entity.getPersistentData().m_128347_("x_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123341_()));
                     entity.getPersistentData().m_128347_("y_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123342_()));
                     entity.getPersistentData().m_128347_("z_pos_doma2", (double)Math.round((float)entity.m_9236_().m_45547_(new ClipContext(entity.m_20299_(1.0F), entity.m_20299_(1.0F).m_82549_(entity.m_20252_(1.0F).m_82490_(0.0)), Block.OUTLINE, Fluid.NONE, entity)).m_82425_().m_123343_()));
                  }
               }

               if (entity.getPersistentData().m_128471_("Cover")) {
                  x_pos = entity.getPersistentData().m_128459_("x_pos_doma");
                  y_pos = entity.getPersistentData().m_128459_("y_pos_doma");
                  z_pos = entity.getPersistentData().m_128459_("z_pos_doma");
               } else {
                  x_pos = entity.m_20185_();
                  y_pos = entity.m_20186_();
                  z_pos = entity.m_20189_();
               }

               old_skill = entity.getPersistentData().m_128459_("cnt1");
               entity.getPersistentData().m_128347_("cnt1", 0.0);
               DomainExpansionBattleProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().m_128347_("cnt1", old_skill);
               if (use_old) {
                  entity.getPersistentData().m_128379_("Failed", old_failed);
               }

               if (entity.getPersistentData().m_128471_("Cover")) {
                  entity.getPersistentData().m_128347_("cnt_cover", entity.getPersistentData().m_128459_("cnt_cover") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_cover") > JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0 + 1.0) {
                     entity.getPersistentData().m_128379_("Cover", false);
                  }
               }
            }

            if (!entity.getPersistentData().m_128471_("Cover")) {
               if (entity instanceof Player) {
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange <= 0.0 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               } else if (entity.getPersistentData().m_128459_("cnt_target") > 5.0) {
                  entity.getPersistentData().m_128347_("cnt_domain_cancel", 0.0);
               } else {
                  label338: {
                     entity.getPersistentData().m_128347_("cnt_domain_cancel", entity.getPersistentData().m_128459_("cnt_domain_cancel") + 1.0);
                     var158 = entity.getPersistentData().m_128459_("cnt_domain_cancel");
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt159 = (LivingEntity)entity;
                        if (_livEnt159.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           var166 = 600;
                           break label338;
                        }
                     }

                     var166 = 100;
                  }

                  if (var158 > (double)var166 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
                  }
               }
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get());
         }

      }
   }
}
