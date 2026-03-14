package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelflame_tiger;
import org.imgaine.gaigegaigekaigecraft.entity.FlameTigerEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class FlameTigerRenderer extends MobRenderer<FlameTigerEntity, Modelflame_tiger<FlameTigerEntity>> {
   public FlameTigerRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelflame_tiger(context.m_174023_(Modelflame_tiger.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<FlameTigerEntity, Modelflame_tiger<FlameTigerEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/flame_tiger.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FlameTigerEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelflame_tiger)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(FlameTigerEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/flame_tiger.png");
   }
}
