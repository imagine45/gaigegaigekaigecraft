package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninNaoyaCursedSpiritEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ZeninNaoyaCursedSpiritModel extends GeoModel<ZeninNaoyaCursedSpiritEntity> {
   public ZeninNaoyaCursedSpiritModel() {
   }

   public ResourceLocation getAnimationResource(ZeninNaoyaCursedSpiritEntity entity) {
      if ((Integer)entity.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form) == 3) {
         return new ResourceLocation("jujutsucraft", "animations/human.animation.json");
      } else {
         return (Integer)entity.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form) == 2 ? new ResourceLocation("jujutsucraft", "animations/naoya_cursed_spirit2.animation.json") : new ResourceLocation("jujutsucraft", "animations/naoya_cursed_spirit1.animation.json");
      }
   }

   public ResourceLocation getModelResource(ZeninNaoyaCursedSpiritEntity entity) {
      if ((Integer)entity.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form) == 3) {
         return new ResourceLocation("jujutsucraft", "geo/human.geo.json");
      } else {
         return (Integer)entity.m_20088_().m_135370_(ZeninNaoyaCursedSpiritEntity.DATA_form) == 2 ? new ResourceLocation("jujutsucraft", "geo/naoya_cursed_spirit2.geo.json") : new ResourceLocation("jujutsucraft", "geo/naoya_cursed_spirit1.geo.json");
      }
   }

   public ResourceLocation getTextureResource(ZeninNaoyaCursedSpiritEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
