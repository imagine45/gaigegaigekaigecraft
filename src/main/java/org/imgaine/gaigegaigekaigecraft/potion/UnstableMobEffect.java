package org.imgaine.gaigegaigekaigecraft.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class UnstableMobEffect extends MobEffect {
   public UnstableMobEffect() {
      super(MobEffectCategory.HARMFUL, -1);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
