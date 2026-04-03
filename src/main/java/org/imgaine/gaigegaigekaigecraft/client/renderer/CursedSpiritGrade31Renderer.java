package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_1;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade31Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade31Renderer extends MobRenderer<CursedSpiritGrade31Entity, Modelcursedspirit3_1<CursedSpiritGrade31Entity>> {
   public CursedSpiritGrade31Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_1(context.bakeLayer(Modelcursedspirit3_1.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade31Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/cursedspirit3_1.png");
   }
}
