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
            if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.SCALE_CHANGE.get())) {
               return;
            }
         }

         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var10000 = entity.m_20194_().m_129892_();
            CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
            double var10003 = Math.random() - 0.5;
            var10000.m_230957_(var10001, "scale divide pehkui:height " + (1.0 + var10003 * 0.01) + " @s");
         }

         if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
            Commands var6 = entity.m_20194_().m_129892_();
            CommandSourceStack var9 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
            double var12 = Math.random() - 0.5;
            var6.m_230957_(var9, "scale divide pehkui:width " + (1.0 + var12 * 0.01) + " @s");
         }

         size = entity.getPersistentData().m_128459_("SCALE_EFFECT_NUM");
         if (size > 0.0) {
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale delay set pehkui:height 0 @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale delay set pehkui:width 0 @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale multiply pehkui:height " + size + " @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale multiply pehkui:width " + size + " @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var7 = entity.m_20194_().m_129892_();
               CommandSourceStack var10 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               double var13 = Math.random() - 0.5;
               var7.m_230957_(var10, "scale divide pehkui:height " + (1.0 + var13 * 0.01) + " @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var8 = entity.m_20194_().m_129892_();
               CommandSourceStack var11 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               double var14 = Math.random() - 0.5;
               var8.m_230957_(var11, "scale divide pehkui:width " + (1.0 + var14 * 0.01) + " @s");
            }
         }

         entity.getPersistentData().m_128347_("SCALE_EFFECT_NUM", 0.0);
         entity.getPersistentData().m_128379_("SCALE_NOCHANGE", false);
      }
   }
}
