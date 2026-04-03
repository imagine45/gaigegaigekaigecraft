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
      super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.0F);
      this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
   }

   protected void scale(Killer1Entity entity, PoseStack poseStack, float f) {
      poseStack.scale(1.5F, 1.5F, 1.5F);
   }

   public ResourceLocation getTextureLocation(Killer1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/killer1.png");
   }
}
