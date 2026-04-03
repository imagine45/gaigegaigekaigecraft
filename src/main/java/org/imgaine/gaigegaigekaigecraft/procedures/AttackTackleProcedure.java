package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiBugEntity;
import org.imgaine.gaigegaigekaigecraft.entity.FushiguroTojiEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AttackTackleProcedure {
   public AttackTackleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean stop = false;
         boolean targeting = false;
         boolean logic_a = false;
         boolean danger = false;
         boolean rotate = false;
         boolean avoidance = false;
         boolean logic_b = false;
         boolean water = false;
         boolean stopHighSpeed = false;
         boolean move_avoid = false;
         boolean move_attack = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double old_skill = 0.0;
         double speed = 0.0;
         double vx = 0.0;
         double vy = 0.0;
         double vz = 0.0;
         double y_fix = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double old_mode = 0.0;
         double y_fix_height = 0.0;
         double num1 = 0.0;
         double cnt8 = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double bbHeight = 0.0;
         double bbWidth = 0.0;
         entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         entity.fallDistance = 0.0F;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 5, 2, false, false));
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

         target_entity = var10000;
         targeting = target_entity instanceof LivingEntity;
         bbHeight = (double)entity.getBbHeight();
         bbWidth = (double)entity.getBbWidth();
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            entity.getPersistentData().putDouble("Damage", 8.0);
            entity.getPersistentData().putDouble("Range", 5.0 * range);
            entity.getPersistentData().putDouble("knockback", 0.2);
            entity.getPersistentData().putDouble("effect", 5.0);
            entity.getPersistentData().putDouble("projectile_type", 1.0);
            entity.getPersistentData().putBoolean("swing", true);
            entity.getPersistentData().putBoolean("attack", true);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         }

         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            danger = false;
            Vec3 _center = new Vec3((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY(), (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(3.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(3.0), (e) -> true)) {
               if (entity != entityiterator) {
                  if (entityiterator.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().getDouble("Damage") > entity.getPersistentData().getDouble("Damage") && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     danger = true;
                     break;
                  }

                  double var149;
                  if (entityiterator instanceof Projectile) {
                     Projectile _projEnt = (Projectile)entityiterator;
                     var149 = _projEnt.getDeltaMovement().length();
                  } else {
                     var149 = 0.0;
                  }

                  if (var149 > 0.0) {
                     danger = true;
                     break;
                  }
               }
            }

            if (!danger) {
               _center = new Vec3(x, y, z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
                  if (entity != entityiterator) {
                     if (entityiterator.isAlive() && entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && entityiterator.getPersistentData().getDouble("Damage") > entity.getPersistentData().getDouble("Damage") * 0.75 && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                        avoidance = true;
                        break;
                     }

                     double var150;
                     if (entityiterator instanceof Projectile) {
                        Projectile _projEnt = (Projectile)entityiterator;
                        var150 = _projEnt.getDeltaMovement().length();
                     } else {
                        var150 = 0.0;
                     }

                     if (var150 > 0.0) {
                        avoidance = true;
                        break;
                     }
                  }
               }
            }

            if (GetDistanceNearestEnemyProcedure.execute(world, entity) < 3.0) {
               danger = true;
               if (GetDistanceProcedure.execute(entity) < 3.0) {
                  rotate = true;
                  stop = true;
               }
            }

            if (entity instanceof Player && entity.isShiftKeyDown()) {
               rotate = true;
               stop = true;
            }

            label565: {
               label520: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt42 = (LivingEntity)entity;
                     if (_livEnt42.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                        break label520;
                     }
                  }

                  if (!(entity instanceof LivingEntity)) {
                     break label565;
                  }

                  LivingEntity _livEnt43 = (LivingEntity)entity;
                  if (!_livEnt43.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     break label565;
                  }
               }

               water = !entity.isInWater() && world.getBlockState(BlockPos.containing(entity.getX(), entity.getY() - 0.1, entity.getZ())).getBlock() == Blocks.WATER;
            }

            if (OnGroundProcedure.execute(world, entity) || water) {
               if (targeting) {
                  label451: {
                     x_pos = target_entity.getX();
                     y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
                     z_pos = target_entity.getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     yaw = (double)entity.getYRot();
                     pitch = (double)entity.getXRot();
                     num1 = GetDistanceProcedure.execute(entity);
                     if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && !(entity instanceof FushiguroTojiBugEntity)) {
                        int var151;
                        label447: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var151 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label447;
                              }
                           }

                           var151 = 0;
                        }

                        int var10001;
                        double var152;
                        label442: {
                           var152 = (double)var151 * 0.5;
                           if (target_entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)target_entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label442;
                              }
                           }

                           var10001 = 0;
                        }

                        if (!(var152 >= (double)var10001) && !(range > 1.5)) {
                           if (entity.getPersistentData().getDouble("cnt8") > 30.0) {
                              move_attack = true;
                           }

                           if (target_entity.getPersistentData().getDouble("skill") == 0.0) {
                              int var153;
                              label525: {
                                 label432: {
                                    if (target_entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)target_entity;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get())) {
                                          var153 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get()).getDuration();
                                          break label432;
                                       }
                                    }

                                    var153 = 0;
                                 }

                                 if (var153 <= 10) {
                                    int var154;
                                    label425: {
                                       if (target_entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)target_entity;
                                          if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get())) {
                                             var154 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get()).getDuration();
                                             break label425;
                                          }
                                       }

                                       var154 = 0;
                                    }

                                    if (var154 <= 10) {
                                       break label525;
                                    }
                                 }

                                 move_attack = true;
                              }
                           }

                           if (!(entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) && target_entity.getPersistentData().getDouble("skill") != 0.0 && entity.getPersistentData().getDouble("cnt8") < 30.0) {
                              move_attack = false;
                           }
                           break label451;
                        }
                     }

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
               }

               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0 * range);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0 * range);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0 * range);
               GetPowerFixProcedure.execute(entity);
               speed = Math.sqrt(entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("x_power") + entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("y_power") + entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("z_power"));
               speed *= 2.0;
               if (targeting) {
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
                           danger = true;
                           rotate = true;
                           stop = true;
                           break;
                        }
                     }
                  }
               }

               if (entity.onGround()) {
                  entity.getPersistentData().putDouble("y_power", Math.max(entity.getPersistentData().getDouble("y_power"), 0.0) + 0.05);
               }

               if (water) {
                  entity.getPersistentData().putDouble("y_power", Math.max(entity.getPersistentData().getDouble("y_power"), 0.0) + 0.05);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 2.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x, y, z, (int)(2.0 * range), 0.1 * range, 0.1, 0.1 * range, 0.25);
                  }
               } else if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int)(2.0 * range), 0.1 * range, 0.1, 0.1 * range, 0.25);
               }

               vx = entity.getPersistentData().getDouble("x_power");
               vy = entity.getPersistentData().getDouble("y_power");
               vz = entity.getPersistentData().getDouble("z_power");
               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, vx, vy, vz);
               entity.setDeltaMovement(new Vec3(vx, Math.min(vy, 1.5 * range), vz));
               entity.fallDistance = 0.0F;
            }

            if (!(entity.getPersistentData().getDouble("cnt8") > 120.0) && (entity instanceof Player || targeting)) {
               if (rotate) {
                  PlayAnimationEntity2Procedure.execute(entity, "empty");
                  entity.getPersistentData().putDouble("cnt1", 10.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  if (!(entity.getPersistentData().getDouble("cnt8") <= 60.0)) {
                     entity.getPersistentData().putDouble("cnt7", 3.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt7", !(entity instanceof FushiguroTojiEntity) && !(entity instanceof FushiguroTojiBugEntity) ? Math.ceil(3.0 * Math.random()) : (double)(1L + Math.round(Math.random())));
                  }

                  if (stop) {
                     entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  }
               } else if (danger) {
                  PlayAnimationEntity2Procedure.execute(entity, "empty");
                  entity.getPersistentData().putDouble("cnt1", 10.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("cnt7", 2.0);
               }
            } else {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            old_skill = entity.getPersistentData().getDouble("skill");
            cnt8 = entity.getPersistentData().getDouble("cnt8");
            if (target_entity instanceof LivingEntity) {
               x_pos = target_entity.getX();
               y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
               z_pos = target_entity.getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity165 = (LivingEntity)entity;
               if (_livingEntity165.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity165.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("cnt7") == 2.0) {
               AttackContinueProcedure.execute(world, x, y, z, entity);
            } else if (entity.getPersistentData().getDouble("cnt7") == 3.0) {
               AttackStrongProcedure.execute(world, x, y, z, entity);
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               ResetCounterProcedure.execute(entity);
               entity.getPersistentData().putDouble("skill", old_skill);
               entity.getPersistentData().putDouble("cnt8", cnt8);
               if (entity.getPersistentData().getDouble("cnt8") >= 60.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
