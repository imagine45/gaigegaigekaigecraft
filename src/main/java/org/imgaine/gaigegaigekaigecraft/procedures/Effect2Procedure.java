package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class Effect2Procedure {
   public Effect2Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         x_pos = entityiterator.m_20185_();
         y_pos = entityiterator.m_20186_() + (double)(entityiterator.m_20206_() * 0.0F);
         z_pos = entityiterator.m_20189_();
         Effect4Procedure.execute(world, entity, entityiterator);
         entity.getPersistentData().m_128347_("BlockRange", 4.0);
         entity.getPersistentData().m_128347_("BlockDamage", 6.0);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
      }
   }
}
