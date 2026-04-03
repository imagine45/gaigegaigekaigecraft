package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AILiquidMetalProcedure {
   public AILiquidMetalProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean logic_a = false;
         boolean LogicOwner = false;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_target = 0.0;
         double x_power = 0.0;
         double pitch = 0.0;
         double y_target = 0.0;
         double z_target = 0.0;
         double yaw = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double degree = 0.0;
         double height = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, 3, false, false));
               }
            }

            LogicOwner = LogicOwnerExistProcedure.execute(world, entity);
            if (!LogicOwner) {
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            } else {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0 && entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                  int var10000;
                  label209: {
                     if (entity_a instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity_a;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label209;
                        }
                     }

                     var10000 = 0;
                  }

                  int var10001;
                  label204: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10001 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label204;
                        }
                     }

                     var10001 = 0;
                  }

                  if (var10000 > var10001 && entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        MobEffect var10003;
                        int var10005;
                        MobEffectInstance var67;
                        label197: {
                           var10003 = MobEffects.DAMAGE_BOOST;
                           if (entity_a instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity_a;
                              if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                 var10005 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                 break label197;
                              }
                           }

                           var10005 = 0;
                        }

                        var67 = new MobEffectInstance(var10003, 2147483647, var10005, false, false);
                        _entity.addEffect(var67);
                     }
                  }

                  float var66;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var66 = _livEnt.getHealth();
                  } else {
                     var66 = -1.0F;
                  }

                  float var68;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     var68 = _livEnt.getMaxHealth();
                  } else {
                     var68 = -1.0F;
                  }

                  if (var66 < var68) {
                     label233: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt13 = (LivingEntity)entity;
                           if (_livEnt13.hasEffect(MobEffects.REGENERATION)) {
                              break label233;
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 51, 0, false, false));
                           }
                        }
                     }
                  }

                  if (entity_a instanceof LivingEntity) {
                     LivingEntity _livEnt15 = (LivingEntity)entity_a;
                     if (_livEnt15.hasEffect((MobEffect)JujutsucraftModMobEffects.UNSTABLE.get()) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                     }
                  }

                  if (entity_a instanceof Player && ((JujutsucraftModVariables.PlayerVariables)entity_a.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower < 1.0 && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
                  }
               }

               x_pos = entity.getX();
               y_pos = entity.getY() + (double)(entity.getBbHeight() * 0.0F);
               z_pos = entity.getZ();
               if (entity.getPersistentData().getDouble("NameRanged_ranged") != 0.0) {
                  entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
                  if (entity.getPersistentData().getDouble("NameRanged_ranged") == entity_a.getPersistentData().getDouble("NameRanged")) {
                     logic_a = true;
                     yaw = (double)entity_a.getYRot();
                     pitch = (double)entity_a.getXRot();
                     x_power = entity.getX();
                     y_power = entity.getY();
                     z_power = entity.getZ();
                     if (entity.getPersistentData().getDouble("move") == 0.0) {
                        dis = 3.0;
                        degree = 60.0;
                        height = 0.0;
                     } else if (entity.getPersistentData().getDouble("move") == 1.0) {
                        dis = 5.0;
                        degree = 0.0;
                        height = 1.0;
                     }

                     if (entity.getPersistentData().getDouble("move") != 1.0) {
                        x_target = entity_a.getX() + Math.cos(Math.toRadians(yaw + 90.0 + degree)) * dis;
                        y_target = entity_a.getY() + (double)entity_a.getBbHeight() * 0.25 + height;
                        z_target = entity_a.getZ() + Math.sin(Math.toRadians(yaw + 90.0 + degree)) * dis;
                        if (Math.abs(x_target - x_power) > 0.5) {
                           x_target = x_power + (x_power > x_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(y_target - y_power) > 0.5) {
                           y_target = y_power + (y_power > y_target ? -0.5 : 0.5);
                        }

                        if (Math.abs(z_target - z_power) > 0.5) {
                           z_target = z_power + (z_power > z_target ? -0.5 : 0.5);
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

               if (!logic_a && !entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "kill @s");
               }
            }

            if (entity.getPersistentData().getDouble("move") == 1.0) {
               AILiquidArrowProcedure.execute(world, x, y, z, entity);
            } else {
               logic_a = true;
               if (entity_a instanceof LivingEntity && entity_a.getPersistentData().getDouble("skill") == 3910.0) {
                  logic_a = false;
               }

               if (logic_a && world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.getBbHeight() * 0.5, z, (int)(ReturnEntitySizeProcedure.execute(entity) * 5.0), (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 0.0);
               }

               ResetCounterProcedure.execute(entity);
            }
         } else {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_LIQUID_METAL.get(), x, y + (double)entity.getBbHeight() * 0.5, z, (int)(ReturnEntitySizeProcedure.execute(entity) * 25.0), (double)entity.getBbWidth() * 0.5, (double)entity.getBbHeight() * 0.5, (double)entity.getBbWidth() * 0.5, 1.0);
            }

            if (!entity.level().isClientSide()) {
               entity.discard();
            }
         }

      }
   }
}
