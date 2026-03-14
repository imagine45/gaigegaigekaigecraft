package org.imgaine.gaigegaigekaigecraft.item;

import org.imgaine.gaigegaigekaigecraft.procedures.CopiedCursedTechniqueRightclickedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SwordOkkotsuYutaToolInInventoryTickProcedure;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;

public class CopiedCursedTechniqueItem extends Item {
   public CopiedCursedTechniqueItem() {
      super((new Item.Properties()).m_41487_(10).m_41486_().m_41497_(Rarity.RARE));
   }

   public InteractionResultHolder<ItemStack> m_7203_(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.m_7203_(world, entity, hand);
      CopiedCursedTechniqueRightclickedProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, (ItemStack)ar.m_19095_());
      return ar;
   }

   public void m_6883_(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.m_6883_(itemstack, world, entity, slot, selected);
      SwordOkkotsuYutaToolInInventoryTickProcedure.execute(world, entity, itemstack);
   }
}
