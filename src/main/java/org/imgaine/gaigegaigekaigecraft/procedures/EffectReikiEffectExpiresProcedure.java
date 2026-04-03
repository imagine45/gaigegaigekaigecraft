package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;

public class EffectReikiEffectExpiresProcedure {
   public EffectReikiEffectExpiresProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity1 = (LivingEntity)entity;
            if (_livingEntity1.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
               AttributeInstance var10000;
               double var10001;
               label18: {
                  var10000 = _livingEntity1.getAttribute(Attributes.ARMOR_TOUGHNESS);
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity0 = (LivingEntity)entity;
                     if (_livingEntity0.getAttributes().hasAttribute(Attributes.ARMOR_TOUGHNESS)) {
                        var10001 = _livingEntity0.getAttribute(Attributes.ARMOR_TOUGHNESS).getBaseValue();
                        break label18;
                     }
                  }

                  var10001 = 0.0;
               }

               var10000.setBaseValue(var10001 - 5.0);
            }
         }

      }
   }
}
