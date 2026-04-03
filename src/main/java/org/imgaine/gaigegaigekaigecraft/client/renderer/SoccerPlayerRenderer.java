package org.imgaine.gaigegaigekaigecraft.client.renderer;

import org.imgaine.gaigegaigekaigecraft.entity.SoccerPlayerEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;

public class SoccerPlayerRenderer extends HumanoidMobRenderer<SoccerPlayerEntity, HumanoidModel<SoccerPlayerEntity>> {
   public SoccerPlayerRenderer(EntityRendererProvider.Context context) {
      super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
      this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getModelManager()));
   }

   public ResourceLocation getTextureLocation(SoccerPlayerEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft:textures/entities/soccer_player.png");
   }
}
