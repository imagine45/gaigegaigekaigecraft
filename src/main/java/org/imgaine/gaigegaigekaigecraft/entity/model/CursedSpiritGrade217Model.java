package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade217Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade217Model extends GeoModel<CursedSpiritGrade217Entity> {
   public CursedSpiritGrade217Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit2_17.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit2_17.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade217Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
