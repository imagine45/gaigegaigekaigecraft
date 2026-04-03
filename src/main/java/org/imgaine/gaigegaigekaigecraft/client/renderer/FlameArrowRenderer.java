package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelflame_arrow;
import org.imgaine.gaigegaigekaigecraft.entity.FlameArrowEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class FlameArrowRenderer extends MobRenderer<FlameArrowEntity, Modelflame_arrow<FlameArrowEntity>> {
   public FlameArrowRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelflame_arrow(context.bakeLayer(Modelflame_arrow.LAYER_LOCATION)), 0.0F);
      this.addLayer(new RenderLayer<FlameArrowEntity, Modelflame_arrow<FlameArrowEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("gaigegaigekaigecraft:textures/entities/flame_arrow.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlameArrowEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.eyes(this.LAYER_TEXTURE));
            ((Modelflame_arrow)this.getParentModel()).renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(FlameArrowEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/clear.png");
   }
}
