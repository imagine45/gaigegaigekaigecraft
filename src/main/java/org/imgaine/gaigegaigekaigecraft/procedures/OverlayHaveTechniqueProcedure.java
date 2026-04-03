package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;

public class OverlayHaveTechniqueProcedure {
   public OverlayHaveTechniqueProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else if (entity instanceof Player) {
         if (InlineMethodHandler.checkGamemodeSpectator(entity)) {
            return false;
         } else {
            Player player = (Player)entity;
            JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
            return playerVars.PlayerCurseTechnique != 0.0;
         }
      } else {
         return true;
      }
   }
}
