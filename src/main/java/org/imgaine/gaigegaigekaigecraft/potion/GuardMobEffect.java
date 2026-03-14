package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.GuardEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.GuardEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.GuardSetDamageProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class GuardMobEffect extends MobEffect {
   public GuardMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -6684673);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      GuardSetDamageProcedure.execute(entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      GuardEffectStartedappliedProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      GuardEffectExpiresProcedure.execute(entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
