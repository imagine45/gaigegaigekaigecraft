package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RotateEntityProcedure {
   public RotateEntityProcedure() {
   }

   public static void execute(double x, double y, double z, Entity entity) {
      if (entity != null) {
         double yaw = 0.0;
         double pitch = 0.0;
         double distance = 0.0;
         double dx = 0.0;
         double dy = 0.0;
         double dz = 0.0;
         double atan2_result = 0.0;
         dx = x - entity.m_20185_();
         dy = y - (entity.m_20186_() + (double)entity.m_20206_() * 0.9);
         dz = z - entity.m_20189_();
         if (dz == 0.0) {
            if (dx > 0.0) {
               atan2_result = 90.0;
            } else if (dx < 0.0) {
               atan2_result = -90.0;
            } else {
               atan2_result = 0.0;
            }
         } else if (dx == 0.0) {
            if (dz > 0.0) {
               atan2_result = 0.0;
            } else {
               atan2_result = 180.0;
            }
         } else {
            atan2_result = Math.toDegrees(Math.atan(dx / dz));
            if (dz < 0.0) {
               atan2_result += (double)(dx > 0.0 ? 180 : -180);
            }
         }

         distance = Math.sqrt(dx * dx + dz * dz + dy * dy);
         yaw = -1.0 * atan2_result;
         pitch = Math.toDegrees(distance == 0.0 ? 0.0 : -1.0 * Math.asin(dy / distance));
         entity.m_146922_((float)yaw);
         entity.m_146926_((float)pitch);
         entity.m_5618_(entity.m_146908_());
         entity.m_5616_(entity.m_146908_());
         entity.f_19859_ = entity.m_146908_();
         entity.f_19860_ = entity.m_146909_();
         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.f_20884_ = _entity.m_146908_();
            _entity.f_20886_ = _entity.m_146908_();
         }

      }
   }
}
