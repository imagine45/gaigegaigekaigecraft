package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.common.ForgeMod;

public class GetPowerFixProcedure {
   public GetPowerFixProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double playerLevel = 0.0;
         double fix = 0.0;
         boolean logic_fix = false;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect(MobEffects.DAMAGE_BOOST)) {
               int var10000;
               label65: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect(MobEffects.DAMAGE_BOOST)) {
                        var10000 = _livEnt.getEffect(MobEffects.DAMAGE_BOOST).getAmplifier();
                        break label65;
                     }
                  }

                  var10000 = 0;
               }

               playerLevel = (double)Math.min(var10000 + 1, 15);
            }
         }

         fix = 0.75 + playerLevel / 30.0;
         if (entity.isInWaterOrBubble() && !entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:swim_attackable")))) {
            double var14;
            double var10001;
            label57: {
               var14 = fix * 0.5;
               if (entity instanceof LivingEntity) {
                  LivingEntity _livingEntity4 = (LivingEntity)entity;
                  if (_livingEntity4.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
                     label53: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livingEntity5 = (LivingEntity)entity;
                           if (_livingEntity5.getAttributes().hasAttribute((Attribute)ForgeMod.SWIM_SPEED.get())) {
                              var10001 = _livingEntity5.getAttribute((Attribute)ForgeMod.SWIM_SPEED.get()).getValue();
                              break label53;
                           }
                        }

                        var10001 = 0.0;
                     }

                     var10001 = Math.min(var10001, 2.0);
                     break label57;
                  }
               }

               var10001 = 1.0;
            }

            fix = var14 * var10001;
         }

         entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * fix);
         entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * fix);
         entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * fix);
         if (entity.getPersistentData().getBoolean("canFly")) {
            entity.getPersistentData().putBoolean("canFly", false);
         } else {
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt14 = (LivingEntity)entity;
               if (_livEnt14.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                  int var10002;
                  label43: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt = (LivingEntity)entity;
                        if (_livEnt.hasEffect(MobEffects.MOVEMENT_SLOWDOWN)) {
                           var10002 = _livEnt.getEffect(MobEffects.MOVEMENT_SLOWDOWN).getAmplifier();
                           break label43;
                        }
                     }

                     var10002 = 0;
                  }

                  fix = Math.max(1.0 - 0.15 * (double)(var10002 + 1), 0.0);
                  entity.getPersistentData().putDouble("x_power", entity.getPersistentData().getDouble("x_power") * fix);
                  entity.getPersistentData().putDouble("y_power", entity.getPersistentData().getDouble("y_power") * fix);
                  entity.getPersistentData().putDouble("z_power", entity.getPersistentData().getDouble("z_power") * fix);
               }
            }

            entity.getPersistentData().putDouble("y_power", Math.min(entity.getPersistentData().getDouble("y_power"), 1.5));
         }

      }
   }
}
