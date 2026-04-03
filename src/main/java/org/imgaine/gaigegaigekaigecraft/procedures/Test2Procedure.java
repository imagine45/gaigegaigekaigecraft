package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class Test2Procedure {
   public Test2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean Player = false;
         boolean logic_b = false;
         boolean logic_a = false;
         String STR2 = "";
         String STR1 = "";
         String DimensionID = "";
         double SpawnedStrength = 0.0;
         double NUM2 = 0.0;
         double x_pos = 0.0;
         double z_pos = 0.0;
         double spawn_z = 0.0;
         double yaw = 0.0;
         double spawn_x = 0.0;
         double NUM1 = 0.0;
         double spawn_y = 0.0;
         double level_strength = 0.0;
         double pitch = 0.0;
         double y_pos = 0.0;
         double level_strength2 = 0.0;
         double speed = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         if (entity.getPersistentData().getDouble("data_cursed_spirit_manipulation1") != 0.0 && entity.level().dimension() != ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension"))) {
            entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
            if (entity.getPersistentData().getDouble("cnt1") > 0.0) {
               entity.getPersistentData().putDouble("cnt1", 0.0);
               if (entity.getPersistentData().getDouble("friend_num") == 0.0) {
                  entity.getPersistentData().putDouble("friend_num", Math.random());
               }

               x_pos = 0.0;
               z_pos = 0.0;
               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  Commands var10000 = entity.getServer().getCommands();
                  CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
                  long var10002 = Math.round(x_pos);
                  var10000.performPrefixedCommand(var10001, "execute in gaigegaigekaigecraft:cursed_spirit_manipulation_dimension run forceload add " + var10002 + " " + Math.round(z_pos) + " " + Math.round(x_pos) + " " + Math.round(z_pos));
               }

               DimensionID = ("" + String.valueOf(entity.level().dimension())).replace("ResourceKey[minecraft:dimension / ", "").replace("]", "");
               Player = entity instanceof Player;
               yaw = (double)entity.getYRot();
               pitch = (double)entity.getXRot();
               NUM1 = 0.0;
               entity.setYRot((float)(yaw + (Math.random() - 0.5) * 45.0));
               entity.setXRot((float)Math.min(pitch, 0.0));
               entity.setYBodyRot(entity.getYRot());
               entity.setYHeadRot(entity.getYRot());
               entity.yRotO = entity.getYRot();
               entity.xRotO = entity.getXRot();
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.yBodyRotO = _entity.getYRot();
                  _entity.yHeadRotO = _entity.getYRot();
               }

               if (entity.isShiftKeyDown()) {
                  spawn_x = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                  spawn_y = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                  spawn_z = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(-5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               } else {
                  spawn_x = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getX();
                  spawn_y = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getY();
                  spawn_z = (double)entity.level().clip(new ClipContext(entity.getEyePosition(1.0F), entity.getEyePosition(1.0F).add(entity.getViewVector(1.0F).scale(5.0)), Block.OUTLINE, Fluid.NONE, entity)).getBlockPos().getZ();
               }

               speed = 6.5;

               for(int index0 = 0; index0 < 10000; ++index0) {
                  ++NUM1;
                  STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM1);
                  SpawnedStrength = 0.0;
                  if (entity.getPersistentData().getDouble(STR1) == 0.0) {
                     break;
                  }

                  String var94 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueName;
                  String var102 = entity.getPersistentData().getString(STR1 + "_name");
                  if (var94.equals(var102 + " ×" + Math.round(entity.getPersistentData().getDouble(STR1 + "_num")))) {
                     int var96;
                     label231: {
                        y_pos = entity.getPersistentData().getDouble(STR1);
                        logic_a = false;
                        logic_b = false;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt28 = (LivingEntity)entity;
                           if (_livEnt28.hasEffect(MobEffects.DAMAGE_BOOST)) {
                              label226: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                       var96 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                       break label226;
                                    }
                                 }

                                 var96 = 0;
                              }

                              ++var96;
                              break label231;
                           }
                        }

                        var96 = 0;
                     }

                     level_strength = (double)var96;
                     if (world instanceof ServerLevel) {
                        ServerLevel _origLevel = (ServerLevel)world;
                        LevelAccessor var58 = _origLevel.getServer().getLevel(ResourceKey.create(Registries.DIMENSION, new ResourceLocation("gaigegaigekaigecraft:cursed_spirit_manipulation_dimension")));
                        if (var58 != null) {
                           Vec3 _center = new Vec3(x_pos, y_pos, z_pos);

                           for(Entity entityiterator : var58.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(0.5), (e) -> true)) {
                              if (entity != entityiterator && entity.getPersistentData().getString(STR1 + "_name").equals(entityiterator.getDisplayName().getString()) && entityiterator.isAlive() && entity.getPersistentData().getDouble("friend_num") == entityiterator.getPersistentData().getDouble("friend_num_worker")) {
                                 if (!logic_a) {
                                    logic_a = true;
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity36 = (LivingEntity)entity;
                                       if (_livingEntity36.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                          int var98;
                                          label207: {
                                             if (entityiterator instanceof LivingEntity) {
                                                LivingEntity _livEnt37 = (LivingEntity)entityiterator;
                                                if (_livEnt37.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                   label203: {
                                                      if (entityiterator instanceof LivingEntity) {
                                                         LivingEntity _livEnt = (LivingEntity)entityiterator;
                                                         if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                                            var98 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                                            break label203;
                                                         }
                                                      }

                                                      var98 = 0;
                                                   }

                                                   ++var98;
                                                   break label207;
                                                }
                                             }

                                             var98 = 0;
                                          }

                                          level_strength2 = (double)var98;
                                          if (entityiterator instanceof LivingEntity) {
                                             LivingEntity _livingEntity40 = (LivingEntity)entityiterator;
                                             if (_livingEntity40.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                                AttributeInstance var99;
                                                double var103;
                                                label195: {
                                                   var99 = _livingEntity40.getAttribute(Attributes.ATTACK_DAMAGE);
                                                   if (entityiterator instanceof LivingEntity) {
                                                      LivingEntity _livingEntity39 = (LivingEntity)entityiterator;
                                                      if (_livingEntity39.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE)) {
                                                         var103 = _livingEntity39.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();
                                                         break label195;
                                                      }
                                                   }

                                                   var103 = 0.0;
                                                }

                                                var99.setBaseValue(Math.max(var103, level_strength * 3.0 * 0.5 * ((Math.max(level_strength * 3.0, 1.0) - Math.max(level_strength2 * 3.0, 1.0)) / Math.max(level_strength * 3.0, 1.0))));
                                             }
                                          }
                                       }
                                    }
                                    int var100;
                                    label190: {
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var100 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label190;
                                          }
                                       }

                                       var100 = 0;
                                    }

                                    if (var100 >= 8) {
                                       entity.getPersistentData().putDouble("cnt1", -5.0);
                                    }

                                    entityiterator.getPersistentData().putDouble("cnt_target", 0.0);
                                    entityiterator.getPersistentData().putDouble("modement_mode", 0.0);
                                    entityiterator.getPersistentData().putDouble("cnt_settarget", 0.0);
                                    entityiterator.getPersistentData().putBoolean("JujutsuSorcerer", entity.getPersistentData().getBoolean("JujutsuSorcerer"));
                                    entityiterator.getPersistentData().putBoolean("CurseUser", entity.getPersistentData().getBoolean("CurseUser"));
                                    entityiterator.getPersistentData().putBoolean("Player", Player);
                                    entityiterator.getPersistentData().putString("OWNER_UUID", entity.getStringUUID());
                                    entityiterator.getPersistentData().putString("TARGET_UUID", "");
                                    entityiterator.getPersistentData().putDouble("friend_num", entity.getPersistentData().getDouble("friend_num"));
                                    entityiterator.getPersistentData().putDouble("friend_num_worker", entity.getPersistentData().getDouble("friend_num"));
                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "data merge entity @s {Invulnerable:0b,NoAI:0b}");
                                    }

                                    entityiterator.setYRot((float)yaw);
                                    entityiterator.setXRot((float)pitch);
                                    entityiterator.setYBodyRot(entityiterator.getYRot());
                                    entityiterator.setYHeadRot(entityiterator.getYRot());
                                    entityiterator.yRotO = entityiterator.getYRot();
                                    entityiterator.xRotO = entityiterator.getXRot();
                                    if (entityiterator instanceof LivingEntity) {
                                       LivingEntity _entity = (LivingEntity)entityiterator;
                                       _entity.yBodyRotO = _entity.getYRot();
                                       _entity.yHeadRotO = _entity.getYRot();
                                    }
                                    double var101;
                                    label181: {
                                       entityiterator.push(0.0, 0.0, 0.0);
                                       entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
                                       entity.getPersistentData().putDouble(STR1 + "_num", 0.0);
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entityiterator;
                                          if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                                             var101 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                                             break label181;
                                          }
                                       }

                                       var101 = 0.0;
                                    }

                                    SpawnedStrength = var101;
                                    if (entityiterator instanceof CursedSpiritGrade13Entity || entityiterator instanceof CursedSpiritGrade23Entity) {
                                       ResetCounterProcedure.execute(entityiterator);
                                       entityiterator.push(entityiterator.getLookAngle().x * speed, entityiterator.getLookAngle().y * speed, entityiterator.getLookAngle().z * speed);
                                       entityiterator.setDeltaMovement(new Vec3(entityiterator.getLookAngle().x * speed, entityiterator.getLookAngle().y * speed, entityiterator.getLookAngle().z * speed));
                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 50, 0, false, false));
                                          }
                                       }

                                       if (entityiterator instanceof LivingEntity) {
                                          LivingEntity _entity = (LivingEntity)entityiterator;
                                          if (!_entity.level().isClientSide()) {
                                             _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
                                          }
                                       }

                                       entityiterator.getPersistentData().putDouble("skill", 1706.0);
                                       entityiterator.getPersistentData().putDouble("cnt1", 6.0);
                                       entityiterator.getPersistentData().putDouble("cnt6", -2.5);
                                       entityiterator.getPersistentData().putDouble("yaw", (double)entityiterator.getYRot());
                                       entityiterator.getPersistentData().putDouble("pitch", (double)entityiterator.getXRot());
                                       entityiterator.getPersistentData().putDouble("x_power", entityiterator.getLookAngle().x * speed * 0.5);
                                       entityiterator.getPersistentData().putDouble("y_power", entityiterator.getLookAngle().y * speed * 0.5);
                                       entityiterator.getPersistentData().putDouble("z_power", entityiterator.getLookAngle().z * speed * 0.5);
                                    }

                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "execute in " + DimensionID + " run tp @s " + spawn_x + " " + spawn_y + " " + spawn_z);
                                    }

                                    if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
                                       entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "execute in " + DimensionID + " run particle squid_ink " + spawn_x + " " + spawn_y + " " + spawn_z + " 0.5 0.5 0.5 0 25 normal");
                                    }
                                 } else {
                                    entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR1 + "_num") + 1.0);
                                 }
                              }
                           }
                        }

                        world = world;
                     }

                     if (entity.getPersistentData().getDouble(STR1 + "_num") == 0.0) {
                        NUM2 = NUM1;

                        for(int index1 = 0; index1 < 10000; ++index1) {
                           STR1 = "data_cursed_spirit_manipulation" + Math.round(NUM2);
                           STR2 = "data_cursed_spirit_manipulation" + Math.round(NUM2 + 1.0);
                           entity.getPersistentData().putDouble(STR1, entity.getPersistentData().getDouble(STR2));
                           entity.getPersistentData().putDouble(STR1 + "_num", entity.getPersistentData().getDouble(STR2 + "_num"));
                           entity.getPersistentData().putString(STR1 + "_name", entity.getPersistentData().getString(STR2 + "_name"));
                           if (entity.getPersistentData().getDouble(STR2) == 0.0) {
                              break;
                           }

                           ++NUM2;
                        }

                        entity.getPersistentData().putDouble("skill", 0.0);
                     }

                     double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerChange - Math.max(SpawnedStrength * 5.0, 5.0);
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.PlayerCursePowerChange = _setval;
                        capability.syncPlayerVariables(entity);
                     });
                     boolean _setval2 = true;
                     entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                        capability.noChangeTechnique = _setval2;
                        capability.syncPlayerVariables(entity);
                     });
                     KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                     break;
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
            }
         } else {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

         if (!entity.getPersistentData().getBoolean("PRESS_Z")) {
            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
