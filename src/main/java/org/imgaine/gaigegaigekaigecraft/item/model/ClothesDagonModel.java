package org.imgaine.gaigegaigekaigecraft.item.model;

import org.imgaine.gaigegaigekaigecraft.item.ClothesDagonItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ClothesDagonModel extends GeoModel<ClothesDagonItem> {
   public ClothesDagonModel() {
   }

   public ResourceLocation getAnimationResource(ClothesDagonItem object) {
      return new ResourceLocation("jujutsucraft", "animations/clothes_dagon.animation.json");
   }

   public ResourceLocation getModelResource(ClothesDagonItem object) {
      return new ResourceLocation("jujutsucraft", "geo/clothes_dagon.geo.json");
   }

   public ResourceLocation getTextureResource(ClothesDagonItem object) {
      return new ResourceLocation("jujutsucraft", "textures/item/dagon2.png");
   }
}
