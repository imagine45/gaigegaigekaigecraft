package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueCrystalProcedure {
   public CursedTechniqueCrystalProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 4700.0);
         if (skill == 4.0) {
            AttackOverheadProcedure.execute(world, x, y, z, entity);
         } else if (skill == 5.0) {
            CrystalRollProcedure.execute(world, x, y, z, entity);
         } else if (skill == 6.0) {
            Crystal1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 7.0) {
            Crystal2Procedure.execute(world, x, y, z, entity);
         } else if (skill == 8.0) {
            if (entity.getPersistentData().getDouble("cnt10") == 0.0) {
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("cnt10", 1.0);
                  entity.getPersistentData().putDouble("x_pos", entity.getX());
                  entity.getPersistentData().putDouble("y_pos", entity.getY());
                  entity.getPersistentData().putDouble("z_pos", entity.getZ());
                  entity.getPersistentData().putDouble("skill", 4708.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt10") != 0.0) {
               Crystal3Procedure.execute(world, entity);
            }
         } else if (skill == 9.0) {
            if (entity.getPersistentData().getDouble("cnt10") == 0.0) {
               AttackOverheadProcedure.execute(world, x, y, z, entity);
               if (entity.getPersistentData().getDouble("skill") == 0.0) {
                  entity.getPersistentData().putDouble("cnt1", 1.0);
                  entity.getPersistentData().putDouble("cnt2", 0.0);
                  entity.getPersistentData().putDouble("cnt10", 1.0);
                  entity.getPersistentData().putDouble("skill", 4709.0);
               }
            }

            if (entity.getPersistentData().getDouble("cnt10") != 0.0) {
               CrystalExplosionProcedure.execute(world, entity);
            }
         } else if (skill == 10.0) {
            CrystalBreathProcedure.execute(world, x, y, z, entity);
         } else if (skill == 15.0) {
            CrystalSelfExplosionProcedure.execute(world, entity);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Ranta Crystal"), false);
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
