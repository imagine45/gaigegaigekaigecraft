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
            if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get())) {
               return;
            }
         }

         label147: {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get())) {
                  break label147;
               }
            }

            if (entity.getPersistentData().m_128459_("skill") == 0.0) {
               if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                  level = 1.0;
               } else if (Player) {
                  if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePowerFormer > 150.0 && ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCursePower >= 10.0) {
                     label127: {
                        label160: {
                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr5 = (ServerPlayer)entity;
                              if (_plr5.m_9236_() instanceof ServerLevel && _plr5.m_8960_().m_135996_(_plr5.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_2"))).m_8193_()) {
                                 break label160;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt6 = (LivingEntity)entity;
                              if (_livEnt6.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 break label160;
                              }
                           }

                           if (entity instanceof ServerPlayer) {
                              ServerPlayer _plr7 = (ServerPlayer)entity;
                              if (_plr7.m_9236_() instanceof ServerLevel && _plr7.m_8960_().m_135996_(_plr7.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:reverse_cursed_technique_1"))).m_8193_()) {
                                 level = 0.0;
                                 break label127;
                              }
                           }

                           level = -1.0;
                           break label127;
                        }

                        level = 1.0;
                     }
                  } else {
                     level = -1.0;
                  }
               } else {
                  label165: {
                     label138: {
                        if (!entity.m_6095_().m_204039_(TagKey.m_203882_(Registries.f_256939_, new ResourceLocation("jujutsucraft:can_use_reverse_cursed_technique")))) {
                           if (!(entity instanceof GojoSatoruSchoolDaysEntity)) {
                              break label138;
                           }

                           GojoSatoruSchoolDaysEntity _datEntL9 = (GojoSatoruSchoolDaysEntity)entity;
                           if (!(Boolean)_datEntL9.m_20088_().m_135370_(GojoSatoruSchoolDaysEntity.DATA_awaking)) {
                              break label138;
                           }
                        }

                        if (entity.getPersistentData().m_128459_("skill") == 0.0) {
                           float var10000;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              var10000 = _livEnt.m_21233_();
                           } else {
                              var10000 = -1.0F;
                           }

                           level = (double)(var10000 > 800.0F ? 1 : 0);
                           break label165;
                        }
                     }

                     level = -1.0;
                  }
               }

               if (!(level >= 0.0)) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     if (!_player.m_9236_().m_5776_()) {
                        _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.not_mastered").getString()), false);
                     }
                  }
               } else {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt12 = (LivingEntity)entity;
                     if (_livEnt12.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                        double var20;
                        int var10001;
                        label104: {
                           var20 = level + 1.0;
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt = (LivingEntity)entity;
                              if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                                 var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.ZONE.get()).m_19564_();
                                 break label104;
                              }
                           }

                           var10001 = 0;
                        }

                        level = var20 + (double)var10001;
                     }
                  }

                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.GUARD.get());
                  }

                  entity.getPersistentData().m_128379_("PRESS_M", true);
                  if (entity.getPersistentData().m_128471_("CursedSpirit")) {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _entity = (LivingEntity)entity;
                        if (!_entity.m_9236_().m_5776_()) {
                           _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get(), 2147483647, (int)(Math.round(level) * -1L), true, true));
                        }
                     }
                  } else if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "effect give @s jujutsucraft:reverse_cursed_technique infinite " + Math.round(level) + " true");
                  }
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
               }

               return;
            }
         }

         if (entity instanceof Player) {
            Player _player = (Player)entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_(Component.m_237115_("jujutsu.message.dont_use").getString()), false);
            }
         }

      }
   }
}
