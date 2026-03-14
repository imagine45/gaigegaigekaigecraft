package org.imgaine.gaigegaigekaigecraft.potion;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class CooldownTimeBackStepMobEffect extends MobEffect {
   public CooldownTimeBackStepMobEffect() {
      super(MobEffectCategory.HARMFUL, -1);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
