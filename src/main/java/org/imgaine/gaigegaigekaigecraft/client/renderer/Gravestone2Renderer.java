package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelgravestone2;
import org.imgaine.gaigegaigekaigecraft.entity.Gravestone2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class Gravestone2Renderer extends MobRenderer<Gravestone2Entity, Modelgravestone2<Gravestone2Entity>> {
   public Gravestone2Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelgravestone2(context.bakeLayer(Modelgravestone2.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(Gravestone2Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/gravestone.png");
   }
}
