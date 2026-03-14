package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.EntityProjectionSorceryEntity;
import net.minecraft.world.entity.Entity;

public class EntityProjectionSorceryDisplayConditionProcedure {
   public EntityProjectionSorceryDisplayConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         int var10000;
         if (entity instanceof EntityProjectionSorceryEntity) {
            EntityProjectionSorceryEntity _datEntI = (EntityProjectionSorceryEntity)entity;
            var10000 = (Integer)_datEntI.m_20088_().m_135370_(EntityProjectionSorceryEntity.DATA_cnt_skin);
         } else {
            var10000 = 0;
         }

         return var10000 >= 2;
      }
   }
}
