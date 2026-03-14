package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.InsectArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class InsectArmorModel extends GeoModel<InsectArmorItem> {
   public InsectArmorModel() {
   }

   public ResourceLocation getAnimationResource(InsectArmorItem object) {
      return new ResourceLocation("jujutsucraft", "animations/insect_armor.animation.json");
   }

   public ResourceLocation getModelResource(InsectArmorItem object) {
      return new ResourceLocation("jujutsucraft", "geo/insect_armor.geo.json");
   }

   public ResourceLocation getTextureResource(InsectArmorItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/insect_armor.png");
   }
}
