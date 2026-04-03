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
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target = var10000 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0;
         entity.fallDistance = 0.0F;
         entity_b = entity.getVehicle();
         if (!(entity_b instanceof LivingEntity)) {
            entity_b = entity;
         }

         label355: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt6 = (LivingEntity)entity;
               if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get())) {
                  break label355;
               }
            }

            if (!entity.onGround() && !entity.isInWater()) {
               if (entity.isPassenger() && (entity_b.onGround() || entity_b.isInWater()) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 200, 0, false, false));
                  }
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), 60, 0, false, false));
               }
            }
         }

         if (target && entity.getPersistentData().getDouble("skill") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt15 = (LivingEntity)entity;
               if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 9, false, false));
                     }
                  }

                  if (entity_b instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity_b;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 20, 9, false, false));
                     }
                  }

                  distance = GetDistanceProcedure.execute(entity);
                  height = GetHeightFromGroundProcedure.execute(world, entity);
                  if (Math.random() < 0.05) {
                     label366: {
                        label389: {
                           old_mode_fly = entity.getPersistentData().getDouble("mode_fly");
                           strong_enemy = false;
                           if (!(distance > 24.0)) {
                              label397: {
                                 label359: {
                                    label311: {
                                       if (distance > 6.0 && !LogicStartProcedure.execute(entity)) {
                                          int var73;
                                          label307: {
                                             if (entity instanceof LivingEntity) {
                                                LivingEntity _livEnt = (LivingEntity)entity;
                                                if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                                   var73 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                                   break label307;
                                                }
                                             }

                                             var73 = 0;
                                          }

                                          if (var73 > 20 && !strong_enemy) {
                                             break label311;
                                          }
                                       }

                                       if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:combat_type")))) {
                                          break label359;
                                       }
                                    }
                                    int var74;
                                    label299: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             var74 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                             break label299;
                                          }
                                       }

                                       var74 = 0;
                                    }

                                    if (var74 < 10) {
                                       break label397;
                                    }
                                 }

                                 if (LogicStartProcedure.execute(entity) || entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:combat_type")))) {
                                    label396: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt24 = (LivingEntity)entity;
                                          if (_livEnt24.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             break label396;
                                          }
                                       }

                                       if (!strong_enemy && !(Math.random() < 0.25)) {
                                          entity.getPersistentData().putDouble("mode_fly", old_mode_fly);
                                          break label389;
                                       }
                                    }
                                 }

                                 if (distance > 4.0) {
                                    label368: {
                                       if (!(distance > 16.0)) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var10000 = _mobEnt.getTarget();
                                          } else {
                                             var10000 = null;
                                          }

                                          if (((Entity)var10000).getPersistentData().getDouble("skill") == 0.0 && !(Math.random() < 0.5)) {
                                             break label368;
                                          }
                                       }

                                       if (old_mode_fly != -2.0 && old_mode_fly != -3.0) {
                                          entity.getPersistentData().putDouble("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                                          break label389;
                                       }

                                       entity.getPersistentData().putDouble("mode_fly", old_mode_fly);
                                       break label389;
                                    }
                                 }

                                 entity.getPersistentData().putDouble("mode_fly", -1.0);
                                 break label389;
                              }
                           }

                           entity.getPersistentData().putDouble("mode_fly", 1.0);
                        }

                        label262: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt31 = (LivingEntity)entity;
                              if (_livEnt31.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                 break label262;
                              }
                           }

                           if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:combat_type")))) {
                              break label366;
                           }
                        }

                        if (entity.getPersistentData().getDouble("mode_fly") < 0.0) {
                           entity.getPersistentData().putDouble("mode_fly", old_mode_fly < 0.0 ? 0.0 : old_mode_fly);
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("mode_fly") != 0.0) {
                     if (entity.getVehicle() instanceof LivingEntity) {
                        speed = 4.0;
                     } else {
                        speed = 1.0;
                     }

                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     x_pos = ((Entity)var10000).getX();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var78 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var78 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var79;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var79 = _mobEnt.getTarget();
                     } else {
                        var79 = null;
                     }

                     z_pos = ((Entity)var79).getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     yaw = (double)entity.getYRot();
                     pitch = (double)entity.getXRot();
                     if (entity.getPersistentData().getDouble("mode_fly") > 0.0) {
                        double var84 = entity.getY();
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10001 = _mobEnt.getTarget();
                        } else {
                           var10001 = null;
                        }

                        var84 = (var84 + ((Entity)var10001).getY()) * 0.5;
                        double var90 = entity.getX();
                        LivingEntity var10002;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10002 = _mobEnt.getTarget();
                        } else {
                           var10002 = null;
                        }

                        var90 = Math.pow(var90 - ((Entity)var10002).getX(), 2.0);
                        double var93 = entity.getZ();
                        LivingEntity var10003;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10003 = _mobEnt.getTarget();
                        } else {
                           var10003 = null;
                        }

                        y_pos = var84 + Math.sqrt(Math.sqrt(var90 + Math.pow(var93 - ((Entity)var10003).getZ(), 2.0)));
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        x_power = entity.getLookAngle().x * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        y_power = entity.getLookAngle().y * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        z_power = entity.getLookAngle().z * Math.max(Math.min(1.25, distance * 0.25), 0.25);
                        if (distance < 4.0) {
                           var84 = entity.getY();
                           LivingEntity var92;
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var92 = _mobEnt.getTarget();
                           } else {
                              var92 = null;
                           }

                           if (var84 > ((Entity)var92).getY()) {
                              entity.getPersistentData().putDouble("mode_fly", 0.0);
                           }
                        }
                     } else if (entity.getPersistentData().getDouble("mode_fly") < 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, false, false));
                           }
                        }

                        if (entity.getPersistentData().getDouble("mode_fly") == -1.0) {
                           int var83;
                           label237: {
                              x_power = entity.getLookAngle().x * -1.0;
                              if (!(height <= Math.max(Math.min(distance * 0.75, 15.0), 4.0))) {
                                 double var82 = entity.getY();
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10001 = _mobEnt.getTarget();
                                 } else {
                                    var10001 = null;
                                 }

                                 if (!(var82 <= ((Entity)var10001).getY())) {
                                    var83 = -1;
                                    break label237;
                                 }
                              }

                              var83 = 1;
                           }

                           y_power = (double)var83;
                           z_power = entity.getLookAngle().z * -1.0;
                           if (distance > 16.0) {
                              entity.getPersistentData().putDouble("mode_fly", (double)(Math.random() < 0.5 ? -2 : -3));
                           }
                        } else if (entity.getPersistentData().getDouble("mode_fly") == -2.0 || entity.getPersistentData().getDouble("mode_fly") == -3.0) {
                           entity.setYRot((float)((double)entity.getYRot() + (90.0 + Math.random() * (double)(distance > 16.0 ? -45 : 45)) * (double)(entity.getPersistentData().getDouble("mode_fly") == -2.0 ? 1 : -1)));
                           entity.setXRot(entity.getXRot());
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }
                           int var81;
                           label245: {
                              x_power = entity.getLookAngle().x * 1.0;
                              if (!(height <= Math.max(Math.min(distance * 0.75, 15.0), 4.0))) {
                                 double var80 = entity.getY();
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10001 = _mobEnt.getTarget();
                                 } else {
                                    var10001 = null;
                                 }

                                 if (!(var80 <= ((Entity)var10001).getY())) {
                                    var81 = -1;
                                    break label245;
                                 }
                              }

                              var81 = 1;
                           }

                           y_power = (double)var81;
                           z_power = entity.getLookAngle().z * 1.0;
                           if (distance < 4.0) {
                              entity.getPersistentData().putDouble("mode_fly", -1.0);
                           }
                        }
                     }

                     x_power = entity.getDeltaMovement().x() + 0.1 * (double)(entity.getDeltaMovement().x() > x_power * speed ? -1 : 1) * speed;
                     y_power = entity.getDeltaMovement().y() + 0.1 * (double)(entity.getDeltaMovement().y() > y_power * speed ? -1 : 1) * speed;
                     z_power = entity.getDeltaMovement().z() + 0.1 * (double)(entity.getDeltaMovement().z() > z_power * speed ? -1 : 1) * speed;
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                     entity.setYRot((float)yaw);
                     entity.setXRot((float)pitch);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     if (entity.getVehicle() instanceof EntityBroomEntity) {
                        entity.getVehicle().setDeltaMovement(new Vec3(x_power, y_power, z_power));
                        Entity _ent = entity.getVehicle();
                        _ent.setYRot((float)yaw);
                        _ent.setXRot((float)pitch);
                        _ent.setYBodyRot(_ent.getYRot());
                        _ent.setYHeadRot(_ent.getYRot());
                        _ent.yRotO = _ent.getYRot();
                        _ent.xRotO = _ent.getXRot();
                        if (_ent instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)_ent;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        return;
                     }
                  }

                  return;
               }
            }

            entity.getPersistentData().putDouble("mode_fly", 0.0);
         } else {
            entity.getPersistentData().putDouble("mode_fly", 0.0);
         }

      }
   }
}
