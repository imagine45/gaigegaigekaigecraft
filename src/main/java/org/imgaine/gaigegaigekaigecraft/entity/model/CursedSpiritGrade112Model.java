package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade112Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade112Model extends GeoModel<CursedSpiritGrade112Entity> {
   public CursedSpiritGrade112Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit1_12.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit1_12.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade112Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
