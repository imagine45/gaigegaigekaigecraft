package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_15;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade315Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade315Renderer extends MobRenderer<CursedSpiritGrade315Entity, Modelcursedspirit3_15<CursedSpiritGrade315Entity>> {
   public CursedSpiritGrade315Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_15(context.bakeLayer(Modelcursedspirit3_15.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade315Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_15.png");
   }
}
