package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerPhysicalAbilityProcedure {
   public PlayerPhysicalAbilityProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double level_jump_set = 0.0;
         double PlayerCT1 = 0.0;
         double level_armor = 0.0;
         double level = 0.0;
         double old_health = 0.0;
         double level_speed_set = 0.0;
         double level_sukuna = 0.0;
         double old_cool = 0.0;
         double level_speed = 0.0;
         double level_armorToughness = 0.0;
         double level_physicalGifted = 0.0;
         double level_power = 0.0;
         double level_resistance = 0.0;
         double level_jump = 0.0;
         double PlayerCT2 = 0.0;
         double level_health = 0.0;
         boolean projectionSorcery = false;
         boolean MythricalBeastAmberEffect = false;
         boolean blue = false;
         boolean YujiItadori = false;
         boolean hasSpeed = false;
         boolean hasJump = false;
         if (entity.isAlive() && entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.tickCount % 2 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               level = playerVars.PlayerLevel;
               PlayerCT1 = playerVars.PlayerCurseTechnique;
               PlayerCT2 = playerVars.PlayerCurseTechnique2;
               if (PlayerCT1 != 0.0) {
                  boolean var10000;
                  label452: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt1 = (LivingEntity)entity;
                        if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.MYTHICAL_BEAST_AMBER_EFFECT.get())) {
                           var10000 = true;
                           break label452;
                        }
                     }

                     var10000 = false;
                  }

                  MythricalBeastAmberEffect = var10000;
                  YujiItadori = PlayerCT1 == 21.0 || PlayerCT2 == 21.0;
                  if (PlayerCT1 == 2.0 || PlayerCT2 == 2.0) {
                     label440: {
                        if (LogicStartPassiveProcedure.execute(entity) && entity instanceof ServerPlayer) {
                           ServerPlayer _plr2 = (ServerPlayer)entity;
                           if (_plr2.level() instanceof ServerLevel && _plr2.getAdvancements().getOrStartProgress(_plr2.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:skill_high_speed"))).isDone()) {
                              var10000 = true;
                              break label440;
                           }
                        }

                        var10000 = false;
                     }

                     blue = var10000;
                  }

                  if (PlayerCT1 == 19.0 || PlayerCT2 == 19.0) {
                     projectionSorcery = LogicStartPassiveProcedure.execute(entity);
                  }

                  if (YujiItadori) {
                     level = Math.max(level + 3.0, level * 1.2);
                  }

                  if (serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                     level_sukuna = (double)Math.min(serverPlayer.getEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get()).getAmplifier() + 1, 20);
                     if (level_sukuna <= 10.0) {
                        level = Math.max(level, (double)(15L + Math.round(Math.floor(level_sukuna * 0.5))));
                     } else if (level_sukuna <= 19.0) {
                        level = Math.max(level, (double)(10L + Math.round(Math.floor(level_sukuna * 1.0))));
                     } else {
                        level = Math.max(level, 35.0);
                     }
                  }

                  if (playerVars.PlayerCursePowerFormer == 0.0) {
                     level = Math.max(level + 6.0, level * 1.3);
                     level_physicalGifted = 5.0;
                  } else if (playerVars.PlayerCursePowerFormer < 100.0) {
                     level = Math.max(level + 3.0, level * 1.2);
                     level_physicalGifted = 1.0;
                  }

                  if (level > 0.0) {
                     level = Math.max(level - 1.0, 0.0);
                     level_power = (double)Math.round(level);
                     level_power = level_power < 3.0 ? Math.min(level_power, 1.0) : level_power;
                     level_resistance = (double)Math.round(level < 3.0 ? 0.0 : Math.min(level / 4.0, 3.0));
                     level_health = (double)Math.round(level >= 19.0 ? 9.0 : Math.min(level / 3.0, 4.0));
                     if (level_sukuna > 0.0) {
                        level_health = (double)Math.round(Math.max(level_health, 14.0));
                     }

                     if (level > 0.0) {
                        if (entity.isSprinting()) {
                           level_speed = level * 0.5;
                           if (projectionSorcery) {
                              level_speed = (double)Math.round(Math.min(Math.max(level_speed * 3.0, 10.0), 120.0));
                           } else if (!(level_physicalGifted > 0.0) && !YujiItadori && !MythricalBeastAmberEffect && !blue) {
                              level_speed = (double)Math.round(Math.min(level_speed, 15.0));
                           } else {
                              level_speed = (double)Math.round(Math.min(Math.max(level_speed * 2.0, 3.0), 30.0));
                           }

                           hasSpeed = serverPlayer.hasEffect(MobEffects.MOVEMENT_SPEED);
                           level_speed_set = hasSpeed ? (double)serverPlayer.getEffect(MobEffects.MOVEMENT_SPEED).getAmplifier() : 0.0;
                           if (!hasSpeed) {
                              if (entity.onGround()) {
                                 if (PlayerCT1 >= 0.0 && PlayerCT2 >= 0.0) {
                                    if (projectionSorcery) {
                                       level_speed_set = 10.0;
                                    } else if (blue) {
                                       level_speed_set = 5.0;
                                    } else if (!YujiItadori && !MythricalBeastAmberEffect) {
                                       level_speed_set = 0.0;
                                    } else {
                                       level_speed_set = 3.0;
                                    }
                                 } else {
                                    level_speed_set = level_physicalGifted;
                                 }

                                 serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20, (int)level_speed_set, false, false));
                              }
                           } else {
                              level_speed_set += (double)(!(level_physicalGifted > 0.0) && !YujiItadori && !MythricalBeastAmberEffect && !projectionSorcery && !blue ? 1 : 2);
                              if (serverPlayer.getEffect(MobEffects.MOVEMENT_SPEED).getDuration() <= 5) {
                                 serverPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10, (int)Math.min(level_speed_set, level_speed), false, false));
                              }
                           }
                        }

                        if (entity.isShiftKeyDown() || !entity.onGround()) {
                           hasJump = serverPlayer.hasEffect(MobEffects.JUMP);
                           if (entity.isShiftKeyDown()) {
                              level_jump = (double)Math.round(Math.min(level / 4.0, 6.0));
                              level_jump_set = hasJump ? (double)serverPlayer.getEffect(MobEffects.JUMP).getAmplifier() : 0.0;
                              ++level_jump_set;
                              if (!hasJump) {
                                 level_jump_set = level_speed_set - 1.0;
                              }
                           } else {
                              level_jump = (double)Math.round(Math.min(level_speed_set / 4.0, level / 4.0));
                              level_jump_set = level_jump;
                           }

                           if ((hasJump ? serverPlayer.getEffect(MobEffects.JUMP).getDuration() : 0) <= 5) {
                              serverPlayer.addEffect(new MobEffectInstance(MobEffects.JUMP, 10, (int)Math.min(level_jump, level_jump_set), false, false));
                           }
                        }
                     }

                     if (serverPlayer.tickCount % 100 == 10) {
                        if ((!serverPlayer.hasEffect(MobEffects.DAMAGE_BOOST) || (double)serverPlayer.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier() < level_power) && !entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:strength infinite " + Math.round(level_power) + " true");
                        }

                        if ((!serverPlayer.hasEffect(MobEffects.DAMAGE_RESISTANCE) || (double)serverPlayer.getEffect(MobEffects.DAMAGE_RESISTANCE).getAmplifier() < level_resistance) && !entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:resistance infinite " + Math.round(level_resistance) + " true");
                        }

                        if (!serverPlayer.hasEffect(MobEffects.HEALTH_BOOST) || (double)serverPlayer.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() < level_health) {
                           float var74;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var74 = _livEnt.getHealth();
                           } else {
                              var74 = -1.0F;
                           }

                           int var10003;
                           double var75;
                           label360: {
                              var75 = (double)var74;
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _livEnt = (LivingEntity)entity;
                                 if (_livEnt.hasEffect(MobEffects.HEALTH_BOOST)) {
                                    var10003 = _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier();
                                    break label360;
                                 }
                              }

                              var10003 = 0;
                           }

                           old_health = var75 + 4.0 * (level_health - (double)var10003 + 1.0);
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:health_boost infinite " + Math.round(level_health) + " true");
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _entity = (LivingEntity)entity;
                              _entity.setHealth((float)old_health);
                           }
                        }

                        level_armor = level * 1.0;
                        level_armorToughness = level * 0.15;
                        if (YujiItadori) {
                           level_armor += 4.0;
                           level_armorToughness += 0.5;
                        }

                        level_armor = Math.min(level_armor, 30.0);
                        level_armorToughness = Math.min(level_armorToughness, 20.0);
                        if (serverPlayer.getAttribute(Attributes.ARMOR) != null && level_armor > serverPlayer.getAttributeValue(Attributes.ARMOR)) {
                           serverPlayer.getAttribute(Attributes.ARMOR).setBaseValue(level_armor);
                        }

                        if (serverPlayer.getAttribute(Attributes.ARMOR_TOUGHNESS) != null && level_armorToughness > serverPlayer.getAttributeValue(Attributes.ARMOR_TOUGHNESS)) {
                           serverPlayer.getAttribute(Attributes.ARMOR_TOUGHNESS).setBaseValue(level_armorToughness);
                        }

                        if (PlayerCT1 >= 0.0 && PlayerCT2 >= 0.0) {
                           if (PlayerCT1 != 1.0 && PlayerCT2 != 1.0 && PlayerCT1 != 4.0 && PlayerCT2 != 4.0) {
                              if (PlayerCT1 == 8.0 || PlayerCT2 == 8.0) {
                                 if (!serverPlayer.hasEffect(MobEffects.DOLPHINS_GRACE) && !entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:dolphins_grace infinite 4 true");
                                 }

                                 if (!serverPlayer.hasEffect(MobEffects.WATER_BREATHING) && !entity.level().isClientSide() && entity.getServer() != null) {
                                    entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:water_breathing infinite 0 true");
                                 }
                              }
                           } else if (!serverPlayer.hasEffect(MobEffects.FIRE_RESISTANCE) && !entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:fire_resistance infinite 0 true");
                           }
                        } else if (level_physicalGifted > 0.0) {
                           --level_physicalGifted;
                           if ((!serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()) || (double)serverPlayer.getEffect((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).getAmplifier() < level_physicalGifted) && !entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:physical_gifted_effect infinite " + Math.round(level_physicalGifted) + " true");
                           }
                        }
                     }
                  }

                  if (serverPlayer.tickCount % 10 == 0 && PlayerCT1 == 10.0 && entity.isInWaterRainOrBubble()) {
                     old_cool = serverPlayer.getPersistentData().getDouble("COOLDOWN_TICKS");
                     serverPlayer.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 20, 0, false, false));
                     entity.getPersistentData().putDouble("COOLDOWN_TICKS", old_cool);
                     serverPlayer.getPersistentData().putDouble("COOLDOWN_TICKS", old_cool);
                  }

                  if (serverPlayer.tickCount % 100 == 10) {
                     if (playerVars.FlagSixEyes && !serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:six_eyes infinite 0 true");
                     }

                     if (serverPlayer.getPersistentData().getBoolean("CursedSpirit") && !serverPlayer.hasEffect(MobEffects.NIGHT_VISION) && !entity.level().isClientSide() && entity.getServer() != null) {
                        entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s minecraft:night_vision infinite 0 true");
                     }

                     if (playerVars.flag_sukuna && !serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                        level_sukuna = GetSukunaLevelProcedure.execute(entity);
                        if (level_sukuna > 0.0) {
                           level_sukuna = (double)Math.round(Math.min(Math.max(level_sukuna, 1.0), 20.0));
                           if (!entity.level().isClientSide() && entity.getServer() != null) {
                              entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:sukuna_effect infinite " + Math.round(level_sukuna) + " true");
                           }
                        }
                     }
                  }

                  if ((PlayerCT2 == 38.0 || PlayerCT1 == 38.0) && LogicStartPassiveProcedure.execute(entity)) {
                     serverPlayer.fallDistance = 0.0F;
                     if ((entity.onGround() || entity.isInWater()) && (serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()) ? serverPlayer.getEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_BACK_STEP.get()).getAmplifier() : 0) < 5) {
                        serverPlayer.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get(), Math.min((serverPlayer.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()) ? serverPlayer.getEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get()).getDuration() : 0) + 10, 60), 0, true, true));
                     }
                  }
               }
            }
         }

      }
   }
}
