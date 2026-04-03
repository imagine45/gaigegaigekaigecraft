package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.HigurumaHiromiEntity;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class GavelRightclickedProcedure {
   public GavelRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack item_mainHand = ItemStack.EMPTY;
         ItemStack item_offHand = ItemStack.EMPTY;
         ItemStack item_target = ItemStack.EMPTY;
         double ticks = 0.0;
         double cnt1 = 0.0;
         double skill = 0.0;
         double CT2 = 0.0;
         double CT1 = 0.0;
         CT1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         CT2 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
         if (entity instanceof HigurumaHiromiEntity || CT1 == 27.0 || CT2 == 27.0) {
            GavelRightClicked2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
