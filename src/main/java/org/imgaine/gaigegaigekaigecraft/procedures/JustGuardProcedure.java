package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class JustGuardProcedure {
   public JustGuardProcedure() {
   }

   public static void execute(Entity guard_entity) {
      if (guard_entity != null) {
         if (!guard_entity.m_9236_().m_5776_() && guard_entity.m_20194_() != null) {
            guard_entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, guard_entity.m_20182_(), guard_entity.m_20155_(), guard_entity.m_9236_() instanceof ServerLevel ? (ServerLevel)guard_entity.m_9236_() : null, 4, guard_entity.m_7755_().getString(), guard_entity.m_5446_(), guard_entity.m_9236_().m_7654_(), guard_entity), "playsound jujutsucraft:guard_just master @s");
         }

         if (guard_entity instanceof Player) {
            Player _player = (Player)guard_entity;
            if (!_player.m_9236_().m_5776_()) {
               _player.m_5661_(Component.m_237113_("§6§l" + Component.m_237115_("jujutsu.message.guard").getString()), true);
            }
         }

         if (guard_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)guard_entity;
            if (!_entity.m_9236_().m_5776_()) {
               _entity.m_7292_(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, true, true));
            }
         }

      }
   }
}
