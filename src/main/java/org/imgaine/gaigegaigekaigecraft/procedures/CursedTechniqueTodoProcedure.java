package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueTodoProcedure {
   public CursedTechniqueTodoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 2003.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 2004.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == 2005.0) {
            SkillBoogieWoogieProcedure.execute(world, x, y, z, entity);
            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (skill == 2006.0) {
            LariatProcedure.execute(world, x, y, z, entity);
         } else if (skill == 2007.0) {
            Attack4ConsecutiveAttacksProcedure.execute(world, entity);
         } else if (skill == 2015.0) {
            AttackTodoBlackFlashProcedure.execute(world, x, y, z, entity);
         } else if (skill == 2020.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Todo"), false);
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
