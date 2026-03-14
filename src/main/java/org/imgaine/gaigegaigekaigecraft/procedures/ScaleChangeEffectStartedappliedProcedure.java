package org.imgaine.gaigegaigekaigecraft.procedures;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;

public class ScaleChangeEffectStartedappliedProcedure {
   public ScaleChangeEffectStartedappliedProcedure() {
   }

   public static void execute(Entity entity) {
      if (entity != null) {
         double size = 0.0;
         if (!entity.getPersistentData().m_128471_("SCALE_NOCHANGE")) {
            entity.getPersistentData().m_128379_("SCALE_NOCHANGE", true);
            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var10000 = entity.m_20194_().m_129892_();
               CommandSourceStack var10001 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               double var10003 = Math.random() - 0.5;
               var10000.m_230957_(var10001, "scale divide pehkui:height " + (1.0 + var10003 * 0.01) + " @s");
            }

            if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
               Commands var5 = entity.m_20194_().m_129892_();
               CommandSourceStack var8 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
               double var11 = Math.random() - 0.5;
               var5.m_230957_(var8, "scale divide pehkui:width " + (1.0 + var11 * 0.01) + " @s");
            }

            size = (double)Math.max(entity.m_20206_(), entity.m_20205_()) * 0.75;
            if (size > 0.0) {
               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale delay set pehkui:height 0 @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale delay set pehkui:width 0 @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale divide pehkui:height " + size + " @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  entity.m_20194_().m_129892_().m_230957_(new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity), "scale divide pehkui:width " + size + " @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var6 = entity.m_20194_().m_129892_();
                  CommandSourceStack var9 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  double var12 = Math.random() - 0.5;
                  var6.m_230957_(var9, "scale divide pehkui:height " + (1.0 + var12 * 0.01) + " @s");
               }

               if (!entity.m_9236_().m_5776_() && entity.m_20194_() != null) {
                  Commands var7 = entity.m_20194_().m_129892_();
                  CommandSourceStack var10 = new CommandSourceStack(CommandSource.f_80164_, entity.m_20182_(), entity.m_20155_(), entity.m_9236_() instanceof ServerLevel ? (ServerLevel)entity.m_9236_() : null, 4, entity.m_7755_().getString(), entity.m_5446_(), entity.m_9236_().m_7654_(), entity);
                  double var13 = Math.random() - 0.5;
                  var7.m_230957_(var10, "scale divide pehkui:width " + (1.0 + var13 * 0.01) + " @s");
               }
            }

            entity.getPersistentData().m_128347_("SCALE_EFFECT_NUM", size);
         }

      }
   }
}
