package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.item.ItemStack;

public class ConvergenceMobEffect extends MobEffect {
   public ConvergenceMobEffect() {
      super(MobEffectCategory.NEUTRAL, -10092544);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
