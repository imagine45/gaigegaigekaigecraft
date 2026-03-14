package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_19;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade319Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade319Renderer extends MobRenderer<CursedSpiritGrade319Entity, Modelcursedspirit3_19<CursedSpiritGrade319Entity>> {
   public CursedSpiritGrade319Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_19(context.m_174023_(Modelcursedspirit3_19.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade319Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(2.0F, 2.0F, 2.0F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade319Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_19.png");
   }
}
