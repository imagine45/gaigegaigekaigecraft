package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityTreeHanamiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityTreeHanamiModel extends GeoModel<EntityTreeHanamiEntity> {
   public EntityTreeHanamiModel() {
   }

   public ResourceLocation getAnimationResource(EntityTreeHanamiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/tree_hanami.animation.json");
   }

   public ResourceLocation getModelResource(EntityTreeHanamiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/tree_hanami.geo.json");
   }

   public ResourceLocation getTextureResource(EntityTreeHanamiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
