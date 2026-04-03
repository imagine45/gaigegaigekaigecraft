package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.StarRageEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.StarRageOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class StarRageMobEffect extends MobEffect {
   public StarRageMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -205);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      StarRageEffectStartedappliedProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      StarRageOnEffectActiveTickProcedure.execute(entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      StarRageEffectStartedappliedProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
