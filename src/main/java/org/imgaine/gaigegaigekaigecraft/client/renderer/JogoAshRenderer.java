package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modeljogo_ash;
import org.imgaine.gaigegaigekaigecraft.entity.JogoAshEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class JogoAshRenderer extends MobRenderer<JogoAshEntity, Modeljogo_ash<JogoAshEntity>> {
   public JogoAshRenderer(EntityRendererProvider.Context context) {
      super(context, new Modeljogo_ash(context.m_174023_(Modeljogo_ash.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<JogoAshEntity, Modeljogo_ash<JogoAshEntity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/jogo_ash.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, JogoAshEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modeljogo_ash)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(JogoAshEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/jogo_ash.png");
   }
}
