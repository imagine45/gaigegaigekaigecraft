package org.imgaine.gaigegaigekaigecraft.procedures;

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
         if (entity instanceof LivingEntity && entity.getPersistentData().getString("TARGET_UUID").isEmpty() && entity.getPersistentData().getDouble("cnt_target") <= 6.0) {
            logic_a = false;
            if (!logic_a) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity var10000;
                  if (entity_a instanceof Mob) {
                     Mob _mobEnt = (Mob)entity_a;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity && entity_a.getPersistentData().getDouble("cnt_target") > 6.0) {
                     logic_a = true;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     entity_target = var10000;
                  }
               }
            }

            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity12 = (LivingEntity)entity;
               if (_livingEntity12.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                  double var40;
                  label225: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity13 = (LivingEntity)entity;
                        if (_livingEntity13.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                           var40 = _livingEntity13.getAttribute(Attributes.FOLLOW_RANGE).getValue();
                           break label225;
                        }
                     }

                     var40 = 0.0;
                  }

                  if (var40 > 0.0) {
                     if (!(entity_target instanceof LivingEntity)) {
                        AABB var10002;
                        double var10004;
                        label217: {
                           Vec3 _center = new Vec3(x, y, z);
                           var10002 = new AABB(_center, _center);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity15 = (LivingEntity)entity;
                              if (_livingEntity15.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                                 var10004 = _livingEntity15.getAttribute(Attributes.FOLLOW_RANGE).getValue();
                                 break label217;
                              }
                           }

                           var10004 = 0.0;
                        }

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, var10002.inflate(Math.min(16.0, var10004) / 2.0), (e) -> true)) {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              entity_target = entityiterator;
                              break;
                           }
                        }
                     }

                     if (!(entity_target instanceof LivingEntity)) {
                        AABB var56;
                        double var59;
                        label202: {
                           Vec3 _center = new Vec3(x, y, z);
                           var56 = new AABB(_center, _center);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity21 = (LivingEntity)entity;
                              if (_livingEntity21.getAttributes().hasAttribute(Attributes.FOLLOW_RANGE)) {
                                 var59 = _livingEntity21.getAttribute(Attributes.FOLLOW_RANGE).getValue();
                                 break label202;
                              }
                           }

                           var59 = 0.0;
                        }

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, var56.inflate(Math.min(80.0, var59) / 2.0), (e) -> true)) {
                           if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              LivingEntity var41;
                              if (entityiterator instanceof Mob) {
                                 Mob _mobEnt = (Mob)entityiterator;
                                 var41 = _mobEnt.getTarget();
                              } else {
                                 var41 = null;
                              }

                              if (var41 instanceof LivingEntity && entityiterator.getPersistentData().getDouble("cnt_target") > 6.0) {
                                 if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                                    if (entityiterator instanceof Mob) {
                                       Mob _mobEnt = (Mob)entityiterator;
                                       var41 = _mobEnt.getTarget();
                                    } else {
                                       var41 = null;
                                    }

                                    if (((Entity)var41).getPersistentData().getDouble("friend_num") == entity.getPersistentData().getDouble("friend_num")) {
                                       entity_target = entityiterator;
                                       break;
                                    }
                                 }
                                 String var44;
                                 label184: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _teamEnt = (LivingEntity)entity;
                                       Scoreboard var43 = _teamEnt.level().getScoreboard();
                                       String var10001;
                                       if (_teamEnt instanceof Player) {
                                          Player _pl = (Player)_teamEnt;
                                          var10001 = _pl.getGameProfile().getName();
                                       } else {
                                          var10001 = _teamEnt.getStringUUID();
                                       }

                                       if (var43.getPlayersTeam(var10001) != null) {
                                          var43 = _teamEnt.level().getScoreboard();
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var10001 = _pl.getGameProfile().getName();
                                          } else {
                                             var10001 = _teamEnt.getStringUUID();
                                          }

                                          var44 = var43.getPlayersTeam(var10001).getName();
                                          break label184;
                                       }
                                    }

                                    var44 = "";
                                 }

                                 if (!var44.isEmpty()) {
                                    if (entityiterator instanceof Mob) {
                                       Mob _mobEnt = (Mob)entityiterator;
                                       var41 = _mobEnt.getTarget();
                                    } else {
                                       var41 = null;
                                    }
                                    String var48;
                                    label177: {
                                       LivingEntity var28 = var41;
                                       if (var28 instanceof LivingEntity) {
                                          LivingEntity _teamEnt = var28;
                                          Scoreboard var47 = _teamEnt.level().getScoreboard();
                                          String var51;
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var51 = _pl.getGameProfile().getName();
                                          } else {
                                             var51 = _teamEnt.getStringUUID();
                                          }

                                          if (var47.getPlayersTeam(var51) != null) {
                                             var47 = _teamEnt.level().getScoreboard();
                                             if (_teamEnt instanceof Player) {
                                                Player _pl = (Player)_teamEnt;
                                                var51 = _pl.getGameProfile().getName();
                                             } else {
                                                var51 = _teamEnt.getStringUUID();
                                             }

                                             var48 = var47.getPlayersTeam(var51).getName();
                                             break label177;
                                          }
                                       }

                                       var48 = "";
                                    }

                                    String var54;
                                    label171: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _teamEnt = (LivingEntity)entity;
                                          Scoreboard var53 = _teamEnt.level().getScoreboard();
                                          String var57;
                                          if (_teamEnt instanceof Player) {
                                             Player _pl = (Player)_teamEnt;
                                             var57 = _pl.getGameProfile().getName();
                                          } else {
                                             var57 = _teamEnt.getStringUUID();
                                          }

                                          if (var53.getPlayersTeam(var57) != null) {
                                             var53 = _teamEnt.level().getScoreboard();
                                             if (_teamEnt instanceof Player) {
                                                Player _pl = (Player)_teamEnt;
                                                var57 = _pl.getGameProfile().getName();
                                             } else {
                                                var57 = _teamEnt.getStringUUID();
                                             }

                                             var54 = var53.getPlayersTeam(var57).getName();
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
               entity.getPersistentData().putString("TARGET_UUID", entity_target.getStringUUID());
            } else {
               entity.getPersistentData().putString("TARGET_UUID", "");
            }
         }

      }
   }
}
