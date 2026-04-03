package org.imgaine.gaigegaigekaigecraft.item;

import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.SupremeMartialSolutionRightClickedInAirProcedure;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class SupremeMartialSolutionItem extends SwordItem {
   public SupremeMartialSolutionItem() {
      super(new Tier() {
         public int getUses() {
            return 2831;
         }

         public float getSpeed() {
            return 4.0F;
         }

         public float getAttackDamageBonus() {
            return -1.0F;
         }

         public int getLevel() {
            return 1;
         }

         public int getEnchantmentValue() {
            return 2;
         }

         public Ingredient getRepairIngredient() {
            return Ingredient.of();
         }
      }, 3, -2.2F, new Item.Properties());
   }

   public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
      InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
      SupremeMartialSolutionRightClickedInAirProcedure.execute(world, entity);
      return ar;
   }

   public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.appendHoverText(itemstack, level, list, flag);
      list.add(Component.translatable("item.gaigegaigekaigecraft.supreme_martial_solution.description_0"));
      list.add(Component.translatable("item.gaigegaigekaigecraft.supreme_martial_solution.description_1"));
   }
}
