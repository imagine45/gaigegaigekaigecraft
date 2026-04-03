package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.GenericArmorLayer;
import org.imgaine.gaigegaigekaigecraft.GenericItemLayer;
import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSweepEntity;
import org.imgaine.gaigegaigekaigecraft.entity.layer.EntityAttackSweepLayer;
import org.imgaine.gaigegaigekaigecraft.entity.model.EntityAttackSweepModel;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;

public class EntityAttackSweepRenderer extends DynamicGeoEntityRenderer<EntityAttackSweepEntity> {
   public EntityAttackSweepRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new EntityAttackSweepModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new EntityAttackSweepLayer(this));
      this.addRenderLayer(new GenericArmorLayer(this));
      this.addRenderLayer(new GenericItemLayer(this));
   }

   public RenderType getRenderType(EntityAttackSweepEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, EntityAttackSweepEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(EntityAttackSweepEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
