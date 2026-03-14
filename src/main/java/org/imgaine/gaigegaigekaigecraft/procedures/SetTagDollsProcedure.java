package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.Doll1Entity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;

public class SetTagDollsProcedure {
   public SetTagDollsProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double size = 0.0;
         double skin = 0.0;
         if (entity instanceof Doll1Entity) {
            size = 1.0 + Math.random() * Math.random();
            if (Math.random() < 0.975) {
               skin = Math.ceil(Math.random() * 14.0);
            } else {
               skin = 20.0 + Math.floor(Math.random() * 4.0);
            }

            if (entity instanceof Doll1Entity) {
               Doll1Entity animatable = (Doll1Entity)entity;
               animatable.setTexture("doll" + Math.round(skin));
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity2 = (LivingEntity)entity;
               if (_livingEntity2.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  _livingEntity2.getAttribute_((Attribute)JujutsucraftModAttributes.SIZE.get()).m_22100_(size);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.m_21204_().m_22171_(Attributes.f_22279_)) {
                  AttributeInstance var10000;
                  double var10001;
                  label45: {
                     var10000 = _livingEntity4.getAttribute_(Attributes.f_22279_);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity3 = (LivingEntity)entity;
                        if (_livingEntity3.m_21204_().m_22171_(Attributes.f_22279_)) {
                           var10001 = _livingEntity3.getAttribute_(Attributes.f_22279_).m_22115_();
                           break label45;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.m_22100_(var10001 / (size - Math.max(size - 1.0, 0.0) * 0.5));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.m_21204_().m_22171_(Attributes.f_22282_)) {
                  _livingEntity5.getAttribute_(Attributes.f_22282_).m_22100_(size / 2.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.m_21204_().m_22171_(Attributes.f_22278_)) {
                  _livingEntity6.getAttribute_(Attributes.f_22278_).m_22100_(size * 1.25 - 1.0);
               }
            }
         }

         SetTagProcedure.execute(world, entity);
      }
   }
}
