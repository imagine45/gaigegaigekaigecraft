package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.GetoSuguruCurseUserEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GetoSuguruCurseUserModel extends GeoModel<GetoSuguruCurseUserEntity> {
   public GetoSuguruCurseUserModel() {
   }

   public ResourceLocation getAnimationResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(GetoSuguruCurseUserEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
