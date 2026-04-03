package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.FoxFireEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
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

public class AIEmberInsectsProcedure {
   public AIEmberInsectsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
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
         boolean logic_a = false;
         boolean logic_b = false;
         boolean reverse = false;
         boolean FoxFire = false;
         boolean SUCCESS = false;
         Entity entity_a = null;
         Entity entity_b = null;
         FoxFire = entity instanceof FoxFireEntity;
         start_time = FoxFire ? 15.0 : 10.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         x_pos = entity.getX() + entity.getLookAngle().x * 64.0;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * 64.0;
         z_pos = entity.getZ() + entity.getLookAngle().z * 64.0;
         if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (entity_a instanceof Mob) {
               Mob _mobEnt = (Mob)entity_a;
               _mobEnt.getTarget();
            } else {
               Object var10000 = null;
            }

            if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
               if (entity.getPersistentData().getDouble("cnt1") == start_time || entity.getPersistentData().getDouble("cnt1") > start_time && Math.random() < 0.2) {
                  dis = 6.0;

                  for(int index0 = 0; index0 < 8; ++index0) {
                     x_pos = entity_a.getX() + entity_a.getLookAngle().x * dis;
                     y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.9 + entity_a.getLookAngle().y * dis;
                     z_pos = entity_a.getZ() + entity_a.getLookAngle().z * dis;
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                        if (entity != entityiterator && LogicAttackProcedure.execute(world, entity_a, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                           SUCCESS = true;
                           x_pos = entityiterator.getX();
                           y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
                           z_pos = entityiterator.getZ();
                           break;
                        }
                     }

                     if (SUCCESS || entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(dis)), Block.VISUAL, Fluid.NONE, entity)).getType() == Type.BLOCK) {
                        break;
                     }

                     dis += 6.0;
                  }

                  entity.getPersistentData().putDouble("x_pos", x_pos);
                  entity.getPersistentData().putDouble("y_pos", y_pos);
                  entity.getPersistentData().putDouble("z_pos", z_pos);
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
               }

               if (entity.getPersistentData().getDouble("cnt1") <= start_time) {
                  if (FoxFire && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y + (double)entity.getBbHeight() * 0.5, z, 4, 0.1, 0.1, 0.1, 0.1);
                  }

                  entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                  if (entity.getPersistentData().getDouble("cnt1") < start_time) {
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
                  } else if (dis > 32.0 && entity.getPersistentData().getDouble("move") == 0.0) {
                     x_pos = entity_a.getX() + entity_a.getLookAngle().x * -8.0;
                     y_pos = entity_a.getY() + (double)entity_a.getBbHeight() * 0.9 + entity_a.getLookAngle().y * -8.0;
                     z_pos = entity_a.getZ() + entity_a.getLookAngle().z * -8.0;
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                     entity.setYRot(entity.getYRot() + 180.0F);
                     entity.setXRot(entity.getXRot() * -1.0F);
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     x_pos = entity.getX() + entity.getLookAngle().x * 64.0;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getLookAngle().y * 64.0;
                     z_pos = entity.getZ() + entity.getLookAngle().z * 64.0;
                  }
               }
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") >= start_time) {
            entity.getPersistentData().putBoolean("canFly", true);
            GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
            if (FoxFire) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x, y + (double)entity.getBbHeight() * 0.5, z, 1, 0.1, 0.1, 0.1, 0.1);
               }
            } else if (entity.getPersistentData().getDouble("move") != 0.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLAME, x, y + (double)entity.getBbHeight() * 0.5, z, 1, 0.1, 0.1, 0.1, 0.1);
            }

            if (entity.getPersistentData().getDouble("cnt1") == start_time) {
               if (entity.getPersistentData().getDouble("move") == 0.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.0F, false);
                     }
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 0.25F, 1.25F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.25F, false);
                     }
                  }
               }

               if (!FoxFire && entity.getPersistentData().getDouble("cnt6") >= 0.0 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x, y + (double)entity.getBbHeight() * 0.5, z, 5, 0.1, 0.1, 0.1, 0.5);
               }

               x_power = entity.getPersistentData().getDouble("x_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
               y_power = entity.getPersistentData().getDouble("y_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
               z_power = entity.getPersistentData().getDouble("z_power") * (1.0 + entity.getPersistentData().getDouble("speed"));
            } else {
               if (FoxFire) {
                  speed = 0.075;
               } else {
                  speed = entity.getPersistentData().getDouble("move") == 0.0 ? 0.125 : 0.05;
               }

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

            if (!entity.getPersistentData().getBoolean("Stop")) {
               entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               BulletDomainHit2Procedure.execute(world, entity);
               RotateEntityProcedure.execute(entity.getX() + entity.getDeltaMovement().x() * 32.0, entity.getY() + (double)entity.getBbHeight() * 0.9 + entity.getDeltaMovement().y() * 32.0, entity.getZ() + entity.getDeltaMovement().z() * 32.0, entity);
            } else {
               entity.getPersistentData().putBoolean("Stop", false);
            }

            entity.getPersistentData().putDouble("Damage", (15.0 + entity.getPersistentData().getDouble("cnt1") * 0.01) * Math.max(CNT6, 0.75));
            entity.getPersistentData().putDouble("Range", 2.5);
            entity.getPersistentData().putDouble("knockback", FoxFire ? 0.1 : 1.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().putDouble("effect", 7.0);
            RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
         }

         dis = Math.sqrt(entity.getPersistentData().getDouble("x_power") * entity.getPersistentData().getDouble("x_power") + entity.getPersistentData().getDouble("y_power") * entity.getPersistentData().getDouble("y_power") + entity.getPersistentData().getDouble("z_power") * entity.getPersistentData().getDouble("z_power"));
         if (dis < 0.01) {
            dis = 1.0;
         }

         if (entity.getPersistentData().getDouble("cnt1") > 80.0 || entity.getPersistentData().getDouble("cnt1") > 50.0 && entity.getPersistentData().getDouble("move") != 0.0 || !entity.isAlive() || world.getBlockState(BlockPos.containing(x + entity.getPersistentData().getDouble("x_power") / dis, y + entity.getPersistentData().getDouble("y_power") / dis, z + entity.getPersistentData().getDouble("z_power") / dis)).canOcclude() && entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("Damage", 15.0 * Math.max(CNT6, 0.75));
            entity.getPersistentData().putDouble("Range", 5.0);
            entity.getPersistentData().putDouble("knockback", FoxFire ? 0.1 : 1.0 * Math.max(CNT6, 0.75));
            RangeAttackProcedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
            entity.getPersistentData().putDouble("effect", 3.0);
            Effect7Procedure.execute(world, x, y + (double)entity.getBbHeight() * 0.5, z, entity);
            entity.getPersistentData().putDouble("effect", 0.0);
         }

      }
   }
}
