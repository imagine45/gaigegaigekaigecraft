package org.imgaine.gaigegaigekaigecraft.entity.model;

import org.imgaine.gaigegaigekaigecraft.entity.ShikigamiRikaDhruvEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ShikigamiRikaDhruvModel extends GeoModel<ShikigamiRikaDhruvEntity> {
   public ShikigamiRikaDhruvModel() {
   }

   public ResourceLocation getAnimationResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "animations/shikigami_dhruvrakdawala3.animation.json");
   }

   public ResourceLocation getModelResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "geo/shikigami_dhruvrakdawala3.geo.json");
   }

   public ResourceLocation getTextureResource(ShikigamiRikaDhruvEntity entity) {
      return new ResourceLocation("gaigegaigekaigecraft", "textures/entities/" + entity.getTexture() + ".png");
   }

   public void setCustomAnimations(ShikigamiRikaDhruvEntity animatable, long instanceId, AnimationState animationState) {
      CoreGeoBone head = this.getAnimationProcessor().getBone("head");
      if (head != null) {
         EntityModelData entityData = (EntityModelData)animationState.getData(DataTickets.ENTITY_MODEL_DATA);
         head.setRotX(entityData.headPitch() * 0.017453292F);
         head.setRotY(entityData.netHeadYaw() * 0.017453292F);
      }

   }
}
