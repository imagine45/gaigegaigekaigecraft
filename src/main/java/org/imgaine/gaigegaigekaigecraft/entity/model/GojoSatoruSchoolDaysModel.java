package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.GojoSatoruSchoolDaysEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class GojoSatoruSchoolDaysModel extends GeoModel<GojoSatoruSchoolDaysEntity> {
   public GojoSatoruSchoolDaysModel() {
   }

   public ResourceLocation getAnimationResource(GojoSatoruSchoolDaysEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(GojoSatoruSchoolDaysEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(GojoSatoruSchoolDaysEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
