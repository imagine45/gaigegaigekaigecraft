package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.JogoEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class JogoModel extends GeoModel<JogoEntity> {
   public JogoModel() {
   }

   public ResourceLocation getAnimationResource(JogoEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/jogo.animation.json");
   }

   public ResourceLocation getModelResource(JogoEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/jogo.geo.json");
   }

   public ResourceLocation getTextureResource(JogoEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
