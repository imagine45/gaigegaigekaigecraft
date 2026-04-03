package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit2_3;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade23Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade23Renderer extends MobRenderer<CursedSpiritGrade23Entity, Modelcursedspirit2_3<CursedSpiritGrade23Entity>> {
   public CursedSpiritGrade23Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit2_3(context.bakeLayer(Modelcursedspirit2_3.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade23Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit2_3.png");
   }
}
