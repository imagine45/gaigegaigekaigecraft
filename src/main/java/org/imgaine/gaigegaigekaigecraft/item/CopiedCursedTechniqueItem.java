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
      super((new Item.Properties()).stacksTo(10).fireResistant().rarity(Rarity.RARE));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      CopiedCursedTechniqueRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }

   public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
      super.inventoryTick(itemstack, world, entity, slot, selected);
      SwordOkkotsuYutaToolInInventoryTickProcedure.execute(world, entity, itemstack);
   }
}
