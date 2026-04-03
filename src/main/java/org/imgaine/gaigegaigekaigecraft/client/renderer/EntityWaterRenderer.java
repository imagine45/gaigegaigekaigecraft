package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.entity.EntityWaterEntity;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityWaterRenderer extends MobRenderer<EntityWaterEntity, PigModel<EntityWaterEntity>> {
   public EntityWaterRenderer(EntityRendererProvider.Context context) {
      super(context, new PigModel(context.bakeLayer(ModelLayers.PIG)), 0.0F);
   }

   public ResourceLocation getTextureLocation(EntityWaterEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/clear.png");
   }
}
