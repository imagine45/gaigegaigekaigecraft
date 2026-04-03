package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class GetDistanceNearestEnemyProcedure {
   public GetDistanceNearestEnemyProcedure() {
   }

   public static double execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return 0.0;
      } else {
         double distance = 0.0;
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         distance = var10000 instanceof LivingEntity ? GetDistanceProcedure.execute(entity) : 999.0;
         Vec3 _center = new Vec3(entity.getX() + entity.getLookAngle().x * 16.0, entity.getY() + (double)entity.getBbHeight() * 0.5 + entity.getLookAngle().y * 16.0, entity.getZ() + entity.getLookAngle().z * 16.0);

         for(Entity entityiterator : world.getEntitiesOfClass(Entity.class, (new AABB(_center, _center)).inflate(16.0), (e) -> true)) {
            if (entity != entityiterator && !(entityiterator instanceof Projectile)) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt11 = (LivingEntity)entity;
                  if (_livEnt11.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                     label69: {
                        if (entity instanceof LivingEntity) {
                           LivingEntity _livEnt12 = (LivingEntity)entity;
                           if (_livEnt12.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                              break label69;
                           }
                        }

                        if (!AntiInfinityProcedure.execute(entityiterator)) {
                           continue;
                        }
                     }
                  }
               }

               if (entityiterator instanceof Player) {
                  if (entityiterator instanceof Player) {
                     Player _plr = (Player)entityiterator;
                     if (_plr.getAbilities().instabuild) {
                        continue;
                     }
                  }

                  if (InlineMethodHandler.checkGamemodeSpectator(entityiterator)) {
                     continue;
                  }
               } else {
                  if (entityiterator instanceof Mob) {
                     Mob _mobEnt = (Mob)entityiterator;
                     var10000 = _mobEnt.getTarget();
                  } else {
                     var10000 = null;
                  }

                  if ((!(var10000 instanceof LivingEntity) || !(entityiterator.getPersistentData().getDouble("cnt_target") > 6.0)) && !(entityiterator.getPersistentData().getDouble("Damage") > 0.0) && !(entityiterator.getPersistentData().getDouble("skill") > 0.0)) {
                     continue;
                  }
               }

               if (LogicAttackProcedure.execute(world, entity, entityiterator) && entityiterator.isAlive()) {
                  distance = Math.min(distance, GetDistanceIteratorProcedure.execute(entity, entityiterator));
               }
            }
         }

         return distance;
      }
   }
}
