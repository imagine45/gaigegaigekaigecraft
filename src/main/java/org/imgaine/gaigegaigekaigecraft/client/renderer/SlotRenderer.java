package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.GenericArmorLayer;
import org.imgaine.gaigegaigekaigecraft.GenericItemLayer;
import org.imgaine.gaigegaigekaigecraft.entity.SlotEntity;
import org.imgaine.gaigegaigekaigecraft.entity.model.SlotModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class SlotRenderer extends DynamicGeoEntityRenderer<SlotEntity> {
   public SlotRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new SlotModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new GenericArmorLayer(this));
      this.addRenderLayer(new GenericItemLayer(this));
   }

   public RenderType getRenderType(SlotEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, SlotEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      float scale = 1.5F;
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(SlotEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
