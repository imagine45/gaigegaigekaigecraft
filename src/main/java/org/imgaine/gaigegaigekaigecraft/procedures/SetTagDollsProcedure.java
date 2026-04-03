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
               if (_livingEntity2.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.SIZE.get())) {
                  _livingEntity2.getAttribute((Attribute)JujutsucraftModAttributes.SIZE.get()).setBaseValue(size);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity4 = (LivingEntity)entity;
               if (_livingEntity4.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                  AttributeInstance var10000;
                  double var10001;
                  label45: {
                     var10000 = _livingEntity4.getAttribute(Attributes.MOVEMENT_SPEED);
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livingEntity3 = (LivingEntity)entity;
                        if (_livingEntity3.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)) {
                           var10001 = _livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue();
                           break label45;
                        }
                     }

                     var10001 = 0.0;
                  }

                  var10000.setBaseValue(var10001 / (size - Math.max(size - 1.0, 0.0) * 0.5));
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity5 = (LivingEntity)entity;
               if (_livingEntity5.getAttributes().hasAttribute(Attributes.ATTACK_KNOCKBACK)) {
                  _livingEntity5.getAttribute(Attributes.ATTACK_KNOCKBACK).setBaseValue(size / 2.0);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livingEntity6 = (LivingEntity)entity;
               if (_livingEntity6.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                  _livingEntity6.getAttribute(Attributes.KNOCKBACK_RESISTANCE).setBaseValue(size * 1.25 - 1.0);
               }
            }
         }

         SetTagProcedure.execute(world, entity);
      }
   }
}
