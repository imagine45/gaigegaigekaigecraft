package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityJinichiDomain2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityJinichiDomain2Model extends GeoModel<EntityJinichiDomain2Entity> {
   public EntityJinichiDomain2Model() {
   }

   public ResourceLocation getAnimationResource(EntityJinichiDomain2Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/jinichi_domain2.animation.json");
   }

   public ResourceLocation getModelResource(EntityJinichiDomain2Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/jinichi_domain2.geo.json");
   }

   public ResourceLocation getTextureResource(EntityJinichiDomain2Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
