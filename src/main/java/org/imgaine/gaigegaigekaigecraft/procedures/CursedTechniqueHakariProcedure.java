package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueHakariProcedure {
   public CursedTechniqueHakariProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 2900.0);
         if (skill == 4.0) {
            SkillTakabaKickProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            SkillBallProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            SkillDoorsProcedure.execute(world, entity);
         } else if (skill == 7.0) {
            SkillConsecutiveEffectsProcedure.execute(entity);
         } else if (skill == 20.0) {
            IdleDeathGambleProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
