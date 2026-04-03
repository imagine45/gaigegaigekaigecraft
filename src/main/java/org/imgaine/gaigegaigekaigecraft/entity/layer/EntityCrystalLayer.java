package org.imgaine.gaigegaigekaigecraft.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityCrystalEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class EntityCrystalLayer extends GeoRenderLayer<EntityCrystalEntity> {
   private static final ResourceLocation LAYER = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/cursedspirit1_12.png");

   public EntityCrystalLayer(GeoRenderer<EntityCrystalEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, EntityCrystalEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType = RenderType.eyes(LAYER);
      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
