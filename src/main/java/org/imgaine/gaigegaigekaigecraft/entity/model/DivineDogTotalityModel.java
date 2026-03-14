package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.DivineDogTotalityEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DivineDogTotalityModel extends GeoModel<DivineDogTotalityEntity> {
   public DivineDogTotalityModel() {
   }

   public ResourceLocation getAnimationResource(DivineDogTotalityEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/divinedogtotality.animation.json");
   }

   public ResourceLocation getModelResource(DivineDogTotalityEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/divinedogtotality.geo.json");
   }

   public ResourceLocation getTextureResource(DivineDogTotalityEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
