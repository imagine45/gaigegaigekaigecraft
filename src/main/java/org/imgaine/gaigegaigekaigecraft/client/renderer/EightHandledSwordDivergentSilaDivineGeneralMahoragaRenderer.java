package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import org.imgaine.gaigegaigekaigecraft.entity.layer.EightHandledSwordDivergentSilaDivineGeneralMahoragaLayer;
import org.imgaine.gaigegaigekaigecraft.entity.model.EightHandledSwordDivergentSilaDivineGeneralMahoragaModel;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class EightHandledSwordDivergentSilaDivineGeneralMahoragaRenderer extends GeoEntityRenderer<EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity> {
   public EightHandledSwordDivergentSilaDivineGeneralMahoragaRenderer(EntityRendererProvider.Context renderManager) {
      super(renderManager, new EightHandledSwordDivergentSilaDivineGeneralMahoragaModel());
      this.shadowRadius = 0.0F;
      this.addRenderLayer(new EightHandledSwordDivergentSilaDivineGeneralMahoragaLayer(this));
   }

   public RenderType getRenderType(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
      return RenderType.entityTranslucent(this.getTextureLocation(animatable));
   }

   public void preRender(PoseStack poseStack, EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      this.scaleHeight = scale;
      this.scaleWidth = scale;
      super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
   }

   protected float getDeathMaxRotation(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entityLivingBaseIn) {
      return 0.0F;
   }
}
