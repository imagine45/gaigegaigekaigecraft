package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroMegumiModel extends GeoModel<FushiguroMegumiEntity> {
   public FushiguroMegumiModel() {
   }

   public ResourceLocation getAnimationResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroMegumiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
