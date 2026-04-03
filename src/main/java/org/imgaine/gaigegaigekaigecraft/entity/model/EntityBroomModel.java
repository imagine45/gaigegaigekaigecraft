package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityBroomEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityBroomModel extends GeoModel<EntityBroomEntity> {
   public EntityBroomModel() {
   }

   public ResourceLocation getAnimationResource(EntityBroomEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/broom.animation.json");
   }

   public ResourceLocation getModelResource(EntityBroomEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/broom.geo.json");
   }

   public ResourceLocation getTextureResource(EntityBroomEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
