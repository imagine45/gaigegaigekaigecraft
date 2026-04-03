package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueOnPotionActiveTick3Procedure {
   public CursedTechniqueOnPotionActiveTick3Procedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 2000.0);
         if (skill >= 2500.0) {
            if (skill >= 2900.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill >= 2800.0) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
               }
            } else if (skill >= 2700.0) {
               CursedTechniqueCrystalProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 2600.0) {
               CursedTechniqueRantaZeninProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 2500.0) {
               CursedTechniqueHazenokiProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 2000.0) {
            if (skill >= 2400.0) {
               CursedTechniqueReggieStarProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 2300.0) {
               CursedTechniqueRozetsuProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 2200.0) {
               CursedTechniqueCombatProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 2100.0) {
               CursedTechniqueKaoriProcedure.execute(world, entity);
            } else if (skill >= 2000.0) {
               CursedTechniqueInoProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 1500.0) {
            if (skill >= 1900.0) {
               CursedTechniqueYorozuProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1800.0) {
               CursedTechniqueTakakoUroProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1700.0) {
               CursedTechniqueDhruvProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1600.0) {
               CursedTechniqueNishimiyaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1500.0) {
               CursedTechniqueJunpeProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 1000.0) {
            if (skill >= 1400.0) {
               CursedTechniqueKugisakiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1300.0) {
               CursedTechniqueYagaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1200.0) {
               CursedTechniqueChojuroProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1100.0) {
               CursedTechniqueKusakabeProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 1000.0) {
               CursedTechniqueMiguelProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 500.0) {
            if (skill >= 900.0) {
               CursedTechniqueHakariProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 800.0) {
               CursedTechniqueAngelProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 700.0) {
               CursedTechniqueHigurumaProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 600.0) {
               CursedTechniqueOgiProcedure.execute(world, x, y, z, entity);
            } else if (skill >= 500.0) {
               CursedTechniqueSmallpoxDeityProcedure.execute(world, x, y, z, entity);
            } else if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         } else if (skill >= 400.0) {
            CursedTechniqueUraumeProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 300.0) {
            CursedTechniqueKurourushiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 200.0) {
            CursedTechniqueJjnichiProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 100.0) {
            CursedTechniqueItadoriProcedure.execute(world, x, y, z, entity);
         } else if (skill >= 0.0) {
            CursedTechniqueTodoProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

      }
   }
}
