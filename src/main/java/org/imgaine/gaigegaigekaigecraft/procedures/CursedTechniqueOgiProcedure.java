package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOgiProcedure {
   public CursedTechniqueOgiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 2600.0);
         if (skill == 5.0) {
            TechniqueBlazingCourageProcedure.execute(world, x, y, z, entity);
         } else if (skill == 11.0) {
            TechniqueOgi1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 12.0) {
            TechniqueOgi2Procedure.execute(world, x, y, z, entity);
         } else if (skill == 13.0) {
            TechniqueOgi3Procedure.execute(world, x, y, z, entity);
         } else if (skill == 14.0) {
            TechniqueOgi4Procedure.execute(world, x, y, z, entity);
         } else if (skill == 15.0) {
            TechniqueOgi5Procedure.execute(world, x, y, z, entity);
         } else if (skill == 19.0) {
            TechniqueOgi9Procedure.execute(world, x, y, z, entity);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
