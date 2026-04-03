package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_20;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade320Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade320Renderer extends MobRenderer<CursedSpiritGrade320Entity, Modelcursedspirit3_20<CursedSpiritGrade320Entity>> {
   public CursedSpiritGrade320Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_20(context.bakeLayer(Modelcursedspirit3_20.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade320Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_20.png");
   }
}
