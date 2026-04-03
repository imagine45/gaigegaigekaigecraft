package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class CeremonialSeaofLightActiveProcedure {
   public CeremonialSeaofLightActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double range;
         double var10000;
         label78: {
            double distance = 0.0;
            double ticks = 0.0;
            double num1 = 0.0;
            range = 0.0;
            double rad1 = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double z_pos = 0.0;
            range = JujutsucraftModVariables.MapVariables.get(world).DomainExpansionRadius * 2.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get()).getDuration();
                  break label78;
               }
            }

            var10000 = 0.0;
         }

         double var30 = var10000;
         if (var30 % 10.0 == 0.0) {
            entity.getPersistentData().putBoolean("onlyLiving", true);
            Vec3 _center = new Vec3(entity.getPersistentData().getDouble("x_pos_doma"), entity.getPersistentData().getDouble("y_pos_doma"), entity.getPersistentData().getDouble("z_pos_doma"));

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(range / 2.0), (e) -> true)) {
               if (entity != entityiterator && LogicAttackDomainProcedure.execute(world, entity, entityiterator) && !entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:ranged_ammo")))) {
                  double var31 = 20.0;
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int)var31, 4, false, false));
                     }
                  }

                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, (int)var31, 2, false, false));
                     }
                  }
               }
            }

            entity.getPersistentData().putBoolean("onlyLiving", false);
         }

         if (entity.getPersistentData().getBoolean("Failed")) {
            if (entity.onGround() && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), x, y, z, 20, 1.0, 0.0, 1.0, 0.05);
            }
         } else {
            double var33 = Math.toRadians(90.0 * (var30 % 4.0));
            double var29 = 4.0 * var30 % (range * 0.5 - 5.0);

            for(int index0 = 0; index0 < 5; ++index0) {
               for(int index1 = 0; index1 < 72; ++index1) {
                  if (!(Math.random() < 0.9)) {
                     var33 += Math.toRadians(10.0 * Math.random());
                     double var34 = entity.getPersistentData().getDouble("x_pos_doma") + Math.cos(var33) * var29;
                     double var35 = entity.getPersistentData().getDouble("y_pos_doma") + 0.1;
                     double var36 = entity.getPersistentData().getDouble("z_pos_doma") + Math.sin(var33) * var29;
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_FLOWER.get(), var34, var35, var36, 1, 0.2, 0.1, 0.2, 0.01);
                     }
                  }
               }

               ++var29;
            }
         }

      }
   }
}
