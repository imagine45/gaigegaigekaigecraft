package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EightHandledSwordDivergentSilaDivineGeneralMahoragaModel extends GeoModel<EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity> {
   public EightHandledSwordDivergentSilaDivineGeneralMahoragaModel() {
   }

   public ResourceLocation getAnimationResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/mahoraga.animation.json");
   }

   public ResourceLocation getModelResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/mahoraga.geo.json");
   }

   public ResourceLocation getTextureResource(EightHandledSwordDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
