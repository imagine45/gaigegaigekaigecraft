package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.TakadaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class TakadaModel extends GeoModel<TakadaEntity> {
   public TakadaModel() {
   }

   public ResourceLocation getAnimationResource(TakadaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/takada.animation.json");
   }

   public ResourceLocation getModelResource(TakadaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/takada.geo.json");
   }

   public ResourceLocation getTextureResource(TakadaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
