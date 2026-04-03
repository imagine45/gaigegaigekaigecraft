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

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      CooldownTimeCombatEffectStartedappliedProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      CooldownTimeOnEffectActiveTickProcedure.execute();
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      CooldownTimeCombatEffectStartedappliedProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
