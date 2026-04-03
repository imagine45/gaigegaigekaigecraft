package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.TruckEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TruckModel extends GeoModel<TruckEntity> {
   public TruckModel() {
   }

   public ResourceLocation getAnimationResource(TruckEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/truck.animation.json");
   }

   public ResourceLocation getModelResource(TruckEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/truck.geo.json");
   }

   public ResourceLocation getTextureResource(TruckEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
