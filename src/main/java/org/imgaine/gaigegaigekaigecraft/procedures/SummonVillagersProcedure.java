package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.level.LevelAccessor;

public class SummonVillagersProcedure {
   public SummonVillagersProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z) {
      for(int index0 = 0; index0 < 10; ++index0) {
         if (world instanceof ServerLevel _level) {
            Entity entityToSpawn = EntityType.f_20492_.m_262496_(_level, BlockPos.m_274561_(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.m_146922_((float)Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               entityToSpawn.m_5618_((float)Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               entityToSpawn.m_5616_((float)Mth.m_216263_(RandomSource.m_216327_(), 0.0, 360.0));
               entityToSpawn.m_20334_(Mth.m_216263_(RandomSource.m_216327_(), -1.0, 1.0), Mth.m_216263_(RandomSource.m_216327_(), -0.25, 0.25), Mth.m_216263_(RandomSource.m_216327_(), -1.0, 1.0));
            }
         }
      }

   }
}
