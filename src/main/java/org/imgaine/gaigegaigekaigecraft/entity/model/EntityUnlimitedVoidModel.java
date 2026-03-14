package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityUnlimitedVoidEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityUnlimitedVoidModel extends GeoModel<EntityUnlimitedVoidEntity> {
   public EntityUnlimitedVoidModel() {
   }

   public ResourceLocation getAnimationResource(EntityUnlimitedVoidEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/entity_unlimited_void.animation.json");
   }

   public ResourceLocation getModelResource(EntityUnlimitedVoidEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/entity_unlimited_void.geo.json");
   }

   public ResourceLocation getTextureResource(EntityUnlimitedVoidEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
