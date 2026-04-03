package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityBroomEntity;
import org.imgaine.gaigegaigekaigecraft.entity.EntitySlashEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
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
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.registries.ForgeRegistries;

public class WindScythe2Procedure {
   public WindScythe2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double damage = 0.0;
         double CNT6 = 0.0;
         double picth = 0.0;
         double HP = 0.0;
         double range = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
         picth = Math.toRadians((double)entity.getXRot());
         x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.6 + Math.sin(picth) * -1.0 * (double)(1.0F + entity.getBbWidth());
         z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1;
         range = ReturnEntitySizeProcedure.execute(entity);
         if (entity.getPersistentData().getDouble("cnt1") < 10.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            ParticleGeneratorCircleProcedure.execute(world, 1.0 * range, 90.0, 0.5 * range, 0.75 * range, 1.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "cloud");
            ParticleGeneratorCircleProcedure.execute(world, 1.0 * range, 90.0, 0.0 * range, 4.0 * range, 1.0 * range, entity.getX(), entity.getX(), entity.getY(), entity.getY() + Math.random() * range, 0.0, entity.getZ(), entity.getZ(), "cloud");
            if (entity.getPersistentData().getDouble("cnt1") == 1.0 && world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.9F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 2.0F, 0.9F, false);
               }
            }

            if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
               ChargeParticleProcedure.execute(world, entity, 1.0);
            } else {
               ChargeParticleProcedure.execute(world, entity, 0.0);
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
                     label260: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label253: {
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
                                    break label253;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label260;
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
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                        entity.getPersistentData().putDouble("cnt6", 5.0);
                        if (world instanceof Level) {
                           Level _level = (Level)world;
                           if (!_level.isClientSide()) {
                              _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                           }
                        }
                     }
                  }
               }
            }

            LivingEntity var77;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var77 = _mobEnt.getTarget();
            } else {
               var77 = null;
            }

            if (var77 instanceof LivingEntity && (entity.getPersistentData().getDouble("cnt1") < 5.0 || entity.getPersistentData().getDouble("cnt1") >= 5.0 && entity.getPersistentData().getDouble("cnt6") < 4.0)) {
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var77 = _mobEnt.getTarget();
               } else {
                  var77 = null;
               }

               x_pos = ((Entity)var77).getX();
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var77 = _mobEnt.getTarget();
               } else {
                  var77 = null;
               }

               double var80 = ((Entity)var77).getY();
               LivingEntity var10001;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10001 = _mobEnt.getTarget();
               } else {
                  var10001 = null;
               }

               y_pos = var80 + (double)((Entity)var10001).getBbHeight() * 0.5;
               LivingEntity var81;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var81 = _mobEnt.getTarget();
               } else {
                  var81 = null;
               }

               z_pos = ((Entity)var81).getZ();
               RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
               entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
            }
         } else {
            LivingEntity var82;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var82 = _mobEnt.getTarget();
            } else {
               var82 = null;
            }

            if (var82 instanceof LivingEntity) {
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

            entity.getPersistentData().putDouble("cnt3", entity.getPersistentData().getDouble("cnt3") + 1.0);
            entity.getPersistentData().putDouble("cnt4", entity.getPersistentData().getDouble("cnt4") + 1.0);
            if (entity.getPersistentData().getDouble("cnt3") == 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity81 = (LivingEntity)entity;
                  if (_livingEntity81.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity81.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-6.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               if (entity.getVehicle() instanceof EntityBroomEntity) {
                  if (entity.getVehicle() instanceof EntityBroomEntity) {
                     PlayAnimationEntity2Procedure.execute(entity.getVehicle(), "attack");
                  }

                  Entity _ent = entity.getVehicle();
                  if (_ent instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)_ent;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt3") <= 10.0) {
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               entity.setYRot((float)(yaw + Mth.nextDouble(RandomSource.create(), -11.25, 11.25)));
               entity.setXRot((float)(pitch + Mth.nextDouble(RandomSource.create(), -11.25, 11.25)));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               int var83;
               label204: {
                  damage = entity.getPersistentData().getDouble("cnt6");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var83 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label204;
                     }
                  }

                  var83 = 0;
               }

               HP = (double)(20 + var83 * 5);
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.CLOUD, x_pos, y_pos, z_pos, (int)(damage * 5.0), 0.1 + damage * 0.2, 0.1 + damage * 0.2, 0.1 + damage * 0.2, 1.0);
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.2F, 1.2F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.wither.shoot")), SoundSource.NEUTRAL, 1.2F, 1.2F, false);
                  }
               }

               if (world instanceof Level) {
                  Level _level = (Level)world;
                  if (!_level.isClientSide()) {
                     _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.2F);
                  } else {
                     _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.player.attack.sweep")), SoundSource.NEUTRAL, 1.2F, 1.2F, false);
                  }
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.ENTITY_SLASH.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                        if (_livingEntity108.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity108.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.0);
                     entityinstance.getPersistentData().putDouble("x_power", entity.getLookAngle().x * 6.0);
                     entityinstance.getPersistentData().putDouble("y_power", entity.getLookAngle().y * 6.0);
                     entityinstance.getPersistentData().putDouble("z_power", entity.getLookAngle().z * 6.0);
                     entityinstance.setDeltaMovement(new Vec3(entity.getLookAngle().x * 6.0, entity.getLookAngle().y * 6.0, entity.getLookAngle().z * 6.0));
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity129 = (LivingEntity)entityinstance;
                        if (_livingEntity129.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity129.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(1.5 * CNT6 * range);
                        }
                     }

                     if (entityinstance instanceof EntitySlashEntity) {
                        RandomSource var84 = RandomSource.create();
                        PlayAnimationEntity2Procedure.execute(entityinstance, "vertical" + Math.round((float)Mth.nextInt(var84, 1, 5)));
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

               entity.getPersistentData().putDouble("Damage", 9.0 * (1.0 + entity.getPersistentData().getDouble("cnt6") * 0.1));
               entity.getPersistentData().putDouble("Range", 6.0);
               entity.getPersistentData().putDouble("knockback", 2.0);
               RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
               entity.setYRot((float)yaw);
               entity.setXRot((float)pitch);
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

            if (entity.getPersistentData().getDouble("cnt3") > 15.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
            }
         }

      }
   }
}
