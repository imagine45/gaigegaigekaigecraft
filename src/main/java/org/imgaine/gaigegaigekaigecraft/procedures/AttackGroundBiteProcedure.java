package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade15Entity;
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
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;

public class AttackGroundBiteProcedure {
   public AttackGroundBiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double entity_height = 0.0;
         double z_power = 0.0;
         entity.fallDistance = 0.0F;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity_height = (double)(entity.getBbHeight() * 5.0F + 1.0F);
         if (entity.getPersistentData().getDouble("cnt2") <= 2.0) {
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               if (entity.onGround()) {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  entity.getPersistentData().putDouble("cnt2", 1.0);
                  entity.getPersistentData().putDouble("y_pos", y);
               } else if (entity.getPersistentData().getDouble("cnt1") > 200.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            } else if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               entity.getPersistentData().putDouble("cnt2", 2.0);
            } else {
               entity.teleportTo(x, y - 0.5, z);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x, y - 0.5, z, entity.getYRot(), entity.getXRot());
               }

               y_pos = y - 1.0;

               for(int index0 = 0; index0 < (int)Math.round(entity_height) && !(y_pos > entity.getPersistentData().getDouble("y_pos")); ++index0) {
                  if (world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude() && !world.getBlockState(BlockPos.containing(x, y_pos + 1.0, z)).canOcclude()) {
                     world.levelEvent(2001, BlockPos.containing(x, y_pos + 0.5, z), Block.getId(world.getBlockState(BlockPos.containing(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }

               if (y < entity.getPersistentData().getDouble("y_pos") - entity_height) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
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
                  } else {
                     x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                     y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                     z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
                  }

                  for(int index1 = 0; index1 < 255; ++index1) {
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        entity.getPersistentData().putDouble("y_pos", y_pos);
                        y_pos -= entity_height;
                        break;
                     }

                     --y_pos;
                  }

                  entity.teleportTo(x_pos, y_pos, z_pos);
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                  }

                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  entity.getPersistentData().putDouble("cnt2", 3.0);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt2") == 3.0) {
            if (entity instanceof CursedSpiritGrade15Entity) {
               PlayAnimationEntity2Procedure.execute(entity, "right_arm_up");
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.teleportTo(x, y + 1.5, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(x, y + 1.5, z, entity.getYRot(), entity.getXRot());
            }

            y_pos = y;

            for(int index2 = 0; index2 < 6 && world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude(); ++index2) {
               if (!world.getBlockState(BlockPos.containing(x, y_pos + 1.0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude()) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x, y_pos, z, 5, 0.5, 0.5, 0.5, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.EXPLOSION, x, y_pos, z, 5, 0.5, 0.5, 0.5, 0.5);
                  }

                  world.levelEvent(2001, BlockPos.containing(x, y_pos + 0.5, z), Block.getId(world.getBlockState(BlockPos.containing(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            entity.getPersistentData().putDouble("Damage", 14.0);
            entity.getPersistentData().putDouble("knockback", 1.5);
            entity.getPersistentData().putDouble("Range", 3.0 * ReturnEntitySizeProcedure.execute(entity));
            entity.getPersistentData().putDouble("effect", 1.0);
            entity.getPersistentData().putBoolean("attack", true);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            if (y > entity.getPersistentData().getDouble("y_pos") + 2.0) {
               entity.getPersistentData().putDouble("cnt2", 4.0);
            }

            if (entity.getXRot() > -80.0F && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") > 10.0) {
               if (entity.getPersistentData().getDouble("cnt3") > 20.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }

               if (entity.getXRot() < -10.0F) {
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s ~ ~ ~ ~ ~10");
                  }
               } else if (entity.getXRot() > 10.0F && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s ~ ~ ~ ~ ~-10");
               }
            } else if (entity.getXRot() > -80.0F && !entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "tp @s ~ ~ ~ ~ ~-20");
            }
         }

         entity.getPersistentData().putDouble("Damage", 0.0);
      }
   }
}
