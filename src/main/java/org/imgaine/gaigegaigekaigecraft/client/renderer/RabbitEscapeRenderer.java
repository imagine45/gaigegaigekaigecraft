package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelRabbitEscape;
import org.imgaine.gaigegaigekaigecraft.entity.RabbitEscapeEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RabbitEscapeRenderer extends MobRenderer<RabbitEscapeEntity, ModelRabbitEscape<RabbitEscapeEntity>> {
   public RabbitEscapeRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelRabbitEscape(context.bakeLayer(ModelRabbitEscape.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(RabbitEscapeEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/rabbitescape.png");
   }
}
