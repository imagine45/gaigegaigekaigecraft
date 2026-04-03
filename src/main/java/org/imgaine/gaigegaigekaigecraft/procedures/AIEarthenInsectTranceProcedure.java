package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEarthenInsectTranceProcedure {
   public AIEarthenInsectTranceProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean logic_b = false;
         boolean reverse = false;
         boolean FoxFire = false;
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double speed = 0.0;
         double start_time = 0.0;
         double x_target = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         if (entity.isAlive()) {
            if (entity.getPersistentData().getDouble("move") == 0.0) {
               entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
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
                        }
                     }

                     logic_a = true;
                     yaw = (double)entity_a.getYRot();
                     pitch = (double)entity_a.getXRot();
                     x_power = entity.getX();
                     y_power = entity.getY();
                     z_power = entity.getZ();
                     x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + 90.0 + entity.getPersistentData().getDouble("position_yaw"))) * (2.75 + (double)entity_a.getBbWidth());
                     y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + entity.getPersistentData().getDouble("position_pitch");
                     z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + entity.getPersistentData().getDouble("position_yaw"))) * (2.75 + (double)entity_a.getBbWidth());
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

               if ((!logic_a || entity.getPersistentData().getDouble("cnt_life") >= 600.0) && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else {
               entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
               start_time = 1.0;
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     x_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX();
                     y_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY();
                     z_pos = (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(64.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ();
                     dis = 8.0;
                     logic_a = false;

                     for(int index0 = 0; index0 < 8; ++index0) {
                        Vec3 _center = new Vec3((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(dis)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(8.0), (e) -> true)) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
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

                     if (entity.getPersistentData().getDouble("cnt1") <= start_time) {
                        RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     }
                  }
               }

               CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
               if (entity.getPersistentData().getDouble("cnt1") >= start_time) {
                  entity.getPersistentData().putBoolean("canFly", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                  if (entity.getPersistentData().getDouble("cnt1") == start_time) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                        }
                     }

                     x_power = entity.getPersistentData().getDouble("x_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
                     y_power = entity.getPersistentData().getDouble("y_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
                     z_power = entity.getPersistentData().getDouble("z_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
                  } else {
                     speed = 0.125;
                     if (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * (1.0 + entity.getPersistentData().getDouble("speed"))) {
                        x_power = entity.getDeltaMovement().x() - speed;
                     } else {
                        x_power = entity.getDeltaMovement().x() + speed;
                     }

                     if (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * (1.0 + entity.getPersistentData().getDouble("speed"))) {
                        y_power = entity.getDeltaMovement().y() - speed;
                     } else {
                        y_power = entity.getDeltaMovement().y() + speed;
                     }

                     if (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * (1.0 + entity.getPersistentData().getDouble("speed"))) {
                        z_power = entity.getDeltaMovement().z() - speed;
                     } else {
                        z_power = entity.getDeltaMovement().z() + speed;
                     }
                  }

                  speed = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_power, 2.0));
                  if (speed < 1.5 * (1.0 + entity.getPersistentData().getDouble("speed"))) {
                     speed = 1.5 * (1.0 + entity.getPersistentData().getDouble("speed")) / Math.max(speed, 0.01);
                     x_power *= speed;
                     y_power *= speed;
                     z_power *= speed;
                  }

                  if (!entity.getPersistentData().getBoolean("Stop")) {
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                     BulletDomainHit2Procedure.execute(world, entity);
                     RotateEntityProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getDeltaMovement().x() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getDeltaMovement().y() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getDeltaMovement().z() * 10.0, entity);
                  } else {
                     entity.getPersistentData().putBoolean("Stop", false);
                  }

                  entity.getPersistentData().putDouble("Damage", 9.0 * Math.max(CNT6, 0.75));
                  entity.getPersistentData().putDouble("Range", 2.5);
                  entity.getPersistentData().putDouble("knockback", 0.25 * Math.max(CNT6, 0.75));
                  entity.getPersistentData().putBoolean("attack", true);
                  RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
                  entity.getPersistentData().putDouble("move", 0.0);
               }
            }
         }

         if (!entity.isAlive() && !entity.getPersistentData().getBoolean("flag_die")) {
            entity.getPersistentData().putBoolean("flag_die", true);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.0F);
               } else {
                  _level.playLocalSound(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:crush")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
               }
            }

            entity.getPersistentData().putDouble("Damage", 12.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().putDouble("Range", 12.0);
            entity.getPersistentData().putDouble("knockback", 0.25 * Math.max(CNT6, 0.75));
            entity.getPersistentData().putDouble("effect", 15.0);
            entity.getPersistentData().putDouble("COOLDOWN_TICKS", 50.0);
            entity.getPersistentData().putBoolean("attack", false);
            RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 8, 0.125, 0.125, 0.125, 0.25);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.SNEEZE, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), 32, 0.125, 0.125, 0.125, 0.5);
            }
         }

      }
   }
}
