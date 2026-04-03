package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.UroTakakoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class UroTakakoModel extends GeoModel<UroTakakoEntity> {
   public UroTakakoModel() {
   }

   public ResourceLocation getAnimationResource(UroTakakoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/uro_takako.animation.json");
   }

   public ResourceLocation getModelResource(UroTakakoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/uro_takako.geo.json");
   }

   public ResourceLocation getTextureResource(UroTakakoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
