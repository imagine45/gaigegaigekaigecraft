package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class KeyStartTechniqueOnKeyPressedProcedure {
   public KeyStartTechniqueOnKeyPressedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         entity.getPersistentData().putBoolean("PRESS_Z", true);
         StartCursedTechniqueProcedure.execute(world, x, y, z, entity);
      }
   }
}
