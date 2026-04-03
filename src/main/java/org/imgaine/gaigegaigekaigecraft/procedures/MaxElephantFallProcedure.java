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
         if (entity.onGround() && entity.getPersistentData().getBoolean("flag_fall")) {
            HP = entity.getPersistentData().getDouble("skill");
            entity.getPersistentData().putDouble("skill", 1.0);
            entity.getPersistentData().putBoolean("flag_fall", false);
            entity.getPersistentData().putDouble("Damage", 14.0);
            entity.getPersistentData().putDouble("Range", (double)(3.0F + entity.getBbWidth()));
            entity.getPersistentData().putDouble("knockback", 2.0);
            entity.getPersistentData().putBoolean("swing", true);
            entity.getPersistentData().putBoolean("attack", true);
            RangeAttackProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("skill", HP);
            if (world instanceof Level) {
               Level _level = (Level)world;
               if (!_level.isClientSide()) {
                  _level.explode((Entity)null, x, y, z, 0.0F, ExplosionInteraction.NONE);
               }
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), 0.5 * (double)entity.getBbWidth(), 0.0, 0.5 * (double)entity.getBbWidth(), 0.0);
            }

            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.sendParticles(ParticleTypes.CLOUD, x, y, z, (int)(25.0 * ReturnEntitySizeProcedure.execute(entity)), 0.5 * (double)entity.getBbWidth(), 0.0, 0.5 * (double)entity.getBbWidth(), 0.25);
            }
         }

         if (entity.getDeltaMovement().y() < -0.25) {
            entity.getPersistentData().putBoolean("flag_fall", true);
         } else {
            entity.getPersistentData().putBoolean("flag_fall", false);
         }

      }
   }
}
