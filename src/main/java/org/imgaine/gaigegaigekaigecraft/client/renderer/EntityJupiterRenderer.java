package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelball;
import org.imgaine.gaigegaigekaigecraft.entity.EntityJupiterEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class EntityJupiterRenderer extends MobRenderer<EntityJupiterEntity, Modelball<EntityJupiterEntity>> {
   public EntityJupiterRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelball(context.bakeLayer(Modelball.LAYER_LOCATION)), 0.0F);
      this.addLayer(new RenderLayer<EntityJupiterEntity, Modelball<EntityJupiterEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_jupiter.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, EntityJupiterEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
            ((Modelball)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   protected void scale(EntityJupiterEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(24.0F, 24.0F, 24.0F);
   }

   public ResourceLocation getTextureLocation(EntityJupiterEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_jupiter.png");
   }
}
