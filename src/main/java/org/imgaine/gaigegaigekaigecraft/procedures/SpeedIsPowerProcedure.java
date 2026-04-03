package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SpeedIsPowerProcedure {
   public SpeedIsPowerProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity target_entity = null;
         boolean SUCCESS = false;
         boolean logic_a = false;
         double d = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double y_pos = 0.0;
         double pitch = 0.0;
         double num1 = 0.0;
         double CNT6 = 0.0;
         entity.getPersistentData().putDouble("cnt10", entity.getPersistentData().getDouble("cnt10") + 1.0);
         range = ReturnEntitySizeProcedure.execute(entity);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         Entity var38 = var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 2, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt10") <= 20.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof Player) {
               double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.PlayerCursePowerChange = _setval;
                  capability.syncPlayerVariables(entity);
               });
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 2, 1, false, false));
               }
            }

            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity instanceof Player) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity12 = (LivingEntity)entity;
                  if (_livingEntity12.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity12.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-21.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity13 = (LivingEntity)entity;
                  if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            x_power = entity.getX();
            y_power = entity.getY();
            z_power = entity.getZ();
            distance = 16.0 * range * Mth.nextDouble(RandomSource.create(), 0.25, 1.0);

            for(int index0 = 0; index0 < (int)(8.0 * range); ++index0) {
               yaw = Math.toRadians((double)Mth.nextInt(RandomSource.create(), 0, 360));
               pitch = Math.toRadians(0.0);
               x_pos = x_power + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = y_power + Math.sin(pitch) * -1.0 * distance;
               z_pos = z_power + Math.sin(yaw) * Math.cos(pitch) * distance;
               ParticleGeneratorProcedure.execute(world, 2.0 * range, 1.0, 0.0, Math.min(entity.getPersistentData().getDouble("cnt6") * 1.0 + 5.0, 10.0), x_pos, x_pos + Math.cos(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance, y_pos, y_pos + Math.sin(pitch) * -1.0 * distance, z_pos, z_pos + Math.sin(yaw + Math.toRadians(90.0)) * Math.cos(pitch) * distance, "minecraft:cloud");
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(2.0 * range), (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.25));
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, (float)(2.0 * range), (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.25), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.25));
               } else {
                  _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), (float)Mth.nextDouble(RandomSource.create(), 1.0, 1.25), false);
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(1.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 0.5);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                  }
               }
            }

            entity.getPersistentData().putDouble("BlockDamage", 2.0);
            entity.getPersistentData().putDouble("BlockRange", 1.0 * range);
            BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
               entity.getPersistentData().putDouble("cnt6", Math.min(entity.getPersistentData().getDouble("cnt6") + 0.25, 5.0));
            }

            if (entity.getPersistentData().getDouble("cnt10") >= 20.0) {
               if (var38 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt10", 19.0);
               }
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt10") <= 25.0) {
               if (entity.getPersistentData().getDouble("cnt10") == 21.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity41 = (LivingEntity)entity;
                     if (_livingEntity41.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity41.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entity;
                     if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  if (var38 instanceof LivingEntity) {
                     RotateEntityProcedure.execute(((Entity)var38).getX(), ((Entity)var38).getY() + (double)((Entity)var38).getBbHeight() * 0.5, ((Entity)var38).getZ(), entity);
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 9.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 9.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 9.0);
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               }

               entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power"));
               entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power"));
               x_power = entity.getPersistentData().getDouble("x_power");
               y_power = entity.getPersistentData().getDouble("y_power");
               z_power = entity.getPersistentData().getDouble("z_power");
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               num1 = 0.0;
               distance = 0.0;

               for(int index1 = 0; index1 < (int)(1.0 + dis); ++index1) {
                  logic_a = false;
                  ++num1;
                  if (num1 > 0.0) {
                     num1 = -2.0;
                     ParticleGeneratorCircleProcedure.execute(world, 18.0 * range, entity.getPersistentData().getDouble("pitch"), 0.5 * range, 6.0 * range, 4.0, x_pos, x_pos - x_power * range, y_pos, y_pos - y_power * range, entity.getPersistentData().getDouble("yaw"), z_pos, z_pos - z_power * range, "minecraft:cloud");
                  }

                  if (!logic_a) {
                     entity.getPersistentData().putDouble("Damage", 26.0 * CNT6);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     entity.getPersistentData().putDouble("knockback", 2.0);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     Vec3 _center = new Vec3(x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator instanceof LivingEntity && entityiterator.isAlive() && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                           logic_a = true;
                           GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           break;
                        }
                     }
                  }

                  if (logic_a) {
                     break;
                  }

                  logic_a = true;
                  if (!InsideSolidCalculateProcedure.execute(world, x_pos + x_power, y_pos, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     x_pos += x_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos + y_power, z_pos, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     y_pos += y_power;
                  }

                  if (!InsideSolidCalculateProcedure.execute(world, x_pos, y_pos, z_pos + z_power, (double)entity.getBbHeight(), (double)entity.getBbWidth())) {
                     logic_a = false;
                     z_pos += z_power;
                  }

                  if (logic_a) {
                     logic_a = false;
                     break;
                  }
               }

               entity.getPersistentData().putBoolean("attack", true);
               entity.teleportTo(x_pos, y_pos, z_pos);
               if (entity instanceof ServerPlayer) {
                  ServerPlayer _serverPlayer = (ServerPlayer)entity;
                  _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
               }

               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power"));
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power"), entity.getPersistentData().getDouble("y_power"), entity.getPersistentData().getDouble("z_power")));
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }
            }

            if (var38 instanceof LivingEntity) {
               entity.setYRot((float)entity.getPersistentData().getDouble("yaw"));
               entity.setXRot((float)entity.getPersistentData().getDouble("pitch"));
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

            if (entity.getPersistentData().getDouble("cnt10") == 26.0) {
               entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power"));
               entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power"));
               entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power"));
               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               if (entity.getPersistentData().getDouble("cnt10") == 20.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 2.0);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 26.0 * CNT6);
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("Range", 8.0 * range);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("Range", 8.0 * range);
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               d = Math.sqrt(entity.getPersistentData().getDouble("Damage"));
               entity.getPersistentData().putDouble("BlockDamage", Math.max(d * 0.25, 1.0));
               entity.getPersistentData().putDouble("BlockRange", Math.max(1.0 * range, Math.max(d * 0.5, 1.0)));
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("Range", Math.max(2.0 * range, Math.max(d * 1.0, 2.0)));
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            entity.getPersistentData().putDouble("x_knockback", 0.0);
            entity.getPersistentData().putDouble("y_knockback", 0.0);
            entity.getPersistentData().putDouble("z_knockback", 0.0);
            if (entity.getPersistentData().getDouble("cnt10") > 30.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
