package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityChimeraShadowGardenEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EntityChimeraShadowGardenModel extends GeoModel<EntityChimeraShadowGardenEntity> {
   public EntityChimeraShadowGardenModel() {
   }

   public ResourceLocation getAnimationResource(EntityChimeraShadowGardenEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/chimera_shadow_garden.animation.json");
   }

   public ResourceLocation getModelResource(EntityChimeraShadowGardenEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/chimera_shadow_garden.geo.json");
   }

   public ResourceLocation getTextureResource(EntityChimeraShadowGardenEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
