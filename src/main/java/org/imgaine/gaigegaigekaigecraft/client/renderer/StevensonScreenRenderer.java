package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelstevenson_screen;
import org.imgaine.gaigegaigekaigecraft.entity.StevensonScreenEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class StevensonScreenRenderer extends MobRenderer<StevensonScreenEntity, Modelstevenson_screen<StevensonScreenEntity>> {
   public StevensonScreenRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelstevenson_screen(context.bakeLayer(Modelstevenson_screen.LAYER_LOCATION)), 0.5F);
   }

   public ResourceLocation getTextureLocation(StevensonScreenEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/stevensonscreen.png");
   }
}
