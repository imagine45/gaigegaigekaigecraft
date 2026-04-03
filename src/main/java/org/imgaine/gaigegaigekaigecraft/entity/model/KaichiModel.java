package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.KaichiEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class KaichiModel extends GeoModel<KaichiEntity> {
   public KaichiModel() {
   }

   public ResourceLocation getAnimationResource(KaichiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/kaichi.animation.json");
   }

   public ResourceLocation getModelResource(KaichiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/kaichi.geo.json");
   }

   public ResourceLocation getTextureResource(KaichiEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(KaichiEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
