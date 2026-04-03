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
            level = Mth.clamp(level, 0.0F, 1.0F);
            provider.setRed(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getRed(), 0.0F, 1.0F), (float)(color >> 16 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setGreen(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getGreen(), 0.0F, 1.0F), (float)(color >> 8 & 255) / 255.0F), 0.0F, 1.0F));
            provider.setBlue(Mth.clamp(Mth.lerp(level, Mth.clamp(provider.getBlue(), 0.0F, 1.0F), (float)(color & 255) / 255.0F), 0.0F, 1.0F));
         }

      }
   }

   @SubscribeEvent
   public static void computeFogColor(ViewportEvent.ComputeFogColor event) {
      provider = event;
      ClientLevel level = Minecraft.getInstance().level;
      Entity entity = provider.getCamera().getEntity();
      if (level != null && entity != null) {
         Vec3 entPos = entity.getPosition((float)provider.getPartialTick());
         execute(provider, entity);
      }

   }

   public static void execute(Entity entity) {
      execute((Event)null, entity);
   }

   private static void execute(@Nullable Event event, Entity entity) {
      if (entity != null) {
         double var9;
         label74: {
            double color = 0.0;
            if (entity instanceof LivingEntity) {
               LivingEntity _livEnt0 = (LivingEntity)entity;
               if (_livEnt0.hasEffect((MobEffect)JujutsucraftModMobEffects.DOMAIN_EXPANSION.get())) {
                  var9 = entity.getPersistentData().getDouble("skill_domain") + 10.0;
                  break label74;
               }
            }
            int var10000;
            label65: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.COLOR.get())) {
                     var10000 = _livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.COLOR.get()).getAmplifier();
                     break label65;
                  }
               }

               var10000 = 0;
            }

            var9 = (double)(var10000 + 10);
         }

         double var6 = var9;
         if (var6 <= 10.0) {
            label58: {
               if (entity instanceof LivingEntity) {
                  LivingEntity _livEnt = (LivingEntity)entity;
                  if (_livEnt.hasEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get())) {
                     var9 = (double)_livEnt.getEffect((MobEffect)JujutsucraftModMobEffects.NEUTRALIZATION.get()).getAmplifier();
                     break label58;
                  }
               }

               var9 = 0.0;
            }

            var6 = var9;
         }

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
