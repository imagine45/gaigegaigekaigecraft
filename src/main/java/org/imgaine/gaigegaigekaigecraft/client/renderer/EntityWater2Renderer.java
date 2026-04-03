package org.imgaine.gaigegaigekaigecraft.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import org.imgaine.gaigegaigekaigecraft.client.model.Modelball;
import org.imgaine.gaigegaigekaigecraft.entity.EntityWater2Entity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class EntityWater2Renderer extends MobRenderer<EntityWater2Entity, Modelball<EntityWater2Entity>> {
   public EntityWater2Renderer(EntityRendererProvider.Context context) {
      super(context, new Modelball(context.bakeLayer(Modelball.LAYER_LOCATION)), 0.0F);
   }

   protected void scale(EntityWater2Entity entity, PoseStack poseStack, float f) {
      poseStack.scale(5.0F, 5.0F, 5.0F);
   }

   public ResourceLocation getTextureLocation(EntityWater2Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/tex_water.png");
   }
}
