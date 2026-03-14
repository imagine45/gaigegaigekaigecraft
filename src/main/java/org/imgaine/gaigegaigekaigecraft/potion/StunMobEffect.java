package org.imgaine.gaigegaigekaigecraft.potion;

import org.imgaine.gaigegaigekaigecraft.procedures.StunEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.StunEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.StunOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraftforge.common.ForgeMod;

public class StunMobEffect extends MobEffect {
   public StunMobEffect() {
      super(MobEffectCategory.HARMFUL, -1);
      this.m_19472_(Attributes.f_22284_, "3e398def-7610-3c50-ba1a-0364c03e9168", -0.1, Operation.MULTIPLY_TOTAL);
      this.m_19472_(Attributes.f_22285_, "19b96e1d-5b1c-30a3-b036-ec2f1e71600c", -0.1, Operation.MULTIPLY_TOTAL);
      this.m_19472_(Attributes.f_22281_, "9c4ad7d7-4d9e-3c1e-9b9e-d55bd472a000", -0.1, Operation.MULTIPLY_TOTAL);
      this.m_19472_((Attribute)ForgeMod.BLOCK_REACH.get(), "470877c3-4f65-3ac2-8472-29fb02d1c9f2", -0.5, Operation.MULTIPLY_BASE);
      this.m_19472_(Attributes.f_22279_, "8f387506-5f3d-3ddd-96b9-2b08658abca4", -1.0, Operation.MULTIPLY_TOTAL);
      this.m_19472_((Attribute)ForgeMod.SWIM_SPEED.get(), "31c5a5cd-e7fd-308f-8c33-19b78cc1b30b", -1.0, Operation.MULTIPLY_TOTAL);
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      StunEffectStartedappliedProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, (double)amplifier);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      StunOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      StunEffectExpiresProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
