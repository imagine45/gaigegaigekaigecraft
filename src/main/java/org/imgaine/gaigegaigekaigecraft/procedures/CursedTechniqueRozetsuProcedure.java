package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueRozetsuProcedure {
   public CursedTechniqueRozetsuProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 4300.0);
         if (skill == 3.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            SkillRozetsuShikigami1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            SkillRozetsuShikigami2Procedure.execute(world, x, y, z, entity);
         } else if (skill == 7.0) {
            SkillRozetsuShikigami3Procedure.execute(world, x, y, z, entity);
         } else if (skill == 20.0) {
            RozetsuDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (skill == 30.0) {
            TechniqueHanakoHandProcedure.execute(world, entity);
         } else if (skill == 31.0) {
            TechniqueHanakoHand2Procedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Rozetsu"), false);
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
