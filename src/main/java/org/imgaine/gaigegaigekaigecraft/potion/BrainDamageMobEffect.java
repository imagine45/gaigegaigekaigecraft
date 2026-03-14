package org.imgaine.gaigegaigekaigecraft.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class BrainDamageMobEffect extends MobEffect {
   public BrainDamageMobEffect() {
      super(MobEffectCategory.HARMFUL, -6750208);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
