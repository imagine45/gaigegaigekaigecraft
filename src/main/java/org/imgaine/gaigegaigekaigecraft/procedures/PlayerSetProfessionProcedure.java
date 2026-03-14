package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;

public class PlayerSetProfessionProcedure {
   public PlayerSetProfessionProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         entity.getPersistentData().m_128379_("JujutsuSorcerer", false);
         entity.getPersistentData().m_128379_("CurseUser", false);
         entity.getPersistentData().m_128379_("CursedSpirit", false);
         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == -2.0) {
            entity.getPersistentData().m_128379_("CursedSpirit", true);
            entity.getPersistentData().m_128379_("CurseUser", true);
         } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == -1.0) {
            entity.getPersistentData().m_128379_("CursedSpirit", true);
         } else if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerProfession == 1.0) {
            entity.getPersistentData().m_128379_("CurseUser", true);
         } else {
            entity.getPersistentData().m_128379_("JujutsuSorcerer", true);
         }

         if (((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique == 0.0) {
            entity.getPersistentData().m_128379_("NonSorcerer", true);
         } else {
            entity.getPersistentData().m_128379_("NonSorcerer", false);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity10 = (LivingEntity)entity;
            if (_livingEntity10.m_21204_().m_22171_((Attribute)JujutsucraftModAttributes.PROFESSION.get())) {
               _livingEntity10.getAttribute_((Attribute)JujutsucraftModAttributes.PROFESSION.get()).m_22100_(((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerCurseTechnique);
            }
         }

      }
   }
}
