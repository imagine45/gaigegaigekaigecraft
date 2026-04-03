package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.player.Player;

public class OrcasanRightClickedOnEntityProcedure {
   public OrcasanRightClickedOnEntityProcedure() {
   }

   public static void execute(Entity entity, Entity sourceentity) {
      if (entity != null && sourceentity != null) {
         if (entity instanceof TamableAnimal) {
            TamableAnimal _toTame = (TamableAnimal)entity;
            if (sourceentity instanceof Player) {
               Player _owner = (Player)sourceentity;
               _toTame.tame(_owner);
            }
         }

      }
   }
}
