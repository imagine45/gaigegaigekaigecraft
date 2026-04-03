package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class ChangeCurseEnergyProcedure {
   public ChangeCurseEnergyProcedure() {
   }

   public static void execute(Entity entity, double energy_change) {
      if (entity != null) {
         if (entity instanceof Player && energy_change != 0.0) {
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> capability.PlayerCursePowerChange += energy_change);
         }

      }
   }
}
