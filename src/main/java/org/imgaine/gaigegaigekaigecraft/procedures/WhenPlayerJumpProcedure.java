package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class WhenPlayerJumpProcedure {
   public WhenPlayerJumpProcedure() {
   }

   @SubscribeEvent
   public static void onEntityJump(LivingEvent.LivingJumpEvent event) {
      execute(event, event.getEntity());
   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         if (entity instanceof LivingEntity) {
            LivingEntity _livEnt0 = (LivingEntity)entity;
            if (_livEnt0.m_21023_(MobEffects.f_19597_)) {
               Vec3 var10001;
               double var10003;
               double var10004;
               int var10006;
               label18: {
                  var10001 = new Vec3;
                  var10003 = entity.m_20184_().m_7096_();
                  var10004 = entity.m_20184_().m_7098_();
                  if (entity instanceof LivingEntity) {
                     LivingEntity _livEnt = (LivingEntity)entity;
                     if (_livEnt.m_21023_(MobEffects.f_19597_)) {
                        var10006 = _livEnt.m_21124_(MobEffects.f_19597_).m_19564_();
                        break label18;
                     }
                  }

                  var10006 = 0;
               }

               var10001.<init>(var10003, var10004 * Math.max(1.0 - (double)(var10006 + 1) * 0.15, 0.0), entity.m_20184_().m_7094_());
               entity.m_20256_(var10001);
            }
         }

      }
   }
}
