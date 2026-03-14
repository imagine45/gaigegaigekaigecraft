package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOkkotsuProcedure {
   public CursedTechniqueOkkotsuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 503.0) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == 505.0) {
            TechniqueImitation1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 506.0) {
            SkillDhruv3Procedure.execute(world, entity);
         } else if (skill == 507.0) {
            ThinIceBreakerProcedure.execute(world, x, y, z, entity);
         } else if (skill == 510.0) {
            TechniqueRika1Procedure.execute(world, entity);
         } else if (skill == 515.0) {
            TechniquePureLoveProcedure.execute(world, entity);
         } else if (skill == 520.0) {
            AuthenticMutualLoveProcedure.execute(world, x, y, z, entity);
         } else {
            TechniqueRika2Procedure.execute(world, x, y, z, entity);
         }

      }
   }
}
