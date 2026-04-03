package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueKaoriProcedure {
   public CursedTechniqueKaoriProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 4100.0);
         if (skill == 5.0) {
            SkillAntiGravityProcedure.execute(world, entity);
         } else if (skill == 10.0) {
            SkillAntiGravityReversedProcedure.execute(world, entity);
         } else if (skill == 20.0) {
            entity.getPersistentData().putDouble("skill", 1820.0);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Kaori Itadori"), false);
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
