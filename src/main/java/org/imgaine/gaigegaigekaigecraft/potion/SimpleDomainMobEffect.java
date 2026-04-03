package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.SimpleDomainEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SimpleDomainEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.SimpleDomainOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class SimpleDomainMobEffect extends MobEffect {
   public SimpleDomainMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -1);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      SimpleDomainEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      SimpleDomainOnEffectActiveTickProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      SimpleDomainEffectExpiresProcedure.execute(entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
