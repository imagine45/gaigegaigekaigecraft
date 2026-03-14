package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.RozetsuEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuModel extends GeoModel<RozetsuEntity> {
   public RozetsuModel() {
   }

   public ResourceLocation getAnimationResource(RozetsuEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(RozetsuEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "animations/rozetsu2.animation.json") : new ResourceLocation("jujutsucraft", "animations/rozetsu.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(RozetsuEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "geo/rozetsu2.geo.json") : new ResourceLocation("jujutsucraft", "geo/rozetsu.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
