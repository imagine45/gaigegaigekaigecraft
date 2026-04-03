package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.HanakoHandEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class HanakoHandModel extends GeoModel<HanakoHandEntity> {
   public HanakoHandModel() {
   }

   public ResourceLocation getAnimationResource(HanakoHandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/hanako_hand.animation.json");
   }

   public ResourceLocation getModelResource(HanakoHandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/hanako_hand.geo.json");
   }

   public ResourceLocation getTextureResource(HanakoHandEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(HanakoHandEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
