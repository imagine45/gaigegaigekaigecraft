package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOnPotionActivetick2Procedure {
   public CursedTechniqueOnPotionActivetick2Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 1000.0);
         if (skill >= 500.0) {
            if (skill >= 1000.0) {
               CursedTechniqueOnPotionActiveTick3Procedure.execute(world, x, y, z, entity);
            } else if (skill >= 900.0) {
               CursedTechniqueNaoyaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 800.0) {
               CursedTechniqueGetoProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 700.0) {
               CursedTechniqueTakabaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 600.0) {
               CursedTechniqueMahoragaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 500.0) {
               CursedTechniqueMahitoProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 400.0) {
            CursedTechniqueHanamiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 300.0) {
            CursedTechniqueNanamiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 200.0) {
            CursedTechniqueIshigoriProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 100.0) {
            CursedTehcniqueMeiMeiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 0.0) {
            CursedTechniqueChosoProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
