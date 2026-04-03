package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ActiveTickConditionProcedure {
   public ActiveTickConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else if (entity.getPersistentData().getDouble("skill") <= -999.0) {
         return false;
      } else {
         return entity instanceof Player ? (Boolean)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).map((variables) -> variables.PlayerCursePower + variables.PlayerCursePowerChange > 0.0).orElse(false) : true;
      }
   }
}
