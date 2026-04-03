package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSweepEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityAttackSweepModel extends GeoModel<EntityAttackSweepEntity> {
   public EntityAttackSweepModel() {
   }

   public ResourceLocation getAnimationResource(EntityAttackSweepEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/entity_sweep.animation.json");
   }

   public ResourceLocation getModelResource(EntityAttackSweepEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/entity_sweep.geo.json");
   }

   public ResourceLocation getTextureResource(EntityAttackSweepEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityAttackSweepEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
