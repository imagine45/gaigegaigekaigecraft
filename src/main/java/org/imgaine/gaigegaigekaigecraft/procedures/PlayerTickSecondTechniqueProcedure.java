package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModItems;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class PlayerTickSecondTechniqueProcedure {
   public PlayerTickSecondTechniqueProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double old_select = 0.0;
         double old_technique = 0.0;
         ItemStack item_a = ItemStack.f_41583_;
         ItemStack item_b = ItemStack.f_41583_;
         boolean changeTechnique = false;
         boolean switched = false;
         boolean old_second = false;
         boolean sync = false;
         if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.f_19797_ % 5 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.m_21205_();
               } else {
                  var10000 = ItemStack.f_41583_;
               }

               label89: {
                  label90: {
                     item_a = var10000.m_41777_();
                     item_b = ReturnInsideItemProcedure.execute(entity).m_41777_();
                     if (item_a.m_41720_() == JujutsucraftModItems.LOUDSPEAKER.get() && !item_a.m_41784_().m_128471_("Used")) {
                        if (!(entity instanceof Player)) {
                           break label90;
                        }

                        Player _plrCldCheck3 = (Player)entity;
                        if (!_plrCldCheck3.m_36335_().m_41519_(item_a.m_41720_())) {
                           break label90;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt4 = (LivingEntity)entity;
                        if (_livEnt4.m_21023_((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                           if (playerVars.PlayerCurseTechnique2 != 1.0) {
                              playerVars.PlayerCurseTechnique2 = 1.0;
                              playerVars.SecondTechnique = true;
                              changeTechnique = true;
                              sync = true;
                           }

                           if (playerVars.PlayerCurseTechnique == 21.0 && !playerVars.SecondTechnique) {
                              playerVars.SecondTechnique = true;
                              sync = true;
                           }
                           break label89;
                        }
                     }

                     if (item_b.m_41720_() == JujutsucraftModItems.DEATH_PAINTING.get() && item_b.m_41613_() >= 9) {
                        if (playerVars.PlayerCurseTechnique2 != 10.0) {
                           playerVars.PlayerCurseTechnique2 = 10.0;
                           sync = true;
                        }
                        break label89;
                     }

                     if (playerVars.SecondTechnique) {
                        playerVars.SecondTechnique = false;
                        sync = true;
                     }

                     if (playerVars.PlayerCurseTechnique2 != playerVars.PlayerCurseTechnique) {
                        playerVars.PlayerCurseTechnique2 = playerVars.PlayerCurseTechnique;
                        changeTechnique = true;
                        sync = true;
                     }
                     break label89;
                  }

                  if (!playerVars.SecondTechnique) {
                     playerVars.SecondTechnique = true;
                     sync = true;
                  }

                  if (playerVars.PlayerCurseTechnique2 != 3.0) {
                     playerVars.PlayerCurseTechnique2 = 3.0;
                     changeTechnique = true;
                     sync = true;
                  }
               }

               if (sync) {
                  playerVars.syncPlayerVariables(entity);
               }

               if (changeTechnique) {
                  if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                     entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "playsound ui.button.click master @s");
                  }

                  playerVars.noChangeTechnique = true;
                  playerVars.syncPlayerVariables(entity);
                  KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }
            }
         }

      }
   }
}
