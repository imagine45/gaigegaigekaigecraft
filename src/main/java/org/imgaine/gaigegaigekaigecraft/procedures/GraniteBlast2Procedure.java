package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
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
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class GraniteBlast2Procedure {
   public GraniteBlast2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double CNT6 = 0.0;
         double damage = 0.0;
         double picth = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 10, 5, false, false));
            }
         }

         range = ReturnEntitySizeProcedure.execute(entity);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         picth = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 1.1 + Math.sin(picth) * -1.0 * (double)(1.0F + entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, (int)(1.0 + CNT6), 0.05, 0.05, 0.05, 0.05);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(1.0 + CNT6), 0.05, 0.05, 0.05, 0.05);
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 8.0) {
               LivingEntity var10000;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label283: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label274: {
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
                                    break label274;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label283;
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

                     ChangeCurseEnergyProcedure.execute(entity, -2.0);
                  }
               }
            }

            LivingEntity var82;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var82 = _mobEnt.getTarget();
            } else {
               var82 = null;
            }

            if (var82 instanceof LivingEntity && (entity.getPersistentData().getDouble("cnt1") < 5.0 || entity.getPersistentData().getDouble("cnt1") >= 5.0 && entity.getPersistentData().getDouble("cnt6") < 4.0)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var82 = _mobEnt.getTarget();
               } else {
                  var82 = null;
               }

               double var84 = ((Entity)var82).getX();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               double var89 = ((Entity)var10001).getY();
               LivingEntity var10002;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               var89 += (double)((Entity)var10002).getBbHeight() * 0.5;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10002 = _mobEnt.getTarget();
               } else {
                  var10002 = null;
               }

               RotateEntityProcedure.execute(var84, var89, ((Entity)var10002).getZ(), entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }
         } else {
            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            LivingEntity var85;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var85 = _mobEnt.getTarget();
            } else {
               var85 = null;
            }

            if (var85 instanceof LivingEntity) {
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

            if (entity.getPersistentData().getDouble("cnt3") > 0.0) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var85 = _mobEnt.getTarget();
               } else {
                  var85 = null;
               }

               if (var85 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var85 = _mobEnt.getTarget();
                  } else {
                     var85 = null;
                  }

                  double var88 = ((Entity)var85).getX();
                  LivingEntity var91;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.getTarget();
                  } else {
                     var91 = null;
                  }

                  double var92 = ((Entity)var91).getY();
                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.getTarget();
                  } else {
                     var96 = null;
                  }

                  var92 += (double)((Entity)var96).getBbHeight() * 0.5;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.getTarget();
                  } else {
                     var96 = null;
                  }

                  RotateEntityProcedure.execute(var88, var92, ((Entity)var96).getZ(), entity);
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               }

               entity.getPersistentData().putDouble("cnt3", -5.0);
               entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
               damage = entity.getPersistentData().getDouble("cnt6");
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CRIT, x_pos, y_pos, z_pos, (int)(damage * 5.0), 0.1 + damage * 0.2, 0.1 + damage * 0.2, 0.1 + damage * 0.2, 1.0);
               }

               picth = 0.8;

               for(int index0 = 0; index0 < (int)Math.round(damage + 1.0); ++index0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)picth);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.generic.explode")), SoundSource.NEUTRAL, 1.2F, (float)picth, false);
                     }
                  }

                  picth -= 0.1;
               }

               int var94;
               label221: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var94 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label221;
                     }
                  }

                  var94 = 0;
               }

               HP = (double)(100 + var94 * 10);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENERGY_BALL_WHITE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity103 = (LivingEntity)entityinstance;
                        if (_livingEntity103.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity103.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putDouble("cnt3", 1.0);
                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") * 1.0);
                     entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.75);
                     entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.75);
                     entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.75);
                     entityinstance.setDeltaMovement(new Vec3(entity.getLookAngle().x * 3.75, entity.getLookAngle().y * 3.75, entity.getLookAngle().z * 3.75));
                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 18.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
               entity.getPersistentData().putDouble("Range", 4.0);
               entity.getPersistentData().putDouble("knockback", 2.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);

               for(int index1 = 0; index1 < (int)(18.0 * range); ++index1) {
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 8.0, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, entity.getZ(), entity.getZ(), "minecraft:crit");
                  ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0, 2.0, 4.0, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Mth.nextDouble(RandomSource.create(), 0.0, 0.25), 0.0, entity.getZ(), entity.getZ(), "minecraft:cloud");
               }

               ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, (double)entity.getXRot(), 0.0, 2.0, 8.0, x_pos, x_pos, y_pos, y_pos, (double)entity.getYRot(), z_pos, z_pos, "minecraft:crit");
            }

            if (entity.getPersistentData().getDouble("cnt4") > 4.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
