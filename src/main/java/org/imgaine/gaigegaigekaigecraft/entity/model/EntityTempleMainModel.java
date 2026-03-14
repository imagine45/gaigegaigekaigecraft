package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityTempleMainEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityTempleMainModel extends GeoModel<EntityTempleMainEntity> {
   public EntityTempleMainModel() {
   }

   public ResourceLocation getAnimationResource(EntityTempleMainEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/entity_temple_main.animation.json");
   }

   public ResourceLocation getModelResource(EntityTempleMainEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/entity_temple_main.geo.json");
   }

   public ResourceLocation getTextureResource(EntityTempleMainEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
