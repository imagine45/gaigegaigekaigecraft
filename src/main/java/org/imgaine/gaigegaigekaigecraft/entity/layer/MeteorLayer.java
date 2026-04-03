package org.imgaine.gaigegaigekaigecraft.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class MeteorLayer extends GeoRenderLayer<MeteorEntity> {
   private static final ResourceLocation LAYER0 = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/flame.png");
   private static final ResourceLocation LAYER1 = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/ball_maximum.png");

   public MeteorLayer(GeoRenderer<MeteorEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, MeteorEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType;
      if ((Integer)animatable.getEntityData().get(MeteorEntity.DATA_mode) == 0) {
         glowRenderType = RenderType.eyes(LAYER0);
      } else {
         glowRenderType = RenderType.eyes(LAYER1);
      }

      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
