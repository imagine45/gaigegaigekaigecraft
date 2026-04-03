package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueJogoProcedure {
   public CursedTechniqueJogoProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = entity.getPersistentData().getDouble("skill");
         if (skill == 405.0) {
            JogoFlame1Procedure.execute(world, x, y, z, entity);
         } else if (skill == 406.0) {
            JogoFlame2Procedure.execute(world, entity);
         } else if (skill == 407.0) {
            TechniqueEmberInsectsProcedure.execute(world, x, y, z, entity);
         } else if (skill == 408.0) {
            JogoFlame3Procedure.execute(world, entity);
         } else if (skill == 409.0) {
            JogoFlame4Procedure.execute(world, entity);
         } else if (skill == 410.0) {
            ChojuroStoneHandProcedure.execute(world, entity);
         } else if (skill == 415.0) {
            MaximumMeteorProcedure.execute(world, entity);
         } else if (skill == 420.0) {
            CoffinOfTheIronMountainProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Jogo"), false);
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _entity = (LivingEntity)entity;
               _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
            }
         }

         if (entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 60, 1));
            }
         }

      }
   }
}
