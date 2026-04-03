package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.KusakabeAtsuyaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class KusakabeAtsuyaModel extends GeoModel<KusakabeAtsuyaEntity> {
   public KusakabeAtsuyaModel() {
   }

   public ResourceLocation getAnimationResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
   }

   public ResourceLocation getModelResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
   }

   public ResourceLocation getTextureResource(KusakabeAtsuyaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
