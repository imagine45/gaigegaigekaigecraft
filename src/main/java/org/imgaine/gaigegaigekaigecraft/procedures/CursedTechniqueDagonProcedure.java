package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueDagonProcedure {
   public CursedTechniqueDagonProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 805.0) {
            DagonWaterSkillProcedure.execute(world, entity);
         } else if (skill == 806.0) {
            DagonFish1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 807.0) {
            DagonFish2Procedure.execute(world, entity);
         } else if (skill == 809.0) {
            DeathSwarmProcedure.execute(world, entity);
         } else if (skill == 810.0) {
            SummonBathynomusProcedure.execute(world, entity);
         } else if (skill == 820.0) {
            HorizonOfTheCaptivatingSkandhaProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Dagon"), false);
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
