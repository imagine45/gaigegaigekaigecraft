package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ThrowingItemEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ThrowingItemModel extends GeoModel<ThrowingItemEntity> {
   public ThrowingItemModel() {
   }

   public ResourceLocation getAnimationResource(ThrowingItemEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/throwing_item.animation.json");
   }

   public ResourceLocation getModelResource(ThrowingItemEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/throwing_item.geo.json");
   }

   public ResourceLocation getTextureResource(ThrowingItemEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ThrowingItemEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
