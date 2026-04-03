package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.TodoAoiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TodoAoiModel extends GeoModel<TodoAoiEntity> {
   public TodoAoiModel() {
   }

   public ResourceLocation getAnimationResource(TodoAoiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/todo_aoi.animation.json");
   }

   public ResourceLocation getModelResource(TodoAoiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/todo_aoi.geo.json");
   }

   public ResourceLocation getTextureResource(TodoAoiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
