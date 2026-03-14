package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModParticleTypes;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class ChargeParticleProcedure {
   public ChargeParticleProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity, double mode) {
      if (entity != null) {
         double entity_size = 0.0;
         double select_color = 0.0;
         entity_size = ReturnEntitySizeProcedure.execute(entity);
         if (mode == 0.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123797_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
            }
         } else if (mode == 1.0) {
            if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
            }
         } else if (mode == 10.0) {
            select_color = ReturnEnergyColorProcedure.execute(entity);
            if (select_color == 1.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_BLUE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }
            } else if (select_color == 2.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_ORANGE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }
            } else if (select_color == 3.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_RED.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }
            } else if (select_color == 4.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_GREEN.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }
            } else if (select_color == 5.0) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_((SimpleParticleType)JujutsucraftModParticleTypes.PARTICLE_CURSE_POWER_PURPLE.get(), entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(1.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
               }
            } else if (world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123808_, entity.m_20185_(), entity.m_20186_() + (double)entity.m_20206_() * 0.5, entity.m_20189_(), (int)(2.0 * entity_size), (double)entity.m_20205_() * 0.5, (double)entity.m_20206_() * 0.5, (double)entity.m_20205_() * 0.5, 0.0);
            }
         }

      }
   }
}
