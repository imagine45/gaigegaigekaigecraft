package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiBugEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class HighSpeedOnEffectActiveTickProcedure {
   public HighSpeedOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, double amplifier) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stopHighSpeed = false;
         boolean logic_a = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double speed = 0.0;
         double bbHeight = 0.0;
         double num1 = 0.0;
         double y_fix = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double bbWidth = 0.0;
         if (amplifier > 0.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            target_entity = var10000;
            if (target_entity instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entity;
                  if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt4 = (LivingEntity)entity;
                  if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     return;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt5 = (LivingEntity)entity;
                  if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                     return;
                  }
               }

               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.getNavigation().stop();
               }

               bbHeight = (double)entity.getBbHeight();
               bbWidth = (double)entity.getBbWidth();
               range = ReturnEntitySizeProcedure.execute(entity);
               if (OnGroundProcedure.execute(world, entity)) {
                  x_pos = target_entity.getX();
                  y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
                  z_pos = target_entity.getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  num1 = GetDistanceProcedure.execute(entity);
                  if (!(entity instanceof FushiguroTojiBugEntity) && !(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(range > 1.5)) {
                     if (target_entity.getPersistentData().getDouble("skill") == 0.0) {
                        int var106;
                        label364: {
                           label315: {
                              if (target_entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)target_entity;
                                 if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                    var106 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                    break label315;
                                 }
                              }

                              var106 = 0;
                           }

                           if (var106 <= 10) {
                              int var107;
                              label308: {
                                 if (target_entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)target_entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                       var107 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                       break label308;
                                    }
                                 }

                                 var107 = 0;
                              }

                              if (var107 <= 10) {
                                 break label364;
                              }
                           }

                           move_attack = true;
                        }
                     }

                     if (num1 > 32.0) {
                        move_attack = true;
                     }
                     int var108;
                     label299: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var108 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label299;
                           }
                        }

                        var108 = 0;
                     }

                     int var10001;
                     double var109;
                     label294: {
                        var109 = (double)var108 * 0.5;
                        if (target_entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)target_entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label294;
                           }
                        }

                        var10001 = 0;
                     }

                     if (var109 >= (double)var10001) {
                        move_attack = true;
                     }

                     if (entity.getPersistentData().getDouble("cnt_backstep") > 10.0) {
                        move_avoid = true;
                     }
                  } else {
                     move_attack = true;
                  }

                  logic_a = false;
                  if (move_attack) {
                     for(int index0 = 0; index0 < 32; ++index0) {
                        entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0 * (num1 > 32.0 ? (32.0 - (Math.min(num1, 64.0) - 32.0)) / 32.0 : Math.min(num1, 32.0) / 32.0)));
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

                        for(int index1 = 0; index1 < 4; ++index1) {
                           if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0 * range)), Block.COLLIDER, Fluid.NONE, entity)).getType() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.getXRot() >= 90.0F) {
                              break;
                           }

                           entity.setYRot(entity.getYRot());
                           entity.setXRot(Math.max(entity.getXRot() - 10.0F, 90.0F));
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }
                  }

                  if (!logic_a || move_avoid) {
                     for(int index2 = 0; index2 < 32; ++index2) {
                        if (num1 < 8.0) {
                           entity.setYRot((float)(yaw + 180.0 + (Math.random() - 0.5) * 180.0));
                           entity.setXRot(0.0F);
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
                           entity.setYRot((float)(yaw + (double)(entity.getPersistentData().getDouble("cnt_target") % 100.0 < 50.0 ? 90 : -90) + (Math.random() - 0.5) * 90.0));
                           entity.setXRot(0.0F);
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }
                        }

                        for(int index3 = 0; index3 < 4; ++index3) {
                           if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0 * range)), Block.COLLIDER, Fluid.NONE, entity)).getType() != Type.BLOCK) {
                              logic_a = true;
                              break;
                           }

                           if (entity.getXRot() >= 90.0F) {
                              break;
                           }

                           entity.setYRot(entity.getYRot());
                           entity.setXRot(Math.max(entity.getXRot() - 10.0F, 90.0F));
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }
                        }

                        if (logic_a) {
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0 * range);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0 * range);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0 * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("x_power") + entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("y_power") + entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("z_power"));
                  speed *= 2.0;
                  if (speed > 0.0) {
                     entity.setSprinting(true);
                     vx = entity.getPersistentData().getDouble("x_power") / (speed * 1.0);
                     vy = entity.getPersistentData().getDouble("y_power") / (speed * 1.0);
                     vz = entity.getPersistentData().getDouble("z_power") / (speed * 1.0);
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();
                     num1 = 0.0;

                     for(int index4 = 0; index4 < (int)Math.round(Math.max(speed, 1.0)); ++index4) {
                        ++num1;
                        logic_a = true;
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                           x_pos += vx;
                           y_pos += vy;
                           z_pos += vz;
                        } else {
                           y_fix = 0.0;
                           logic_a = false;

                           for(int index5 = 0; index5 < (int)Math.round(num1 * 1.0); ++index5) {
                              ++y_fix;
                              if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                                 logic_a = true;
                                 x_pos += vx;
                                 y_pos = y_pos + vy + y_fix;
                                 z_pos += vz;
                                 break;
                              }
                           }

                           if (!logic_a) {
                              break;
                           }
                        }
                     }

                     if (!logic_a && !(num1 >= speed * 0.5)) {
                        logic_a = true;
                     } else {
                        logic_a = false;
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     }

                     if (logic_a) {
                        entity.setYRot((float)((double)(entity.getYRot() + 180.0F) + Mth.nextDouble(RandomSource.create(), -90.0, 90.0)));
                        entity.setXRot((float)Math.max((double)(-1.0F * entity.getXRot()), 22.5));
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0 * range);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0 * range);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0 * range);
                  GetPowerFixProcedure.execute(entity);
                  speed = Math.sqrt(entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("x_power") + entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("y_power") + entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("z_power"));
                  speed *= 2.0;
                  if (speed > 0.0) {
                     vx = entity.getPersistentData().getDouble("x_power") / (speed * 1.0);
                     vy = entity.getPersistentData().getDouble("y_power") / (speed * 1.0);
                     vz = entity.getPersistentData().getDouble("z_power") / (speed * 1.0);

                     for(int index6 = 0; index6 < (int)Math.round(Math.max(speed * 1.0, 1.0)); ++index6) {
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                        logic_a = true;
                        y_fix = 0.0;
                        if (InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy, z_pos + vz, bbHeight, bbWidth)) {
                           logic_a = false;

                           for(int index7 = 0; index7 < (int)Math.round(Math.max(speed * 1.0, 1.0)); ++index7) {
                              ++y_fix;
                              if (!InsideSolidCalculateProcedure.execute(world, x_pos + vx, y_pos + vy + y_fix, z_pos + vz, bbHeight, bbWidth) && !InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + vy + y_fix, z_pos, bbHeight, bbWidth)) {
                                 logic_a = true;
                                 break;
                              }
                           }
                        }

                        if (!logic_a) {
                           break;
                        }

                        y_pos = y_pos + vy + y_fix;
                        entity.teleportTo(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           y_pos -= vy + y_fix;
                           entity.teleportTo(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                           }
                        }

                        z_pos += vz;
                        entity.teleportTo(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           z_pos -= vz;
                           entity.teleportTo(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                           }
                        }

                        x_pos += vx;
                        entity.teleportTo(x_pos, y_pos, z_pos);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           x_pos -= vx;
                           entity.teleportTo(x_pos, y_pos, z_pos);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                           }
                        }

                        if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
                           stopHighSpeed = true;
                           break;
                        }
                     }
                  }

                  if (entity.onGround()) {
                     entity.getPersistentData().putDouble("y_power", Math.max(entity.getPersistentData().getDouble("y_power"), 0.0) + 0.05);
                  }

                  vx = entity.getPersistentData().getDouble("x_power");
                  vy = entity.getPersistentData().getDouble("y_power");
                  vz = entity.getPersistentData().getDouble("z_power");
                  StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, vx, vy, vz);
                  entity.setDeltaMovement(new Vec3(vx, Math.min(vy, 1.5 * range), vz));
                  entity.fallDistance = 0.0F;
               }

               if (stopHighSpeed) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get());
                  }

                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            }
         }

      }
   }
}
