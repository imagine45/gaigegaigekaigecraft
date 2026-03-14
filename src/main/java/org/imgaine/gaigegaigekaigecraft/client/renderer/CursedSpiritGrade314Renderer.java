package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_14;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade314Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade314Renderer extends MobRenderer<CursedSpiritGrade314Entity, Modelcursedspirit3_14<CursedSpiritGrade314Entity>> {
   public CursedSpiritGrade314Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_14(context.m_174023_(Modelcursedspirit3_14.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade314Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_14.png");
   }
}
