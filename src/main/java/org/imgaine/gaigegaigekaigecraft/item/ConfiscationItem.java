package org.imgaine.gaigegaigekaigecraft.item;

import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.ConfiscationRightclickedProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class ConfiscationItem extends Item {
   public ConfiscationItem() {
      super((new Item.Properties()).stacksTo(64).rarity(Rarity.COMMON));
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.translatable("item.gaigegaigekaigecraft.confiscation.description_0"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      ConfiscationRightclickedProcedure.execute(entity, (ItemStack)ar.getObject());
      return ar;
   }
}
