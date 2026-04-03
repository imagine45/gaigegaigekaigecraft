package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelDivineDog;
import org.imgaine.gaigegaigekaigecraft.entity.DivineDogBlackEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DivineDogBlackRenderer extends MobRenderer<DivineDogBlackEntity, ModelDivineDog<DivineDogBlackEntity>> {
   public DivineDogBlackRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelDivineDog(context.bakeLayer(ModelDivineDog.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(DivineDogBlackEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(1.2F, 1.2F, 1.2F);
   }

   public ResourceLocation getTextureLocation(DivineDogBlackEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/divinedogblack.png");
   }
}
