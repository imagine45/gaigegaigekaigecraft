package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import net.minecraft.world.entity.Entity;

public class LogicAIActiveProcedure {
   public LogicAIActiveProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean logic_a = false;
         logic_a = true;
         if (entity instanceof GojoSatoruSchoolDaysEntity) {
            boolean var10000;
            label22: {
               if (entity instanceof GojoSatoruSchoolDaysEntity) {
                  GojoSatoruSchoolDaysEntity _datEntL1 = (GojoSatoruSchoolDaysEntity)entity;
                  if ((Boolean)_datEntL1.getEntityData().get(GojoSatoruSchoolDaysEntity.DATA_dying)) {
                     var10000 = true;
                     break label22;
                  }
               }

               var10000 = false;
            }

            logic_a = !var10000;
         }

         return logic_a;
      }
   }
}
