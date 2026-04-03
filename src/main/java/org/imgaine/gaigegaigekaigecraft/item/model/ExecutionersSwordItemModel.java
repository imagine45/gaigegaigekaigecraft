package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.ExecutionersSwordItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ExecutionersSwordItemModel extends GeoModel<ExecutionersSwordItem> {
   public ExecutionersSwordItemModel() {
   }

   public ResourceLocation getAnimationResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/gavel.animation.json");
   }

   public ResourceLocation getModelResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/gavel.geo.json");
   }

   public ResourceLocation getTextureResource(ExecutionersSwordItem animatable) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/item/gavel.png");
   }
}
