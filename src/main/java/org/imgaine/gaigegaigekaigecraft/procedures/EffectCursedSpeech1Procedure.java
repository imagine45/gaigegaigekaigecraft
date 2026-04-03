package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

public class EffectCursedSpeech1Procedure {
   public EffectCursedSpeech1Procedure() {
   }

   public static void execute(Entity entity, Entity entityiterator) {
      if (entity != null && entityiterator != null) {
         String message = "";
         double x_pos = 0.0;
         double y_pos = 0.0;
         double z_pos = 0.0;
         double effect = 0.0;
         x_pos = entityiterator.getX();
         y_pos = entityiterator.getY() + (double)entityiterator.getBbHeight() * 0.5;
         z_pos = entityiterator.getZ();
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            _entity.removeEffect((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get());
         }

         entity.getPersistentData().putBoolean("attack", false);
         entityiterator.getPersistentData().putDouble("Damage", 0.0);
         entityiterator.getPersistentData().putDouble("skill", -1000.0);
         if (entityiterator instanceof LivingEntity) {
            LivingEntity _entity = (LivingEntity)entityiterator;
            if (!_entity.level().isClientSide()) {
               _entity.addEffect(new MobEffectInstance((MobEffect)JujutsucraftModMobEffects.CURSED_TECHNIQUE.get(), 20, 0, false, false));
            }
         }

         entityiterator.getPersistentData().putDouble("skill", -1000.0);
         if (!entityiterator.level().isClientSide() && entityiterator.getServer() != null) {
            entityiterator.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entityiterator.position(), entityiterator.getRotationVector(), entityiterator.level() instanceof ServerLevel ? (ServerLevel)entityiterator.level() : null, 4, entityiterator.getName().getString(), entityiterator.getDisplayName(), entityiterator.level().getServer(), entityiterator), "playsound gaigegaigekaigecraft:tinnitus master @s");
         }

         if (entityiterator instanceof Player) {
            message = "NULL";
            effect = entity.getPersistentData().getDouble("effect");
            if (effect == 305.0) {
               message = Component.translatable("jujutsu.technique.explode").getString();
            } else if (effect == 306.0) {
               message = Component.translatable("jujutsu.technique.get_crushed").getString();
            } else if (effect == 307.0) {
               message = Component.translatable("jujutsu.technique.crumble_away").getString();
            } else if (effect == 308.0) {
               message = Component.translatable("jujutsu.technique.dont_move").getString();
            } else if (effect == 309.0) {
               message = Component.translatable("jujutsu.technique.blast_away").getString();
            }

            if (!message.equals("NULL") && !entity.level().isClientSide() && entity.getServer() != null) {
               Commands var10000 = entity.getServer().getCommands();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               String var10002 = entityiterator.getDisplayName().getString();
               var10000.performPrefixedCommand(var10001, "tell " + var10002 + " " + message);
            }
         }

      }
   }
}
