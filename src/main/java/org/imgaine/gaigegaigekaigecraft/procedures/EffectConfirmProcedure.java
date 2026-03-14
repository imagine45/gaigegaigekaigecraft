package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class EffectConfirmProcedure {
   public EffectConfirmProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double effect = 0.0;
         effect = entity.getPersistentData().m_128459_("effectConfirm");
         if (effect != 0.0) {
            if (effect == 1.0) {
               EffectConfirm1Procedure.execute(world, entityiterator);
            } else if (effect == 2.0) {
               EffectConfirm2Procedure.execute(entityiterator);
            } else if (effect == 3.0) {
               EffectConfirm3Procedure.execute(entityiterator);
            } else if (effect == 4.0) {
               EffectConfirm4Procedure.execute(entityiterator);
            }
         }

         EffectConfilmCharactorProcedure.execute(world, x, y, z, entity, entityiterator);
      }
   }
}
