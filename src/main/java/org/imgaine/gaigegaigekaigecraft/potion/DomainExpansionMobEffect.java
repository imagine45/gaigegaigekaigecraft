package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.DomainExpansionEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DomainExpansionEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.DomainExpansionOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class DomainExpansionMobEffect extends MobEffect {
   public DomainExpansionMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      DomainExpansionEffectStartedappliedProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      DomainExpansionOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      DomainExpansionEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
