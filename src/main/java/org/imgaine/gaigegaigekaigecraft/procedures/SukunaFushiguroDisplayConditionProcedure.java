package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.SukunaFushiguroEntity;
import net.minecraft.world.entity.Entity;

public class SukunaFushiguroDisplayConditionProcedure {
   public SukunaFushiguroDisplayConditionProcedure() {
   }

   public static boolean execute(Entity entity) {
      if (entity == null) {
         return false;
      } else {
         boolean var10000;
         if (entity instanceof SukunaFushiguroEntity) {
            SukunaFushiguroEntity _datEntL0 = (SukunaFushiguroEntity)entity;
            if ((Boolean)_datEntL0.m_20088_().m_135370_(SukunaFushiguroEntity.DATA_perfect_mode)) {
               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }
}
