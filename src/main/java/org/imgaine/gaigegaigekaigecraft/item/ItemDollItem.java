package org.imgaine.gaigegaigekaigecraft.item;

import org.imgaine.gaigegaigekaigecraft.procedures.HumanStockRightClickedInAirProcedure;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.context.UseOnContext;

public class ItemDollItem extends Item {
   public ItemDollItem() {
      super((new Item.Properties()).m_41487_(64).m_41497_(Rarity.COMMON));
   }

   public UseAnim m_6164_(ItemStack itemstack) {
      return UseAnim.EAT;
   }

   public InteractionResult m_6225_(UseOnContext context) {
      super.m_6225_(context);
      HumanStockRightClickedInAirProcedure.execute(context.m_43725_(), (double)context.m_8083_().m_123341_(), (double)context.m_8083_().m_123342_(), (double)context.m_8083_().m_123343_(), context.m_43719_(), context.m_43723_(), context.m_43722_());
      return InteractionResult.SUCCESS;
   }
}
