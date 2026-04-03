package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
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
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueOgi4Procedure {
   public TechniqueOgi4Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean power = false;
         boolean mode_speed = false;
         boolean type = false;
         boolean logic_a = false;
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
         double CNT6 = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity) * (1.0 + entity.getPersistentData().getDouble("cnt10"));
         if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 5, false, false));
               }
            }

            x_pos = entity.getX();
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
            z_pos = entity.getZ();
            if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
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
                     label235: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label236: {
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
                                    break label236;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label235;
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
            }

            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 0.0));
            }

            if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
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

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, entity.getY(), z_pos, 5, 0.25, 0.25, 0.25, CNT6 * 0.1);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") >= 1.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.blaze.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               entity.getPersistentData().putDouble("cnt4", (double)(entity.getYRot() + 45.0F));
            }

            if (entity.getPersistentData().getDouble("cnt1") < 22.0) {
               if (entity.getPersistentData().getDouble("cnt1") % 5.0 == 1.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity54 = (LivingEntity)entity;
                     if (_livingEntity54.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity54.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-8.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity55 = (LivingEntity)entity;
                     if (_livingEntity55.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity55.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               for(int index0 = 0; index0 < 6; ++index0) {
                  entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + Math.random() * 20.0);
                  rad = Math.toRadians(entity.getPersistentData().getDouble("cnt4"));

                  for(int index1 = 0; index1 < 2; ++index1) {
                     y_pos = y + entity.getPersistentData().getDouble("cnt1") * 0.14 + 0.4;
                     if (type) {
                        dis = Math.min(2.0, entity.getPersistentData().getDouble("cnt1") * 0.25);
                        x_pos = x + Math.cos(rad) * dis;
                        z_pos = z + Math.sin(rad) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.25, 4.0 * range, 5.0, 2.0 * range, x + Math.cos(rad), x + Math.cos(rad) * 4.0, y_pos, y_pos, z + Math.sin(rad), z + Math.sin(rad) * 4.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                     } else {
                        dis = Math.min(4.0, entity.getPersistentData().getDouble("cnt1") * 0.33);
                        x_pos = x + Math.sin(rad) * dis;
                        z_pos = z + Math.cos(rad) * dis;
                        ParticleGeneratorProcedure.execute(world, range * 0.25, 4.0 * range, 5.0, 2.0 * range, x + Math.sin(rad), x + Math.sin(rad) * 4.0, y_pos, y_pos, z + Math.cos(rad), z + Math.cos(rad) * 4.0, "gaigegaigekaigecraft:particle_curse_power_blue");
                     }

                     entity.getPersistentData().putDouble("Damage", 17.0 * CNT6);
                     entity.getPersistentData().putDouble("Range", 4.0 * range);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
                     entity.getPersistentData().putDouble("projectile_type", 2.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                     if (world.getBlockState(BlockPos.containing(x_pos, y_pos, z_pos)).canOcclude()) {
                        CompoundTag var93;
                        int var10003;
                        label191: {
                           var93 = entity.getPersistentData();
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label191;
                              }
                           }

                           var10003 = 0;
                        }

                        var93.putDouble("BlockDamage", (0.25 + (double)var10003 * 0.5) * CNT6);
                        entity.getPersistentData().putDouble("BlockRange", 2.0 * range);
                        entity.getPersistentData().putBoolean("noEffect", true);
                        BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), x_pos, y_pos, z_pos, 15, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.EXPLOSION, x_pos, y_pos, z_pos, 4, 0.3, 0.3, 0.3, 0.5);
                        }

                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F);
                           } else {
                              _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 0.3F, 1.0F, false);
                           }
                        }
                     }

                     type = !type;
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 22.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:sword_sweep")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity79 = (LivingEntity)entity;
                  if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-5.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity80 = (LivingEntity)entity;
                  if (_livingEntity80.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity80.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 26.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }

            entity.getPersistentData().putBoolean("attack", true);
         }

      }
   }
}
