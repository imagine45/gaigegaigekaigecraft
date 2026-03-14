package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EffectCursedSpeechProcedure {
   public EffectCursedSpeechProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         if (entity.getPersistentData().m_128459_("effect") == 305.0) {
            EffectCursedSpeechExplodeProcedure.execute(world, entity, entityiterator);
         } else if (entity.getPersistentData().m_128459_("effect") == 306.0) {
            EffectCursedSpeechGetCrushedProcedure.execute(world, entity, entityiterator);
         } else if (entity.getPersistentData().m_128459_("effect") == 307.0) {
            EffectCursedSpeechCrumbleAwayProcedure.execute(world, entity, entityiterator);
         } else if (entity.getPersistentData().m_128459_("effect") == 308.0) {
            EffectCursedSpeechDontMoveProcedure.execute(world, entity, entityiterator);
         } else if (entity.getPersistentData().m_128459_("effect") == 309.0) {
            EffectCursedSpeechBlastAwayProcedure.execute(world, entity, entityiterator);
         } else {
            EffectCursedSpeech1Procedure.execute(world, entity, entityiterator);
         }

      }
   }
}
