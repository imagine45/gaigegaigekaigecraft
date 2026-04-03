package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GuardEffectExpiresProcedure {
   public GuardEffectExpiresProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().getDouble("skill") == 0.0) {
            entity.getPersistentData().putDouble("Damage", 0.0);
         }

         entity.getPersistentData().putBoolean("swing", false);
         entity.getPersistentData().putBoolean("guard", false);
         if (!(entity instanceof Player)) {
            entity.setShiftKeyDown(false);
         }

      }
   }
}
