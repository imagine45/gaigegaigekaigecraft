package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;

public class ProfessionSorcererProcedure {
   public ProfessionSorcererProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double _setval = 0.0;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerProfession = _setval;
            capability.syncPlayerVariables(entity);
         });
         PlayerSetProfessionProcedure.execute(entity);
         ProfessionDecidedProcedure.execute(entity);
      }
   }
}
