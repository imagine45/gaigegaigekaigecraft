package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpear2Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class IceSpear2Model extends GeoModel<IceSpear2Entity> {
   public IceSpear2Model() {
   }

   public ResourceLocation getAnimationResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/ice_spear2.animation.json");
   }

   public ResourceLocation getModelResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/ice_spear2.geo.json");
   }

   public ResourceLocation getTextureResource(IceSpear2Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
