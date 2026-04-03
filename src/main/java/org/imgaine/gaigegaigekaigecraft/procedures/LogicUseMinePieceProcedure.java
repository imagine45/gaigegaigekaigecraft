package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.fml.ModList;

public class LogicUseMinePieceProcedure {
   public LogicUseMinePieceProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         logic_a = false;
         if (ModList.get().isLoaded("minepiece") && (entity.getPersistentData().getDouble("Pirate") != 0.0 || entity.getPersistentData().getBoolean("Marine") || entity.getPersistentData().getBoolean("Revolutionary"))) {
            logic_a = true;
         }

         return logic_a;
      }
   }
}
