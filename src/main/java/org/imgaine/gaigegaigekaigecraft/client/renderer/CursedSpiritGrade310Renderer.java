package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_10;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade310Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade310Renderer extends MobRenderer<CursedSpiritGrade310Entity, Modelcursedspirit3_10<CursedSpiritGrade310Entity>> {
   public CursedSpiritGrade310Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_10(context.bakeLayer(Modelcursedspirit3_10.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade310Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_10.png");
   }
}
