package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.GenericArmorLayer;
import org.imgaine.gaigegaigekaigecraft.GenericItemLayer;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenBall1Entity;
import org.imgaine.gaigegaigekaigecraft.entity.model.WoodenBall1Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class WoodenBall1Renderer extends DynamicGeoEntityRenderer<WoodenBall1Entity> {
   public WoodenBall1Renderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new WoodenBall1Model());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new GenericArmorLayer(this));
      this.addRenderLayer(new GenericItemLayer(this));
   }

   public RenderType getRenderType(WoodenBall1Entity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, WoodenBall1Entity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 2.0F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(WoodenBall1Entity entityLivingBaseIn) {
      return 0.0F;
   }
}
