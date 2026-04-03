package org.imgaine.gaigegaigekaigecraft.procedures;

import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class ScaleChangeOnEffectActiveTickProcedure {
   public ScaleChangeOnEffectActiveTickProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double size = 0.0;
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get())) {
               return;
            }
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            Commands var10000 = entity.getServer().getCommands();
            CommandSourceStack var10001 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
            double var10003 = Math.random() - 0.5;
            var10000.performPrefixedCommand(var10001, "scale divide pehkui:height " + (1.0 + var10003 * 0.01) + " @s");
         }

         if (!entity.level().isClientSide() && entity.getServer() != null) {
            Commands var6 = entity.getServer().getCommands();
            CommandSourceStack var9 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
            double var12 = Math.random() - 0.5;
            var6.performPrefixedCommand(var9, "scale divide pehkui:width " + (1.0 + var12 * 0.01) + " @s");
         }

         size = entity.getPersistentData().getDouble("SCALE_EFFECT_NUM");
         if (size > 0.0) {
            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "scale delay set pehkui:height 0 @s");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "scale delay set pehkui:width 0 @s");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "scale multiply pehkui:height " + size + " @s");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               entity.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity), "scale multiply pehkui:width " + size + " @s");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               Commands var7 = entity.getServer().getCommands();
               CommandSourceStack var10 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               double var13 = Math.random() - 0.5;
               var7.performPrefixedCommand(var10, "scale divide pehkui:height " + (1.0 + var13 * 0.01) + " @s");
            }

            if (!entity.level().isClientSide() && entity.getServer() != null) {
               Commands var8 = entity.getServer().getCommands();
               CommandSourceStack var11 = new CommandSourceStack(CommandSource.NULL, entity.position(), entity.getRotationVector(), entity.level() instanceof ServerLevel ? (ServerLevel)entity.level() : null, 4, entity.getName().getString(), entity.getDisplayName(), entity.level().getServer(), entity);
               double var14 = Math.random() - 0.5;
               var8.performPrefixedCommand(var11, "scale divide pehkui:width " + (1.0 + var14 * 0.01) + " @s");
            }
         }

         entity.getPersistentData().putDouble("SCALE_EFFECT_NUM", 0.0);
         entity.getPersistentData().putBoolean("SCALE_NOCHANGE", false);
      }
   }
}
