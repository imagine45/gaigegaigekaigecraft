package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

public class CursedTechniqueEffectStartedappliedProcedure {
   public CursedTechniqueEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         if (entity instanceof Mob) {
            Mob _entity = (Mob)entity;
            _entity.getNavigation().stop();
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.REVERSE_CURSED_TECHNIQUE.get());
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.FALLING_BLOSSOM_EMOTION.get());
         }

         entity.getPersistentData().putDouble("used_technique_cost", ((JujutsucraftModVariables.PlayerVariables)entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).orElse(new JujutsucraftModVariables.PlayerVariables())).PlayerSelectCurseTechniqueCost);
      }
   }
}
