package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.PlayfulCloudItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PlayfulCloudItemModel extends GeoModel<PlayfulCloudItem> {
   public PlayfulCloudItemModel() {
   }

   public ResourceLocation getAnimationResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/playful_cloud.animation.json");
   }

   public ResourceLocation getModelResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/playful_cloud.geo.json");
   }

   public ResourceLocation getTextureResource(PlayfulCloudItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/playful_cloud.png");
   }
}
