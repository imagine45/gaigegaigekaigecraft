package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class AIResonanceProcedure {
   public AIResonanceProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean SUCCESS = false;
         double CNT6 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double range_fix = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double x_power = 0.0;
         double range = 0.0;
         double NUM1 = 0.0;
         Entity entity_a = null;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("TARGET"));
         if (entity_a instanceof LivingEntity) {
            entity.teleportTo(entity_a.getX() + entity.getPersistentData().getDouble("x_pos"), entity_a.getY() + entity.getPersistentData().getDouble("y_pos"), entity_a.getZ() + entity.getPersistentData().getDouble("z_pos"));
            if (entity instanceof ServerPlayer) {
               ServerPlayer _serverPlayer = (ServerPlayer)entity;
               _serverPlayer.connection.teleport(entity_a.getX() + entity.getPersistentData().getDouble("x_pos"), entity_a.getY() + entity.getPersistentData().getDouble("y_pos"), entity_a.getZ() + entity.getPersistentData().getDouble("z_pos"), entity.getYRot(), entity.getXRot());
            }

            if (entity_a instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity_a;
               if (!_entity.level().isClientSide()) {
                  _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 30, 9, false, false));
               }
            }
         }

         x_pos = entity.getX();
         y_pos = entity.getY() + (double)entity.getBbHeight() * 0.5;
         z_pos = entity.getZ();
         if (entity.getPersistentData().getDouble("cnt1") == 1.0) {
            entity.getPersistentData().putDouble("Damage", 20.0 * CNT6);
            entity.getPersistentData().putDouble("Range", 1.0 * range_fix);
            entity.getPersistentData().putDouble("knockback", 0.5);
            entity.getPersistentData().putDouble("effect", 1.0);
            entity.getPersistentData().putDouble("effectConfirm", 2.0);
            entity.getPersistentData().putBoolean("ignore", true);
            RangeAttackProcedure.execute(world, x_pos, y_pos, z_pos, entity);
         }

         if (entity.getPersistentData().getDouble("cnt1") > 20.0 && !entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
