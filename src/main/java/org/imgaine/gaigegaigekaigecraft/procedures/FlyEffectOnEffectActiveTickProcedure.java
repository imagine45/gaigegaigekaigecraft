package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class FlyEffectOnEffectActiveTickProcedure {
   public FlyEffectOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.fallDistance = 0.0F;
      }
   }
}
