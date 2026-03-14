package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelMahoraga_dog6;
import org.imgaine.gaigegaigekaigecraft.entity.MahoragaDogEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MahoragaDogRenderer extends MobRenderer<MahoragaDogEntity, ModelMahoraga_dog6<MahoragaDogEntity>> {
   public MahoragaDogRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahoraga_dog6(context.m_174023_(ModelMahoraga_dog6.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(MahoragaDogEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/mahoraga_dog6.png");
   }
}
