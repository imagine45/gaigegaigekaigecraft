package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueYorozuProcedure {
   public CursedTechniqueYorozuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 3900.0);
         if (skill == 5.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == 7.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == 8.0) {
            TechniqueLiquidArrowProcedure.execute(world, entity);
         } else if (skill == 9.0) {
            TechniqueNeedleProcedure.execute(world, entity);
         } else if (skill == 12.0) {
            TechniqueLiquidMetalProcedure.execute(world, entity);
         } else if (skill == 14.0) {
            TechniqueInsectArmorProcedure.execute(world, x, y, z, entity);
         } else if (skill == 15.0) {
            TechniqueTrueSphereProcedure.execute(world, entity);
         } else if (skill == 20.0) {
            ThreefoldAfflictionProcedure.execute(world, x, y, z, entity);
         } else if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         if (entity.getPersistentData().m_128459_("skill") == 0.0 && entity instanceof Player) {
            boolean _setval = true;
            entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
               capability.noChangeTechnique = _setval;
               capability.syncPlayerVariables(entity);
            });
            KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
         }

      }
   }
}
