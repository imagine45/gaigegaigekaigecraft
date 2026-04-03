package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueCombatProcedure {
   public CursedTechniqueCombatProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 4200.0);
         if (skill == 3.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == 4.0) {
            AttackTackleProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            AttackSpeedProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Combat"), false);
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
