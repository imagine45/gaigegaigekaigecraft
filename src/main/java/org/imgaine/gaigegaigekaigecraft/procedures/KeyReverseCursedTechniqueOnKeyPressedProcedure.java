package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class KeyReverseCursedTechniqueOnKeyPressedProcedure {
   public KeyReverseCursedTechniqueOnKeyPressedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double level = 0.0;
         boolean strength = false;
         boolean Player = false;
         Player = entity instanceof Player;
         if (Player && entity instanceof LivingEntity) {
            LivingEntity _livEnt1 = (LivingEntity)entity;
            if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
               return;
            }
         }

         label153: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label153;
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0) {
               if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                  level = 1.0;
               } else if (Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 150.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 10.0) {
                     label129: {
                        label166: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr5 = (ServerPlayer)entity;
                              if (_plr5.level() instanceof ServerLevel && _plr5.getAdvancements().getOrStartProgress(_plr5.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_2"))).isDone()) {
                                 break label166;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt6 = (LivingEntity)entity;
                              if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label166;
                              }
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr7 = (ServerPlayer)entity;
                              if (_plr7.level() instanceof ServerLevel && _plr7.getAdvancements().getOrStartProgress(_plr7.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:reverse_cursed_technique_1"))).isDone()) {
                                 level = 0.0;
                                 break label129;
                              }
                           }

                           level = -1.0;
                           break label129;
                        }

                        level = 1.0;
                     }
                  } else {
                     level = -1.0;
                  }
               } else {
                  label172: {
                     label144: {
                        if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_reverse_cursed_technique")))) {
                           label167: {
                              if (entity instanceof GojoSatoruSchoolDaysEntity) {
                                 GojoSatoruSchoolDaysEntity _datEntL9 = (GojoSatoruSchoolDaysEntity)entity;
                                 if ((Boolean)_datEntL9.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                                    break label167;
                                 }
                              }

                              if (!entity.getPersistentData().contains("entity_can_use_rct") || !entity.getPersistentData().getBoolean("entity_can_use_rct")) {
                                 break label144;
                              }
                           }
                        }

                        if (entity.getPersistentData().getDouble("skill") == 0.0) {
                           float var10000;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.getMaxHealth();
                           } else {
                              var10000 = -1.0F;
                           }

                           level = (double)(var10000 > 800.0F ? 1 : 0);
                           break label172;
                        }
                     }

                     level = -1.0;
                  }
               }

               if (!(level >= 0.0)) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.level().isClientSide()) {
                        _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.not_mastered").getString()), false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt14 = (LivingEntity)entity;
                     if (_livEnt14.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        double var20;
                        int var10001;
                        label106: {
                           var20 = level + 1.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get()).getAmplifier();
                                 break label106;
                              }
                           }

                           var10001 = 0;
                        }

                        level = var20 + (double)var10001;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  entity.getPersistentData().putBoolean("PRESS_M", true);
                  if (entity.getPersistentData().getBoolean("CursedSpirit")) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.level().isClientSide()) {
                           _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2147483647, (int)(Math.round(level) * -1L), true, true));
                        }
                     }
                  } else if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:reverse_cursed_technique infinite " + Math.round(level) + " true");
                  }
               }

               if (!entity.level().isClientSide() && entity.getServer() != null) {
                  entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
               }

               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal(Component.translatable("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
