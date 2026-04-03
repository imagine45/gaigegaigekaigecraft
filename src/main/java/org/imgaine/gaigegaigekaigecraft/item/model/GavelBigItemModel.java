package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.GavelBigItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GavelBigItemModel extends GeoModel<GavelBigItem> {
   public GavelBigItemModel() {
   }

   public ResourceLocation getAnimationResource(GavelBigItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(GavelBigItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(GavelBigItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/gavel.png");
   }
}
