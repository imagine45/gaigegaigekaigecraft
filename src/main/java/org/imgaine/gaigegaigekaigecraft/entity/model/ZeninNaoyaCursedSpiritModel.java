package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninNaoyaCursedSpiritModel extends GeoModel<ZeninNaoyaCursedSpiritEntity> {
   public ZeninNaoyaCursedSpiritModel() {
   }

   public ResourceLocation getAnimationResource(ZeninNaoyaCursedSpiritEntity entity) {
      if ((Integer)entity.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form) == 3) {
         return new ResourceLocation("gaigegaigekaigecraft", "animations/human.animation.json");
      } else {
         return (Integer)entity.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form) == 2 ? new ResourceLocation("gaigegaigekaigecraft", "animations/naoya_cursed_spirit2.animation.json") : new ResourceLocation("gaigegaigekaigecraft", "animations/naoya_cursed_spirit1.animation.json");
      }
   }

   public ResourceLocation getModelResource(ZeninNaoyaCursedSpiritEntity entity) {
      if ((Integer)entity.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form) == 3) {
         return new ResourceLocation("gaigegaigekaigecraft", "geo/human.geo.json");
      } else {
         return (Integer)entity.getEntityData().get(ZeninNaoyaCursedSpiritEntity.DATA_form) == 2 ? new ResourceLocation("gaigegaigekaigecraft", "geo/naoya_cursed_spirit2.geo.json") : new ResourceLocation("gaigegaigekaigecraft", "geo/naoya_cursed_spirit1.geo.json");
      }
   }

   public ResourceLocation getTextureResource(ZeninNaoyaCursedSpiritEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
