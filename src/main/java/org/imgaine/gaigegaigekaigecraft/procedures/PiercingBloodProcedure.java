package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BloodBallEntity;
import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
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
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class PiercingBloodProcedure {
   public PiercingBloodProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_attack = false;
         boolean water = false;
         boolean logic_b = false;
         double dis = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double power = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double CNT6 = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         water = entity instanceof SukunaFushiguroEntity || !((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 6.0 || ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 == 6.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 9, false, false));
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            double var106 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var112 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var112 += (double)((Entity)var10002).getBbHeight() * 0.8;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var106, var112, ((Entity)var10002).getZ(), entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity19 = (LivingEntity)entity;
               if (_livingEntity19.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity19.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (0.6 + (double)entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth());
            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               entity.getPersistentData().putDouble("cnt3", 1.0);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, 1.0F, 1.2F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.extinguish")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("NameRanged") != 0.0) {
                  Vec3 _center = new Vec3(x, y, z);

                  for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(25.0), (e) -> true)) {
                     if (entity != entityiterator && entityiterator instanceof BloodBallEntity && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                        entityiterator.getPersistentData().putBoolean("despawn", true);
                        entityiterator.teleportTo(x_pos, y_pos, z_pos);
                        if (entityiterator instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                           _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityiterator.getYRot(), entityiterator.getXRot());
                        }

                        entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 15.0));
                        entity.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6"), 5.0));
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                        break;
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") <= 15.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 1, 0.0, 0.0, 0.0, 0.0);
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(1.0 * CNT6), 0.0, 0.0, 0.0, 0.1 * CNT6);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(1.0 * CNT6), 0.0, 0.0, 0.0, 0.1 * CNT6);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 19.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 6.0) {
                     label381: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label382: {
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
                                    break label382;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label381;
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

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 19.0));
                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }
                  } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                     }

                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 20.0) {
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               entity.getPersistentData().putDouble("cnt2", 1.0);
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth()));
               entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (0.6 + (double)entity.getBbWidth()));
               entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth()));
               entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x);
               entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y);
               entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z);
               entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("x_pos"));
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("y_pos"));
               entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("z_pos"));
            }

            if (entity.getPersistentData().getDouble("cnt2") <= 15.0 + entity.getPersistentData().getDouble("cnt6")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity115 = (LivingEntity)entity;
                  if (_livingEntity115.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity115.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt2") <= 5.0 + entity.getPersistentData().getDouble("cnt6")) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8, 9, false, false));
                  }
               }

               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth());
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * (0.6 + (double)entity.getBbWidth());
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.6 + (double)entity.getBbWidth());
               if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.2F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.2F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.firework_rocket.large_blast_far")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                     }
                  }

                  ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, (double)entity.getXRot(), 0.1 * range, 1.5 * range, 1.0, x_pos, x_pos, y_pos, y_pos, (double)entity.getYRot(), z_pos, z_pos, "minecraft:cloud");
               }
            }

            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            x_power = entity.getPersistentData().getDouble("x_power") * 0.1;
            y_power = entity.getPersistentData().getDouble("y_power") * 0.1;
            z_power = entity.getPersistentData().getDouble("z_power") * 0.1;

            for(int index0 = 0; index0 < 50; ++index0) {
               ++dis;
               if (dis > 0.0) {
                  dis = -10.0;
                  entity.getPersistentData().putDouble("Damage", 20.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 2.0);
                  entity.getPersistentData().putDouble("knockback", 1.0 - (entity.getPersistentData().getDouble("cnt1") - 20.0) * 0.05);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  if (!water) {
                     entity.getPersistentData().putDouble("effect", 11.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               }

               logic_a = false;
               logic_b = false;
               if ((dis == -10.0 || dis == -5.0) && !world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).isEmpty() && entity != (Entity)world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((LivingEntity) null) && ((Entity)world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x_pos, y_pos, z_pos), 0.5, 0.5, 0.5), (e) -> true).stream().sorted(InlineMethodHandler.compareDistOf(x_pos, y_pos, z_pos)).findFirst().orElse((LivingEntity) null)).isAlive()) {
                  logic_b = true;
               }

               if (world.isEmptyBlock(BlockPos.containing(x_pos + x_power, y_pos, z_pos))) {
                  x_pos += x_power;
               } else {
                  logic_a = true;
               }

               if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos + y_power, z_pos))) {
                  y_pos += y_power;
               } else {
                  logic_a = true;
               }

               if (world.isEmptyBlock(BlockPos.containing(x_pos, y_pos, z_pos + z_power))) {
                  z_pos += z_power;
               } else {
                  logic_a = true;
               }

               if (logic_a || logic_b) {
                  entity.getPersistentData().putDouble("Damage", 20.0 * CNT6);
                  entity.getPersistentData().putDouble("Range", 2.0);
                  entity.getPersistentData().putDouble("knockback", 1.0 - (entity.getPersistentData().getDouble("cnt1") - 20.0) * 0.05);
                  entity.getPersistentData().putDouble("projectile_type", 1.0);
                  if (!water) {
                     entity.getPersistentData().putDouble("effect", 11.0);
                  }

                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (logic_a) {
                     entity.getPersistentData().putDouble("BlockRange", 2.0);
                     entity.getPersistentData().putDouble("BlockDamage", 2.0 * CNT6);
                     BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.25F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 1.25F, false);
                     }
                  }

                  if (water) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_WATER.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 1.0);
                     }
                  } else if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_BLOOD_RED.get(), x_pos, y_pos, z_pos, 5, 0.1, 0.1, 0.1, 1.0);
                  }
                  break;
               }
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            x_pos = entity.getPersistentData().getDouble("cnt3");
            y_pos = entity.getPersistentData().getDouble("cnt4");
            z_pos = entity.getPersistentData().getDouble("cnt5");

            for(int index1 = 0; index1 < 40; ++index1) {
               if (water) {
                  ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, Mth.nextDouble(RandomSource.create(), 5.0, 10.0), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_blue");
               } else {
                  ParticleGeneratorProcedure.execute(world, 0.0, 1.0, 0.0, Mth.nextDouble(RandomSource.create(), 5.0, 10.0), x_pos, x_pos + x_power, y_pos, y_pos + y_power, z_pos, z_pos + z_power, "gaigegaigekaigecraft:particle_red");
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 40.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
