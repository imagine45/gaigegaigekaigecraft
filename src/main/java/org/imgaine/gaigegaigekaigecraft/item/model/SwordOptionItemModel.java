package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.SwordOptionItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class SwordOptionItemModel extends GeoModel<SwordOptionItem> {
   public SwordOptionItemModel() {
   }

   public ResourceLocation getAnimationResource(SwordOptionItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/sword_option.animation.json");
   }

   public ResourceLocation getModelResource(SwordOptionItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/sword_option.geo.json");
   }

   public ResourceLocation getTextureResource(SwordOptionItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/playful_cloud.png");
   }
}
