package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade11Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade11Model extends GeoModel<CursedSpiritGrade11Entity> {
   public CursedSpiritGrade11Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/cursedspirit1_1.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/cursedspirit1_1.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade11Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
