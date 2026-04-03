package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade03Entity;
import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class SkillUzumakiProcedure {
   public SkillUzumakiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double distance = 0.0;
         double num1 = 0.0;
         double HP = 0.0;
         double x_pos = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         Entity target_entity = null;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         target_entity = var10000;
         if (target_entity instanceof LivingEntity) {
            x_pos = target_entity.getX();
            y_pos = target_entity.getY() + (double)target_entity.getBbHeight() * 0.75;
            z_pos = target_entity.getZ();
            RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().getDouble("cnt9") < 20.0) {
            entity.getPersistentData().putDouble("cnt9", entity.getPersistentData().getDouble("cnt9") + 1.0);
            if (entity instanceof Player) {
               if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt9", 30.0);
               }
            } else if (!entity.getPersistentData().getBoolean("uzumaki")) {
               entity.getPersistentData().putDouble("cnt9", 30.0);
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "particle soul ^ ^ ^3 0.1 0.1 0.1 0 2 normal @s");
            }
         }

         if (entity.getPersistentData().getDouble("cnt9") >= 30.0 && entity.getPersistentData().getDouble("cnt9") < 35.0) {
            entity.getPersistentData().putDouble("skill", 1816.0);
         }

         if (entity.getPersistentData().getDouble("cnt9") >= 20.0 && entity.getPersistentData().getDouble("cnt9") < 25.0) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            pitch = Math.toRadians(0.0);
            distance = (double)(-3.0F - entity.getBbWidth());
            entity.getPersistentData().putDouble("x_pos", entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance);
            entity.getPersistentData().putDouble("y_pos", entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance);
            entity.getPersistentData().putDouble("z_pos", entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance);
            x_pos = entity.getPersistentData().getDouble("x_pos");
            y_pos = entity.getPersistentData().getDouble("y_pos");
            z_pos = entity.getPersistentData().getDouble("z_pos");
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 4, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
               if (!(entity instanceof Player) && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 9, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity38 = (LivingEntity)entity;
                  if (_livingEntity38.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity38.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-3.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               num1 = entity.getPersistentData().getDouble("cnt1") / 19.5;
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SOUL, x_pos, y_pos + 2.0, z_pos, (int)(50.0 * num1), 1.5 * num1, 1.5 * num1, 1.5 * num1, 0.0);
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.SQUID_INK, x_pos, y_pos + 2.0, z_pos, (int)(25.0 * num1), 1.5 * num1, 1.5 * num1, 1.5 * num1, 0.0);
               }

               if (entity.getPersistentData().getDouble("cnt2") == 0.0) {
                  entity.getPersistentData().putDouble("cnt2", 1.0);
                  double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 700.0;
                  entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                     capability.PlayerCursePowerChange = _setval;
                     capability.syncPlayerVariables(entity);
                  });
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)(entity.getPersistentData().getDouble("COOLDOWN_TICKS") * 2.0), 0, false, false));
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.ZONE.get(), 100, 0, false, false));
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("ambient.cave")), SoundSource.NEUTRAL, 2.0F, 0.5F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:slow_motion_end")), SoundSource.NEUTRAL, 2.0F, 1.0F, false);
                     }
                  }

                  if (world instanceof Level) {
                     Level _level = (Level)world;
                     if (!_level.isClientSide()) {
                        _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F);
                     } else {
                        _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:piano_horror")), SoundSource.NEUTRAL, 1.0F, 0.25F, false);
                     }
                  }

                  if (entity.getPersistentData().getDouble("friend_num") != 0.0 && !(entity instanceof Player)) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0), (e) -> true)) {
                        if (entity != entityiterator && entityiterator.getPersistentData().getBoolean("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker") && world instanceof ServerLevel) {
                           ServerLevel _level = (ServerLevel)world;
                           _level.sendParticles(ParticleTypes.SOUL, entityiterator.getX(), entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5, entityiterator.getZ(), (int)Math.min(Math.pow((double)(entityiterator.getBbWidth() * 2.0F + entityiterator.getBbHeight() * 2.0F), 2.0), 100.0), (double)entityiterator.getBbWidth() * 0.5, (double)entityiterator.getBbHeight() * 0.5, (double)entityiterator.getBbWidth() * 0.5, 0.0);
                        }
                     }
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.getPersistentData().putDouble("cnt3", 1.0);
                  if (entity instanceof Player) {
                     x_pos = 0.0;
                     z_pos = 0.0;
                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        Commands var91 = entity.getServer().getCommands();
                        CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                        long var10002 = Math.round(x_pos);
                        var91.performPrefixedCommand(var10001, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                     }

                     num1 = 0.0;

                     for(int index0 = 0; index0 < 10000; ++index0) {
                        ++num1;
                        STR1 = "data_cursed_spirit_manipulation" + Math.round(num1);
                        if (entity.getPersistentData().getDouble(STR1) == 0.0) {
                           break;
                        }

                        y_pos = entity.getPersistentData().getDouble(STR1);
                        if (world instanceof ServerLevel) {
                           ServerLevel _origLevel = (ServerLevel)world;
                           LevelAccessor var34 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                           if (var34 != null) {
                              Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                              for(Entity entityiterator : var34.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                                 if (entity != entityiterator && entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                                    double var98;
                                    int var10003;
                                    CompoundTag var92;
                                    label361: {
                                       var92 = entity.getPersistentData();
                                       var98 = entity.getPersistentData().getDouble("cnt6");
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var10003 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label361;
                                          }
                                       }

                                       var10003 = 0;
                                    }

                                    var92.putDouble("cnt6", var98 + (double)(var10003 + 1) * 0.1);
                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "kill @s");
                                    }

                                    if (!entityiterator.level().isClientSide()) {
                                       entityiterator.discard();
                                    }
                                 }
                              }
                           }

                           world = world;
                        }

                        entity.getPersistentData().putDouble(STR1, 0.0);
                        entity.getPersistentData().putDouble(STR1 + "_num", 0.0);
                        entity.getPersistentData().putString(STR1 + "_name", "");
                     }

                     boolean _setval = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  } else {
                     entity.getPersistentData().putBoolean("use_uzumaki", true);
                     if (entity instanceof GetoSuguruCurseUserEntity) {
                        entity.getPersistentData().putDouble("cnt2", 0.0);
                        GetoSpawnCurseRandomProcedure.execute(world, x, y, z, entity);
                        entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") - 1.0);
                        entity.getPersistentData().putDouble("skill", 1815.0);
                     }
                  }

                  x_pos = entity.getPersistentData().getDouble("x_pos");
                  y_pos = entity.getPersistentData().getDouble("y_pos");
                  z_pos = entity.getPersistentData().getDouble("z_pos");
                  if (entity.getPersistentData().getDouble("friend_num") != 0.0 && !(entity instanceof Player)) {
                     Vec3 _center = new Vec3(x, y, z);

                     for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(256.0), (e) -> true)) {
                        if (entity != entityiterator && !(entityiterator instanceof CursedSpiritGrade03Entity) && entityiterator.getPersistentData().getBoolean("CursedSpirit") && !(entityiterator instanceof Player) && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                           double var99;
                           int var100;
                           CompoundTag var93;
                           label335: {
                              var93 = entity.getPersistentData();
                              var99 = entity.getPersistentData().getDouble("cnt6");
                              if (entityiterator instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entityiterator;
                                 if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                    var100 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                    break label335;
                                 }
                              }

                              var100 = 0;
                           }

                           var93.putDouble("cnt6", var99 + (double)(var100 + 1) * 0.1);
                           if (!entityiterator.level().isClientSide()) {
                              entityiterator.discard();
                           }
                        }
                     }
                  }

                  int var96;
                  label327: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var96 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label327;
                        }
                     }

                     var96 = 0;
                  }

                  HP = (double)(400 + var96 * 40);
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.UZUMAKI.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                           LivingEntity _livingEntity121 = (LivingEntity)entityinstance;
                           if (_livingEntity121.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity121.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity128 = (LivingEntity)entityinstance;
                           if (_livingEntity128.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                              AttributeInstance var94;
                              double var97;
                              label315: {
                                 var94 = _livingEntity128.getAttribute(Attributes.ATTACK_DAMAGE);
                                 if (entityinstance instanceof LivingEntity) {
                                    LivingEntity _livingEntity125 = (LivingEntity)entityinstance;
                                    if (_livingEntity125.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                       var97 = _livingEntity125.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                       break label315;
                                    }
                                 }

                                 var97 = 0.0;
                              }

                              var94.setBaseValue(var97 + entity.getPersistentData().getDouble("cnt6"));
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity130 = (LivingEntity)entityinstance;
                           if (_livingEntity130.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity130.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(0.1);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") < 80.0) {
               if (target_entity instanceof LivingEntity) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 20, false, false));
                     }
                  }

                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (target_entity.getPersistentData().getDouble("skill") == 515.0) {
                     if (target_entity.getPersistentData().getDouble("cnt1") < 80.0) {
                        entity.getPersistentData().putBoolean("PRESS_Z", true);
                     } else {
                        entity.getPersistentData().putBoolean("PRESS_Z", false);
                     }
                  } else {
                     if (target_entity instanceof OkkotsuYutaEntity && target_entity.getPersistentData().getDouble("skill") == 0.0) {
                        int var95;
                        label271: {
                           if (target_entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)target_entity;
                              if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                                 var95 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                                 break label271;
                              }
                           }

                           var95 = 0;
                        }

                        if (var95 >= 10) {
                           entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                     }

                     if (target_entity.getPersistentData().getDouble("skill") == 0.0) {
                        if (GetDistanceProcedure.execute(entity) >= 10.0) {
                           entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                     }

                     if (target_entity.getPersistentData().getDouble("skill") > 0.0) {
                        if (target_entity.getPersistentData().getBoolean("PRESS_Z")) {
                           entity.getPersistentData().putBoolean("PRESS_Z", true);
                        } else {
                           entity.getPersistentData().putBoolean("PRESS_Z", false);
                        }
                     }
                  }

                  if (entity.getPersistentData().getDouble("cnt2") >= 200.0) {
                     entity.getPersistentData().putBoolean("PRESS_Z", false);
                  }
               }

               if (entity.getPersistentData().getBoolean("PRESS_Z")) {
                  entity.getPersistentData().putDouble("cnt1", Math.min(entity.getPersistentData().getDouble("cnt1"), 78.0));
               }
            }

            entity.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 3.0);
            entity.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 3.0);
            entity.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 3.0);
            if (entity.getPersistentData().getDouble("cnt1") == 90.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity165 = (LivingEntity)entity;
                  if (_livingEntity165.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity165.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
            }

            if (entity.getPersistentData().getDouble("cnt1") > 100.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
