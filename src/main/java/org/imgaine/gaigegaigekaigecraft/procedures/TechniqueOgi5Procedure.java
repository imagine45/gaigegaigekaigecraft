package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi5Procedure {
   public TechniqueOgi5Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         double dis = 0.0;
         double rad = 0.0;
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
         double CNT6 = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 4, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.getBbWidth()));
            entity.getPersistentData().putDouble("y_pos", entity.getY() + Math.sin(pitch) * -1.0 * (double)(-3.0F - entity.getBbWidth()) + entity.getPersistentData().getDouble("cnt1") * 0.25);
            entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(-3.0F - entity.getBbWidth()));
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            }

            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (entity.getPersistentData().getDouble("cnt1") >= 14.0) {
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
                     label237: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label229: {
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
                                    break label229;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label237;
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
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 13.0));
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
         } else {
            if (entity.getPersistentData().getDouble("cnt1") == 15.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.ender_dragon.growl")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               x_pos = entity.getPersistentData().getDouble("x_pos");
               y_pos = entity.getPersistentData().getDouble("y_pos");
               z_pos = entity.getPersistentData().getDouble("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FLAME_TIGER.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
                     if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                        entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {NoGravity:1b,Silent:1b,Invulnerable:1b}");
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

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity79 = (LivingEntity)entity;
                  if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            dis = Math.min((entity.getPersistentData().getDouble("cnt1") - 14.5) * 0.6, 12.0) * CNT6 * range;

            for(int index0 = 0; index0 < 72; ++index0) {
               rad += Math.toRadians(10.0) * Math.random();
               x_pos = x + Math.cos(rad) * dis;
               z_pos = z + Math.sin(rad) * dis;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y, z_pos, 1, 0.1, 0.1, 0.1, 0.05);
               }
            }

            x_power = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (dis + (double)entity.getBbWidth()) - entity.getPersistentData().getDouble("x_pos");
            y_power = entity.getY() + (double)entity.getBbHeight() * 0.7 + Math.sin(pitch) * -1.0 * (dis + (double)entity.getBbWidth()) - entity.getPersistentData().getDouble("y_pos");
            z_pwoer = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (dis + (double)entity.getBbWidth()) - entity.getPersistentData().getDouble("z_pos");
            dis = Math.sqrt(Math.pow(x_power, 2.0) + Math.pow(y_power, 2.0) + Math.pow(z_pwoer, 2.0));
            if (dis > 1.0) {
               x_power = x_power / dis * 1.0;
               y_power = y_power / dis * 1.0;
               z_pwoer = z_pwoer / dis * 1.0;
            }

            entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + x_power);
            entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + y_power);
            entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + z_pwoer);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(15.0 * CNT6), 1.2, 1.2, 1.2, 0.1 * CNT6);
            }

            entity.getPersistentData().putDouble("Damage", 21.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 5.0);
            entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
            entity.getPersistentData().putDouble("effect", 5.0);
            entity.getPersistentData().putDouble("projectile_type", 2.0);
            entity.getPersistentData().putBoolean("attack", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, (int)(25.0 * CNT6), 0.3, 0.3, 0.3, 0.5 * CNT6);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, (int)(5.0 * CNT6), 0.3, 0.3, 0.3, 0.5 * CNT6);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.5F, 1.0F, false);
                  }
               }

               CompoundTag var111;
               int var10003;
               label203: {
                  var111 = entity.getPersistentData();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label203;
                     }
                  }

                  var10003 = 0;
               }

               var111.putDouble("BlockDamage", (0.5 + (double)var10003 * 0.5) * CNT6);
               entity.getPersistentData().putDouble("BlockRange", 4.0);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 15.0 + 20.0 * CNT6) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
