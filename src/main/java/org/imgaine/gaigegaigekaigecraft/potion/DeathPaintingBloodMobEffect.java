package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.DeathPaintingBloodEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DeathPaintingBloodEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DeathPaintingBloodOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DeathPaintingBloodMobEffect extends MobEffect {
   public DeathPaintingBloodMobEffect() {
      super(MobEffectCategory.HARMFUL, -10092544);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      cures.add(new ItemStack(Items.f_42455_));
      cures.add(new ItemStack(Items.f_42747_));
      cures.add(new ItemStack(Items.f_42787_));
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      DeathPaintingBloodEffectStartedappliedProcedure.execute(entity.m_9236_(), entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), entity, (double)amplifier);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      DeathPaintingBloodOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      DeathPaintingBloodEffectExpiresProcedure.execute(entity, (double)amplifier);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
