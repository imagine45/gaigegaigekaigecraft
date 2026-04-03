package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityCrackEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityCrackModel extends GeoModel<EntityCrackEntity> {
   public EntityCrackModel() {
   }

   public ResourceLocation getAnimationResource(EntityCrackEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/crack.animation.json");
   }

   public ResourceLocation getModelResource(EntityCrackEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/crack.geo.json");
   }

   public ResourceLocation getTextureResource(EntityCrackEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(EntityCrackEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("bone");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
