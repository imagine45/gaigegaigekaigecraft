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
         if (ModList.get().isLoaded("minepiece") && (entity.getPersistentData().m_128459_("Pirate") != 0.0 || entity.getPersistentData().m_128471_("Marine") || entity.getPersistentData().m_128471_("Revolutionary"))) {
            logic_a = true;
         }

         return logic_a;
      }
   }
}
