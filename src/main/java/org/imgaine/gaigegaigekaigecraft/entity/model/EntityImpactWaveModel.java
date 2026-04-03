package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.EntityImpactWaveEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class EntityImpactWaveModel extends GeoModel<EntityImpactWaveEntity> {
   public EntityImpactWaveModel() {
   }

   public ResourceLocation getAnimationResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/rubble.animation.json");
   }

   public ResourceLocation getModelResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/rubble.geo.json");
   }

   public ResourceLocation getTextureResource(EntityImpactWaveEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/clear.png");
   }

   public void setCustomAnimations(EntityImpactWaveEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
