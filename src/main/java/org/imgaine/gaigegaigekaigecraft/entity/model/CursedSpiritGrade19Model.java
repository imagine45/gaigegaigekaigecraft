package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade19Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade19Model extends GeoModel<CursedSpiritGrade19Entity> {
   public CursedSpiritGrade19Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/cursedspirit1_9.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/cursedspirit1_9.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade19Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
