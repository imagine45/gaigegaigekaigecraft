package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;

public class SkillConsecutiveEffectsProcedure {
   public SkillConsecutiveEffectsProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         boolean SUCCESS = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double pitch = 0.0;
         double yaw = 0.0;
         double rnd = 0.0;
         double dis = 0.0;
         double old_rnd = 0.0;
         double NUM1 = 0.0;
         entity.getPersistentData().putDouble("Reserve", 13.0);
         entity.getPersistentData().putDouble("skill", 0.0);
      }
   }
}
