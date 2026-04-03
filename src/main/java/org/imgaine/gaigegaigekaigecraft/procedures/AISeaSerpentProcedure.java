package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.BathynomusGiganteusEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SeaSerpentMiniEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AISeaSerpentProcedure {
   public AISeaSerpentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double CNT6 = 0.0;
         double entity_size = 0.0;
         double strength = 0.0;
         double speed = 0.0;
         double size = 0.0;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean logic_c = false;
         boolean SUCCESS = false;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (entity.isAlive()) {
            BulletDomainHit2Procedure.execute(world, entity);
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("movement") == 1.0) {
               AISeaSerpent2Procedure.execute(world, x, y, z, entity);
            } else {
               if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                  x_power = entity.getPersistentData().getDouble("x_power");
                  y_power = entity.getPersistentData().getDouble("y_power");
                  z_power = entity.getPersistentData().getDouble("z_power");

                  for(int index0 = 0; index0 < 2; ++index0) {
                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }

                     if (entity.getPersistentData().getDouble("cnt1") >= 8.0 && (!entity.isInWall() || entity.getPersistentData().getDouble("cnt1") >= 16.0)) {
                        x_pos = entity.getX();
                        y_pos = entity.getY();
                        z_pos = entity.getZ();
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash")), SoundSource.NEUTRAL, 2.0F, (float)CNT6, false);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.getBbWidth()) * CNT6), 1.0, 1.0, 1.0, 2.0);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER_2.get(), x_pos, y_pos, z_pos, (int)((double)(20.0F * entity.getBbWidth()) * CNT6), 1.0, 1.0, 1.0, 1.0);
                        }

                        entity.getPersistentData().putDouble("cnt1", 0.0);
                        if (entity instanceof BathynomusGiganteusEntity) {
                           entity.getPersistentData().putDouble("cnt2", 2.0);
                        } else {
                           entity.getPersistentData().putDouble("cnt2", (double)(Math.random() < 0.3 ? 2 : 1));
                        }
                        break;
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt2") != 0.0) {
                  entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                  size = ReturnEntitySizeProcedure.execute(entity);
                  if (entity.getPersistentData().getBoolean("Stop")) {
                     entity.getPersistentData().putBoolean("Stop", true);
                  } else {
                     if (!(entity instanceof BathynomusGiganteusEntity) || entity.getPersistentData().getDouble("cnt1") < 15.0) {
                        dis = 32.0;
                        x_pos = entity.getX() + entity.getLookAngle().x * dis;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * dis;
                        z_pos = entity.getZ() + entity.getLookAngle().z * dis;
                        if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                           entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                           if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                              LivingEntity var10000;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (var10000 instanceof LivingEntity) {
                                 if (entity_a instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity_a;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 entity_a = var10000;
                                 x_pos = entity_a.getX();
                                 y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5;
                                 z_pos = entity_a.getZ();
                              } else {
                                 dis = 8.0;
                                 logic_a = false;

                                 for(int index1 = 0; index1 < 2; ++index1) {
                                    x_pos = entity_a.getX() + entity_a.getLookAngle().x * dis;
                                    y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.9 + entity_a.getLookAngle().y * dis;
                                    z_pos = entity_a.getZ() + entity_a.getLookAngle().z * dis;
                                    Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                                    for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(12.0), (e) -> true)) {
                                       if (entity != entityiterator && LogicAttackProcedure.execute(world, entity_a, entityiterator)) {
                                          logic_a = true;
                                          x_pos = entityiterator.getX();
                                          y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                                          z_pos = entityiterator.getZ();
                                          break;
                                       }
                                    }

                                    if (logic_a || entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.COLLIDER, Fluid.NONE, entity_a)).getType() == Type.BLOCK) {
                                       break;
                                    }

                                    dis += 16.0;
                                 }
                              }
                           }
                        }

                        yaw = (double)(entity.getYRot() % 360.0F);
                        pitch = (double)entity.getXRot();
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                        dis = Math.sqrt((entity.getX() - x_pos) * (entity.getX() - x_pos) + (entity.getY() - y_pos) * (entity.getY() - y_pos) + (entity.getZ() - z_pos) * (entity.getZ() - z_pos));
                        if (dis < 0.0 || dis > 14.0) {
                           entity.setYRot(entity.getYRot() % 360.0F);
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

                           yaw_cal = (double)entity.getYRot() - yaw;
                           yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 6 : -6);
                           pitch = (double)entity.getXRot();
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
                        }
                     }

                     speed = entity.getPersistentData().getDouble("cnt_life") == 1.0 ? 1.0 : Math.min(1.0, Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z()) + 0.2);
                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * speed);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * speed);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * speed);
                     x_power = entity.getPersistentData().getDouble("x_power");
                     y_power = entity.getPersistentData().getDouble("y_power");
                     z_power = entity.getPersistentData().getDouble("z_power");
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                     dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
                     if (dis > 1.0) {
                        x_power /= dis;
                        y_power /= dis;
                        z_power /= dis;
                     } else {
                        dis = 1.0;
                     }

                     speed = Math.min(Math.sqrt(entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().y() * entity.getDeltaMovement().y() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z()), 3.0);
                     entity.getPersistentData().putDouble("cnt_attack", entity.getPersistentData().getDouble("cnt_attack") + 1.0);

                     for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                        logic_c = false;
                        if (entity.getPersistentData().getDouble("cnt_attack") > 0.0) {
                           if (entity instanceof BathynomusGiganteusEntity) {
                              entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
                           } else if (entity instanceof SeaSerpentMiniEntity) {
                              entity.getPersistentData().putDouble("Damage", 9.0 * CNT6);
                           } else {
                              entity.getPersistentData().putDouble("Damage", 13.5 * CNT6);
                           }

                           entity.getPersistentData().putDouble("knockback", 0.25);
                           entity.getPersistentData().putDouble("Range", (double)Math.max(1.0F + entity.getBbWidth(), 2.0F));
                           entity.getPersistentData().putDouble("effect", 1.0);
                           entity.getPersistentData().putBoolean("swing", true);
                           RangeAttackProcedure.execute(world, entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25, entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25, entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25, entity);
                           if (entity.getPersistentData().getDouble("cnt_attack") < 0.0) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.swing(InteractionHand.MAIN_HAND, true);
                              }

                              logic_c = true;
                           }
                        }

                        if (entity.getPersistentData().getBoolean("Stop")) {
                           entity.getPersistentData().putBoolean("Stop", false);
                           logic_a = false;
                           break;
                        }

                        logic_b = false;
                        entity.teleportTo(entity.getX() + x_power, entity.getY(), entity.getZ());
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.teleportTo(entity.getX() - x_power, entity.getY(), entity.getZ());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(entity.getX() - x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                           }

                           logic_b = true;
                        }

                        entity.teleportTo(entity.getX(), entity.getY() + y_power, entity.getZ());
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity.getX(), entity.getY() + y_power, entity.getZ(), entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.teleportTo(entity.getX(), entity.getY() - y_power, entity.getZ());
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(entity.getX(), entity.getY() - y_power, entity.getZ(), entity.getYRot(), entity.getXRot());
                           }

                           logic_b = true;
                        }

                        entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + z_power);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                        }

                        if (InsideSolidProcedure.execute(world, entity)) {
                           entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - z_power);
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _serverPlayer = (ServerPlayer)entity;
                              _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - z_power, entity.getYRot(), entity.getXRot());
                           }

                           logic_b = true;
                        }

                        if ((entity.isInWall() || logic_b) && (entity.getPersistentData().getDouble("cnt1") % 20.0 == 10.0 || logic_c)) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.swing(InteractionHand.MAIN_HAND, true);
                           }

                           entity.getPersistentData().putDouble("BlockRange", (double)(1.0F * entity.getBbWidth()));
                           entity.getPersistentData().putDouble("BlockDamage", Math.max((double)entity.getBbWidth() * 0.5 * CNT6, 0.5));
                           BlockDestroyAllDirectionProcedure.execute(world, entity.getX() + entity.getLookAngle().x * (double)entity.getBbWidth() * 0.25, entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * (double)entity.getBbWidth() * 0.25, entity.getZ() + entity.getLookAngle().z * (double)entity.getBbWidth() * 0.25, entity);
                        }
                     }

                     entity.getPersistentData().putDouble("x_knockback", 0.0);
                     entity.getPersistentData().putDouble("y_knockback", 0.0);
                     entity.getPersistentData().putDouble("z_knockback", 0.0);
                  }
               }

               if (entity instanceof BathynomusGiganteusEntity) {
                  if (entity.getPersistentData().getDouble("cnt1") > 60.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (entity instanceof SeaSerpentMiniEntity) {
                  if (entity.getPersistentData().getDouble("cnt1") > 80.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               } else if (entity.getPersistentData().getDouble("cnt1") > 80.0 && !entity.level().isClientSide()) {
                  entity.discard();
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            entity.getPersistentData().putDouble("cnt3", 1.0);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, (int)(2.0F * (entity.getBbHeight() + entity.getBbWidth())), (double)entity.getBbWidth() * 0.1, (double)entity.getBbHeight() * 0.1, (double)entity.getBbWidth() * 0.1, 1.0);
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()));
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, (float)(0.5 + Math.random()), false);
               }
            }
         }

      }
   }
}
