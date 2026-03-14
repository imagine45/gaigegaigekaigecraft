package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelball;
import org.imgaine.gaigegaigekaigecraft.entity.TrueSphereEntity;
import org.imgaine.gaigegaigekaigecraft.procedures.SizeByNBTProcedure;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class TrueSphereRenderer extends MobRenderer<TrueSphereEntity, Modelball<TrueSphereEntity>> {
   public TrueSphereRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelball(context.m_174023_(Modelball.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<TrueSphereEntity, Modelball<TrueSphereEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/tex_black.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, TrueSphereEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelball)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, OverlayTexture.f_118083_, 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   protected void scale(TrueSphereEntity entity, PoseStack poseStack, float f) {
      Level world = entity.m_9236_();
      double x = entity.m_20185_();
      double y = entity.m_20186_();
      double z = entity.m_20189_();
      float scale = (float)SizeByNBTProcedure.execute(entity);
      poseStack.m_85841_(scale, scale, scale);
   }

   public ResourceLocation getTextureLocation(TrueSphereEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/tex_black.png");
   }
}
