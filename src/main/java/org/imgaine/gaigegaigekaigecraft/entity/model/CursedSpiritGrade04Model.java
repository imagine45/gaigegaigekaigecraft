package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.CursedSpiritGrade04Entity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class CursedSpiritGrade04Model extends GeoModel<CursedSpiritGrade04Entity> {
   public CursedSpiritGrade04Model() {
   }

   public ResourceLocation getAnimationResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/kurourushi.animation.json");
   }

   public ResourceLocation getModelResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/kurourushi.geo.json");
   }

   public ResourceLocation getTextureResource(CursedSpiritGrade04Entity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(CursedSpiritGrade04Entity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
