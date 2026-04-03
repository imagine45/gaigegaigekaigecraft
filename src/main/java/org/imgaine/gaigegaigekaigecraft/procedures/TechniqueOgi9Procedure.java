package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi9Procedure {
   public TechniqueOgi9Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         boolean logic_attack = false;
         boolean oni = false;
         boolean logic_b = false;
         boolean FoxFire = false;
         double dis = 0.0;
         double rad = 0.0;
         double tsuki7_mode = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double x_pos2 = 0.0;
         double y_pos2 = 0.0;
         double z_pos2 = 0.0;
         double rad_now = 0.0;
         double yaw_now = 0.0;
         double x_center = 0.0;
         double y_center = 0.0;
         double z_center = 0.0;
         double y_fix = 0.0;
         double y_power = 0.0;
         double z_pwoer = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double HP = 0.0;
         double start_time = 0.0;
         double CNT6 = 0.0;
         double z_power = 0.0;
         double range = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") < 40.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 19, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "stopsound @s");
               }

               if (entity.getPersistentData().getDouble("cnt1") <= 25.0) {
                  if (entity.getPersistentData().getDouble("cnt1") == 21.0) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 60, 0, true, true));
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity13 = (LivingEntity)entity;
                        if (_livingEntity13.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                           _livingEntity13.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity14 = (LivingEntity)entity;
                        if (_livingEntity14.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                           _livingEntity14.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                        }
                     }

                     PlayAnimationProcedure.execute(world, entity);
                  }

                  for(int index0 = 0; index0 < 2; ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 8.0, 0.0, 3.0, entity.getX(), entity.getX(), entity.getY() + Math.random(), entity.getY(), 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_curse_power_blue");
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") > 38.0) {
                  if (OnGroundProcedure.execute(world, entity)) {
                     entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 39.0));
                     entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 1.0);
                     entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 1.0);
                     entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 1.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 38.0));
                  }
               }
            } else {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(2.0 * range), 0.25 * range, 0.1 * range, 0.25 * range, 1.0);
               }

               if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               for(int index1 = 0; index1 < 2; ++index1) {
                  ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 0.0, 16.0, 3.0, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random(), 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_curse_power_blue");
               }

               if (entity.getPersistentData().getDouble("cnt1") >= 19.0) {
                  LivingEntity var10000;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof LivingEntity) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                     if (GetDistanceProcedure.execute(entity) > 12.0) {
                        label332: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                              label324: {
                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                                    if (entity instanceof Mob) {
                                       Mob _mobEnt = (Mob)entity;
                                       var10000 = _mobEnt.getTarget();
                                    } else {
                                       var10000 = null;
                                    }

                                    if (((Entity)var10000).getPersistentData().getBoolean("attack")) {
                                       break label324;
                                    }
                                 }

                                 if (entity instanceof Mob) {
                                    Mob _mobEnt = (Mob)entity;
                                    var10000 = _mobEnt.getTarget();
                                 } else {
                                    var10000 = null;
                                 }

                                 if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                    break label332;
                                 }
                              }
                           }

                           entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
                        entity.getPersistentData().putDouble("cnt7", 1.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                           }
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, 20, 0.5, 0.5, 0.5, 1.5);
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     ParticleGeneratorCircleProcedure.execute(world, 9.0, 90.0, 0.0, 16.0, 3.0, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random(), 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_curse_power_blue");
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 19.0));
               }
            }
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 19, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity.getPersistentData().getDouble("cnt3") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity84 = (LivingEntity)entity;
                  if (_livingEntity84.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity84.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(101.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity85 = (LivingEntity)entity;
                  if (_livingEntity85.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity85.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 3.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 3.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               for(int index2 = 0; index2 < (int)(32.0 * range); ++index2) {
                  if (Math.random() < 0.75 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(1.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 1.0);
                  }

                  ++dis;
                  if (dis > 0.0) {
                     entity.getPersistentData().putDouble("Damage", 40.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 5.0 * range);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putDouble("projectile_type", 2.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), entity);
                     ParticleGeneratorCircleProcedure.execute(world, 16.0, entity.getPersistentData().getDouble("pitch"), 0.0, 16.0, 3.0, entity.getX(), entity.getX(), entity.getY(), entity.getY(), entity.getPersistentData().getDouble("yaw"), entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_curse_power_blue");
                     dis = 5.0 * range * -0.5;
                  }

                  entity.teleportTo(entity.getX() + entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX() + entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX() - entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() - entity.getPersistentData().getDouble("x_power"), entity.getY(), entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY() + entity.getPersistentData().getDouble("y_power"), entity.getZ());
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY() + entity.getPersistentData().getDouble("y_power"), entity.getZ(), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("y_power"), entity.getZ());
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY() - entity.getPersistentData().getDouble("y_power"), entity.getZ(), entity.getYRot(), entity.getXRot());
                     }
                  }

                  entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() + entity.getPersistentData().getDouble("z_power"));
                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _serverPlayer = (ServerPlayer)entity;
                     _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() + entity.getPersistentData().getDouble("z_power"), entity.getYRot(), entity.getXRot());
                  }

                  if (InsideSolidProcedure.execute(world, entity)) {
                     entity.teleportTo(entity.getX(), entity.getY(), entity.getZ() - entity.getPersistentData().getDouble("z_power"));
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX(), entity.getY(), entity.getZ() - entity.getPersistentData().getDouble("z_power"), entity.getYRot(), entity.getXRot());
                     }
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 3.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY(), entity.getZ(), (int)(25.0 * range), 0.1 * range, 0.1 * range, 0.1 * range, 3.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F);
                  } else {
                     _level.playLocalSound(entity.getX(), entity.getY(), entity.getZ(), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(4.0 * range), 1.0F, false);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ(), (int)(2.0 * range), 0.25 * range, 0.25 * range, 0.25 * range, 1.0);
            }

            if (entity.getPersistentData().getDouble("cnt3") == 7.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity181 = (LivingEntity)entity;
                  if (_livingEntity181.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity181.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity182 = (LivingEntity)entity;
                  if (_livingEntity182.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity182.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt3") > 30.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
