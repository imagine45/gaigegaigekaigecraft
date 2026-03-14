package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit1_3;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade13Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade13Renderer extends MobRenderer<CursedSpiritGrade13Entity, Modelcursedspirit1_3<CursedSpiritGrade13Entity>> {
   public CursedSpiritGrade13Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit1_3(context.m_174023_(Modelcursedspirit1_3.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<CursedSpiritGrade13Entity, Modelcursedspirit1_3<CursedSpiritGrade13Entity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/cursedspirit1_3__glow.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CursedSpiritGrade13Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelcursedspirit1_3)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade13Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit1_3.png");
   }
}
