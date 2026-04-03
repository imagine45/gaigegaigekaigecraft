package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityHandEntity;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenSpear1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenSpear2Entity;
import net.minecraft.world.entity.Entity;

public class WoodenSpear1DisplayConditionProcedure {
   public WoodenSpear1DisplayConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         label42: {
            if (entity instanceof WoodenSpear1Entity) {
               WoodenSpear1Entity _datEntL0 = (WoodenSpear1Entity)entity;
               if ((Boolean)_datEntL0.getEntityData().get(WoodenSpear1Entity.DATA_stone)) {
                  break label42;
               }
            }

            if (entity instanceof WoodenSpear2Entity) {
               WoodenSpear2Entity _datEntL1 = (WoodenSpear2Entity)entity;
               if ((Boolean)_datEntL1.getEntityData().get(WoodenSpear2Entity.DATA_stone)) {
                  break label42;
               }
            }

            if (entity instanceof RockFragmentEntity) {
               RockFragmentEntity _datEntL2 = (RockFragmentEntity)entity;
               if ((Boolean)_datEntL2.getEntityData().get(RockFragmentEntity.DATA_Magma)) {
                  break label42;
               }
            }

            if (entity instanceof EntityHandEntity) {
               EntityHandEntity _datEntL3 = (EntityHandEntity)entity;
               if ((Boolean)_datEntL3.getEntityData().get(EntityHandEntity.DATA_Magma)) {
                  break label42;
               }
            }

            var10000 = false;
            return var10000;
         }

         var10000 = true;
         return var10000;
      }
   }
}
