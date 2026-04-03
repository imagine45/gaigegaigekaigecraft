package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class TsukumoDomainExpansionActiveProcedure {
   public TsukumoDomainExpansionActiveProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double rad;
         double z_center;
         double range;
         double y_center;
         double x_center;
         int var10000;
         label96: {
            boolean logic_a = false;
            z_center = 0.0;
            range = 0.0;
            double x_pos = 0.0;
            y_center = 0.0;
            double z_pos = 0.0;
            double yaw = 0.0;
            double dis = 0.0;
            double x_knockback = 0.0;
            x_center = 0.0;
            rad = 0.0;
            double rad_now = 0.0;
            double z_knockback = 0.0;
            double y_pos = 0.0;
            double y_knockback = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            x_center = entity.getPersistentData().getDouble("x_pos_doma");
            y_center = entity.getPersistentData().getDouble("y_pos_doma");
            z_center = entity.getPersistentData().getDouble("z_pos_doma");
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label96;
               }
            }

            var10000 = 0;
         }

         if (var10000 % 5 == 0 && !entity.getPersistentData().getBoolean("Failed")) {
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.STAR_RAGE.get(), 10, 11, true, true));
               }
            }

            Vec3 _center = new Vec3(x_center, y_center, z_center);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator)) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 6, false, false));
                     }
                  }

                  double var46 = entityiterator.getX() - entityiterator.getX();
                  double var55 = entityiterator.getY() - 5.0 - entityiterator.getY();
                  double var51 = entityiterator.getZ() - entityiterator.getZ();
                  double var44 = Math.sqrt(Math.pow(var46, 2.0) + Math.pow(var55, 2.0) + Math.pow(var51, 2.0));
                  var46 = var46 / var44 * 3.0;
                  var55 = var55 / var44 * 3.0;
                  var51 = var51 / var44 * 3.0;
                  if (!(var46 * 1.1 < entityiterator.getDeltaMovement().x()) && !(var46 * 0.9 > entityiterator.getDeltaMovement().x())) {
                     var46 = entityiterator.getDeltaMovement().x();
                  } else {
                     var46 = entityiterator.getDeltaMovement().x() + var46 * 0.1;
                  }

                  if (!(var55 * 1.1 < entityiterator.getDeltaMovement().y()) && !(var55 * 0.9 > entityiterator.getDeltaMovement().y())) {
                     var55 = entityiterator.getDeltaMovement().y();
                  } else {
                     var55 = entityiterator.getDeltaMovement().y() + var55 * 0.1;
                  }

                  if (!(var51 * 1.1 < entityiterator.getDeltaMovement().z()) && !(var51 * 0.9 > entityiterator.getDeltaMovement().z())) {
                     var51 = entityiterator.getDeltaMovement().z();
                  } else {
                     var51 = entityiterator.getDeltaMovement().z() + var51 * 0.1;
                  }

                  entityiterator.setDeltaMovement(new Vec3(var46, var55, var51));
               }
            }
         }

         double var45 = range * 0.5 - 4.0;
         double var43 = Math.toRadians(Math.random() * 360.0);
         double var50 = Math.toRadians((Math.random() - 0.5) * 180.0);
         boolean var37 = Math.random() < 0.5;

         for(int index0 = 0; index0 < 72; ++index0) {
            if (Math.random() < 0.5) {
               double var40;
               double var42;
               double var54;
               if (var37) {
                  var40 = x_center + Math.cos(rad) * (Math.cos(var50) + Math.abs(Math.sin(var43) * Math.sin(var50))) * var45;
                  var54 = y_center + Math.sin(rad) * Math.sin(var50) * -1.0 * var45;
                  var42 = z_center + Math.sin(rad) * (Math.cos(var50) + Math.abs(Math.cos(var43) * Math.sin(var50))) * var45;
               } else {
                  var40 = x_center + Math.cos(rad) * Math.cos(var50) * var45;
                  var54 = y_center + Math.sin(rad) * var45;
                  var42 = z_center + Math.cos(rad) * Math.sin(var50) * var45;
               }

               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.sendParticles(ParticleTypes.PORTAL, var40, var54, var42, 1, 0.5, 0.5, 0.5, 0.0);
               }
            }

            rad += Math.toRadians(10.0 * Math.random());
         }

      }
   }
}
