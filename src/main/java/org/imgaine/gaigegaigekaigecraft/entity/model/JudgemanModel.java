package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.JudgemanEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JudgemanModel extends GeoModel<JudgemanEntity> {
   public JudgemanModel() {
   }

   public ResourceLocation getAnimationResource(JudgemanEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/judgeman.animation.json");
   }

   public ResourceLocation getModelResource(JudgemanEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/judgeman.geo.json");
   }

   public ResourceLocation getTextureResource(JudgemanEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
