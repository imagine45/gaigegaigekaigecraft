package org.imgaine.gaigegaigekaigecraft.item;

import org.imgaine.gaigegaigekaigecraft.procedures.PendantTodoAoiItemIsDroppedByPlayerProcedure;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.UseAnim;

public class PendantTodoAoiItem extends Item {
   public PendantTodoAoiItem() {
      super((new Item.Properties()).stacksTo(1).rarity(Rarity.COMMON));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.EAT;
   }

   public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
      PendantTodoAoiItemIsDroppedByPlayerProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
      return true;
   }
}
