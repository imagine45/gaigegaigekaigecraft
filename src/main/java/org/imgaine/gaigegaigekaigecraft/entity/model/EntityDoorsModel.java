package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityDoorsEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityDoorsModel extends GeoModel<EntityDoorsEntity> {
   public EntityDoorsModel() {
   }

   public ResourceLocation getAnimationResource(EntityDoorsEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/doors.animation.json");
   }

   public ResourceLocation getModelResource(EntityDoorsEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/doors.geo.json");
   }

   public ResourceLocation getTextureResource(EntityDoorsEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityDoorsEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
