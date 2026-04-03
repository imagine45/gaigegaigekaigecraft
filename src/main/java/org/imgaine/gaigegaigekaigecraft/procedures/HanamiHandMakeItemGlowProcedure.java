package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.item.ItemStack;

public class HanamiHandMakeItemGlowProcedure {
   public HanamiHandMakeItemGlowProcedure() {
   }

   public static boolean execute(ItemStack itemstack) {
      return itemstack.getOrCreateTag().getDouble("Power") > 0.0;
   }
}
