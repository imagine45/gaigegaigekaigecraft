package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueMahoragaProcedure {
   public CursedTechniqueMahoragaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 1605.0) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1606.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1607.0) {
            TechniqueExplodeProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1608.0) {
            StoneThrowingProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1615.0) {
            AttackOverheadSuperProcedure.execute(world, entity);
         } else if (skill == 1619.0) {
            MahoragaCutTheWorldProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1620.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Mahoraga"), false);
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
