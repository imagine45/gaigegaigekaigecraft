package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class KurourushiBodyHelmetTickEventProcedure {
   public KurourushiBodyHelmetTickEventProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 5, 0, false, false));
            }
         }

      }
   }
}
