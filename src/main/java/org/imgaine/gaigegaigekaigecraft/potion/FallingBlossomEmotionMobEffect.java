package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.FallingBlossomEmotionOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class FallingBlossomEmotionMobEffect extends MobEffect {
   public FallingBlossomEmotionMobEffect() {
      super(MobEffectCategory.BENEFICIAL, -13369345);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      return cures;
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      FallingBlossomEmotionOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
