package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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

public class TechniqueFistMeteorProcedure {
   public TechniqueFistMeteorProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double distance = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double CNT6 = 0.0;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         entity.fallDistance = 0.0F;
         if (entity.getPersistentData().getDouble("cnt1") == 0.0) {
            if (entity.getPersistentData().getDouble("cnt2") <= 1.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 4, false, false));
                  }
               }

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
                  entity.getPersistentData().putBoolean("PRESS_Z", false);
                  if (GetDistanceProcedure.execute(entity) > 8.0) {
                     label225: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label219: {
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
                                    break label219;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label225;
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
                  entity.getPersistentData().putDouble("cnt2", Math.min(entity.getPersistentData().getDouble("cnt2"), 0.0));
                  if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                     entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                     if (entity instanceof Player) {
                        double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 1.0;
                        entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                           capability.PlayerCursePowerChange = _setval;
                           capability.syncPlayerVariables(entity);
                        });
                     }

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

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 10.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt2") >= 1.0) {
               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 2.5, entity.getDeltaMovement().z()));
                  entity.getPersistentData().putDouble("cnt3", 1.0);
               } else if (entity.getDeltaMovement().y() < 0.1 || entity.getPersistentData().getDouble("cnt2") > 30.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") < 20.0) {
               if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity48 = (LivingEntity)entity;
                     if (_livingEntity48.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity48.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity49 = (LivingEntity)entity;
                     if (_livingEntity49.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity49.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
                  LivingEntity var58;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var58 = _mobEnt.getTarget();
                  } else {
                     var58 = null;
                  }

                  if (var58 instanceof LivingEntity) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var58 = _mobEnt.getTarget();
                     } else {
                        var58 = null;
                     }

                     x_pos = ((Entity)var58).getX();
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var58 = _mobEnt.getTarget();
                     } else {
                        var58 = null;
                     }

                     double var61 = ((Entity)var58).getY();
                     LivingEntity var10001;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var10001 = _mobEnt.getTarget();
                     } else {
                        var10001 = null;
                     }

                     y_pos = var61 + (double)((Entity)var10001).getBbHeight() * 0.5;
                     LivingEntity var62;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var62 = _mobEnt.getTarget();
                     } else {
                        var62 = null;
                     }

                     z_pos = ((Entity)var62).getZ();
                     RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  }

                  int var63;
                  label171: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var63 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label171;
                        }
                     }

                     var63 = 0;
                  }

                  HP = (double)(200 + var63 * 20);
                  yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  pitch = Math.toRadians((double)entity.getXRot());
                  distance = (double)(7.0F + entity.getBbWidth());
                  x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
                  z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
                  if (world instanceof ServerLevel) {
                     ServerLevel _serverLevel = (ServerLevel)world;
                     Entity entityinstance = ((EntityType)JujutsucraftModEntities.FIST.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                           LivingEntity _livingEntity76 = (LivingEntity)entityinstance;
                           if (_livingEntity76.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                              _livingEntity76.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                           }
                        }

                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entityinstance;
                           _entity.setHealth((float)HP);
                        }

                        entityinstance.getPersistentData().putDouble("cnt6", 20.0 + entity.getPersistentData().getDouble("cnt6"));
                        entityinstance.getPersistentData().putDouble("speed", 0.0);
                        entityinstance.getPersistentData().putDouble("cnt1", 0.0);
                        if (entityinstance instanceof LivingEntity) {
                           LivingEntity _livingEntity87 = (LivingEntity)entityinstance;
                           if (_livingEntity87.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                              _livingEntity87.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(5.0 * CNT6);
                           }
                        }

                        _serverLevel.addFreshEntity(entityinstance);
                     }
                  }
               }

               if (entity.getPersistentData().getDouble("cnt1") < 25.0) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.0, entity.getDeltaMovement().z()));
               }
            } else {
               if (entity.getPersistentData().getDouble("cnt1") > 60.0) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }

               if (entity.onGround()) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               }
            }
         }

      }
   }
}
