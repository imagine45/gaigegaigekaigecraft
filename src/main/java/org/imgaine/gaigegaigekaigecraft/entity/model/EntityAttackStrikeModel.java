package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackStrikeEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityAttackStrikeModel extends GeoModel<EntityAttackStrikeEntity> {
   public EntityAttackStrikeModel() {
   }

   public ResourceLocation getAnimationResource(EntityAttackStrikeEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/entity_strike.animation.json");
   }

   public ResourceLocation getModelResource(EntityAttackStrikeEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/entity_strike.geo.json");
   }

   public ResourceLocation getTextureResource(EntityAttackStrikeEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityAttackStrikeEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
