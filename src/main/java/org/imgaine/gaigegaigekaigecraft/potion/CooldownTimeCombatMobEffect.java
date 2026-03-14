package org.imgaine.gaigegaigekaigecraft.potion;

import org.imgaine.gaigegaigekaigecraft.procedures.CooldownTimeCombatEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.CooldownTimeOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;

public class CooldownTimeCombatMobEffect extends MobEffect {
   public CooldownTimeCombatMobEffect() {
      super(MobEffectCategory.HARMFUL, -1);
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      CooldownTimeCombatEffectStartedappliedProcedure.execute(entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      CooldownTimeOnEffectActiveTickProcedure.execute();
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      CooldownTimeCombatEffectStartedappliedProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
