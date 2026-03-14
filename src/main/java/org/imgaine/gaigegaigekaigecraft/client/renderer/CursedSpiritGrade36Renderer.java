package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_6;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade36Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade36Renderer extends MobRenderer<CursedSpiritGrade36Entity, Modelcursedspirit3_6<CursedSpiritGrade36Entity>> {
   public CursedSpiritGrade36Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_6(context.m_174023_(Modelcursedspirit3_6.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade36Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(0.8F, 0.8F, 0.8F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade36Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_6.png");
   }
}
