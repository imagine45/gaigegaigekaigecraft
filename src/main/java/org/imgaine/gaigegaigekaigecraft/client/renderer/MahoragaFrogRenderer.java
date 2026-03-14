package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelMahoraga_frog6;
import org.imgaine.gaigegaigekaigecraft.entity.MahoragaFrogEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class MahoragaFrogRenderer extends MobRenderer<MahoragaFrogEntity, ModelMahoraga_frog6<MahoragaFrogEntity>> {
   public MahoragaFrogRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelMahoraga_frog6(context.m_174023_(ModelMahoraga_frog6.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(MahoragaFrogEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(0.6F, 0.6F, 0.6F);
   }

   public ResourceLocation getTextureLocation(MahoragaFrogEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/mahoraga_frog6.png");
   }
}
