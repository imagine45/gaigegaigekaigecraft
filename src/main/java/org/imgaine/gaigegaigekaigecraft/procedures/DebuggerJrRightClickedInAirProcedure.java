package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class DebuggerJrRightClickedInAirProcedure {
   public DebuggerJrRightClickedInAirProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putDouble("skill", 2020.0);
         entity.getPersistentData().putDouble("cnt1", 0.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
         entity.getPersistentData().putDouble("cnt3", 0.0);
         entity.getPersistentData().putDouble("Damage", 0.0);
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 2147483647, 0, false, false));
            }
         }

      }
   }
}
