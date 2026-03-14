package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.FlyEffectEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.FlyEffectEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.FlyEffectOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class FlyEffectMobEffect extends MobEffect {
   public FlyEffectMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      FlyEffectEffectStartedappliedProcedure.execute(entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      FlyEffectOnEffectActiveTickProcedure.execute(entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      FlyEffectEffectExpiresProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
