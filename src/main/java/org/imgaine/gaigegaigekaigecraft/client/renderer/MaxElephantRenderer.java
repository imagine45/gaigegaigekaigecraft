package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelMaxElephant;
import org.imgaine.gaigegaigekaigecraft.entity.MaxElephantEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MaxElephantRenderer extends MobRenderer<MaxElephantEntity, ModelMaxElephant<MaxElephantEntity>> {
   public MaxElephantRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMaxElephant(context.m_174023_(ModelMaxElephant.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(MaxElephantEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/maxelephant.png");
   }
}
