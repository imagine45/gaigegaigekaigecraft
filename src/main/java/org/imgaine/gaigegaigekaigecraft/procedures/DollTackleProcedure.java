package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.function.Consumer;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.Doll1Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModEntities;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.commands.arguments.EntityAnchorArgument.Anchor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
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

public class DollTackleProcedure {
   public DollTackleProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double CNT6 = 0.0;
         double distance = 0.0;
         double size = 0.0;
         double picth = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            EntityAnchorArgument.Anchor var10001 = Anchor.EYES;
            Vec3 var10002;
            LivingEntity var10004;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10004 = _mobEnt.getTarget();
            } else {
               var10004 = null;
            }

            double var74 = ((Entity)var10004).getX();
            LivingEntity var10005;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10005 = _mobEnt.getTarget();
            } else {
               var10005 = null;
            }

            double var75 = ((Entity)var10005).getY();
            LivingEntity var10006;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var75 += (double)((Entity)var10006).getBbHeight() * 0.5;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10006 = _mobEnt.getTarget();
            } else {
               var10006 = null;
            }

            var10002 = new Vec3(var74, var75, ((Entity)var10006).getZ());
            entity.lookAt(var10001, var10002);
            entity.getPersistentData().putBoolean("PRESS_Z", false);
            if (GetDistanceNearestEnemyProcedure.execute(world, entity) > 6.0) {
               label304: {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if (((Entity)var10000).getPersistentData().getDouble("skill") != 0.0) {
                     label297: {
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
                              break label297;
                           }
                        }

                        if (entity instanceof Mob) {
                           Mob _mobEnt = (Mob)entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (((Entity)var10000).getPersistentData().getDouble("Damage") != 0.0) {
                           break label304;
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

         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            label270: {
               label269: {
                  if (entity instanceof Player) {
                     if (entity.isShiftKeyDown()) {
                        break label269;
                     }
                  } else if (Math.random() < 0.5) {
                     break label269;
                  }

                  entity.getPersistentData().putDouble("cnt7", 2.0);
                  break label270;
               }

               entity.getPersistentData().putDouble("cnt7", 1.0);
            }
         }

         if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 6, false, false));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), (int)entity.getPersistentData().getDouble("COOLDOWN_TICKS"), 0, false, false));
               }
            }

            entity.getPersistentData().putDouble("cnt6", -2.5);
         } else if (entity.getPersistentData().getDouble("cnt1") <= 1.0) {
            yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
            picth = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(picth) * -1.0 * (double)(1.0F + entity.getBbWidth());
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(picth) * (double)(1.0F + entity.getBbWidth());
            if (entity.getPersistentData().getBoolean("PRESS_Z")) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
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

               if (entity.getPersistentData().getDouble("cnt6") < 5.0) {
                  entity.getPersistentData().putDouble("cnt6", entity.getPersistentData().getDouble("cnt6") + 0.1);
                  if (entity.getPersistentData().getDouble("cnt6") > 5.0) {
                     entity.getPersistentData().putDouble("cnt6", 5.0);
                     if (world instanceof Level) {
                        Level _level = (Level)world;
                        if (!_level.isClientSide()) {
                           _level.explode((Entity)null, x_pos, y_pos, z_pos, 0.0F, ExplosionInteraction.NONE);
                        }
                     }

                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.ENCHANTED_HIT, x_pos, y_pos, z_pos, 20, 0.25, 0.25, 0.25, 1.0);
                     }
                  }

                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 2.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                  }
               }

               if (entity.getPersistentData().getDouble("cnt6") >= 5.0) {
                  ChargeParticleProcedure.execute(world, entity, 1.0);
               } else {
                  ChargeParticleProcedure.execute(world, entity, 0.0);
               }
            }
         }

         CNT6 = 1.0 + entity.getPersistentData().getDouble("cnt6") * 0.2;
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
               entity.getPersistentData().putDouble("cnt1", Math.max(entity.getPersistentData().getDouble("cnt1"), 4.0));
            }
         } else if (entity.getPersistentData().getDouble("cnt1") == 5.0) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.swing(InteractionHand.MAIN_HAND, true);
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity66 = (LivingEntity)entity;
               if (_livingEntity66.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                  _livingEntity66.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-7.0);
               }
            }

            PlayAnimationProcedure.execute(world, entity);
            if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
               entity.getPersistentData().putDouble("friend_num", Math.random());
            }

            if (entity.getPersistentData().getDouble("cnt6") < 0.0) {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F) + Mth.nextDouble(RandomSource.create(), -90.0, 90.0));
               distance = (double)(3.0F + entity.getBbWidth());
            } else {
               yaw = Math.toRadians((double)(entity.getYRot() + 90.0F));
               distance = (double)(1.0F + entity.getBbWidth());
            }

            pitch = Math.toRadians((double)entity.getXRot());
            x_pos = entity.getX() + Math.cos(yaw) * Math.cos(pitch) * distance;
            y_pos = entity.getY() + (double)entity.getBbHeight() * 0.75 + Math.sin(pitch) * -1.0 * distance;
            z_pos = entity.getZ() + Math.sin(yaw) * Math.cos(pitch) * distance;
            size = 1.5 + Math.max(entity.getPersistentData().getDouble("cnt6") * 0.5, 0.0);
            if (entity.getPersistentData().getDouble("NameRanged") == 0.0) {
               entity.getPersistentData().putDouble("NameRanged", Math.random());
            }

            if (world instanceof ServerLevel) {
               ServerLevel _serverLevel = (ServerLevel)world;
               Entity entityinstance = ((EntityType)JujutsucraftModEntities.DOLL_1.get()).create(_serverLevel, (CompoundTag)null, (Consumer)null, BlockPos.containing(x_pos, y_pos, z_pos), MobSpawnType.MOB_SUMMONED, false, false);
               if (entityinstance != null) {
                  entityinstance.setYRot(world.getRandom().nextFloat() * 360.0F);
                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity84 = (LivingEntity)entityinstance;
                     if (_livingEntity84.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                        _livingEntity84.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _livingEntity90 = (LivingEntity)entityinstance;
                     if (_livingEntity90.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                        double var71;
                        AttributeInstance var69;
                        label247: {
                           var69 = _livingEntity90.getAttribute(Attributes.ATTACK_DAMAGE);
                           if (entityinstance instanceof LivingEntity) {
                              LivingEntity _livingEntity86 = (LivingEntity)entityinstance;
                              if (_livingEntity86.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                 var71 = _livingEntity86.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                 break label247;
                              }
                           }

                           var71 = 0.0;
                        }

                        int var73;
                        label242: {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt87 = (LivingEntity)entity;
                              if (_livEnt87.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 label238: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                          var73 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                          break label238;
                                       }
                                    }

                                    var73 = 0;
                                 }

                                 ++var73;
                                 break label242;
                              }
                           }

                           var73 = 0;
                        }

                        var69.setBaseValue(var71 + (double)(1 * var73 * 3));
                     }
                  }

                  double var72;
                  CompoundTag var70;
                  label232: {
                     var70 = entityinstance.getPersistentData();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                           var72 = (double)_livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                           break label232;
                        }
                     }

                     var72 = 0.0;
                  }

                  var70.putDouble("LevelResistance", var72);
                  entityinstance.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                  entityinstance.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                  entityinstance.getPersistentData().putDouble("NameRanged_ranged", entity.getPersistentData().getDouble("NameRanged"));
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

                  entityinstance.getPersistentData().putBoolean("Player", entity instanceof Player || entity.getPersistentData().getBoolean("Player"));
                  entityinstance.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                  entityinstance.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                  if (entityinstance instanceof Doll1Entity) {
                     Doll1Entity _datEntSetI = (Doll1Entity)entityinstance;
                     _datEntSetI.getEntityData().set(Doll1Entity.DATA_move, 1);
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                     }
                  }

                  if (entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                     }
                  }

                  entityinstance.getPersistentData().putBoolean("canFly", true);
                  entityinstance.getPersistentData().putDouble("skill", 1706.0);
                  entityinstance.getPersistentData().putDouble("cnt1", 5.0);
                  entityinstance.getPersistentData().putDouble("cnt6", 0.0 + entity.getPersistentData().getDouble("cnt6"));
                  if (entity.getPersistentData().getDouble("cnt6") < 0.0 && entityinstance instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityinstance;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.HIGH_SPEED.get(), 100, 0, false, false));
                     }
                  }

                  _serverLevel.addFreshEntity(entityinstance);
               }
            }

            if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
               if ((!entity.getPersistentData().getBoolean("PRESS_Z") || !(entity.getPersistentData().getDouble("cnt8") < 20.0)) && !(entity.getPersistentData().getDouble("cnt8") < 5.0)) {
                  entity.getPersistentData().putDouble("skill", 0.0);
               } else {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  entity.getPersistentData().putDouble("cnt8", entity.getPersistentData().getDouble("cnt8") + 1.0);
                  if (entity instanceof Player) {
                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - 5.0;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower + ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange <= 0.0) {
                        entity.getPersistentData().putDouble("skill", 0.0);
                     }
                  }
               }
            }
         }

         if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
