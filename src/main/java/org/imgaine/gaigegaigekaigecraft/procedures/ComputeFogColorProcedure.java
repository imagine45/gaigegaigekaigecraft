package org.imgaine.gaigegaigekaigecraft.procedures;

import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber({Dist.CLIENT})
public class ComputeFogColorProcedure {
   public static ViewportEvent.ComputeFogColor provider = null;

   public ComputeFogColorProcedure() {
   }

   public static void setColor(int color) {
      provider.setRed((float)(color >> 16 & 255) / 255.0F);
      provider.setGreen((float)(color >> 8 & 255) / 255.0F);
      provider.setBlue((float)(color & 255) / 255.0F);
   }

   public static void setColor(float level, int color) {
      if (!(level <= 0.0F)) {
         if (level >= 1.0F) {
            provider.setRed((float)(color >> 16 & 255) / 255.0F);
            provider.setGreen((float)(color >> 8 & 255) / 255.0F);
            provider.setBlue((float)(color & 255) / 255.0F);
         } else {
            level = Mth.m_14036_(level, 0.0F, 1.0F);
            provider.setRed(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getRed(), 0.0F, 1.0F), (float)(color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setGreen(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getGreen(), 0.0F, 1.0F), (float)(color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setBlue(Mth.m_14036_(Mth.m_14179_(level, Mth.m_14036_(provider.getBlue(), 0.0F, 1.0F), (float)(color & 255) / 255.0F), 0.0F, 1.0F));
         }

      }
   }

   @SubscribeEvent
   public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
      provider = event;
      ClientLevel level = Minecraft.m_91087_().f_91073_;
      Entity entity = provider.getCamera().m_90592_();
      if (level != null && entity != null) {
         Vec3 entPos = entity.m_20318_((float)provider.getPartialTick());
         execute(provider, entity);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double var10000;
         label59: {
            double color = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.m_21023_((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = entity.getPersistentData().m_128459_("skill_domain") + 10.0;
                  break label59;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.m_21023_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  var10000 = (double)_livEnt.m_21124_((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).m_19564_();
                  break label59;
               }
            }

            var10000 = 0.0;
         }

         double var6 = var10000;
         if (var6 > 10.0) {
            var6 -= 10.0;
            if (var6 != 1.0 && var6 != 18.0) {
               if (var6 != 4.0 && var6 != 26.0 && var6 != 43.0) {
                  if (var6 != 6.0 && var6 != 11.0 && var6 != 23.0 && var6 != 25.0) {
                     if (var6 == 24.0) {
                        setColor(-3618561);
                     }
                  } else {
                     setColor(-16777216);
                  }
               } else {
                  setColor(-14155776);
               }
            } else {
               setColor(-11534336);
            }
         }

      }
   }
}
