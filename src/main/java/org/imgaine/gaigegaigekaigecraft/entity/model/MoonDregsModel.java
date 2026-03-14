package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.MoonDregsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class MoonDregsModel extends GeoModel<MoonDregsEntity> {
   public MoonDregsModel() {
   }

   public ResourceLocation getAnimationResource(MoonDregsEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/moon_dregs.animation.json");
   }

   public ResourceLocation getModelResource(MoonDregsEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/moon_dregs.geo.json");
   }

   public ResourceLocation getTextureResource(MoonDregsEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
