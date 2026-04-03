package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelGaruda;
import org.imgaine.gaigegaigekaigecraft.entity.GarudaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class GarudaRenderer extends MobRenderer<GarudaEntity, ModelGaruda<GarudaEntity>> {
   public GarudaRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelGaruda(context.bakeLayer(ModelGaruda.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(GarudaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/garuda.png");
   }
}
