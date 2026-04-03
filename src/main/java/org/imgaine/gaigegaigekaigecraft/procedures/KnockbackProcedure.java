package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class KnockbackProcedure {
   public KnockbackProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double x_knockback = 0.0;
         double z_knockback = 0.0;
         double y_knockback = 0.0;
         double knockback = 0.0;
         double distance = 0.0;
         double H_original = 0.0;
         double M_original = 0.0;
         double Y_limit = 0.0;
         double effect = 0.0;
         effect = entity.getPersistentData().getDouble("effect");
         Y_limit = 1.5;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(entity.getPersistentData().getDouble("Range") / 2.0), (e) -> true)) {
            if (entity != entityiterator) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entityiterator;
                  if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     continue;
                  }
               }

               if (!(entityiterator instanceof LivingEntity) || LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  if (effect == 1.0) {
                     x_knockback = entityiterator.getX() - x;
                     y_knockback = entityiterator.getY() - y;
                     z_knockback = entityiterator.getZ() - z;
                  } else {
                     x_knockback = entityiterator.getX() - entity.getX();
                     y_knockback = entityiterator.getY() - entity.getY();
                     z_knockback = entityiterator.getZ() - entity.getZ();
                  }

                  if (x_knockback == 0.0 && z_knockback == 0.0) {
                     x_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0, y_knockback);
                     z_knockback = Mth.nextDouble(RandomSource.create(), y_knockback * -1.0, y_knockback);
                  }

                  distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                  if (distance != 0.0) {
                     knockback = entity.getPersistentData().getDouble("knockback") * 3.0;
                     x_knockback = x_knockback / distance * knockback;
                     y_knockback = y_knockback / distance * knockback;
                     z_knockback = z_knockback / distance * knockback;
                     if (y_knockback > Y_limit) {
                        M_original = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                        H_original = Math.sqrt(x_knockback * x_knockback + z_knockback * z_knockback);
                        knockback = Math.sqrt(M_original * M_original - Y_limit * Y_limit);
                        knockback /= H_original != 0.0 ? H_original : 1.0;
                        x_knockback *= knockback;
                        y_knockback = Y_limit;
                        z_knockback *= knockback;
                     }
                  }

                  x_knockback += entity.getPersistentData().getDouble("x_knockback");
                  y_knockback += entity.getPersistentData().getDouble("y_knockback");
                  z_knockback += entity.getPersistentData().getDouble("z_knockback");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity20 = (LivingEntity)entity;
                     if (_livingEntity20.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                        double var10000;
                        label52: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity21 = (LivingEntity)entityiterator;
                              if (_livingEntity21.getAttributes().hasAttribute(Attributes.KNOCKBACK_RESISTANCE)) {
                                 var10000 = _livingEntity21.getAttribute(Attributes.KNOCKBACK_RESISTANCE).getBaseValue();
                                 break label52;
                              }
                           }

                           var10000 = 0.0;
                        }

                        knockback = Math.sqrt(Math.max(var10000, 0.0) + 1.0);
                        x_knockback /= knockback;
                        y_knockback /= knockback;
                        z_knockback /= knockback;
                     }
                  }

                  EntityVectorProcedure.execute(entityiterator, x_knockback, y_knockback, z_knockback);
               }
            }
         }

         entity.getPersistentData().putDouble("effect", 0.0);
      }
   }
}
