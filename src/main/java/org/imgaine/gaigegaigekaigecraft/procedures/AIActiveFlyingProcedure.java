package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityBroomEntity;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIActiveFlyingProcedure {
   public AIActiveFlyingProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double distance = 0.0;
         double height = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_mode_fly = 0.0;
         double speed = 0.0;
         boolean target = false;
         boolean logic_avoid = false;
         boolean strong_enemy = false;
         Entity entity_b = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.m_5448_();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity && entity.getPersistentData().m_128459_("cnt_target") > 6.0;
         entity.f_19789_ = 0.0F;
         entity_b = entity.m_20202_();
         if (!(entity_b instanceof LivingEntity)) {
            entity_b = entity;
         }

         label355: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt6 = (LivingEntity)entity;
               if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                  break label355;
               }
            }

            if (!entity.m_20096_() && !entity.m_20069_()) {
               if (entity.m_20159_() && (entity_b.m_20096_() || entity_b.m_20069_()) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.m_9236_().m_5776_()) {
                     _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 200, 0, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.m_9236_().m_5776_()) {
                  _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 60, 0, false, false));
               }
            }
         }

         if (target && entity.getPersistentData().m_128459_("skill") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt15 = (LivingEntity)entity;
               if (_livEnt15.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 20, 9, false, false));
                     }
                  }

                  if (entity_b instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_b;
                     if (!_entity.m_9236_().m_5776_()) {
                        _entity.m_7292_(new MobEffectInstance(MobEffects.f_19591_, 20, 9, false, false));
                     }
                  }

                  distance = GetDistanceProcedure.execute(entity);
                  height = GetHeightFromGroundProcedure.execute(world, entity);
                  if (Math.random() < 0.05) {
                     label366: {
                        label389: {
                           old_mode_fly = entity.getPersistentData().m_128459_("mode_fly");
                           strong_enemy = false;
                           if (!(distance > 24.0)) {
                              label397: {
                                 label359: {
                                    label311: {
                                       if (distance > 6.0 && !LogicStartProcedure.execute(entity)) {
                                          label307: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                   var73 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).m_19557_();
                                                   break label307;
                                                }
                                             }

                                             var73 = 0;
                                          }

                                          if (var73 > 20 && !strong_enemy) {
                                             break label311;
                                          }
                                       }

                                       if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                                          break label359;
                                       }
                                    }

                                    label299: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             var74 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).m_19557_();
                                             break label299;
                                          }
                                       }

                                       var74 = 0;
                                    }

                                    if (var74 < 10) {
                                       break label397;
                                    }
                                 }

                                 if (LogicStartProcedure.execute(entity) || entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                                    label396: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt24 = (LivingEntity)entity;
                                          if (_livEnt24.m_21023_((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             break label396;
                                          }
                                       }

                                       if (!strong_enemy && !(Math.random() < 0.25)) {
                                          entity.getPersistentData().m_128347_("mode_fly", old_mode_fly);
                                          break label389;
                                       }
                                    }
                                 }

                                 if (distance > 4.0) {
                                    label368: {
                                       if (!(distance > 16.0)) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var10000 = _mobEnt.m_5448_();
                                          } else {
                                             var10000 = null;
                                          }

                                          if (((Entity)var10000).getPersistentData().m_128459_("skill") == 0.0 && !(Math.random() < 0.5)) {
                                             break label368;
                                          }
                                       }

                                       if (old_mode_fly != -2.0 && old_mode_fly != -3.0) {
                                          entity.getPersistentData().m_128347_("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                                          break label389;
                                       }

                                       entity.getPersistentData().m_128347_("mode_fly", old_mode_fly);
                                       break label389;
                                    }
                                 }

                                 entity.getPersistentData().m_128347_("mode_fly", -1.0);
                                 break label389;
                              }
                           }

                           entity.getPersistentData().m_128347_("mode_fly", 1.0);
                        }

                        label262: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt31 = (LivingEntity)entity;
                              if (_livEnt31.m_21023_(MobEffects.f_19597_)) {
                                 break label262;
                              }
                           }

                           if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:combat_type")))) {
                              break label366;
                           }
                        }

                        if (entity.getPersistentData().m_128459_("mode_fly") < 0.0) {
                           entity.getPersistentData().m_128347_("mode_fly", old_mode_fly < 0.0 ? 0.0 : old_mode_fly);
                        }
                     }
                  }

                  if (entity.getPersistentData().m_128459_("mode_fly") != 0.0) {
                     if (entity.m_20202_() instanceof LivingEntity) {
                        speed = 4.0;
                     } else {
                        speed = 1.0;
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).m_20185_();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.m_5448_();
                     } else {
                        var10000 = null;
                     }

                     double var78 = ((Entity)var10000).m_20186_();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.m_5448_();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var78 + (double)((Entity)var10001).m_20206_() * 0.5;
                     LivingEntity var79;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var79 = _mobEnt.m_5448_();
                     } else {
                        var79 = null;
                     }

                     z_pos = ((Entity)var79).m_20189_();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     yaw = (double)entity.m_146908_();
                     pitch = (double)entity.m_146909_();
                     if (entity.getPersistentData().m_128459_("mode_fly") > 0.0) {
                        double var84 = entity.m_20186_();
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10001 = _mobEnt.m_5448_();
                        } else {
                           var10001 = null;
                        }

                        var84 = (var84 + ((Entity)var10001).m_20186_()) * 0.5;
                        double var90 = entity.m_20185_();
                        LivingEntity var10002;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.m_5448_();
                        } else {
                           var10002 = null;
                        }

                        var90 = Math.pow(var90 - ((Entity)var10002).m_20185_(), 2.0);
                        double var93 = entity.m_20189_();
                        LivingEntity var10003;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10003 = _mobEnt.m_5448_();
                        } else {
                           var10003 = null;
                        }

                        y_pos = var84 + Math.sqrt(Math.sqrt(var90 + Math.pow(var93 - ((Entity)var10003).m_20189_(), 2.0)));
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        x_power = entity.m_20154_().f_82479_ * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        y_power = entity.m_20154_().f_82480_ * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        z_power = entity.m_20154_().f_82481_ * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        if (distance < 4.0) {
                           var84 = entity.m_20186_();
                           LivingEntity var92;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var92 = _mobEnt.m_5448_();
                           } else {
                              var92 = null;
                           }

                           if (var84 > ((Entity)var92).m_20186_()) {
                              entity.getPersistentData().m_128347_("mode_fly", 0.0);
                           }
                        }
                     } else if (entity.getPersistentData().m_128459_("mode_fly") < 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.m_9236_().m_5776_()) {
                              _entity.m_7292_(new MobEffectInstance(MobEffects.f_19597_, 40, 0, false, false));
                           }
                        }

                        if (entity.getPersistentData().m_128459_("mode_fly") == -1.0) {
                           label237: {
                              x_power = entity.m_20154_().f_82479_ * -1.0;
                              if (!(height <= Math.max(Math.min(distance * 0.75, 15.0), 4.0))) {
                                 double var82 = entity.m_20186_();
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10001 = _mobEnt.m_5448_();
                                 } else {
                                    var10001 = null;
                                 }

                                 if (!(var82 <= ((Entity)var10001).m_20186_())) {
                                    var83 = -1;
                                    break label237;
                                 }
                              }

                              var83 = 1;
                           }

                           y_power = (double)var83;
                           z_power = entity.m_20154_().f_82481_ * -1.0;
                           if (distance > 16.0) {
                              entity.getPersistentData().m_128347_("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                           }
                        } else if (entity.getPersistentData().m_128459_("mode_fly") == -2.0 || entity.getPersistentData().m_128459_("mode_fly") == -3.0) {
                           entity.m_146922_((float)((double)entity.m_146908_() + (90.0 + Math.random() * (double)(distance > 16.0 ? -45 : 45)) * (double)(entity.getPersistentData().m_128459_("mode_fly") == -2.0 ? 1 : -1)));
                           entity.m_146926_(entity.m_146909_());
                           entity.m_5618_(entity.m_146908_());
                           entity.m_5616_(entity.m_146908_());
                           entity.f_19859_ = entity.m_146908_();
                           entity.f_19860_ = entity.m_146909_();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.f_20884_ = _entity.m_146908_();
                              _entity.f_20886_ = _entity.m_146908_();
                           }

                           label245: {
                              x_power = entity.m_20154_().f_82479_ * 1.0;
                              if (!(height <= Math.max(Math.min(distance * 0.75, 15.0), 4.0))) {
                                 double var80 = entity.m_20186_();
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10001 = _mobEnt.m_5448_();
                                 } else {
                                    var10001 = null;
                                 }

                                 if (!(var80 <= ((Entity)var10001).m_20186_())) {
                                    var81 = -1;
                                    break label245;
                                 }
                              }

                              var81 = 1;
                           }

                           y_power = (double)var81;
                           z_power = entity.m_20154_().f_82481_ * 1.0;
                           if (distance < 4.0) {
                              entity.getPersistentData().m_128347_("mode_fly", -1.0);
                           }
                        }
                     }

                     x_power = entity.m_20184_().m_7096_() + 0.1 * (double)(entity.m_20184_().m_7096_() > x_power * speed ? -1 : 1) * speed;
                     y_power = entity.m_20184_().m_7098_() + 0.1 * (double)(entity.m_20184_().m_7098_() > y_power * speed ? -1 : 1) * speed;
                     z_power = entity.m_20184_().m_7094_() + 0.1 * (double)(entity.m_20184_().m_7094_() > z_power * speed ? -1 : 1) * speed;
                     entity.m_20256_(new Vec3(x_power, y_power, z_power));
                     entity.m_146922_((float)yaw);
                     entity.m_146926_((float)pitch);
                     entity.m_5618_(entity.m_146908_());
                     entity.m_5616_(entity.m_146908_());
                     entity.f_19859_ = entity.m_146908_();
                     entity.f_19860_ = entity.m_146909_();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.f_20884_ = _entity.m_146908_();
                        _entity.f_20886_ = _entity.m_146908_();
                     }

                     if (entity.m_20202_() instanceof EntityBroomEntity) {
                        entity.m_20202_().m_20256_(new Vec3(x_power, y_power, z_power));
                        Entity _ent = entity.m_20202_();
                        _ent.m_146922_((float)yaw);
                        _ent.m_146926_((float)pitch);
                        _ent.m_5618_(_ent.m_146908_());
                        _ent.m_5616_(_ent.m_146908_());
                        _ent.f_19859_ = _ent.m_146908_();
                        _ent.f_19860_ = _ent.m_146909_();
                        if (_ent instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)_ent;
                           _entity.f_20884_ = _entity.m_146908_();
                           _entity.f_20886_ = _entity.m_146908_();
                        }

                        return;
                     }
                  }

                  return;
               }
            }

            entity.getPersistentData().m_128347_("mode_fly", 0.0);
         } else {
            entity.getPersistentData().m_128347_("mode_fly", 0.0);
         }

      }
   }
}
