package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelcockroach_warm;
import org.imgaine.gaigegaigekaigecraft.entity.CockroachLarvaEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CockroachLarvaRenderer extends MobRenderer<CockroachLarvaEntity, Modelcockroach_warm<CockroachLarvaEntity>> {
   public CockroachLarvaRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelcockroach_warm(context.m_174023_(Modelcockroach_warm.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(CockroachLarvaEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(0.7F, 0.7F, 0.7F);
   }

   public ResourceLocation getTextureLocation(CockroachLarvaEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/cockroach_eggs.png");
   }
}
