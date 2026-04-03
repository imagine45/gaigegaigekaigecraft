package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.OkkotsuYutaCullingGameEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class OkkotsuYutaCullingGameModel extends GeoModel<OkkotsuYutaCullingGameEntity> {
   public OkkotsuYutaCullingGameModel() {
   }

   public ResourceLocation getAnimationResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(OkkotsuYutaCullingGameEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
