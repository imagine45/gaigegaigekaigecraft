package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class AIWoodenSpear2Procedure {
   public AIWoodenSpear2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
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
         double CNT6 = 0.0;
         double distance = 0.0;
         attack = false;
         x_power = entity.getPersistentData().getDouble("x_power");
         y_power = entity.getPersistentData().getDouble("y_power");
         z_power = entity.getPersistentData().getDouble("z_power");
         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
            yaw = (double)(entity.getYRot() % 360.0F);
            pitch = (double)entity.getXRot();
            if (LogicOwnerExistProcedure.execute(world, entity)) {
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

                     double var81 = ((Entity)var10000).getY();
                     LivingEntity var10001;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var81 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var82;
                     if (entity_a instanceof Mob) {
                        Mob _mobEnt = (Mob)entity_a;
                        var82 = _mobEnt.getTarget();
                     } else {
                        var82 = null;
                     }

                     z_pos = ((Entity)var82).getZ();
                  } else {
                     x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                     y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                     z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                  }
               }
            }

            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
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

            move_power = entity.getPersistentData().getDouble("cnt3") < 20.0 ? 8.0 : 16.0;
            yaw_cal = (double)entity.getYRot() - yaw;
            if ((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0))) {
               yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / move_power;
            } else {
               yaw -= Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / move_power;
            }

            pitch_cal = Math.abs(pitch - (double)entity.getXRot());
            if (pitch > (double)entity.getXRot()) {
               pitch -= pitch_cal / move_power;
            } else {
               pitch += pitch_cal / move_power;
            }

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

         yaw = (double)entity.getYRot();
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

         entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.0);
         entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
         entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.0);
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

         if (entity.getPersistentData().getDouble("cnt3") < 20.0) {
            attack = false;
         } else {
            if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
               entity.getPersistentData().putDouble("cnt4", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            attack = true;

            for(int index0 = 0; index0 < 2; ++index0) {
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("Damage", 15.0);
               entity.getPersistentData().putDouble("knockback", 1.0);
               entity.getPersistentData().putDouble("Range", 3.0);
               entity.getPersistentData().putDouble("effect", 1.0);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               if (entity.getPersistentData().getBoolean("Stop")) {
                  entity.getPersistentData().putBoolean("Stop", false);
                  attack = false;
                  break;
               }

               if (entity.isInWall()) {
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 2.0);
                  attack = false;
                  break;
               }

               entity.teleportTo(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
               }

               if (entity.isInWall()) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 8, 0.5, 0.5, 0.5, 0.5);
                  }

                  world.levelEvent(2001, BlockPos.containing(x_pos, y_pos, z_pos), net.minecraft.world.level.block.Block.getId(world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos))));
                  entity.getPersistentData().putDouble("BlockRange", (double)(1.0F * entity.getBbWidth()));
                  entity.getPersistentData().putDouble("BlockDamage", (double)(entity.getBbWidth() * 1.0F) * CNT6);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }
            }

            BulletDomainHit2Procedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt3") > 60.0 && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

         if (attack) {
            entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
            entity.getPersistentData().putDouble("knockback", 0.5);
         } else {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.getPersistentData().putDouble("knockback", 0.1);
            entity.getPersistentData().putDouble("target_type", 1.0);
         }

         entity.getPersistentData().putDouble("Damage", 15.0);
         entity.getPersistentData().putDouble("Range", 3.0);
         entity.getPersistentData().putDouble("effect", 1.0);
         RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
         entity.getPersistentData().putDouble("target_type", 0.0);
         entity.getPersistentData().putDouble("Damage", 0.0);
      }
   }
}
