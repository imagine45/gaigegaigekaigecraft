package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class CursedTechniqueReggieStarProcedure {
   public CursedTechniqueReggieStarProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         double skill = 0.0;
         skill = (double)Math.round(entity.getPersistentData().getDouble("skill") - 4400.0);
         if (skill == 5.0) {
            ReceiptKitchenKnifeProcedure.execute(world, entity);
         } else if (skill == 10.0) {
            ReceiptCarProcedure.execute(world, entity);
         } else if (skill == 11.0) {
            ReceiptTruckProcedure.execute(world, entity);
         } else if (skill == 15.0) {
            ReceiptHouseProcedure.execute(world, entity);
         } else if (skill == 20.0) {
            OtherDomainExpansionProcedure.execute(world, x, y, z, entity);
         } else if (skill == 30.0) {
            BayerKnifeProcedure.execute(world, x, y, z, entity);
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal("WIP Reggie Star"), false);
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
