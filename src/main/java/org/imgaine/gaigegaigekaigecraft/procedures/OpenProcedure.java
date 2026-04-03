package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class OpenProcedure {
   public OpenProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double distance = 0.0;
         double rad1 = 0.0;
         double width = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double speed = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 9, false, false));
            }
         }

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

            double var88 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var99 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var99 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var88, var99, ((Entity)var10002).getZ(), entity);
         }

         entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
         entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
         entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         entity.getPersistentData().putDouble("x_pos", x_pos);
         entity.getPersistentData().putDouble("y_pos", y_pos);
         entity.getPersistentData().putDouble("z_pos", z_pos);
         if (entity.getPersistentData().getDouble("cnt1") <= 31.0) {
            if (entity.getPersistentData().getDouble("cnt1") <= 15.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, (int)(10.0F * entity.getBbWidth()), 0.1 * (double)entity.getBbWidth(), 0.1 * (double)entity.getBbWidth(), 0.1 * (double)entity.getBbWidth(), 0.05);
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.fire.ambient")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  int var101;
                  label264: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var101 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label264;
                        }
                     }

                     var101 = 0;
                  }

                  HP = (double)(200 + var101 * 20);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FLAME_ARROW.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                     if (entityinstance != null) {
                        entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                        SetRangedAmmoProcedure.execute(entity, entityinstance);
                        if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                           entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoAI:1b}");
                        }

                        entityinstance.setYRot(entity.getYRot());
                        entityinstance.setXRot(entity.getXRot());
                        entityinstance.setYBodyRot(entityinstance.getYRot());
                        entityinstance.setYHeadRot(entityinstance.getYRot());
                        entityinstance.yRotO = entityinstance.getYRot();
                        entityinstance.xRotO = entityinstance.getXRot();
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.yBodyRotO = _entity.getYRot();
                           _entity.yHeadRotO = _entity.getYRot();
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity53 = (LivingEntity)entityinstance;
                           if (_livingEntity53.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity53.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                     }
                  }
               }
            } else {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 8.0) {
                     label316: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label317: {
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
                                    break label317;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label316;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof JogoEntity && entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10000 = _mobEnt.getTarget();
                     } else {
                        var10000 = null;
                     }

                     if (((Entity)var10000).getPersistentData().getDouble("skill") == 405.0) {
                        label318: {
                           if (entity instanceof Mob) {
                              Mob _mobEnt = (Mob)entity;
                              var10000 = _mobEnt.getTarget();
                           } else {
                              var10000 = null;
                           }

                           if (!(((Entity)var10000).getPersistentData().getDouble("cnt6") >= 5.0)) {
                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getBoolean("PRESS_Z")) {
                                 break label318;
                              }
                           }

                           entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                     }
                  }

                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (var10000 instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity && entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", true);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 30.0));
                  if (entity.getPersistentData().getDouble("cnt1") >= 30.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 31.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 31.0) {
               CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
               entity.getPersistentData().putDouble("Damage", 17.5 * CNT6);
               entity.getPersistentData().putDouble("Range", 12.0 * CNT6);
               entity.getPersistentData().putDouble("projectile_type", 1.0);
               entity.getPersistentData().putDouble("knockback", 0.5);
               entity.getPersistentData().putDouble("effect", 3.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 45.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 15.0 && entity.getPersistentData().getDouble("cnt1") <= 31.0) {
            CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
            distance = Math.min(entity.getPersistentData().getDouble("cnt1") * 0.5, 4.0) * CNT6;
            if (Math.random() < 1.0) {
               for(int index0 = 0; index0 < 4; ++index0) {
                  entity.getPersistentData().putDouble("BlockRange", distance);
                  entity.getPersistentData().putDouble("BlockDamage", 5.0 * CNT6);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos + distance - 0.5, z_pos, entity);
                  rad1 = Math.toRadians(720.0 * Math.random());
                  width = distance * (Math.random() * 0.5 + 0.5);
                  x_pos = entity.getX() + Math.cos(rad1) * width;
                  z_pos = entity.getZ() + Math.sin(rad1) * width;
                  entity.getPersistentData().putBoolean("noEffect", true);
               }

               entity.getPersistentData().putBoolean("noEffect", false);
            }

            y_pos = entity.getY();

            for(int index1 = 0; index1 < 36; ++index1) {
               rad1 += Math.toRadians(20.0 * Math.random());
               x_pos = entity.getX() + Math.cos(rad1) * distance;
               z_pos = entity.getZ() + Math.sin(rad1) * distance;
               if (Math.random() < 0.1 * CNT6) {
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
                  }

                  if (Math.random() < 0.1 && entity.getPersistentData().getDouble("cnt6") > 2.5 && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_MAGMA.get(), x_pos, y_pos, z_pos, 1, distance * 0.5, distance * 0.05, distance * 0.5, 0.05);
                  }
               }

               if (Math.random() < 0.005 * CNT6 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
               }

               if (Math.random() < 0.05 * CNT6 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, 1, distance * 0.05, distance * 0.05, distance * 0.05, speed);
               }
            }

            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
            x_power = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (0.9 + (double)entity.getBbWidth()) - x_pos;
            y_power = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (0.9 + (double)entity.getBbWidth()) - y_pos;
            z_power = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (0.9 + (double)entity.getBbWidth()) - z_pos;
            distance = 0.0;

            for(int index2 = 0; index2 < Math.round((1.0F + entity.getBbWidth()) * 3.0F * 10.0F); ++index2) {
               if (Math.random() < 0.05 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
               }

               if (Math.random() < 0.0025 && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 1, distance, distance, distance, distance);
               }

               x_pos += x_power;
               y_pos += y_power;
               z_pos += z_power;
               distance += 0.001;
            }
         }

      }
   }
}
