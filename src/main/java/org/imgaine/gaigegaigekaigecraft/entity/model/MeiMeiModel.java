package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.MeiMeiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MeiMeiModel extends GeoModel<MeiMeiEntity> {
   public MeiMeiModel() {
   }

   public ResourceLocation getAnimationResource(MeiMeiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(MeiMeiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(MeiMeiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
