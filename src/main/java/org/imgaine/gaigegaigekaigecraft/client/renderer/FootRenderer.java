package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelfoot;
import org.imgaine.gaigegaigekaigecraft.entity.FootEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class FootRenderer extends MobRenderer<FootEntity, Modelfoot<FootEntity>> {
   public FootRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelfoot(context.m_174023_(Modelfoot.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(FootEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(2.0F, 2.0F, 2.0F);
   }

   public ResourceLocation getTextureLocation(FootEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/foot.png");
   }
}
