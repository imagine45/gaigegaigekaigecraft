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

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      GuardSetDamageProcedure.execute(entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      GuardEffectStartedappliedProcedure.execute(entity.level(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      GuardEffectExpiresProcedure.execute(entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
