package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

public class DeepConcentrationMobEffect extends MobEffect {
   public DeepConcentrationMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -3355393);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
