package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class PhysicalGiftedProcedure {
   public PhysicalGiftedProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill") + 100.0;
         if (skill == 0.0) {
            AttackWeakProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1.0) {
            AttackStrongProcedure.execute(world, x, y, z, entity);
         } else if (skill == 2.0) {
            AttackContinueProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == 7.0) {
            AttackTackleProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Physical gifted"), false);
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
