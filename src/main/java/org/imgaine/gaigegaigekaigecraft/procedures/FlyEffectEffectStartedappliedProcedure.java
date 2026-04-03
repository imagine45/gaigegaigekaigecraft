package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public class FlyEffectEffectStartedappliedProcedure {
   public FlyEffectEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Player) {
            if (entity instanceof Player) {
               Player _plr = (Player)entity;
               if (_plr.getAbilities().instabuild) {
                  return;
               }
            }

            if (entity.getPersistentData().getDouble("skill") > -900.0 && entity instanceof Player) {
               Player _player = (Player)entity;
               _player.getAbilities().mayfly = true;
               _player.onUpdateAbilities();
            }
         }

      }
   }
}
