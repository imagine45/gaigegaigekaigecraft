package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_4;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade34Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade34Renderer extends MobRenderer<CursedSpiritGrade34Entity, Modelcursedspirit3_4<CursedSpiritGrade34Entity>> {
   public CursedSpiritGrade34Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_4(context.bakeLayer(Modelcursedspirit3_4.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade34Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_4.png");
   }
}
