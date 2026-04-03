package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueChosoProcedure {
   public CursedTechniqueChosoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 1005.0) {
            TechniqueSlicingExorcismProcedure.execute(world, entity);
         } else if (skill == 1006.0) {
            TechniqueConvergenceProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1007.0) {
            PiercingBloodProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1008.0) {
            SupernovaProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1009.0) {
            TechniqueFlowingRedScaleProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1016.0) {
            DagonWaterSkillProcedure.execute(world, entity);
         } else if (skill == 1018.0) {
            TechniqueWingKingProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1019.0) {
            KechizuPoizonProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1020.0) {
            ChosoDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Choso"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
