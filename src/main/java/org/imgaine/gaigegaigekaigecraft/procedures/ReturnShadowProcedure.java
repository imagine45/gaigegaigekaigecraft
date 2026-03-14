package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ReturnShadowProcedure {
   public ReturnShadowProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double NUM1 = 0.0;
         double NUM_SUM = 0.0;
         if (entity.getPersistentData().m_128459_("friend_num") != 0.0) {
            entity.getPersistentData().m_128347_("cnt4", 100.0);
            DespawnTenShadowsTechniqueProcedure.execute(world, x, y, z, entity);
         }

         entity.getPersistentData().m_128347_("skill", 0.0);
      }
   }
}
