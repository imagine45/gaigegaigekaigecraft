package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.JujutsucraftMod;
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
            JujutsucraftMod.queueServerWork(1, () -> {
               if (entity instanceof LivingEntity _livEnt1) {
                  if (_livEnt1.m_21023_((MobEffect)JujutsucraftModMobEffects.FLY_EFFECT.get())) {
                     return;
                  }
               }

               if (entity instanceof Player _plr) {
                  if (_plr.m_150110_().f_35937_) {
                     return;
                  }
               }

               if (!((<undefinedtype>)(new Object() {
                  public boolean checkGamemode(Entity _ent) {
                     if (_ent instanceof ServerPlayer _serverPlayer) {
                        return _serverPlayer.f_8941_.m_9290_() == GameType.SPECTATOR;
                     } else if (_ent.m_9236_().m_5776_() && _ent instanceof Player _player) {
                        return Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()) != null && Minecraft.m_91087_().m_91403_().m_104949_(_player.m_36316_().getId()).m_105325_() == GameType.SPECTATOR;
                     } else {
                        return false;
                     }
                  }
               })).checkGamemode(entity)) {
                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150110_().f_35936_ = false;
                     _player.m_6885_();
                  }

                  if (entity instanceof Player) {
                     Player _player = (Player)entity;
                     _player.m_150110_().f_35935_ = false;
                     _player.m_6885_();
                  }
               }

            });
         }

      }
   }
}
