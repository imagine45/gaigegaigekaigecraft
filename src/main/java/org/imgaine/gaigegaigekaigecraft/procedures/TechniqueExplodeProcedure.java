package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
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
import net.minecraftforge.registries.ForgeRegistries;

public class TechniqueExplodeProcedure {
   public TechniqueExplodeProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double distance = 0.0;
         double CNT6 = 0.0;
         double power = 0.0;
         double entity_size = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
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

            x_pos = ((Entity)var10000).getX();
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            double var83 = ((Entity)var10000).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var83 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var84;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var84 = _mobEnt.getTarget();
            } else {
               var84 = null;
            }

            z_pos = ((Entity)var84).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
            entity.setYRot(entity.getYRot());
            entity.setXRot((float)Math.min((double)Math.max(entity.getXRot(), 0.0F), 22.5));
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

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         distance = 0.5 * (double)entity.getBbWidth();
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * distance;
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 6, false, false));
               }
            }

            entity.getPersistentData().putDouble("x_pos", x_pos);
            entity.getPersistentData().putDouble("y_pos", y_pos);
            entity.getPersistentData().putDouble("z_pos", z_pos);
            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 0.8F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.breath")), SoundSource.NEUTRAL, 2.0F, 0.8F, false);
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(1.0 * entity_size), 0.5 * entity_size, 0.5 * entity_size, 0.5 * entity_size, 0.1);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(1.0 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 0.1);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label277: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label267: {
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
                                    break label267;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label277;
                              }
                           }
                        }

                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0 || entity instanceof EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 8.0));
                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                  } else {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") == 5.0) {
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.01);
                     }

                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }
                  }
               }
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity71 = (LivingEntity)entity;
               if (_livingEntity71.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity71.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-19.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity72 = (LivingEntity)entity;
               if (_livingEntity72.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity72.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         } else {
            entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity79 = (LivingEntity)entity;
                  if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-19.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity80 = (LivingEntity)entity;
                  if (_livingEntity80.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity80.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt2") == 3.0) {
               entity.getPersistentData().putDouble("knockback", 2.0);
               entity.getPersistentData().putDouble("BlockRange", 16.0 * CNT6 * entity_size);
               entity.getPersistentData().putDouble("BlockDamage", 0.33);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
            }

            if (entity.getPersistentData().getDouble("cnt2") < 15.0) {
               for(int index0 = 0; index0 < (int)(15.0 * entity_size); ++index0) {
                  ParticleGeneratorProcedure.execute(world, entity_size * 0.1, 1.0, 25.0, Mth.nextDouble(RandomSource.create(), 0.0, 8.0), x_pos, x_pos + entity.getPersistentData().getDouble("x_power"), y_pos, y_pos + entity.getPersistentData().getDouble("y_power"), z_pos, z_pos + entity.getPersistentData().getDouble("z_power"), "minecraft:cloud");
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") < 9.0) {
               for(int index1 = 0; index1 < 3; ++index1) {
                  entity.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos") + entity.getPersistentData().getDouble("x_power") * 0.5);
                  entity.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos") + entity.getPersistentData().getDouble("y_power") * 0.5);
                  entity.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos") + entity.getPersistentData().getDouble("z_power") * 0.5);
                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  entity.getPersistentData().putDouble("Damage", 18.0);
                  if (entity.getPersistentData().getDouble("cnt3") > 0.0) {
                     for(int index2 = 0; index2 < (int)Math.round(entity.getPersistentData().getDouble("cnt3")); ++index2) {
                        entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * 0.9);
                        if (entity.getPersistentData().getDouble("Damage") < 10.0) {
                           entity.getPersistentData().putDouble("Damage", 10.0);
                           break;
                        }
                     }
                  }

                  entity.getPersistentData().putDouble("Damage", entity.getPersistentData().getDouble("Damage") * CNT6);
                  entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 0.5);
                  entity.getPersistentData().putDouble("Range", 10.0 * CNT6 * entity_size);
                  entity.getPersistentData().putDouble("knockback", 2.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("BlockRange", 4.0 * CNT6 * entity_size);
                  entity.getPersistentData().putDouble("BlockDamage", 4.0 * CNT6);
                  entity.getPersistentData().putBoolean("noParticle", true);
                  entity.getPersistentData().putBoolean("noEffect", true);
                  BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putBoolean("noEffect", true);
               }

               entity.getPersistentData().putDouble("BlockRange", 10.0 * entity_size);
               entity.getPersistentData().putDouble("BlockDamage", 0.33);
               entity.getPersistentData().putBoolean("noParticle", true);
               BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") < 6.0) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               pitch = Math.toRadians((double)entity.getXRot());
               distance = 0.5 * (double)entity.getBbWidth();
               x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
               y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
               z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
               entity.getPersistentData().putDouble("Damage", 18.0 * CNT6);
               entity.getPersistentData().putDouble("Range", 16.0 * CNT6 * entity_size);
               entity.getPersistentData().putDouble("knockback", 2.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("Range", 16.0 * CNT6 * entity_size);
               entity.getPersistentData().putDouble("knockback", 2.0);
               KnockbackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(10.0 * CNT6 * entity_size), 0.1 * entity_size, 0.1 * entity_size, 0.1 * entity_size, 5.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") > 25.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
