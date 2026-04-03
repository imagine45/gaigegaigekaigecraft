package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.InsectArmorActivetickProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.InsectArmorAppliedProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.InsectArmorExpiresProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class InsectArmorTechniqueMobEffect extends MobEffect {
   public InsectArmorTechniqueMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -10092544);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.addAttributeModifiers(entity, attributeMap, amplifier);
      InsectArmorAppliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      InsectArmorActivetickProcedure.execute(entity.level(), entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      InsectArmorExpiresProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, (double)amplifier);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
