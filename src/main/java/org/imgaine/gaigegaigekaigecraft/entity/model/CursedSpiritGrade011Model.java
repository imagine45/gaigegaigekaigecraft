package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade011Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade011Model extends GeoModel<CursedSpiritGrade011Entity> {
   public CursedSpiritGrade011Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/gashadokuro.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/gashadokuro.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade011Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
