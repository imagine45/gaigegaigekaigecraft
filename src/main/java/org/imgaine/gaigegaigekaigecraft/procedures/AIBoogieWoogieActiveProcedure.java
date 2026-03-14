package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.level.LevelAccessor;

public class AIBoogieWoogieActiveProcedure {
   public AIBoogieWoogieActiveProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double dis = 0.0;
         double x_power = 0.0;
         double y_power = 0.0;
         double z_power = 0.0;
         double velocity = 0.0;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         if (entity.m_6084_()) {
            LivingEntity var10000;
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.m_5448_();
            } else {
               var10000 = null;
            }

            if (var10000 instanceof LivingEntity) {
               if (LogicStartPassiveProcedure.execute(entity)) {
                  entity.getPersistentData().m_128347_("cnt_boogie_woogie", entity.getPersistentData().m_128459_("cnt_boogie_woogie") + 1.0);
                  if (entity.getPersistentData().m_128459_("cnt_boogie_woogie") > 10.0) {
                     entity.getPersistentData().m_128347_("cnt_boogie_woogie", 0.0);
                     SkillBoogieWoogieProcedure.execute(world, x, y, z, entity);
                  }
               }
            } else {
               entity.getPersistentData().m_128347_("cnt_boogie_woogie", 0.0);
            }
         }

      }
   }
}
