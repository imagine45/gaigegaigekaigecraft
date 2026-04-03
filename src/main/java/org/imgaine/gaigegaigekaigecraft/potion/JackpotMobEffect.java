package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.JackpotEffectStartedappliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.JackpotOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ItemStack;

public class JackpotMobEffect extends MobEffect {
   public JackpotMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -6684775);
      this.addAttributeModifier(Attributes.ARMOR, "88d6ac80-6225-397c-bd52-95f8ba78e5ea", 10.0, Operation.ADDITION);
      this.addAttributeModifier(Attributes.ARMOR_TOUGHNESS, "7f8b1b7a-8610-3427-8703-4101ead8a02b", 5.0, Operation.ADDITION);
      this.addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE, "a60c03e9-c5f5-30f0-8ef9-69d8099ed034", 1.0, Operation.ADDITION);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      JackpotEffectStartedappliedProcedure.execute(entity.level(), entity);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      JackpotOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
