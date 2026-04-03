package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.KaichiEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class AIKaichiProcedure {
   public AIKaichiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_attack = false;
         boolean skull = false;
         boolean logic_a = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double loop_num = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double speed = 0.0;
         double size = 0.0;
         double pitch = 0.0;
         double pitch_cal = 0.0;
         double yaw = 0.0;
         double yaw_cal = 0.0;
         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_life") > 10.0) {
            if (entity instanceof KaichiEntity) {
               PlayAnimationEntity2Procedure.execute(entity, "spin");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 2.0F, false);
               }
            }
         }

         size = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            logic_attack = false;
            entity.getPersistentData().putBoolean("Stop", false);
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged") && entity_a.getPersistentData().getDouble("skill") > 0.0) {
                  logic_attack = true;
                  entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                  entity.setYRot(entity_a.getYRot());
                  entity.setXRot(entity_a.getXRot());
                  entity.setYBodyRot(entity.getYRot());
                  entity.setYHeadRot(entity.getYRot());
                  entity.yRotO = entity.getYRot();
                  entity.xRotO = entity.getXRot();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.yBodyRotO = _entity.getYRot();
                     _entity.yHeadRotO = _entity.getYRot();
                  }

                  entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }

                  if (!entity.isAlive()) {
                     entity_a.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }

            if (!logic_attack || !entity.isAlive()) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 10, 0.25, 0.25, 0.25, 0.5);
               }
            }

            if (entity.getPersistentData().getDouble("cnt_life") > 10.0) {
               entity.getPersistentData().putDouble("Damage", 6.0);
               entity.getPersistentData().putDouble("Range", 2.0 * size);
               entity.getPersistentData().putDouble("knockback", 0.25);
               entity.getPersistentData().putDouble("effect", 1.0);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getBoolean("Stop")) {
               entity.getPersistentData().putBoolean("Stop", true);
            } else {
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
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

                        Level var103 = ((Entity)var10000).level();
                        ClipContext var10001;
                        LivingEntity var10003;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10003 = _mobEnt.getTarget();
                        } else {
                           var10003 = null;
                        }

                        Vec3 var110 = ((Entity)var10003).getEyePosition(1.0F);
                        LivingEntity var10004;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10004 = _mobEnt.getTarget();
                        } else {
                           var10004 = null;
                        }

                        Vec3 var115 = ((Entity)var10004).getEyePosition(1.0F);
                        LivingEntity var10005;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10005 = _mobEnt.getTarget();
                        } else {
                           var10005 = null;
                        }

                        var115 = var115.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var123 = Block.OUTLINE;
                        ClipContext.Fluid var10006 = Fluid.NONE;
                        LivingEntity var10007;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var110, var115, var123, var10006, var10007);
                        x_pos = (double)var103.clip(var10001).getBlockPos().getX();
                        LivingEntity var104;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var104 = _mobEnt.getTarget();
                        } else {
                           var104 = null;
                        }

                        Level var105 = ((Entity)var104).level();
                        LivingEntity var111;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var111 = _mobEnt.getTarget();
                        } else {
                           var111 = null;
                        }

                        Vec3 var112 = ((Entity)var111).getEyePosition(1.0F);
                        LivingEntity var117;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var117 = _mobEnt.getTarget();
                        } else {
                           var117 = null;
                        }

                        Vec3 var118 = ((Entity)var117).getEyePosition(1.0F);
                        LivingEntity var124;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var124 = _mobEnt.getTarget();
                        } else {
                           var124 = null;
                        }

                        var118 = var118.add(((Entity)var124).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var125 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var112, var118, var125, var10006, var10007);
                        y_pos = (double)var105.clip(var10001).getBlockPos().getY();
                        LivingEntity var106;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var106 = _mobEnt.getTarget();
                        } else {
                           var106 = null;
                        }

                        Level var107 = ((Entity)var106).level();
                        LivingEntity var113;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var113 = _mobEnt.getTarget();
                        } else {
                           var113 = null;
                        }

                        Vec3 var114 = ((Entity)var113).getEyePosition(1.0F);
                        LivingEntity var120;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var120 = _mobEnt.getTarget();
                        } else {
                           var120 = null;
                        }

                        Vec3 var121 = ((Entity)var120).getEyePosition(1.0F);
                        LivingEntity var126;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var126 = _mobEnt.getTarget();
                        } else {
                           var126 = null;
                        }

                        var121 = var121.add(((Entity)var126).getViewVector(1.0F).scale(0.0));
                        ClipContext.Block var127 = Block.OUTLINE;
                        var10006 = Fluid.NONE;
                        if (entity_a instanceof Mob) {
                           Mob _mobEnt = (Mob)entity_a;
                           var10007 = _mobEnt.getTarget();
                        } else {
                           var10007 = null;
                        }

                        var10001 = new ClipContext(var114, var121, var127, var10006, var10007);
                        z_pos = (double)var107.clip(var10001).getBlockPos().getZ();
                     } else {
                        dis = 8.0;
                        logic_a = false;

                        for(int index0 = 0; index0 < 8; ++index0) {
                           x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                           y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                           z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> true)) {
                              if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                                 logic_a = true;
                                 x_pos = entityiterator.getX();
                                 y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                                 z_pos = entityiterator.getZ();
                                 break;
                              }
                           }

                           dis += 8.0;
                           if (logic_a) {
                              break;
                           }
                        }
                     }
                  }
               }

               x_power = entity.getX() - x_pos;
               y_power = entity.getY() - y_pos;
               z_power = entity.getZ() - z_pos;
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis > 10.0 && (entity.getPersistentData().getDouble("cnt1") % 3.0 == 1.0 || dis > 32.0)) {
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  yaw = (double)(entity.getYRot() % 360.0F);
                  pitch = (double)entity.getXRot();
                  if (entity.getPersistentData().getDouble("cnt1") % 9.0 != 1.0 && dis <= 32.0) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.setYRot((float)((yaw + (Math.random() - 0.5) * 90.0) % 360.0));
                        entity.setXRot((float)(pitch + (Math.random() - 0.5) * 45.0));
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0)), Block.COLLIDER, Fluid.NONE, entity)).getType() != Type.BLOCK) {
                           break;
                        }
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 4, 0.25, 0.25, 0.25, 0.2);
                  }
               }

               speed = 6.0;
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

               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();

               for(int index2 = 0; index2 < (int)Math.round(dis); ++index2) {
                  entity.getPersistentData().putDouble("Damage", 15.0);
                  entity.getPersistentData().putDouble("Range", 3.0 * size);
                  entity.getPersistentData().putDouble("knockback", 0.5);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  entity.teleportTo(entity.getX() + x_power, entity.getY(), entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (entity.isInWall()) {
                     entity.teleportTo(entity.getX() - x_power, entity.getY(), entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() - x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY() + y_power, entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + y_power, entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (entity.isInWall()) {
                     entity.teleportTo(entity.getX(), entity.getY() - y_power, entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY() - y_power, entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                  }

                  if (entity.isInWall()) {
                     entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - z_power, entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               entity.getPersistentData().putDouble("BlockRange", 1.0 * size);
               entity.getPersistentData().putDouble("BlockDamage", 4.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.15));
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 50.0 && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
