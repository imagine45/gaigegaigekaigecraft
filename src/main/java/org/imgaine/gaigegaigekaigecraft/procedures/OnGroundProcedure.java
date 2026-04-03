package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class OnGroundProcedure {
   public OnGroundProcedure() {
   }

   public static boolean execute(LevelAccessor world, Entity entity) {
      if (entity == null) {
         return false;
      } else {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double dis = 0.0;
         double dis_change = 0.0;
         boolean logic_onGround = false;
         logic_onGround = entity.onGround() || entity.isInWaterOrBubble();
         if (!logic_onGround) {
            logic_onGround = entity.getPersistentData().getBoolean("canFly");
            if (!logic_onGround && InsideSolidCalculateProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), (double)entity.getBbHeight(), (double)(entity.getBbWidth() * 2.0F))) {
               logic_onGround = true;
            }
         }

         return logic_onGround;
      }
   }
}
