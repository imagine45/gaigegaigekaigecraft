package org.imgaine.gaigegaigekaigecraft.procedures;

import com.mojang.blaze3d.shaders.FogShape;
import javax.annotation.Nullable;
import org.imgaine.gaigegaigekaigecraft.init.JujutsucraftModMobEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer.FogMode;
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
public class RenderFogProcedure {
   public static ViewportEvent.RenderFog provider = null;

   public RenderFogProcedure() {
   }

   public static void setDistance(float start, float end) {
      provider.setNearPlaneDistance(start);
      provider.setFarPlaneDistance(end);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }

   }

   public static void setShape(FogShape shape) {
      provider.setFogShape(shape);
      if (!provider.isCanceled()) {
         provider.setCanceled(true);
      }

   }

   @SubscribeEvent
   public static void renderFog(ViewportEvent.RenderFog event) {
      provider = event;
      if (provider.getMode() == FogMode.FOG_TERRAIN) {
         ClientLevel level = Minecraft.getInstance().level;
         Entity entity = provider.getCamera().getEntity();
         if (level != null && entity != null) {
            Vec3 pos = entity.getPosition((float)provider.getPartialTick());
            execute(provider, entity);
         }
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double var10000;
         label61: {
            double color = 0.0;
            double distance = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var10000 = entity.getPersistentData().getDouble("skill_domain") + 10.0;
                  break label61;
               }
            }

            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt = (LivingEntity)entity;
               if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                  var10000 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                  break label61;
               }
            }

            var10000 = 0.0;
         }

         double var8 = var10000;
         if (var8 > 10.0) {
            var8 -= 10.0;
            double var10;
            if (var8 != 1.0 && var8 != 18.0) {
               var10 = 48.0;
            } else {
               var10 = 64.0;
            }

            if (var8 == 1.0 || var8 == 18.0 || var8 == 4.0 || var8 == 26.0 || var8 == 43.0 || var8 == 6.0 || var8 == 11.0 || var8 == 23.0 || var8 == 25.0 || var8 == 24.0) {
               setDistance(0.0F, (float)var10);
               setShape(FogShape.SPHERE);
            }
         }

      }
   }
}
