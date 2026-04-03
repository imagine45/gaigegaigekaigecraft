package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import org.imgaine.gaigegaigekaigecraft.entity.layer.EntityImpactWaveLayer;
import org.imgaine.gaigegaigekaigecraft.entity.model.EntityImpactWaveModel;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EntityImpactWaveRenderer extends GeoEntityRenderer<EntityImpactWaveEntity> {
   public EntityImpactWaveRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new EntityImpactWaveModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new EntityImpactWaveLayer(this));
   }

   public RenderType getRenderType(EntityImpactWaveEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, EntityImpactWaveEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(EntityImpactWaveEntity entityLivingBaseIn) {
      return 0.0F;
   }

   public boolean shouldRender(EntityImpactWaveEntity entity, Frustum frustum, double camX, double camY, double camZ) {
      return true;
   }
}
