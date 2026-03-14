package org.imgaine.gaigegaigekaigecraft.item;

import org.imgaine.gaigegaigekaigecraft.procedures.SukunaFingerFoodEatenProcedure;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class SukunaFingerItem extends Item {
   public SukunaFingerItem() {
      super((new Item.Properties()).m_41487_(20).m_41486_().m_41497_(Rarity.EPIC).m_41489_((new FoodProperties.Builder()).m_38760_(2).m_38758_(0.3F).m_38765_().m_38767_()));
   }

   public int m_8105_(ItemStack itemstack) {
      return 16;
   }

   public float m_8102_(ItemStack par1ItemStack, BlockState par2Block) {
      return 0.0F;
   }

   public ItemStack m_5922_(ItemStack itemstack, Level world, LivingEntity entity) {
      ItemStack retval = super.m_5922_(itemstack, world, entity);
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      SukunaFingerFoodEatenProcedure.execute(world, x, y, z, entity);
      return retval;
   }
}
