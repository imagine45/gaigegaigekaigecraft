package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.registries.ForgeRegistries;

public class KeySimpleDomainOnKeyPressedProcedure {
   public KeySimpleDomainOnKeyPressedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean number;
         boolean on;
         boolean falling_blossom;
         double cost;
         int var10000;
         label356: {
            number = false;
            on = false;
            falling_blossom = false;
            double timer = 0.0;
            cost = 0.0;
            double strength = 0.0;
            double num1 = 0.0;
            double num2 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  label351: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label351;
                        }
                     }

                     var10000 = 0;
                  }

                  var10000 += 2;
                  break label356;
               }
            }

            var10000 = 1;
         }

         double var29 = (double)var10000;
         if (entity instanceof Player) {
            number = InlineMethodHandler.checkGamemodeCreative(entity);
            cost = 50.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt4 = (LivingEntity)entity;
               if (_livEnt4.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                  int var10002;
                  label342: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                           var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()).getAmplifier();
                           break label342;
                        }
                     }

                     var10002 = 0;
                  }

                  cost = (double)Math.round(cost * Math.pow(0.5, (double)(var10002 + 1)));
               }
            }
         } else {
            if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_falling_blossom_emotion")))) {
               if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_simple_domain")))) {
                  label334: {
                     label333: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt8 = (LivingEntity)entity;
                           if (_livEnt8.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                              if (!(entity instanceof LivingEntity)) {
                                 break label333;
                              }

                              LivingEntity _livEnt9 = (LivingEntity)entity;
                              if (!_livEnt9.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                 break label333;
                              }

                              label328: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt = (LivingEntity)entity;
                                    if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                       var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                                       break label328;
                                    }
                                 }

                                 var10000 = 0;
                              }

                              if (var10000 <= 0) {
                                 break label333;
                              }
                           }
                        }

                        var10000 = 0;
                        break label334;
                     }

                     var10000 = 1;
                  }
               } else {
                  var10000 = 1;
               }

               falling_blossom = var10000 == 1;
            }

            label388: {
               if (!falling_blossom) {
                  label378: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                           break label378;
                        }
                     }

                     var10000 = 0;
                     break label388;
                  }
               }

               var10000 = 1;
            }

            falling_blossom = var10000 == 1;
         }

         label408: {
            if (entity instanceof Player) {
               if (entity.isShiftKeyDown() && entity instanceof ServerPlayer) {
                  ServerPlayer _plr14 = (ServerPlayer)entity;
                  if (_plr14.level() instanceof ServerLevel && _plr14.getAdvancements().getOrStartProgress(_plr14.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_falling_blossom_emotion"))).isDone() && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 50.0) {
                     break label408;
                  }
               }
            } else if (falling_blossom) {
               break label408;
            }

            label293: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                     break label293;
                  }
               }

               var10000 = 0;
            }

            if (var10000 > 0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     boolean var65;
                     String var10001;
                     label218: {
                        var10001 = Component.translatable("effect.simple_domain").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt25 = (LivingEntity)entity;
                           if (_livEnt25.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                              var65 = true;
                              break label218;
                           }
                        }

                        var65 = false;
                     }

                     _player.displayClientMessage(Component.literal(var10001 + ": " + var65), false);
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
               }
            } else {
               label368: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt28 = (LivingEntity)entity;
                     if (_livEnt28.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                        break label368;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt29 = (LivingEntity)entity;
                     if (_livEnt29.hasEffect((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_SIMPLE_DOMAIN.get())) {
                        break label368;
                     }
                  }

                  if (LogicSimpleDomainProcedure.execute()) {
                     if (!(entity instanceof Player)) {
                        on = entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_simple_domain")));
                     } else {
                        label274: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr31 = (ServerPlayer)entity;
                              if (_plr31.level() instanceof ServerLevel && _plr31.getAdvancements().getOrStartProgress(_plr31.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_simple_domain"))).isDone()) {
                                 if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 50.0 && (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= cost || number)) {
                                    if (!number) {
                                       double _setval = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower - cost;
                                       entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                                          capability.PlayerCursePower = _setval;
                                          capability.syncPlayerVariables(entity);
                                       });
                                    }

                                    on = true;
                                 } else if (entity instanceof Player) {
                                    Player _player = (Player)entity;
                                    if (!_player.level().isClientSide()) {
                                       _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
                                    }
                                 }
                                 break label274;
                              }
                           }

                           if (entity instanceof Player) {
                              Player _player = (Player)entity;
                              if (!_player.level().isClientSide()) {
                                 _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.not_mastered").getString()), false);
                              }
                           }
                        }

                        if (!entity.level().isClientSide() && entity.getServer() != null) {
                           entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
                        }
                     }

                     if (on) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), (int)(100.0 + var29 * 20.0), (int)var29, true, true));
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           if (!_entity.level().isClientSide()) {
                              _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
                           }
                        }

                        if (entity instanceof Player) {
                           Player _player = (Player)entity;
                           if (!_player.level().isClientSide()) {
                              String var64;
                              boolean var66;
                              label252: {
                                 var64 = Component.translatable("effect.simple_domain").getString();
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt41 = (LivingEntity)entity;
                                    if (_livEnt41.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                                       var66 = true;
                                       break label252;
                                    }
                                 }

                                 var66 = false;
                              }

                              _player.displayClientMessage(Component.literal(var64 + ": " + var66), false);
                           }
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity43 = (LivingEntity)entity;
                           if (_livingEntity43.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                              _livingEntity43.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-16.0);
                           }
                        }

                        label394: {
                           double var30 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                           double var31 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                           if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_hollow_wicker_basket")))) {
                              label385: {
                                 if (entity instanceof LivingEntity) {
                                    LivingEntity _livEnt45 = (LivingEntity)entity;
                                    if (_livEnt45.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                       break label385;
                                    }
                                 }

                                 if (!(entity instanceof Player) || var30 != 1.0 && var31 != 1.0 && var30 != 7.0 && var31 != 7.0 && var30 != 12.0 && var31 != 12.0 && var30 != 24.0 && var31 != 24.0) {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livingEntity48 = (LivingEntity)entity;
                                       if (_livingEntity48.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                                          _livingEntity48.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(0.0);
                                       }
                                    }
                                    break label394;
                                 }
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livingEntity47 = (LivingEntity)entity;
                              if (_livingEntity47.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                                 _livingEntity47.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                              }
                           }
                        }

                        PlayAnimationProcedure.execute(world, entity);
                     }

                     return;
                  }
               }

               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
                  }

                  return;
               }
            }

            return;
         }

         if (entity instanceof Player) {
            on = true;
         } else {
            label386: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt16 = (LivingEntity)entity;
                  if (_livEnt16.hasEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get())) {
                     on = false;
                     KeySimpleDomainOnKeyReleasedProcedure.execute(entity);
                     break label386;
                  }
               }

               on = true;
            }
         }

         if (on) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get(), 2147483647, (int)var29, true, true));
               }
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("§l" + Component.translatable("effect.gaigegaigekaigecraft.falling_blossom_emotion").getString()), false);
               }
            }

            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.playSound((Player)null, BlockPos.containing(x, y, z), (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F);
               } else {
                  _level.playLocalSound(x, y, z, (SoundEvent)ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gaigegaigekaigecraft:frame_set")), SoundSource.NEUTRAL, 1.0F, 1.0F, false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 30, false, false));
               }
            }
         }

      }
   }
}
