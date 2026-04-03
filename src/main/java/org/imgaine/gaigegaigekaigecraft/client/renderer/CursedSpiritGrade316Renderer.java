package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_16;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade316Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade316Renderer extends MobRenderer<CursedSpiritGrade316Entity, Modelcursedspirit3_16<CursedSpiritGrade316Entity>> {
   public CursedSpiritGrade316Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_16(context.bakeLayer(Modelcursedspirit3_16.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade316Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_16.png");
   }
}
