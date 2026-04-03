package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ReggieStarEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ReggieStarModel extends GeoModel<ReggieStarEntity> {
   public ReggieStarModel() {
   }

   public ResourceLocation getAnimationResource(ReggieStarEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ReggieStarEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ReggieStarEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
