package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade013Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade013Model extends GeoModel<CursedSpiritGrade013Entity> {
   public CursedSpiritGrade013Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit0_13.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit0_13.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade013Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
