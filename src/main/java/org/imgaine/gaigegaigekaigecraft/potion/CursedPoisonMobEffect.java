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
      cures.add(new ItemStack(Items.f_42455_));
      cures.add(new ItemStack(Items.f_42747_));
      cures.add(new ItemStack(Items.f_42787_));
      return cures;
   }

   public void m_6742_(LivingEntity entity, int amplifier) {
      CursedPoisonOnEffectActiveTickProcedure.execute(entity.m_9236_(), entity);
   }

   public boolean m_6584_(int duration, int amplifier) {
      return true;
   }
}
