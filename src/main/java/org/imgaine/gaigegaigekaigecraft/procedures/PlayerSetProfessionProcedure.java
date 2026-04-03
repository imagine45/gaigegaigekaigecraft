package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModAttributes;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.player.Player;

public class PlayerSetProfessionProcedure {
   public PlayerSetProfessionProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double profession = 0.0;
         JujutsucraftModVariables.PlayerVariables pVars = null;
         if (entity instanceof Player) {
            pVars = (JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse((JujutsucraftModVariables.PlayerVariables) null);
         }

         profession = pVars.PlayerProfession;
         entity.getPersistentData().putBoolean("JujutsuSorcerer", false);
         entity.getPersistentData().putBoolean("CurseUser", false);
         entity.getPersistentData().putBoolean("CursedSpirit", false);
         if (profession == -2.0) {
            entity.getPersistentData().putBoolean("CursedSpirit", true);
            entity.getPersistentData().putBoolean("CurseUser", true);
         } else if (profession == -1.0) {
            entity.getPersistentData().putBoolean("CursedSpirit", true);
         } else if (profession == 1.0) {
            entity.getPersistentData().putBoolean("CurseUser", true);
         } else {
            entity.getPersistentData().putBoolean("JujutsuSorcerer", true);
         }

         if (profession == 0.0) {
            entity.getPersistentData().putBoolean("NonSorcerer", true);
         } else {
            entity.getPersistentData().putBoolean("NonSorcerer", false);
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _livingEntity10 = (LivingEntity)entity;
            if (_livingEntity10.getAttributes().hasAttribute((Attribute)JujutsucraftModAttributes.PROFESSION.get())) {
               _livingEntity10.getAttribute((Attribute)JujutsucraftModAttributes.PROFESSION.get()).setBaseValue(profession);
            }
         }

      }
   }
}
