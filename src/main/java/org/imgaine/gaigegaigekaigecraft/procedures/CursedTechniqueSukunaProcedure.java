package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueSukunaProcedure {
   public CursedTechniqueSukunaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill <= 120.0) {
            if (skill == 105.0) {
               DismantleProcedure.execute(world, x, y, z, entity);
            } else if (skill == 106.0) {
               CleaveProcedure.execute(world, entity);
            } else if (skill == 107.0) {
               OpenProcedure.execute(world, entity);
            } else if (skill == 111.0) {
               SkillSukunaCombo1Procedure.execute(world, x, y, z, entity);
            } else if (skill == 112.0) {
               SkillSukunaCombo2Procedure.execute(world, x, y, z, entity);
            } else if (skill == 113.0) {
               SkillSukunaCombo3Procedure.execute(world, x, y, z, entity);
            } else if (skill == 120.0) {
               MalevolentShrineProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 150.0 && skill < 200.0) {
            if (skill < 160.0) {
               if (skill == 150.0) {
                  ZonbaProcedure.execute(world, x, y, z, entity);
               } else if (skill == 151.0) {
                  TechniqueSkeleton1Procedure.execute(world, x, y, z, entity);
               } else if (skill == 152.0) {
                  TechniqueSkullProcedure.execute(world, x, y, z, entity);
               } else if (skill == 153.0) {
                  TechniqueScissorsProcedure.execute(world, entity);
               } else if (skill == 154.0) {
                  SkillEnergyWave2Procedure.execute(world, x, y, z, entity);
               } else if (skill == 155.0) {
                  TechniqueTamamonoMae1Procedure.execute(world, x, y, z, entity);
               } else if (skill == 156.0) {
                  TechniqueTamamonomae2Procedure.execute(world, x, y, z, entity);
               } else if (skill == 157.0) {
                  TechniqueFoxFireProcedure.execute(world, x, y, z, entity);
               } else if (skill == 158.0) {
                  AttackPiecingOxProcedure.execute(world, x, y, z, entity);
               } else if (skill == 159.0) {
                  TechniqueMucusProcedure.execute(world, x, y, z, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill < 170.0) {
               if (skill == 160.0) {
                  SkillGaneshaProcedure.execute(world, entity);
               } else if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
