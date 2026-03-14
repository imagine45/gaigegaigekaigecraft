package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade010Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class CursedSpiritGrade010Model extends GeoModel<CursedSpiritGrade010Entity> {
   public CursedSpiritGrade010Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade010Entity entity) {
      return new ResourceLocation("jujutsucraft", "animations/yamata_no_orochi.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade010Entity entity) {
      return new ResourceLocation("jujutsucraft", "geo/yamata_no_orochi.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade010Entity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
