package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
import java.util.UUID;
import java.util.function.BiFunction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.Scoreboard;

public class SetTargetProcedure {
   public SetTargetProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         Entity entity_target = null;
         boolean logic_a = false;
         if (entity instanceof LivingEntity && entity.getPersistentData().m_128461_("TARGET_UUID").isEmpty() && entity.getPersistentData().m_128459_("cnt_target") <= 6.0) {
            logic_a = false;
            if (!logic_a) {
               entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
                  public Entity apply(LevelAccessor levelAccessor, String uuid) {
                     if (levelAccessor instanceof ServerLevel serverLevel) {
                        try {
                           return serverLevel.m_8791_(UUID.fromString(uuid));
                        } catch (Exception var5) {
                        }
                     }

                     return null;
                  }
               }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.m_5448_();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity_a.getPersistentData().m_128459_("cnt_target") > 6.0) {
                     logic_a = true;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     entity_target = var10000;
                  }
               }
            }

            if (entity.getPersistentData().m_128459_("friend_num") == 0.0) {
               entity.getPersistentData().m_128347_("friend_num", Math.random());
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity12 = (LivingEntity)entity;
               if (_livingEntity12.m_21204_().m_22171_(Attributes.f_22277_)) {
                  double var40;
                  label225: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity13 = (LivingEntity)entity;
                        if (_livingEntity13.m_21204_().m_22171_(Attributes.f_22277_)) {
                           var40 = _livingEntity13.getAttribute_(Attributes.f_22277_).m_22135_();
                           break label225;
                        }
                     }

                     var40 = 0.0;
                  }

                  if (var40 > 0.0) {
                     if (!(entity_target instanceof LivingEntity)) {
                        Vec3 _center;
                        AABB var10002;
                        double var10004;
                        label217: {
                           _center = new Vec3(x, y, z);
                           var10002 = new AABB(_center, _center);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity15 = (LivingEntity)entity;
                              if (_livingEntity15.m_21204_().m_22171_(Attributes.f_22277_)) {
                                 var10004 = _livingEntity15.getAttribute_(Attributes.f_22277_).m_22135_();
                                 break label217;
                              }
                           }

                           var10004 = 0.0;
                        }

                        for(Entity entityiterator : world.m_6443_(Entity.class, var10002.m_82400_(Math.min(16.0, var10004) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              entity_target = entityiterator;
                              break;
                           }
                        }
                     }

                     if (!(entity_target instanceof LivingEntity)) {
                        Vec3 _center;
                        AABB var56;
                        double var59;
                        label202: {
                           _center = new Vec3(x, y, z);
                           var56 = new AABB(_center, _center);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity21 = (LivingEntity)entity;
                              if (_livingEntity21.m_21204_().m_22171_(Attributes.f_22277_)) {
                                 var59 = _livingEntity21.getAttribute_(Attributes.f_22277_).m_22135_();
                                 break label202;
                              }
                           }

                           var59 = 0.0;
                        }

                        for(Entity entityiterator : world.m_6443_(Entity.class, var56.m_82400_(Math.min(80.0, var59) / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.m_6084_() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              LivingEntity var41;
                              if (entityiterator instanceof Mob) {
                                 Mob _mobEnt = (Mob)entityiterator;
                                 var41 = _mobEnt.m_5448_();
                              } else {
                                 var41 = null;
                              }

                              if (var41 instanceof LivingEntity && entityiterator.getPersistentData().m_128459_("cnt_target") > 6.0) {
                                 if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                                    if (entityiterator instanceof Mob) {
                                       Mob _mobEnt = (Mob)entityiterator;
                                       var41 = _mobEnt.m_5448_();
                                    } else {
                                       var41 = null;
                                    }

                                    if (((Entity)var41).getPersistentData().m_128459_("friend_num") == entity.getPersistentData().m_128459_("friend_num")) {
                                       entity_target = entityiterator;
                                       break;
                                    }
                                 }

                                 label184: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _teamEnt = (LivingEntity)entity;
                                       Scoreboard var43 = _teamEnt.m_9236_().m_6188_();
                                       String var10001;
                                       if (_teamEnt instanceof Player) {
                                          Player _pl = (Player)_teamEnt;
                                          var10001 = _pl.m_36316_().getName();
                                       } else {
                                          var10001 = _teamEnt.m_20149_();
                                       }

                                       if (var43.m_83500_(var10001) != null) {
                                          var43 = _teamEnt.m_9236_().m_6188_();
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var10001 = _pl.m_36316_().getName();
                                          } else {
                                             var10001 = _teamEnt.m_20149_();
                                          }

                                          var44 = var43.m_83500_(var10001).m_5758_();
                                          break label184;
                                       }
                                    }

                                    var44 = "";
                                 }

                                 if (!var44.isEmpty()) {
                                    if (entityiterator instanceof Mob) {
                                       Mob _mobEnt = (Mob)entityiterator;
                                       var41 = _mobEnt.m_5448_();
                                    } else {
                                       var41 = null;
                                    }

                                    label177: {
                                       LivingEntity var28 = var41;
                                       if (var28 instanceof LivingEntity) {
                                          LivingEntity _teamEnt = var28;
                                          Scoreboard var47 = _teamEnt.m_9236_().m_6188_();
                                          String var51;
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var51 = _pl.m_36316_().getName();
                                          } else {
                                             var51 = _teamEnt.m_20149_();
                                          }

                                          if (var47.m_83500_(var51) != null) {
                                             var47 = _teamEnt.m_9236_().m_6188_();
                                             if (_teamEnt instanceof Player) {
                                                Player _pl = (Player)_teamEnt;
                                                var51 = _pl.m_36316_().getName();
                                             } else {
                                                var51 = _teamEnt.m_20149_();
                                             }

                                             var48 = var47.m_83500_(var51).m_5758_();
                                             break label177;
                                          }
                                       }

                                       var48 = "";
                                    }

                                    String var54;
                                    label171: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _teamEnt = (LivingEntity)entity;
                                          Scoreboard var53 = _teamEnt.m_9236_().m_6188_();
                                          String var57;
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var57 = _pl.m_36316_().getName();
                                          } else {
                                             var57 = _teamEnt.m_20149_();
                                          }

                                          if (var53.m_83500_(var57) != null) {
                                             var53 = _teamEnt.m_9236_().m_6188_();
                                             if (_teamEnt instanceof Player) {
                                                Player _pl = (Player)_teamEnt;
                                                var57 = _pl.m_36316_().getName();
                                             } else {
                                                var57 = _teamEnt.m_20149_();
                                             }

                                             var54 = var53.m_83500_(var57).m_5758_();
                                             break label171;
                                          }
                                       }

                                       var54 = "";
                                    }

                                    if (var48.equals(var54)) {
                                       entity_target = entityiterator;
                                       break;
                                    }
                                 }
                              }

                              if (entityiterator instanceof Player && (!(entity_a instanceof Player) || logic_a)) {
                                 entity_target = entityiterator;
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            if (entity_target instanceof LivingEntity) {
               entity.getPersistentData().m_128359_("TARGET_UUID", entity_target.m_20149_());
            } else {
               entity.getPersistentData().m_128359_("TARGET_UUID", "");
            }
         }

      }
   }
}
