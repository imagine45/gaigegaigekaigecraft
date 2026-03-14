package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.ClothesKusakabeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesKusakabeModel extends GeoModel<ClothesKusakabeItem> {
   public ClothesKusakabeModel() {
   }

   public ResourceLocation getAnimationResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "animations/clothes_kusakabe.animation.json");
   }

   public ResourceLocation getModelResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "geo/clothes_kusakabe.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesKusakabeItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/clothes_kusakabe.png");
   }
}
