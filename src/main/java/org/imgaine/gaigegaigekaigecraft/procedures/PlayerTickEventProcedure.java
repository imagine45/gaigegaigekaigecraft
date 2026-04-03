package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
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
         execute(event, event.player.level(), event.player.getX(), event.player.getY(), event.player.getZ(), event.player);
      }

   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      execute((Event)null, world, x, y, z, entity);
   }

   private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double currentCursePowerChange = 0.0;
         double healCursePower = 0.0;
         if (entity.isAlive()) {
            if (entity instanceof ServerPlayer) {
               ServerPlayer serverPlayer = (ServerPlayer)entity;
               if (serverPlayer.tickCount % 10 == 0) {
                  JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
                  currentCursePowerChange = playerVars.PlayerCursePowerChange;
                  healCursePower = 0.0;
                  if (playerVars.PlayerCurseTechnique != 0.0) {
                     if (serverPlayer.isCreative()) {
                        if (playerVars.PlayerCursePower < playerVars.PlayerCursePowerMAX || currentCursePowerChange != 0.0) {
                           playerVars.PlayerCursePower = playerVars.PlayerCursePowerMAX;
                           playerVars.PlayerCursePowerChange = 0.0;
                           playerVars.syncPlayerVariables(entity);
                        }
                     } else {
                        if (currentCursePowerChange < 0.0) {
                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt1 = (LivingEntity)entity;
                              if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                                 currentCursePowerChange *= 0.5;
                              }
                           }

                           if (entity instanceof LivingEntity) {
                              LivingEntity _livEnt2 = (LivingEntity)entity;
                              if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                 int var10002;
                                 label84: {
                                    if (entity instanceof LivingEntity) {
                                       LivingEntity _livEnt = (LivingEntity)entity;
                                       if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                                          var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get()).getAmplifier();
                                          break label84;
                                       }
                                    }

                                    var10002 = 0;
                                 }

                                 currentCursePowerChange *= 0.1 / (double)(Math.max(var10002, 0) + 1);
                              }
                           }
                        }

                        healCursePower = 1.0 + (2.0 + playerVars.PlayerLevel) / 1.1 * 0.2;
                        float var10000;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10000 = _livEnt.getHealth();
                        } else {
                           var10000 = -1.0F;
                        }

                        float var10001;
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt = (LivingEntity)entity;
                           var10001 = _livEnt.getMaxHealth();
                        } else {
                           var10001 = -1.0F;
                        }

                        if (var10000 >= var10001) {
                           healCursePower *= 2.0;
                        }

                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt6 = (LivingEntity)entity;
                           if (_livEnt6.hasEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get())) {
                              healCursePower *= 1.2;
                           }
                        }

                        currentCursePowerChange += (double)Math.round(healCursePower);
                        if (currentCursePowerChange != 0.0) {
                           playerVars.PlayerCursePower = (double)Math.round(Math.max(Math.min(playerVars.PlayerCursePower + currentCursePowerChange, playerVars.PlayerCursePowerMAX), 0.0));
                           playerVars.PlayerCursePowerChange = 0.0;
                           playerVars.syncPlayerVariables(entity);
                           if (playerVars.PlayerCursePower <= 0.0 && entity.getPersistentData().getBoolean("CursedSpirit")) {
                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
                              }

                              if (entity instanceof LivingEntity) {
                                 LivingEntity _entity = (LivingEntity)entity;
                                 _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                              }

                              entity.kill();
                           }
                        }
                     }
                  }

                  if (serverPlayer.getAdvancements().getOrStartProgress(serverPlayer.server.getAdvancements().getAdvancement(new ResourceLocation("gaigegaigekaigecraft:advancement_insect"))).isDone() && serverPlayer.getFoodData().getFoodLevel() < 20) {
                     serverPlayer.getFoodData().setFoodLevel(20);
                  }
               }
            }

            WhenPlayerActiveTickInfinityProcedure.execute(entity);
         }

         PlayerTickSecondTechniqueProcedure.execute(world, x, y, z, entity);
      }
   }
}
