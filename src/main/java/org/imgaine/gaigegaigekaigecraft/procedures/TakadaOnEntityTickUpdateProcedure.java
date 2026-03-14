package org.imgaine.gaigegaigekaigecraft.procedures;

import java.util.UUID;
import java.util.function.BiFunction;
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
            entity_a = (new BiFunction<LevelAccessor, String, Entity>() {
               public Entity apply(LevelAccessor levelAccessor, String uuid) {
                  if (levelAccessor instanceof ServerLevel serverLevel) {
                     try {
                        return serverLevel.m_8791_(UUID.fromString(uuid));
                     } catch (Exception var5) {
                     }
                  }

                  return null;
               }
            }).apply(world, entity.getPersistentData().m_128461_("OWNER_UUID"));
            if (entity_a instanceof LivingEntity) {
               LivingEntity _livEnt2 = (LivingEntity)entity_a;
               if (_livEnt2.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  if (entity instanceof JudgemanEntity && entity_a.getPersistentData().m_128459_("skill") == 2719.0 && entity_a.getPersistentData().m_128459_("cnt3") >= 20.0 && entity_a.getPersistentData().m_128459_("cnt1") > 0.0) {
                     if (entity instanceof JudgemanEntity) {
                        ((JudgemanEntity)entity).setAnimation("empty");
                     }

                     if (entity instanceof JudgemanEntity) {
                        ((JudgemanEntity)entity).setAnimation("judgement");
                     }

                     num1 = 0.0;
                     x_pos = entity.m_20185_();
                     y_pos = entity.m_20186_();
                     z_pos = entity.m_20189_();
                     if (world instanceof ServerLevel) {
                        ServerLevel _level = (ServerLevel)world;
                        _level.m_8767_(ParticleTypes.f_123765_, x_pos, y_pos, z_pos, 15, 2.0, 0.5, 2.0, 0.5);
                        return;
                     }
                  }

                  return;
               }
            }

            if (entity instanceof TakadaEntity) {
               if (world instanceof ServerLevel) {
                  ServerLevel _level = (ServerLevel)world;
                  _level.m_8767_(ParticleTypes.f_123810_, x, y + (double)entity.m_20206_() * 0.5, z, 40, 0.2, 0.5, 0.2, 0.0);
               }
            } else if (entity instanceof JudgemanEntity && world instanceof ServerLevel) {
               ServerLevel _level = (ServerLevel)world;
               _level.m_8767_(ParticleTypes.f_123765_, x, y + (double)entity.m_20206_() * 0.5, z, 40, 0.2, 0.5, 0.2, 0.0);
            }

            if (!entity.m_9236_().m_5776_()) {
               entity.m_146870_();
            }
         } else if (!entity.m_9236_().m_5776_()) {
            entity.m_146870_();
         }

      }
   }
}
