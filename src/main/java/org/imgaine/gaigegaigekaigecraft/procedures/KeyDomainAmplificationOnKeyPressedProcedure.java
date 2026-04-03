package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class KeyDomainAmplificationOnKeyPressedProcedure {
   public KeyDomainAmplificationOnKeyPressedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         boolean Player = false;
         double level = 0.0;
         if (OverlayHaveTechniqueProcedure.execute(entity)) {
            label113: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt0 = (LivingEntity)entity;
                  if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get());
                     }

                     if (!(entity instanceof Player)) {
                        break label113;
                     }

                     Player _player = (Player)entity;
                     if (_player.level().isClientSide()) {
                        break label113;
                     }

                     String var15;
                     boolean var16;
                     label77: {
                        var15 = Component.translatable("effect.domain_amplification").getString();
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt3 = (LivingEntity)entity;
                           if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                              var16 = true;
                              break label77;
                           }
                        }

                        var16 = false;
                     }

                     _player.displayClientMessage(Component.literal(var15 + ": " + var16), false);
                     break label113;
                  }
               }

               label119: {
                  if (entity instanceof Player) {
                     label118: {
                        if (entity instanceof ServerPlayer) {
                           ServerPlayer _plr6 = (ServerPlayer)entity;
                           if (_plr6.level() instanceof ServerLevel && _plr6.getAdvancements().getOrStartProgress(_plr6.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:mastery_domain_amplification"))).isDone()) {
                              break label118;
                           }
                        }

                        if (!(entity instanceof LivingEntity)) {
                           break label119;
                        }

                        LivingEntity _livEnt7 = (LivingEntity)entity;
                        if (!_livEnt7.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           break label119;
                        }
                     }
                  }

                  double var10000;
                  label91: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                           var10000 = (double)_livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                           break label91;
                        }
                     }

                     var10000 = 0.0;
                  }

                  level = var10000;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "effect give @s gaigegaigekaigecraft:domain_amplification infinite " + Math.round(level) + " false");
                  }

                  if (!(entity instanceof Player)) {
                     break label113;
                  }

                  Player _player = (Player)entity;
                  if (_player.level().isClientSide()) {
                     break label113;
                  }

                  String var10001;
                  boolean var10002;
                  label85: {
                     var10001 = Component.translatable("effect.domain_amplification").getString();
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt11 = (LivingEntity)entity;
                        if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_AMPLIFICATION.get())) {
                           var10002 = true;
                           break label85;
                        }
                     }

                     var10002 = false;
                  }

                  _player.displayClientMessage(Component.literal(var10001 + ": " + var10002), false);
                  break label113;
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

      }
   }
}
