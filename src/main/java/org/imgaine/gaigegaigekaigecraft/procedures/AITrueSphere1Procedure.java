package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AITrueSphere1Procedure {
   public AITrueSphere1Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double move_power = 0.0;
         double dis = 0.0;
         double tick = 0.0;
         double z_fix = 0.0;
         double num1 = 0.0;
         double x_fix = 0.0;
         double y_fix = 0.0;
         double old_distance = 0.0;
         double distance = 0.0;
         double num2 = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         dis = (double)(entity.getBbWidth() * 1.0F);
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.getPersistentData().putDouble("cnt2", 1.0);
            entity.getPersistentData().putDouble("x_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX());
            entity.getPersistentData().putDouble("y_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY());
            entity.getPersistentData().putDouble("z_pos", (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ());
            entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_pos") + entity.getLookAngle().x);
            entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_pos") + entity.getLookAngle().y);
            entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_pos") + entity.getLookAngle().z);
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

                     x_pos = ((Entity)var10000).getX();
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     double var102 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var102 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var103;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var103 = _mobEnt.getTarget();
                     } else {
                        var103 = null;
                     }

                     z_pos = ((Entity)var103).getZ();
                  } else {
                     x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                     y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                     z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                  }

                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("x_pos", x_pos);
                  entity.getPersistentData().putDouble("y_pos", y_pos);
                  entity.getPersistentData().putDouble("z_pos", z_pos);
                  entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_pos") + entity.getLookAngle().x);
                  entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_pos") + entity.getLookAngle().y);
                  entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_pos") + entity.getLookAngle().z);
               }
            }

            logic_a = false;
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            x_power = entity.getLookAngle().x * 4.0;
            y_power = entity.getLookAngle().y * 4.0;
            z_power = entity.getLookAngle().z * 4.0;

            for(int index0 = 0; index0 < 10; ++index0) {
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(5.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_a = true;
                     entity.getPersistentData().putDouble("x_pos", entityiterator.getX());
                     entity.getPersistentData().putDouble("y_pos", entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     entity.getPersistentData().putDouble("z_pos", entityiterator.getZ());
                     entity.getPersistentData().putDouble("x_power", entityiterator.getX());
                     entity.getPersistentData().putDouble("y_power", entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                     entity.getPersistentData().putDouble("z_power", entityiterator.getZ());
                     break;
                  }
               }

               if (logic_a) {
                  break;
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            x_power = entity.getLookAngle().x * 1.0;
            y_power = entity.getLookAngle().y * 1.0;
            z_power = entity.getLookAngle().z * 1.0;
            old_distance = 9999.0;

            for(int index1 = 0; index1 < 2; ++index1) {
               distance = Math.sqrt(Math.pow(entity.getX() - x_pos, 2.0) + Math.pow(entity.getY() - y_pos, 2.0) + Math.pow(entity.getZ() - z_pos, 2.0));
               if (distance > old_distance || distance < dis) {
                  entity.getPersistentData().putDouble("cnt2", 2.0);
                  entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
                  BulletDomainHit2Procedure.execute(world, entity);
                  break;
               }

               logic_a = entity.isInWall();
               entity.teleportTo(entity.getX() + x_power, entity.getY(), entity.getZ());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
               }

               if (entity.isInWall() && !logic_a) {
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

               if (entity.isInWall() && !logic_a) {
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

               if (entity.isInWall() && !logic_a) {
                  entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - z_power, entity.getYRot(), entity.getXRot());
                  }
               }

               old_distance = distance;
            }

            entity.getPersistentData().putDouble("x_power", x_power);
            entity.getPersistentData().putDouble("y_power", y_power);
            entity.getPersistentData().putDouble("z_power", z_power);
         }

         if (entity.getPersistentData().getDouble("cnt2") > 1.0) {
            x_power = entity.getPersistentData().getDouble("x_power") * 1.0;
            y_power = entity.getPersistentData().getDouble("y_power") * 1.0;
            z_power = entity.getPersistentData().getDouble("z_power") * 1.0;

            for(int index2 = 0; index2 < 2; ++index2) {
               logic_a = entity.isInWall();
               entity.teleportTo(entity.getX() + x_power, entity.getY(), entity.getZ());
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
               }

               if (entity.isInWall() && !logic_a) {
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

               if (entity.isInWall() && !logic_a) {
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

               if (entity.isInWall() && !logic_a) {
                  entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - z_power);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - z_power, entity.getYRot(), entity.getXRot());
                  }
               }
            }

            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") > 10.0) {
               entity.getPersistentData().putDouble("move", 0.0);
            }

            entity.getPersistentData().putDouble("cnt_bullet_hit", 15.0);
            BulletDomainHit2Procedure.execute(world, entity);
         }

      }
   }
}
