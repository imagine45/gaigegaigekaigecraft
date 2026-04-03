package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class JogoAshEntityDiesProcedure {
   public JogoAshEntityDiesProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.LARGE_SMOKE, x, y + 1.0, z, 20, 0.2, 0.4, 0.2, 0.2);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.ASH, x, y + 1.0, z, 60, 0.2, 0.4, 0.2, 0.2);
         }

         if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
