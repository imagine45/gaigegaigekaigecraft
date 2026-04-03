package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.entity.JudgemanEntity;
import org.imgaine.gaigegaigekaigecraft.entity.TakadaEntity;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class TakadaOnEntityTickUpdateProcedure {
   public TakadaOnEntityTickUpdateProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         Entity entity_a = null;
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double num1 = 0.0;
         if (LogicOwnerExistProcedure.execute(world, entity)) {
            label51: {
               entity_a = GetEntityFromUUIDProcedure.execute(world, entity.getPersistentData().getString("OWNER_UUID"));
               if (entity_a instanceof LivingEntity) {
                  LivingEntity _livEnt2 = (LivingEntity)entity_a;
                  if (_livEnt2.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                     break label51;
                  }
               }

               if (entity_a.getPersistentData().getDouble("skill") == 0.0) {
                  if (entity instanceof TakadaEntity) {
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.sendParticles(ParticleTypes.END_ROD, x, y + (double)entity.getBbHeight() * 0.5, z, (int)(10.0F + entity.getBbWidth() * entity.getBbWidth() * entity.getBbHeight() * 1.0F), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.0);
                     }
                  } else if (entity instanceof JudgemanEntity && world instanceof ServerLevel) {
                     ServerLevel _level = (ServerLevel)world;
                     _level.sendParticles(ParticleTypes.SQUID_INK, x, y + (double)entity.getBbHeight() * 0.5, z, (int)(10.0F + entity.getBbWidth() * entity.getBbWidth() * entity.getBbHeight() * 1.0F), (double)entity.getBbWidth() * 0.25, (double)entity.getBbHeight() * 0.25, (double)entity.getBbWidth() * 0.25, 0.0);
                  }

                  if (!entity.level().isClientSide()) {
                     entity.discard();
                  }

                  return;
               }
            }

            if (entity instanceof JudgemanEntity && entity_a.getPersistentData().getDouble("skill") == 2719.0 && entity_a.getPersistentData().getDouble("cnt3") >= 20.0 && entity_a.getPersistentData().getDouble("cnt1") > 0.0) {
               if (entity_a.getPersistentData().getDouble("cnt2") >= 1.0) {
                  if (entity instanceof JudgemanEntity) {
                     PlayAnimationEntity2Procedure.execute(entity, "judgement");
                  }
               } else if (entity instanceof JudgemanEntity) {
                  PlayAnimationEntity2Procedure.execute(entity, "judgement_light");
               }
            }
         } else if (!entity.level().isClientSide()) {
            entity.discard();
         }

      }
   }
}
