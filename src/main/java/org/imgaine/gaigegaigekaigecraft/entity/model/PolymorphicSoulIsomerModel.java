package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.PolymorphicSoulIsomerEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PolymorphicSoulIsomerModel extends GeoModel<PolymorphicSoulIsomerEntity> {
   public PolymorphicSoulIsomerModel() {
   }

   public ResourceLocation getAnimationResource(PolymorphicSoulIsomerEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(PolymorphicSoulIsomerEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(PolymorphicSoulIsomerEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
