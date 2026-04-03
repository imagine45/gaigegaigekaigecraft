package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

public class AIWoodenBallProcedure {
   public AIWoodenBallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean attack = false;
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
         double tick = 0.0;
         Entity entity_a = null;
         if (entity.isAlive()) {
            if (entity.getPersistentData().getDouble("move") == 0.0) {
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     if (entity.getPersistentData().getDouble("position_pitch") == 0.0) {
                        entity.getPersistentData().putDouble("cnt_x", Math.max(entity.getPersistentData().getDouble("cnt_x"), 2.0));
                     }

                     if (entity.getPersistentData().getDouble("cnt_x") == 0.0) {
                        if (entity_a.getPersistentData().getDouble("skill") != 0.0 && entity_a.getPersistentData().getBoolean("attack")) {
                           entity.getPersistentData().putDouble("cnt_x", 1.0);
                        }
                     } else if (entity.getPersistentData().getDouble("cnt_x") == 1.0) {
                        if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                           entity.getPersistentData().putDouble("cnt_x", 2.0);
                        }
                     } else {
                        entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                        if (entity.getPersistentData().getDouble("cnt_x") > 10.0) {
                           ResetCounterProcedure.execute(entity);
                           entity.getPersistentData().putDouble("cnt_x", 0.0);
                           entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
                           entity.getPersistentData().putDouble("move", entity.getPersistentData().getDouble("cnt_x2"));
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:1b}");
                           }
                        }
                     }

                     logic_a = true;
                     yaw = (double)entity_a.getYRot();
                     pitch = (double)entity_a.getXRot();
                     x_power = entity.getX();
                     y_power = entity.getY();
                     z_power = entity.getZ();
                     x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + 90.0 + entity.getPersistentData().getDouble("position_yaw"))) * 5.0;
                     y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + entity.getPersistentData().getDouble("position_pitch");
                     z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + entity.getPersistentData().getDouble("position_yaw"))) * 5.0;
                     if (Math.abs(x_target - x_power) > 0.5) {
                        x_target = x_power + (x_power > x_target ? -0.5 : 0.5);
                     }

                     if (Math.abs(y_target - y_power) > 0.5) {
                        y_target = y_power + (y_power > y_target ? -0.5 : 0.5);
                     }

                     if (Math.abs(z_target - z_power) > 0.5) {
                        z_target = z_power + (z_power > z_target ? -0.5 : 0.5);
                     }

                     entity.teleportTo(x_target, y_target, z_target);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(x_target, y_target, z_target, entity.getYRot(), entity.getXRot());
                     }

                     entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
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
                  }
               }

               if (!logic_a && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (entity.getPersistentData().getDouble("move") < 5.0) {
               AIWoodenBall1Procedure.execute(world, entity);
            } else {
               AIWoodenBall1Procedure.execute(world, entity);
               if (entity.getPersistentData().getDouble("move") == 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }
         } else {
            world.levelEvent(2001, BlockPos.containing(x, y + (double)entity.getBbHeight() * 0.5, z), Block.getId(Blocks.OAK_LOG.defaultBlockState()));
            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
