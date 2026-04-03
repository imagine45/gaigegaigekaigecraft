package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class EffectKirinEffectExpiresProcedure {
   public EffectKirinEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Gaigegaigekaigecraft.queueServerWork(1, () -> {
            if (entity instanceof LivingEntity _livEnt0) {
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.EFFECT_KIRIN.get())) {
                  return;
               }
            }

            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 600, 4, true, true));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 600, 2, true, true));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 10, 0, false, false));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME.get(), 600, 4, false, false));
               }
            }

            if (entity instanceof LivingEntity _entity) {
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.COOLDOWN_TIME_COMBAT.get(), 200, 4, false, false));
               }
            }

         });
      }
   }
}
