package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class EntityUseProjectionSorceryProcedure {
   public EntityUseProjectionSorceryProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity && LogicStartPassiveProcedure.execute(entity)) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            LivingEntity _entity = var10000;
            if (_entity instanceof LivingEntity) {
               LivingEntity _livEnt3 = _entity;
               if (_livEnt3.hasEffect((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get())) {
                  return;
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            _entity = var10000;
            if (_entity instanceof LivingEntity) {
               LivingEntity _livEnt5 = _entity;
               if (_livEnt5.hasEffect((MobEffect)JujutsucraftModMobEffects.INFINITY_EFFECT.get())) {
                  return;
               }
            }

            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (((Entity)var10000).getPersistentData().getDouble("select") == 0.0 && GetDistanceProcedure.execute(entity) < 4.0) {
               if (entity instanceof LivingEntity) {
                  _entity = (LivingEntity)entity;
                  _entity.swing(InteractionHand.MAIN_HAND, true);
               }

               if (entity instanceof Mob) {
                  Mob _mobEnt = (Mob)entity;
                  var10000 = _mobEnt.getTarget();
               } else {
                  var10000 = null;
               }

               LivingEntity var9 = var10000;
               if (var9 instanceof LivingEntity) {
                  _entity = var9;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.PROJECTION_SORCERY.get(), 50, 0, true, true));
                  }
               }
            }
         }

      }
   }
}
