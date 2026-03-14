package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_11;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade311Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade311Renderer extends MobRenderer<CursedSpiritGrade311Entity, Modelcursedspirit3_11<CursedSpiritGrade311Entity>> {
   public CursedSpiritGrade311Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_11(context.m_174023_(Modelcursedspirit3_11.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade311Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_11.png");
   }
}
