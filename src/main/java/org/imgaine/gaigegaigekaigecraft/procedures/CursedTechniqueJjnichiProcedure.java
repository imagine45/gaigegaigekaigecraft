package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueJjnichiProcedure {
   public CursedTechniqueJjnichiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double level = 0.0;
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().m_128459_("skill") - 2200.0);
         if (skill == 4.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            TechniqueFistSingleProcedure.execute(world, entity);
         } else if (skill == 6.0) {
            FistGunProcedure.execute(world, entity);
         } else if (skill == 7.0) {
            TechniqueFistProcedure.execute(world, entity);
         } else if (skill == 8.0) {
            TechniqueFootProcedure.execute(world, entity);
         } else if (skill == 10.0) {
            TechniqueFistMeteorProcedure.execute(world, entity);
         } else if (skill == 20.0) {
            JinichiDomainProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Jinichi"), false);
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
