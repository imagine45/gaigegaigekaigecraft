package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_12;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade312Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade312Renderer extends MobRenderer<CursedSpiritGrade312Entity, Modelcursedspirit3_12<CursedSpiritGrade312Entity>> {
   public CursedSpiritGrade312Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_12(context.m_174023_(Modelcursedspirit3_12.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade312Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_12.png");
   }
}
