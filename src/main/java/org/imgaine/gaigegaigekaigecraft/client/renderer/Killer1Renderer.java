package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.entity.Killer1Entity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class Killer1Renderer extends HumanoidMobRenderer<Killer1Entity, HumanoidModel<Killer1Entity>> {
   public Killer1Renderer(EntityRendererProvider.Context context) {
      super(context, new HumanoidModel(context.m_174023_(ModelLayers.f_171162_)), 0.0F);
      this.m_115326_(new HumanoidArmorLayer(this, new HumanoidModel(context.m_174023_(ModelLayers.f_171164_)), new HumanoidModel(context.m_174023_(ModelLayers.f_171165_)), context.m_266367_()));
   }

   protected void scale(Killer1Entity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.5F, 1.5F, 1.5F);
   }

   public ResourceLocation getTextureLocation(Killer1Entity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/killer1.png");
   }
}
