package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetoSuguruEntityDiesProcedure {
   public GetoSuguruEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (!entity.m_6084_() && !entity.getPersistentData().m_128471_("use_uzumaki")) {
            for(int index0 = 0; index0 < 20; ++index0) {
               entity.getPersistentData().m_128347_("cnt2", 0.0);
               entity.getPersistentData().m_128347_("num_grade0", 0.0);
               entity.getPersistentData().m_128347_("num_grade1", 0.0);
               GetoSpawnCurseRandomProcedure.execute(world, entity);
            }
         }

      }
   }
}
