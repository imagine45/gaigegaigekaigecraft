package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.KaichiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KaichiModel extends GeoModel<KaichiEntity> {
   public KaichiModel() {
   }

   public ResourceLocation getAnimationResource(KaichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/kaichi.animation.json");
   }

   public ResourceLocation getModelResource(KaichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/kaichi.geo.json");
   }

   public ResourceLocation getTextureResource(KaichiEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
