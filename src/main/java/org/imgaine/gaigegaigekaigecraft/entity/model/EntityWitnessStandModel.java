package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityWitnessStandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityWitnessStandModel extends GeoModel<EntityWitnessStandEntity> {
   public EntityWitnessStandModel() {
   }

   public ResourceLocation getAnimationResource(EntityWitnessStandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/witness_stand.animation.json");
   }

   public ResourceLocation getModelResource(EntityWitnessStandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/witness_stand.geo.json");
   }

   public ResourceLocation getTextureResource(EntityWitnessStandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
