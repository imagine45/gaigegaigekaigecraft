package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.YorozuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class YorozuModel extends GeoModel<YorozuEntity> {
   public YorozuModel() {
   }

   public ResourceLocation getAnimationResource(YorozuEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(YorozuEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(YorozuEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
