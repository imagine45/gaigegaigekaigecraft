package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.MeteorEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class MeteorModel extends GeoModel<MeteorEntity> {
   public MeteorModel() {
   }

   public ResourceLocation getAnimationResource(MeteorEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/ball_maximum.animation.json");
   }

   public ResourceLocation getModelResource(MeteorEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/ball_maximum.geo.json");
   }

   public ResourceLocation getTextureResource(MeteorEntity entity) {
      return (Integer)entity.getEntityData().get(MeteorEntity.DATA_mode) == 0 ? new ResourceLocation("gaigegaigekaigecraft", "textures/entities/clear.png") : new ResourceLocation("gaigegaigekaigecraft", "textures/entities/ball_maximum.png");
   }

   public void setCustomAnimations(MeteorEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("BallMain");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
