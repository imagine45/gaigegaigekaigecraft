package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
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
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.Level.ExplosionInteraction;
import net.minecraft.world.phys.Vec3;

public class TechniqueFistProcedure {
   public TechniqueFistProcedure() {
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
         entity.getPersistentData().putDouble("cnt2", entity.getPersistentData().getDouble("cnt2") + 1.0);
         entity.fallDistance = 0.0F;
         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
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
                     label232: {
                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                           label224: {
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
                                    break label224;
                                 }
                              }

                              if (entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)entity;
                                 var10000 = _mobEnt.getTarget();
                              } else {
                                 var10000 = null;
                              }

                              if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                                 break label232;
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
               LivingEntity var61;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var61 = _mobEnt.getTarget();
               } else {
                  var61 = null;
               }

               if (var61 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var61 = _mobEnt.getTarget();
                  } else {
                     var61 = null;
                  }

                  x_pos = ((Entity)var61).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var61 = _mobEnt.getTarget();
                  } else {
                     var61 = null;
                  }

                  double var64 = ((Entity)var61).getY();
                  LivingEntity var10001;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10001 = _mobEnt.getTarget();
                  } else {
                     var10001 = null;
                  }

                  y_pos = var64 + (double)((Entity)var10001).getBbHeight() * 0.5;
                  LivingEntity var65;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var65 = _mobEnt.getTarget();
                  } else {
                     var65 = null;
                  }

                  z_pos = ((Entity)var65).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
                  entity.getPersistentData().putDouble("yaw", (double)entity.getYRot());
                  entity.getPersistentData().putDouble("pitch", (double)entity.getXRot());
               }

               if (entity.getPersistentData().getDouble("cnt3") == 0.0) {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 1.75, entity.getDeltaMovement().z()));
                  entity.getPersistentData().putDouble("cnt3", 1.0);
               } else if (entity.getDeltaMovement().y() < 0.1 || entity.getPersistentData().getDouble("cnt2") > 30.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
               }
            }
         } else {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") < 30.0 * CNT6) {
               if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.swing(InteractionHand.MAIN_HAND, true);
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity62 = (LivingEntity)entity;
                     if (_livingEntity62.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                        _livingEntity62.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(4.0);
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity63 = (LivingEntity)entity;
                     if (_livingEntity63.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                        _livingEntity63.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                     }
                  }

                  PlayAnimationProcedure.execute(world, entity);
               }

               LivingEntity var66;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var66 = _mobEnt.getTarget();
               } else {
                  var66 = null;
               }

               if (var66 instanceof LivingEntity) {
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

               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               entity.setYRot((float)yaw);
               entity.setXRot((float)Math.max(pitch, 67.5));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               int var67;
               label177: {
                  entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x(), 0.0, entity.getDeltaMovement().z()));
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var67 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label177;
                     }
                  }

                  var67 = 0;
               }

               HP = (double)(40 + var67 * 8);
               entity.getPersistentData().putDouble("x_pos", (Math.random() - 0.5) * 16.0 * CNT6);
               entity.getPersistentData().putDouble("y_pos", Math.random() * 2.0 * CNT6);
               entity.getPersistentData().putDouble("z_pos", (Math.random() - 0.5) * 16.0 * CNT6);
               x_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0 * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getPersistentData().getDouble("x_pos");
               y_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0 * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getPersistentData().getDouble("y_pos");
               z_pos = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-6.0 * CNT6)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getPersistentData().getDouble("z_pos");
               if (world instanceof ServerLevel) {
                  ServerLevel _serverLevel = (ServerLevel)world;
                  Entity entityinstance = ((EntityType)JujutsucraftModEntities.FIST.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
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
                        LivingEntity _livingEntity91 = (LivingEntity)entityinstance;
                        if (_livingEntity91.getAttributes().hasAttribute(Attributes.MAX_HEALTH)) {
                           _livingEntity91.getAttribute(Attributes.MAX_HEALTH).setBaseValue(HP);
                        }
                     }

                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entityinstance;
                        _entity.setHealth((float)HP);
                     }

                     entityinstance.getPersistentData().putDouble("cnt6", 2.5);
                     entityinstance.getPersistentData().putDouble("x_pos", entity.getPersistentData().getDouble("x_pos"));
                     entityinstance.getPersistentData().putDouble("y_pos", entity.getPersistentData().getDouble("y_pos"));
                     entityinstance.getPersistentData().putDouble("z_pos", entity.getPersistentData().getDouble("z_pos"));
                     entityinstance.getPersistentData().putDouble("speed", 0.5);
                     if (entityinstance instanceof LivingEntity) {
                        LivingEntity _livingEntity108 = (LivingEntity)entityinstance;
                        if (_livingEntity108.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                           _livingEntity108.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(2.5);
                        }
                     }

                     _serverLevel.addFreshEntity(entityinstance);
                  }
               }

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
            } else {
               if (entity.getPersistentData().getDouble("cnt1") > 30.0 * CNT6 + 30.0) {
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
