package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelball;
import org.imgaine.gaigegaigekaigecraft.entity.TrueSphereEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class TrueSphereRenderer extends MobRenderer<TrueSphereEntity, Modelball<TrueSphereEntity>> {
   public TrueSphereRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelball(context.bakeLayer(Modelball.LAYER_LOCATION)), 0.0F);
      this.addLayer(new RenderLayer<TrueSphereEntity, Modelball<TrueSphereEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_black.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, TrueSphereEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
            ((Modelball)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   protected void scale(TrueSphereEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(TrueSphereEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_black.png");
   }
}
