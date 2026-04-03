package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ZeninChojuroEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ZeninChojuroModel extends GeoModel<ZeninChojuroEntity> {
   public ZeninChojuroModel() {
   }

   public ResourceLocation getAnimationResource(ZeninChojuroEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/zenin_chojuro.animation.json");
   }

   public ResourceLocation getModelResource(ZeninChojuroEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/zenin_chojuro.geo.json");
   }

   public ResourceLocation getTextureResource(ZeninChojuroEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ZeninChojuroEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
