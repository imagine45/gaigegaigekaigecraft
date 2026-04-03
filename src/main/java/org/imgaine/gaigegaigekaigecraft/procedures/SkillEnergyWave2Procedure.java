package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.entity.BulletCursePowerProjectileEntity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade18Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillEnergyWave2Procedure {
   public SkillEnergyWave2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean flame = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double damage = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double num1 = 0.0;
         double num2 = 0.0;
         double dis = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         flame = entity.getPersistentData().getDouble("skill") > 100.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
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
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 9, false, false));
               }
            }

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

            double var100 = ((Entity)var10000).getY();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            y_pos = var100 + (double)((Entity)var10001).getBbHeight() * 0.5;
            LivingEntity var101;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var101 = _mobEnt.getTarget();
            } else {
               var101 = null;
            }

            z_pos = ((Entity)var101).getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 5, false, false));
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
            }
         }

         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         pitch = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(pitch) * -1.0 * (double)(1.0F + entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * (double)(1.0F + entity.getBbWidth());
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") < 15.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity28 = (LivingEntity)entity;
               if (_livingEntity28.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity28.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity29 = (LivingEntity)entity;
               if (_livingEntity29.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity29.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (flame) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.05);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 13.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label356: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label347: {
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
                                    break label347;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label356;
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

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(1.0 + CNT6), 0.05, 0.05, 0.05, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(1.0 * CNT6), 0.05, 0.05, 0.05, 0.05);
            }

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

               Level var109 = ((Entity)var10000).level();
               ClipContext var111;
               LivingEntity var10003;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10003 = _mobEnt.getTarget();
               } else {
                  var10003 = null;
               }

               Vec3 var117 = ((Entity)var10003).getEyePosition(1.0F);
               LivingEntity var10004;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10004 = _mobEnt.getTarget();
               } else {
                  var10004 = null;
               }

               Vec3 var119 = ((Entity)var10004).getEyePosition(1.0F);
               LivingEntity var10005;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10005 = _mobEnt.getTarget();
               } else {
                  var10005 = null;
               }

               var119 = var119.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var123 = Block.OUTLINE;
               ClipContext.Fluid var10006 = Fluid.NONE;
               LivingEntity var10007;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10007 = _mobEnt.getTarget();
               } else {
                  var10007 = null;
               }

               var111 = new ClipContext(var117, var119, var123, var10006, var10007);
               double var110 = (double)var109.clip(var111).getBlockPos().getX();
               LivingEntity var112;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var112 = _mobEnt.getTarget();
               } else {
                  var112 = null;
               }

               Level var113 = ((Entity)var112).level();
               ClipContext var10002;
               LivingEntity var121;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var121 = _mobEnt.getTarget();
               } else {
                  var121 = null;
               }

               Vec3 var122 = ((Entity)var121).getEyePosition(1.0F);
               LivingEntity var124;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var124 = _mobEnt.getTarget();
               } else {
                  var124 = null;
               }

               Vec3 var125 = ((Entity)var124).getEyePosition(1.0F);
               LivingEntity var129;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var129 = _mobEnt.getTarget();
               } else {
                  var129 = null;
               }

               var125 = var125.add(((Entity)var129).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var130 = Block.OUTLINE;
               ClipContext.Fluid var134 = Fluid.NONE;
               LivingEntity var10008;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10008 = _mobEnt.getTarget();
               } else {
                  var10008 = null;
               }

               var10002 = new ClipContext(var122, var125, var130, var134, var10008);
               double var114 = (double)var113.clip(var10002).getBlockPos().getY();
               LivingEntity var115;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var115 = _mobEnt.getTarget();
               } else {
                  var115 = null;
               }

               Level var116 = ((Entity)var115).level();
               ClipContext var118;
               LivingEntity var127;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var127 = _mobEnt.getTarget();
               } else {
                  var127 = null;
               }

               Vec3 var128 = ((Entity)var127).getEyePosition(1.0F);
               LivingEntity var131;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var131 = _mobEnt.getTarget();
               } else {
                  var131 = null;
               }

               Vec3 var132 = ((Entity)var131).getEyePosition(1.0F);
               LivingEntity var135;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var135 = _mobEnt.getTarget();
               } else {
                  var135 = null;
               }

               var132 = var132.add(((Entity)var135).getViewVector(1.0F).scale(0.0));
               ClipContext.Block var136 = Block.OUTLINE;
               ClipContext.Fluid var137 = Fluid.NONE;
               LivingEntity var10009;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10009 = _mobEnt.getTarget();
               } else {
                  var10009 = null;
               }

               var118 = new ClipContext(var128, var132, var136, var137, var10009);
               RotateEntityProcedure.execute(var110, var114, (double)var116.clip(var118).getBlockPos().getZ(), entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }
         } else if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
            if (entity instanceof CursedSpiritGrade18Entity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity78 = (LivingEntity)entity;
                  if (_livingEntity78.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity78.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-4.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity79 = (LivingEntity)entity;
                  if (_livingEntity79.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity79.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity80 = (LivingEntity)entity;
                  if (_livingEntity80.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity80.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(100.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity81 = (LivingEntity)entity;
                  if (_livingEntity81.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity81.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 0.75F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.25F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.end_gateway.spawn")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.25F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") < 16.0 && flame && world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(1.0 * CNT6), 1.0F, false);
                  }
               }
            }

            if (flame) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL_FIRE_FLAME, x_pos, y_pos, z_pos, 25, 0.1, 0.1, 0.1, 0.5);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), x_pos, y_pos, z_pos, 10, 0.1, 0.1, 0.1, 0.5);
            }

            entity.getPersistentData().putDouble("Damage", 1.0 * CNT6);
            DamageFixProcedure.execute(entity);
            damage = entity.getPersistentData().getDouble("Damage");

            for(int index0 = 0; index0 < 4; ++index0) {
               Level projectileLevel = entity.level();
               if (!projectileLevel.isClientSide()) {
                  Projectile _entityToSpawn = ((new InlineMethodHandler() {
                     public Projectile getArrowO(Level level, Entity shooter, float damage, int knockback, byte piercing) {
                        AbstractArrow entityToSpawn = new BulletCursePowerProjectileEntity((EntityType)JujutsucraftModEntities.BULLET_CURSE_POWER_PROJECTILE.get(), level);
                        entityToSpawn.setOwner(shooter);
                        entityToSpawn.setBaseDamage((double)damage);
                        entityToSpawn.setKnockback(knockback);
                        entityToSpawn.setSilent(true);
                        entityToSpawn.setPierceLevel(piercing);
                        return entityToSpawn;
                     }
                  })).getArrowO(projectileLevel, entity, (float)damage, 1, (byte)100);
                  _entityToSpawn.setPos(entity.getX(), entity.getEyeY() - 0.1, entity.getZ());
                  _entityToSpawn.shoot(entity.getLookAngle().x, entity.getLookAngle().y, entity.getLookAngle().z, (float)(2.5 + Math.random() * 0.5), 2.5F);
                  projectileLevel.addFreshEntity(_entityToSpawn);
               }
            }

            entity.getPersistentData().putDouble("Damage", 13.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 5.0);
            entity.getPersistentData().putDouble("knockback", 1.0 * CNT6);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         } else if (entity.getPersistentData().getDouble("cnt1") > 30.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
