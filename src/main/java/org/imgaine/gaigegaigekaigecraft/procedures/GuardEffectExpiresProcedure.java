package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class GuardEffectExpiresProcedure {
   public GuardEffectExpiresProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity.getPersistentData().m_128459_("skill") == 0.0) {
            entity.getPersistentData().m_128347_("Damage", 0.0);
         }

         entity.getPersistentData().m_128379_("swing", false);
         entity.getPersistentData().m_128379_("guard", false);
         if (!(entity instanceof Player)) {
            entity.m_20260_(false);
         }

      }
   }
}
