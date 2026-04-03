package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityJinichiDomain1Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityJinichiDomain1Model extends GeoModel<EntityJinichiDomain1Entity> {
   public EntityJinichiDomain1Model() {
   }

   public ResourceLocation getAnimationResource(EntityJinichiDomain1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/jinichi_domain1.animation.json");
   }

   public ResourceLocation getModelResource(EntityJinichiDomain1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/jinichi_domain1.geo.json");
   }

   public ResourceLocation getTextureResource(EntityJinichiDomain1Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
