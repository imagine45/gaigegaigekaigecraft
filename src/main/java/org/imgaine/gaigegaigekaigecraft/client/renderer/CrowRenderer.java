package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcrow;
import org.imgaine.gaigegaigekaigecraft.entity.CrowEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CrowRenderer extends MobRenderer<CrowEntity, Modelcrow<CrowEntity>> {
   public CrowRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelcrow(context.bakeLayer(Modelcrow.LAYER_LOCATION)), 0.3F);
   }

   public ResourceLocation getTextureLocation(CrowEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/crow.png");
   }
}
