package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade17Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade17Model extends GeoModel<CursedSpiritGrade17Entity> {
   public CursedSpiritGrade17Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit1_7.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit1_7.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade17Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
