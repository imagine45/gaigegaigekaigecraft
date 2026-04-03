package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class ResetCounterProcedure {
   public ResetCounterProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double number = 0.0;
         double Level = 0.0;
         boolean logic_a = false;
         boolean CREATIVE = false;
         entity.getPersistentData().putDouble("Damage", 0.0);
         entity.getPersistentData().putDouble("cnt1", 0.0);
         entity.getPersistentData().putDouble("cnt2", 0.0);
         entity.getPersistentData().putDouble("cnt3", 0.0);
         entity.getPersistentData().putDouble("cnt4", 0.0);
         entity.getPersistentData().putDouble("cnt5", 0.0);
         entity.getPersistentData().putDouble("cnt6", 0.0);
         entity.getPersistentData().putDouble("cnt7", 0.0);
         entity.getPersistentData().putDouble("cnt8", 0.0);
         entity.getPersistentData().putDouble("cnt9", 0.0);
         entity.getPersistentData().putDouble("cnt10", 0.0);
         entity.getPersistentData().putDouble("COOLDOWN_TICKS", 10.0);
         entity.getPersistentData().putBoolean("attack", false);
         entity.getPersistentData().putBoolean("betrayal", false);
      }
   }
}
