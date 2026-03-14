package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityCockroachEggsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityCockroachEggsModel extends GeoModel<EntityCockroachEggsEntity> {
   public EntityCockroachEggsModel() {
   }

   public ResourceLocation getAnimationResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cockroach_eggs.animation.json");
   }

   public ResourceLocation getModelResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cockroach_eggs.geo.json");
   }

   public ResourceLocation getTextureResource(EntityCockroachEggsEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
