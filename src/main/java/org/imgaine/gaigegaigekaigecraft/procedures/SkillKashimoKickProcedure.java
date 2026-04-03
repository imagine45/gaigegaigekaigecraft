package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillKashimoKickProcedure {
   public SkillKashimoKickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double CNT6 = 0.0;
         double tick = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double dis = 0.0;
         double HP = 0.0;
         double rnd = 0.0;
         double strength = 0.0;
         double distance = 0.0;
         double range = 0.0;
         double old_cnt2 = 0.0;
         double old_cnt1 = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         x_pos = entity.getX();
         y_pos = entity.getY();
         z_pos = entity.getZ();
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.5F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x_pos, y_pos, z_pos), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F);
                  } else {
                     _level.playLocalSound(x_pos, y_pos, z_pos, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:flame_explode")), SoundSource.NEUTRAL, (float)(2.0 * range), 0.75F, false);
                  }
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 4, 4, false, false));
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
                     label311: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label299: {
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
                                    break label299;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label311;
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
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 4.0 * range, 90.0, 0.5 * range, 0.75 * range, 1.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_flame_purple");
            if (entity.getPersistentData().getDouble("cnt1") <= 5.0) {
               ParticleGeneratorCircleProcedure.execute(world, 8.0 * range, 90.0, 0.0 * range, 8.0 * range, 4.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_thunder_blue");
            }
         } else if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            if (entity.getPersistentData().getDouble("cnt1") <= 21.0) {
               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(4.0 * range), 0.5F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.lightning_bolt.thunder")), SoundSource.NEUTRAL, (float)(4.0 * range), 0.5F, false);
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") == 11.0) {
                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
                     }
                  }

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

                     double var97 = ((Entity)var95).getX();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     double var98 = ((Entity)var10001).getY();
                     LivingEntity var10002;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.getTarget();
                     } else {
                        var10002 = null;
                     }

                     var98 += (double)((Entity)var10002).getBbHeight() * 0.5;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10002 = _mobEnt.getTarget();
                     } else {
                        var10002 = null;
                     }

                     RotateEntityProcedure.execute(var97, var98, ((Entity)var10002).getZ(), entity);
                  }

                  entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0 * CNT6);
                  entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0 * CNT6);
                  entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0 * CNT6);
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity80 = (LivingEntity)entity;
                     if (_livingEntity80.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity80.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1706.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               x_power = entity.getPersistentData().getDouble("x_power") * 2.0;
               y_power = entity.getPersistentData().getDouble("y_power") * 2.0;
               z_power = entity.getPersistentData().getDouble("z_power") * 2.0;
               if (entity.getPersistentData().getDouble("cnt1") == 11.0) {
                  EntityVectorProcedure.execute(entity, x_power, y_power, z_power);
               } else {
                  entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
               }

               StepBlockProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, x_power, y_power, z_power);
               dis = Math.sqrt(x_power * x_power + y_power * y_power + z_power * z_power);
               if (dis != 0.0) {
                  x_power /= dis;
                  y_power /= dis;
                  z_power /= dis;
               }

               x_pos = entity.getX();
               y_pos = entity.getY();
               z_pos = entity.getZ();
               entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.0);
               entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power") * 1.0);
               entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.0);

               for(int index0 = 0; index0 < (int)Math.max(dis, 1.0); ++index0) {
                  for(int index1 = 0; index1 < (int)(6.0 * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, entity.getPersistentData().getDouble("pitch"), 0.0 * range, Mth.nextDouble(RandomSource.create(), 0.0, 2.0) * range, 8.0, entity.getX() + entity.getPersistentData().getDouble("x_power") * range, entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getPersistentData().getDouble("y_power") * range, entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getPersistentData().getDouble("yaw"), entity.getZ() + entity.getPersistentData().getDouble("z_power") * range, entity.getZ(), "gaigegaigekaigecraft:particle_flame_purple");
                  }

                  if (!logic_a) {
                     entity.getPersistentData().putDouble("Damage", (25.0 + entity.getPersistentData().getDouble("cnt1") * 0.01) * CNT6);
                     entity.getPersistentData().putDouble("Range", 10.0 * range);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     entity.getPersistentData().putDouble("effect", 5.0);
                     entity.getPersistentData().putBoolean("attack", true);
                     RangeAttackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                     entity.getPersistentData().putDouble("Range", 10.0 * range);
                     entity.getPersistentData().putDouble("knockback", 1.0);
                     KnockbackProcedure.execute(world, x_pos, y_pos + (double)entity.getBbHeight() * 0.5, z_pos, entity);
                  }

                  if (logic_a) {
                     break;
                  }

                  x_pos += x_power;
                  y_pos += y_power;
                  z_pos += z_power;
               }

               entity.getPersistentData().putDouble("x_knockback", 0.0);
               entity.getPersistentData().putDouble("y_knockback", 0.0);
               entity.getPersistentData().putDouble("z_knockback", 0.0);
               entity.getPersistentData().putBoolean("attack", true);
               if (logic_a) {
                  if (Math.round(distance) >= 1L) {
                     x_pos = entity.getX();
                     y_pos = entity.getY();
                     z_pos = entity.getZ();

                     for(int index2 = 0; index2 < (int)Math.round(distance); ++index2) {
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
                           break;
                        }
                     }

                     entity.teleportTo(x_pos, y_pos, z_pos);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entity.getYRot(), entity.getXRot());
                     }
                  }

                  logic_a = true;
               }

               if (logic_a || entity.getPersistentData().getDouble("cnt1") >= 21.0) {
                  entity.getPersistentData().putDouble("cnt1", 21.0);
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 5.0);
               }

               ParticleGeneratorCircleProcedure.execute(world, 36.0 * range, entity.getPersistentData().getDouble("pitch"), 0.0 * range, 2.0 * range, 4.0, entity.getX(), entity.getX() - entity.getPersistentData().getDouble("x_power") * range, entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getY() + (double)entity.getBbHeight() * 0.5 - entity.getPersistentData().getDouble("y_power") * range, entity.getPersistentData().getDouble("yaw"), entity.getZ(), entity.getZ() - entity.getPersistentData().getDouble("z_power") * range, "gaigegaigekaigecraft:particle_thunder_blue");
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 21.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 9, false, false));
                  }
               }

               entity.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
               if (entity.getPersistentData().getDouble("cnt1") == 21.0) {
                  old_cnt1 = entity.getPersistentData().getDouble("cnt1");
                  old_cnt2 = entity.getPersistentData().getDouble("cnt2");
                  entity.getPersistentData().putDouble("cnt1", 9.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("x_knockback", entity.getPersistentData().getDouble("x_power") * 1.0);
                  entity.getPersistentData().putDouble("y_knockback", entity.getPersistentData().getDouble("y_power") * 1.0);
                  entity.getPersistentData().putDouble("z_knockback", entity.getPersistentData().getDouble("z_power") * 1.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity167 = (LivingEntity)entity;
                     if (_livingEntity167.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity167.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(1.0);
                     }
                  }

                  AttackStrongPunchProcedure.execute(world, x, y, z, entity);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity168 = (LivingEntity)entity;
                     if (_livingEntity168.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity168.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(0.0);
                     }
                  }

                  entity.getPersistentData().putDouble("cnt1", old_cnt1);
                  entity.getPersistentData().putDouble("cnt2", old_cnt2);
                  entity.getPersistentData().putDouble("x_knockback", 0.0);
                  entity.getPersistentData().putDouble("y_knockback", 0.0);
                  entity.getPersistentData().putDouble("z_knockback", 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt1") > 35.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

         entity.getPersistentData().putBoolean("attack", true);
      }
   }
}
