package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.level.LevelAccessor;

public class StunEffectExpiresProcedure {
   public StunEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity.isAlive()) {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt1 = (LivingEntity)entity;
               if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.STUN.get())) {
                  return;
               }
            }

            if (entity.getPersistentData().getDouble("skill") == 0.0 || entity.getPersistentData().getDouble("skill") == -1000.0) {
               entity.getPersistentData().putDouble("skill", 0.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity5 = (LivingEntity)entity;
                  if (_livingEntity5.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get())) {
                     _livingEntity5.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_1.get()).setBaseValue(-49.0);
                  }
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity6 = (LivingEntity)entity;
                  if (_livingEntity6.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get())) {
                     _livingEntity6.getAttribute((Attribute)JujutsucraftModAttributes.ANIMATION_2.get()).setBaseValue(1.0);
                  }
               }

               PlayAnimationProcedure.execute(world, entity);
               AnimationResetProcedure.execute(entity);
            }
         }

      }
   }
}
