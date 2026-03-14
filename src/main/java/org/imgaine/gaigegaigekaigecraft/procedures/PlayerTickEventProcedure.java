package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTickEventProcedure {
   public PlayerTickEventProcedure() {
   }

   @SubscribeEvent
   public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
      if (event.phase == Phase.END) {
         execute(event, event.player.m_9236_(), event.player.m_20185_(), event.player.m_20186_(), event.player.m_20189_(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double currentCursePowerChange = 0.0;
         double healCursePower = 0.0;
         if (entity.m_6084_()) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               if (serverPlayer.f_19797_ % 10 == 0) {
                  JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  currentCursePowerChange = playerVars.PlayerCursePowerChange;
                  healCursePower = 0.0;
                  if (playerVars.PlayerCurseTechnique != 0.0) {
                     if (((<undefinedtype>)(new Object() {
                        public boolean checkGamemode(Entity _ent) {
                           if (_ent instanceof ServerPlayer _serverPlayer) {
                              return _serverPlayer.f_8941_.m_9290_() == GameType.CREATIVE;
                           } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                              return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.CREATIVE;
                           } else {
                              return false;
                           }
                        }
                     })).checkGamemode(entity)) {
                        if (playerVars.PlayerCursePower < playerVars.PlayerCursePowerMAX) {
                           playerVars.PlayerCursePower = playerVars.PlayerCursePowerMAX;
                           playerVars.syncPlayerVariables(entity);
                        }
                     } else {
                        if (currentCursePowerChange < 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt2 = (LivingEntity)entity;
                              if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 currentCursePowerChange *= 0.5;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt3 = (LivingEntity)entity;
                              if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                 int index0 = 0;

                                 while(true) {
                                    int var10001;
                                    label109: {
                                       if (entity instanceof LivingEntity) {
                                          LivingEntity _livEnt = (LivingEntity)entity;
                                          if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                             var10001 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()).m_19564_();
                                             break label109;
                                          }
                                       }

                                       var10001 = 0;
                                    }

                                    if (index0 >= var10001 + 1) {
                                       break;
                                    }

                                    currentCursePowerChange *= 0.1;
                                    ++index0;
                                 }
                              }
                           }
                        }

                        healCursePower = 1.0 + (2.0 + playerVars.PlayerLevel) / 1.1 * 0.2;
                        float var10000;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.m_21223_();
                        } else {
                           var10000 = -1.0F;
                        }

                        float var32;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var32 = _livEnt.m_21233_();
                        } else {
                           var32 = -1.0F;
                        }

                        if (var10000 >= var32) {
                           healCursePower *= 2.0;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt7 = (LivingEntity)entity;
                           if (_livEnt7.m_21023_((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                              healCursePower *= 1.2;
                           }
                        }

                        currentCursePowerChange += (double)Math.round(healCursePower);
                        if (currentCursePowerChange != 0.0) {
                           playerVars.PlayerCursePower = (double)Math.round(Math.max(Math.min(playerVars.PlayerCursePower + currentCursePowerChange, playerVars.PlayerCursePowerMAX), 0.0));
                           playerVars.PlayerCursePowerChange = 0.0;
                           playerVars.syncPlayerVariables(entity);
                           if (playerVars.PlayerCursePower <= 0.0 && entity.getPersistentData().m_128471_("CursedSpirit")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                              }

                              if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                                 entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "kill @s");
                              }
                           }
                        }
                     }
                  }

                  if (entity instanceof ServerPlayer) {
                     ServerPlayer _plr12 = (ServerPlayer)entity;
                     if (_plr12.m_9236_() instanceof ServerLevel && _plr12.m_8960_().m_135996_(_plr12.f_8924_.m_129889_().m_136041_(new ResourceLocation("jujutsucraft:advancement_insect"))).m_8193_()) {
                        int var31;
                        if (entity instanceof Player) {
                           Player _plr = (Player)entity;
                           var31 = _plr.m_36324_().m_38702_();
                        } else {
                           var31 = 0;
                        }

                        if (var31 < 20 && entity instanceof Player) {
                           Player _player = (Player)entity;
                           _player.m_36324_().m_38705_(20);
                        }
                     }
                  }
               }
            }

            WhenPlayerActiveTickInfinityProcedure.execute(entity);
         }

         PlayerTickSecondTechniqueProcedure.execute(world, x, y, z, entity);
      }
   }
}
