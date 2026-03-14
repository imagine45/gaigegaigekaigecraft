package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class KeyReverseCursedTechniqueOnKeyReleasedProcedure {
   public KeyReverseCursedTechniqueOnKeyReleasedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
         }

         entity.getPersistentData().m_128379_("PRESS_M", false);
      }
   }
}
