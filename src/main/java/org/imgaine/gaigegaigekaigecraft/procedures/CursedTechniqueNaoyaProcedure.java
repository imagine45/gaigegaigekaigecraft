package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueNaoyaProcedure {
   public CursedTechniqueNaoyaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 1905.0) {
            SkillProjectionSorceryProcedure.execute(world, entity);
         } else if (skill == 1907.0) {
            SpeedIsPowerProcedure.execute(world, entity);
         } else if (skill == 1910.0) {
            SkillExplodeAirProcedure.execute(world, entity);
         } else if (skill == 1915.0) {
            AttackProjectionSorceryProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1916.0) {
            AttackTackleFlyingProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1920.0) {
            TimeCellMoonPalaceProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Naoya"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.m_21195_((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

      }
   }
}
