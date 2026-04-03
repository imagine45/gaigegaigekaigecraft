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
      cures.add(new ItemStack(Items.MILK_BUCKET));
      cures.add(new ItemStack(Items.TOTEM_OF_UNDYING));
      cures.add(new ItemStack(Items.HONEY_BOTTLE));
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      DeathPaintingBloodEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      DeathPaintingBloodOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      DeathPaintingBloodEffectExpiresProcedure.execute(entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
