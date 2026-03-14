package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelogami;
import org.imgaine.gaigegaigekaigecraft.entity.OgamiEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class OgamiRenderer extends MobRenderer<OgamiEntity, Modelogami<OgamiEntity>> {
   public OgamiRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelogami(context.m_174023_(Modelogami.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(OgamiEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/ogami.png");
   }
}
