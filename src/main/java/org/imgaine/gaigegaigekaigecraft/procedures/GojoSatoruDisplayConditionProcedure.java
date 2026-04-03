package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruEntity;
import net.minecraft.world.entity.Entity;

public class GojoSatoruDisplayConditionProcedure {
   public GojoSatoruDisplayConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (entity instanceof GojoSatoruEntity) {
            GojoSatoruEntity _datEntL0 = (GojoSatoruEntity)entity;
            if ((Boolean)_datEntL0.getEntityData().get(GojoSatoruEntity.DATA_ghost)) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
