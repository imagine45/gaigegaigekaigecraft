package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade014Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade014Model extends GeoModel<CursedSpiritGrade014Entity> {
   public CursedSpiritGrade014Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit0_14.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit0_14.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade014Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
