package org.imgaine.gaigegaigekaigecraft.item;

import java.util.List;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;

public class SplitSoulKatanaItem extends SwordItem {
   public SplitSoulKatanaItem() {
      super(new Tier() {
         public int m_6609_() {
            return 2831;
         }

         public float m_6624_() {
            return 4.0F;
         }

         public float m_6631_() {
            return 4.0F;
         }

         public int m_6604_() {
            return 1;
         }

         public int m_6601_() {
            return 2;
         }

         public Ingredient m_6282_() {
            return Ingredient.m_151265_();
         }
      }, 3, -2.6F, new Item.Properties());
   }

   public void m_7373_(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
      super.m_7373_(itemstack, level, list, flag);
      list.add(Component.m_237115_("item.jujutsucraft.split_soul_katana.description_0"));
      list.add(Component.m_237115_("item.jujutsucraft.split_soul_katana.description_1"));
      list.add(Component.m_237115_("item.jujutsucraft.split_soul_katana.description_2"));
   }
}
