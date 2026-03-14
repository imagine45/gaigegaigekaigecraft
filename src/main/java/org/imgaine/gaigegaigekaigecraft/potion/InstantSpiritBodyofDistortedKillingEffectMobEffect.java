package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.InstantSpiritBodyofDistortedKillingEffectEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.InstantSpiritBodyofDistortedKillingEffectEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.InstantSpiritBodyofDistortedKillingEffectOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class InstantSpiritBodyofDistortedKillingEffectMobEffect extends MobEffect {
   public InstantSpiritBodyofDistortedKillingEffectMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -3355444);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      InstantSpiritBodyofDistortedKillingEffectEffectStartedappliedProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, (double)amplifier);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      InstantSpiritBodyofDistortedKillingEffectOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      InstantSpiritBodyofDistortedKillingEffectEffectExpiresProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, (double)amplifier);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
