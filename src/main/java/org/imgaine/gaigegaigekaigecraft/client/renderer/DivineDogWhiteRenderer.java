package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelDivineDog;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogWhiteEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DivineDogWhiteRenderer extends MobRenderer<DivineDogWhiteEntity, ModelDivineDog<DivineDogWhiteEntity>> {
   public DivineDogWhiteRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelDivineDog(context.m_174023_(ModelDivineDog.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(DivineDogWhiteEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.2F, 1.2F, 1.2F);
   }

   public ResourceLocation getTextureLocation(DivineDogWhiteEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/divinedogwhite.png");
   }
}
