package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.BlackRopeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class BlackRopeItemModel extends GeoModel<BlackRopeItem> {
   public BlackRopeItemModel() {
   }

   public ResourceLocation getAnimationResource(BlackRopeItem animatable) {
      return new ResourceLocation("jujutsucraft", "animations/black_rope.animation.json");
   }

   public ResourceLocation getModelResource(BlackRopeItem animatable) {
      return new ResourceLocation("jujutsucraft", "geo/black_rope.geo.json");
   }

   public ResourceLocation getTextureResource(BlackRopeItem animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/hair_black.png");
   }
}
