package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiPterosaurEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ShikigamiPterosaurModel extends GeoModel<ShikigamiPterosaurEntity> {
   public ShikigamiPterosaurModel() {
   }

   public ResourceLocation getAnimationResource(ShikigamiPterosaurEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/shikigami_dhruvrakdawala2.animation.json");
   }

   public ResourceLocation getModelResource(ShikigamiPterosaurEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/shikigami_dhruvrakdawala2.geo.json");
   }

   public ResourceLocation getTextureResource(ShikigamiPterosaurEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
