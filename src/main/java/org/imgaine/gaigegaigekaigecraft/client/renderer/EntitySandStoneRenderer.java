package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelrock_fragment;
import org.imgaine.gaigegaigekaigecraft.entity.EntitySandStoneEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntitySandStoneRenderer extends MobRenderer<EntitySandStoneEntity, Modelrock_fragment<EntitySandStoneEntity>> {
   public EntitySandStoneRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelrock_fragment(context.m_174023_(Modelrock_fragment.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntitySandStoneEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.5F, 1.5F, 1.5F);
   }

   public ResourceLocation getTextureLocation(EntitySandStoneEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/tex_sandstone.png");
   }
}
