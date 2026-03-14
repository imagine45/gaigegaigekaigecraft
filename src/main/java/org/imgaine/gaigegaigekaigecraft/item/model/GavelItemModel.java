package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.GavelItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GavelItemModel extends GeoModel<GavelItem> {
   public GavelItemModel() {
   }

   public ResourceLocation getAnimationResource(GavelItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(GavelItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(GavelItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/gavel.png");
   }
}
