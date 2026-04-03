package org.imgaine.gaigegaigekaigecraft.init;

import org.imgaine.gaigegaigekaigecraft.api.IAnimatableEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class EntityAnimationFactory {
   public EntityAnimationFactory() {
   }

   @SubscribeEvent
   public static void onEntityTick(LivingEvent.LivingTickEvent event) {
      if (event != null && event.getEntity() != null) {
         LivingEntity var2 = event.getEntity();
         if (var2 instanceof IAnimatableEntity) {
            IAnimatableEntity animatableEntity = (IAnimatableEntity)var2;
            String animation = animatableEntity.getSyncedAnimation();
            if (!animation.equals("undefined")) {
               animatableEntity.setAnimation("undefined");
               animatableEntity.setAnimationProcedure(animation);
            }
         }
      }

   }
}
