package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.WoodenSpear1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenSpear2Entity;
import net.minecraft.world.entity.Entity;

public class WoodenSpear2OnInitialEntitySpawnProcedure {
   public WoodenSpear2OnInitialEntitySpawnProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         boolean logic_stone = false;
         logic_stone = entity.getPersistentData().getDouble("skill") >= 3200.0 && entity.getPersistentData().getDouble("skill") < 3300.0;
         if (entity instanceof WoodenSpear1Entity) {
            WoodenSpear1Entity _datEntSetL = (WoodenSpear1Entity)entity;
            _datEntSetL.getEntityData().set(WoodenSpear1Entity.DATA_stone, logic_stone);
         }

         if (entity instanceof WoodenSpear2Entity) {
            WoodenSpear2Entity _datEntSetL = (WoodenSpear2Entity)entity;
            _datEntSetL.getEntityData().set(WoodenSpear2Entity.DATA_stone, logic_stone);
         }

      }
   }
}
