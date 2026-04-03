package org.imgaine.gaigegaigekaigecraft.entity.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;

public class EntityImpactWaveLayer extends GeoRenderLayer<EntityImpactWaveEntity> {
   private static final ResourceLocation LAYER0 = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/orange.png");
   private static final ResourceLocation LAYER1 = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/flame_tiger.png");
   private static final ResourceLocation LAYER2 = new ResourceLocation("gaigegaigekaigecraft", "textures/entities/red.png");

   public EntityImpactWaveLayer(GeoRenderer<EntityImpactWaveEntity> entityRenderer) {
      super(entityRenderer);
   }

   public void render(PoseStack poseStack, EntityImpactWaveEntity animatable, BakedGeoModel bakedModel, RenderType renderType, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
      RenderType glowRenderType;
      if ((Integer)animatable.getEntityData().get(EntityImpactWaveEntity.DATA_mode) == 2) {
         glowRenderType = RenderType.eyes(LAYER2);
      } else if ((Integer)animatable.getEntityData().get(EntityImpactWaveEntity.DATA_mode) == 1) {
         glowRenderType = RenderType.eyes(LAYER1);
      } else {
         glowRenderType = RenderType.eyes(LAYER0);
      }

      this.getRenderer().reRender(this.getDefaultBakedModel(animatable), poseStack, bufferSource, animatable, glowRenderType, bufferSource.getBuffer(glowRenderType), partialTick, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
   }
}
