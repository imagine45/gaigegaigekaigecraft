package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class GavelRightclickedProcedure {
   public GavelRightclickedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         ItemStack ITEM_A = ItemStack.f_41583_;
         ItemStack ITEM_REPLACE = ItemStack.f_41583_;
         boolean RIGHT_HAND = false;
         boolean success = false;
         GavelRightClicked2Procedure.execute(world, x, y, z, entity);
      }
   }
}
