package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityEyeRantaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityEyeRantaModel extends GeoModel<EntityEyeRantaEntity> {
   public EntityEyeRantaModel() {
   }

   public ResourceLocation getAnimationResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/eye_ranta.animation.json");
   }

   public ResourceLocation getModelResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/eye_ranta.geo.json");
   }

   public ResourceLocation getTextureResource(EntityEyeRantaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
