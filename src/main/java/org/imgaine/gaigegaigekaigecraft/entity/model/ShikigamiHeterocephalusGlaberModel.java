package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiHeterocephalusGlaberEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShikigamiHeterocephalusGlaberModel extends GeoModel<ShikigamiHeterocephalusGlaberEntity> {
   public ShikigamiHeterocephalusGlaberModel() {
   }

   public ResourceLocation getAnimationResource(ShikigamiHeterocephalusGlaberEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/shikigami_dhruvrakdawala1.animation.json");
   }

   public ResourceLocation getModelResource(ShikigamiHeterocephalusGlaberEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/shikigami_dhruvrakdawala1.geo.json");
   }

   public ResourceLocation getTextureResource(ShikigamiHeterocephalusGlaberEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
