package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraftforge.registries.ForgeRegistries;

public class AIWaterProcedure {
   public AIWaterProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         boolean logic_a = false;
         Entity entity_a = null;
         double range = 0.0;
         double rnd = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double size = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         if (entity.getPersistentData().getDouble("skill") == 1016.0) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.getEntityData().set(EntityWaterEntity.DATA_type, 1);
            }
         } else if (entity.getPersistentData().getDouble("skill") == 409.0) {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
               _datEntSetI.getEntityData().set(EntityWaterEntity.DATA_type, 2);
            }
         } else if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntSetI = (EntityWaterEntity)entity;
            _datEntSetI.getEntityData().set(EntityWaterEntity.DATA_type, 0);
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY() + (double)(entity.getBbHeight() * 0.0F);
         z_pos = entity.getZ();
         x_power = entity.getDeltaMovement().x();
         y_power = entity.getDeltaMovement().y();
         z_power = entity.getDeltaMovement().z();
         speed = Math.max(Math.min(Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power), 2.0), -2.0);
         int var10000;
         if (entity instanceof EntityWaterEntity) {
            EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
            var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
         } else {
            var10000 = 0;
         }

         if (var10000 == 2) {
            ParticleGeneratorProcedure.execute(world, range * 2.0, 1.0 * range, 25.0, 2.0 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_magma");
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 1) {
               ParticleGeneratorProcedure.execute(world, range * 2.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_blood_2");
               if (entity.isInWaterRainOrBubble() && !entity.level().isClientSide()) {
                  entity.discard();
               }
            } else {
               ParticleGeneratorProcedure.execute(world, range * 2.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_water_2");
               ParticleGeneratorProcedure.execute(world, range * 2.0, 2.0 * range, 25.0, 0.5 * speed, x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_water");
            }
         }

         if (entity.isAlive()) {
            size = ReturnEntitySizeProcedure.execute(entity);
            entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
            entity.getPersistentData().putDouble("cnt_x2", entity.getPersistentData().getDouble("cnt_x2") + 1.0);
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               entity.getPersistentData().putDouble("Damage", 9.0);
               entity.getPersistentData().putDouble("Range", 5.0 + size);
               entity.getPersistentData().putDouble("effect", 10.0);
               entity.getPersistentData().putDouble("knockback", 0.5);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)(entity.getBbHeight() / 2.0F), entity.getZ(), entity);
            } else {
               entity.getPersistentData().putDouble("Damage", 7.0);
               entity.getPersistentData().putDouble("Range", 5.0 + size);
               CompoundTag var77 = entity.getPersistentData();
               int var10002;
               if (entity instanceof EntityWaterEntity) {
                  EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                  var10002 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
               } else {
                  var10002 = 0;
               }

               var77.putDouble("effect", (double)(var10002 == 1 ? 11 : 0));
               entity.getPersistentData().putDouble("knockback", 0.5);
               RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)(entity.getBbHeight() / 2.0F), entity.getZ(), entity);
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity.onGround()) {
               x_power = entity.getX() + entity.getDeltaMovement().x() * 16.0;
               y_power = entity.getY() + (double)(entity.getBbHeight() / 2.0F) + entity.getDeltaMovement().y() * 16.0;
               z_power = entity.getZ() + entity.getDeltaMovement().z() * 16.0;
               RotateEntityProcedure.execute(x_power, y_power, z_power, entity);
               logic_b = false;
               if (entity.getPersistentData().getDouble("cnt_x2") > 10.0) {
                  entity.getPersistentData().putDouble("cnt_x2", Math.random() * 5.0);
                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 == 2) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     if (Math.random() < 0.1) {
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                           } else {
                              _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.lava.pop")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                           }
                        }

                        entity.getPersistentData().putDouble("BlockRange", 3.0);
                        entity.getPersistentData().putDouble("BlockDamage", 2.0);
                        entity.getPersistentData().putBoolean("noParticle", true);
                        if (entity instanceof EntityWaterEntity) {
                           EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                           var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                        } else {
                           var10000 = 0;
                        }

                        if (var10000 == 2) {
                           entity.getPersistentData().putDouble("effect", 3.0);
                        }

                        BlockDestroyAllDirectionProcedure.execute(world, x, y, z, entity);
                     }
                  } else if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.water.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  if (entity instanceof EntityWaterEntity) {
                     EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
                     var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
                  } else {
                     var10000 = 0;
                  }

                  if (var10000 != 0 && entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                        logic_b = true;
                        entity.getPersistentData().putDouble("x_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getX());
                        entity.getPersistentData().putDouble("y_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getY());
                        entity.getPersistentData().putDouble("z_pos", (double)entity_a.level().clip(new ClipContext(entity_a.getEyePosition(1.0F), entity_a.getEyePosition(1.0F).add(entity_a.getViewVector(1.0F).scale(32.0)), Block.OUTLINE, Fluid.NONE, entity_a)).getBlockPos().getZ());
                        GetPowerForwardProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                        RotateEntityProcedure.execute(entity.getPersistentData().getDouble("x_pos"), entity.getPersistentData().getDouble("y_pos"), entity.getPersistentData().getDouble("z_pos"), entity);
                        entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.5, entity.getPersistentData().getDouble("y_power") * 0.75 + 0.25, entity.getPersistentData().getDouble("z_power") * 0.5));
                     }
                  }
               }

               if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                  yaw = (double)entity.getYRot();
                  pitch = 0.0;
                  rnd = 10.0;
                  logic_a = false;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     for(int index1 = 0; index1 < 32; ++index1) {
                        entity.setYRot((float)(yaw + (Math.random() - 0.5) * rnd));
                        entity.setXRot((float)(pitch + (Math.random() - 0.5) * rnd));
                        entity.setYBodyRot(entity.getYRot());
                        entity.setYHeadRot(entity.getYRot());
                        entity.yRotO = entity.getYRot();
                        entity.xRotO = entity.getXRot();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(2.0)), Block.OUTLINE, Fluid.NONE, entity)).getType() != Type.BLOCK) {
                           logic_a = true;
                           break;
                        }
                     }

                     if (logic_a) {
                        break;
                     }

                     rnd += 10.0;
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
               }

               if (logic_a || !logic_b) {
                  entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 0.75, entity.getPersistentData().getDouble("y_power") * 0.75, entity.getPersistentData().getDouble("z_power") * 0.75));
               }
            }

            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 != 0) {
               BulletDomainHit2Procedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt_x") > 80.0) {
               entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 9999.0F);
            }
         } else {
            if (entity instanceof EntityWaterEntity) {
               EntityWaterEntity _datEntI = (EntityWaterEntity)entity;
               var10000 = (Integer)_datEntI.getEntityData().get(EntityWaterEntity.DATA_type);
            } else {
               var10000 = 0;
            }

            if (var10000 == 2) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y, z, 5, 0.2, 0.2, 0.2, 0.05);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.splash.high_speed")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
