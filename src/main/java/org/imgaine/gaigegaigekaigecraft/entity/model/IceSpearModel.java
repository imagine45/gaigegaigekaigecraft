package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceSpearModel extends GeoModel<IceSpearEntity> {
   public IceSpearModel() {
   }

   public ResourceLocation getAnimationResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/ice_spear1.animation.json");
   }

   public ResourceLocation getModelResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/ice_spear1.geo.json");
   }

   public ResourceLocation getTextureResource(IceSpearEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
