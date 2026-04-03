package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class AICursedSpiritsFlyingAttackProcedure {
   public AICursedSpiritsFlyingAttackProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double z_pos = 0.0;
         double y_pos = 0.0;
         double x_pos = 0.0;
         double y_power = 0.0;
         double x_power = 0.0;
         double dis = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double yaw_cal = 0.0;
         double pitch_cal = 0.0;
         double z_power = 0.0;
         double NUM1 = 0.0;
         String STR1 = "";
         Entity owner_entity = null;
         boolean logic_a = false;
         boolean ownerExist = false;
         boolean teleported = false;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            ownerExist = true;
            owner_entity = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
         }

         if (entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")) && entity.isAlive()) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("modement_mode") == 0.0) {
               if (entity.getPersistentData().getDouble("cnt1") > 10.0) {
                  entity.getPersistentData().putDouble("cnt1", 0.0);
                  if (ownerExist && entity.getPersistentData().getDouble("friend_num_worker") != 0.0 && entity.getPersistentData().getDouble("friend_num_worker") == owner_entity.getPersistentData().getDouble("friend_num") && entity.getPersistentData().getDouble("friend_num_worker") != owner_entity.getPersistentData().getDouble("friend_num_worker")) {
                     if (!(owner_entity instanceof Player) || !owner_entity.isShiftKeyDown()) {
                        LivingEntity var10000;
                        if (owner_entity instanceof Mob) {
                           Mob _mobEnt = (Mob)owner_entity;
                           var10000 = _mobEnt.getTarget();
                        } else {
                           var10000 = null;
                        }

                        if (!(var10000 instanceof LivingEntity) || !(owner_entity.getPersistentData().getDouble("cnt_target") > 6.0)) {
                           return;
                        }
                     }

                     if (!entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {NoAI:1b}");
                     }

                     entity.getPersistentData().putDouble("modement_mode", 1.0);
                  }
               }
            } else {
               entity.getPersistentData().putDouble("cnt_settarget", 0.0);
               if (entity.getPersistentData().getDouble("cnt1") > 1.0) {
                  if (entity.getPersistentData().getDouble("cnt1") > 2.0) {
                     yaw = (double)(entity.getYRot() % 360.0F);
                     pitch = (double)entity.getXRot();
                     RotateEntityProcedure.execute((double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX() + entity.getDeltaMovement().x() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY() + entity.getDeltaMovement().y() * 10.0, (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ() + entity.getDeltaMovement().z() * 10.0, entity);
                     entity.setYRot(entity.getYRot() % 360.0F);
                     entity.setXRot(entity.getXRot());
                     entity.setYBodyRot(entity.getYRot());
                     entity.setYHeadRot(entity.getYRot());
                     entity.yRotO = entity.getYRot();
                     entity.xRotO = entity.getXRot();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.yBodyRotO = _entity.getYRot();
                        _entity.yHeadRotO = _entity.getYRot();
                     }

                     yaw_cal = (double)entity.getYRot() - yaw;
                     yaw += Math.min(360.0 - Math.abs(yaw_cal), Math.abs(yaw_cal)) / (double)((!(yaw_cal >= 180.0) || !(yaw_cal < 360.0)) && (!(yaw_cal >= -180.0) || !(yaw_cal < 0.0)) ? 5 : -5);
                     pitch_cal = Math.abs((double)entity.getXRot() - pitch);
                     pitch += pitch_cal / (double)(pitch > (double)entity.getXRot() ? -5 : 5);
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

                  LivingEntity var96;
                  if (entity instanceof Mob) {
                     Mob _mobEnt = (Mob)entity;
                     var96 = _mobEnt.getTarget();
                  } else {
                     var96 = null;
                  }

                  if (var96 instanceof LivingEntity && entity.getPersistentData().getDouble("cnt_target") > 6.0) {
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var96 = _mobEnt.getTarget();
                     } else {
                        var96 = null;
                     }

                     Level var105 = ((Entity)var96).level();
                     ClipContext var113;
                     LivingEntity var122;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var122 = _mobEnt.getTarget();
                     } else {
                        var122 = null;
                     }

                     Vec3 var123 = ((Entity)var122).getEyePosition(1.0F);
                     LivingEntity var136;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var136 = _mobEnt.getTarget();
                     } else {
                        var136 = null;
                     }

                     Vec3 var137 = ((Entity)var136).getEyePosition(1.0F);
                     LivingEntity var150;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var150 = _mobEnt.getTarget();
                     } else {
                        var150 = null;
                     }

                     var137 = var137.add(((Entity)var150).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var151 = Block.OUTLINE;
                     ClipContext.Fluid var158 = Fluid.NONE;
                     LivingEntity var163;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.getTarget();
                     } else {
                        var163 = null;
                     }

                     var113 = new ClipContext(var123, var137, var151, var158, var163);
                     x_pos = (double)var105.clip(var113).getBlockPos().getX();
                     LivingEntity var106;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var106 = _mobEnt.getTarget();
                     } else {
                        var106 = null;
                     }

                     Level var107 = ((Entity)var106).level();
                     LivingEntity var124;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var124 = _mobEnt.getTarget();
                     } else {
                        var124 = null;
                     }

                     Vec3 var125 = ((Entity)var124).getEyePosition(1.0F);
                     LivingEntity var139;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var139 = _mobEnt.getTarget();
                     } else {
                        var139 = null;
                     }

                     Vec3 var140 = ((Entity)var139).getEyePosition(1.0F);
                     LivingEntity var152;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var152 = _mobEnt.getTarget();
                     } else {
                        var152 = null;
                     }

                     var140 = var140.add(((Entity)var152).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var153 = Block.OUTLINE;
                     var158 = Fluid.NONE;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.getTarget();
                     } else {
                        var163 = null;
                     }

                     var113 = new ClipContext(var125, var140, var153, var158, var163);
                     y_pos = (double)var107.clip(var113).getBlockPos().getY();
                     LivingEntity var108;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var108 = _mobEnt.getTarget();
                     } else {
                        var108 = null;
                     }

                     Level var109 = ((Entity)var108).level();
                     LivingEntity var126;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var126 = _mobEnt.getTarget();
                     } else {
                        var126 = null;
                     }

                     Vec3 var127 = ((Entity)var126).getEyePosition(1.0F);
                     LivingEntity var142;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var142 = _mobEnt.getTarget();
                     } else {
                        var142 = null;
                     }

                     Vec3 var143 = ((Entity)var142).getEyePosition(1.0F);
                     LivingEntity var154;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var154 = _mobEnt.getTarget();
                     } else {
                        var154 = null;
                     }

                     var143 = var143.add(((Entity)var154).getViewVector(1.0F).scale(0.0));
                     ClipContext.Block var155 = Block.OUTLINE;
                     var158 = Fluid.NONE;
                     if (entity instanceof Mob) {
                        Mob _mobEnt = (Mob)entity;
                        var163 = _mobEnt.getTarget();
                     } else {
                        var163 = null;
                     }

                     var113 = new ClipContext(var127, var143, var155, var158, var163);
                     z_pos = (double)var109.clip(var113).getBlockPos().getZ();
                  } else {
                     entity.getPersistentData().putDouble("cnt_target", 0.0);
                     if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0) {
                        logic_a = false;
                        Vec3 _center = new Vec3(x, y, z);

                        for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(6.0), (e) -> true)) {
                           if (entity != entityiterator && LogicAttackProcedure.execute(world, entity, entityiterator)) {
                              logic_a = true;
                              x_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getX();
                              y_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getY();
                              z_pos = (double)entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1.0F), entityiterator.getEyePosition(1.0F).add(entityiterator.getViewVector(1.0F).scale(0.0)), Block.OUTLINE, Fluid.NONE, entityiterator)).getBlockPos().getZ();
                              break;
                           }
                        }

                        if (!logic_a && ownerExist && entity.getPersistentData().getDouble("friend_num_worker") == owner_entity.getPersistentData().getDouble("friend_num") && entity.getPersistentData().getDouble("friend_num_worker") != owner_entity.getPersistentData().getDouble("friend_num_worker")) {
                           if (owner_entity instanceof Mob) {
                              Mob _mobEnt = (Mob)owner_entity;
                              var96 = _mobEnt.getTarget();
                           } else {
                              var96 = null;
                           }

                           if (var96 instanceof LivingEntity) {
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var96 = _mobEnt.getTarget();
                              } else {
                                 var96 = null;
                              }

                              Level var99 = ((Entity)var96).level();
                              ClipContext var10001;
                              LivingEntity var10003;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10003 = _mobEnt.getTarget();
                              } else {
                                 var10003 = null;
                              }

                              Vec3 var117 = ((Entity)var10003).getEyePosition(1.0F);
                              LivingEntity var10004;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10004 = _mobEnt.getTarget();
                              } else {
                                 var10004 = null;
                              }

                              Vec3 var128 = ((Entity)var10004).getEyePosition(1.0F);
                              LivingEntity var10005;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10005 = _mobEnt.getTarget();
                              } else {
                                 var10005 = null;
                              }

                              var128 = var128.add(((Entity)var10005).getViewVector(1.0F).scale(0.0));
                              ClipContext.Block var145 = Block.COLLIDER;
                              ClipContext.Fluid var10006 = Fluid.NONE;
                              LivingEntity var10007;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.getTarget();
                              } else {
                                 var10007 = null;
                              }

                              var10001 = new ClipContext(var117, var128, var145, var10006, var10007);
                              x_pos = (double)var99.clip(var10001).getBlockPos().getX();
                              LivingEntity var100;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var100 = _mobEnt.getTarget();
                              } else {
                                 var100 = null;
                              }

                              Level var101 = ((Entity)var100).level();
                              LivingEntity var118;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var118 = _mobEnt.getTarget();
                              } else {
                                 var118 = null;
                              }

                              Vec3 var119 = ((Entity)var118).getEyePosition(1.0F);
                              LivingEntity var130;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var130 = _mobEnt.getTarget();
                              } else {
                                 var130 = null;
                              }

                              Vec3 var131 = ((Entity)var130).getEyePosition(1.0F);
                              LivingEntity var146;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var146 = _mobEnt.getTarget();
                              } else {
                                 var146 = null;
                              }

                              var131 = var131.add(((Entity)var146).getViewVector(1.0F).scale(0.0));
                              ClipContext.Block var147 = Block.COLLIDER;
                              var10006 = Fluid.NONE;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.getTarget();
                              } else {
                                 var10007 = null;
                              }

                              var10001 = new ClipContext(var119, var131, var147, var10006, var10007);
                              y_pos = (double)var101.clip(var10001).getBlockPos().getY();
                              LivingEntity var102;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var102 = _mobEnt.getTarget();
                              } else {
                                 var102 = null;
                              }

                              Level var103 = ((Entity)var102).level();
                              LivingEntity var120;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var120 = _mobEnt.getTarget();
                              } else {
                                 var120 = null;
                              }

                              Vec3 var121 = ((Entity)var120).getEyePosition(1.0F);
                              LivingEntity var133;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var133 = _mobEnt.getTarget();
                              } else {
                                 var133 = null;
                              }

                              Vec3 var134 = ((Entity)var133).getEyePosition(1.0F);
                              LivingEntity var148;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var148 = _mobEnt.getTarget();
                              } else {
                                 var148 = null;
                              }

                              var134 = var134.add(((Entity)var148).getViewVector(1.0F).scale(0.0));
                              ClipContext.Block var149 = Block.COLLIDER;
                              var10006 = Fluid.NONE;
                              if (owner_entity instanceof Mob) {
                                 Mob _mobEnt = (Mob)owner_entity;
                                 var10007 = _mobEnt.getTarget();
                              } else {
                                 var10007 = null;
                              }

                              var10001 = new ClipContext(var121, var134, var149, var10006, var10007);
                              z_pos = (double)var103.clip(var10001).getBlockPos().getZ();
                           } else {
                              x_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getX();
                              y_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getY();
                              z_pos = (double)owner_entity.level().clip(new ClipContext(owner_entity.getEyePosition(1.0F), owner_entity.getEyePosition(1.0F).add(owner_entity.getViewVector(1.0F).scale(64.0)), Block.COLLIDER, Fluid.NONE, owner_entity)).getBlockPos().getZ();
                           }
                        }
                     }
                  }

                  entity.getPersistentData().putBoolean("free", true);
                  GetPowerForwardProcedure.execute(x_pos, y_pos, z_pos, entity);
                  x_power = entity.getDeltaMovement().x() + (entity.getDeltaMovement().x() > entity.getPersistentData().getDouble("x_power") * 0.4 ? -0.075 : 0.075);
                  y_power = entity.getDeltaMovement().y() + (entity.getDeltaMovement().y() > entity.getPersistentData().getDouble("y_power") * 0.4 ? -0.075 : 0.075);
                  z_power = entity.getDeltaMovement().z() + (entity.getDeltaMovement().z() > entity.getPersistentData().getDouble("z_power") * 0.4 ? -0.075 : 0.075);
                  if (entity.getPersistentData().getBoolean("Stop")) {
                     entity.getPersistentData().putBoolean("Stop", false);
                  } else {
                     entity.setDeltaMovement(new Vec3(x_power, y_power, z_power));
                     entity.teleportTo(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power);
                     if (entity instanceof ServerPlayer) {
                        ServerPlayer _serverPlayer = (ServerPlayer)entity;
                        _serverPlayer.connection.teleport(entity.getX() + x_power, entity.getY() + y_power, entity.getZ() + z_power, entity.getYRot(), entity.getXRot());
                     }
                  }

                  x_pos = entity.getX();
                  y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  z_pos = entity.getZ();
                  entity.getPersistentData().putDouble("Damage", 9.0);
                  entity.getPersistentData().putDouble("knockback", Math.random() * 1.0);
                  entity.getPersistentData().putDouble("Range", (double)(entity.getBbWidth() * 2.0F));
                  entity.getPersistentData().putDouble("effect", 1.0);
                  RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
                  if (entity.getPersistentData().getDouble("cnt1") >= 50.0) {
                     teleported = false;
                     entity.getPersistentData().putDouble("cnt1", 0.0);
                     entity.getPersistentData().putDouble("cnt2", 0.0);
                     entity.getPersistentData().putDouble("modement_mode", 0.0);
                     if (entity.getPersistentData().getDouble("friend_num_worker") != 0.0 && ownerExist && owner_entity instanceof Player) {
                        teleported = true;
                        x_pos = 0.0;
                        y_pos = 64.0 + Math.random();
                        z_pos = 0.0;
                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           Commands var110 = entity.getServer().getCommands();
                           CommandSourceStack var116 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                           long var10002 = Math.round(x_pos);
                           var110.performPrefixedCommand(var116, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
                        }

                        NUM1 = 0.0;

                        for(int index0 = 0; index0 < 10000; ++index0) {
                           ++NUM1;
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                           if (owner_entity.getPersistentData().getString(STR1 + "_name").equals(entity.getDisplayName().getString())) {
                              y_pos = owner_entity.getPersistentData().getDouble(STR1);
                              break;
                           }

                           if (owner_entity.getPersistentData().getDouble(STR1) == 0.0) {
                              owner_entity.getPersistentData().putDouble(STR1, y_pos);
                              owner_entity.getPersistentData().putString(STR1 + "_name", entity.getDisplayName().getString());
                              break;
                           }
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "data merge entity @s {Invulnerable:1b,PersistenceRequired:1b,NoAI:1b}");
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run tp @s " + x_pos + " " + y_pos + " " + z_pos);
                        }

                        owner_entity.getPersistentData().putDouble(STR1 + "_num", owner_entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                        owner_entity.getPersistentData().putBoolean("UpdateSkills", true);
                     }

                     if (!teleported && !entity.level().isClientSide()) {
                        entity.discard();
                     }
                  }
               }
            }
         }

      }
   }
}
