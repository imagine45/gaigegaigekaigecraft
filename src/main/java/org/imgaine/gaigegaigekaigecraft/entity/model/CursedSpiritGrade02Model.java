package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade02Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade02Model extends GeoModel<CursedSpiritGrade02Entity> {
   public CursedSpiritGrade02Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/hanako.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/hanako.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade02Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
