package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class HanamiSpearProcedure {
   public HanamiSpearProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         boolean logic_a = false;
         boolean logic_b = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double yaw = 0.0;
         double picth = 0.0;
         double num1 = 0.0;
         double range = 0.0;
         double num2 = 0.0;
         double mode = 0.0;
         if (entity.getPersistentData().getDouble("cnt7") == 0.0) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               mode = Math.random() < 0.5 ? 2.0 : 1.0;
            } else {
               mode = entity.isShiftKeyDown() ? 2.0 : 1.0;
            }

            entity.getPersistentData().putDouble("cnt7", (double)Math.round(mode));
         }

         if (entity.getPersistentData().getDouble("cnt7") == 1.0) {
            HanamiSpear1Procedure.execute(world, entity);
         } else {
            HanamiSpear2Procedure.execute(world, entity);
         }

      }
   }
}
