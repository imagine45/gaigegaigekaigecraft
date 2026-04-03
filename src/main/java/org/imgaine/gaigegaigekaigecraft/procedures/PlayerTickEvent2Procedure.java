package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.TickEvent.Phase;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class PlayerTickEvent2Procedure {
   public PlayerTickEvent2Procedure() {
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
         boolean changeTechnique = false;
         String old_name = "";
         if (entity.isAlive() && entity instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer)entity;
            if (serverPlayer.tickCount % 2 == 0) {
               JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
               if (entity.isShiftKeyDown()) {
                  StartGuardProcedure.execute(world, entity);
                  serverPlayer.removeEffect(MobEffects.MOVEMENT_SPEED);
                  if (!playerVars.flag_shift) {
                     playerVars.flag_shift = true;
                     changeTechnique = true;
                  }
               } else if (playerVars.flag_shift) {
                  playerVars.flag_shift = false;
                  changeTechnique = true;
               }

               if (changeTechnique && (playerVars.PlayerCurseTechnique == 6.0 || playerVars.PlayerCurseTechnique2 == 6.0)) {
                  old_name = playerVars.PlayerSelectCurseTechniqueName;
                  playerVars.noChangeTechnique = true;
                  playerVars.syncPlayerVariables(entity);
                  KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
                  if (!old_name.equals(playerVars.PlayerSelectCurseTechniqueName) && !entity.level().isClientSide() && entity.getServer() != null) {
                     entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "playsound ui.button.click master @s");
                  }
               }
            }
         }

      }
   }
}
