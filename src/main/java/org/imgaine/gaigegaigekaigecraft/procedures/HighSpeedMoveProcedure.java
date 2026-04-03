package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade16Entity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HighSpeedMoveProcedure {
   public HighSpeedMoveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_b = false;
         boolean logic_a = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double speed = 0.0;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt2") < 2.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 9, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0 && entity.getPersistentData().getDouble("cnt1") == 0.0) {
               entity.getPersistentData().putDouble("cnt1", (double)(entity.getPersistentData().getBoolean("PRESS_S") ? -1 : 1));
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
               if (entity instanceof CursedSpiritGrade16Entity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false));
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(20.0 * range), 0.5 * range, 0.5 * range, 0.5 * range, 0.0);
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(5.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
                  }
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               speed = 0.5 * entity.getPersistentData().getDouble("cnt1");
               x_power = entity.getLookAngle().x * speed;
               y_power = entity.getLookAngle().y * speed;
               z_power = entity.getLookAngle().z * speed;

               for(int index0 = 0; index0 < 48; ++index0) {
                  logic_a = true;
                  logic_b = false;
                  if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                     entity.getPersistentData().putDouble("Range", 3.0 * range);
                     Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.isAlive() && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_b = true;
                           break;
                        }
                     }
                  }

                  if (logic_b) {
                     break;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     x_pos += x_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     z_pos += z_power;
                  }

                  if (logic_a) {
                     for(int index1 = 0; index1 < 4; ++index1) {
                        if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + 1.0, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           ++y_pos;
                        }

                        if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos + y_power, z_pos + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                           logic_a = false;
                           break;
                        }
                     }
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     y_pos += y_power;
                  }

                  if (logic_a) {
                     break;
                  }
               }

               entity.teleportTo(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
               }

               if (entity instanceof CursedSpiritGrade16Entity) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(20.0 * range), 0.5 * range, 0.5 * range, 0.5 * range, 0.1);
                  }
               } else {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F);
                     } else {
                        _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)range, 1.0F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, entity.getX(), entity.getY(), entity.getZ(), (int)(5.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
                  }
               }

               if (entity instanceof Mob) {
                  Mob _entity = (Mob)entity;
                  _entity.getNavigation().stop();
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") > 3.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
