package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityDomainKugisakiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityDomainKugisakiModel extends GeoModel<EntityDomainKugisakiEntity> {
   public EntityDomainKugisakiModel() {
   }

   public ResourceLocation getAnimationResource(EntityDomainKugisakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/kugisaki_domain.animation.json");
   }

   public ResourceLocation getModelResource(EntityDomainKugisakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/kugisaki_domain.geo.json");
   }

   public ResourceLocation getTextureResource(EntityDomainKugisakiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
