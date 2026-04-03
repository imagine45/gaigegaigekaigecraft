package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.NueEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NueModel extends GeoModel<NueEntity> {
   public NueModel() {
   }

   public ResourceLocation getAnimationResource(NueEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/nue.animation.json");
   }

   public ResourceLocation getModelResource(NueEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/nue.geo.json");
   }

   public ResourceLocation getTextureResource(NueEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
