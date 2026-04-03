package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.phys.Vec3;

public class AIAngelProcedure {
   public AIAngelProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double num1 = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num2 = 0.0;
         double num3 = 0.0;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
            num3 = GetHeightFromGroundProcedure.execute(world, entity);
            RotateEntityProcedure.execute(entity_a.getX(), entity_a.getY(), entity_a.getZ(), entity);
            entity.setYRot(entity.getYRot() + 90.0F);
            entity.setXRot((float)(45.0 * (Math.min(num3, 16.0) / 16.0 - 0.5)));
            entity.setYBodyRot(entity.getYRot());
            entity.setYHeadRot(entity.getYRot());
            entity.yRotO = entity.getYRot();
            entity.xRotO = entity.getXRot();
            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.yBodyRotO = _entity.getYRot();
               _entity.yHeadRotO = _entity.getYRot();
            }

            entity.setDeltaMovement(new Vec3(entity.getLookAngle().x * 0.25, entity.getLookAngle().y * 0.25, entity.getLookAngle().z * 0.25));
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
