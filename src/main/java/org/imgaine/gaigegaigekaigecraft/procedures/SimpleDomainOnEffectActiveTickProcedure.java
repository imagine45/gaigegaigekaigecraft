package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class SimpleDomainOnEffectActiveTickProcedure {
   public SimpleDomainOnEffectActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         int var10000;
         label128: {
            boolean logic_infinity = false;
            double z_pos = 0.0;
            double num3 = 0.0;
            double strength = 0.0;
            double num1 = 0.0;
            double x_pos = 0.0;
            double y_pos = 0.0;
            double pitch = 0.0;
            double yaw = 0.0;
            double num2 = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                  break label128;
               }
            }

            var10000 = 0;
         }

         if (var10000 > 0 && LogicSimpleDomainProcedure.execute()) {
            label120: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                     break label120;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 5 == 1) {
               SimpleDomainEffectStartedappliedProcedure.execute(world, x, y, z, entity);
            }

            if (!ActiveTickConditionProcedure.execute(entity)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get());
               }

               return;
            }

            label112: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                     break label112;
                  }
               }

               var10000 = 0;
            }

            if (var10000 % 2 == 1) {
               label136: {
                  double var34 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
                  double var39 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2;
                  if (!entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("gaigegaigekaigecraft:can_use_hollow_wicker_basket")))) {
                     label134: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt5 = (LivingEntity)entity;
                           if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get())) {
                              break label134;
                           }
                        }

                        if (!(entity instanceof Player) || var34 != 1.0 && var39 != 1.0 && var34 != 7.0 && var39 != 7.0 && var34 != 12.0 && var39 != 12.0 && var34 != 24.0 && var39 != 24.0 && var34 != 44.0 && var39 != 44.0 && var34 != 45.0 && var39 != 45.0) {
                           break label136;
                        }
                     }
                  }

                  double var38 = Math.toRadians((double)(entity.getYRot() + 90.0F));
                  double var37 = Math.toRadians((double)entity.getXRot());
                  double var35 = entity.getX() + Math.cos(var38) * Math.cos(var37) * (double)(-1.0F - entity.getBbWidth());
                  double var36 = entity.getY() + (double)entity.getBbHeight() * 0.5;
                  double var33 = entity.getZ() + Math.sin(var38) * Math.cos(var37) * (double)(-1.0F - entity.getBbWidth());
                  if (world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_HOLLOW_WICKER_BASKET.get(), var35, var36, var33, 0, 0.0, 0.0, 0.0, 0.0);
                  }
               }
            }

            int var10002;
            double var50;
            label83: {
               var50 = (double)entity.getBbWidth();
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                     var10002 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getDuration();
                     break label83;
                  }
               }

               var10002 = 0;
            }

            double var40 = var50 + 0.025 * (double)var10002;
            var40 = Math.min(var40, entity.getPersistentData().getDouble("skill") == 3105.0 ? 16.0 : 4.0);
            Vec3 _center = new Vec3(x, y, z);

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(var40 * 2.0 / 2.0), (e) -> true)) {
               if (entity != entityiterator && entity.getY() + (double)entity.getBbHeight() >= entityiterator.getY() && entity.getY() <= entityiterator.getY() + (double)entityiterator.getBbHeight()) {
                  if (entityiterator instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entityiterator;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get(), 5, 0, true, true));
                     }
                  }
                  break;
               }
            }
         }

      }
   }
}
