package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ResonanceEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ResonanceModel extends GeoModel<ResonanceEntity> {
   public ResonanceModel() {
   }

   public ResourceLocation getAnimationResource(ResonanceEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/resonance.animation.json");
   }

   public ResourceLocation getModelResource(ResonanceEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/resonance.geo.json");
   }

   public ResourceLocation getTextureResource(ResonanceEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ResonanceEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("body2");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
