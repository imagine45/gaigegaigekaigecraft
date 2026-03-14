package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.JackpotEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.JackpotOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class JackpotMobEffect extends MobEffect {
   public JackpotMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -6684775);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void m_6385_(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.m_6385_(entity, attributeMap, amplifier);
      JackpotEffectStartedappliedProcedure.execute(entity.m_9236_(), entity);
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      JackpotOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
