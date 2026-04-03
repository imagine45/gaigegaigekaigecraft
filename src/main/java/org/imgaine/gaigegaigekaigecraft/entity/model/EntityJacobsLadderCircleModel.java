package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityJacobsLadderCircleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityJacobsLadderCircleModel extends GeoModel<EntityJacobsLadderCircleEntity> {
   public EntityJacobsLadderCircleModel() {
   }

   public ResourceLocation getAnimationResource(EntityJacobsLadderCircleEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/jacobs_ladder.animation.json");
   }

   public ResourceLocation getModelResource(EntityJacobsLadderCircleEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/jacobs_ladder.geo.json");
   }

   public ResourceLocation getTextureResource(EntityJacobsLadderCircleEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
