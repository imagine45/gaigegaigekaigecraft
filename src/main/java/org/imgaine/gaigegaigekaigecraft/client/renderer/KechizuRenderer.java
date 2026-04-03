package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelkechizu;
import org.imgaine.gaigegaigekaigecraft.entity.KechizuEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class KechizuRenderer extends MobRenderer<KechizuEntity, Modelkechizu<KechizuEntity>> {
   public KechizuRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelkechizu(context.bakeLayer(Modelkechizu.LAYER_LOCATION)), 0.6F);
   }

   public ResourceLocation getTextureLocation(KechizuEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/kechizu.png");
   }
}
