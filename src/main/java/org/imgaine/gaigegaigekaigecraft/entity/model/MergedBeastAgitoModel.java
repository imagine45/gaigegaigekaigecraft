package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.MergedBeastAgitoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MergedBeastAgitoModel extends GeoModel<MergedBeastAgitoEntity> {
   public MergedBeastAgitoModel() {
   }

   public ResourceLocation getAnimationResource(MergedBeastAgitoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/merged_beast_agito.animation.json");
   }

   public ResourceLocation getModelResource(MergedBeastAgitoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/merged_beast_agito.geo.json");
   }

   public ResourceLocation getTextureResource(MergedBeastAgitoEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
