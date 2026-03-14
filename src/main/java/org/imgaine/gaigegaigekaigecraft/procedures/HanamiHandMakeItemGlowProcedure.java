package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.item.ItemStack;

public class HanamiHandMakeItemGlowProcedure {
   public HanamiHandMakeItemGlowProcedure() {
   }

   public static boolean execute(ItemStack itemstack) {
      return itemstack.m_41784_().m_128459_("Power") > 0.0;
   }
}
