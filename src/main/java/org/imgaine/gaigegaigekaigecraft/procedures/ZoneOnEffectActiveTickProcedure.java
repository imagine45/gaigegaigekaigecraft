package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ZoneOnEffectActiveTickProcedure {
   public ZoneOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (!entity.isAlive() && entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.ZONE.get());
         }

      }
   }
}
