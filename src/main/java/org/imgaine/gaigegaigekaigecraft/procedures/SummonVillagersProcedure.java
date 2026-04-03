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
            Entity entityToSpawn = EntityType.VILLAGER.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
            if (entityToSpawn != null) {
               entityToSpawn.setYRot((float)Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               entityToSpawn.setYBodyRot((float)Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               entityToSpawn.setYHeadRot((float)Mth.nextDouble(RandomSource.create(), 0.0, 360.0));
               entityToSpawn.setDeltaMovement(Mth.nextDouble(RandomSource.create(), -1.0, 1.0), Mth.nextDouble(RandomSource.create(), -0.25, 0.25), Mth.nextDouble(RandomSource.create(), -1.0, 1.0));
            }
         }
      }

   }
}
