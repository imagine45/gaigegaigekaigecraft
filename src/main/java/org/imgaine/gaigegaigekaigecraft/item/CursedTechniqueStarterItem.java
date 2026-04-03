package org.imgaine.gaigegaigekaigecraft.item;

import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.CursedTechniqueStarterRightClickedInAirProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;

public class CursedTechniqueStarterItem extends Item {
   public CursedTechniqueStarterItem() {
      super((new Item.Properties()).stacksTo(1).fireResistant().rarity(Rarity.RARE));
   }

   public UseAnim getUseAnimation(ItemStack itemstack) {
      return UseAnim.EAT;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.translatable("item.gaigegaigekaigecraft.cursed_technique_starter.description_0"));
      list.add(Component.translatable("item.gaigegaigekaigecraft.cursed_technique_starter.description_1"));
      list.add(Component.translatable("item.gaigegaigekaigecraft.cursed_technique_starter.description_2"));
      list.add(Component.translatable("item.gaigegaigekaigecraft.cursed_technique_starter.description_3"));
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      CursedTechniqueStarterRightClickedInAirProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, (ItemStack)ar.getObject());
      return ar;
   }
}
