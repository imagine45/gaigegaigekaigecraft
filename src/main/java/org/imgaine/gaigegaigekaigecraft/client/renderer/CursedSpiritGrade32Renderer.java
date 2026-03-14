package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_2;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade32Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade32Renderer extends MobRenderer<CursedSpiritGrade32Entity, Modelcursedspirit3_2<CursedSpiritGrade32Entity>> {
   public CursedSpiritGrade32Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_2(context.m_174023_(Modelcursedspirit3_2.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CursedSpiritGrade32Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.1F, 1.1F, 1.1F);
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade32Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_2.png");
   }
}
