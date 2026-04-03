package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class Effect6Procedure {
   public Effect6Procedure() {
   }

   public static void execute(LevelAccessor world, Entity entityiterator) {
      if (entityiterator != null) {
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         Entity entity_a = null;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.ASH, x_pos, y_pos, z_pos, 20, 0.25, 0.5, 0.25, 0.05);
         }

         if (world instanceof ServerLevel) {
            ServerLevel _level = (ServerLevel)world;
            _level.sendParticles(ParticleTypes.FLAME, x_pos, y_pos, z_pos, 10, 0.25, 0.5, 0.25, 0.05);
         }

      }
   }
}
