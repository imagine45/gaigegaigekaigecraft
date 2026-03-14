package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.Comparator;
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
         effect = entity.getPersistentData().m_128459_("effect");
         Y_limit = 1.5;
         Vec3 _center = new Vec3(x, y, z);

         for(Entity entityiterator : world.m_6443_(Entity.class, (new AABB(_center, _center)).m_82400_(entity.getPersistentData().m_128459_("Range") / 2.0), (e) -> true).stream().sorted(Comparator.comparingDouble((_entcnd) -> _entcnd.m_20238_(_center))).toList()) {
            if (entity != entityiterator) {
               if (entityiterator instanceof LivingEntity) {
                  LivingEntity _livEnt3 = (LivingEntity)entityiterator;
                  if (_livEnt3.m_21023_((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     continue;
                  }
               }

               if (!(entityiterator instanceof LivingEntity) || LogicAttackProcedure.execute(world, entity, entityiterator)) {
                  if (effect == 1.0) {
                     x_knockback = entityiterator.m_20185_() - x;
                     y_knockback = entityiterator.m_20186_() - y;
                     z_knockback = entityiterator.m_20189_() - z;
                  } else {
                     x_knockback = entityiterator.m_20185_() - entity.m_20185_();
                     y_knockback = entityiterator.m_20186_() - entity.m_20186_();
                     z_knockback = entityiterator.m_20189_() - entity.m_20189_();
                  }

                  if (entityiterator.m_20096_() || y_knockback == 0.0) {
                     y_knockback = Math.max(Math.abs(y_knockback), 0.42);
                  }

                  if (x_knockback == 0.0 && z_knockback == 0.0) {
                     x_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * -1.0, y_knockback);
                     z_knockback = Mth.m_216263_(RandomSource.m_216327_(), y_knockback * -1.0, y_knockback);
                  }

                  distance = Math.sqrt(x_knockback * x_knockback + y_knockback * y_knockback + z_knockback * z_knockback);
                  if (distance != 0.0) {
                     knockback = entity.getPersistentData().m_128459_("knockback") * 3.0;
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

                  x_knockback += entity.getPersistentData().m_128459_("x_knockback");
                  y_knockback += entity.getPersistentData().m_128459_("y_knockback");
                  z_knockback += entity.getPersistentData().m_128459_("z_knockback");
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livingEntity21 = (LivingEntity)entity;
                     if (_livingEntity21.m_21204_().m_22171_(Attributes.f_22278_)) {
                        double var10000;
                        label55: {
                           if (entityiterator instanceof LivingEntity) {
                              LivingEntity _livingEntity22 = (LivingEntity)entityiterator;
                              if (_livingEntity22.m_21204_().m_22171_(Attributes.f_22278_)) {
                                 var10000 = _livingEntity22.getAttribute_(Attributes.f_22278_).m_22115_();
                                 break label55;
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
                  entityiterator.getPersistentData().m_128347_("old_x_position", entityiterator.getPersistentData().m_128459_("old_x_position") - x_knockback);
                  entityiterator.getPersistentData().m_128347_("old_y_position", entityiterator.getPersistentData().m_128459_("old_y_position") - y_knockback);
                  entityiterator.getPersistentData().m_128347_("old_z_position", entityiterator.getPersistentData().m_128459_("old_z_position") - z_knockback);
               }
            }
         }

         entity.getPersistentData().m_128347_("effect", 0.0);
         entity.getPersistentData().m_128347_("knockback", 0.0);
      }
   }
}
