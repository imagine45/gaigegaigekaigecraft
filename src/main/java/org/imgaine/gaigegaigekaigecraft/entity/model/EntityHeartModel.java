package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityHeartEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityHeartModel extends GeoModel<EntityHeartEntity> {
   public EntityHeartModel() {
   }

   public ResourceLocation getAnimationResource(EntityHeartEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/heart.animation.json");
   }

   public ResourceLocation getModelResource(EntityHeartEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/heart.geo.json");
   }

   public ResourceLocation getTextureResource(EntityHeartEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
