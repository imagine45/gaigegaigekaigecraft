package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelclock;
import org.imgaine.gaigegaigekaigecraft.entity.EntityClockEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityClockRenderer extends MobRenderer<EntityClockEntity, Modelclock<EntityClockEntity>> {
   public EntityClockRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelclock(context.m_174023_(Modelclock.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityClockEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/clock.png");
   }
}
