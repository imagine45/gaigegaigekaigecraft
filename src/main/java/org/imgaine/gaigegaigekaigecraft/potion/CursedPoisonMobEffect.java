package org.imgaine.gaigegaigekaigecraft.potion;

import java.util.ArrayList;
import java.util.List;
import org.imgaine.gaigegaigekaigecraft.procedures.CursedPoisonOnEffectActiveTickProcedure;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class CursedPoisonMobEffect extends MobEffect {
   public CursedPoisonMobEffect() {
      super(MobEffectCategory.HARMFUL, -10092442);
   }

   public List<ItemStack> getCurativeItems() {
      ArrayList<ItemStack> cures = new ArrayList();
      cures.add(new ItemStack(Items.MILK_BUCKET));
      cures.add(new ItemStack(Items.TOTEM_OF_UNDYING));
      cures.add(new ItemStack(Items.HONEY_BOTTLE));
      return cures;
   }

   public void applyEffectTick(LivingEntity entity, int amplifier) {
      CursedPoisonOnEffectActiveTickProcedure.execute(entity.level(), entity);
   }

   public boolean isDurationEffectTick(int duration, int amplifier) {
      return true;
   }
}
