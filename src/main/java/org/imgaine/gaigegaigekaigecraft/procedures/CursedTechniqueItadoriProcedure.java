package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueItadoriProcedure {
   public CursedTechniqueItadoriProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double level = 0.0;
         double x_pos = 0.0;
         double power = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 2100.0);
         if (skill == 5.0) {
            DivergentFistProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            Attack4ConsecutiveAttacksProcedure.execute(world, entity);
         } else if (skill == 8.0) {
            CleaveProcedure.execute(world, entity);
         } else if (skill == 13.0) {
            PiercingBloodProcedure.execute(world, x, y, z, entity);
         } else if (skill == 14.0) {
            SuperNovaItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill == 18.0) {
            DeepConcentrationItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill == 19.0) {
            TransformToSukunaProcedure.execute(world, x, y, z, entity);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
