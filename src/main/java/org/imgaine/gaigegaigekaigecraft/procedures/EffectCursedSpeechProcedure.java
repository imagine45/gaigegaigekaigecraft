package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class EffectCursedSpeechProcedure {
   public EffectCursedSpeechProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = 0.0;
         double power = 0.0;
         effect = entity.getPersistentData().getDouble("effect");
         if (effect == 305.0) {
            EffectCursedSpeechExplodeProcedure.execute(world, entity, entityiterator);
            power = 1.5;
         } else if (effect == 306.0) {
            EffectCursedSpeechGetCrushedProcedure.execute(world, entity, entityiterator);
            power = 1.2;
         } else if (effect == 307.0) {
            EffectCursedSpeechCrumbleAwayProcedure.execute(world, entity, entityiterator);
            power = 2.0;
         } else if (effect == 308.0) {
            EffectCursedSpeechDontMoveProcedure.execute(entity, entityiterator);
            power = 1.0;
         } else if (effect == 309.0) {
            EffectCursedSpeechBlastAwayProcedure.execute(entity, entityiterator);
            power = 1.3;
         } else {
            EffectCursedSpeech1Procedure.execute(entity, entityiterator);
            power = 1.0;
         }

         int var10000;
         label31: {
            if (entityiterator instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entityiterator;
               if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                  var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                  break label31;
               }
            }

            var10000 = 0;
         }

         power = (double)Math.max(var10000 - 4, 0) * power;
         entity.getPersistentData().putDouble("cnt10", Math.max(Math.max(entity.getPersistentData().getDouble("cnt10"), power), 1.0));
      }
   }
}
