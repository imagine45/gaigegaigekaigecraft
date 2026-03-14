package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.ModelPiercing_Ox;
import org.imgaine.gaigegaigekaigecraft.entity.PiercingOxEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PiercingOxRenderer extends MobRenderer<PiercingOxEntity, ModelPiercing_Ox<PiercingOxEntity>> {
   public PiercingOxRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelPiercing_Ox(context.m_174023_(ModelPiercing_Ox.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(PiercingOxEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/piercingox.png");
   }
}
