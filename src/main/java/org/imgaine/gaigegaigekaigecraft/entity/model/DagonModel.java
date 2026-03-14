package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.DagonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DagonModel extends GeoModel<DagonEntity> {
   public DagonModel() {
   }

   public ResourceLocation getAnimationResource(DagonEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(DagonEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "animations/dagon2.animation.json") : new ResourceLocation("jujutsucraft", "animations/dagon1.animation.json");
   }

   public ResourceLocation getModelResource(DagonEntity entity) {
      return (Integer)entity.m_20088_().m_135370_(DagonEntity.DATA_form) == 1 ? new ResourceLocation("jujutsucraft", "geo/dagon2.geo.json") : new ResourceLocation("jujutsucraft", "geo/dagon1.geo.json");
   }

   public ResourceLocation getTextureResource(DagonEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
