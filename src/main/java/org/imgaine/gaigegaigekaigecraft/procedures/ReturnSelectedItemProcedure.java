package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.item.ItemStack;

public class ReturnSelectedItemProcedure {
   public ReturnSelectedItemProcedure() {
   }

   public static ItemStack execute(ItemStack item) {
      ItemStack itemstack_1 = ItemStack.EMPTY;
      itemstack_1 = item.copy();
      if (itemstack_1.getItem() != ItemStack.EMPTY.getItem()) {
         itemstack_1.getOrCreateTag().putBoolean("DistributionItem", true);
      }

      return itemstack_1;
   }
}
