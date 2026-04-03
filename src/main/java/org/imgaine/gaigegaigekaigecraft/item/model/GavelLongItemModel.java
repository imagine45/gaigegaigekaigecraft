package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.GavelLongItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GavelLongItemModel extends GeoModel<GavelLongItem> {
   public GavelLongItemModel() {
   }

   public ResourceLocation getAnimationResource(GavelLongItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(GavelLongItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(GavelLongItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/gavel.png");
   }
}
