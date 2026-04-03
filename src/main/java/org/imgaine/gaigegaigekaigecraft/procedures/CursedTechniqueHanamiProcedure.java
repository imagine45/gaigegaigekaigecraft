package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueHanamiProcedure {
   public CursedTechniqueHanamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 1405.0) {
            HanamiSpearProcedure.execute(world, entity);
         } else if (skill == 1406.0) {
            WoodenBallProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1410.0) {
            HanamiSpear3Procedure.execute(world, entity);
         } else if (skill == 1415.0) {
            HanamiFlowerOfferingProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1420.0) {
            CeremonialSeaOfLightProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Hanami"), false);
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
