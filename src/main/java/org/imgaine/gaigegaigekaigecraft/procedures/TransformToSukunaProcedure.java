package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import org.imgaine.gaigegaigekaigecraft.network.JujutsucraftModVariables;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;

public class TransformToSukunaProcedure {
   public TransformToSukunaProcedure() {
   }

   public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
      if (entity != null) {
         String STR1 = "";
         double level = 0.0;
         double x_pos = 0.0;
         double power = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         entity.getPersistentData().putDouble("cnt1", entity.getPersistentData().getDouble("cnt1") + 1.0);
         LivingEntity var10000;
         if (entity instanceof Mob) {
            Mob _mobEnt = (Mob)entity;
            var10000 = _mobEnt.getTarget();
         } else {
            var10000 = null;
         }

         if (var10000 instanceof LivingEntity) {
            if (entity instanceof Mob) {
               Mob _mobEnt = (Mob)entity;
               var10000 = _mobEnt.getTarget();
            } else {
               var10000 = null;
            }

            if (((Entity)var10000).isAlive()) {
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  if (!_entity.level().isClientSide()) {
                     _entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 20, false, false));
                  }
               }

               entity.getPersistentData().putBoolean("PRESS_Z", true);
            }
         }

         if (entity.getPersistentData().getBoolean("PRESS_Z")) {
            power = (double)Math.round((20.0 - entity.getPersistentData().getDouble("cnt1")) * 0.25);
            STR1 = Component.translatable("jujutsu.message.long_press").getString();

            for(int index0 = 0; index0 < (int)power; ++index0) {
               STR1 = "■" + STR1 + "■";
            }

            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(STR1), true);
               }
            }

            if (entity.getPersistentData().getDouble("cnt1") >= 20.0) {
               if (entity instanceof Player) {
                  Player _player = (Player)entity;
                  if (!_player.level().isClientSide()) {
                     _player.displayClientMessage(Component.literal(""), true);
                  }
               }

               level = GetSukunaLevelProcedure.execute(entity);
               if (level > 0.0) {
                  level = Math.min(Math.max(level, 1.0), 20.0) - 1.0;
                  if (entity instanceof LivingEntity) {
                     LivingEntity _entity = (LivingEntity)entity;
                     if (!_entity.level().isClientSide()) {
                        _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.SUKUNA_EFFECT.get(), 6000, (int)Math.round(level), false, false));
                     }
                  }
               }

               KeyResetTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               boolean _setval = true;
               entity.getCapability(JujutsucraftModVariables.PLAYER_VARIABLES_CAPABILITY, (Direction)null).ifPresent((capability) -> {
                  capability.noChangeTechnique = _setval;
                  capability.syncPlayerVariables(entity);
               });
               KeyChangeTechniqueOnKeyPressedProcedure.execute(world, x, y, z, entity);
               entity.getPersistentData().putDouble("skill", 0.0);
               if (entity instanceof LivingEntity) {
                  LivingEntity _entity = (LivingEntity)entity;
                  _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.DEEP_CONCENTRATION.get());
               }
            }
         } else {
            if (entity instanceof Player) {
               Player _player = (Player)entity;
               if (!_player.level().isClientSide()) {
                  _player.displayClientMessage(Component.literal(""), true);
               }
            }

            entity.getPersistentData().putDouble("skill", 0.0);
         }

      }
   }
}
