package org.imgaine.gaigegaigekaigecraft.item;

import org.imgaine.gaigegaigekaigecraft.procedures.HumanStockCarRightClickedOnBlockProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;

public class HumanStockCarItem extends Item {
   public HumanStockCarItem() {
      super((new Item.Properties()).stacksTo(64).rarity(Rarity.COMMON));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.EAT;
   }

   public InteractionResult useOn(UseOnContext context) {
      super.useOn(context);
      HumanStockCarRightClickedOnBlockProcedure.execute(context.getLevel(), (double)context.getClickedPos().getX(), (double)context.getClickedPos().getY(), (double)context.getClickedPos().getZ(), context.getClickedFace(), context.getPlayer(), context.getItemInHand());
      return InteractionResult.SUCCESS;
   }
}
