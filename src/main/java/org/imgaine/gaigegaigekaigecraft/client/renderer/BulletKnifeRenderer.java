package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelkitchen_knife;
import org.imgaine.gaigegaigekaigecraft.entity.BulletKnifeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class BulletKnifeRenderer extends EntityRenderer<BulletKnifeEntity> {
   private static final ResourceLocation texture = new ResourceLocation("gaigegaigekaigecraft:textures/entities/knife.png");
   private final Modelkitchen_knife model;

   public BulletKnifeRenderer(EntityRendererProvider.Context context) {
      super(context);
      this.model = new Modelkitchen_knife(context.bakeLayer(Modelkitchen_knife.LAYER_LOCATION));
   }

   public void render(BulletKnifeEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
      VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
      poseStack.pushPose();
      poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90.0F));
      poseStack.mulPose(Axis.ZP.rotationDegrees(90.0F + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
      this.model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      poseStack.popPose();
      super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
   }

   public ResourceLocation getTextureLocation(BulletKnifeEntity entity) {
      return texture;
   }
}
