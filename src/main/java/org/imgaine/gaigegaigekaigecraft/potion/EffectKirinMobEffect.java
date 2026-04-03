package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.EffectKirinEffectExpiresProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.EffectKirinOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.item.ItemStack;

public class EffectKirinMobEffect extends MobEffect {
   public EffectKirinMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -103);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      EffectKirinOnEffectActiveTickProcedure.execute(entity);
   }

   public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
      super.removeAttributeModifiers(entity, attributeMap, amplifier);
      EffectKirinEffectExpiresProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
