package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.ClothesUroItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesUroModel extends GeoModel<ClothesUroItem> {
   public ClothesUroModel() {
   }

   public ResourceLocation getAnimationResource(ClothesUroItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/clothes_uro.animation.json");
   }

   public ResourceLocation getModelResource(ClothesUroItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/clothes_uro.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesUroItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/clothes_uro.png");
   }
}
