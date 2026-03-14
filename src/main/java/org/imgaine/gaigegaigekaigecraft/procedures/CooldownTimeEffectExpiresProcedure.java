package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class CooldownTimeEffectExpiresProcedure {
   public CooldownTimeEffectExpiresProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double StartTimer = 0.0;
         CooldownTimeEffectStartedappliedProcedure.execute(entity);
      }
   }
}
