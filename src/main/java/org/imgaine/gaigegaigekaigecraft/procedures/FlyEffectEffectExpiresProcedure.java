package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.InlineMethodHandler;
import org.imgaine.gaigegaigekaigecraft.Gaigegaigekaigecraft;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.LevelAccessor;

public class FlyEffectEffectExpiresProcedure {
   public FlyEffectEffectExpiresProcedure() {
   }

   public static void execute(LevelAccessor world, Entity entity) {
      if (entity != null) {
         if (entity instanceof Player) {
            Gaigegaigekaigecraft.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _livEnt1) {
                  if (_livEnt1.hasEffect((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                     return;
                  }
               }

               if (entity instanceof Player _plr) {
                  if (_plr.getAbilities().instabuild) {
                     return;
                  }
               }

               if (!InlineMethodHandler.checkGamemodeSpectator(entity)) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getAbilities().mayfly = false;
                     _player.onUpdateAbilities();
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.getAbilities().flying = false;
                     _player.onUpdateAbilities();
                  }
               }

            });
         }

      }
   }
}
