package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelrock_fragment;
import org.imgaine.gaigegaigekaigecraft.entity.DomainExpansionEntityEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DomainExpansionEntityRenderer extends MobRenderer<DomainExpansionEntityEntity, Modelrock_fragment<DomainExpansionEntityEntity>> {
   public DomainExpansionEntityRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.bakeLayer(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(DomainExpansionEntityEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/clear.png");
   }
}
