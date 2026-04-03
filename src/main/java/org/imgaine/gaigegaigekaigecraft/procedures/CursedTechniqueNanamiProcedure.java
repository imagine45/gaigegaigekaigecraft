package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueNanamiProcedure {
   public CursedTechniqueNanamiProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 1305.0) {
            WeaponNanamiRightClickedInAirProcedure.execute(world, entity);
            entity.getPersistentData().putDouble("skill", 0.0);
         } else if (skill == 1306.0) {
            AttackJumpProcedure.execute(world, x, y, z, entity);
         } else if (skill == 1307.0) {
            Attack4ConsecutiveAttacksProcedure.execute(world, entity);
         } else if (skill == 1310.0) {
            GaragaraProcedure.execute(world, entity);
         } else if (skill == 1320.0) {
            NanamiDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Nanami"), false);
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
