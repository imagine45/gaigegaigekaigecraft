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
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)(entityiterator.getBbHeight() * 0.0F);
         z_pos = entityiterator.getZ();
         Effect4Procedure.execute(world, entity, entityiterator);
         entity.getPersistentData().putDouble("BlockRange", 4.0);
         entity.getPersistentData().putDouble("BlockDamage", 6.0);
         BlockDestroyAllDirectionProcedure.execute(world, x_pos, y_pos, z_pos, entity);
      }
   }
}
