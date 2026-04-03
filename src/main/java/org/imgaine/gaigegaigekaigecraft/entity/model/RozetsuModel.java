package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuModel extends GeoModel<RozetsuEntity> {
   public RozetsuModel() {
   }

   public ResourceLocation getAnimationResource(RozetsuEntity entity) {
      return (Integer)entity.getEntityData().get(RozetsuEntity.DATA_form) == 1 ? new ResourceLocation("gaigegaigekaigecraft", "animations/rozetsu2.animation.json") : new ResourceLocation("gaigegaigekaigecraft", "animations/rozetsu.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuEntity entity) {
      return (Integer)entity.getEntityData().get(RozetsuEntity.DATA_form) == 1 ? new ResourceLocation("gaigegaigekaigecraft", "geo/rozetsu2.geo.json") : new ResourceLocation("gaigegaigekaigecraft", "geo/rozetsu.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
