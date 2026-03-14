package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueKashimoProcedure {
   public CursedTechniqueKashimoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 705.0) {
            LightningStrikeProcedure.execute(world, x, y, z, entity);
         } else if (skill == 710.0) {
            TurnUpTheVolumeProcedure.execute(world, x, y, z, entity);
         } else if (skill == 715.0) {
            TechniqueMythicalBeastAmberProcedure.execute(world, x, y, z, entity);
         } else if (skill == 716.0) {
            TechniqueAhProcedure.execute(world, x, y, z, entity);
         } else if (skill == 717.0) {
            TechniqueEnergyWave1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 719.0) {
            SkillKashimoKickProcedure.execute(world, x, y, z, entity);
         } else if (skill == 720.0) {
            KashimoDomainProcedure.execute(world, x, y, z, entity);
         } else if (skill == 730.0) {
            OtakeThunderProcedure.execute(world, entity);
         } else if (skill == 731.0) {
            OtakeFlameProcedure.execute(world, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Kashimo"), false);
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
