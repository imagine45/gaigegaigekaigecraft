package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.RozetsuShikigamiVesselEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RozetsuShikigamiVesselModel extends GeoModel<RozetsuShikigamiVesselEntity> {
   public RozetsuShikigamiVesselModel() {
   }

   public ResourceLocation getAnimationResource(RozetsuShikigamiVesselEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/rozetsu_shikigami_vessel.animation.json");
   }

   public ResourceLocation getModelResource(RozetsuShikigamiVesselEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/rozetsu_shikigami_vessel.geo.json");
   }

   public ResourceLocation getTextureResource(RozetsuShikigamiVesselEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
