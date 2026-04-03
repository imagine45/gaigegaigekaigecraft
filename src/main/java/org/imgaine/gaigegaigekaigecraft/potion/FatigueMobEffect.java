package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class FatigueMobEffect extends MobEffect {
   public FatigueMobEffect() {
      super(MobEffectCategory.HARMFUL, -16777216);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      cures.add(new ItemStack(Items.MILK_BUCKET));
      cures.add(new ItemStack(Items.TOTEM_OF_UNDYING));
      cures.add(new ItemStack(Items.HONEY_BOTTLE));
      return cures;
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
