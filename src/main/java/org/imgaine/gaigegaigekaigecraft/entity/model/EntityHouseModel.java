package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityHouseEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityHouseModel extends GeoModel<EntityHouseEntity> {
   public EntityHouseModel() {
   }

   public ResourceLocation getAnimationResource(EntityHouseEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/reggie_house.animation.json");
   }

   public ResourceLocation getModelResource(EntityHouseEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/reggie_house.geo.json");
   }

   public ResourceLocation getTextureResource(EntityHouseEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityHouseEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
