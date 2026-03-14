package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueSmallpoxDeityProcedure {
   public CursedTechniqueSmallpoxDeityProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 2500.0);
         if (skill == 5.0) {
            SkillStoneProcedure.execute(world, entity);
         } else if (skill == 6.0) {
            TechniqueSmallpoxDeityBreathProcedure.execute(world, x, y, z, entity);
         } else if (skill == 20.0) {
            GraveyardDomainProcedure.execute(world, x, y, z, entity);
         } else if (skill == 30.0) {
            SkillSoulExplosionProcedure.execute(world, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
