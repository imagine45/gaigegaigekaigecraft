package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modeldhruv_lakdawalla;
import org.imgaine.gaigegaigekaigecraft.entity.DhruvLakdawallaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DhruvLakdawallaRenderer extends MobRenderer<DhruvLakdawallaEntity, Modeldhruv_lakdawalla<DhruvLakdawallaEntity>> {
   public DhruvLakdawallaRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeldhruv_lakdawalla(context.m_174023_(Modeldhruv_lakdawalla.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(DhruvLakdawallaEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/dhruv_lakdawalla.png");
   }
}
