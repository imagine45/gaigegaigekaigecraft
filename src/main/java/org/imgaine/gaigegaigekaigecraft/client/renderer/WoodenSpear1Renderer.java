package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelwooden_spear1;
import org.imgaine.gaigegaigekaigecraft.entity.WoodenSpear1Entity;
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

public class WoodenSpear1Renderer extends MobRenderer<WoodenSpear1Entity, Modelwooden_spear1<WoodenSpear1Entity>> {
   public WoodenSpear1Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelwooden_spear1(context.m_174023_(Modelwooden_spear1.LAYER_LOCATION)), 0.0F);
      this.m_115326_(new RenderLayer<WoodenSpear1Entity, Modelwooden_spear1<WoodenSpear1Entity>>(this) {
         final ResourceLocation LAYER_TEXTURE = new ResourceLocation("jujutsucraft:textures/entities/hand.png");

         public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, WoodenSpear1Entity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            Level world = entity.m_9236_();
            double x = entity.m_20185_();
            double y = entity.m_20186_();
            double z = entity.m_20189_();
            if (WoodenSpear1DisplayConditionProcedure.execute(entity)) {
               VertexConsumer vertexConsumer = bufferSource.m_6299_(RenderType.m_110458_(this.LAYER_TEXTURE));
               ((Modelwooden_spear1)this.m_117386_()).m_7695_(poseStack, vertexConsumer, light, LivingEntityRenderer.m_115338_(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
            }

         }
      });
   }

   public ResourceLocation getTextureLocation(WoodenSpear1Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/tex_wood.png");
   }
}
