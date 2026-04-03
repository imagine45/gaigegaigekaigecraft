package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.IceSpearEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class IceSpearModel extends GeoModel<IceSpearEntity> {
   public IceSpearModel() {
   }

   public ResourceLocation getAnimationResource(IceSpearEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/plojectile_crystal_ore.animation.json");
   }

   public ResourceLocation getModelResource(IceSpearEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/plojectile_crystal_ore.geo.json");
   }

   public ResourceLocation getTextureResource(IceSpearEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(IceSpearEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
