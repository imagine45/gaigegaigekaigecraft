package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class AIEnergyBallWhiteProcedure {
   public AIEnergyBallWhiteProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double z_power = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double speed = 0.0;
         double CNT6 = 0.0;
         double speed2 = 0.0;
         double range_fix = 0.0;
         double range = 0.0;
         double d = 0.0;
         boolean logic_attack = false;
         boolean granite = false;
         boolean energy_wave = false;
         boolean logic_b = false;
         boolean logic_a = false;
         boolean skull = false;
         boolean flame = false;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         energy_wave = entity.getPersistentData().getDouble("skill") >= 700.0 && entity.getPersistentData().getDouble("skill") < 800.0;
         granite = entity.getPersistentData().getDouble("skill") >= 1200.0 && entity.getPersistentData().getDouble("skill") < 1300.0;
         flame = entity.getPersistentData().getDouble("skill") >= 400.0 && entity.getPersistentData().getDouble("skill") < 500.0;
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            logic_attack = false;
            entity.getPersistentData().putBoolean("Stop", false);
            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && energy_wave && LogicOwnerExistProcedure.execute(world, entity)) {
               if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  logic_attack = true;
                  entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), entity_a.getPersistentData().getDouble("cnt6")));
                  entity.getPersistentData().putDouble("x_power", entity_a.getPersistentData().getDouble("x_power"));
                  entity.getPersistentData().putDouble("y_power", entity_a.getPersistentData().getDouble("y_power"));
                  entity.getPersistentData().putDouble("z_power", entity_a.getPersistentData().getDouble("z_power"));
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

                  entity.teleportTo(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity_a.getPersistentData().getDouble("x_pos"), entity_a.getPersistentData().getDouble("y_pos"), entity_a.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
                  }
               }

               if (entity_a.getPersistentData().getDouble("skill") <= 0.0) {
                  logic_attack = false;
               }
            }

            if (!logic_attack || !entity.isAlive()) {
               entity.getPersistentData().putDouble("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt3") != 0.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            entity.getPersistentData().putDouble("x_knockback", entity.getDeltaMovement().x() * 1.0);
            entity.getPersistentData().putDouble("z_knockback", entity.getDeltaMovement().z() * 1.0);
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
            range_fix = 1.0;
            RotateEntityProcedure.execute(entity.getX() + entity.getPersistentData().getDouble("x_power") * 50.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getPersistentData().getDouble("y_power") * 50.0, entity.getZ() + entity.getPersistentData().getDouble("z_power") * 50.0, entity);
            if (energy_wave) {
               ParticleGeneratorCircleProcedure.execute(world, 18.0 * range, (double)entity.getXRot(), 0.0 * range, 1.0 * range, 4.0, entity.getX(), entity.getX() - entity.getPersistentData().getDouble("x_power") * range, entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getY() + (double)entity.getBbHeight() * 0.5 - entity.getPersistentData().getDouble("y_power") * range, (double)entity.getYRot(), entity.getZ(), entity.getZ() - entity.getPersistentData().getDouble("z_power") * range, "gaigegaigekaigecraft:particle_thunder_blue");
            }

            if (entity.getPersistentData().getBoolean("Stop")) {
               entity.getPersistentData().putBoolean("Stop", false);
               speed = 0.0;
               speed2 = 0.0;
            } else {
               speed = energy_wave ? 3.0 : 1.25;
               speed2 = 0.25;
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (granite && entity_a instanceof LivingEntity) {
               entity.getPersistentData().putBoolean("free", true);
               GetPowerForwardProcedure.execute((double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY(), (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(48.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ(), entity);
               x_power = entity.getDeltaMovement().x() + Math.min(speed2, Math.abs(entity.getDeltaMovement().x() - entity.getPersistentData().getDouble("x_power") * speed)) * (double)(entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * speed ? -1 : 1);
               y_power = entity.getDeltaMovement().y() + Math.min(speed2, Math.abs(entity.getDeltaMovement().y() - entity.getPersistentData().getDouble("y_power") * speed)) * (double)(entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * speed ? -1 : 1);
               z_power = entity.getDeltaMovement().z() + Math.min(speed2, Math.abs(entity.getDeltaMovement().z() - entity.getPersistentData().getDouble("z_power") * speed)) * (double)(entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * speed ? -1 : 1);
            } else {
               x_power = entity.getPersistentData().getDouble("x_power") * speed;
               y_power = entity.getPersistentData().getDouble("y_power") * speed;
               z_power = entity.getPersistentData().getDouble("z_power") * speed;
            }

            entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > 1.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            } else {
               dis = 1.0;
            }

            for(int index0 = 0; index0 < (int)dis; ++index0) {
               range = ReturnEntitySizeProcedure.execute(entity);
               x_pos = entity.getX();
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
               z_pos = entity.getZ();
               if (granite) {
                  entity.getPersistentData().putDouble("Damage", 20.0);
               } else if (energy_wave) {
                  entity.getPersistentData().putDouble("Damage", 24.0);
               } else if (flame) {
                  entity.getPersistentData().putDouble("Damage", 17.0);
                  entity.getPersistentData().putDouble("effect", 10.0);
               } else {
                  entity.getPersistentData().putDouble("Damage", 10.0);
               }

               if (entity.getPersistentData().getDouble("cnt_life") > 0.0) {
                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * Math.pow(0.99, Math.min(entity.getPersistentData().getDouble("cnt_life"), 25.0)));
               }

               entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * CNT6);
               entity.getPersistentData().putDouble("Range", 3.0 * range_fix);
               entity.getPersistentData().putDouble("knockback", 0.5);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                  if (entity != entityiterator && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                     logic_b = true;
                     break;
                  }
               }

               d = Math.sqrt(1.0 + entity.getPersistentData().getDouble("Damage"));
               if (logic_b || entity.isInWall() || !entity.isAlive()) {
                  entity.getPersistentData().putBoolean("Stop", true);
                  range = d * 0.25 + 3.0 * range_fix;
                  entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", range * 2.0);
                  entity.getPersistentData().putDouble("knockback", 1.0);
                  if (flame) {
                     entity.getPersistentData().putDouble("effect", 10.0);
                  } else {
                     entity.getPersistentData().putDouble("effect", 0.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockDamage", d * 1.0);
                  entity.getPersistentData().putDouble("BlockRange", range);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  if (flame) {
                     entity.getPersistentData().putDouble("effect", 3.0);
                  }

                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F, false);
                     }
                  }

                  if (granite) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_blue ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                     }
                  } else if (energy_wave) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F);
                        } else {
                           _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:thunder_impact")), SoundSource.NEUTRAL, (float)(range * 0.5), 1.0F, false);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_thunder_blue ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                     }
                  } else if (flame && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle flame ~ ~ ~ " + range * 0.25 + " " + range * 0.25 + " " + range * 0.25 + " 1 " + Math.round(5.0 * range) + " force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle explosion ~ ~ ~ " + range * 0.75 + " " + range * 0.75 + " " + range * 0.75 + " 1 " + Math.round(10.0 * range) + " force");
                  }

                  entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") - 1.0);
                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
                  break;
               }

               entity.teleportTo(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(entity.getX() + x_power * 1.0, entity.getY() + y_power * 1.0, entity.getZ() + z_power * 1.0, entity.getYRot(), entity.getXRot());
               }
            }

            if ((entity.getPersistentData().getDouble("cnt1") > (double)(granite ? 35 : 15) || entity.getPersistentData().getDouble("cnt2") > 5.0 * CNT6) && !entity.level().isClientSide()) {
               entity.discard();
            }
         }

         entity.getPersistentData().putDouble("cnt_life", entity.getPersistentData().getDouble("cnt_life") + 1.0);
         if (entity.getPersistentData().getDouble("cnt_life") > 1.0) {
            x_pos = entity.getPersistentData().getDouble("old_x");
            y_pos = entity.getPersistentData().getDouble("old_y");
            z_pos = entity.getPersistentData().getDouble("old_z");
            x_power = entity.getX() - x_pos;
            y_power = entity.getY() - y_pos;
            z_power = entity.getZ() - z_pos;
            dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
            if (dis > 1.0) {
               x_power /= dis;
               y_power /= dis;
               z_power /= dis;
            }

            range = ReturnEntitySizeProcedure.execute(entity);

            for(int index1 = 0; index1 < (int)Math.max(dis * 4.0, 1.0); ++index1) {
               if (flame) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:flame ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle minecraft:end_rod ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
                  }
               } else if (granite && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.getServer().getCommands().performPrefixedCommand((new CommandSourceStack(CommandSource.NULL, new Vec3(x_pos, y_pos, z_pos), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), (Entity)null)).withSuppressedOutput(), "particle gaigegaigekaigecraft:particle_blue ~ ~ ~ 0.25 0.25 0.25 0.01 2 force");
               }

               if (energy_wave) {
                  ParticleGeneratorProcedure.execute(world, range * 1.0, 2.0 * range, 22.5, 4.0, x_pos, x_pos - x_power, y_pos, y_pos - y_power, z_pos, z_pos - z_power, "minecraft:cloud");
               }

               x_pos += x_power * 0.25;
               y_pos += y_power * 0.25;
               z_pos += z_power * 0.25;
            }
         }

         entity.getPersistentData().putDouble("old_x", entity.getX());
         entity.getPersistentData().putDouble("old_y", entity.getY());
         entity.getPersistentData().putDouble("old_z", entity.getZ());
      }
   }
}
