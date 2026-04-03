package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TraceableEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class InfinityActiveTickProcedure {
   public InfinityActiveTickProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         int var10000;
         label149: {
            boolean isRangedAmmo = false;
            boolean isProjectile = false;
            boolean logic_infinity = false;
            double dx = 0.0;
            double myNameRangedRanged = 0.0;
            double dy = 0.0;
            double dz = 0.0;
            double myNameRanged = 0.0;
            double velocity = 0.0;
            double T1 = 0.0;
            double T2 = 0.0;
            double infinity_radius = 0.0;
            double distance = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get()).getDuration();
                  break label149;
               }
            }

            var10000 = 0;
         }

         label163: {
            if (var10000 % 10 == 5) {
               if (!ActiveTickConditionProcedure.execute(entity) || !LogicStartPassiveProcedure.execute(entity)) {
                  break label163;
               }

               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt1 = (LivingEntity)entity;
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     break label163;
                  }
               }

               label140: {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get())) {
                        var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.SIMPLE_DOMAIN.get()).getAmplifier();
                        break label140;
                     }
                  }

                  var10000 = 0;
               }

               if (var10000 > 0) {
                  break label163;
               }

               if (entity instanceof Player) {
                  label125: {
                     if (entity instanceof LivingEntity) {
                        LivingEntity _livEnt5 = (LivingEntity)entity;
                        if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.SIX_EYES.get())) {
                           break label125;
                        }
                     }

                     JujutsucraftModVariables.PlayerVariables pVars = null;
                     pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
                     pVars.PlayerCursePowerChange -= 5.0;
                     if (pVars.PlayerCursePower + pVars.PlayerCursePowerChange <= 0.0) {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _entity = (LivingEntity)entity;
                           _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
                        }

                        return;
                     }
                  }
               }
            }

            double var38 = entity.getPersistentData().getDouble("NameRanged");
            double var35 = entity.getPersistentData().getDouble("NameRanged_ranged");
            double var40 = (double)(8.0F + Math.max(entity.getBbWidth() * 2.0F, entity.getBbHeight() * 2.0F) * 2.0F);
            Vec3 _center = new Vec3(entity.getX(), entity.getY() + (double)entity.getBbHeight() * 0.5, entity.getZ());

            for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(var40 / 2.0), (e) -> true)) {
               if (entity != entityiterator) {
                  boolean var33 = false;
                  boolean var32 = entityiterator instanceof Projectile;
                  boolean var31 = entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("forge:ranged_ammo"))) || entityiterator.getPersistentData().getDouble("NameRanged_ranged") != 0.0;
                  Vec3 vel = entityiterator.getDeltaMovement();
                  if (var32) {
                     Entity var52;
                     if (entityiterator instanceof TraceableEntity) {
                        TraceableEntity _traceableEntity = (TraceableEntity)entityiterator;
                        var52 = _traceableEntity.getOwner();
                     } else {
                        var52 = null;
                     }

                     if (var52 != entity) {
                        double var34 = entity.getX() - entityiterator.getX();
                        double var36 = _center.y - (entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5);
                        double var37 = entity.getZ() - entityiterator.getZ();
                        double var39 = vel.lengthSqr();
                        if (var34 * vel.x + var36 * vel.y + var37 * vel.z > 0.0 || entityiterator.getPersistentData().getBoolean("Stop")) {
                           double var41 = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                           if (var41 < var40 * 0.25) {
                              var33 = true;
                           } else if (var41 > 0.0 && var39 > var41 * var41) {
                              entityiterator.setDeltaMovement(new Vec3(vel.x / var41 * var40 * 0.25, vel.y / var41 * var40 * 0.25, vel.z / var41 * var40 * 0.25));
                           }
                        }
                     }
                  }

                  if (var31) {
                     var33 = true;
                     if (var35 != 0.0 && (var35 == entityiterator.getPersistentData().getDouble("NameRanged") || var35 == entityiterator.getPersistentData().getDouble("NameRanged_ranged")) || var38 != 0.0 && (var38 == entityiterator.getPersistentData().getDouble("NameRanged_ranged") || var38 == entityiterator.getPersistentData().getDouble("NameRanged"))) {
                        continue;
                     }

                     double var42 = GetDistanceIteratorProcedure.execute(entity, entityiterator);
                     if (var42 > var40 * 0.25) {
                        continue;
                     }
                  }

                  if (var33) {
                     if (!entityiterator.getPersistentData().getBoolean("Stop")) {
                        entityiterator.getPersistentData().putBoolean("Stop", true);
                     }

                     if (var32) {
                        entityiterator.setXRot(entityiterator.getXRot());
                        entityiterator.setYRot(entityiterator.getYRot());
                        entityiterator.setDeltaMovement(new Vec3(entityiterator.getLookAngle().x * 1.0E-5, entityiterator.getLookAngle().y * 1.0E-5, entityiterator.getLookAngle().z * 1.0E-5));
                        entityiterator.fallDistance = 0.0F;
                        if (entityiterator instanceof Arrow || entityiterator instanceof SpectralArrow) {
                           entityiterator.hasImpulse = true;
                           entityiterator.hurtMarked = true;
                        }
                     } else {
                        entityiterator.setDeltaMovement(Vec3.ZERO);
                     }
                  }
               }
            }

            return;
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get());
         }

      }
   }
}
