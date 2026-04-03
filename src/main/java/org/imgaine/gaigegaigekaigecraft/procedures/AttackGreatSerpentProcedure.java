package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AttackGreatSerpentProcedure {
   public AttackGreatSerpentProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double entity_size = 0.0;
         double picth = 0.0;
         double yaw = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            entity.teleportTo(x, y - 0.5 * entity_size, z);
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(x, y - 0.5 * entity_size, z, entity.getYRot(), entity.getXRot());
            }

            y_pos = y + (double)entity.getBbHeight();

            for(int index0 = 0; index0 < 32; ++index0) {
               if (!world.getBlockState(BlockPos.containing(x, y_pos + 1.0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude()) {
                  world.levelEvent(2001, BlockPos.containing(x, y_pos + 0.5, z), Block.getId(world.getBlockState(BlockPos.containing(x, y_pos, z))));
                  break;
               }

               --y_pos;
            }

            if (world.getBlockState(BlockPos.containing(x, y + (double)entity.getBbHeight() + 2.0, z)).canOcclude() || y < 0.0) {
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
                  x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                  y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                  z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(16.0 * entity_size)), net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               }

               for(int index1 = 0; index1 < 128; ++index1) {
                  if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                     y_pos -= 12.0 * entity_size;
                     break;
                  }

                  y_pos -= 1.0 * entity_size;
               }

               entity.teleportTo(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
               }

               entity.getPersistentData().putDouble("cnt2", 1.0);
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") < 3.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               y_pos = y;

               for(int index2 = 0; index2 < 32; ++index2) {
                  if (!world.getBlockState(BlockPos.containing(x, y_pos + 1.0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude()) {
                     world.levelEvent(2001, BlockPos.containing(x, y_pos + 0.5, z), Block.getId(world.getBlockState(BlockPos.containing(x, y_pos, z))));
                     break;
                  }

                  ++y_pos;
               }
            } else if (entity.getPersistentData().getDouble("cnt1") < 45.0) {
               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().getDouble("cnt1") < 14.0) {
                  if (entity.getPersistentData().getDouble("cnt1") < 12.0) {
                     if (world.getBlockState(BlockPos.containing(x, y + (double)entity.getBbHeight() + 0.25, z)).canOcclude()) {
                        entity.teleportTo(x, y + 1.5 * entity_size, z);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x, y + 1.5 * entity_size, z, entity.getYRot(), entity.getXRot());
                        }
                     } else {
                        entity.setDeltaMovement(new Vec3(0.0, 1.5, 0.0));
                     }
                  }

                  y_pos = y;

                  for(int index3 = 0; index3 < 32; ++index3) {
                     if (!world.getBlockState(BlockPos.containing(x, y_pos + 1.0, z)).canOcclude() && world.getBlockState(BlockPos.containing(x, y_pos, z)).canOcclude()) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x, y_pos, z, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.CLOUD, x, y_pos, z, (int)(10.0 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.EXPLOSION, x, y_pos, z, (int)(10.0 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.5);
                        }

                        world.levelEvent(2001, BlockPos.containing(x, y_pos + 0.5, z), Block.getId(world.getBlockState(BlockPos.containing(x, y_pos, z))));
                        break;
                     }

                     --y_pos;
                  }
               }

               Vec3 _center = new Vec3(x, y + (double)entity.getBbHeight(), z);

               for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(3.0 * entity_size / 2.0), (e) -> true)) {
                  if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator instanceof Player && !entityiterator.isPassenger()) {
                     entityiterator.startRiding(entity);
                     entity.getPersistentData().putDouble("cnt3", 1.0);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.getPersistentData().putDouble("knockback", 1.0);
               } else {
                  entity.getPersistentData().putDouble("cnt3", 0.0);
               }

               entity.getPersistentData().putDouble("Damage", 10.0);
               entity.getPersistentData().putDouble("Range", 3.0 * entity_size);
               entity.getPersistentData().putDouble("effect", 1.0);
               entity.getPersistentData().putBoolean("swing", true);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight(), z, entity);
            } else {
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
               if (entity.getPersistentData().getDouble("cnt3") > 10.0) {
                  Vec3 _center = new Vec3(x, y + (double)entity.getBbHeight(), z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(3.0 * entity_size / 2.0), (e) -> true)) {
                     if (entityiterator.getVehicle() == entity) {
                        logic_a = true;
                        entityiterator.setShiftKeyDown(true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt3") > 20.0 && !logic_a) {
                     entity.getPersistentData().putDouble("skill", 0.0);
                  }
               }
            }
         }

         entity.getPersistentData().putDouble("Damage", 0.0);
      }
   }
}
