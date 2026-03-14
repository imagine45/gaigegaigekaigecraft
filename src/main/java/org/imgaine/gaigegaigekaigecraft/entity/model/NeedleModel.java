package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.NeedleEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class NeedleModel extends GeoModel<NeedleEntity> {
   public NeedleModel() {
   }

   public ResourceLocation getAnimationResource(NeedleEntity entity) {
      return new ResourceLocation("jujutsucraft", "animations/needle.animation.json");
   }

   public ResourceLocation getModelResource(NeedleEntity entity) {
      return new ResourceLocation("jujutsucraft", "geo/needle.geo.json");
   }

   public ResourceLocation getTextureResource(NeedleEntity entity) {
      return new ResourceLocation("jujutsucraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(NeedleEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
