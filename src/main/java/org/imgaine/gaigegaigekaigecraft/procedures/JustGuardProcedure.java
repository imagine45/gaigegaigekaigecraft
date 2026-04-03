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
         if (!guard_entity.level().isClientSide() && guard_entity.getServer() != null) {
            guard_entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, guard_entity.position(), guard_entity.getRotationVector(), guard_entity.level() instanceof ServerLevel ? (ServerLevel)guard_entity.level() : null, 4, guard_entity.getName().getString(), guard_entity.getDisplayName(), guard_entity.level().getServer(), guard_entity), "playsound gaigegaigekaigecraft:guard_just master @s");
         }

         if (guard_entity instanceof Player) {
            Player _player = (Player)guard_entity;
            if (!_player.level().isClientSide()) {
               _player.displayClientMessage(Component.literal("§6§l" + Component.translatable("jujutsu.message.guard").getString()), true);
            }
         }

         if (guard_entity instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)guard_entity;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.GUARD.get(), 15, 1, true, true));
            }
         }

      }
   }
}
