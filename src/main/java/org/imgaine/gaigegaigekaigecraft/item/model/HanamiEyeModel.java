package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.HanamiEyeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class HanamiEyeModel extends GeoModel<HanamiEyeItem> {
   public HanamiEyeModel() {
   }

   public ResourceLocation getAnimationResource(HanamiEyeItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/hanami_eye.animation.json");
   }

   public ResourceLocation getModelResource(HanamiEyeItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/hanami_eye.geo.json");
   }

   public ResourceLocation getTextureResource(HanamiEyeItem object) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/hanami_eye.png");
   }
}
