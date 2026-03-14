package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.Scoreboard;

public class LogicAttackTargetProcedure {
   public LogicAttackTargetProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         boolean target_reset = false;
         logic_a = true;
         if (entity.getPersistentData().m_128459_("skill") <= -999.0) {
            logic_a = false;
         }

         if (entity.getPersistentData().m_128459_("cnt_target") <= 6.0) {
            logic_a = false;
         } else {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
                  double var19 = entity.getPersistentData().m_128459_("friend_num");
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.m_5448_();
                  } else {
                     var10001 = null;
                  }

                  if (var19 == ((Entity)var10001).getPersistentData().m_128459_("friend_num")) {
                     target_reset = true;
                  }
               }

               label102: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _teamEnt = (LivingEntity)entity;
                     Scoreboard var20 = _teamEnt.m_9236_().m_6188_();
                     String var26;
                     if (_teamEnt instanceof Player) {
                        Player _pl = (Player)_teamEnt;
                        var26 = _pl.m_36316_().getName();
                     } else {
                        var26 = _teamEnt.m_20149_();
                     }

                     if (var20.m_83500_(var26) != null) {
                        var20 = _teamEnt.m_9236_().m_6188_();
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var26 = _pl.m_36316_().getName();
                        } else {
                           var26 = _teamEnt.m_20149_();
                        }

                        var21 = var20.m_83500_(var26).m_5758_();
                        break label102;
                     }
                  }

                  var21 = "";
               }

               if (!var21.isEmpty()) {
                  label94: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _teamEnt = (LivingEntity)entity;
                        Scoreboard var23 = _teamEnt.m_9236_().m_6188_();
                        String var28;
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var28 = _pl.m_36316_().getName();
                        } else {
                           var28 = _teamEnt.m_20149_();
                        }

                        if (var23.m_83500_(var28) != null) {
                           var23 = _teamEnt.m_9236_().m_6188_();
                           if (_teamEnt instanceof Player) {
                              Player _pl = (Player)_teamEnt;
                              var28 = _pl.m_36316_().getName();
                           } else {
                              var28 = _teamEnt.m_20149_();
                           }

                           var24 = var23.m_83500_(var28).m_5758_();
                           break label94;
                        }
                     }

                     var24 = "";
                  }

                  LivingEntity var30;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var30 = _mobEnt.m_5448_();
                  } else {
                     var30 = null;
                  }

                  label87: {
                     LivingEntity var14 = var30;
                     if (var14 instanceof LivingEntity) {
                        LivingEntity _teamEnt = var14;
                        Scoreboard var31 = _teamEnt.m_9236_().m_6188_();
                        String var10002;
                        if (_teamEnt instanceof Player) {
                           Player _pl = (Player)_teamEnt;
                           var10002 = _pl.m_36316_().getName();
                        } else {
                           var10002 = _teamEnt.m_20149_();
                        }

                        if (var31.m_83500_(var10002) != null) {
                           var31 = _teamEnt.m_9236_().m_6188_();
                           if (_teamEnt instanceof Player) {
                              Player _pl = (Player)_teamEnt;
                              var10002 = _pl.m_36316_().getName();
                           } else {
                              var10002 = _teamEnt.m_20149_();
                           }

                           var32 = var31.m_83500_(var10002).m_5758_();
                           break label87;
                        }
                     }

                     var32 = "";
                  }

                  if (var24.equals(var32)) {
                     target_reset = true;
                  }
               }

               if (target_reset) {
                  logic_a = false;
                  entity.getPersistentData().m_128359_("TARGET_UUID", "");
                  entity.getPersistentData().m_128347_("cnt_target", 0.0);
                  if (entity instanceof Mob) {
                     Mob _entity = (Mob)entity;
                     _entity.m_6710_((LivingEntity)null);
                     if (entity instanceof PathfinderMob) {
                        PathfinderMob _pathfinderMob = (PathfinderMob)entity;
                        _pathfinderMob.f_21346_.m_25352_(1, new HurtByTargetGoal(_pathfinderMob, new Class[0]));
                     }
                  }
               }
            }
         }

         return logic_a;
      }
   }
}
