package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class BulletBallProjectileWhileProjectileFlyingTickProcedure {
   public BulletBallProjectileWhileProjectileFlyingTickProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity immediatesourceentity) {
      if (entity != null && immediatesourceentity != null) {
         immediatesourceentity.getPersistentData().m_128347_("cnt_life", immediatesourceentity.getPersistentData().m_128459_("cnt_life") + 1.0);
         if (immediatesourceentity.getPersistentData().m_128459_("cnt_life") > 20.0) {
            BulletBallProjectileProjectileHitsBlockProcedure.execute(world, x, y, z, entity);
            if (!immediatesourceentity.m_9236_().m_5776_()) {
               immediatesourceentity.m_146870_();
            }
         }

      }
   }
}
