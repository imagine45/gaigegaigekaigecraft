package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class GetoSuguruEntityDiesProcedure {
   public GetoSuguruEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (!entity.isAlive() && !entity.getPersistentData().getBoolean("use_uzumaki")) {
            for(int index0 = 0; index0 < 20; ++index0) {
               entity.getPersistentData().putDouble("cnt2", 0.0);
               entity.getPersistentData().putDouble("num_grade0", 0.0);
               entity.getPersistentData().putDouble("num_grade1", 0.0);
               GetoSpawnCurseRandomProcedure.execute(world, x, y, z, entity);
            }
         }

      }
   }
}
