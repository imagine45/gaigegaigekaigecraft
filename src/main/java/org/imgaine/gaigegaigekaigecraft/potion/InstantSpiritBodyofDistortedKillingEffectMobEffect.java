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

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      InstantSpiritBodyofDistortedKillingEffectEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      InstantSpiritBodyofDistortedKillingEffectOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      InstantSpiritBodyofDistortedKillingEffectEffectExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
