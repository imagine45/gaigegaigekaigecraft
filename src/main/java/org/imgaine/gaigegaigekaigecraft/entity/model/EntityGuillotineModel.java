package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityGuillotineEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityGuillotineModel extends GeoModel<EntityGuillotineEntity> {
   public EntityGuillotineModel() {
   }

   public ResourceLocation getAnimationResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/guillotine.animation.json");
   }

   public ResourceLocation getModelResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/guillotine.geo.json");
   }

   public ResourceLocation getTextureResource(EntityGuillotineEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
