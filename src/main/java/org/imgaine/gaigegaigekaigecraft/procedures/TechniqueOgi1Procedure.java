package org.imgaine.gaigegaigekaigecraft.procedures;

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
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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

public class TechniqueOgi1Procedure {
   public TechniqueOgi1Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
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
         double CNT6 = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 8, 4, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 9.0 && entity.getPersistentData().getDouble("cnt1") <= 10.0) {
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
                     label253: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label243: {
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
                                    break label243;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label253;
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
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 9.0));
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
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 20, 0.5, 0.5, 0.5, 0.5);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.getY(), z_pos, 5, 0.25, 0.1, 0.25, 0.5);
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.getY(), z_pos, 2, 0.25, 0.1, 0.25, 0.5);
                  }
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.getY(), z_pos, 5, 0.25, 0.25, 0.25, CNT6 * 0.1);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
               }

               if (OnGroundProcedure.execute(world, entity)) {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  LivingEntity var95;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var95 = _mobEnt.getTarget();
                  } else {
                     var95 = null;
                  }

                  if (var95 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.getTarget();
                     } else {
                        var95 = null;
                     }

                     x_pos = ((Entity)var95).getX();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var95 = _mobEnt.getTarget();
                     } else {
                        var95 = null;
                     }

                     double var98 = ((Entity)var95).getY();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var98 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var99;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var99 = _mobEnt.getTarget();
                     } else {
                        var99 = null;
                     }

                     z_pos = ((Entity)var99).getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
                  GetPowerFixProcedure.execute(entity);
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 1.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 2.5) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, (int)(CNT6 * 10.0), 0.1, 0.1, 0.1, CNT6 * 0.25);
                     }
                  }

                  entity.getPersistentData().putDouble("x_pos", x);
                  entity.getPersistentData().putDouble("y_pos", y + 0.1);
                  entity.getPersistentData().putDouble("z_pos", z);
                  entity.getPersistentData().putDouble("old_x", x);
                  entity.getPersistentData().putDouble("old_y", y + (double)entity.getBbHeight() * 0.5);
                  entity.getPersistentData().putDouble("old_z", z);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity81 = (LivingEntity)entity;
                     if (_livingEntity81.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity81.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               } else if (entity.getPersistentData().getDouble("cnt1") >= 120.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         } else if (entity.getPersistentData().getDouble("cnt1") >= 6.0) {
            entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 10.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt1") <= 4.0) {
               entity.setDeltaMovement(new Vec3(entity.getPersistentData().getDouble("x_power") * 1.2 * CNT6, entity.getPersistentData().getDouble("y_power") * 1.2 * CNT6, entity.getPersistentData().getDouble("z_power") * 1.2 * CNT6));
            }

            rad_now = Math.toRadians((double)(entity.getYRot() + 90.0F));
            x_pos = x - entity.getPersistentData().getDouble("old_x");
            y_pos = y + (double)entity.getBbHeight() * 0.5 - entity.getPersistentData().getDouble("old_y");
            z_pos = z - entity.getPersistentData().getDouble("old_z");
            dis = Math.sqrt(x_pos * x_pos + y_pos * y_pos + z_pos * z_pos);
            if (dis != 0.0) {
               entity.getPersistentData().putDouble("x_pos", x_pos / (dis * 5.0));
               entity.getPersistentData().putDouble("y_pos", y_pos / (dis * 5.0));
               entity.getPersistentData().putDouble("z_pos", z_pos / (dis * 5.0));
            }

            x_pos = x;
            y_pos = y + (double)entity.getBbHeight() * 0.5;
            z_pos = z;

            for(int index0 = 0; index0 < (int)Math.max(Math.round(dis), 1L); ++index0) {
               entity.getPersistentData().putDouble("Damage", 15.0 * CNT6);
               entity.getPersistentData().putDouble("Range", 3.0 * range);
               entity.getPersistentData().putDouble("knockback", 0.6);
               entity.getPersistentData().putDouble("effect", 5.0);
               entity.getPersistentData().putDouble("projectile_type", 1.0);
               entity.getPersistentData().putBoolean("swing", true);
               entity.getPersistentData().putBoolean("attack", true);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

               for(int index1 = 0; index1 < 5; ++index1) {
                  rad = Math.toRadians(entity.getPersistentData().getDouble("cnt2"));

                  for(int index2 = 0; index2 < 2; ++index2) {
                     x_pos2 = x_pos + (Math.cos(rad_now) - Math.sin(rad) * Math.sin(rad_now)) * 1.25 * range;
                     z_pos2 = z_pos + (Math.sin(rad_now) + Math.sin(rad) * Math.cos(rad_now)) * 1.25 * range;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos2, y_pos, z_pos2, 1, 0.1 * range, 0.1 * range, 0.1 * range, 0.1 * range);
                     }

                     rad += Math.toRadians(180.0);
                  }

                  entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 5.0);
                  x_pos += entity.getPersistentData().getDouble("x_pos");
                  y_pos += entity.getPersistentData().getDouble("y_pos");
                  z_pos += entity.getPersistentData().getDouble("z_pos");
               }
            }

            entity.getPersistentData().putDouble("old_x", x);
            entity.getPersistentData().putDouble("old_y", y + (double)entity.getBbHeight() * 0.5);
            entity.getPersistentData().putDouble("old_z", z);
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
