package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CockroachesEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

public class AIRabbitProcedure {
   public AIRabbitProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         Entity entity_a = null;
         double rnd = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double speed = 0.0;
         double entity_size = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         speed = entity instanceof CockroachesEntity ? 0.5 : 0.75;
         if (entity.isAlive()) {
            if (LogicOwnerExistProcedure.execute(world, entity)) {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            } else {
               AIActiveProcedure.execute(world, x, y, z, entity);
            }

            if (entity instanceof CockroachesEntity) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_COCKROACH.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.1);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(1.0 * entity_size), 0.25 * entity_size, 0.25 * entity_size, 0.25 * entity_size, 0.0);
               }

               if (entity.getPersistentData().getDouble("skill") > -900.0) {
                  entity.getPersistentData().putDouble("skill", 2306.0);
                  entity.getPersistentData().putDouble("Damage", 9.0);
                  entity.getPersistentData().putDouble("Range", (double)(2.0F + entity.getBbWidth()));
                  entity.getPersistentData().putDouble("knockback", 0.1);
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                  entity.getPersistentData().putDouble("skill", 0.0);
                  entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
                  if (entity.getPersistentData().getDouble("cnt_life") > 120.0 && !entity.level().isClientSide()) {
                     entity.discard();
                  }
               }
            } else {
               FollowEntityProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("Range", entity_size);
               entity.getPersistentData().putDouble("knockback", 0.1);
               KnockbackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            }

            entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
            if (entity.getPersistentData().getDouble("skill") > -900.0) {
               if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.onGround()) {
                  entity.getPersistentData().putDouble("cnt_x", Math.random() * 5.0);
                  if (entity.getPersistentData().getDouble("friend_num") != 0.0) {
                     if (LogicOwnerExistProcedure.execute(world, entity) && entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                        logic_a = true;
                        if (!(entity instanceof RabbitEscapeEntity) && !(entity instanceof CockroachesEntity)) {
                           entity.getPersistentData().putDouble("x_pos", entity.getX() + entity.getLookAngle().x * 64.0);
                           entity.getPersistentData().putDouble("y_pos", entity.getY() + entity.getLookAngle().y * 64.0);
                           entity.getPersistentData().putDouble("z_pos", entity.getZ() + entity.getLookAngle().z * 64.0);
                        } else {
                           LivingEntity var10000;
                           if (entity_a instanceof Mob) {
                              Mob _mobEnt = (Mob)entity_a;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (var10000 instanceof LivingEntity && entity_a.getPersistentData().getDouble("cnt_target") > 6.0) {
                              CompoundTag var30 = entity.getPersistentData();
                              LivingEntity var10002;
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var30.putDouble("x_pos", ((Entity)var10002).getX());
                              var30 = entity.getPersistentData();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var30.putDouble("y_pos", ((Entity)var10002).getY());
                              var30 = entity.getPersistentData();
                              if (entity_a instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity_a;
                                 var10002 = _mobEnt.getTarget();
                              } else {
                                 var10002 = null;
                              }

                              var30.putDouble("z_pos", ((Entity)var10002).getZ());
                           } else {
                              entity.getPersistentData().putDouble("x_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX());
                              entity.getPersistentData().putDouble("y_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY());
                              entity.getPersistentData().putDouble("z_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                           }
                        }
                     }

                     if (logic_a) {
                        RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                        GetPowerForwardProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                        if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(4.0)), Block.COLLIDER, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                           entity.getPersistentData().putDouble("y_power", Math.max(entity.getPersistentData().getDouble("y_power"), 0.75 * (1.0 / speed)));
                        }

                        entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * speed, Math.max(entity.getPersistentData().getDouble("y_power") * speed, entity instanceof CockroachesEntity ? 0.1 : 0.25), entity.getPersistentData().getDouble("z_power") * speed));
                     }
                  }
               }

               if (entity instanceof RabbitEscapeEntity && !logic_a && entity.onGround() && entity.getDeltaMovement().x() * entity.getDeltaMovement().x() + entity.getDeltaMovement().z() * entity.getDeltaMovement().z() > 0.01) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), Math.max(entity.getDeltaMovement().y(), 0.33), entity.getDeltaMovement().z()));
               }
            }
         }

      }
   }
}
