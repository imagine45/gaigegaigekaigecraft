package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class InsideSolidProcedure {
   public InsideSolidProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         return entity.m_5830_() ? true : InsideSolidCalculateProcedure.execute(world, entity.m_20185_(), entity.m_20186_(), entity.m_20189_(), (double)entity.m_20206_(), (double)entity.m_20205_());
      }
   }
}
