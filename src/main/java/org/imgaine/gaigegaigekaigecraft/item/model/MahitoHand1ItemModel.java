package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.MahitoHand1Item;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MahitoHand1ItemModel extends GeoModel<MahitoHand1Item> {
   public MahitoHand1ItemModel() {
   }

   public ResourceLocation getAnimationResource(MahitoHand1Item animatable) {
      return new ResourceLocation("jujutsucraft", "animations/mahito_hand1.animation.json");
   }

   public ResourceLocation getModelResource(MahitoHand1Item animatable) {
      return new ResourceLocation("jujutsucraft", "geo/mahito_hand1.geo.json");
   }

   public ResourceLocation getTextureResource(MahitoHand1Item animatable) {
      return new ResourceLocation("jujutsucraft", "textures/item/mahito_hand1.png");
   }
}
