package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityRozetsuDomainEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityRozetsuDomainModel extends GeoModel<EntityRozetsuDomainEntity> {
   public EntityRozetsuDomainModel() {
   }

   public ResourceLocation getAnimationResource(EntityRozetsuDomainEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/rouzetsu_domain.animation.json");
   }

   public ResourceLocation getModelResource(EntityRozetsuDomainEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/rouzetsu_domain.geo.json");
   }

   public ResourceLocation getTextureResource(EntityRozetsuDomainEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityRozetsuDomainEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone4");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
