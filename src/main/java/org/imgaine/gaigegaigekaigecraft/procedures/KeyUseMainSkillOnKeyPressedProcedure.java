package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.LevelAccessor;

public class KeyUseMainSkillOnKeyPressedProcedure {
   public KeyUseMainSkillOnKeyPressedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double p_skill1 = 0.0;
         double old_select = 0.0;
         double select = 0.0;
         p_skill1 = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).SecondTechnique ? ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique2 : ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique;
         if (p_skill1 == -1.0) {
            int var10000;
            label173: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get())) {
                     var10000 = _livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.PHYSICAL_GIFTED_EFFECT.get()).m_19564_();
                     break label173;
                  }
               }

               var10000 = 0;
            }

            select = (double)(var10000 > 0 ? 7 : 1);
         }

         if (p_skill1 == 1.0) {
            select = 5.0;
         } else if (p_skill1 == 2.0) {
            select = 5.0;
         } else if (p_skill1 == 3.0) {
            select = 8.0;
         } else if (p_skill1 == 4.0) {
            select = 6.0;
         } else if (p_skill1 == 5.0) {
            select = 10.0;
         }

         if (p_skill1 == 6.0) {
            select = 4.0;
         } else if (p_skill1 == 7.0) {
            select = 5.0;
         } else if (p_skill1 == 8.0) {
            select = 7.0;
         } else if (p_skill1 == 9.0) {
            select = 10.0;
         } else if (p_skill1 == 10.0) {
            select = 6.0;
         }

         if (p_skill1 == 11.0) {
            select = 5.0;
         } else if (p_skill1 == 12.0) {
            select = 5.0;
         } else if (p_skill1 == 13.0) {
            select = 5.0;
         } else if (p_skill1 == 14.0) {
            select = 6.0;
         } else if (p_skill1 == 15.0) {
            select = 5.0;
         }

         if (p_skill1 == 16.0) {
            select = 5.0;
         } else if (p_skill1 == 17.0) {
            select = 15.0;
         } else if (p_skill1 == 18.0) {
            select = 10.0;
         } else if (p_skill1 == 19.0) {
            select = 5.0;
         } else if (p_skill1 == 20.0) {
            select = 5.0;
         }

         if (p_skill1 == 21.0) {
            select = 5.0;
         } else if (p_skill1 == 22.0) {
            select = 5.0;
         } else if (p_skill1 == 23.0) {
            select = 6.0;
         } else if (p_skill1 == 24.0) {
            select = 5.0;
         } else if (p_skill1 == 25.0) {
            select = 5.0;
         }

         if (p_skill1 == 26.0) {
            select = 11.0;
         } else if (p_skill1 == 27.0) {
            select = 20.0;
         } else if (p_skill1 == 28.0) {
            select = 15.0;
         } else if (p_skill1 == 29.0) {
            select = 6.0;
         } else if (p_skill1 == 30.0) {
            select = 5.0;
         }

         if (p_skill1 == 31.0) {
            select = 5.0;
         } else if (p_skill1 == 32.0) {
            select = 5.0;
         } else if (p_skill1 == 33.0) {
            select = 20.0;
         } else if (p_skill1 == 34.0) {
            select = 6.0;
         } else if (p_skill1 == 35.0) {
            select = 5.0;
         }

         if (p_skill1 == 36.0) {
            select = 5.0;
         } else if (p_skill1 == 37.0) {
            select = 10.0;
         } else if (p_skill1 == 38.0) {
            select = 10.0;
         } else if (p_skill1 == 39.0) {
            select = 8.0;
         } else if (p_skill1 == 40.0) {
            select = 5.0;
         }

         if (p_skill1 == 41.0) {
            select = 10.0;
         } else if (p_skill1 == 42.0) {
            select = 0.0;
         } else if (p_skill1 == 43.0) {
            select = 5.0;
         } else if (p_skill1 == 44.0) {
            select = 0.0;
         } else if (p_skill1 == 45.0) {
            select = 0.0;
         }

         boolean _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.use_mainSkill = _setval;
            capability.syncPlayerVariables(entity);
         });
         old_select = ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerSelectCurseTechnique = select;
            capability.syncPlayerVariables(entity);
         });
         _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechnique == select) {
            KeyStartTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

         _setval = false;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.use_mainSkill = _setval;
            capability.syncPlayerVariables(entity);
         });
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.PlayerSelectCurseTechnique = old_select;
            capability.syncPlayerVariables(entity);
         });
         _setval = true;
         entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
            capability.noChangeTechnique = _setval;
            capability.syncPlayerVariables(entity);
         });
         KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
      }
   }
}
