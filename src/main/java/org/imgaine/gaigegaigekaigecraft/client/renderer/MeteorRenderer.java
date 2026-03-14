package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelball_maximum;
import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class MeteorRenderer extends MobRenderer<MeteorEntity, Modelball_maximum<MeteorEntity>> {
   public MeteorRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelball_maximum(context.m_174023_(Modelball_maximum.LAYER_LOCATION)), 10.0F);
      this.m_115326_(new RenderLayer<MeteorEntity, Modelball_maximum<MeteorEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/ball_maximum.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, MeteorEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelball_maximum)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(MeteorEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/ball_maximum.png");
   }
}
