package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

public class EffectConfirm2Procedure {
   public EffectConfirm2Procedure() {
   }

   public static void execute(Entity entityiterator) {
      if (entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         entityiterator.getPersistentData().putDouble("Damage", 0.0);
         entityiterator.setDeltaMovement(new Vec3(0.0, 0.0, 0.0));
      }
   }
}
