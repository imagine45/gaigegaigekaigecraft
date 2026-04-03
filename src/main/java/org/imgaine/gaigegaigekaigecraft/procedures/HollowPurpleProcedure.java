package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.BlueEntity;
import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RedEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
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
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class HollowPurpleProcedure {
   public HollowPurpleProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean big = false;
         double rnd = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double HP = 0.0;
         double rad = 0.0;
         double rad_now = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double distance = 0.0;
         double range = 0.0;
         range = ReturnEntitySizeProcedure.execute(entity);
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
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

            double var131 = ((Entity)var10000).getX();
            LivingEntity var10001;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10001 = _mobEnt.getTarget();
            } else {
               var10001 = null;
            }

            double var140 = ((Entity)var10001).getY();
            LivingEntity var10002;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            var140 += (double)((Entity)var10002).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10002 = _mobEnt.getTarget();
            } else {
               var10002 = null;
            }

            RotateEntityProcedure.execute(var131, var140, ((Entity)var10002).getZ(), entity);
         }

         entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
         entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
         entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 9, false, false));
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            int var142;
            label514: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     var142 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                     break label514;
                  }
               }

               var142 = 0;
            }

            HP = (double)(40 + var142 * 20);
            pitch = Math.toRadians((double)entity.getXRot());
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F - 40.0F));
            distance = (double)(2.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.RED.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
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
                     LivingEntity _livingEntity38 = (LivingEntity)entityinstance;
                     if (_livingEntity38.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity38.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity42 = (LivingEntity)entityinstance;
                     if (_livingEntity42.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity42.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0);
                     }
                  }

                  if (entityinstance instanceof RedEntity) {
                     RedEntity _datEntSetL = (RedEntity)entityinstance;
                     _datEntSetL.getEntityData().set(RedEntity.DATA_flag_purple, true);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F + 40.0F));
            distance = (double)(2.0F + entity.getBbWidth());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.BLUE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  SetRangedAmmoProcedure.execute(entity, entityinstance);
                  if (!entityinstance.level().isClientSide() && entityinstance.getServer() != null) {
                     entityinstance.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityinstance.position(), entityinstance.getRotationVector(), entityinstance.level() instanceof ServerLevel ? (ServerLevel)entityinstance.level() : null, 4, entityinstance.getName().getString(), entityinstance.getDisplayName(), entityinstance.level().getServer(), entityinstance), "data merge entity @s {Invulnerable:1b}");
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
                     LivingEntity _livingEntity60 = (LivingEntity)entityinstance;
                     if (_livingEntity60.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                        _livingEntity60.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     _entity.setHealth((float)HP);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity64 = (LivingEntity)entityinstance;
                     if (_livingEntity64.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity64.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.0);
                     }
                  }

                  if (entityinstance instanceof BlueEntity) {
                     BlueEntity _datEntSetL = (BlueEntity)entityinstance;
                     _datEntSetL.getEntityData().set(BlueEntity.DATA_flag_purple, true);
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 20.0 && entity.getPersistentData().getDouble("cnt4") == 0.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity70 = (LivingEntity)entity;
               if (_livingEntity70.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity70.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(20.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity71 = (LivingEntity)entity;
               if (_livingEntity71.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                  _livingEntity71.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") <= 10.0) {
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(24.0), (e) -> true)) {
               if (entity != entityiterator && entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) {
                  label533: {
                     if (entityiterator instanceof RedEntity) {
                        RedEntity _datEntL76 = (RedEntity)entityiterator;
                        if ((Boolean)_datEntL76.getEntityData().get(RedEntity.DATA_flag_purple)) {
                           break label533;
                        }
                     }

                     if (!(entityiterator instanceof BlueEntity)) {
                        continue;
                     }

                     BlueEntity _datEntL77 = (BlueEntity)entityiterator;
                     if (!(Boolean)_datEntL77.getEntityData().get(BlueEntity.DATA_flag_purple)) {
                        continue;
                     }
                  }

                  logic_a = true;
                  if (entityiterator instanceof RedEntity) {
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + Math.max(40.0 - entity.getPersistentData().getDouble("cnt1") * 4.0, 0.0));
                  } else if (entityiterator instanceof BlueEntity) {
                     yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + Math.max(40.0 - entity.getPersistentData().getDouble("cnt1") * 4.0, 0.0));
                  } else {
                     logic_a = false;
                  }

                  if (logic_a) {
                     pitch = Math.toRadians((double)entity.getXRot());
                     distance = (double)(1.0F + entity.getBbWidth());
                     x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                     y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                     z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     entityiterator.teleportTo(x_pos, y_pos, z_pos);
                     if (entityiterator instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityiterator;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityiterator.getYRot(), entityiterator.getXRot());
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") == 10.0 && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 5, 0.25, 0.25, 0.25, 0.0);
            }
         } else if (entity.getPersistentData().getDouble("cnt1") <= 20.0) {
            if (entity.getPersistentData().getDouble("cnt1") >= 19.0) {
               if (entity.getPersistentData().getDouble("cnt4") > 0.0 && entity.getPersistentData().getDouble("cnt6") >= 0.0) {
                  for(int index0 = 0; index0 < (int)(2.0 * range); ++index0) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.5 * range, 0.75 * range, 4.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), entity.getPersistentData().getDouble("cnt6") >= 6.0 ? "enchanted_hit" : "crit");
                  }

                  for(int index1 = 0; index1 < (int)(2.0 * range); ++index1) {
                     ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 2.0 * range, 8.0 * range, 1.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "cloud");
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0 && Math.random() < 0.1) {
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
                        }
                     }

                     for(int index2 = 0; index2 < (int)(4.0 * range); ++index2) {
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.0 * range, 8.0 * range, Mth.nextDouble(RandomSource.create(), 0.0, 2.0) * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_thunder_purple");
                     }

                     for(int index3 = 0; index3 < (int)(4.0 * range); ++index3) {
                        ParticleGeneratorCircleProcedure.execute(world, 1.0, 90.0, 0.5 * range, 0.75 * range, Mth.nextDouble(RandomSource.create(), 0.0, 2.0) * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "gaigegaigekaigecraft:particle_thunder_purple");
                     }
                  }
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               if (var10000 instanceof LivingEntity) {
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 12.0) {
                     label538: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label539: {
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
                                    break label539;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label538;
                              }
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (var10000 != entity) {
                           entity.getPersistentData().putBoolean("PRESS_Z", true);
                        }
                     }
                  }

                  if (!(entity instanceof GojoSatoruEntity)) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", 19.0);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 9, 5, false, false));
                     }
                  }

                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  pitch = Math.toRadians((double)entity.getXRot());
                  distance = 1.5 + (double)entity.getBbWidth();
                  x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                  z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  if (entity.getPersistentData().getDouble("cnt6") >= 6.0) {
                     ChargeParticleProcedure.execute(world, entity, 1.0);
                  } else {
                     ChargeParticleProcedure.execute(world, entity, 0.0);
                  }

                  if (entity.getPersistentData().getDouble("cnt6") < 4.0) {
                     entity.getPersistentData().putDouble("cnt5", entity.getPersistentData().getDouble("cnt5") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt5") > 20.0) {
                        if (entity.getPersistentData().getDouble("cnt4") == 0.0) {
                           entity.getPersistentData().putDouble("cnt4", 1.0);
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity162 = (LivingEntity)entity;
                              if (_livingEntity162.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                                 _livingEntity162.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(215.0);
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity163 = (LivingEntity)entity;
                              if (_livingEntity163.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                                 _livingEntity163.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                              }
                           }

                           PlayAnimationProcedure.execute(world, entity);
                        }

                        entity.getPersistentData().putDouble("cnt5", 0.0);
                        entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 1.0);
                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.level().isClientSide()) {
                              CompoundTag var143 = entity.getPersistentData();
                              _player.displayClientMessage(Component.literal("§l\"" + Component.translatable("chant.gaigegaigekaigecraft.purple" + Math.round(var143.getDouble("cnt6"))).getString() + "\""), false);
                           }
                        }

                        if (entity instanceof Player) {
                           double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 50.0;
                           entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                              capability.PlayerCursePowerChange = _setval;
                              capability.syncPlayerVariables(entity);
                           });
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt6") >= 4.0 && entity.getPersistentData().getDouble("cnt6") < 6.0) {
                     entity.getPersistentData().putDouble("cnt6", 6.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.FLASH, x_pos, y_pos, z_pos, 10, 0.25, 0.25, 0.25, 1.5);
                     }

                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                        } else {
                           _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:electric_shock")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                        }
                     }
                  }
               }
            }
         } else {
            if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
               label559: {
                  label503: {
                     if (entity instanceof Player) {
                        if (entity.getPersistentData().getDouble("cnt6") >= 6.0 && entity.isShiftKeyDown()) {
                           break label503;
                        }
                     } else if (entity instanceof GojoSatoruEntity) {
                        float var138;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var138 = _livEnt.getHealth();
                        } else {
                           var138 = -1.0F;
                        }

                        double var139 = (double)var138;
                        float var144;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var144 = _livEnt.getMaxHealth();
                        } else {
                           var144 = -1.0F;
                        }

                        if (var139 < (double)var144 * 0.4) {
                           break label503;
                        }
                     }

                     entity.getPersistentData().putDouble("cnt2", 1.0);
                     break label559;
                  }

                  entity.getPersistentData().putDouble("cnt2", 2.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") == 1.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 21.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity188 = (LivingEntity)entity;
                     if (_livingEntity188.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity188.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(215.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity189 = (LivingEntity)entity;
                     if (_livingEntity189.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity189.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               if (entity.getPersistentData().getDouble("cnt1") == 28.0) {
                  logic_a = true;
               }
            } else {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity191 = (LivingEntity)entity;
                  if (_livingEntity191.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity191.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(2015.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity192 = (LivingEntity)entity;
                  if (_livingEntity192.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity192.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getPersistentData().getDouble("cnt1") == 21.0) {
                  logic_a = true;
               }
            }

            if (logic_a) {
               int var145;
               label488: {
                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  pitch = Math.toRadians((double)entity.getXRot());
                  distance = 1.5 + (double)entity.getBbWidth();
                  x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                  z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var145 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label488;
                     }
                  }

                  var145 = 0;
               }

               HP = (double)(400 + var145 * 40);
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.PURPLE.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
                  if (entityinstance != null) {
                     entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                     SetRangedAmmoProcedure.execute(entity, entityinstance);
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
                        LivingEntity _livingEntity208 = (LivingEntity)entityinstance;
                        if (_livingEntity208.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity208.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6"));
                     if (entity.getPersistentData().getDouble("cnt6") >= 4.0) {
                        entityinstance.getPersistentData().putDouble("size", 8.0 * (0.5 + entity.getPersistentData().getDouble("cnt6") * 0.5));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity219 = (LivingEntity)entityinstance;
                           if (_livingEntity219.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity219.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(5.0);
                           }
                        }
                     } else {
                        entityinstance.getPersistentData().putDouble("size", 8.0 * (0.5 + entity.getPersistentData().getDouble("cnt6") * 0.2));
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity224 = (LivingEntity)entityinstance;
                           if (_livingEntity224.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity224.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(5.0);
                           }
                        }
                     }

                     if (entity.getPersistentData().getDouble("cnt2") == 2.0) {
                        entityinstance.getPersistentData().putDouble("size", 5.0);
                        entityinstance.getPersistentData().putDouble("cnt6", Math.max(entity.getPersistentData().getDouble("cnt6") - 4.0, 2.0));
                        entityinstance.getPersistentData().putString("OWNER_UUID", "");
                        entityinstance.getPersistentData().putBoolean("explode", true);
                        entityinstance.getPersistentData().putBoolean("betrayal", true);
                        x_pos = entity.getX();
                        y_pos = entity.getY() + 2.0 + (double)entity.getBbHeight() + Math.max(entityinstance.getPersistentData().getDouble("size"), 5.0) * 0.2;
                        z_pos = entity.getZ();
                     } else {
                        distance = 2.0 + ((double)entity.getBbWidth() + Math.max(entityinstance.getPersistentData().getDouble("size"), 5.0) * 0.2) * 0.75;
                        x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                        y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                        z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                     }

                     entityinstance.teleportTo(x_pos, y_pos, z_pos);
                     if (entityinstance instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entityinstance;
                        _serverPlayer.connection.teleport(x_pos, y_pos, z_pos, entityinstance.getYRot(), entityinstance.getXRot());
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") > 66.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
