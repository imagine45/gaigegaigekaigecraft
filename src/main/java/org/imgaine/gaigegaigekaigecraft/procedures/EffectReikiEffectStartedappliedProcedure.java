package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

public class EffectReikiEffectStartedappliedProcedure {
   public EffectReikiEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         ItemStack item_a = ItemStack.f_41583_;
         double num_level = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity1 = (LivingEntity)entity;
            if (_livingEntity1.m_21204_().m_22171_(Attributes.f_22285_)) {
               AttributeInstance var10000;
               double var10001;
               label18: {
                  var10000 = _livingEntity1.getAttribute_(Attributes.f_22285_);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity0 = (LivingEntity)entity;
                     if (_livingEntity0.m_21204_().m_22171_(Attributes.f_22285_)) {
                        var10001 = _livingEntity0.getAttribute_(Attributes.f_22285_).m_22115_();
                        break label18;
                     }
                  }

                  var10001 = 0.0;
               }

               var10000.m_22100_(var10001 + 5.0);
            }
         }

      }
   }
}
