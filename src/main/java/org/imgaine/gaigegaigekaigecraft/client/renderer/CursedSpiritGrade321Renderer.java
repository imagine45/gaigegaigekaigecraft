package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_21;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade321Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade321Renderer extends MobRenderer<CursedSpiritGrade321Entity, Modelcursedspirit3_21<CursedSpiritGrade321Entity>> {
   public CursedSpiritGrade321Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_21(context.m_174023_(Modelcursedspirit3_21.LAYER_LOCATION)), 0.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade321Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_21.png");
   }
}
