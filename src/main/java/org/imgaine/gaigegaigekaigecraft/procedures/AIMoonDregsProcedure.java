package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AIMoonDregsProcedure {
   public AIMoonDregsProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_infinity = false;
         Entity entity_a = null;
         Entity owner_uuid = null;
         double x_target = 0.0;
         double NUM2 = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double velocity = 0.0;
         double yaw = 0.0;
         double NUM1 = 0.0;
         double dis = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity.isAlive()) {
            label322: {
               AIActiveProcedure.execute(world, x, y, z, entity);
               entity.fallDistance = 0.0F;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get())) {
                     break label322;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 60, 1, false, false));
                  }
               }
            }

            if (entity.isVehicle() && entity.getFirstPassenger() instanceof LivingEntity) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2, 2, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }

               Entity _passentity = entity.getFirstPassenger();
               if (_passentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_passentity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2, 4, false, false));
                  }
               }

               _passentity = entity.getFirstPassenger();
               if (_passentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_passentity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 2, 0, false, false));
                  }
               }

               _passentity = entity.getFirstPassenger();
               if (_passentity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)_passentity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 2, 0, false, false));
                  }
               }
            }

            double var10001;
            label316: {
               NUM1 = (double)(2L + Math.round(entity.getPersistentData().getDouble("Strength") * 0.5));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity17 = (LivingEntity)entity;
                  if (_livingEntity17.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                     var10001 = _livingEntity17.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                     break label316;
                  }
               }

               var10001 = 0.0;
            }

            label311: {
               NUM2 = (double)Math.round(Math.floor(Math.min((NUM1 + var10001 * 3.0) / 4.0, 3.0)));
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt18 = (LivingEntity)entity;
                  if (_livEnt18.hasEffect(MobEffects.DAMAGE_BOOST)) {
                     break label311;
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 2147483647, (int)NUM1, false, false));
                  }
               }
            }

            int var10000;
            label306: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
                     var10000 = _livEnt.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier();
                     break label306;
                  }
               }

               var10000 = 0;
            }

            if ((double)var10000 < NUM2 && entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 2147483647, (int)NUM2, false, false));
               }
            }

            if (entity.getPersistentData().getDouble("skill") > 100.0) {
               LivingEntity var91;
               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var91 = _mobEnt.getTarget();
               } else {
                  var91 = null;
               }

               if (var91 instanceof LivingEntity) {
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.getTarget();
                  } else {
                     var91 = null;
                  }

                  x_pos = ((Entity)var91).getX();
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var91 = _mobEnt.getTarget();
                  } else {
                     var91 = null;
                  }

                  double var94 = ((Entity)var91).getY();
                  LivingEntity var98;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var98 = _mobEnt.getTarget();
                  } else {
                     var98 = null;
                  }

                  y_pos = var94 + (double)((Entity)var98).getBbHeight() * 0.5;
                  LivingEntity var95;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var95 = _mobEnt.getTarget();
                  } else {
                     var95 = null;
                  }

                  z_pos = ((Entity)var95).getZ();
                  RotateEntityProcedure.execute(x_pos, y_pos, z_pos, entity);
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (!entity.isVehicle()) {
                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.getTarget();
                  } else {
                     var96 = null;
                  }

                  if (var96 instanceof LivingEntity) {
                     entity.getPersistentData().putDouble("cnt_x", entity.getPersistentData().getDouble("cnt_x") + 1.0);
                     if (entity.getPersistentData().getDouble("cnt_x") > 10.0 && entity.getPersistentData().getDouble("skill") == 0.0) {
                        entity.getPersistentData().putDouble("cnt_x", 0.0);
                        ResetCounterProcedure.execute(entity);
                        CalculateAttackProcedure.execute(world, entity);
                     }
                  } else {
                     entity.getPersistentData().putDouble("cnt_x", 0.0);
                  }

                  if (entity.getPersistentData().getDouble("skill") == 0.0 && entity.getPersistentData().getDouble("friend_num") != 0.0 && LogicOwnerExistProcedure.execute(world, entity)) {
                     entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                     if (entity.getPersistentData().getDouble("friend_num") == entity_a.getPersistentData().getDouble("friend_num")) {
                        logic_a = true;
                        yaw = (double)entity_a.getYRot();
                        pitch = (double)entity_a.getXRot();
                        x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + (double)(entity_a.isShiftKeyDown() ? 90 : 30))) * 3.0 * (double)(entity_a.isShiftKeyDown() ? 1 : -1);
                        y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.5 + (entity_a.isShiftKeyDown() ? Math.sin(pitch) * -1.0 - 0.5 : 0.5);
                        z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + (double)(entity_a.isShiftKeyDown() ? 90 : 30))) * 3.0 * (double)(entity_a.isShiftKeyDown() ? 1 : -1);
                        if (entity_a.isShiftKeyDown()) {
                           Vec3 _center = new Vec3(x, y + (double)(entity.getBbHeight() / 2.0F), z);

                           for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate((double)(2.0F + entity.getBbWidth()) / 2.0), (e) -> true)) {
                              if (entity != entityiterator) {
                                 velocity = 0.0;
                                 x_power = 0.0;
                                 y_power = 0.0;
                                 z_power = 0.0;
                                 logic_infinity = false;
                                 double var97;
                                 if (entityiterator instanceof Projectile) {
                                    Projectile _projEnt = (Projectile)entityiterator;
                                    var97 = _projEnt.getDeltaMovement().length();
                                 } else {
                                    var97 = 0.0;
                                 }

                                 if (var97 > 0.0) {
                                    logic_infinity = false;
                                    velocity = Math.sqrt(Math.pow(entityiterator.getDeltaMovement().x(), 2.0) + Math.pow(entityiterator.getDeltaMovement().y(), 2.0) + Math.pow(entityiterator.getDeltaMovement().z(), 2.0));
                                    if (velocity > 0.0) {
                                       x_power = entityiterator.getDeltaMovement().x() / velocity;
                                       y_power = entityiterator.getDeltaMovement().y() / velocity;
                                       z_power = entityiterator.getDeltaMovement().z() / velocity;
                                       dis = Math.sqrt(Math.pow(entityiterator.getX() - entity.getX(), 2.0) + Math.pow(entityiterator.getY() - entity.getY(), 2.0) + Math.pow(entityiterator.getZ() - entity.getZ(), 2.0));
                                       if (dis > Math.sqrt(Math.pow(entityiterator.getX() + x_power * 0.001 - entity.getX(), 2.0) + Math.pow(entityiterator.getY() + y_power * 0.001 - entity.getY(), 2.0) + Math.pow(entityiterator.getZ() + z_power * 0.001 - entity.getZ(), 2.0))) {
                                          logic_infinity = true;
                                       }
                                    }
                                 }

                                 if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo")))) {
                                    logic_infinity = true;
                                    if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && (entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged") || entity.getPersistentData().getDouble("NameRanged_ranged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged"))) {
                                       logic_infinity = false;
                                    }

                                    if (entity.getPersistentData().getDouble("NameRanged") != 0.0 && (entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged_ranged") || entity.getPersistentData().getDouble("NameRanged") == entityiterator.getPersistentData().getDouble("NameRanged"))) {
                                       logic_infinity = false;
                                    }
                                 }

                                 if (logic_infinity) {
                                    if (!entity.getPersistentData().getBoolean("Stop")) {
                                       entityiterator.getPersistentData().putBoolean("Stop", true);
                                    }

                                    if (velocity > 0.0) {
                                       entityiterator.setDeltaMovement(new Vec3(x_power * 0.01, 0.0, z_power * 0.01));
                                    } else {
                                       entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                                    }
                                 }
                              }
                           }
                        }

                        if (Math.abs(x_target - entity.getX()) > 0.5) {
                           x_target = entity.getX() + (entity.getX() > x_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(y_target - entity.getY()) > 0.5) {
                           y_target = entity.getY() + (entity.getY() > y_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(z_target - entity.getZ()) > 0.5) {
                           z_target = entity.getZ() + (entity.getZ() > z_target ? -0.5 : 0.5);
                        }

                        entity.teleportTo(x_target, y_target, z_target);
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _serverPlayer = (ServerPlayer)entity;
                           _serverPlayer.connection.teleport(x_target, y_target, z_target, entity.getYRot(), entity.getXRot());
                        }

                        entity.setDeltaMovement(new Vec3(entity_a.getDeltaMovement().x(), entity_a.onGround() ? 0.0 : entity_a.getDeltaMovement().y(), entity_a.getDeltaMovement().z()));
                        entity.setYRot(entity_a.getYRot());
                        entity.setXRot(entity_a.getXRot());
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
                  }
               }
            } else {
               AIMoonDregsMove1Procedure.execute(world, entity);
            }
         }

         if (LogicOwnerExistProcedure.execute(world, entity)) {
            owner_uuid = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            if (owner_uuid instanceof LivingEntity) {
               if (!owner_uuid.isAlive() && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
            }
         } else if (entity.getPersistentData().getDouble("friend_num") != 0.0 && !entity.level().isClientSide() && entity.getServer() != null) {
            entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
         }

      }
   }
}
