package org.imgaine.gaigegaigekaigecraft.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class MahitoHand2Item extends SwordItem {
   public MahitoHand2Item() {
      super(new Tier() {
         public int getUses() {
            return 1200;
         }

         public float getSpeed() {
            return 4.0F;
         }

         public float getAttackDamageBonus() {
            return 0.0F;
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
}
