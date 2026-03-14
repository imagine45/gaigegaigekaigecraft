package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcursedspirit3_17;
import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade317Entity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class CursedSpiritGrade317Renderer extends MobRenderer<CursedSpiritGrade317Entity, Modelcursedspirit3_17<CursedSpiritGrade317Entity>> {
   public CursedSpiritGrade317Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelcursedspirit3_17(context.m_174023_(Modelcursedspirit3_17.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<CursedSpiritGrade317Entity, Modelcursedspirit3_17<CursedSpiritGrade317Entity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_17_glow.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, CursedSpiritGrade317Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110488_(this.LAYER_TEXTURE));
            ((Modelcursedspirit3_17)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
         }
      });
   }

   public ResourceLocation getTextureLocation(CursedSpiritGrade317Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cursedspirit3_17.png");
   }
}
