package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FrameEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AttackProjectionSorceryProcedure {
   public AttackProjectionSorceryProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean berserker = false;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_skill = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double rnd = 0.0;
         double y_fix_height = 0.0;
         double old_mode = 0.0;
         double cnt8 = 0.0;
         double cnt9 = 0.0;
         double dis2 = 0.0;
         double distance = 0.0;
         entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 5, 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 5, 0, false, false));
            }
         }

         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         targeting = var10000 instanceof LivingEntity;
         if (entity.getPersistentData().getDouble("cnt7") <= 10.0) {
            if (!targeting) {
               if (!(entity instanceof Player)) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else {
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

               y_pos = ((Entity)var10000).getY();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               z_pos = ((Entity)var10000).getZ();
               dis = 0.0;

               for(int index0 = 0; index0 < 255 && !world.getBlockState(BlockPos.containing(x_pos, y_pos - dis, z_pos)).canOcclude(); ++index0) {
                  if (y_pos - dis < 0.0) {
                     dis = 255.0;
                     break;
                  }

                  ++dis;
               }

               Vec3 _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(9.0), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (entityiterator.getPersistentData().getDouble("Damage") > 0.0 && entityiterator.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        danger = true;
                        break;
                     }

                     double var146;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var146 = _projEnt.getDeltaMovement().length();
                     } else {
                        var146 = 0.0;
                     }

                     if (var146 > 0.0) {
                        danger = true;
                        break;
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt7") <= 0.0 && OnGroundProcedure.execute(world, entity)) {
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

                  double var149 = ((Entity)var10000).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var149 + (double)((Entity)var10001).getBbHeight() * 0.75;
                  LivingEntity var150;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var150 = _mobEnt.getTarget();
                  } else {
                     var150 = null;
                  }

                  z_pos = ((Entity)var150).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)entity.getYRot();
                  pitch = (double)entity.getXRot();
                  dis2 = GetDistanceProcedure.execute(entity);
                  berserker = false;
                  if (entity.getPersistentData().getDouble("cnt7") >= 0.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var150 = _mobEnt.getTarget();
                     } else {
                        var150 = null;
                     }

                     label551: {
                        if (((Entity)var150).getPersistentData().getDouble("skill") != 0.0) {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.getTarget();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().getDouble("skill") == 0.0) {
                              break label551;
                           }

                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var150 = _mobEnt.getTarget();
                           } else {
                              var150 = null;
                           }

                           if (((Entity)var150).getPersistentData().getDouble("Damage") != 0.0) {
                              break label551;
                           }
                        }

                        berserker = true;
                     }
                     int var154;
                     label542: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var154 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label542;
                           }
                        }

                        var154 = 0;
                     }

                     double var155 = (double)var154 * 0.75;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }
                     int var170;
                     label536: {
                        LivingEntity _mobEnt = var10001;
                        if (_mobEnt instanceof LivingEntity) {
                           LivingEntity _livEnt = _mobEnt;
                           if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              var170 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                              break label536;
                           }
                        }

                        var170 = 0;
                     }

                     if (var155 > (double)var170) {
                        berserker = true;
                     }
                  }

                  if ((berserker || dis2 > 32.0) && !danger) {
                     entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                     entity.getPersistentData().putDouble("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                  } else {
                     label651: {
                        if (!(entity.getPersistentData().getDouble("cnt7") < 0.0)) {
                           label623: {
                              label523: {
                                 if (!(entity.getPersistentData().getDouble("cnt8") < 10.0)) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.getTarget();
                                    } else {
                                       var150 = null;
                                    }

                                    if (((Entity)var150).getPersistentData().getDouble("skill") == 0.0) {
                                       break label523;
                                    }

                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var150 = _mobEnt.getTarget();
                                    } else {
                                       var150 = null;
                                    }

                                    if (!(((Entity)var150).getPersistentData().getDouble("Damage") > 0.0)) {
                                       break label523;
                                    }
                                 }

                                 if (dis2 < 6.0) {
                                    break label623;
                                 }
                              }

                              if (!(entity.getPersistentData().getDouble("cnt8") < 5.0) || !(dis2 < 3.0)) {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var150 = _mobEnt.getTarget();
                                 } else {
                                    var150 = null;
                                 }

                                 label487: {
                                    if (((Entity)var150).getPersistentData().getDouble("skill") != 0.0) {
                                       if (entity instanceof Mob) {
                                          Mob _mobEnt = (Mob)entity;
                                          var150 = _mobEnt.getTarget();
                                       } else {
                                          var150 = null;
                                       }

                                       if (((Entity)var150).getPersistentData().getDouble("Damage") > 0.0) {
                                          if (entity instanceof Mob) {
                                             Mob _mobEnt = (Mob)entity;
                                             var150 = _mobEnt.getTarget();
                                          } else {
                                             var150 = null;
                                          }

                                          if (!((Entity)var150).getPersistentData().getBoolean("attack")) {
                                             break label487;
                                          }
                                       }
                                    }

                                    if (!(entity.getPersistentData().getDouble("cnt8") < 10.0)) {
                                       entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                                       entity.getPersistentData().putDouble("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                                       break label651;
                                    }
                                 }

                                 entity.setYRot((float)(yaw + (double)(Math.random() < 0.5 ? 90 : -90) + (Math.random() - 0.5) * 90.0));
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

                                 entity.getPersistentData().putDouble("cnt7", 1.0);
                                 break label651;
                              }
                           }
                        }

                        logic_a = false;

                        for(int index1 = 0; index1 < 64; ++index1) {
                           entity.setYRot((float)(yaw + 180.0 + (Math.random() - 0.5) * 270.0));
                           entity.setXRot(-45.0F);
                           entity.setYBodyRot(entity.getYRot());
                           entity.setYHeadRot(entity.getYRot());
                           entity.yRotO = entity.getYRot();
                           entity.xRotO = entity.getXRot();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.yBodyRotO = _entity.getYRot();
                              _entity.yHeadRotO = _entity.getYRot();
                           }

                           if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.COLLIDER, Fluid.NONE, entity)).getType() != Type.BLOCK) {
                              entity.setYRot(entity.getYRot());
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

                              logic_a = true;
                              break;
                           }
                        }

                        if (!logic_a) {
                           entity.setYRot((float)(yaw + (Math.random() - 0.5) * 90.0 * (Math.min(dis2, 32.0) / 32.0)));
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

                           entity.getPersistentData().putDouble("cnt7", (double)(dis > 2.0 && dis < 16.0 ? 2 : 1));
                        } else {
                           entity.getPersistentData().putDouble("cnt7", 1.0);
                        }
                     }
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
            }

            entity.fallDistance = 0.0F;
            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            GetPowerFixProcedure.execute(entity);
            if (targeting && entity.getPersistentData().getDouble("cnt7") == 2.0 && dis > 2.0 && dis < 16.0 && entity.getDeltaMovement().y() >= -0.05) {
               entity.getPersistentData().putBoolean("canFly", true);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               double var162 = ((Entity)var10000).getX();
               LivingEntity var171;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var171 = _mobEnt.getTarget();
               } else {
                  var171 = null;
               }

               double var172 = ((Entity)var171).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var172 += (double)(((Entity)var10002).getBbHeight() * 1.0F);
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               GetPowerForwardProcedure.execute(var162, var172, ((Entity)var10002).getZ(), entity);
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.0, entity.getPersistentData().getDouble("y_power") * 1.0, entity.getPersistentData().getDouble("z_power") * 1.0));
            } else if (entity.getPersistentData().getDouble("cnt8") > 100.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().putDouble("skill", 0.0);
            } else if (OnGroundProcedure.execute(world, entity)) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 2, 0.1, 0.1, 0.1, 0.5);
               }

               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.0, entity.getPersistentData().getDouble("y_power") * 1.0, entity.getPersistentData().getDouble("z_power") * 1.0));
               entity.getPersistentData().putDouble("cnt7", 0.0);
            }

            speed = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0));
            speed *= 2.0;
            if (speed != 0.0) {
               vx = entity.getDeltaMovement().x() / speed;
               vy = entity.getDeltaMovement().y() / speed;
               vz = entity.getDeltaMovement().z() / speed;

               for(int index2 = 0; index2 < (int)Math.round(Math.max(speed, 1.0)); ++index2) {
                  x_pos = entity.getX();
                  y_pos = entity.getY();
                  z_pos = entity.getZ();
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
                     rotate = true;
                     if (GetDistanceProcedure.execute(entity) < 3.0) {
                        stop = true;
                        if (entity.getPersistentData().getDouble("cnt_special") > 0.0) {
                           entity.getPersistentData().putDouble("cnt_special", -60.0);
                           EntityUseProjectionSorceryProcedure.execute(entity);
                        }
                     }

                     if (targeting && entity.getPersistentData().getDouble("cnt7") == 2.0) {
                        double var163 = entity.getY();
                        LivingEntity var174;
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var174 = _mobEnt.getTarget();
                        } else {
                           var174 = null;
                        }

                        if (var163 <= ((Entity)var174).getY() + 1.0) {
                           stop = false;
                           rotate = false;
                        }
                     }

                     if (rotate) {
                        break;
                     }
                  }

                  if (speed == 0.0) {
                     break;
                  }

                  logic_a = true;
                  y_fix_height = 0.0;

                  for(int index3 = 0; index3 < (int)Math.ceil((double)(entity.getBbHeight() + 0.0F)); ++index3) {
                     if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + vy + y_fix_height, z_pos)).canOcclude()) {
                        logic_a = false;
                        break;
                     }

                     ++y_fix_height;
                  }

                  if (logic_a) {
                     x_pos += vx;
                     y_pos += vy;
                     z_pos += vz;
                  } else {
                     logic_a = false;
                     y_fix = 0.0;

                     for(int index4 = 0; index4 < (int)Math.round(Math.max(speed * 2.0, 1.0)); ++index4) {
                        if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix, z_pos + vz)).canOcclude()) {
                           if (world.getBlockState(BlockPos.containing(x_pos, Math.max(y_pos + vy, y_pos) + y_fix, z_pos)).canOcclude()) {
                              logic_a = false;
                              break;
                           }

                           y_fix += 0.5;
                        } else {
                           logic_a = true;
                           y_fix_height = 0.0;

                           for(int index5 = 0; index5 < (int)Math.ceil((double)entity.getBbHeight()); ++index5) {
                              if (world.getBlockState(BlockPos.containing(x_pos + vx, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + y_fix + y_fix_height, z_pos + vz)).canOcclude() || world.getBlockState(BlockPos.containing(x_pos, y_pos + vy + y_fix + y_fix_height, z_pos + vz)).canOcclude()) {
                                 logic_a = false;
                                 break;
                              }

                              ++y_fix_height;
                           }

                           if (logic_a) {
                              break;
                           }

                           ++y_fix;
                        }
                     }

                     if (!logic_a) {
                        entity.getPersistentData().putDouble("cnt7", -1.0);
                        break;
                     }

                     x_pos += vx;
                     y_pos = y_pos + vy + y_fix;
                     z_pos += vz;
                  }

                  entity.teleportTo(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                  }
               }
            }

            if (rotate) {
               entity.getPersistentData().putDouble("cnt1", 10.0);
               if (world.getEntitiesOfClass(FrameEntity.class, AABB.ofSize(new Vec3(x, y, z), 6.0, 6.0, 6.0), (e) -> true).isEmpty() && (!stop || !(entity.getPersistentData().getDouble("cnt9") > 4.0) && entity.getPersistentData().getDouble("cnt7") != 2.0)) {
                  entity.getPersistentData().putDouble("cnt7", (double)(!stop ? 11L : Math.round(10.0 + Math.ceil(Math.random() * 2.0))));
               } else {
                  entity.getPersistentData().putDouble("cnt7", 12.0);
               }

               if (stop) {
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") > 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 2, 2, false, false));
               }
            }

            old_skill = entity.getPersistentData().getDouble("skill");
            old_mode = entity.getPersistentData().getDouble("mode");
            cnt8 = entity.getPersistentData().getDouble("cnt8");
            cnt9 = entity.getPersistentData().getDouble("cnt9");
            if (targeting) {
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

               double var166 = ((Entity)var10000).getY();
               LivingEntity var175;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var175 = _mobEnt.getTarget();
               } else {
                  var175 = null;
               }

               y_pos = var166 + (double)((Entity)var175).getBbHeight() * 0.75;
               LivingEntity var167;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var167 = _mobEnt.getTarget();
               } else {
                  var167 = null;
               }

               z_pos = ((Entity)var167).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }
            double var168;
            label372: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                     var168 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                     break label372;
                  }
               }

               var168 = 0.0;
            }

            distance = var168;
            if (entity.getPersistentData().getDouble("cnt7") == 11.0) {
               AttackContinueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("cnt7") == 12.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get());
            }

            if (distance > 0.0 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)distance, 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().putDouble("skill", old_skill);
               entity.getPersistentData().putDouble("mode", old_mode);
               entity.getPersistentData().putDouble("cnt8", cnt8);
               entity.getPersistentData().putDouble("cnt9", cnt9);
               if (entity.getPersistentData().getDouble("cnt9") > 4.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }

               entity.getPersistentData().putDouble("cnt8", Math.min(entity.getPersistentData().getDouble("cnt8"), 20.0));
               entity.getPersistentData().putDouble("cnt9", entity.getPersistentData().getDouble("cnt9") + 1.0);
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
