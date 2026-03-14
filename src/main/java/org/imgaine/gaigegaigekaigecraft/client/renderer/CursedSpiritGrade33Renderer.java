package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_3;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade33Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade33Renderer extends MobRenderer<CursedSpiritGrade33Entity, Modelcursedspirit3_3<CursedSpiritGrade33Entity>> {
   public CursedSpiritGrade33Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_3(context.m_174023_(Modelcursedspirit3_3.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade33Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_3.png");
   }
}
