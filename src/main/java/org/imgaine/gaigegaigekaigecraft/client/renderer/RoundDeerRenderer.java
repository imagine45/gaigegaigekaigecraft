package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelRoundDeer;
import org.imgaine.gaigegaigekaigecraft.entity.RoundDeerEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RoundDeerRenderer extends MobRenderer<RoundDeerEntity, ModelRoundDeer<RoundDeerEntity>> {
   public RoundDeerRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelRoundDeer(context.bakeLayer(ModelRoundDeer.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(RoundDeerEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/rounddeer.png");
   }
}
