package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class SizeByNBTProcedure {
   public SizeByNBTProcedure() {
   }

   public static double execute(Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double var10000;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity0 = (LivingEntity)entity;
            if (_livingEntity0.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity1 = (LivingEntity)entity;
                  if (_livingEntity1.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                     var10000 = _livingEntity1.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22135_();
                     return var10000;
                  }
               }

               var10000 = 0.0;
               return var10000;
            }
         }

         var10000 = 1.0;
         return var10000;
      }
   }
}
