package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityDomainInumakiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityDomainInumakiModel extends GeoModel<EntityDomainInumakiEntity> {
   public EntityDomainInumakiModel() {
   }

   public ResourceLocation getAnimationResource(EntityDomainInumakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/inumaki_domain.animation.json");
   }

   public ResourceLocation getModelResource(EntityDomainInumakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/inumaki_domain.geo.json");
   }

   public ResourceLocation getTextureResource(EntityDomainInumakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
