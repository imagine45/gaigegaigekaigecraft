package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelself_embodiment_of_perfection;
import org.imgaine.gaigegaigekaigecraft.entity.EntityHandsEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityHandsRenderer extends MobRenderer<EntityHandsEntity, Modelself_embodiment_of_perfection<EntityHandsEntity>> {
   public EntityHandsRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelself_embodiment_of_perfection(context.bakeLayer(Modelself_embodiment_of_perfection.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityHandsEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/self_embodiment_of_perfection.png");
   }
}
