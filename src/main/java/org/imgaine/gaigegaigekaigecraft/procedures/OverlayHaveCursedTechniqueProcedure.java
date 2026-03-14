package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class OverlayHaveCursedTechniqueProcedure {
   public OverlayHaveCursedTechniqueProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else if (!OverlayHaveTechniqueProcedure.execute(entity)) {
         return false;
      } else if (entity instanceof Player) {
         Player player = (Player)entity;
         JujutsucraftModVariables.PlayerVariables playerVars = (JujutsucraftModVariables.PlayerVariables)player.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables());
         return playerVars.PlayerCurseTechnique != -1.0;
      } else {
         return true;
      }
   }
}
