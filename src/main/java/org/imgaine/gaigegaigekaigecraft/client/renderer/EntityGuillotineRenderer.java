package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelguillotine;
import org.imgaine.gaigegaigekaigecraft.entity.EntityGuillotineEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityGuillotineRenderer extends MobRenderer<EntityGuillotineEntity, Modelguillotine<EntityGuillotineEntity>> {
   public EntityGuillotineRenderer(EntityRendererProvider.Context context) {
      super(context, new Modelguillotine(context.m_174023_(Modelguillotine.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntityGuillotineEntity entity, PoseStack poseStack, float f) {
      poseStack.m_85841_(1.25F, 1.25F, 1.25F);
   }

   public ResourceLocation getTextureLocation(EntityGuillotineEntity entity) {
      return new ResourceLocation("jujutsucraft:textures/entities/guillotine.png");
   }
}
