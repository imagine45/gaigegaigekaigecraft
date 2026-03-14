package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class EightHandledSwrodDivergentSilaDivineGeneralMahoragaModel extends GeoModel<EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity> {
   public EightHandledSwrodDivergentSilaDivineGeneralMahoragaModel() {
   }

   public ResourceLocation getAnimationResource(EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/mahoraga.animation.json");
   }

   public ResourceLocation getModelResource(EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/mahoraga.geo.json");
   }

   public ResourceLocation getTextureResource(EightHandledSwrodDivergentSilaDivineGeneralMahoragaEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }
}
