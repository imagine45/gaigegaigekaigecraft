package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class AIRideableControlProcedure {
   public AIRideableControlProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double speed = 0.0;
         Entity owner_uuid = null;
         owner_uuid = entity.getFirstPassenger();
         if (owner_uuid instanceof LivingEntity) {
            entity.fallDistance = 0.0F;
            owner_uuid.fallDistance = 0.0F;
            entity.setYRot(owner_uuid.getYRot());
            entity.setXRot(owner_uuid.getXRot());
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            if (owner_uuid instanceof Player) {
               if (owner_uuid.getPersistentData().getBoolean("PRESS_SPACE") && entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 5, 19, false, false));
                  }
               }

               if (owner_uuid.getPersistentData().getBoolean("PRESS_W")) {
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 10, 9, false, false));
                     }
                  }

                  speed = Math.sqrt(Math.pow(entity.getDeltaMovement().x(), 2.0) + Math.pow(entity.getDeltaMovement().y(), 2.0) + Math.pow(entity.getDeltaMovement().z(), 2.0));
                  speed = Math.min(speed + 0.2, 1.25);
                  entity.setDeltaMovement(new Vec3(owner_uuid.getLookAngle().x * speed, owner_uuid.getLookAngle().y * speed, owner_uuid.getLookAngle().z * speed));
               }
            }
         }

      }
   }
}
