package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelawaji_knot;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAwajiKnotEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityAwajiKnotRenderer extends MobRenderer<EntityAwajiKnotEntity, Modelawaji_knot<EntityAwajiKnotEntity>> {
   public EntityAwajiKnotRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelawaji_knot(context.bakeLayer(Modelawaji_knot.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntityAwajiKnotEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(3.4F, 3.4F, 3.4F);
   }

   public ResourceLocation getTextureLocation(EntityAwajiKnotEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/awaji_knot.png");
   }
}
