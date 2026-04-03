package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade015Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade015Model extends GeoModel<CursedSpiritGrade015Entity> {
   public CursedSpiritGrade015Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit0_15.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit0_15.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade015Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
