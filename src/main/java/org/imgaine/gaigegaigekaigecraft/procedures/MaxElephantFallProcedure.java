package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level.ExplosionInteraction;

public class MaxElephantFallProcedure {
   public MaxElephantFallProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         boolean rotate = false;
         boolean dis = false;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double HP = 0.0;
         double yaw = 0.0;
         double pitch = 0.0;
         double level_jump = 0.0;
         double level = 0.0;
         double level_speed = 0.0;
         if (entity.m_20096_() && entity.getPersistentData().m_128471_("flag_fall")) {
            HP = entity.getPersistentData().m_128459_("skill");
            entity.getPersistentData().m_128347_("skill", 1.0);
            entity.getPersistentData().m_128379_("flag_fall", false);
            entity.getPersistentData().m_128347_("Damage", 14.0);
            entity.getPersistentData().m_128347_("Range", (double)(3.0F + entity.m_20205_()));
            entity.getPersistentData().m_128347_("knockback", 2.0);
            entity.getPersistentData().m_128379_("swing", true);
            entity.getPersistentData().m_128379_("attack", true);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().m_128347_("skill", HP);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.m_5776_()) {
                  _level.m_254849_((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123813_, x, y, z, (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), 0.5 * (double)entity.m_20205_(), 0.0, 0.5 * (double)entity.m_20205_(), 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123796_, x, y, z, (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), 0.5 * (double)entity.m_20205_(), 0.0, 0.5 * (double)entity.m_20205_(), 0.25);
            }
         }

         if (entity.m_20184_().m_7098_() < -0.25) {
            entity.getPersistentData().m_128379_("flag_fall", true);
         } else {
            entity.getPersistentData().m_128379_("flag_fall", false);
         }

      }
   }
}
