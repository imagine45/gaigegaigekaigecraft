package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_7;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade37Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade37Renderer extends MobRenderer<CursedSpiritGrade37Entity, Modelcursedspirit3_7<CursedSpiritGrade37Entity>> {
   public CursedSpiritGrade37Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_7(context.m_174023_(Modelcursedspirit3_7.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade37Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_7.png");
   }
}
