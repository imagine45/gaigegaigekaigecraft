package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelrock_fragment;
import org.imgaine.gaigegaigekaigecraft.entity.FoxFireEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class FoxFireRenderer extends MobRenderer<FoxFireEntity, Modelrock_fragment<FoxFireEntity>> {
   public FoxFireRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.bakeLayer(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
      this.addLayer(new RenderLayer<FoxFireEntity, Modelrock_fragment<FoxFireEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_ice.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FoxFireEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
            ((Modelrock_fragment)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   protected void scale(FoxFireEntity entity, PoseStack poseStack, float f) {
      poseStack.scale(0.2F, 0.2F, 0.2F);
   }

   public ResourceLocation getTextureLocation(FoxFireEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/clear.png");
   }
}
