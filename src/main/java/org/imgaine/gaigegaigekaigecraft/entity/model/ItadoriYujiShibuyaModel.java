package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ItadoriYujiShibuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ItadoriYujiShibuyaModel extends GeoModel<ItadoriYujiShibuyaEntity> {
   public ItadoriYujiShibuyaModel() {
   }

   public ResourceLocation getAnimationResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(ItadoriYujiShibuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
