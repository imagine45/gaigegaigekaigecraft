package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.FushiguroMegumiShibuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FushiguroMegumiShibuyaModel extends GeoModel<FushiguroMegumiShibuyaEntity> {
   public FushiguroMegumiShibuyaModel() {
   }

   public ResourceLocation getAnimationResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(FushiguroMegumiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
