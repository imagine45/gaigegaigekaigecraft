package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.MythicalBeastAmberEffectEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.MythicalBeastAmberEffectEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.MythicalBeastAmberEffectOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class MythicalBeastAmberEffectMobEffect extends MobEffect {
   public MythicalBeastAmberEffectMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -65281);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      MythicalBeastAmberEffectEffectStartedappliedProcedure.execute(entity, (double)amplifier);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      MythicalBeastAmberEffectOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6386_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6386_(entity, attributeMap, amplifier);
      MythicalBeastAmberEffectEffectExpiresProcedure.execute(entity.m_9236_(), entity, (double)amplifier);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
