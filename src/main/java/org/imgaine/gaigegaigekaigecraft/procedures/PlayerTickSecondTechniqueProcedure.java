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
         ItemStack item_a = ItemStack.EMPTY;
         ItemStack item_b = ItemStack.EMPTY;
         boolean changeTechnique = false;
         boolean switched = false;
         boolean old_second = false;
         boolean sync = false;
         if (entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.tickCount % 6 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               ItemStack var10000;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  var10000 = _livEnt.getMainHandItem();
               } else {
                  var10000 = ItemStack.EMPTY;
               }

               label89: {
                  label90: {
                     item_a = var10000;
                     if (item_a.getItem() == JujutsucraftModItems.LOUDSPEAKER.get() && !item_a.getOrCreateTag().getBoolean("Used")) {
                        if (!(entity instanceof Player)) {
                           break label90;
                        }

                        Player _plrCldCheck2 = (Player)entity;
                        if (!_plrCldCheck2.getCooldowns().isOnCooldown(item_a.getItem())) {
                           break label90;
                        }
                     }

                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt3 = (LivingEntity)entity;
                        if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
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

                     item_b = ReturnInsideItemProcedure.execute(entity).copy();
                     if (item_b.getItem() == JujutsucraftModItems.DEATH_PAINTING.get() && item_b.getCount() >= 9) {
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

               if (changeTechnique) {
                  sync = true;
                  if (!entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
                  }

                  playerVars.noChangeTechnique = true;
                  KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               }

               if (sync) {
                  playerVars.syncPlayerVariables(entity);
               }
            }
         }

      }
   }
}
