package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_8;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade38Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade38Renderer extends MobRenderer<CursedSpiritGrade38Entity, Modelcursedspirit3_8<CursedSpiritGrade38Entity>> {
   public CursedSpiritGrade38Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_8(context.bakeLayer(Modelcursedspirit3_8.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade38Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_8.png");
   }
}
