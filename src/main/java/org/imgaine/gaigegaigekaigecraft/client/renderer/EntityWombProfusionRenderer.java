package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.ModelWombProfusion;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWombProfusionEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityWombProfusionRenderer extends MobRenderer<EntityWombProfusionEntity, ModelWombProfusion<EntityWombProfusionEntity>> {
   public EntityWombProfusionRenderer(EntityRendererProvider.Context context) {
      super(context, new ModelWombProfusion(context.m_174023_(ModelWombProfusion.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntityWombProfusionEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(2.25F, 2.25F, 2.25F);
   }

   public ResourceLocation getTextureLocation(EntityWombProfusionEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/wombprofusion.png");
   }
}
