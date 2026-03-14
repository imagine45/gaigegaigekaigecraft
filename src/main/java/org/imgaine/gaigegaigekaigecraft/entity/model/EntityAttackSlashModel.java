package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityAttackSlashEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityAttackSlashModel extends GeoModel<EntityAttackSlashEntity> {
   public EntityAttackSlashModel() {
   }

   public ResourceLocation getAnimationResource(EntityAttackSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/entity_slash.animation.json");
   }

   public ResourceLocation getModelResource(EntityAttackSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/entity_slash.geo.json");
   }

   public ResourceLocation getTextureResource(EntityAttackSlashEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityAttackSlashEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
