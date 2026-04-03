package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelrock_fragment;
import org.imgaine.gaigegaigekaigecraft.entity.RockFragmentEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import org.imgaine.gaigegaigekaigecraft.procedures.WoodenSpear1DisplayConditionProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class RockFragmentRenderer extends MobRenderer<RockFragmentEntity, Modelrock_fragment<RockFragmentEntity>> {
   public RockFragmentRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.bakeLayer(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
      this.addLayer(new RenderLayer<RockFragmentEntity, Modelrock_fragment<RockFragmentEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/ball_maximum.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, RockFragmentEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            Level world = entity.level();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            if (WoodenSpear1DisplayConditionProcedure.execute(entity)) {
               VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(this.LAYER_TEXTURE));
               ((Modelrock_fragment)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
            }

         }
      });
      this.addLayer(new RenderLayer<RockFragmentEntity, Modelrock_fragment<RockFragmentEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/ball_maximum.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, RockFragmentEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            Level world = entity.level();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            if (WoodenSpear1DisplayConditionProcedure.execute(entity)) {
               VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
               ((Modelrock_fragment)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
            }

         }
      });
   }

   protected void scale(RockFragmentEntity entity, PoseStack poseStack, float f) {
      Level world = entity.level();
      double x = entity.getX();
      double y = entity.getY();
      double z = entity.getZ();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.scale(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(RockFragmentEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/rock_fragment.png");
   }
}
