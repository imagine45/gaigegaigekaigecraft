package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueGojoProcedure {
   public CursedTechniqueGojoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().m_128459_("skill");
         if (skill == 205.0) {
            InfinityProcedure.execute(world, x, y, z, entity);
         } else if (skill == 206.0) {
            TechniqueBlueProcedure.execute(world, x, y, z, entity);
         } else if (skill == 207.0) {
            TechniqueRedProcedure.execute(world, x, y, z, entity);
         } else if (skill == 208.0) {
            TechniqueBluePunchProcedure.execute(world, entity);
         } else if (skill == 215.0) {
            HollowPurpleProcedure.execute(world, x, y, z, entity);
         } else if (skill == 220.0) {
            UnlimitedVoidProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.m_9236_().m_5776_()) {
                  _player.m_5661_(Component.m_237113_("WIP Limitless"), false);
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
